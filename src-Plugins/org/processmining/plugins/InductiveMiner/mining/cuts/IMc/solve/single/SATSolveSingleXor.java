package org.processmining.plugins.InductiveMiner.mining.cuts.IMc.solve.single;

import gnu.trove.map.hash.THashMap;

import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

import org.deckfour.xes.classification.XEventClass;
import org.processmining.plugins.InductiveMiner.Pair;
import org.processmining.plugins.InductiveMiner.graphs.Graph;
import org.processmining.plugins.InductiveMiner.mining.cuts.Cut.Operator;
import org.processmining.plugins.InductiveMiner.mining.cuts.IMc.CutFinderIMinInfo;
import org.processmining.plugins.InductiveMiner.mining.cuts.IMc.SATResult;
import org.processmining.plugins.InductiveMiner.mining.cuts.IMc.probabilities.Probabilities;
import org.sat4j.core.Vec;
import org.sat4j.core.VecInt;
import org.sat4j.pb.ObjectiveFunction;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVec;
import org.sat4j.specs.TimeoutException;

public class SATSolveSingleXor extends SATSolveSingle {

	public SATSolveSingleXor(CutFinderIMinInfo info) {
		super(info);
	}

	public SATResult solveSingle(int cutSize, double bestAverageTillNow) {
		//debug(" solve xor with cut size " + cutSize + " and probability " + bestAverageTillNow);

		Graph<XEventClass> graph = info.getGraph();
		Probabilities probabilities = info.getProbabilities();

		//compute number of edges in the cut
		int numberOfEdgesInCut = (countNodes - cutSize) * cutSize;

		//edges
		Map<Pair<XEventClass, XEventClass>, Edge> edge2var = new THashMap<Pair<XEventClass, XEventClass>, Edge>();
		for (int i = 0; i < countNodes; i++) {
			for (int j = i + 1; j < countNodes; j++) {
				XEventClass aI = nodes[i];
				XEventClass aJ = nodes[j];

				edge2var.put(new Pair<XEventClass, XEventClass>(aI, aJ), newEdgeVar(aI, aJ));
			}
		}

		try {
			//constraint: exactly cutSize nodes are cut
			{
				int[] clause = new int[countNodes];
				int i = 0;
				for (XEventClass a : graph.getVertices()) {
					clause[i] = node2var.get(a).getVarInt();
					i++;
				}
				solver.addAtLeast(new VecInt(clause), cutSize);
				solver.addAtMost(new VecInt(clause), cutSize);
			}

			//constraint: edge is cut iff between two nodes on different sides of the cut
			for (int i = 0; i < countNodes; i++) {
				for (int j = i + 1; j < countNodes; j++) {
					XEventClass aI = nodes[i];
					XEventClass aJ = nodes[j];

					int A = node2var.get(aI).getVarInt();
					int B = node2var.get(aJ).getVarInt();
					int C = edge2var.get(new Pair<XEventClass, XEventClass>(aI, aJ)).getVarInt();

					int clause1[] = { A, B, -C };
					int clause2[] = { A, -B, C };
					int clause3[] = { -A, B, C };
					int clause4[] = { -A, -B, -C };

					solver.addClause(new VecInt(clause1));
					solver.addClause(new VecInt(clause2));
					solver.addClause(new VecInt(clause3));
					solver.addClause(new VecInt(clause4));
				}
			}

			//objective function: least cost for edges
			VecInt clause = new VecInt();
			IVec<BigInteger> coefficients = new Vec<BigInteger>();
			for (int i = 0; i < countNodes; i++) {
				for (int j = i + 1; j < countNodes; j++) {
					XEventClass aI = nodes[i];
					XEventClass aJ = nodes[j];
					clause.push(edge2var.get(new Pair<XEventClass, XEventClass>(aI, aJ)).getVarInt());
					coefficients.push(probabilities.getProbabilityXorB(info, aI, aJ).negate());
				}
			}
			ObjectiveFunction obj = new ObjectiveFunction(clause, coefficients);
			solver.setObjectiveFunction(obj);

			//constraint: better than best previous run
			BigInteger minObjectiveFunction = BigInteger
					.valueOf((long) (probabilities.doubleToIntFactor * bestAverageTillNow * numberOfEdgesInCut));
			solver.addAtMost(clause, coefficients, minObjectiveFunction.negate());

			//compute result
			Pair<Set<XEventClass>, Set<XEventClass>> result = compute();
			if (result != null) {

				//compute cost of cut
				//String x = "";
				double sumProbability = 0;
				for (int i = 0; i < countNodes; i++) {
					for (int j = i + 1; j < countNodes; j++) {
						XEventClass aI = nodes[i];
						XEventClass aJ = nodes[j];
						Edge e = edge2var.get(new Pair<XEventClass, XEventClass>(aI, aJ));
						if (e.isResult()) {
							double p = probabilities.getProbabilityXor(info, aI, aJ);
							//x += e.toString() + " (" + p + "), ";
							sumProbability += p;
						}
					}
				}

				double averageProbability = sumProbability / numberOfEdgesInCut;
				SATResult result2 = new SATResult(result.getLeft(), result.getRight(), averageProbability, Operator.xor);

				debug("  xor size " + cutSize + ": " + result2.toString());
				//debug("   edges " + x);
				//debug("   sum probability " + sumProbability);

				return result2;
			} else {
				debug("  no solution xor size " + cutSize);
			}
		} catch (ContradictionException e) {
			debug("  inconsistent problem xor size " + cutSize);
		} catch (TimeoutException e1) {
			debug("  time out xor size " + cutSize);
		}
		return null;
	}

}

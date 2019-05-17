package searchAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

import problem.HelpR2D2;
import problem.State;

public class ASI implements GenericSearchAlgorithm {
	private ArrayList<Node> queue;
	private HelpR2D2 problem;
	private Node node;
	private int expandedNodes;
	private int cost;
	private ArrayList<String> actionsFromRoot;
	private boolean visualize;

	public ASI(HelpR2D2 problem, boolean visualize) {
		queue = new ArrayList<Node>();
		this.problem = problem;
		this.node = new Node(problem.getInitialState(), null, "ASI");
		queue.add(node);
		this.visualize = visualize;
	}

	public ArrayList<Node> getqueue() {
		return queue;
	}

	public void setqueue(ArrayList<Node> queue) {
		this.queue = queue;
	}

	public HelpR2D2 getproblem() {
		return problem;
	}

	public void setproblem(HelpR2D2 problem) {
		this.problem = problem;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	@Override
	public ArrayList<Node> search() {
		ArrayList<Node> result = new ArrayList<Node>();
		while (!(queue.isEmpty())) {
			ArrayList<State> states = new ArrayList<State>();
			ArrayList<Node> nodes = new ArrayList<Node>();
			Node node = queue.remove(0);
			expandedNodes++;
			//System.out.println(node);
			if (problem.testGoal(node.getState())) {
				cost = node.getCostFromRoot();
				actionsFromRoot = node.getActionsFromRoot();
				result = node.goalTest(visualize);
				break;
			}
			states = problem.expand(node.getState());
			for (int i = 0; i < states.size(); i++) {
				Node node1 = new Node(states.get(i), node, "ASI");
				queue.add(node1);
				nodes.add(node1);
			}
			Collections.sort(queue);
			node.setChildren(nodes);
		}
		return result;
	}

	public int getExpandedNodes() {
		return expandedNodes;
	}

	public static void main(String[] args) {
		HelpR2D2 p = new HelpR2D2();
		ASI asi = new ASI(p, true);
		asi.search();

	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public ArrayList<String> getActionsFromRoot() {
		return actionsFromRoot;
	}

}
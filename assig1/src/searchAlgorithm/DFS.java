package searchAlgorithm;

import java.util.ArrayList;

import problem.HelpR2D2;
import problem.State;

public class DFS implements GenericSearchAlgorithm {
	private ArrayList<Node> queue;
	private HelpR2D2 problem;
	private Node node;
	private int expandedNodes;
	private int cost;
	private ArrayList<String> actionsFromRoot;
	private boolean visualize;

	public DFS(HelpR2D2 problem, boolean visualize) {
		queue = new ArrayList<Node>();
		this.problem = problem;
		this.node = new Node(problem.getInitialState(), null, "DFS");
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
				result = node.goalTest(visualize);
				actionsFromRoot = node.getActionsFromRoot();
				break;
			}
			states = problem.expand(node.getState());
			while (!states.isEmpty()) {
				Node node1 = new Node(states.remove(states.size() - 1), node,
						"DFS");
				queue.add(0, node1);
				nodes.add(node1);

			}

			node.setChildren(nodes);
		}
		return result;

	}

	public static void main(String[] args) {
		HelpR2D2 p = new HelpR2D2();
		DFS dfs = new DFS(p, true);
		dfs.search();
	}

	@Override
	public int getExpandedNodes() {
		return expandedNodes;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public ArrayList<String> getActionsFromRoot() {
		// TODO Auto-generated method stub
		return actionsFromRoot;

	}

}

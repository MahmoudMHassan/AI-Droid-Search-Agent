package searchAlgorithm;

import java.util.ArrayList;

import problem.HelpR2D2;
import problem.State;

public class BFS implements GenericSearchAlgorithm {
	private ArrayList<Node> Queue;
	private HelpR2D2 problem;
	private Node node;
	private int expandedNodes;
	private int cost;
	private ArrayList<String> actionsFromRoot;
	private boolean visualize ;

	public BFS(HelpR2D2 problem , boolean visualize) {
		Queue = new ArrayList<Node>();
		this.problem = problem;
		this.node = new Node(problem.getInitialState(), null, "BFS");
		Queue.add(node);
		this.visualize = visualize;
	}

	public int getExpandedNodes() {
		return expandedNodes;
	}

	public ArrayList<Node> getQueue() {
		return Queue;
	}

	public void setQueue(ArrayList<Node> queue) {
		Queue = queue;
	}

	public HelpR2D2 getProblem() {
		return problem;
	}

	public void setProblem(HelpR2D2 problem) {
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
		ArrayList<State> States = new ArrayList<State>();
		while (!(Queue.isEmpty())) {

			System.out.println();
			ArrayList<Node> nodes = new ArrayList<Node>();
			Node node = Queue.remove(0);
			expandedNodes++;

			//System.out.println(node);

			if (problem.testGoal(node.getState())) {
				cost = node.getCostFromRoot();
				result = node.goalTest(visualize);
				actionsFromRoot = node.getActionsFromRoot();
				break;
			}
			States = problem.expand(node.getState());

			while (!States.isEmpty()) {
				Node node1 = new Node(States.remove(0), node, "BFS");
				Queue.add(node1);
				nodes.add(node1);
			}
			node.setChildren(nodes);
		}
		return result;
	}

	public static void main(String[] args) {
		HelpR2D2 p = new HelpR2D2();
		BFS bfs = new BFS(p,true);
		bfs.search();
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

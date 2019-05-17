package searchAlgorithm;

import java.util.ArrayList;

import problem.R2D2State;
import problem.State;

public class Node implements Comparable<Node> {
	private State state;
	private Node parent;
	private ArrayList<Node> children;
	private int cost;
	private int depth;
	private String strategy;
	public static int admissible = 1;
	//public static int expantion;
	private int costFromRoot;
	private ArrayList<String> actionsFromRoot;

	
	public Node(State state, Node parent, String strategy) {
		this.state = state;
		this.parent = parent;
		children = new ArrayList<Node>();
		actionsFromRoot = new ArrayList<>();

		if (parent != null)
			depth = parent.getDepth() + 1;

		this.strategy = strategy;
		
		
		if (parent != null){
			costFromRoot = uniformCost();
			setCost();
		}
			
		else
			cost = 0;
		
		//expantion++;
	    

	}


	public String toString() {
		String res = "level :" + depth + "\n";
		res += state + "\n";
		//res += "number of expantion : " + expantion;
		return res;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Node> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}

	public int getCost() {
		return cost;
	}

	public void setCost() {
		if (strategy.equals("GSI")) {
			R2D2State st = (R2D2State) (state);
			if (admissible == 0)
				cost = st.getGrid().hteleportal();
			else
				cost = st.getGrid().inactivePadsCost();
		} else {
			if (strategy.equals("ASI")) {
				cost = astarCost();
			} else {
				cost = costFromRoot;
			}

		}

	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	// lessa wa7ed hy3adl al code 34an al cost
	public int uniformCost() {
		R2D2State st = (R2D2State) (state);
		int stateActionCost = 0;
		if (st.getAction().equals("Move"))
			stateActionCost = 10;
		else
			stateActionCost = 20;
		return parent.getCostFromRoot() + stateActionCost;
	}

	public int astarCost() {
		R2D2State st = (R2D2State) (state);
		int cost1;
		if (admissible == 0)
			cost1 = st.getGrid().hteleportal();
		else
			cost1 = st.getGrid().inactivePadsCost();
		return costFromRoot + cost1;
	}
	
	public ArrayList<Node> goalTest(boolean visualize) {
		ArrayList<Node> result = new ArrayList<Node>();
		result.add(this);
		Node curr = this;


		while (curr != null) {
			if(visualize){
			System.out.println();
			System.out.println(curr);
			}
			R2D2State st = (R2D2State) curr.getState();
			actionsFromRoot.add(0,st.getAction()+" "+st.getDirection());
			result.add(curr.getParent());
			curr = curr.getParent();
		}
		
		return result;
	}
	
	public int getCostFromRoot() {
		return costFromRoot;
	}
	public void setCostFromRoot(int costFromRoot) {
		this.costFromRoot = costFromRoot;
	}
	
	
	@Override
	public int compareTo(Node o) {

		if (this.cost > o.cost)
			return 1;
		else {
			if (this.cost == o.getCost())
				return 0;
			else
				return -1;
		}

	}


	public ArrayList<String> getActionsFromRoot() {
		return actionsFromRoot;
	}


	public void setActionsFromRoot(ArrayList<String> actionsFromRoot) {
		this.actionsFromRoot = actionsFromRoot;
	}

}
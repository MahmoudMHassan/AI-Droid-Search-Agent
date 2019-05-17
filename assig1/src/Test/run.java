package Test;

import problem.HelpR2D2;
import searchAlgorithm.ASI;
import searchAlgorithm.BFS;
import searchAlgorithm.DFS;
import searchAlgorithm.GSI;
import searchAlgorithm.IDS;
import searchAlgorithm.Node;
import searchAlgorithm.UCS;

public class run {
	public void search(boolean visualize, String strategy) {
		HelpR2D2 p = new HelpR2D2();
		switch (strategy) {
		case "BF": {

			BFS bfs = new BFS(p, true);
			bfs.search();
			System.out.println("Expanded nodes : "+bfs.getExpandedNodes());
			System.out.println("Actions from root : "+bfs.getActionsFromRoot());
			System.out.println("Cost : "+bfs.getCost());

		}
		case "DF": {
			DFS dfs = new DFS(p, true);
			dfs.search();
			dfs.getExpandedNodes();
			dfs.getActionsFromRoot();
			dfs.getCost();

		}
		case "ID": {
			IDS ids = new IDS(p, true);
			ids.search();
			ids.getExpandedNodes();
			ids.getActionsFromRoot();
			ids.getCost();

		}
		case "UC": {
			UCS ucs = new UCS(p, true);
			ucs.search();
			ucs.getExpandedNodes();
			ucs.getActionsFromRoot();
			ucs.getCost();

		}
		case "GR0": {

			GSI gsr = new GSI(p, true);
			Node.admissible = 0;
			gsr.search();
			gsr.getExpandedNodes();
			gsr.getActionsFromRoot();
			gsr.getCost();

		}
		case "GR1": {
			GSI gsr = new GSI(p, true);
			Node.admissible = 1;
			gsr.search();
			gsr.getExpandedNodes();
			gsr.getActionsFromRoot();
			gsr.getCost();

		}
		case "AS0": {
			ASI asi = new ASI(p, true);
			Node.admissible = 0;
			asi.search();
			asi.getExpandedNodes();
			asi.getActionsFromRoot();
			asi.getCost();

		}
		case "AS1": {
			ASI asi = new ASI(p, true);
			Node.admissible = 1;
			asi.search();
			asi.getExpandedNodes();
			asi.getActionsFromRoot();
			asi.getCost();

		}

		}
	}

	public static void main(String[] args) {
		run r = new run();
		r.search(true, "BF");
//		r.search(true, "DF");
//		r.search(true, "ID");
//		r.search(true, "UC");
//		r.search(true, "GR0");
//		r.search(true, "GR1");
//		r.search(true, "AS0");
//		r.search(true, "AS1");
	}
}

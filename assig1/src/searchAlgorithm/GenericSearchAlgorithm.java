package searchAlgorithm;

import java.util.ArrayList;



public interface GenericSearchAlgorithm {
	ArrayList<Node> search();
	int getExpandedNodes();
	int getCost();
	ArrayList<String> getActionsFromRoot();
}

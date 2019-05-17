package problem;

import java.util.ArrayList;
import java.util.Hashtable;



public interface GenericSearchProblem {
	
     boolean testGoal(State s);
    
     int  pathCost();
    
     State getInitialState();
     
     Hashtable<String, Integer> getActions();
     
     ArrayList<State>  getStateSpace();
     
     ArrayList<State> expand(State s);
    
     
}

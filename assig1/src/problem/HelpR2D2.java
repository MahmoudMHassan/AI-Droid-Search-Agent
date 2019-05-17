package problem;

import java.util.ArrayList;
import java.util.Hashtable;

public class HelpR2D2 implements GenericSearchProblem {

	
	       public static Hashtable<String,Integer> actions ;
		   private R2D2State initialState ;
		   private ArrayList<State> stateSpace ;
	        public HelpR2D2(){
	        	 setActions() ;
	             setInitialState();
	    	 
	      }
	      
			private void setInitialState() {
				R2D2Grid grid = new R2D2Grid();
				initialState  = new R2D2State(grid);
				
			}

			private void setActions() {
				   actions = new Hashtable<String,Integer>();
				   actions.put("Push",20);
				   actions.put("Move",10);
			
				
			}

			@Override
			public R2D2State getInitialState() {
				return initialState;
			}
			
			@Override
			public ArrayList<State> getStateSpace() {
				return stateSpace;
			}

			@Override
			public boolean testGoal(State s) {
				R2D2State state = (R2D2State) s ;
				R2D2Grid grid = state.getGrid();
				if((state.getRocksOnPads() == grid.getRocksPadsNumber()) && state.isAgentOnTeleportal())
					return true ;
				
				return false;
			}

			@Override
			public int pathCost() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Hashtable<String, Integer> getActions() {
				return actions;
			
				
			}
			
			public ArrayList<R2D2State> move(R2D2State s) throws CloneNotSupportedException{
				R2D2Position  agentPosition = s.getAgentPosition();
				ArrayList<R2D2State> res = new  ArrayList<>();
                int x = agentPosition.getX() ;
                int y = agentPosition.getY() ;
               
                ArrayList<R2D2Position> poss = new ArrayList<>();
                poss.add( new R2D2Position(x-1, y)) ;
                poss.add( new R2D2Position(x, y-1)) ;
                poss.add( new R2D2Position(x, y+1)) ;
                poss.add( new R2D2Position(x+1, y)) ;
                
                ArrayList<R2D2Direction> directions = new ArrayList<>();
                directions.add(R2D2Direction.North);
                directions.add(R2D2Direction.West);
                directions.add(R2D2Direction.East);
                directions.add(R2D2Direction.South);

               for (int i = 0; i < poss.size(); i++) {
            		R2D2Grid newg = s.getGrid().move(agentPosition,poss.get(i));
    				if(newg!=null){
    					R2D2State newS = new R2D2State(newg);
    					newS.setAction("Move");
    					newS.setDirection(directions.get(i));
    					res.add( newS);
    				}
    			        
			   }
               return res ;
             
					
			}
			
			public ArrayList<R2D2State> push(R2D2State s) throws CloneNotSupportedException{
				R2D2Position  agentPosition = s.getAgentPosition();
				ArrayList<R2D2State> res = new  ArrayList<>();
                int x = agentPosition.getX() ;
                int y = agentPosition.getY() ;
               
                ArrayList<R2D2Position> next = new ArrayList<>();
                next.add( new R2D2Position(x-1, y)) ;
                next.add( new R2D2Position(x, y-1)) ;
                next.add( new R2D2Position(x, y+1)) ;
                next.add( new R2D2Position(x+1, y)) ;
                
                ArrayList<R2D2Position> afterNext = new ArrayList<>();
                afterNext.add( new R2D2Position(x-2, y)) ;
                afterNext.add( new R2D2Position(x, y-2)) ;
                afterNext.add( new R2D2Position(x, y+2)) ;
                afterNext.add( new R2D2Position(x+2, y)) ;
                
                ArrayList<R2D2Direction> directions = new ArrayList<>();
                directions.add(R2D2Direction.North);
                directions.add(R2D2Direction.West);
                directions.add(R2D2Direction.East);
                directions.add(R2D2Direction.South);
                
               for (int i = 0; i < next.size(); i++) {
            		R2D2Grid newg = s.getGrid().push(agentPosition,next.get(i),afterNext.get(i));
    				if(newg!=null){
    					R2D2State newS = new R2D2State(newg);
				     	newS.setAction("Push");
				    	newS.setDirection(directions.get(i));
				    	res.add( newS);
    				}
			   }
               return res ;
             
					
			}
			
			
			
			@Override
			public ArrayList<State> expand(State s) {
				 ArrayList<State> res = new ArrayList<State>();
				
				try {
					 ArrayList<R2D2State> push = push((R2D2State)s);
				   
					 ArrayList<R2D2State> move = move((R2D2State)s); 
					 
					 if(!push.isEmpty()) 
					 {
						 res.addAll(push);
						 
						
					 }
					 
					 if(!move.isEmpty()) 
					 {
						 res.addAll(move);
						 
						
					 }
					
					 
					 return res;
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					System.out.println("error clone");
					e.printStackTrace();
					return res ;
				}
			
				
			}
			
			
		
//			public R2D2State move(R2D2State s) throws CloneNotSupportedException{
//				R2D2Position  agentPosition = s.getAgentPosition();
//			
//                int x = agentPosition.getX() ;
//                int y = agentPosition.getY() ;
//				switch (s.getDirection()) {
//				case North:{
//					 x -=1 ;
//					R2D2Grid newg = s.getGrid().move(agentPosition,new R2D2Position(x, y));
//					if(newg==null)
//						return null ;
//					else
//						return  new R2D2State(newg,s.getDirection());		
//					
//				}
//				case South:{
//					x += 1 ;
//					R2D2Grid newg = s.getGrid().move(agentPosition,new R2D2Position(x, y));
//					if(newg==null)
//						return null ;
//					else
//						return  new R2D2State(newg,s.getDirection());	
//				}
//				case East:{
//					y += 1 ;
//					R2D2Grid newg = s.getGrid().move(agentPosition,new R2D2Position(x, y));
//					if(newg==null)
//						return null ;
//					else
//						return new R2D2State(newg,s.getDirection());
//				}
//				case West:{
//					y -= 1 ;
//					R2D2Grid newg = s.getGrid().move(agentPosition,new R2D2Position(x, y));
//					if(newg==null)
//						return null ;
//					else
//						return new R2D2State(newg,s.getDirection());
//				}
//			
//				}
//				System.out.println("error helpR2d2 move");
//				return null  ;
//			}
			
			
//			public R2D2State rotateLeft(R2D2State s) throws CloneNotSupportedException{
//				 R2D2Grid newGrid = (R2D2Grid) s.getGrid().clone();
//				          newGrid.setAgentPosition(s.getGrid().getAgentPosition());
//			       return new R2D2State(newGrid, s.rotateLeft());
//			}
//			public R2D2State rotateRight(R2D2State s) throws CloneNotSupportedException{
//				 R2D2Grid newGrid = (R2D2Grid) s.getGrid().clone();
//		          newGrid.setAgentPosition(s.getGrid().getAgentPosition());
//	       return new R2D2State(newGrid, s.rotateRight());
//
//			}
//			public R2D2State push(R2D2State s) throws CloneNotSupportedException{
//				
//				R2D2Position  agentPosition = s.getAgentPosition();
//			
//                int x = agentPosition.getX() ;
//                int y = agentPosition.getY() ;
//                     
//                R2D2Grid newg=null;
//                
//                switch (s.getDirection()) {
//				case North:{
//					 x -=1 ;
//					R2D2Position next = new R2D2Position(x, y);
//					R2D2Position afterNext = new R2D2Position(x-1, y);
//				    newg = s.getGrid().push(agentPosition,next,afterNext);
//				    break;		
//					
//				}
//				case South:{
//					x += 1 ;
//					R2D2Position next = new R2D2Position(x, y);
//					R2D2Position afterNext = new R2D2Position(x+1, y);
//				    newg = s.getGrid().push(agentPosition,next,afterNext);
//				    break;
//				}
//				case East:{
//					y += 1 ;
//					R2D2Position next = new R2D2Position(x, y);
//					R2D2Position afterNext = new R2D2Position(x, y+1);
//				    newg = s.getGrid().push(agentPosition,next,afterNext);
//				    break;
//				}
//				case West:{
//					y -= 1 ;
//					R2D2Position next = new R2D2Position(x, y);
//					R2D2Position afterNext = new R2D2Position(x, y-1);
//				    newg = s.getGrid().push(agentPosition,next,afterNext);
//				    break;
//				}
//				default : System.out.println("error helpR2D2");
//				}
//                if(newg==null){
//                	
//                	System.out.println("newg is nulllllllllll");
//                	return null ;
//                }
//					
//				else{
//					System.out.println("newg is not nulllllllllll");
//					return  new R2D2State(newg,s.getDirection());
//				}
//				
//                
//			}

			
         
//			@Override
//			public ArrayList<State> expand(State s) {
//				R2D2State ss = (R2D2State)s;
////				System.out.println("start");
////				System.out.println(ss.getGrid());
////				System.out.println("agent = "+ss.getGrid().getAgentPosition());
////				System.out.println("direction = "+ss.getDirection());
////				System.out.println("expantion = "+ c++);
////				System.out.println("end");
//				 ArrayList<State> res = new ArrayList<State>();
//				
//				try {
//					 R2D2State pushRes = push((R2D2State)s);
//					 R2D2State moveRes = move((R2D2State) s);     
//					 R2D2State rotLRes = rotateLeft((R2D2State)s);
//					 R2D2State rotRRes = rotateRight((R2D2State)s);         
//					 if(pushRes != null) 
//					 {
//						 res.add(pushRes);
//						 pushRes.action="push";
//						System.out.println( "pusheeeeeeeeeeeed");
//					 }else{
//						System.out.println("nooottttttttttttt       pushhhhhed");
//					 }
//					          
//					 if(moveRes != null) 
//					 {
//						 res.add(moveRes);
//						 moveRes.action = "move";
//					 }
//					 if(rotLRes != null) 
//					 {
//						 res.add(rotLRes);
//				           rotLRes.action = "rotateLeft";
//
//					 }
//					 if(rotRRes != null)
//					 {
//						 res.add(rotRRes);
//						 rotRRes.action= "rotateRight";
//					 }
//				
//					 
//					 return res;
//				} catch (CloneNotSupportedException e) {
//					// TODO Auto-generated catch block
//					System.out.println("error clone");
//					e.printStackTrace();
//					return res ;
//				}
//			
//				
//			}
			




			
	

}

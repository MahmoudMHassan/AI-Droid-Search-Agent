package problem;

public class R2D2State implements State{
   private R2D2Grid grid ;
   private R2D2Direction direction ;
   private String action ;
     
   
   public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}
public void setDirection(R2D2Direction direction) {
	this.direction = direction;
}
public R2D2State(R2D2Grid grid ) {
	  this.grid = grid ;
	  
	 
	
   }
public R2D2Grid getGrid() {
	return grid;
}

public R2D2Direction getDirection() {
	return direction;
}
public int getRocksOnPads() {
	return grid.getRocksOnPads();
}
public R2D2Position getAgentPosition() {
	return grid.getAgentPosition();
}

public boolean isAgentOnTeleportal(){
	R2D2GridItem[][] g = grid.getGrid();
	R2D2Position p = getAgentPosition();
//	System.out.println("goalTest");
//	System.out.println(p);
//	System.out.println(p.getX());
//	System.out.println(p.getY());
//	System.out.println(g[p.getX()][p.getY()]);
//	System.out.println("end goaltest");
	if(g[p.getX()][p.getY()].isAgentOnTeleportal())
	 return true ;
	return false; 
}


public R2D2Direction rotateRight(){
	switch(direction){
	case West : return R2D2Direction.North ;
	case North: return R2D2Direction.East;
	case East:  return R2D2Direction.South;
	case South: return R2D2Direction.West;
	}
	return null ;
}

public R2D2Direction rotateLeft(){
	switch(direction){
	case North : return R2D2Direction.West ;
	case West: return R2D2Direction.South;
	case South:  return R2D2Direction.East;
	case East: return R2D2Direction.North;
	}
	return null ;
}

public String toString(){
	 String res = "Start state \n";
	 res+= grid ;
	 res += "direction :"+direction + "\n";
	 res +="Action :"+action+"\n";
	 res+= "end State \n";
	 return res ;
	 
}


   
   
} 

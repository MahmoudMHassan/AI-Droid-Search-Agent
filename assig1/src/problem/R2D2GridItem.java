package problem;


public class R2D2GridItem  {
   private R2D2GridItemType type  = R2D2GridItemType.Empty;
  
   public R2D2GridItem(R2D2GridItemType type ){
	   this.type = type ;
	 
   }
public String toString(){
	return type.name() ;
}

public R2D2GridItemType getType() {
	return type;
}

public void setType(R2D2GridItemType type) {
	this.type = type;
}

public boolean isEmpty(){
	return this.type == R2D2GridItemType.Empty ;
}
public boolean isTeleportal(){
	return this.type == R2D2GridItemType.Teleportal ;
}
public boolean isRock(){
	return this.type == R2D2GridItemType.Rock ;
}

public boolean isPad(){
	return this.type == R2D2GridItemType.Pad ;
}

public boolean isObstacle(){
	return this.type == R2D2GridItemType.Obstacle ;
}
public boolean isAgent(){
	return this.type == R2D2GridItemType.Agent ;
}
public boolean isAgentOnTeleportal(){
	return this.type == R2D2GridItemType.AgentOnTeleportal ;
}
public boolean isRockOnPad(){
	return this.type == R2D2GridItemType.RockOnPad ;
}
public boolean isAgentOnPad(){
	return this.type == R2D2GridItemType.AgentOnPad ;
}




@Override
public boolean equals(Object o){
	R2D2GridItem in = (R2D2GridItem) o ;
	return in.getType() == this.getType() ;
}

   
}

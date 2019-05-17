package problem;

public class R2D2Position {
  private int x ;
  private int y ;
  public R2D2Position(int x ,int y) {
	  this.x = x ;
	  this.y = y ;
}
public int getX() {
	return x;
}

public int getY() {
	return y;
}
public String toString(){
	return "x = "+x+" ,y = "+y ;
}
public void setX(int x) {
	this.x = x;
}
public void setY(int y) {
	this.y = y;
}
  
}

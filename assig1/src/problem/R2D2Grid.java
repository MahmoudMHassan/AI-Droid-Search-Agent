package problem;


import java.util.Random;


public class R2D2Grid implements Cloneable {
	  private R2D2GridItem[][] grid ;
	  private int n ;
	  private int m ;
	  private int rocksPadsNumber ;
	  private int obstaclesNumber ;
	  private int nBounds = 9;
	  private int mBounds = 9 ;
	  private int rocksPadsBound = (nBounds*mBounds)/3 ;
	  private int obstaclesBound = rocksPadsBound/2;
	  private R2D2Position agentPosition; 
      private int rocksOnPads = 0 ;




	public R2D2Grid (){
//	      makeGrid();
//	      rocksPadsBound = (n*m)/3 ;
//		  obstaclesBound = rocksPadsBound/2;
//		  System.out.println("1");
//    	  makeAgent();
//    	  System.out.println("2");
//    	  makeTeleportal();
//    	  System.out.println("3");
//    	  makeRocksPads();
//    	  System.out.println("4");
//    	  makeObstacles(); 
//    	  System.out.println("5");
     
     	   n =  3;
    	   m = 3 ;
    	  grid  = new R2D2GridItem[n][m];
    	  for (int i = 0; i < grid.length; i++) {
  			for (int j = 0; j < grid[i].length; j++) {
  				grid[i][j] = new R2D2GridItem(R2D2GridItemType.Empty);
  			}
  		}
    	  grid[0][1].setType(R2D2GridItemType.Pad);
    	  grid[1][1].setType(R2D2GridItemType.Rock);
      	  grid[0][2].setType(R2D2GridItemType.Pad);
    	  grid[1][2].setType(R2D2GridItemType.Rock);
//    	  grid[3][4].setType(R2D2GridItemType.Pad);
//    	  grid[4][1].setType(R2D2GridItemType.Rock);
    	  rocksPadsNumber = 2;
    	  grid[2][1].setType(R2D2GridItemType.Agent);
    	  agentPosition = new R2D2Position(2,1);
          grid[2][2].setType(R2D2GridItemType.Teleportal);
          grid[0][0].setType(R2D2GridItemType.Obstacle);
    	  
    	  
      }
	 
      
      
      private void makeGrid(){
    	  Random rand = new Random();
    	  n = rand.nextInt(nBounds) ;
    	  m = rand.nextInt(mBounds) ;
    	  while(n<3){
    		  n = rand.nextInt(nBounds) ;  
    	  }
    	  while(m<3){
        	  m = rand.nextInt(mBounds) ;
    	  }
    	 System.out.println("n = "+n);
    	 System.out.println("m = "+m);
    	  grid  = new R2D2GridItem[n][m];
    	  for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new R2D2GridItem(R2D2GridItemType.Empty);
			}
		}
      }
      
      private void makeAgent(){
    	  Random rand = new Random();
    	  int x = rand.nextInt(n) ;
    	  int y = rand.nextInt(m) ;
    	  grid[x][y].setType(R2D2GridItemType.Agent); 
    	  agentPosition = new R2D2Position(x, y);
    	  
      }
      private void makeRocksPads(){
    	  Random rand = new Random();
    	  rocksPadsNumber =  rand.nextInt(rocksPadsBound) ;
    	  while(rocksPadsNumber<=0){
    		  System.out.println("roockspadsnumber");
    		  rocksPadsNumber =  rand.nextInt(rocksPadsBound) ; 
    	  }
    	  System.out.println("rocksPadNumber : "+rocksPadsNumber);
    	  int xr = 0 ;
    	  int yr = 0 ;
    	  int xp = 0 ;
    	  int yp = 0 ;
    	  for (int i = 0; i < rocksPadsNumber; i++) {
    		  do{
    			  xr = rand.nextInt(n) ;
         		  yr = rand.nextInt(m) ;
    		  }while(!grid[xr][yr].isEmpty());
          	  grid[xr][yr].setType(R2D2GridItemType.Rock); 
          	  
    		  do{
    			  xp = rand.nextInt(n) ;
         		  yp = rand.nextInt(m) ;
    		  }while(!grid[xp][yp].isEmpty());
          	  grid[xp][yp].setType(R2D2GridItemType.Pad); 
    		  
    	  }
      }
      
      private void makeObstacles(){
    	  Random rand = new Random();
    	  obstaclesNumber = rand.nextInt(obstaclesBound);
    	  obstaclesNumber = 0 ;
    	  System.out.println("obstaclesNumber :"+obstaclesNumber);
    	  int xo ;
    	  int yo ;
    	  for (int i = 0; i < obstaclesNumber; i++) {
    		  do{
    			  xo = rand.nextInt(n) ;
         		  yo = rand.nextInt(m) ;
    		  }while(!grid[xo][yo].isEmpty());
          	  grid[xo][yo].setType(R2D2GridItemType.Obstacle);    		  
		}
      }
      private void makeTeleportal(){
    	  Random rand = new Random();
    	  int xt ;
    	  int yt ;
    	  do{
			  xt = rand.nextInt(n) ;
     		  yt = rand.nextInt(m) ;
		  }while(!grid[xt][yt].isEmpty());
    	  grid[xt][yt].setType(R2D2GridItemType.Teleportal);
      }
      public int getRocksPadsNumber() {
  		return rocksPadsNumber;
  	}
  	public void setAgentPosition(R2D2Position agentPosition) {
		this.agentPosition = agentPosition;
	}



      public R2D2Position getAgentPosition() {
  		return agentPosition;
  	}

	  public R2D2GridItem[][] getGrid() {
		return grid;
	}
	 public  R2D2Grid(R2D2GridItem[][] grid ){
		  this.grid = grid ;
		  
	  }
	 public boolean isWall(R2D2Position pos){
		  int x = pos.getX();
		  int y = pos.getY();
		 if(x <0 || y<0 || x>=grid.length || y>=grid[0].length)
			 return true;
		 else
			 return false; 
	 }
	  
	  @Override
	  protected Object clone() throws CloneNotSupportedException {
          
	     R2D2GridItem [][] r  = new R2D2GridItem[n][m];
	     for (int i = 0; i < r.length; i++) {
						for (int j = 0; j < r[i].length; j++) {
							//System.out.println(grid[i][j]);
						    r[i][j]=  new R2D2GridItem(grid[i][j].getType());
						}
		 }
	     R2D2Grid res = new R2D2Grid(r);
	     res.setRocksOnPads(rocksOnPads);
	     res.setM(m);
	     res.setN(n);
	     res.setRocksPadsNumber(rocksPadsNumber);
	     //res.print();
	     // System.out.println(res);
	
	     return res ;
	  }
	  
	  public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public int getM() {
		return m;
	}


	public void setM(int m) {
		this.m = m;
	}


	public void setRocksPadsNumber(int rocksPadsNumber) {
		this.rocksPadsNumber = rocksPadsNumber;
	}


	R2D2Grid move(R2D2Position start ,R2D2Position target) throws CloneNotSupportedException{
//		  System.out.println("move start :"+start);
//          System.out.println("move target :"+target);
          
	      //  R2D2GridItem agentItem = grid[start.getX()][start.getY()];

			if( isWall(target)  )
				return null;
			
			R2D2GridItem targetItem = grid[target.getX()][target.getY()];

			if(targetItem.isObstacle() || targetItem.isRockOnPad() || targetItem.isRock()){
				return null ;
			}else{
		        R2D2Grid newGrid = (R2D2Grid) this.clone();
		        newGrid.setAgentPosition(target);
              //  System.out.println("yob2aaaaaaaaaa");
               // System.out.println(newGrid);
                
		        R2D2GridItem agentItemNewGrid  = newGrid.getGrid()[start.getX()][start.getY()] ;
		        R2D2GridItem targetItemNewGrid = newGrid.getGrid()[target.getX()][target.getY()] ;

		       
		        if(agentItemNewGrid.isAgentOnTeleportal())
		        	agentItemNewGrid.setType(R2D2GridItemType.Teleportal);
		        else if(agentItemNewGrid.isAgentOnPad())
		        	agentItemNewGrid.setType(R2D2GridItemType.Pad);
		        else 
		        	agentItemNewGrid.setType(R2D2GridItemType.Empty);
		        
		        
		        
		        if(targetItemNewGrid.isPad()){
		        	targetItemNewGrid.setType(R2D2GridItemType.AgentOnPad);
		        }else{
		        	if(targetItemNewGrid.isTeleportal())
		        		targetItemNewGrid.setType(R2D2GridItemType.AgentOnTeleportal);
		        	else
		        		targetItemNewGrid.setType(R2D2GridItemType.Agent);
		        }
		      
				return newGrid;
			}
		}
	  R2D2Grid push(R2D2Position start ,R2D2Position nextPos ,R2D2Position afternextPos) throws CloneNotSupportedException{
//            System.out.println("push start :"+start);
//            System.out.println("push nextpos :"+nextPos);
//            System.out.println("push afternextpos :"+afternextPos);
	

			if( isWall(nextPos)||  isWall(afternextPos)  )
				return null ;
				
		     R2D2GridItem afterNext = grid[afternextPos.getX()][afternextPos.getY()] ;
		     R2D2GridItem next = grid[nextPos.getX()][nextPos.getY()] ;
				
			if (!next.isRock() || afterNext.isObstacle()  || afterNext.isRock() || afterNext.isRockOnPad()){
				return null;
			}else{
				
				R2D2Grid newGrid = (R2D2Grid) this.clone();
		        newGrid.setAgentPosition( nextPos);
		       //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa7aaaaaa");
		       // System.out.println(start);
		       // System.out.println(newGrid);
				R2D2GridItem agentItemNewGrid  = newGrid.getGrid()[start.getX()][start.getY()] ;
			    R2D2GridItem nextItemNewGrid = newGrid.getGrid()[nextPos.getX()][nextPos.getY()] ;
			    R2D2GridItem afterNextItemNewGrid = newGrid.getGrid()[afternextPos.getX()][afternextPos.getY()] ;
        
			    
			    switch(agentItemNewGrid.getType()){
			    case AgentOnTeleportal : agentItemNewGrid.setType(R2D2GridItemType.Teleportal);break;
			    case AgentOnPad        : agentItemNewGrid.setType(R2D2GridItemType.Pad);break;
			    case Agent         : agentItemNewGrid.setType(R2D2GridItemType.Empty);break;
			    default            :System.out.println("push error not expected agentItemNewGrid = "+agentItemNewGrid.getType());
			    }
			    
			    switch(nextItemNewGrid.getType()){
			    case Rock         : nextItemNewGrid.setType(R2D2GridItemType.Agent);break;
			    default            :System.out.println("push error not expected nextItemNewGrid = "+nextItemNewGrid.getType());
			    }
			    
			    
			    switch(afterNextItemNewGrid.getType()){
			    case Pad : {
			    	afterNextItemNewGrid.setType(R2D2GridItemType.RockOnPad);
			       //  System.out.println("ooppppppppppppppppppppppppppppppppppppppppppaaaaaaaaaaaaaaaaaa");
			         
			         newGrid.setRocksOnPads( rocksOnPads+1);
			       //  System.out.println("7at3leh :"+rocksOnPads);
//			         System.out.println(newGrid);
//			         System.out.fprintln(newGrid.getRocksOnPads());
			         return newGrid;
			    }
			    case Teleportal   : afterNextItemNewGrid.setType(R2D2GridItemType.RockOnTeleportal);break;
			    case Empty        : afterNextItemNewGrid.setType(R2D2GridItemType.Rock);break;
			    default            :System.out.println("push error not expected afterNextItemNewGrid = "+afterNextItemNewGrid.getType());

			    }
			    
     
				return newGrid;
			}
		}


	public int getRocksOnPads() {
		return rocksOnPads;
	}


	public void setRocksOnPads(int rocksOnPads) {
		this.rocksOnPads = rocksOnPads;
	}

	public int hteleportal() {
		R2D2Position point = new R2D2Position(0, 0);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j].isTeleportal()) {
					point.setX(i);
					point.setY(j);
					break;
				}
			}
		}
		int num = (int) Math.sqrt(square(getAgentPosition().getX()- point.getX())
				   + square(getAgentPosition().getY() - point.getY()));

		return 10 * num;
	}

	public int square(int x) {
		return x * x;
	}
	
	public int inactivePadsCost(){
		 int res = 0 ;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j].isPad())res++ ;
			}
		}
		return res*10 ;
	}
	


	

	public String toString(){
		//System.out.println("7nprint");
		String res = "";
    	  for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j].isEmpty())
					res += " -- ";
				else
				    res +=grid[i][j].toString()+" ";
			}
			res+="\n";
		}
    	  
		return res ;
      }
    
public static void main(String[] args) throws CloneNotSupportedException {
//	R2D2Grid g = new R2D2Grid();
//	R2D2Grid a = (R2D2Grid) g.clone();
//	System.out.println(a);
//	System.out.println(a.getGrid()[0][1]);
}
     
}

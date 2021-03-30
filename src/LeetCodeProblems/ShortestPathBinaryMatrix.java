package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
	static class Node{
        int x;
        int y;
        int dist;
        Node(int x,int y,int dist)
        {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
    	int row=grid.length;
        int col=grid[0].length;
    	
        if(grid[0][0]==1 || grid[row-1][col-1]==1) {
        	 return -1;
        }
            
        int[][] direction = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1}, {-1,-1}};
        
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(0,0,1));
        grid[0][0]=1;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                Node temp=queue.poll();
                int x=temp.x;
                int y=temp.y;
                int cost=temp.dist;
                
                if(x==row-1 && y==col-1 )
                    return cost;
                
                for(int[] way:direction)
                {
                   int nextX=x+way[0];
                   int nextY=y+way[1];
                    
                    if(nextX>=0 && nextX<row && nextY>=0 && nextY<col && grid[nextX][nextY]==0 )
                    {
                    	queue.add(new Node(nextX,nextY,cost+1));
                        grid[nextX][nextY]=1;
                    }
                    
                }
            }
        }
        
        return -1;
        
    }

}

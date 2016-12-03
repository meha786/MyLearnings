import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
	
	
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void bfs(int mat[][],int source, int len, boolean visited[])
	{
		q.add(source);
		visited[source] = true;
		
		while(!q.isEmpty())
		{
			int front = q.remove();
			
			System.out.print(front + " ");
			
			for(int i=0;i<len;i++)
			{
				if(mat[front][i]==1 && visited[i]==false)
				{
					q.add(i);
					visited[i] = true;
				}
			}
			
		}
}

	public static void main(String[] args) {
		
		int mat[][] = new int[][]{{0,1,0,0,1,0,0,0,0},
								  {1,0,1,0,1,0,0,0,0},
								  {0,1,0,0,0,1,0,0,0},
								  {0,0,0,0,0,0,1,1,0},
								  {1,0,0,0,0,1,0,0,0},
								  {0,0,1,0,1,0,0,0,1},
								  {0,0,0,1,0,1,0,0,0},
								  {0,0,0,1,0,0,0,1,0},
								  {0,0,0,0,0,1,0,0,0}};
		
	/*int[][] mat = { {0,1,1,0},
			    		{1,0,0,0},
			    		{1,0,0,1},
			    		{0,0,1,0}
			  };*/
	
		
								  
		int len = mat[0].length;
		boolean visited[] = new boolean[len];
		
		for(int i=0;i<len;i++)
		{
			visited[i] = false;
		}
			  
		bfs(mat,0,len,visited);
		
	}

}

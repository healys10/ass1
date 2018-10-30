import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {
	
	private int V;						//# vertices
	private int E;						//# edges
	private ArrayList<Integer>[] adj;   //adj[V] = adjacency list for vertex V
	private int [] indegree;			//indegree[V] = indegree of vertex V
	private int [] outdegree;			//outdegree[V] = outdegree of vertex V
	private boolean marked [];			//list of visited vertices
	private boolean hasCycle;			//True if graph has cycle
	private boolean stack [];			//
	
	
	public DAG(int V)
	{
		
	}
	public int V()
	{
		return V;
	}
	public int E()
	{
		return E;
	}
	public void addEdge(int v, int w)
	{
			
	}
	public int indegree(int v)
	{
	
		return -1;
	}
	public int outdegree(int v)
	{
		
		return -1;
	}
	private int validateVertex(int v)
	{
		if(v < 0 || v >= V)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}

}

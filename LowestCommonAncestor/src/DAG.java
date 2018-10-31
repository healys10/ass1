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
		if(V < 0)
		{
			throw new IllegalArgumentException("The number of vertices must be greater than 0");
		}
		
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		marked = new boolean[V];
		stack = new boolean[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		
		for(int v = 0; v < V; v++)
		{
			adj[v] = new ArrayList<Integer>();
		}
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
		if((validateVertex(v) > 0) && (validateVertex(w) > 0))
		{
			adj[v].add(w);
			indegree[w]++;
			E++;
		}
		else
		{
			System.out.println("Please enter numbers between 0 and " + (V-1));
		}		
	}
	
	
	public int indegree(int v)
	{
		if(validateVertex(v) > 0)
		{
			return indegree[v];
		}
		else
		{
			return -1;
		}
	}
	
	
	public int outdegree(int v)
	{
		if(validateVertex(v) > 0)
		{
			return adj[v].size();
		}
		else
		{
			return -1;
		}
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
	
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	public boolean hasCycle()
	{
		return hasCycle;
	}
	
	public void findCycle(int v)
	{
		marked[v] = true;
		stack[v] = true;
		
		for(int w : adj(v))
		{
			if(!marked[w])
			{
				findCycle(w);
			}
			else if(stack[w])
			{
				hasCycle = true;
				return;
			}
		}
		stack[v] = false;
	}
	
	
	
	public int findLCA(int v, int w)
	{
		findCycle(0);
		
		if(hasCycle) //Not DAG
		{
			return -1;
		}
		else if(validateVertex(v) < 0 || validateVertex(w) < 0)
		{
			return -1;
		}
		else if(E == 0)
		{
			//Empty
			return -1;
		}
		
		DAG reverse = reverse(); //reverse function
		
		ArrayList<Integer> array1 = reverse.BFS(v);//breadth first search
		ArrayList<Integer> array2 = reverse.BFS(w);
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();
		
		boolean found = false;
		
		for(int i = 0; i < array1.size(); i++)
		{
			for(int j = 0; j < array2.size(); j++)
			{
				if(array1.get(i) == array2.get(j))
				{
					commonAncestors.add(array1.get(i));
					found = true;
				}
			}
		}
		
		if(found)
		{
			return commonAncestors.get(0);
		}
		else
		{
			return -1; //None found
		}
	}
	
	public ArrayList<Integer> BFS(int s)
	{
		ArrayList<Integer> order = new ArrayList<Integer>();
		boolean visit[] = new boolean[V]; //Marks vertices as not visit
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visit[s] = true;
		queue.add(s);
		
		while(queue.size() != 0)
		{
			s = queue.poll(); //Sets s to the head of the list
			order.add(s);
			
			//Find adjacent vertices to s. If not visited,
			//mark as visited (true) and enqueue
			Iterator<Integer> i = adj[s].listIterator();
			
			while(i.hasNext())
			{
				int n = i.next();
				if(!visit[n])
				{
					visit[n] = true;
					queue.add(n);
				}
			}
		}
		return order;
	}
	

}

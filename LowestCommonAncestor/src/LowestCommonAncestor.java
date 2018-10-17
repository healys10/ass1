import java.util.ArrayList; 
import java.util.List; 
  

/*class Node { 
    int data; 
    Node left, right; 
  
    Node(int value) { 
        data = value; 
        left = right = null; 
    } 
}*/


  
public class LowestCommonAncestor 
{ 
	Digraph graph;
	
	public LowestCommonAncestor(Digraph g)
	{
		this.graph = g;
	}
	
	public boolean hasCycle()
	{
		DirectedCycle testDAG = new DirectedCycle(graph);
		return testDAG.hasCycle();
	}
	
	public int lowestCommonAncestor(int a,int b)
	{
		if(hasCycle()){
			return -1;
		}
		else if (graph.V()==0){
			return -1;
		}
		else{
			//code
			DirectedDFS DFS_A = new DirectedDFS(graph, a);
			DirectedDFS DFS_B = new DirectedDFS(graph, b);
			boolean[]am = DFS_A.marked;
			boolean[]bm = DFS_B.marked;
			for(int i = 0; i<am.length; i++){
				if(am[i]==bm[i]){
					return i;
				}
			}
			
			return -1;
		}

	}
	

  
   /* Node root; 
    private List<Integer> path1 = new ArrayList<>(); 
    private List<Integer> path2 = new ArrayList<>(); 
  
    int findLCA(int n1, int n2) { 
        path1.clear(); 
        path2.clear(); 
        return findLCAInternal(root, n1, n2); 
    } 
  
    private int findLCAInternal(Node root, int n1, int n2) { 
  
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) { 
            return -1; 
        } 
  
        int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++) { 
              
            if (!path1.get(i).equals(path2.get(i))) 
                break; 
        } 
  
        return path1.get(i-1); 
    } 
    private boolean findPath(Node root, int n, List<Integer> path) 
    { 
    	
        if (root == null) { 
            return false; 
        } 
          
        path.add(root.data); 
  
        if (root.data == n) { 
            return true; 
        } 
  
        if (root.left != null && findPath(root.left, n, path)) { 
            return true; 
        } 
  
        if (root.right != null && findPath(root.right, n, path)) { 
            return true; 
        } 
  
        path.remove(path.size()-1); 
  
        return false; 
        */
    
    
    public static void main (String[] args)
    {
    	Digraph v = new Digraph(0);
    	v.addEdge(0,1);
    }
    
}     

  


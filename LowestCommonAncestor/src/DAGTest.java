import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest
{

	@Test
	public void test()
	{
        DAG graph = new DAG(10);	 
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
		
		assertEquals(1, graph.indegree(4));
		assertEquals(2, graph.outdegree(4));
		assertEquals(5, graph.E());
		assertEquals(10, graph.V());
		String adj = "[6, 7]";
		assertEquals(adj, graph.adj(4).toString());
	}
	
	@Test
	public void addEdge()
	{
		DAG graph = new DAG(5);
		
		graph.addEdge(1,2);

		//- will print a system error and not addEdge
		graph.addEdge(-1, -6);
		
		//Won't addEdge as 12 > 5
		graph.addEdge(3, 12);
		
		assertEquals(1, graph.E());
	}
	
	@Test
	public void testIndegree()
	{
		DAG graph = new DAG(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 3);
		
		assertEquals(1, graph.indegree(3));
	
		assertEquals(-1, graph.indegree(5));
	}
	
	@Test
	public void testOutdegree()
	{
		DAG graph = new DAG(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 3);
		
		assertEquals(1, graph.outdegree(3));
	
		assertEquals(-1, graph.outdegree(5));
	}
	
	@Test 
	public void testV()
	{
		DAG graph = new DAG(6);
		assertEquals(6, graph.V());
	}
	
	@Test
	public void testE(){
		
		DAG graph = new DAG(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 3);
		
		assertEquals(3, graph.E());
	}
	
	@Test
	public void testCycle()
	{
		DAG graph = new DAG(10);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		
		graph.findCycle(0);
		
		assertTrue(graph.hasCycle()); 
	}
	
	@Test
	public void testAcyclicGraph()
	{
		DAG graph = new DAG(10);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 3);
		
		graph.findCycle(1);
		assertFalse(graph.hasCycle());
	}
	
	@Test
	public void testLCA()
	{
		DAG graph = new DAG(10);
		
		//        3   4    8
		//   0  1       6    7
		//        2   5
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(2, 5);
		graph.addEdge(5, 6);
		graph.addEdge(4, 6);
		graph.addEdge(6, 7);
		graph.addEdge(4, 8);
		graph.addEdge(8, 7);
		
		assertEquals(1, graph.findLCA(4, 5));
		assertEquals(8, graph.findLCA(7, 8));
		assertEquals(6, graph.findLCA(6, 7));
	}
	
	@Test
	public void testLCAforNoCommonAncestors()
	{
		DAG graph = new DAG(10);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(3, 2);
		graph.addEdge(2, 4);
		graph.addEdge(1, 5);
		graph.addEdge(2, 5);
		
		//Check if function works
		assertEquals(0, graph.findLCA(2, 1));
		assertEquals(3, graph.findLCA(2, 3));
		assertEquals(2, graph.findLCA(4, 5));
		
		//Check for vertex that doesn't exist
		assertEquals(-1, graph.findLCA(8, 2));
		
		//Check negative
		assertEquals(-1, graph.findLCA(-2, 3));
		assertEquals(-1, graph.findLCA(3, -2));
		assertEquals(-1, graph.findLCA(-2, -3));
	}

}

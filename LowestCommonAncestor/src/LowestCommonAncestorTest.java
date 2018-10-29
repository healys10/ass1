import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LowestCommonAncestorTest
{

	
	@Test
	public void testEmpty()
	{
		//LowestCommonAncestor tree = new LowestCommonAncestor();
		Digraph graph = new Digraph(0);
		LowestCommonAncestor lca = new LowestCommonAncestor(graph);
		int test = lca.lowestCommonAncestor(1,2);
		assertEquals(test,-1);
		//assertEquals("Checking empty tree", -1, tree.findLCA(2,3));
	}
	
	@Test
	public void test()
	{
		//LowestCommonAncestor test = initializeData();
		Digraph graph = new Digraph(10);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(3, 6);
		graph.addEdge(4, 5);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		LowestCommonAncestor test = new LowestCommonAncestor(graph);
		assertEquals(1,test.lowestCommonAncestor(6, 1));
	}  
	
	/*
	@Test
	public void testMultiple()
	{
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.right.right.right = new Node(7);
		assertEquals("Checking tree with multiple nodes", 2, tree.findLCA(4,5));
		assertEquals("Checking tree with multiple nodes", 1, tree.findLCA(3,5));
		assertEquals("Checking tree with multiple nodes", 6, tree.findLCA(6,7));
	}
	
	@Test
	public void testOthers()
	{
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.left.right = new Node(4);
		tree.root.right = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.right.left = new Node(7);
		assertEquals("Checking non-present", -1, tree.findLCA(22,5));
		assertEquals("Checking non-present", -1, tree.findLCA(18,115));
		assertEquals("Checking non-present", -1, tree.findLCA(0,7));
		
	}
	
	@Test
	public void testNegativeForPositive()
	{
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.left.left = new Node(3);
		assertEquals("Checking negative", -1, tree.findLCA(-2,2));
		assertEquals("Checking negative", -1, tree.findLCA(-1,-3));
	}
	
	@Test
	public void testNegative()
	{
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(-2);
		tree.root.left = new Node(-5);
		tree.root.left.left = new Node(-4);
		tree.root.right = new Node(-1);
		assertEquals("Checking", -2, tree.findLCA(-5,-1));
		assertEquals("Checking", -5, tree.findLCA(-5,-4));
	}
*/

}

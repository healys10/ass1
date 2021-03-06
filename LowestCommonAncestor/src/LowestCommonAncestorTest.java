import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LowestCommonAncestorTest
{

	@Test
	public void testConstructor()
	{
		Node node = new Node(1);
		assertNotNull("Testing constructor..",node);
	}
	
	@Test
	public void testEmpty()
	{
		LowestCommonAncestor tree = new LowestCommonAncestor();
		assertEquals("Checking empty tree", -1, tree.findLCA(2,3));
	}
	
	@Test
	public void testSingle()
	{
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		assertEquals("Checking tree with single node at 1,1", 1, tree.findLCA(1,1));
		assertEquals("Checking tree with single node at other", -1, tree.findLCA(0,0));
	}
	
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
	
}

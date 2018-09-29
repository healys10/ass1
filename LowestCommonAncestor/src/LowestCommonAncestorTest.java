import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LowestCommonAncestorTest
{

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
		assertEquals("Checking tree with single node at other", -1, tree.findLCA(2,6));
		assertEquals("Checking tree with single node at other", -1, tree.findLCA(0,0));
	}

}

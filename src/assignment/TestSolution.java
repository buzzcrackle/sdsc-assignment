package assignment;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolution {

	// Test to see if isSubtree works on two identical one-node trees
	@Test
	public void simpleMatchingTest() {
		TreeNode s = new TreeNode(10);
		TreeNode t = new TreeNode(10);

		assertEquals(Solution.isSubtree(s, t), true);
	}

	// Test to see if isSubtree returns true with the example trees
	@Test
	public void exampleMatch1() {
		TreeNode s = new TreeNode(3);
		s.left = new TreeNode(4);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(1);
		s.left.right = new TreeNode(2);
		
		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);

		assertEquals(Solution.isSubtree(s, t), true);
	}
	
	// Test to see if isSubtree returns true with the example trees
	@Test
	public void exampleMatch2() {
		TreeNode s = new TreeNode(3);
		s.left = new TreeNode(4);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(1);
		s.left.right = new TreeNode(2);
		
		TreeNode t = new TreeNode(5);

		assertEquals(Solution.isSubtree(s, t), true);
	}
	
	// Test to see if isSubtree returns false with the example trees
	@Test
	public void exampleNotMatch() {
		TreeNode s = new TreeNode(3);
		s.left = new TreeNode(4);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(1);
		s.left.right = new TreeNode(2);
		s.left.right.left = new TreeNode(0);
		
		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);

		assertEquals(Solution.isSubtree(s, t), false);
	}
	
	// Test with a more complex tree that has no matching subtree
	@Test
	public void complexNotMatch() {
		TreeNode s = new TreeNode(2);
		s.left = new TreeNode(7);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(2);
		s.left.right = new TreeNode(6);
		s.left.right.left = new TreeNode(5);
		s.left.right.right = new TreeNode(11);
		s.right.right = new TreeNode(9);
		s.right.right.left = new TreeNode(4);
		
		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);

		assertEquals(Solution.isSubtree(s, t), false);
	}
	
	// Test with a more complex tree that has a matching subtree
	@Test
	public void complexMatch() {
		TreeNode s = new TreeNode(2);
		s.left = new TreeNode(7);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(2);
		s.left.right = new TreeNode(6);
		s.left.right.left = new TreeNode(5);
		s.left.right.right = new TreeNode(11);
		s.right.right = new TreeNode(9);
		s.right.right.left = new TreeNode(4);
		
		TreeNode t = new TreeNode(5);
		t.right = new TreeNode(9);
		t.right.left = new TreeNode(4);

		assertEquals(Solution.isSubtree(s, t), true);
	}
	
	// Test with tree that has two matching subtrees
	@Test
	public void twoMatches() {
		TreeNode s = new TreeNode(2);
		s.left = new TreeNode(7);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(2);
		s.left.right = new TreeNode(6);
		s.left.right.left = new TreeNode(5);
		s.left.right.left.right = new TreeNode(9);
		s.left.right.left.right.left = new TreeNode(4);
		s.left.right.right = new TreeNode(11);
		s.right.right = new TreeNode(9);
		s.right.right.left = new TreeNode(4);
		
		TreeNode t = new TreeNode(5);
		t.right = new TreeNode(9);
		t.right.left = new TreeNode(4);

		assertEquals(Solution.isSubtree(s, t), true);
	}
	
	// Test with a complex tree that has two matching subtrees but one has extra
	// node
	@Test
	public void oneCloseMatchOneTrueMatch1() {
		TreeNode s = new TreeNode(2);
		s.left = new TreeNode(7);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(2);
		s.left.right = new TreeNode(6);
		s.left.right.left = new TreeNode(5);
		s.left.right.left.right = new TreeNode(9);
		s.left.right.left.right.left = new TreeNode(4);
		s.left.right.right = new TreeNode(11);
		s.right.right = new TreeNode(9);
		s.right.right.left = new TreeNode(4);
		s.right.right.left.right = new TreeNode(8);
		
		TreeNode t = new TreeNode(5);
		t.right = new TreeNode(9);
		t.right.left = new TreeNode(4);

		assertEquals(Solution.isSubtree(s, t), true);
	}
	
	// Test with a complex tree that has two matching subtrees but one has extra
	// node
	@Test
	public void oneCloseMatchOneTrueMatch2() {
		TreeNode s = new TreeNode(2);
		s.left = new TreeNode(7);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(2);
		s.left.right = new TreeNode(6);
		s.left.right.left = new TreeNode(5);
		s.left.right.left.right = new TreeNode(9);
		s.left.right.left.right.left = new TreeNode(4);
		s.left.right.left.right.left.right = new TreeNode(7);
		s.left.right.right = new TreeNode(11);
		s.right.right = new TreeNode(9);
		s.right.right.left = new TreeNode(4);
		
		TreeNode t = new TreeNode(5);
		t.right = new TreeNode(9);
		t.right.left = new TreeNode(4);

		assertEquals(Solution.isSubtree(s, t), true);
	}
}
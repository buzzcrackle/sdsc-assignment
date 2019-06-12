package assignment;

import java.util.*;

/**
 * Determines whether tree t is a subset of tree s
 * 
 * @author jesseliang
 *
 */
class Solution {
	
	/**
	 * Returns a boolean value that indicates whether tree t is a subtree of 
	 * tree s
	 * 
	 * @param s is the head of the main tree
	 * @param t is the head of the tree to check with
	 * @return true if t is a subtree of s, false otherwise
	 */
	public static boolean isSubtree(TreeNode s, TreeNode t) {
		// Gets list of all nodes that match the head node of t
		List<TreeNode> matchingHeads = searchForHeads(s, t);

		// Iterate through the list and check if there is a subtree in s that 
		// matches t
		for (TreeNode node : matchingHeads) {
			
			// If the tree is equal, that means t must be a subtree of s, 
			// therefore return true
			if (treesEqual(node, t)) {
				return true;
			}
		}

		// No subtrees matched t, therefore return false
		return false;
	}

	/**
	 * Finds all occurrences of an equal node in a tree and returns the list of
	 * all occurrences
	 * 
	 * @param rootNode is the head node of tree
	 * @param query is the node to search for
	 * @return list of equal nodes in tree
	 */
	public static List<TreeNode> searchForHeads(TreeNode rootNode, TreeNode 
												query) {
		// List to hold matching nodes
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		
		// Queue for BFS
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		
		// Start BFS by adding the rootNode to queue
		queue.add(rootNode);

		// BFS; Goes through all nodes in a tree
		while(queue.size() != 0) {
			// Remove first node in queue
			TreeNode removed = queue.poll();
			
			// If the first removed node is not null and matches the query, add
			// to the result list
			if (removed != null && removed.val == query.val) {
				result.add(removed);
			}

			// If the child nodes are not null, add them to the queue
			if (removed.left != null) {
				queue.add(removed.left);
			}
			if (removed.right != null) {
				queue.add(removed.right);
			}
		}

		return result;
	}

	/**
	 * Checks if treeA and treeB are equal
	 * 
	 * @param treeA is the first tree to check
	 * @param treeB is the second tree to check
	 * @return true if trees are equal, false otherwise
	 */
	public static boolean treesEqual(TreeNode treeA, TreeNode treeB) {
		// Queues for BFS
		LinkedList<TreeNode> queueA = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queueB = new LinkedList<TreeNode>();
		
		// Start BFS by adding head nodes to queues
		queueA.add(treeA);
		queueB.add(treeB);

		// BFS; Goes through nodes in both trees, until they do not match
		while(queueA.size() != 0 || queueB.size() != 0) {
			// Remove the first nodes from each queue
			TreeNode removedA = queueA.poll();
			TreeNode removedB = queueB.poll();
			
			// If either removed nodes were null or if they do not match, then
			// the trees are not equal, and return false
			if (removedA == null || removedB == null || removedB.val != 
				removedA.val) {
				return false;
			}
			
			// If the child nodes of the removed nodes are not null, add them to
			// the queue
			if (removedA.left != null) {
				queueA.add(removedA.left);
			}
			if (removedA.right != null) {
				queueA.add(removedA.right);
			}
			if (removedB.left != null) {
				queueB.add(removedB.left);
			}
			if (removedB.right != null) {
				queueB.add(removedB.right);
			}
		}

		return true;
	}
}


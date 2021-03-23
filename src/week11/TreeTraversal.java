package week11;

class TreeNode{
	Object data;
	TreeNode left;
	TreeNode right;
	
}

class LinkedTree{
	private TreeNode root;
	
	public TreeNode createBT() {
		root = null;
		return root;
	}
	
	public boolean isEmpty(TreeNode bt) {
		if(bt==null)
			return true;
		else return false;
	}
	
	public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) {
		TreeNode root = new TreeNode();
		root.data = data;
		root.left = bt1;
		root.right = bt2;
		return root;
	}
	
	public TreeNode leftSubtree(TreeNode bt) {
		if(isEmpty(bt))
			return null;
		else return bt.left;
	}
	
	public TreeNode rightSubtree(TreeNode bt) {
		if(isEmpty(bt))
			return null;
		else return bt.right;
	}
	
	public Object data(TreeNode bt) {
		if(isEmpty(bt))
			return null;
		else 
			return bt.data;
	}
	
	public void inorder(TreeNode root) {
		
		if(root!=null) {
			inorder(root.left);
			System.out.printf("%c", root.data);
			inorder(root.right);
		}
	}


public void makeArrayBT(TreeNode root) {
	Object [] arr = new Object [10];

	arrayBT(arr, root, 1);
	
	for(int i=0; i<10; i++) {
		System.out.println(i+" : " + arr[i]);
	}
}

private void arrayBT(Object[] arr, TreeNode root, int i) {
	if(root!=null) {
		arrayBT(arr, root.left, i*2);
		arr[i] = root.data;
		arrayBT(arr, root.right, i*2+1);
	}
}

}


public class TreeTraversal {

	public static void main(String args[]) {
	LinkedTree T = new LinkedTree();
	
	TreeNode n7 = T.makeBT(null, 'D', null);
	TreeNode n6 = T.makeBT(null, 'C', null);
	TreeNode n5 = T.makeBT(null, 'B', null);
	TreeNode n4 = T.makeBT(null, 'A', null);
	TreeNode n3 = T.makeBT(n6, '/', n7);  // C/D
	TreeNode n2 = T.makeBT(n4, '*', n5);  // A*B
	TreeNode n1 = T.makeBT(n2, '-', n3);  // (A*B)-(C/D)
	
	System.out.println("\n LinkedList Inorder : ");
	T.inorder(n1);
	
	System.out.println();
	T.makeArrayBT(n1);
	}
	

}

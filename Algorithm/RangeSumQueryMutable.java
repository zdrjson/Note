class SegmentTreeNode {
		int start;
		int end;
		int sum;
		SegmentTreeNode left;
		SegmentTreeNode right;
		public SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right) {
                   this.start = start;
		   this.end = end;
		   this.sum = sum;
		   this.left = left;
		   this.right = right;
		}
}

class NumArray {
	int[] nums_;
	SegmentTreeNode root_;
	
	public NumArray(int[] nums) {
		if (nums != null) {
			nums_ = nums;
			root_ = buildTree(0, nums.length - 1);
		}
	}
	
	public void update(int i, int val) {
		
		updateTree(root_, i, val);
	}

	public int sumRange(int i, int j) {
		return sumRange(root_, i , j);
	}
	
	//helper 
	public SegmentTreeNode buildTree(int start, int end) {
		 if (start > end) {
			  return null;
		 }
		   
		if (start == end) {
			return new SegmentTreeNode(start, end, nums_[start], null , null);
		}
		int mid = start + (end - start) / 2;
		SegmentTreeNode left = buildTree(start, mid);
		SegmentTreeNode right = buildTree(mid + 1, end);
		return new SegmentTreeNode(start, end, left.sum + right.sum, left, right);
	}
	
	public void updateTree(SegmentTreeNode root, int i, int val) {
		 if (root == null) {
			   return;
		 }
		if (root.start == i && root.end == i) {
			root.sum = val;
			return;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (i <= mid) {
			updateTree(root.left, i , val);
		} else {
			updateTree(root.right, i , val);
		}
		root.sum = root.left.sum + root.right.sum;
	}
	
	public int sumRange(SegmentTreeNode root, int i, int j) {
		if (root.start == i && root.end == j) {
			return root.sum;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (j <= mid) {
			return sumRange(root.left, i, j);
		} else if (i > mid) {
			return sumRange(root.right, i, j);
		} else {
			return sumRange(root.left, i , mid) + sumRange(root.right, mid + 1, j);
		}
	}
}


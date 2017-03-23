package oj;

/**
 * Created by shiyueqi on 2016/7/26.
 */

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.

 * For example:
 * Given the below binary tree and sum = 22,
       5
      / \
     4   8
     /   / \
    11  13  4
   /  \      \
  7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(sum == 0){
            return true;
        }else if(sum < 0){
            return false;
        }

        if(root == null){
            return false;
        }

        boolean flag1 = hasPathSum(root.left, sum-root.val);
        boolean flag2 = hasPathSum(root.right, sum-root.val);

        return flag1 || flag2;
    }
}

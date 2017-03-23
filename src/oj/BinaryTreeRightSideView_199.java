package oj;

/**
 * Created by shiyueqi on 2016/7/25.
 */

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 * For example:
 * Given the following binary tree,
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * You should return [1, 3, 4].
 */

/**
 * TestCases:    1
 *              /\
 *            2   3
 *           /
 *         4
 * Output: 1,3,4
 */

import java.util.ArrayList;
import java.util.List;
public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        List<TreeNode> treeNodeList = new ArrayList<>();
        List<TreeNode> treeNodeListChildren = new ArrayList<>();

        treeNodeList.add(root);
        list.add(root.val);

        while (treeNodeList.size() > 0){
            for(int i=0; i<treeNodeList.size(); i++){
                if(treeNodeList.get(i).left != null){
                    treeNodeListChildren.add(treeNodeList.get(i).left);
                }
                if(treeNodeList.get(i).right != null){
                    treeNodeListChildren.add(treeNodeList.get(i).right);
                }
            }
            if(treeNodeListChildren.size() > 0){
                list.add(treeNodeListChildren.get(treeNodeListChildren.size()-1).val);
            }

            treeNodeList.clear();
            treeNodeList.addAll(treeNodeListChildren);
            treeNodeListChildren.clear();
        }

        return list;
    }

    public static void main(String[] args){
        BinaryTreeRightSideView_199 rightSideView = new BinaryTreeRightSideView_199();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;


        List<Integer> list = rightSideView.rightSideView(node1);
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

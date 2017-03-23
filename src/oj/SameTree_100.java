package oj;

/**
 * Created by shiyueqi on 2016/7/25.
 */

/**
 * Given two binary trees, write a function to check if they are equal or not.

 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */


import java.util.ArrayList;
import java.util.List;

public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (p != null && q == null)){
            return false;
        }else if(p == null && q == null){
            return true;
        }

        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();

        listP.add(p);
        listQ.add(q);

        while (listP.size() > 0 && listQ.size() > 0){
            if( listP.get(0).val != listQ.get(0).val ){
                return false;
            }

            if((listP.get(0).left != null && listQ.get(0).left == null) ||
                    (listP.get(0).left == null && listQ.get(0).left != null)){
                return false;
            }else if(listP.get(0).left != null && listQ.get(0).left != null){
                listP.add(listP.get(0).left);
                listQ.add(listQ.get(0).left);
            }

            if((listP.get(0).right != null && listQ.get(0).right == null) ||
                    (listP.get(0).right == null && listQ.get(0).right != null)){
                return false;
            }else if(listP.get(0).right != null && listQ.get(0).right != null) {
                listP.add(listP.get(0).right);
                listQ.add(listQ.get(0).right);
            }

            listP.remove(0);
            listQ.remove(0);
        }

        if(listP.size() != listQ.size())
            return false;

        return true;
    }

    public static void main(String[] args){
        TreeNode treeNodeP = new TreeNode(0);
        TreeNode treeNodeQ = new TreeNode(0);

        SameTree_100 sameTree_100 = new SameTree_100();
        boolean flag = sameTree_100.isSameTree(treeNodeP, treeNodeQ);
        System.out.println(flag);
    }
}

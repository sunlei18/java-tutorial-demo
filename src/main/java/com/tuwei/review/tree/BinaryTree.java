package com.tuwei.review.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    /**
     * 根据前序遍历和中序遍历的，重建二叉树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if(pre.length == 0 || in.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        for(int i=0;i<in.length;i++){
            if(in[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){

        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue != null){
            TreeNode node = queue.poll();
            arr.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return arr;
    }
}

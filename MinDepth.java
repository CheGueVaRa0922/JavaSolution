public class MinDepth {
    /*leetcode 111.二叉树的最小深度
        这题和最大深度差不多
        要取最小值
        但是我们要小心
        null的情况
        所以就要单独加
    */
    public int minDepth(TreeNode root) {
        return height(root);
    }
    public int height(TreeNode node){
        int res = 0;

        if(node == null) return res;
        int leftheight = 1 , rightheight = 1;
        if(node.left == null && node.right != null){
            rightheight = height(node.right) + 1;
            return rightheight;
        }
        if(node.left != null && node.right == null){
            leftheight = height(node.left) + 1;
            return leftheight;
        }
        leftheight = height(node.left) + 1;
        rightheight = height(node.right) + 1;
        res = Math.min(leftheight,rightheight);
        return res;
    }
}

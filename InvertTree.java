public class InvertTree {
    /*leetcode 226.翻转二叉树
        首先我们需要弄清楚，我要以何种顺序遍历这个二叉树让它翻转
        我们最直接的想法肯定就是每到一个根节点就翻转一下，然后取它的左右孩子继续反转
    */
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }
    public void reverse(TreeNode node){
        if(node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        reverse(node.left);
        reverse(node.right);

    }
}
}

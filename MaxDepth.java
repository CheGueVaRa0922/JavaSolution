public class MaxDepth {
    /*leetcode 104.二叉树的最大深度
       这题还是一样的，我估计还是采用后序遍历
       所以我们要不断地遍历左右节点
       如果有节点，那就往上加一，最高的高度就是最大深度
       要取最大值

       错误：
               还是没能正确理解leftheight的初始话
               因为我们前面已经剪枝了
               所以初始化就是1
   */
    public int maxDepth(TreeNode root) {
        return height(root);
    }
    public int height(TreeNode node){
        if(node == null) return 0;
        int height = 0;
        int leftheight = 1 , rightheight = 1;
        if(node.left != null){
            leftheight = height(node.left) + 1;
        }
        if(node.right != null){
            rightheight = height(node.right) + 1;
        }
        height = Math.max(leftheight,rightheight);
        return height;
    }
}

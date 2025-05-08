public class IsSymmetric {
    /*leetcode 101.对称二叉树
        对于这题我们要做的就是内侧比内侧，外侧比外侧
        然后这题我们应该采用后序遍历
        即左右都比完了，然后返回给中

        错误：
                还是不清楚这题的思路
                我们首先要弄清楚
                如果false是个什么情况
                true又是什么情况
                我们递归
                递归的对象是谁

    */
    public boolean isSymmetric(TreeNode root) {
        return is(root.left,root.right);
    }
    public boolean is(TreeNode left,TreeNode right){

        boolean res = false;
        if(left == null && right != null){
            return false;
        }
        else if(left != null && right == null){
            return false;
        }
        else if(left == null && right == null){
            return true;
        }
        else if(left.val == right.val){
            boolean outside = is(left.left,right.right);
            boolean inside = is(left.right,right.left);
            res = outside && inside;
        }

        return res;
    }
}

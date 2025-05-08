public class PostorderTraversal {
    /*leetcode 145.后序遍历
        这题的递归法，因为是是后序遍历，所以根节点的值最后加上
        所以把add放在最后
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
    public void postorder(TreeNode root,List<Integer> res){
        if(root == null) return;
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
    /*
        迭代法的核心就在于栈
        我们每次都要取左右孩子
        然后就是注意孩子的入栈顺序以及add的位置
        这题肯定用翻转最快
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            res.add(node.val);
            stack.pop();
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node != null){
                stack.pop();
                stack.push(node);
                stack.push(null);
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);

            }
            else{
                stack.pop();
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}

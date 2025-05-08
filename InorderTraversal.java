public class InorderTraversal {
    /*leetcode 94.中序遍历
        递归法，中序遍历，左中右，所以add放中间
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode root,List<Integer> res){
        if(root == null) return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    迭代法：
    中序遍历的话
            那就是左中右的顺序
    所以我们要不断地获取左孩子
    这题要用如果获取不到了，那就开始取值，看看左孩子有没有右孩子，这里可以做回到根节点
            的操作

    还是不懂捏，这题的迭代法还是太有难度了
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){

            if(node != null){
                stack.push(node);
                node = node.left;

            }
            else{
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        //我看null好像每次都是标记根节点
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node != null){
                stack.pop();
                if(node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
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

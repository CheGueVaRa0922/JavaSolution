public class PreorderTraversal {
    /*leetcode 144.前序遍历
            递归法的核心就是要确定好
            递归的对象是谁
            什么时候停止
            什么时候加元素
        */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;

    }
    public void preorder(TreeNode root,List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }

    /*
        对于迭代法的话，就需要用到栈
        因为是前序遍历，所以放入栈的顺序应该是
        右左中
        但是我们一开始肯定要把根节点放进去
        然后进入后再弹出
        然后根据它有没有左右孩子把它们放进来
        然后关于取值的话，那就是先取值再弹出呗，因为每次都是先取中
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            res.add(node.val);
            stack.pop();
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return res;
    }
    /*
        统一法的话就要用队列来做
        因为队列是先入先出
        所以就要更改一下顺序，要pop元素
        他妈的null标记，忘了
        中左右
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> queue = new Stack<>();
        if(root == null) return res;
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.peek();
            if(node != null){
                queue.pop();
                if(node.right != null) queue.push(node.right);
                if(node.left != null) queue.push(node.left);
                queue.push(node);
                queue.push(null);
            }else{
                queue.pop();
                node = queue.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}


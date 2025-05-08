public class LeverOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //leetcode 102.二叉树的层序遍历
        /*
            这题的大体思路就是用栈记录每一层元素的size
            然后取出对应数量的元素进行取值
            最后res.add
        */
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
}

public class SortedSquares2 {
    //leetcode 977.有序数组的平方
    /*思路：
            频繁改变数据
            因为原来的数组本身就是一个递增的数组
            所以就不需要一个个比，怕的就是左边的负数平方比较大
            所以从两头比起，谁更大就填上去就好了

            “这道题纠结了半天，就是没注意到非降序，有点傻逼，浪费了好多时间”

     */
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] ans = new int[nums.length];
        int pos = nums.length - 1;
        while(i<=j){
            if(nums[i] * nums[i] > nums[j] * nums[j]){
                ans[pos] = nums[i] * nums[i];
                i++;
            }
            else{
                ans[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return ans;
    }

}

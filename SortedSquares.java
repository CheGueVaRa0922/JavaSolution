class SortedSquares {
    //leetcode 977.有序数组的平方
    /*思路：
            高频改变数组
            我最开始的思路就是觉得这应该是个冒泡排序
            就觉得也挺符合双指针的，比较暴力
            因为这就很符合思维定式
            slow+1
            fast+1这种

     */
    public int[] sortedSquares(int[] nums) {
        int time = nums.length - 1;
        for(int i = time;i >= 0;i--){
            nums[i] = nums[i] * nums[i];
        }
        while(time >= 0){
            int slow = 0;
            for(int fast = 0;fast < nums.length - 1;fast++){
                if(nums[slow] >= nums[fast + 1]){
                    int temp = 0;
                    temp = nums[slow];
                    nums[slow] = nums[fast + 1];
                    nums[fast + 1] = temp;
                    slow++;

                }
            }
            time--;
        }
        return nums;
    }

}
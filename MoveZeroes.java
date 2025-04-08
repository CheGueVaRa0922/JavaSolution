class MoveZeroes {
    //leecode 283.移动零
    /*思路：
            高频改变数组
            利用双指针
            交换位置是一个很常用的技巧******
            我最初想的是就是一个个替换位置，也是快慢
            然后计算0的个数，再一个个填上去，不过时间复杂度稍微大一点


            错误：
                一定要注意使用for循环已经有fast++了
                slow++呢一定要放对位置，因为我放在了
                if{}后边导致数组压根没变化

     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for(int fast = 0;fast <= nums.length - 1;fast++){
            if(nums[fast] != 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }

        }
    }
}
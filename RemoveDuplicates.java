public class RemoveDuplicates {
    //leetcode.26删除有序数组的重复项
    /*思路：
            我个人现在觉得这种但凡涉及高频修改数组的题目
            就可以使用双指针

     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for(int fast = 0;fast <= nums.length - 1;fast++){
            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }

        }
        return slow + 1;
    }
}

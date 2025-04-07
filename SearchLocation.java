public class SearchLocation {
    //leetcode 35.搜索插入位置
    /*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    请必须使用时间复杂度为 O(log n) 的算法。
     */
    /*
    示例 1:
        输入: nums = [1,3,5,6], target = 5
        输出: 2
    示例 2:
        输入: nums = [1,3,5,6], target = 2
        输出: 1
    示例 3:
        输入: nums = [1,3,5,6], target = 7
        输出: 4
    提示:

        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums 为 无重复元素 的 升序 排列数组
        -104 <= target <= 104
     */
    /*思路：
            因为是二分法，所以先把公式先套上去。
            结论:
                ① middle == left || middle == right
                ② left = right + 1 (大多数最终结果)
            因为最后middle要么等于left 要么等于right
            既然是找插入位置，你放在left那个位置准没错
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                return mid;
            }
        }
        return left;
    }
}


public class Starend {
    //leetcode 34.在排序数组中查找元素的第一个和最后一个位置
    /*
    给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

    如果数组中不存在目标值 target，返回 [-1, -1]。

    你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

    示例 1：
        输入：nums = [5,7,7,8,8,10], target = 8
        输出：[3,4]
    示例 2：
        输入：nums = [5,7,7,8,8,10], target = 6
        输出：[-1,-1]
    示例 3：
        输入：nums = [], target = 0
        输出：[-1,-1]

    提示：
        0 <= nums.length <= 105
        -109 <= nums[i] <= 109
        nums 是一个非递减数组
        -109 <= target <= 109
     */
    /*思路：
            ①只有两种情况即 1.这数在里面 2.这数不在里面
            不在里边又可以分为比他们都大(小),或者不大不小
            所以就要分情况讨论
            但是其实最后二分都能把这两种情况分出来，所以不需要讨论2
            能算出来的在while里能走到else，不能的直接return了

          错误：
                有一次我把 start和end的边界搞错了
                写成了 start >= 0  end <= nums.length - 1
                这样会越界，导致假如有的范围在0位，start-- 变-1了
                有的end在num.length - 1位，end++变num.length越界
     */
    public int[] searchRange(int[] nums, int target) {
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
                int start = mid;
                int end = mid;
                while(start > 0 && nums[start - 1] == nums[mid]){
                    start--;
                }
                while(end < nums.length - 1 && nums[end + 1] == nums[mid]){
                    end++;
                }
                return new int [] {start,end};
            }
        }
        return new int [] {-1,-1};
    }
}

public class Intersection {
    //leetcode 349.两个数组的交集
    /*思路：
            因为我们需要快速判断一个数有没有出现
            所以会想到哈希方法
            然后呢正好有一个set.contains()这个方法就很好用
            所以我们这道题大体的思路就是
            把num1放入set里面，然后这个hashset会自动帮我们去重
            放进去之后呢，我用遍历num2
            看看num2里面有没有元素被contains在里面
            所有就可以得到所有的重复元素

     */
    public int[] intersection(int[] nums1, int[] nums2) {
        //把num1的书存到这个set里面
        //然后遍历num2看看有没有对应的
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[]{};
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> reSet = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        for(int i : nums2){
            if(set1.contains(i)){
                reSet.add(i);
            }
        }
        int [] arr = new int[reSet.size()];
        int index = 0;
        for(int i : reSet){
            arr[index++] = i;
        }
        return arr;
    }
}

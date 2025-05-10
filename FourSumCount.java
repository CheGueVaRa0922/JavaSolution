public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //leetcode 454.四数相加 II
        /*
            这题大体的一个思路就是算出1 2 的所有和 组合
            然后再算出3 4的和组合
            在1 2的组合里找有没有让他们之和等于0的数
            所以这题涉及到快速查找元素
            需要使用哈希法
            然后题目说要计算多少个
            所以用map比较好，可以计数

        */
        //错误：第4个循环写成了i < nums4.length, get的时候写成了 0 - i - j
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums1.length;i++){
            for(int j = 0;j < nums2.length;j++){
                int sum = nums1[i] + nums2[j];
                int value = map.getOrDefault(sum,0) + 1;
                map.put(sum,value);
            }
        }
        int time = 0;
        for(int i = 0;i < nums3.length;i++){
            for(int j = 0;j <nums4.length;j++){
                if(map.containsKey(0 - nums3[i] - nums4[j])){
                    time += map.get(0 - nums3[i] - nums4[j]);
                }
            }
        }
        return time;
    }
}

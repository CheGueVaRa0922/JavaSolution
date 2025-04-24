public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //leetcode 1.两数之和
        //大体思路就是，我们一个个遍历nums数组
        /*
            然后呢，遍历到一个数字，我们就找我们有没有遍历过target - nums[i];
            没有的话，就把当前这个东西放在哈希表里；
            因为我们需要得到元素的下标
            所以呢
            这题应该用map比较合适
            key就是对应的值，key的value就是下标
        */
        //错误：不记得用containsKey()
        if(nums.length == 0 || nums == null){
            return new int[]{};
        }
        int [] arr =new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            int distance = target - nums[i];
            if(map.containsKey(distance)){
                arr[0] = map.get(distance);
                arr[1] = i;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return arr;
    }
}

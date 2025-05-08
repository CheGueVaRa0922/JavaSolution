public class TopKFrequent {
    /*leetcode 347.前K个高频元素
        先用map存储每个元素出现的频率
        然后用一个pq存储
        如果size < k那就还能放
        如果大于pq那就给它放进来

        //错误：
                首先就是for那里，遍历map的entrySet没加括号
                队列弹出用成了pop，压入用成了push
                最后取元素也不会取
    */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int [] res = new int[k];
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2) -> (pair1[1] - pair2[1]));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(pq.size() < k){
                pq.add(new int[]{entry.getKey(),entry.getValue()});
            }
            if(entry.getValue()  > pq.peek()[1]){
                pq.poll();
                pq.add(new int[]{entry.getKey(),entry.getValue()});
            }
        }
        for(int i = 0;i < k;i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}

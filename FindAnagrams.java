public class FindAnagrams {
    //leetcode 438.找到字符串中所有字母异位词
    /*思路：
            这题大体的思路就是滑动窗口
            我觉得就是如果说要拿出一组组数来比较的话
            滑动窗口是个好办法
            大体的思路就是这样
            先算出s 和 p的长度
            然后呢，求出s的前p个长度的count，求出p的count
            然后如果他们相等的话就add(0)
            如果不相等就继续滑动窗口，删除第个元素的记录
            然后记下此时 i + p_len的元素(滑动了嘛，就是越过了中间几个元素)
            如果这个时候相等了，就add(i+1)
            因为这个时候初始位置已经变了，移了一格
    */
    public List<Integer> findAnagrams(String s, String p) {
        int s_len = s.length() , p_len = p.length();

        ArrayList<Integer> list = new ArrayList();
        if(s_len < p_len){
            return list;
        }
        int []count_s = new int[26] , count_p = new int[26];
        for(int i = 0;i < p_len;i++){
            count_s[s.charAt(i) - 'a']++;
            count_p[p.charAt(i) - 'a']++;
        }
        if(Arrays.equals(count_s,count_p)){
            list.add(0);
        }
        for(int i = 0;i < s_len - p_len;i++){
            count_s[s.charAt(i) - 'a']--;
            count_s[s.charAt(i + p_len) - 'a']++;
            if(Arrays.equals(count_s,count_p)){
                list.add(i + 1);
            }
        }
        return list;
    }
}

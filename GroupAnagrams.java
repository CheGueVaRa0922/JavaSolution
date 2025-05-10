public class GroupAnagrams {
    //leetcode 49.字母异位词分组
    /*思路：
            这题大体大体的思路就是什么呢
            就是创建一个哈希map
            key和value对应的
            然后呢
            我们去取出strs里的每一个str
            取完之后，就记录它的count
            然后根据它的count我们生成一个动态的字符组
            最后就变成了类似于a1b1c2这种字符串
            然后我们把这个key放在map里面，没有的话就创建一个，这个key就对应一个list
            然后以此类推，如果后续key相同的话，就在list.add()上这个str

            错误：
                    1.sb.append((char)i + 'a')写错了
                    2.List的定义也有问题List list = map.getOrDefault(key,List<String>);
                    3.put也有问题put(key,str)
                    4.最后return也有问题ArrayList(List<String>).(map.values)


    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str : strs){
            int []count = new int[26];
            for(int i = 0;i < str.length();i++){
                count[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i < 26;i++){
                if(count[i] != 0){
                    sb.append((char)(i + 'a'));//
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key,new ArrayList<String>());//
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

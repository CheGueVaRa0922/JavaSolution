public class IsAnagram {
    //leetcode 242.有效的字母异位词
    /*思路：
            这题怎么说呢，如果按照卡尔的说法
            要快速寻找一个元素就用哈希表
            其次就是一般会用数组，map，set这三种
            如果数组范围可控，就是比较小，就建议用数组
            比较大就用set
            key -> value 就用map，先这么大致理解吧，这些我还不理解

            这题的思路就是创建一个count数组
            然后呢利用ASCII相对位置
            就比如b和a码的位置相差一
            所以这个时候从字符串取出一个元素然后与a相减
            就可以得到对应count位置+1，可以记录这个位置有多少个字母
            然后遍历完第一个++
            第二个就--
            如果他们相同，count里面所有元素就都是0

            错误:
                    1.字符串取元素是.charAt()
                    2.字符串取长度不是.size(),是.length()

     */
    public boolean isAnagram(String s, String t) {
        int []count = new int[26];
        for(int i = 0;i < s.length();i++){
            count[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i < t.length();i++){
            count[t.charAt(i) - 'a']--;
        }
        for(int i = 0;i < 26;i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}

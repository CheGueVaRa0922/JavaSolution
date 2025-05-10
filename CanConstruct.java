public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        //leetcode 383.赎金信
        //我倒是还有map的方案，不过数组更优就是
        /*
            大体思路应该是这样
            记录rans的count，然后遍历rans的字母
            记录magazine的count
            然后遍历rans的字母
            比比看两个数组的对应元素多少
        */
        int []r_count = new int [26] , m_count = new int [26];
        for(int i = 0;i < ransomNote.length();i++){
            r_count[ransomNote.charAt(i) - 'a']++;
        }
        for(int i = 0;i < magazine.length();i++){
            m_count[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0;i < ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(r_count[c - 'a'] > m_count[c - 'a']){
                return false;
            }
        }
        return true;
    }
}

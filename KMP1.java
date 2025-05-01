public class KMP1 {
    //leetcode 28.找出字符串中第一个匹配项的下标
    /*思路：
        大体思路就是先求出needle的next数组
        再和haystack进行对比
        细节：
                关于next不相等的情况
                记住一定是while
                然后就是剪枝记得

        错误：
                生成next数组的时候应该谨记，
                每次循环过后，我需要给next赋值
    */
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return -1;
        }
        int []next = new int [needle.length()];
        form(next,needle);
        int j = 0;
        for(int i = 0;i < haystack.length();i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }

            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return i - needle.length() + 1;
            }

        }
        return -1;
    }
    public void form(int []next,String needle){
        int j = 0;
        next[0] = 0;
        for(int i = 1;i < needle.length();i++){
            while(j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(needle.charAt(i) == needle.charAt(j)){
                j++;

            }
            next[i] = j;
        }
    }
}

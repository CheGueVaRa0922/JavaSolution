public class ReverseStr {
    //leetcode 541.反转字符串II
    /*思路：
            这题有点反套路化
            一般都是i++
            然后呢
            这题大体思路就是
            每次都是i += 2 * k
            如果剩下的元素大于等于k个的话
            那就自然的Reverse
            如果不够的话
            那就全都Reverse
            然后我们需要保证
            执行了第一个reverse不会执行第二个Reverse
            所以就需要continue

    */
    //错误：2 * k老是简写成2k
    public String reverseStr(String s, int k) {
        char [] ch = s.toCharArray();
        for(int i = 0;i < ch.length;i += 2 * k){
            if(i + k < ch.length){
                reverse(ch,i,i + k);
                continue;
            }
            reverse(ch,i,ch.length);
        }
        return new String(ch);
    }
    public void reverse(char [] ch,int start,int end){
        for(int left = start , right = end - 1;left < right;left++ , right--){
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
        }
    }
}

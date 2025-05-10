public class ReverseWords {
    //leetcode 151.反转字符串
    /*思路：
           大体的思路就是
           先去掉多余的空格
           然后翻转整个字符串
           然后再将每一个单词都翻转

           去除多余的空格很有讲究
           只要slow != 0 就要在当前位置生成一个space然后迭代
           因为这是由后期他俩双指针的性质决定的

           然后在最后处理每一个单词的翻转
           要确保最后一个单词能被翻转到
           这个时候就有不同了
           fast 是 <= ch.length
           这个时候就作为一个标志点
           可以让最后一个单词得到翻转
    */
    /*
        去除多余空格
        将整个字符串反转
        将每个单词反转

        错误：
                还是不会resize
                不知道要用原来的ch接受去掉空格的ch
                最后的翻转每个单词还是有点问题
    */

    public String reverseWords(String s) {
        char [] ch = s.toCharArray();
        ch = removespace(ch);
        reverse(ch,0,ch.length - 1);
        reverseEachWord(ch);
        return new String(ch);
    }
    public char[] removespace(char [] ch){
        int slow = 0;
        for(int fast = 0;fast < ch.length;fast++){
            if(ch[fast] != ' '){
                if(slow != 0){
                    ch[slow] = ' ';
                    slow++;
                }
                while(fast < ch.length && ch[fast] != ' '){
                    ch[slow++] = ch[fast];
                    fast++;
                }
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(ch, 0, newChars, 0, slow);
        return newChars;
    }
    public void reverseEachWord(char [] ch){
        int slow = 0;
        for(int fast = 0;fast <= ch.length;fast++){
            if(fast == ch.length || ch[fast] == ' '){
                reverse(ch,slow,fast - 1);
                slow = fast + 1;
            }
        }
    }
    public void reverse(char [] ch,int start,int end){
        for(int left = start , right = end;left < right;left++,right--){
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
        }
    }
}

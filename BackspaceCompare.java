class BackspaceCompare {
    //leetcode 844.比较含退格的字符串
    /*思路：
            这题相对来书还是比较难写
            设计两个对象的比较
            整体的代码思路就是这样的
            上面的while部分呢取出一个字符然后拿下来比
            （其中的while部分细则就是可以跳过被退格掉的字符）
            然后不相等肯定是false了
            最后的else是可以提取出那种越界的情况
            有一方越界，一方还有东西
            肯定就不相等了
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skips = 0;
        int skipt = 0;
        while(i >= 0 || j >= 0){
            while(i >= 0){
                if(s.charAt(i) == '#'){
                    skips++;
                    i--;
                }
                else if(skips > 0){
                    skips--;
                    i--;
                }
                else{
                    break;
                }
            }
            while(j >= 0){
                if(t.charAt(j) == '#'){
                    skipt++;
                    j--;
                }
                else if(skipt > 0){
                    skipt--;
                    j--;
                }
                else{
                    break;
                }
            }
            if(i >= 0 && j>= 0){
                if(s.charAt(i) != t.charAt(j)){
                    return false;
                }
            }
            else{
                if(i >= 0 || j>= 0){
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
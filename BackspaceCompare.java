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

            第二次做有感：
                        还是挺有手感的，差点就不看答案写对了，break那里应该相信自己的
                        整体的思路还是一样，如果跳完了，就把一个字符拿下来比

                        错误点：
                                ①i和j就是要 >= 0 不然的话会少比，最开头的没法比
                                就比如i=0 , j = -1了
                                但是这个时候我写成了i>0 || j>0
                                这样少比了东西
                                ②然后就是判断后面长度大小的问题，就是我要把比长度放在前面，这样不会导致越界
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

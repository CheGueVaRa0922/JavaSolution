public class Ishappy {
    //leetcode 202.快乐数
    /*思路：
        因为这道题有这么一个特征
        就是如果最后n=1了，那就是happy，但是你要想到
        一个数拆分成几个数的平方再求和
        它的组合就是有限的
        所以就会出现重复的结果
        一旦出现重复的结果
        就说明这个数到不了happy
        然后我们就需要判断是否重复，快速查找一个元素对吧
        所以这题用set比较好，大的用set就比较好
        
     */

    public boolean isHappy(int n) {
        //因为这几个数拆分之后的平方和终究的组合还是有限的，所以sum会重复出现
        //大体思路就是把它丢进去，如果最后结果是1了，或者说重复了就出来
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = ok(n);

        }
        return n == 1;
    }
    public int ok(int n){
        int ans = 0;
        while(n > 0){
            int temp = n % 10;
            ans += temp * temp;
            n = n / 10;
        }
        return ans;
    }
}

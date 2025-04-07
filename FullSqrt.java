public class FullSqrt {
    public boolean isPerfectSquare(int num) {
        //leetcode 367.有效的完全平方数
        /*
        给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。

        完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。

        不能使用任何内置的库函数，如  sqrt 。

        示例 1：
            输入：num = 16
            输出：true
            解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
        示例 2：
            输入：num = 14
            输出：false
            解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。


        提示：
            1 <= num <= 231 - 1
         */
        /*思路：首先还是“分情况”
                    ①算得出
                    ②算不出
          二分肯定可以做，我就是得保证我的二分能把这些规则一点的完全平方
          给他算出来对吧
          所以目的就是保证算法的正确性
          这样算不出来的直接return false
          还是老样子，分析最终结果，找个数据代入我们的算法呗
          算出来了就成功了

         */
        int left = 0;
        int right = num;
        while(left <= right){
            int mid = left + (right - left)/2;
            if((long) mid * mid > num){
                right = mid - 1;
            }
            else if((long) mid * mid < num){
                left = mid + 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}

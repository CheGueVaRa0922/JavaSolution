public class Sqrt {
    //leetcode 69.x的平方根
    /*
    给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

    由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

    注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

    示例 1：
        输入：x = 4
        输出：2
    示例 2：
        输入：x = 8
        输出：2
    解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。

    提示：
        0 <= x <= 231 - 1
     */
    /*思路：
        分情况：只有两种情况
                ①能被精确算出
                ②不能被精确算出
                能精确的已经被二分给囊括了
                所以我们讨论不能被精确算出的
                我的一个经验是，分析过程没有用，要分析结果
                所以我们分析大多数结果的最后时刻
                因为我们知道走出循环后
                right + 1 = left
                变到这最后一步之前只会有两种情况
                left = mid + 1
                right = mid - 1
                然后我们随便找两个数对应着最后两种情况
                一代入，发现最后算数平凡根都等于right
            错误：
                注意mid * mid 可能会很大，所以利用long防止过大
                第二次犯错：还是没用long
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while(left <= right){
            int mid = left + (right - left)/2;
            if((long) mid * mid > x){
                right = mid - 1;
            }
            else if((long) mid * mid < x){
                left = mid + 1;
            }
            else{
                return mid;
            }
        }
        return right;
    }
}

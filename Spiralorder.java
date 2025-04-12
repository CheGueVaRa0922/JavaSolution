import java.util.ArrayList;
import java.util.List;

public class Spiralorder {
    //leetcode 54.螺旋矩阵
    /*思路：
            这道题十分适合四边界来解题
            宏观的一个思路就是这样的
            一次转一个边界，
            前两个到头了就换下一个
            后两个到倒数第二个就换下一个
            最需要考虑的就是下和左边界，因为不是每次循环都会有下和左的更新
            就比如最后那一段
            现在依我看，我这也是拙见，我还是未能彻底理解右边界
            以我现在来看，上边界每个循环必定会执行，剩下三个是不一定的，有边界我觉得也要加上判定条件
            但是可以被省略，因为它自己的for循环就决定了它可以不写这个if判断
            判断这个for循环到底要不要开始

            这题还算是比较好了，不用费心处理越界的问题，动态数组好啊

            错误：
                 老是忘了这种左闭右闭迭代的元素应该是边界+1开始才对


     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<Integer>();
        int rows = matrix.length , columns = matrix[0].length;
        int left = 0 , right = columns - 1 , top = 0 , bottom = rows - 1;
        int row = 0 , column = 0;

        while(top <= bottom && left <= right){
            for(column = left;column <= right;column++){
                arr.add(matrix[top][column]);
            }
            for(row = top + 1;row <= bottom;row++){
                arr.add(matrix[row][right]);
            }
            if(top < bottom && left < right){
                for(column = right - 1;column > left;column--){
                    arr.add(matrix[bottom][column]);
                }
                for(row = bottom;row > top;row--){
                    arr.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;

        }
        return arr;
    }
}

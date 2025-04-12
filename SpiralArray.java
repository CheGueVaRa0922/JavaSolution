public class SpiralArray {
    //leetcode LCR 146.螺旋遍历二维数组

    /*思路：
            这一题与上一题基本相同吧
            我做这题的历程就是老出边界问题
            因为是静态数组
            所以不太好搞
            其实想来想去还是边界出了问题，条件判断不清晰
            错主要就错在下和左边界
            这两个边界就是捆绑的
            无独有偶
            肯定会一起发生
            我们就要思考，在什么情况下，在什么事件的基础上，这两个边界才会更新
            首先那肯定是下边界：左边界要小于右边界，你得要有地方给其他元素填进去
            对于左边界：上边界肯定要小于下边界
            最后还有一个大大前提，下边界如何才能执行还需要 上 <下
            左边界也一样，你肯定要左小于右才能有左边界更新
            最后这两个边界的if可以合成同一个，然后包住这最后两个边界

     */
    public int[] spiralArray(int[][] array) {
        if(array == null || array.length == 0){
            return new int []{};
        }
        int rows = array.length , columns = array[0].length;

        int [] arr = new int[rows * columns];
        int left = 0 , right = columns - 1 , top = 0 , bottom = rows - 1;
        int row = 0 ,column = 0;
        int count = 0;
        while(left <= right && top <= bottom){
            if(left <= right){
                for(column = left;column <= right;column++){
                    arr[count++] = array[top][column];
                }
            }
            if(top < bottom && left <= right){
                for(row = top + 1;row <= bottom;row++){
                    arr[count++] = array[row][right];
                }
            }
            if(left < right && top <bottom){
                for(column = right - 1;column > left;column--){
                    arr[count++] = array[bottom][column];
                }
            }
            if(left < right && top < bottom){
                for(row = bottom;row > top;row--){
                    arr[count++] = array[row][left];
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

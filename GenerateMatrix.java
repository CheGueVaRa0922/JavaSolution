public class GenerateMatrix {
    //leetcode 59.螺旋矩阵 II
    /*思路：
            我觉得这种题的核心就是在于边界问题
            之前本来可以设四个边界为boundary的
            后来发现，其实设四个边界还是比较好
            对于这类题四边界就统一了做题方式
            boundary的做法就是左闭右开，末尾的交给下一个循环去处理
            因为这道题是规整的正方形，所以不需要考虑太多的边界问题
            四边界的做法就是把boundary改成了边界，本质上没有差别
            还是左闭右开
            最后如果是奇数的话，补齐最后一个元素就可以

            错误：
                1.老是忘记边界的迭代
                2.对于奇数的最后一个元素，其实n/2就好了，没必要再加1，触发边界问题了

     */
    public int[][] generateMatrix(int n) {
        int top = 0 , bottom = n - 1 , left = 0 , right = n - 1;
        int time  = 1;
        int [][]arr = new int[n][n];
        int start_x = 0 , start_y = 0;
        int count = 1;
        int column = 0 , row = 0;
        while(time <= n/2){
            for(column = start_y;column < right;column++){
                arr[start_x][column] = count++;
            }
            for(row = start_x;row < bottom;row++){
                arr[row][column] = count++;
            }
            for(;column > left;column--){
                arr[bottom][column] = count++;
            }
            for(;row > top;row--){
                arr[row][left] = count++;
            }
            top++;
            bottom--;
            left++;
            right--;
            time++;
            start_x++;
            start_y++;

        }
        if(n % 2 == 1){
            arr[n / 2][n / 2] = n * n;
        }
        return arr;
    }
}

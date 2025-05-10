import java.util.Scanner;

public class Solid {
    //卡码网 44.土地开放商购买土地
    /*思路：
            还是前缀和的内容
            然后就是我觉得要把代码分成好几个模块

            逐个模块利用代码完成我们想要的功能
            

     */
    public static void main(String []args){
        //初始化土地
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        int[][] arr = new int[n][m];
        for(int i = 0;i <= n - 1;i++){
            for(int j = 0; j <= m-1;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        //算出每行每列之和
        int[] p_x = new int[n];
        int[] p_y = new int[m];
        int sum_x = 0 ,sum_y = 0;
        //算行
        for(int i = 0;i <= n - 1;i++){

            for(int j = 0; j <= m - 1;j++){
                sum_x += arr[i][j];
            }
            p_x[i] = sum_x;
        }
        for(int j = 0;j <= m - 1;j++){

            for(int i = 0;i <= n - 1;i++){
                sum_y += arr[i][j];
            }
            p_y[j] = sum_y;
        }
        int result = Integer.MAX_VALUE;
        //横着找
        for(int i = 0;i < n - 1;i++){
            int distance = 0;
            if((p_x[n - 1] - p_x[i]) - p_x[i] > 0){
                distance = (p_x[n - 1] - p_x[i]) - p_x[i];
            }
            else{
                distance = p_x[i] - (p_x[n - 1] - p_x[i]);
            }


            result = Math.min(result,distance);
        }
        for(int j = 0;j < m - 1;j++){
            int distance = 0;
            if((p_y[n - 1] - p_y[j]) - p_y[j] > 0){
                distance = (p_y[n - 1] - p_y[j]) - p_y[j];
            }
            else{
                distance = p_y[j] - (p_y[n - 1] - p_y[j]);
            }

            result = Math.min(result,distance);
        }
        System.out.println(result);
    }
}

import java.util.Scanner;

public class Presum {
    //卡码网 58.区间和
    /*思路：
            对于这种需要求数组前边和的就可以采用前缀和

            知道这个思路就可以
            剩下的套用我们的框架
            多问问自己
            我们需要遍历哪些元素？
            我们需要再什么时候迭代？

     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int presum = 0;
        int [] p = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
            presum += arr[i];
            p[i] = presum;
        }

        while(sc.hasNextInt()){
            int left = sc.nextInt();
            int right = sc.nextInt();
            int sum = 0;
            if(left == 0){

                sum = p[right];

            }
            else{

                sum = p[right] - p[left - 1];

            }
            System.out.println(sum);
        }
        sc.close();

    }
}

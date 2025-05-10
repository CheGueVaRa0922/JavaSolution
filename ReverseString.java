public class ReverseString {
    //leetcode 344.反转字符串
    /*思路：
            这题很经典，因为要移动两个元素
            很自然会想到双指针
    */
    public void reverseString(char[] s) {
        for(int left = 0 , right = s.length - 1;left < s.length / 2;left++ , right--){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}

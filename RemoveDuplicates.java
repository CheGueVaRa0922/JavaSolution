public class RemoveDuplicates {
    /*leetcode 1047.删除字符串中的素有相邻重复项
       创建一个sb
       如果sb里面元素为空就放进去新的
       新的要是和旧的一样，就把旧的弹出来

       错误：
               一开始用了栈
               其实只要用sb就好
   */
    public String removeDuplicates(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < s.length();i++){
            if(sb.isEmpty() || sb.charAt(sb.length() - 1) != s.charAt(i)){
                sb.append(s.charAt(i));
            }
            else{
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return new String(sb);
    }
}

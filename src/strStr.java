class Solution {
    public int strStr(String haystack, String needle) {
//        定义双指针i,j分别指向两个字符串的第一个字符
//        判断haystack[i]是否与needle[j]相等
//        如果相等i+1,j=0，i指针向后移一位，j重新指向needle的第一位
//        循环终止条件
//        1.haystack剩余长度小于needle字符长度
//        2.needle所有字符与haystack全部匹配完毕（判断j与needle的长度相等，表示needle所有字符都已匹配返回匹配），返回i-j，既needle字符在haystack开始的位置
//        3.如果没有任何匹配，返回-1
//        4.如果needle为空，则在第一次存货进入j==needle.length()中，返回0
        for (int i = 0; i < (haystack.length() - needle.length() + 1); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    i = i - j;
                    break;
                } else {
                    i++;
                }
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.strStr("abcde", ""));
    }
}
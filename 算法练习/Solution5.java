/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution5 {

    public static void main(String[] args) {
//        System.out.println(new Solution5().longestPalindrome("level"));
//        System.out.println(new Solution5().longestPalindrome("noon"));
//        System.out.println(new Solution5().longestPalindrome("cacsabaaba"));
//        System.out.println(new Solution5().longestPalindrome("cbbd"));
        System.out.println(new Solution5().longestPalindrome("ac"));
    }
    /*
        1、全相等，不计长度取最长
        2、开头与结尾相同
        3、长度为偶数时只有全相等，基数则会出现回文子串
        level noon
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        // 首先从子串中找出成对的子串
        int len = s.length();
        int i = 0, l;
        String tempStr = "";
        String max = String.valueOf(s.charAt(i));
        int iCh, lastCh; // iCh = i下标的字符，lastCh = 从末端依次遍历过来的字符
        while (i < len) {
            l = len - 1;
            iCh = s.charAt(i);
            while ((l - i) > 0) {
                lastCh = s.charAt(l);
                if (iCh == lastCh) {
                    tempStr = s.substring(i, l + 1);
//                    System.out.println("发现首位相等的子串，判断是否是回文子：" + tempStr);
                    // 检查是否是回文子串
                    if (validateRollBack(tempStr)) {
//                        System.out.println("是回文子,长度:" + tempStr.length());
                        if (tempStr.length() > max.length()) {
                            max = tempStr;
                            if (max.length() == s.length()) {
                                return max;
                            }
                        }
                    } else {
//                        System.out.println("不是回文子。");
                    }
                }
                l--;
            }
            i++;
        }
        return max;
    }

    public boolean validateRollBack(String s){
        int start = 0;
        int end = s.length() - 1;
        boolean isRollbackStr = true;
        while (start != end && (end - start) > 0) {
            if (s.charAt(start) != s.charAt(end)) {
                isRollbackStr = false;
                break;
            }
            start++;
            end--;
        }
        return isRollbackStr;
    }


}

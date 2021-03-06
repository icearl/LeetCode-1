/**
 * 第87题
 *  Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

    Below is one possible representation of s1 = "great":

            great
           /    \
         gr    eat
        / \    /  \
       g   r  e   at
      / \
     a   t

    To scramble the string, we may choose any non-leaf node and swap its two children.

    For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

            rgeat
          /    \
         rg    eat
        / \    /  \
       r   g  e   at
                 / \
                a   t

    We say that "rgeat" is a scrambled string of "great".

    Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

             rgtae
            /    \
          rg    tae
          / \    /  \
         r   g  ta  e
               / \
              t   a

    We say that "rgtae" is a scrambled string of "great".

    Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * Created by zhaoshiqiang on 2017/7/16.
 */
//区间动态规划的升级版，需要用一个三维数组来存储中间状态
//参考博客：http://blog.csdn.net/ljiabin/article/details/44537523
public class Scramble_String {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        //表示从s1的第i个字符开始长度为len的子串，和从s2的第j个字符开始长度为len的子串，是否互为scramble。
        boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length() + 1];
        //初始化转移方程，确定len为1状态
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        //确定计算顺序，len从2开始到s.length，i，j分别从0开始，到s1.length() - len + 1
        for (int len = 2; len <= s1.length(); len++) {
            for (int i = 0; i < s1.length() - len + 1; i++) {
                for (int j = 0; j < s2.length() - len + 1; j++) {
                    for (int k = 1; k < len; k++) {
                        dp[i][j][len] |= dp[i][j][k] && dp[i + k][j + k][len - k] || dp[i][j + len - k][k] && dp[i + k][j][len - k];
                    }
                }
            }
        }

        return dp[0][0][s1.length()];
    }
}

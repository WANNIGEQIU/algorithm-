package com.im.alg.code;

import com.sun.tools.javac.Main;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code3 {
    /**
     * 利用map处理,设置个start 记录起始索引,和max记录总长数判断集合中是否存在
     * 相同元素,存在存入map更新max值,遇到重复元素将start索引值右移动
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashMap = new HashMap<>(16);
        int start = 0;
        int max = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                start = Math.max(start,hashMap.get(s.charAt(i)) + 1);
            }
                hashMap.put(s.charAt(i), i);
                max = Math.max(i - start + 1, max);

        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(121 % 10);
    }


}

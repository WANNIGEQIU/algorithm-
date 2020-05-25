package com.im.alg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lesson1 {
    /**
     * O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1 || nums == null) throw new IllegalArgumentException();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("没有符合条件的俩数之和");
    }

    /**
     * 利用map 降低时间复杂度 k -存储元素, v -存储索引
     * 判断map中是否存入目标元素,没有放入map中,有返回下标索引
     *
     * @param ints
     * @param target
     * @return
     */
    public int[] twoSum2(int[] ints, int target) {
        if (ints.length <= 1 || ints == null) throw new IllegalArgumentException();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            int n = target - ints[i];
            if (hashMap.containsKey(n)) {
                return new int[]{i, hashMap.get(n)};
            } else {
                hashMap.put(ints[i], i);
            }
        }
        throw new IllegalArgumentException("没有符合条件的俩数之和");
    }
}

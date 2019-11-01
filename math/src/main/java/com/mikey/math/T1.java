package com.mikey.math;

import java.util.HashMap;

/**
 *  两数之和
 *  给定一个整数数组 nums 和一个目标值 target，
 *  请你在该数组中找出和为目标值的那 两个 整数，
 *  并返回他们的数组下标。
 */
public class T1 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && map.get(tmp) != i) {
                return new int[]{i, map.get(tmp)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{i, map.get(tmp)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum4(int[] nums, int target) {
        if (nums == null)
            return null;
        int max = 2047;
        int[] res = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            int ldiff = (target - nums[i]) & max;
            if (res[ldiff] != 0) {
                return new int[]{res[ldiff] - 1, i};
            }
            res[nums[i] & max] = i + 1;
        }

        return new int[2];
    }
}

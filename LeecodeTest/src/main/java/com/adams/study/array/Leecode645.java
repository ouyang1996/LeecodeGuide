package com.adams.study.array;

import java.util.Arrays;

/**
 * @time: 2021/7/29 19:42
 * @description:集合 s 包含从 1 到 n的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
*               给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *              请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *              eg1.输入：nums = [1,2,2,4]
 *                  输出：[2,3]
 *              eg2.输入：nums = [1,1]
 *                  输出：[1,2]
 * @version: 1.0
 * @author: ouyang
 */
public class Leecode645 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,8,10,11,12,13};
        System.out.println(Arrays.toString(findRepeatNumber(nums)));
    }

    public static int[] findRepeatNumber(int[] nums){
        int[] returnArray = new int[2];
        int length = nums.length;
        int[] hash = new int[length];
        for (int num : nums) {
            hash[num-1]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0){
                returnArray[1] = i+1;
            }
            if (hash[i] == 2){
                returnArray[0] = i+1;
            }
        }
        return returnArray;
    }
}

package com.adams.study.array;

import java.util.Arrays;

/**
 * @Author :adams_ou
 * @Description :给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * 注意:
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * @Date :Create in 22:09 2020/7/25
 */
public class Leecode628 {

    public static void main(String[] args) {
        int[] nums = {-3,4,2,-1,};
        System.out.println(maximumProduct(nums));
    }

    /**
     * 方法一：排序
     * 我们将数组进行升序排序，如果数组中所有的元素都是非负数，那么答案即为最后三个元素的乘积。
     * 如果数组中出现了负数，那么我们还需要考虑乘积中包含负数的情况，显然选择最小的两个负数和最大的一个正数是最优的，即为前两个元素与最后一个元素的乘积。
     * 上述两个结果中的较大值就是答案。注意我们可以不用判断数组中到底有没有正数，0 或者负数，因为上述两个结果实际上已经包含了所有情况，最大值一定在其中。
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums){
        Arrays.sort(nums);
        //结果就两种,一种是负数(三个负数,就按三个最大的负数取就行,两个正数,一个负数,也是取三个最大的数,这种情况很难出现,除非只有3个数)
        // 一种是正数(三个正数,按升序取最后三个,两个负数,一个正数,取两个最小负数,一个最大正数)
        return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }

    /**
     * 方法二：线性扫描
     * 在方法一中，我们实际上只要求出数组中最大的三个数以及最小的两个数，因此我们可以不用排序，用线性扫描直接得出这五个数。
     * @param nums
     * @return
     */
    public static int maximumProduct1(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

}

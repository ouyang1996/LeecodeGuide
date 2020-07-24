package com.adams.study.array;

/**
 * @Author :adams_ou
 * @Description :Leecode485题:最大连续1的个数
 *              给定一个二进制数组， 计算其中最大连续1的个数。
 *              输入: [1,1,0,1,1,1]
 *              输出: 3
 *              解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 *              注意:输入的数组只包含 0 和1。
 *                  输入数组的长度是正整数，且不超过 10,000。
 * @Date :Create in 20:58 2020/7/21
 */
public class Leecode485 {
    public static void main(String[] args) {
        Leecode485 leecode485 = new Leecode485();
        int[] nums = new int[10000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random()+0.9);
        }
        //new int[]{0,1,1,1,1,1,1,0})
        System.out.println(leecode485.findMaxConsecutiveOnes2(nums));
    }

    /**
     * 用一个计数器 count 记录 1 的数量，另一个计数器 maxCount 记录当前最大的 1 的数量。
     * 当我们遇到 1 时，count 加一。
     * 当我们遇到 0 时：
     *   将 count 与 maxCount 比较，maxCoiunt 记录较大值。
     *   将 count 设为 0。
     * 返回 maxCount。
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i=0;i<nums.length;i++){
            if (nums[i] == 1) {
                count += 1;
            }else {
                maxCount = Math.max(count,maxCount);
                count = 0;
            }
        }
        return Math.max(count,maxCount);
    }

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        int front = 0;
        int last = 0;
        int maxCount = 0;
        while (last < nums.length) {
            if (nums[last] == 1) {
                last ++;
            }
            /** 若出现0 保存当前最大连续值 重置指针*/
            else {
                maxCount = Math.max(maxCount, last - front);
                front = last + 1;
                last = front;
            }
        }
        /** 判断最后的连续值是否是最大值 */
        maxCount = Math.max(maxCount, last - front);
        return maxCount;
    }

}


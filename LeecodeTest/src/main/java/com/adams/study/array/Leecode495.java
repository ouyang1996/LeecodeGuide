package com.adams.study.array;

/**
 * @Author :adams_ou
 * @Description :Leecode495题:提莫攻击
 *      在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
 *      现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 *      你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 *示例1:
 * 输入: [1,4], 2
 * 输出: 4
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
 * 所以最终输出 4 秒。
 *
 * 示例2:
 * 输入: [1,2], 2
 * 输出: 3
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
 * 由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
 * 所以最终输出 3 。
 * @Date :Create in 10:33 2020/7/22
 */
public class Leecode495 {

    public static void main(String[] args) {
        int[] ints = {1, 3, 6, 8, 10, 11, 14};
        System.out.println(findPoisonedDuration(ints, 3));
    }


    /**
     * 考虑相邻两个攻击时间点 A[i] 和 A[i + 1] 以及中毒持续时间 t，如果 A[i] + t <= A[i + 1]，
     * 那么在第 i + 1 次攻击时，第 i 次攻击造成的中毒的持续时间已经结束，即持续时间为 t；
     * 如果 A[i] + t > A[i + 1]，那么在第 i + 1 次攻击时，第 i 次攻击的中毒仍然在持续，
     * 由于中毒状态不可叠加，因此持续时间为 A[i + 1] - A[i]。
     * @param timeSeries
     * @param duration
     * @return
     */
    public static int findPoisonedDuration(int[] timeSeries,int duration){
        int n = timeSeries.length;
        if (n==0) {
            return 0;
        }
        int total = 0;
        for (int i=0;i<n-1;i++){
            total+=Math.min(timeSeries[i+1]-timeSeries[i],duration);
        }
        return total+duration;
    }
}
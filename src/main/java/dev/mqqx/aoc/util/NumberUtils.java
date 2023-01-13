package dev.mqqx.aoc.util;

import static java.lang.Math.sqrt;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class NumberUtils {

  public static int sumToN(int n) {
    return n * (n + 1) / 2;
  }

  public static int minNForSumToNBySum(int sum) {
    return (int) sqrt(2 * sum + 1D);
  }

  public static int median(int[] nums) {
    int median;
    if (nums.length % 2 == 0) {
      median = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
    } else {
      median = nums[nums.length / 2];
    }
    return median;
  }
}

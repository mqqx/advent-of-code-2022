package dev.mqqx.aoc.util;

import static java.lang.Integer.parseInt;
import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    if (isEven(nums.length)) {
      median = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
    } else {
      median = nums[nums.length / 2];
    }
    return median;
  }

  public static boolean isOdd(long toCheck) {
    return toCheck % 2 == 1;
  }

  public static boolean isEven(long toCheck) {
    return !isOdd(toCheck);
  }

  public static List<Integer> parseIntegers(String search) {
    final Pattern integers = Pattern.compile("-?\\d+");
    final Matcher matcher = integers.matcher(search);

    final List<Integer> integerList = new ArrayList<>();
    while (matcher.find()) {
      integerList.add(parseInt(matcher.group()));
    }

    return integerList;
  }
}

package dev.hmmr.aoc.days;

import static java.util.Arrays.stream;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;

@NoArgsConstructor(access = AccessLevel.NONE)
public class Day1 {
  @SneakyThrows
  static int calculateMostCalories(Resource example) {
    final List<String> content =
        stream(new String(example.getInputStream().readAllBytes()).split("\n\n")).toList();

    int mostCalories = 0;

    for (String numbers : content) {
      final Integer calories =
          stream(numbers.split("\n")).toList().stream()
              .map(Integer::valueOf)
              .reduce(0, Integer::sum);
      if (calories > mostCalories) {
        mostCalories = calories;
      }
    }

    return mostCalories;
  }
}

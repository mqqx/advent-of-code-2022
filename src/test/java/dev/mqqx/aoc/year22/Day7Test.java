package dev.mqqx.aoc.year22;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

class Day7Test {

  @Test
  void testSolvePart1Example() {
    final Resource example = new ClassPathResource("year22/day7/7-example");

    assertThat(Day7.solvePart1(example)).isEqualTo(95_437);
  }

  @Test
  void testSolvePart1() {
    final Resource resource = new ClassPathResource("year22/day7/7");

    assertThat(Day7.solvePart1(resource)).isEqualTo(1_447_046);
  }

  @Test
  void testSolvePart2Example() {
    final Resource example = new ClassPathResource("year22/day7/7-example");

    assertThat(Day7.solvePart2(example)).isEqualTo(24_933_642);
  }

  @Test
  void testSolvePart2() {
    final Resource resource = new ClassPathResource("year22/day7/7");

    assertThat(Day7.solvePart2(resource)).isEqualTo(578_710);
  }
}

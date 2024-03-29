package dev.mqqx.aoc.year21;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

class Day19Test {

  @Test
  void testSolvePart1Example() {
    final Resource example = new ClassPathResource("year21/day19/19-example");

    assertThat(Day19.solvePart1(example)).isEqualTo(79);
  }

  @Test
  void testSolvePart1() {
    final Resource resource = new ClassPathResource("year21/day19/19");

    assertThat(Day19.solvePart1(resource)).isEqualTo(451);
  }

  @Test
  void testSolvePart2Example() {
    final Resource example = new ClassPathResource("year21/day19/19-example");

    assertThat(Day19.solvePart2(example)).isEqualTo(3_621);
  }

  @Test
  void testSolvePart2() {
    final Resource resource = new ClassPathResource("year21/day19/19");

    assertThat(Day19.solvePart2(resource)).isEqualTo(13_184);
  }
}

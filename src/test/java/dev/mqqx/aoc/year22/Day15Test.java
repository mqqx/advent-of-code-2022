package dev.mqqx.aoc.year22;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

class Day15Test {

  @Test
  void testSolvePart1Example() {
    final Resource example = new ClassPathResource("year22/day15/15-example");

    assertThat(Day15.solvePart1(example, 10)).isEqualTo(26);
  }

  @Test
  void testSolvePart1() {
    final Resource resource = new ClassPathResource("year22/day15/15");

    assertThat(Day15.solvePart1(resource, 2_000_000)).isEqualTo(4_886_370);
  }

  @Test
  void testSolvePart2Example() {
    final Resource example = new ClassPathResource("year22/day15/15-example");

    assertThat(Day15.solvePart2(example, 20)).isEqualTo(56_000_011);
  }

  @Test
  void testSolvePart2() {
    final Resource resource = new ClassPathResource("year22/day15/15");

    assertThat(Day15.solvePart2(resource, 4_000_000)).isEqualTo(11_374_534_948_438L);
  }
}

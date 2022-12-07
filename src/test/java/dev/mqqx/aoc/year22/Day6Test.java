package dev.mqqx.aoc.year22;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

class Day6Test {

  @Test
  void doThingExample() {
    final Resource example = new ClassPathResource("year22/day6/6-example");

    assertThat(Day6.doThing(example, 4)).isEqualTo(11);
  }

  @Test
  void doThing() {
    final Resource resource = new ClassPathResource("year22/day6/6");

    assertThat(Day6.doThing(resource, 4)).isEqualTo(1_275);
  }

  @Test
  void doThingAdvancedExample() {
    final Resource example = new ClassPathResource("year22/day6/6-example");

    assertThat(Day6.doThing(example, 14)).isEqualTo(26);
  }

  @Test
  void doThingAdvanced() {
    final Resource resource = new ClassPathResource("year22/day6/6");

    assertThat(Day6.doThing(resource, 14)).isEqualTo(3_605);
  }
}
# Advent of Code 2021 

Solutions for Advent of Code 2021

## Day 1

Loops with counters.

## Day 2

Loops, with string replacement as well some counters.

## Day 3

For part 1 using mainly plain looping with some counters.

For part 1 using `^` operator to calculate whether zeros or ones need to be removed depending on most common bit and most relevant one.

## Day 4

Using a `BingoNumber` record to safe the state on a bingo board after each drawn number. Therefor just used lots of plain iterations over all boards to find the first/last winning board.

## Day 5

Solved by extending own `Point` class to provide util methods for horizontal (`y1==y2`), vertical (`x1==x2`) or diagonal (`abs(x2 - x1)==abs(y2 - y1)`) points between `this` and a given point.

## Day 6

At first, I just used an `AtomicLong` for each fish and counted them separately, which resulted in an OOM-Error on part 2.

Therefor I migrated to an `AtomicLongMap` (Guava) with the day as the key and the count of fish on that day as value. This works by using `getAndAdd` to either just increase the existing counter or put a new one in the temporary map.

## Day 7

Start at median and increase/decrease possible height until minimum fuel does not get any lower.

Use same logic for part 2 with added `sumToN` call, to count for the increased fuel cost the further the crab needs to move.

## Day 8

For part 1 I removed the left side of the text of the `|` sign and used the regex `\b(?:[a-z]{2,4}|[a-z]{7})\b` to count all strings where the output had a length of 2, 3, 4 or 7 which represents the numbers 1, 4, 7 and 8.

As for part 2 one needs to recognize all numbers, so they can be summed up. Therefor I came up with some unique constrains regarding the length and already found numbers. As each number-string will exactly once on the left side, already mapped numbers can be removed from the set of numbers to parse.

## Day 9

Parse the height map into a 2d-array and check all numbers if they are surrounded by higher ones. If that's the case then add it (+ an additional 1) to the sum.

For the 2nd part check connected top and left basins and optionally merge them together.
Count the saved basins in a `AtomicLongMap` and multiply the three largest basis counts.

## Day 10

For the 1st part scan all lines for syntax errors by keeping track of the opening character of all unclosed chunks in a deque and return the specified error points if there is an illegal character detected. Otherwise, just return 0 to avoid additional filtering of unfinished chunks.

For the 2nd part filter the lines with syntax errors out and take all characters of unclosed chunks to calculate the auto complete score in reversed order as they are saved in the deque.

## Day 11

Each step repeat looping over energy levels as long as there are new flashes found. Use `Integer.MIN_VALUE` to mark already flashed energy levels, before they get reset eventually in `reset` method.

Part two will just use `1_000` instead of `100` steps and return before when all energy levels flashed at once. Could be changed to a `while` loop with boolean, but for the provided data it's enough.

## Day 12

Part 1 uses backtracking as well as filtering out unreachable nodes already before traversing.

Part 2 adds the condition, that one of the small caves can be visited two times. Therefor we cannot remove unreachable nodes, because they can be reached now.
Besides that the small cave visits are counted in an `AtomicLongMap` which will be used to check the added condition.

## Day 13

For part 1 read all points into a set and fold them with the first folding, by subtracting the x/y-gap of the corresponding point value if its >= the x/y-line to fold.

Collect everything back into a set to ensure distinctness.

For part 2 apply all foldings and print the final list of points.

## Day 14

Populate the polymer by using a `StringBuilder` to save the partial strings after each population.

For part 2 we cannot rely on string manipulation as with 40 steps the result would get way to large (with starting length 4 and doubling every round (-1) the result would be roughly 4*2^40 and therefore in the TB area).

So instead of string manipulation we start with the initial 3 string pairs and populate the polymer by iterating over the pairs, splitting them up and add the pairs value to it.

Following up, we need to add one to the count of the first and the last char, so they are double counted as any other char.

Afterwards we subtract the highest count by the lowest count and divide the result by 2, because of the double counting.

## Day 15

Use Dijkstra to get the path with the lowest risk. For the 2nd part expand the grid first and solve it with the same implementation.

## Day 16

Parse hex string to binary string by iterating over the strings chars and collect the suiting bit-string, without having to worry about data type boundaries.

Parse packets as long as the end of the binary string is not reached and sum the version of each as score in the 1st part.

Parse the values and evaluate them by their corresponding operation as long as the end of the binary string is reached.
Return the last operation result as score for part 2.

## Day 17

Brute force around the edges of the borders and try every x/y for velocity in a reasonable amount of steps.

Brute force part 2 with even larger ranges.

Can be improved by filtering out shots which can never reach the target, e.g. when their x velocity is 0 before or after the target.

## Day 18

Use `JsonParser` to get an easy nested representation of the input before parsing it to nested `Node` with either value or left and right `Node` aka snailfish number.

merge and reduce the parsed snailfish numbers until the whole list was processed and return the recursive calculated magnitude for part 1.

For part 2 iterate over all snailfish numbers in a nested loop, merge and reduce each pair of `x+y` as well as `y+x` as the commutative is not the same.

## Day 19

Parse scanner results to own `Point3D` record and use first scanner result as base for comparison to others.

For other scanner results try all 24 different orientations in comparison to the original scanner and add the beacons if at least 12 match.

Therefor lots of nested loops are used in part 1.

Part 2 requires the highest manhattan distance between the scanners found in part 1.

## Day 20

Looked very easy at first, but was a bit tricky due to flipping border pixels in the image enhancement algorithm of the actual input.

The index of `0 0000 0000`, which translates to index `0` is `#` in the actual input. The index of `1 1111 1111`, which translates to index `511` is `.`.

Therefor the border bits flip for the actual input on odd rounds.

Besides that the parsing and enhancing of the image was pretty forward and could just use a round counter of `50` instead of `2` for part 2, without further changes.

## Day 21

Use a `Player` helper class together with simple looping until one player reaches at least `1000` points. Use modulo `%10` for the position and set it to `10` if `%10` would be `0` 

Recursive quantum splitting with pre-calculated results of the frequency of three D3 rolls for part 2.

## Day 22

At first, I thought about using `Range` and `RangeSet` provided by guava. But unfortunately writing a proper `DiscreteDomain` implementation for `Point3D` is not trivial, as with even setting up strict rules for `next` and `last` element methods, one cannot find an easy working direction.

Therefore, I started to save the individual cubes one-by-one and compared them to previous ones regarding there overlapping parts.

Solution runs pretty fast, so it can be used for part 1 and 2 as well, by just skipping the fixed lower and upper bounds of part 1 in part 2.

## Day 23

Especially part 1 could be easily used by hand, while for part 2 it would take quite some time. Therefor using dijkstras to find the least energy required to organize the amphipods in part 1 and 2.

Additionally, part 2 doubles the length of the burrows for each amphipod type, which we can then use to iterate over it from 1-4.

## Day 24

There are 9^14 possibilities to find the largest model number.
That's more than can be checked in a reasonable time.

Therefor after examining, comparing and reducing the instruction patters it turns out, there are only two relevant instructions per set of 18 instructions.
Taking these the solution can be simplified to only check if the first operand of the current instruction added to the second operand of the last instruction is `>= 0`.

To get the smallest model number for part 2, just start from the smallest number `1` and count upwards.

## Day 25

Plainly implemented the requirements by moving the `>` chars first and the `v` chars afterwards. Moving until no more moves are done in one round.
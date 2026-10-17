# Homework: Testing and Debugging -- your personal variant

Student: 2025700171    Variant code: 2184a6223d

You received `Point.java`. It contains several faults. Your own copy differs from other students' copies,
so a classmate's tests, fixes or answers will not match your code.

## Your specifications
Directions: NORTH is +y, EAST is +x. Each move changes a coordinate by exactly 1 (diagonals change both).

1. Unless stated otherwise, a Point starts from (0,0).
2. `manhattanDistance(Point)` returns the Manhattan distance between the Point and another Point.
3. `squaredEuclideanDistance(Point)` returns the squared Euclidean distance between the Point and another Point.
4. All distances (including `xDistance` and `yDistance`) are non-negative integers.
5. (Manhattan distance)^2 >= squared Euclidean distance, for every pair of Points.
6. `move(Direction)` moves the Point one step towards the Direction (smallest possible step).
7. The space is a square whose edge holds **7 unique coordinates**, centered on (0,0)
   (so x and y each range over -3..3). Creating a Point outside this space throws `IllegalArgumentException`.
8. `reflection(Point o)` creates and returns a NEW Point that is this Point reflected over `o`.
   If the result is outside the space, `IllegalArgumentException` is thrown.
9. A move that would leave the square instead places the Point at the reflection, over (0,0), of the position it had BEFORE the move.
10. `neighborhoodManhattan(List<Point> candidates, int d)` returns a new list of exactly those candidates whose Manhattan
   distance to this Point is <= d. A negative d gives an empty list.

Anything these rules leave open is yours to decide and document in your report (see the handout).

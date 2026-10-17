import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void spec01_defaultOrigin() {
		Point p = new Point();
		assertEquals(0, p.x);
		assertEquals(0, p.y);
	}
	
	@Test
	void spec02_manhattandistance() {
		for(int x1= -3; x1<= 3; x1++) {
			for(int x2= -3; x2<=3; x2++) {
				for(int y1=-3; y1<=3; y1++) {
					for(int y2=-3; y2<=3; y2++) {
						Point p1= new Point(x1,y1);
						Point p2= new Point(x2,y2);
						
						int expected = Math.abs(x1-x2)+ Math.abs(y1-y2);
						int actual = p1.manhattanDistance(p2);
						
						assertEquals(expected, actual,
							    "Manhattan distance failed for " + p1 + " and " + p2);
					}
				}		
			}
		}
	}
	
	@Test
	void spec03_squaredEuclideanDistance() {
		for(int x1= -3; x1<= 3; x1++) {
			for(int x2= -3; x2<=3; x2++) {
				for(int y1=-3; y1<=3; y1++) {
					for(int y2=-3; y2<=3; y2++) {
						Point p1= new Point(x1,y1);
						Point p2= new Point(x2,y2);
						
						int expected = (x1-x2)*(x1-x2)+ (y1-y2) * (y1-y2);
						int actual = p1.squaredEuclideanDistance(p2);
						
						assertEquals(expected, actual,
							    "Squared Euclidean distance failed for " + p1 + " and " + p2);
					}
				}		
			}
		}
		
	}
	
	@Test
	void spec04_nonNegativeXDistance() {
	    for (int x1 = -3; x1 <= 3; x1++) {
	        for (int y1 = -3; y1 <= 3; y1++) {
	            for (int x2 = -3; x2 <= 3; x2++) {
	                for (int y2 = -3; y2 <= 3; y2++) {

	                    Point p1 = new Point(x1, y1);
	                    Point p2 = new Point(x2, y2);

	                    assertTrue(p1.xDistance(p2) >= 0);

	                }
	            }
	        }
	    }
	}
	
	@Test
	void spec04_nonNegativeYDistance() {
	    for (int x1 = -3; x1 <= 3; x1++) {
	        for (int y1 = -3; y1 <= 3; y1++) {
	            for (int x2 = -3; x2 <= 3; x2++) {
	                for (int y2 = -3; y2 <= 3; y2++) {

	                    Point p1 = new Point(x1, y1);
	                    Point p2 = new Point(x2, y2);

	                    assertTrue(p1.yDistance(p2) >= 0);

	                }
	            }
	        }
	    }
	}
	
	@Test
	void spec04_nonNegativeManhattanDistance() {
	    for (int x1 = -3; x1 <= 3; x1++) {
	        for (int y1 = -3; y1 <= 3; y1++) {
	            for (int x2 = -3; x2 <= 3; x2++) {
	                for (int y2 = -3; y2 <= 3; y2++) {

	                    Point p1 = new Point(x1, y1);
	                    Point p2 = new Point(x2, y2);

	                    assertTrue(p1.manhattanDistance(p2) >= 0);

	                }
	            }
	        }
	    }
	}
	
	@Test
	void spec04_nonNegativeSquaredEuclideanDistance() {
	    for (int x1 = -3; x1 <= 3; x1++) {
	        for (int y1 = -3; y1 <= 3; y1++) {
	            for (int x2 = -3; x2 <= 3; x2++) {
	                for (int y2 = -3; y2 <= 3; y2++) {

	                    Point p1 = new Point(x1, y1);
	                    Point p2 = new Point(x2, y2);

	                    assertTrue(p1.squaredEuclideanDistance(p2) >= 0);

	                }
	            }
	        }
	    }
	}
	
	@Test
	void spec05_distanceInequality() {
	    for (int x1 = -3; x1 <= 3; x1++) {
	        for (int y1 = -3; y1 <= 3; y1++) {
	            for (int x2 = -3; x2 <= 3; x2++) {
	                for (int y2 = -3; y2 <= 3; y2++) {

	                    Point p1 = new Point(x1, y1);
	                    Point p2 = new Point(x2, y2);
	                    
	                    int manhattan = p1.manhattanDistance(p2);
	                    int squaredEuclidean = p1.squaredEuclideanDistance(p2);

	                    assertTrue(manhattan * manhattan >= squaredEuclidean,"SPEC 5 failed for " + p1 + " and " + p2);

	                }
	            }
	        }
	    }
	}
	
	@Test
	void spec06_moveNorth() {
	    Point p = new Point(2, 2);

	    int oldX = p.x;
	    int oldY = p.y;

	    p.move(Point.Direction.NORTH);

	    assertEquals(0, p.x - oldX);
	    assertEquals(1, p.y - oldY);
	}

	@Test
	void spec06_moveSouth() {
	    Point p = new Point(2, 2);

	    int oldX = p.x;
	    int oldY = p.y;

	    p.move(Point.Direction.SOUTH);

	    assertEquals(0, p.x - oldX);
	    assertEquals(-1, p.y - oldY);
	}

	@Test
	void spec06_moveEast() {
	    Point p = new Point(2, 2);

	    int oldX = p.x;
	    int oldY = p.y;

	    p.move(Point.Direction.EAST);

	    assertEquals(1, p.x - oldX);
	    assertEquals(0, p.y - oldY);
	}

	@Test
	void spec06_moveWest() {
	    Point p = new Point(2, 2);

	    int oldX = p.x;
	    int oldY = p.y;

	    p.move(Point.Direction.WEST);

	    assertEquals(-1, p.x - oldX);
	    assertEquals(0, p.y - oldY);
	}

	@Test
	void spec06_moveNorthEast() {
	    Point p = new Point(2, 2);

	    int oldX = p.x;
	    int oldY = p.y;

	    p.move(Point.Direction.NORTHEAST);

	    assertEquals(1, p.x - oldX);
	    assertEquals(1, p.y - oldY);
	}

	@Test
	void spec06_moveNorthWest() {
	    Point p = new Point(2, 2);

	    int oldX = p.x;
	    int oldY = p.y;

	    p.move(Point.Direction.NORTHWEST);

	    assertEquals(-1, p.x - oldX);
	    assertEquals(1, p.y - oldY);
	}

	@Test
	void spec06_moveSouthEast() {
	    Point p = new Point(2, 2);

	    int oldX = p.x;
	    int oldY = p.y;

	    p.move(Point.Direction.SOUTHEAST);

	    assertEquals(1, p.x - oldX);
	    assertEquals(-1, p.y - oldY);
	}

	@Test
	void spec06_moveSouthWest() {
	    Point p = new Point(2, 2);

	    int oldX = p.x;
	    int oldY = p.y;

	    p.move(Point.Direction.SOUTHWEST);

	    assertEquals(-1, p.x - oldX);
	    assertEquals(-1, p.y - oldY);
	}
	
	@Test
	void spec07_validCoordinates() {

	    for (int x = -3; x <= 3; x++) {
	        for (int y = -3; y <= 3; y++) {

	            final int currentX = x;
	            final int currentY = y;

	            Point p = assertDoesNotThrow(
	                () -> new Point(currentX, currentY)
	            );

	            assertEquals(currentX, p.x);
	            assertEquals(currentY, p.y);
	        }
	    }
	}
	
	@Test
	void spec07_justOutsideBoundaries() {

	    assertAll(
	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(4, 0)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(-4, 0)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(0, 4)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(0, -4)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(4, 4)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(-4, -4)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(4, -4)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(-4, 4))
	    );
	}
	
	@Test
	void spec07_farOutsideBoundaries() {

	    assertAll(
	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(10, 0)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(-10, 0)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(0, 100)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(0, -100)),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(100, -100))
	    );
	}
	
	@Test
	void spec08_validReflections() {

	    for (int x = -3; x <= 3; x++) {
	        for (int y = -3; y <= 3; y++) {
	            for (int ox = -3; ox <= 3; ox++) {
	                for (int oy = -3; oy <= 3; oy++) {

	                    int expectedX = 2 * ox - x;
	                    int expectedY = 2 * oy - y;

	                    if (expectedX >= -3 && expectedX <= 3 &&
	                        expectedY >= -3 && expectedY <= 3) {

	                        Point p = new Point(x, y);
	                        Point o = new Point(ox, oy);

	                        Point result = p.reflection(o);

	                        assertEquals(expectedX, result.x,
	                            "Incorrect reflected X for " + p + " over " + o);

	                        assertEquals(expectedY, result.y,
	                            "Incorrect reflected Y for " + p + " over " + o);
	                    }
	                }
	            }
	        }
	    }
	}
	
	@Test
	void spec08_returnsNewPoint() {

	    Point p = new Point(1, 2);

	    Point result = p.reflection(p);

	    assertNotSame(p, result);

	    assertEquals(1, result.x);
	    assertEquals(2, result.y);
	}
	
	@Test
	void spec08_doesNotModifyOriginalPoints() {

	    Point p = new Point(1, 2);
	    Point center = new Point(0, 1);

	    Point result = p.reflection(center);

	    assertAll(
	        () -> assertEquals(1, p.x),
	        () -> assertEquals(2, p.y),
	        () -> assertEquals(0, center.x),
	        () -> assertEquals(1, center.y),
	        () -> assertEquals(-1, result.x),
	        () -> assertEquals(0, result.y)
	    );
	}
	
	@Test
	void spec08_outsideReflectionThrows() {

	    assertAll(
	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(-3, -3)
	                .reflection(new Point(3, 3))),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(3, 3)
	                .reflection(new Point(-3, -3))),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(-3, 0)
	                .reflection(new Point(1, 0))),

	        () -> assertThrows(IllegalArgumentException.class,
	            () -> new Point(0, 3)
	                .reflection(new Point(0, -1)))
	    );
	}
	
	@Test
	void spec09_allBoundaryMoves() {

	    for (int x = -3; x <= 3; x++) {
	        for (int y = -3; y <= 3; y++) {

	            for (Point.Direction direction : Point.Direction.values()) {

	                int dx = 0;
	                int dy = 0;

	                switch (direction) {
	                    case NORTH:     dy = 1; break;
	                    case NORTHEAST: dx = 1; dy = 1; break;
	                    case EAST:      dx = 1; break;
	                    case SOUTHEAST: dx = 1; dy = -1; break;
	                    case SOUTH:     dy = -1; break;
	                    case SOUTHWEST: dx = -1; dy = -1; break;
	                    case WEST:      dx = -1; break;
	                    case NORTHWEST: dx = -1; dy = 1; break;
	                }

	                int nextX = x + dx;
	                int nextY = y + dy;

	                if (nextX < -3 || nextX > 3 ||
	                    nextY < -3 || nextY > 3) {

	                    Point p = new Point(x, y);

	                    p.move(direction);

	                    assertEquals(-x, p.x,
	                        "Wrong reflected X from (" + x + "," + y
	                        + ") moving " + direction);

	                    assertEquals(-y, p.y,
	                        "Wrong reflected Y from (" + x + "," + y
	                        + ") moving " + direction);
	                }
	            }
	        }
	    }
	}
	
	@Test
	void spec09_reflectsPositionBeforeMove() {

	    Point p = new Point(3, 2);

	    p.move(Point.Direction.EAST);

	    assertAll(
	        () -> assertEquals(-3, p.x),
	        () -> assertEquals(-2, p.y)
	    );
	}
	

	@Test
	void spec10_filtersCandidatesByManhattanDistance() {
		
	    Point center = new Point(0, 0);
	
	    Point p1 = new Point(1, 0); // Distance 1
	    Point p2 = new Point(1, 1); // Distance 2
	    Point p3 = new Point(2, 1); // Distance 3
	    Point p4 = new Point(3, 2); // Distance 5
	
	    List<Point> candidates = Arrays.asList(p1, p2, p3, p4);
	
	    List<Point> result = center.neighborhoodManhattan(candidates, 2);
	
	    assertEquals(2, result.size());
	    assertTrue(result.contains(p1));
	    assertTrue(result.contains(p2));
	    assertFalse(result.contains(p3));
	    assertFalse(result.contains(p4));
	}
	
	@Test
	void spec10_includesExactDistanceBoundary() {
	    Point center = new Point(0, 0);
	
	    Point inside = new Point(1, 1);  // Distance 2
	    Point boundary = new Point(2, 1); // Distance 3
	    Point outside = new Point(2, 2);  // Distance 4
	
	    List<Point> candidates = Arrays.asList(inside, boundary, outside);
	
	    List<Point> result = center.neighborhoodManhattan(candidates, 3);
	
	    assertEquals(2, result.size());
	    assertTrue(result.contains(inside));
	    assertTrue(result.contains(boundary));
	    assertFalse(result.contains(outside));
	}
	
	@Test
	void spec10_negativeDistanceReturnsEmpty() {
	    Point center = new Point(0, 0);
	
	    List<Point> candidates = Arrays.asList(
	        new Point(0, 0),
	        new Point(1, 0),
	        new Point(2, 2)
	    );
	
	    for (int d : new int[]{-1, -2, -100}) {
	        List<Point> result = center.neighborhoodManhattan(candidates, d);
	
	        assertNotNull(result);
	        assertTrue(result.isEmpty(),
	            "Negative d = " + d + " should produce an empty list");
	    }
	}
	
	@Test
	void spec10_returnsNewListWithOriginalPointReferences() {
	    Point center = new Point(0, 0);
	    Point candidate = new Point(1, 1);
	
	    List<Point> candidates = new ArrayList<>();
	    candidates.add(candidate);
	
	    List<Point> result = center.neighborhoodManhattan(candidates, 3);
	
	    assertNotSame(candidates, result);
	    assertEquals(1, result.size());
	    assertSame(candidate, result.get(0));
	}
	
	@Test
	void spec10_usesManhattanNotEuclidean() {
	    Point center = new Point(0, 0);
	
	    Point diagonal = new Point(2, 2); // Manhattan 4, Euclidean ~2.83
	    Point axis = new Point(3, 0);     // Manhattan 3, Euclidean 3
	
	    List<Point> candidates = Arrays.asList(diagonal, axis);
	
	    List<Point> result = center.neighborhoodManhattan(candidates, 3);
	
	    assertEquals(1, result.size());
	    assertSame(axis, result.get(0));
	}
	
	@Test
	void spec10_zeroDistanceAndEmptyCandidates() {
	    Point center = new Point(1, -1);
	
	    Point sameCoordinates = new Point(1, -1);
	    Point nearby = new Point(1, 0);
	
	    List<Point> candidates = Arrays.asList(sameCoordinates, nearby);
	
	    List<Point> result = center.neighborhoodManhattan(candidates, 0);
	
	    assertEquals(1, result.size());
	    assertSame(sameCoordinates, result.get(0));
	
	    List<Point> emptyResult =
	        center.neighborhoodManhattan(new ArrayList<Point>(), 2);
	
	    assertNotNull(emptyResult);
	    assertTrue(emptyResult.isEmpty());
	}
	
	@Test
	void spec10_allValidPointsAndThresholds() {
    Point center = new Point(1, -1);

    List<Point> candidates = new ArrayList<>();

    for (int x = -3; x <= 3; x++) {
        for (int y = -3; y <= 3; y++) {
            candidates.add(new Point(x, y));
        }
    }

    for (int d = 0; d <= 12; d++) {
        List<Point> result = center.neighborhoodManhattan(candidates, d);

        List<Point> expected = new ArrayList<>();

        for (Point candidate : candidates) {
            int distance = Math.abs(candidate.x - center.x)
                         + Math.abs(candidate.y - center.y);

            if (distance <= d) {
                expected.add(candidate);
            }
        }

        assertEquals(expected.size(), result.size(),
            "Incorrect list size for d = " + d);

        assertTrue(result.containsAll(expected),
            "Missing candidates for d = " + d);

        assertTrue(expected.containsAll(result),
            "Unexpected candidates for d = " + d);
    }
}


}

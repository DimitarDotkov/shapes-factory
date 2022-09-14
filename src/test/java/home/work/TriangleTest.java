package home.work;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void perimeterIsCalculatedCorrectly() {
        Triangle triangle = new Triangle(6.6,10.04,15.9);
        double perimeter = triangle.perimeter();
        double roundedPerimeter = Math.round(perimeter * 100.0) / 100.0;

        assertEquals(32.54,roundedPerimeter);
    }

    @Test
    void toStringReturnsCorrectRepresentation() {
        Triangle triangle = new Triangle(10.8,12.35,18.77);
        String stringRepresentation = triangle.toString();

        assertEquals("triangle 10.8 12.35 18.77",stringRepresentation);
    }

    @Test
    void clonedObjectIsNotTheSameAsOriginal() throws CloneNotSupportedException {
        Triangle triangle = new Triangle(3.0,4.0,5.0);
        Triangle clone = (Triangle) triangle.clone();

        assertNotSame(triangle,clone);

    }
}
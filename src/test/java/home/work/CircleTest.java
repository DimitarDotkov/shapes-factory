package home.work;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void perimeterIsCalculatedCorrectly() {
        Circle circle = new Circle(5);
        double perimeter = circle.perimeter();
        double roundedPerimeter = Math.round(perimeter * 100.0) / 100.0;

        assertEquals(31.4,roundedPerimeter);
    }

    @Test
    void toStringReturnsCorrectRepresentation() {
        Circle circle = new Circle(10);
        String stringRepresentation = circle.toString();

        assertEquals("circle 10.0",stringRepresentation);
    }

    @Test
    void clonedObjectIsNotTheSameAsOriginal() throws CloneNotSupportedException {
        Circle circle = new Circle(15);
        Circle clone = (Circle) circle.clone();

        assertNotSame(circle,clone);
    }
}
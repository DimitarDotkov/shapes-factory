package home.work;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void perimeterIsCalculatedCorrectly() {
        Rectangle rectangle = new Rectangle(12.9,21.4);
        double perimeter = rectangle.perimeter();
        double roundedPerimeter = Math.round(perimeter * 100.0) / 100.0;

        assertEquals(68.6,roundedPerimeter);
    }

    @Test
    void toStringReturnsCorrectRepresentation() {
        Rectangle rectangle = new Rectangle(5.41,2.25);
        String stringRepresentation = rectangle.toString();

        assertEquals("rectangle 5.41 2.25",stringRepresentation);
    }

    @Test
    void clonedObjectIsNotTheSameAsOriginal() throws CloneNotSupportedException {
        Rectangle rectangle = new Rectangle(5.36,5.78);
        Rectangle clone = (Rectangle) rectangle.clone();

        assertNotSame(rectangle,clone);
    }
}
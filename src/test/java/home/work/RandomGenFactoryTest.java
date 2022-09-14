package home.work;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RandomGenFactoryTest {

    @Test
    void randomFiguresAreCreated() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ArrayList<Figure> randomList;
        randomList= new RandomGenFactory().randomGenerator(5);
        for (Figure figure : randomList) {
            assertNotSame(null, figure);
        }
    }

    @Test
    void createCircleReturnsCircleObject() {
        Circle circle = new RandomGenFactory().createCircle();
        assertEquals("Circle",circle.getClass().getSimpleName());
    }

    @Test
    void createRectangleReturnsRectangleObject() {
        Rectangle rectangle = new RandomGenFactory().createRectangle();
        assertEquals("Rectangle",rectangle.getClass().getSimpleName());
    }

    @Test
    void createTriangleReturnsTriangleObject() {
        Triangle triangle = new RandomGenFactory().createTriangle();
        assertEquals("Triangle",triangle.getClass().getSimpleName());
    }
}
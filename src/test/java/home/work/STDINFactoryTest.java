package home.work;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class STDINFactoryTest {

    @Test
    void figureIsCreatedCorrectly() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String figure = "circle 10";
        Scanner sc = new Scanner(figure);
        Circle circle = new Circle(10);

        assertEquals(circle.toString(),new STDINFactory(sc).toFigure().toString());
    }

    @Test
    void figuresReadFromFileAreCreatedCorrectly() throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ArrayList<Figure> actual = new ArrayList<>();
        File file = new File(".\\resources\\list.txt");
        Scanner fileReader = new Scanner(file);

        while (fileReader.hasNextLine()){
            actual.add(new STDINFactory(fileReader).toFigure());
        }
        String[] expected = new String[]{"triangle 3.0 4.0 5.0","rectangle 45.0 50.0","circle 10.0","circle 15.0"};

        for(int i = 0; i < actual.size();i++){
            assertEquals(expected[i],actual.get(i).toString());
        }
    }

    @Test
    void multipleFiguresAreCorrectlyCreated() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String[] expected = new String[]{"triangle 5.0 8.0 10.0","rectangle 15.4 64.1","circle 5.4"};

        Circle circle = new Circle(5.4);
        Triangle triangle = new Triangle(5,8,10);
        Rectangle rectangle = new Rectangle(15.4,64.1);
        ArrayList<Figure> figuresList = new ArrayList<>();
        figuresList.add(triangle);
        figuresList.add(rectangle);
        figuresList.add(circle);

        for (int i = 0; i < figuresList.size(); i++) {
            assertEquals(expected[i],figuresList.get(i).toString());
        }

    }

    @Test
    void circleIsCreated() {
        String circleRadius = "15.4";
        Scanner sc = new Scanner(circleRadius);

        assertNotSame(null,new STDINFactory(sc).createCircle());
    }

    @Test
    void rectangleIsCreated() {
        String rectangleSides="10 20";
        Scanner sc = new Scanner(rectangleSides);

        assertNotSame(null,new STDINFactory(sc).createRectangle());
    }

    @Test
    void triangleIsCreated() {
        String triangleSides="5 8 10";
        Scanner sc = new Scanner(triangleSides);

        assertNotSame(null,new STDINFactory(sc).createTriangle());
    }

    @Test
    void circleIsCreatedCorrectly() {
        String circleRadius = "40.2";
        Scanner sc = new Scanner(circleRadius);

        Circle expected = new Circle(40.2);
        assertEquals(expected.toString(),new STDINFactory(sc).createCircle().toString());
    }

    @Test
    void rectangleIsCreatedCorrectly() {
        String rectangleSides = "15.4 58.3";
        Scanner sc = new Scanner(rectangleSides);

        Rectangle expected = new Rectangle(15.4, 58.3);

        assertEquals(expected.toString(),new STDINFactory(sc).createRectangle().toString());
    }

    @Test
    void triangleIsCreatedCorrectly() {
        String triangleSides = "3.4 6.1 7.2";
        Scanner sc = new Scanner(triangleSides);

        Triangle expected = new Triangle(3.4, 6.1, 7.2);

        assertEquals(expected.toString(),new STDINFactory(sc).createTriangle().toString());
    }
}


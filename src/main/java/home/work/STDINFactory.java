package home.work;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;


// StdinFactory

// FigureReader, FigureScanner, ...
public class STDINFactory implements Factory{
    ArrayList<Figure> arr = new ArrayList<>();
    final Scanner scc;

    public STDINFactory(Scanner scc){
        this.scc=scc;
    }

    public Figure toFigure() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String className=scc.next();

        className=className.substring(0,1).toUpperCase() + className.substring(1);
        Class<?> c = Class.forName("home.work.STDINFactory");

        Constructor<?> cons=c.getConstructor(Scanner.class);
        STDINFactory instance = (STDINFactory) cons.newInstance(scc);

        Method m = c.getDeclaredMethod("create" + className);

        Figure result = (Figure) m.invoke(instance);
        return result;
    }

    public ArrayList<Figure> toFigures(int number) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < number; i++) {
            arr.add(toFigure());
        }

        return arr;
    }

    @Override
    public Circle createCircle(){
        double radius = scc.nextDouble();
        return new Circle(radius);
    }

    @Override
    public Rectangle createRectangle(){
        double firstSide=scc.nextDouble();
        double secondSide=scc.nextDouble();
        return new Rectangle(firstSide,secondSide);
    }

    @Override
    public Triangle createTriangle(){
        double firstSide=scc.nextDouble();
        double secondSide=scc.nextDouble();
        double thirdSide=scc.nextDouble();
        return new Triangle(firstSide, secondSide, thirdSide);
    }
}

package home.work;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class RandomGenFactory implements Factory{
    public enum className {
        Circle,
        Rectangle,
        Triangle;

        private static Random ran = new Random();

        public static className randomName()  {
            className[] directions = values();
            int index = ran.nextInt(directions.length);
            return directions[index];
        }
    }
    ArrayList<Figure> arr = new ArrayList<>();
    final double MAX_VALUE=1000.0;
    final double MIN_VALUE=1.0;

    private double[] generateTriangle() {
        double fs = Math.random()*(MAX_VALUE-MIN_VALUE)+MIN_VALUE;
        double ss = Math.random()*(MAX_VALUE-MIN_VALUE)+MIN_VALUE;
        double ts = Math.random()*(MAX_VALUE-MIN_VALUE)+MIN_VALUE;

        if (fs + ss >= ts && ss + ts >= fs && fs + ts >= ss) {
            double []arr={fs,ss,ts};
            return arr;
        }

        return null;
    }

    public ArrayList<Figure> randomGenerator(int number) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        for(;number>0;number--)
        {
            String randomName = className.randomName().toString();
            Class<?> c = Class.forName("home.work.RandomGenFactory");
            RandomGenFactory instance = (RandomGenFactory) c.getDeclaredConstructor().newInstance();
            Method m = c.getDeclaredMethod("create" + randomName);

            Figure result = (Figure) m.invoke(instance);
            arr.add(result);
        }

        return arr;
    }

    @Override
    public Circle createCircle(){
        double rad= Math.random()*(MAX_VALUE-MIN_VALUE)+MIN_VALUE;
        return new Circle(rad);
    }

    @Override
    public Rectangle createRectangle(){
        double fs=Math.random()*(MAX_VALUE-MIN_VALUE)+MIN_VALUE;
        double ss=Math.random()*(MAX_VALUE-MIN_VALUE)+MIN_VALUE;
        return new Rectangle(fs,ss);
    }

    @Override
    public Triangle createTriangle(){
        double[] tr=generateTriangle();
        while (tr==null){
            tr=generateTriangle();
        }
        return new Triangle(tr[0],tr[1],tr[2]);
    }
}

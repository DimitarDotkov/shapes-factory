package home.work;

public class Circle implements Figure {
    final double PI = 3.14;
    double radius;

    public Circle(double radius){
        this.radius=radius;
    }

    @Override
    public double perimeter() {
        return 2.0*PI*radius;
    }

    @Override
    public String toString(){
        String className=this.getClass().getSimpleName().substring(0,1).toLowerCase()+this.getClass().getSimpleName().substring(1);
        return className + " " + radius;
        //return this.getClass().getSimpleName() + " " + radius;
    }

    @Override
    public Figure clone() throws CloneNotSupportedException{
        return (Circle)super.clone();
    }
}

package home.work;

public class Rectangle implements Figure {
    double firstSide;
    double secondSide;

    public Rectangle(double firstSide,double secondSide){
        this.firstSide=firstSide;
        this.secondSide=secondSide;
    }

    @Override
    public double perimeter() {
        return 2.0*(firstSide+secondSide);
    }

    @Override
    public String toString(){
        String className=this.getClass().getSimpleName().substring(0,1).toLowerCase()+this.getClass().getSimpleName().substring(1);
        return className + " " + firstSide + " " + secondSide;

//        return this.getClass().getSimpleName() + " " + firstSide + " " + secondSide;
    }

    @Override
    public Figure clone() throws CloneNotSupportedException{
        return (Rectangle)super.clone();
    }
}

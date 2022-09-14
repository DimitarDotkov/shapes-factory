package home.work;

public class Triangle implements Figure {
    double firstSide;
    double secondSide;
    double thirdSide;

    public Triangle(double firstSide,double secondSide,double thirdSide){
        if (firstSide+secondSide>=thirdSide && secondSide+thirdSide>=firstSide && firstSide+thirdSide>=secondSide){
            this.firstSide=firstSide;
            this.secondSide=secondSide;
            this.thirdSide=thirdSide;
        }
    }

    @Override
    public double perimeter() {
        return firstSide+secondSide+thirdSide;
    }
    @Override
    public String toString(){
        String className=this.getClass().getSimpleName().substring(0,1).toLowerCase()+this.getClass().getSimpleName().substring(1);
        return className + " " + firstSide + " " + secondSide + " " + thirdSide;
    }

    @Override
    public Figure clone() throws CloneNotSupportedException{
        return (Triangle)super.clone();
    }
}

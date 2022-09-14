package home.work;

public interface Figure extends Cloneable {
    double perimeter();
    String toString();
    Figure clone() throws CloneNotSupportedException;
}

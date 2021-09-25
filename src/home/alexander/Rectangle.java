package home.alexander;

public class Rectangle implements Cloneable {

    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return ("Rectangle " + "length = " + length + ", " + "width = " + width);
    }

    public void finalize() {
        System.out.println("Rectangle destroyed!!");
    }

    // Переопределяем метод hashCode() вычисления хеша объекта
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(length);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    // Переопределяем метод equals() для сравнения объектов по содержимому
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null) return false;
        else if (this.getClass() != obj.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
//        if ((rectangle.length == this.length) && (rectangle.width == this.width)) return true;
//        else return false;
        if (Double.doubleToLongBits(length) != Double.doubleToLongBits(rectangle.length)) return false;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(rectangle.width)) return false;
        return true;
    }

    // Переопределяем метод clone()
    @Override
    public Rectangle clone() {
        try {
            return (Rectangle) super.clone(); //  используем метод clone() суперкласса Object
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

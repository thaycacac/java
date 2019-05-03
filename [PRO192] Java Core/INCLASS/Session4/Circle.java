
public class Circle extends Shape {
    // Lớp cha abtract hoặc lớp con abtract hoặc lớp con sẽ phải ghi đè định nghĩa phương thức trừu tượng của cha

    private double radius;

    public Circle() {
    }

    public Circle(String bgColor, double radius) {
        super(bgColor);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

}

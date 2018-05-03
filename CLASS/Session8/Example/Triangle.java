package Example;

public class Triangle {

    private int a, b, c;

    public Triangle() {
    }

    public Triangle(int a, int b, int c) throws MyException, Exception {

        if (a < 0 || b < 0 || c < 0) {
            throw new MyException("Not valid");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new Exception();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        double p;
        p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}

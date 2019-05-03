
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        // Lớp trừu thượng k thể tạo thể hiện: Shapte s = new Shape();
        Circle c = new Circle("Red", 1.2);
        System.out.println("bgColor = " + c.getBgColor());
        System.out.println("radius = " + c.getRadius());
        double area = c.getArea();
        System.out.println("area = " + area);

        // Solution1
        String rs = String.format("%.2f", area); //format định dạng của format
        System.out.println("area = " + rs);

        // Solution 2
        String pattern = "##.####"; //0 & #
        DecimalFormat df = new DecimalFormat(pattern);
        rs = df.format(area);
        System.out.println("area (##.####) = " + rs);

        // Solution 3
        pattern = "00.0000"; //0 & #
        df = new DecimalFormat(pattern);
        rs = df.format(area);
        System.out.println("area (00.0000) = " + rs);
    }
}

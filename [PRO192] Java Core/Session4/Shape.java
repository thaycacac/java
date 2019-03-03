public abstract class Shape {
    // Có phương thức abtract thì lớp thành lớp abtract
    private  String bgColor;

    public Shape() {
    }

    public Shape(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getBgColor() {
        return bgColor;
    }
 
    public abstract double getArea();
    // Thời điểm viết k đủ dữ liệu để viết
}

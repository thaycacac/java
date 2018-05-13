public abstract class Shape {//có phương thức abtract thì lớp thành lớp abtract
    private  String bgColor;

    public Shape() {
    }

    public Shape(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getBgColor() {
        return bgColor;
    }
 
    public abstract double getArea();//thời điểm viết k đủ dữ liệu để viết
}

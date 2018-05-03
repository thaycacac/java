
public class MyClass {
    //static abstract  void f(); //phương thức trừu tượng phải nằm trong class trừu tượng
    //static không đi kèm vs abtract vì static phải cụ thể
    static final int MAX = 20;
    int x; //instance variable
    /*
    MyClass m = new MyClass();
    m.x = 10 (correct)
    */
    static int y;//class variable
    /*
    auto declare variable of y=0
    Myclass.y = 20 (correct)
    Myclass.x = 10 (incorrect)
    */
    static{
        y+=2;//ưu tiên chạy trước
        System.out.println("y= "+y); //y=2
    }
    public MyClass(){
        y++;
        System.out.println("y= "+y);//y=6
    }
    static{
        y+=3;//ưu tiên chạy trước
        System.out.println("y= "+y);//y=5
    }
}

/*
lớp java.lang.Math là luôn luôn static final
m.pow(2,3) (incorrect)
Math.pow(2,3) (correct)
*/

/*
Inner class (lớp nội)
lớp nội được dùng tất cả ở bên ngoài có

*/

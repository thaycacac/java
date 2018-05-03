class A{//outer
    int x;
    static class B{//inner
        int y;
        int x; //shadowing
        void f(){
            x=y=10;
        }
    }//lấy gần nhất
    void g(){
        x=10;
        //y=20;
    }
}
public class Main {
    public static void main(String[] args) {
        MyClass m = new MyClass(); // khối static chỉ chạy một lần
        //2, 5, 6
        MyClass m1 = new MyClass();
        //7
        
        A a = new A();
        A.B b = new A.B();
    }
    
}


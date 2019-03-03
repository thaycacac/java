
public interface IMath {

    //constants + method declaration only
    public final String ERROR = "Devided by zero";
    //final cho biến ~ hằng số. 
    //final cho lớp ~ không cho lớp khác kế thừa.
    //final cho method ~ không được ghi đè ở lớp thừa kế

    public int add(int x, int y);
        int div(int x, int y); // Tự hiểu là public
    }

    interface A {
    }

    interface B extends A {
    }

    class MyMath implements IMath {// Phải định nghĩa các abtract

        @Override
        public int add(int x, int y) {
            //ERROR = ERROR.toUpperCase(); //không chạy vì nó là hằng số, kể cả không có final
            return x + y;
        }

        @Override
        public int div(int x, int y) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}

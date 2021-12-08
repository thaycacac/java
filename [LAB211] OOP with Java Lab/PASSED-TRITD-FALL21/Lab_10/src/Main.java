
import java.util.*;

public class Main {


    public static void main(String[] args) {
        int[] elementData = {6, 3, 4, -55, 3, 5, 1, 9, 2, 1, 0, 0, 2, 77};
        ArrayIntList list = new ArrayIntList(elementData, elementData.length);
        System.out.println("Old list: ");
        list.display();
        System.out.println("\nNew list: ");
        list.fromCount();
    }
    
}

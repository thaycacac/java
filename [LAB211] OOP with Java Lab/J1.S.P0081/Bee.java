
import java.util.Random;

public class Bee {

    public int randomHealthPoint() {
        Random ran = new Random();
        int min = 0;
        int max = 100;
        return ran.nextInt((max - min) + 1) + min;
    }

    public int randomAttack() {
        Random ran = new Random();
        int min = 0;
        int max = 80;
        return ran.nextInt((max - min) + 1) + min;
    }
}

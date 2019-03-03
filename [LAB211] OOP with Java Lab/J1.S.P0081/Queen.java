
import java.util.ArrayList;

public class Queen extends Bee implements IBee {

    ArrayList<Queen> listQueen = new ArrayList<>();

    private int healthPoint;

    public Queen() {
    }

    public Queen(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    @Override
    public void creatBeeList() {
        listQueen.clear();
        System.out.println("List Queen: ");
        for (int i = 0; i < 10; i++) {
            int point = super.randomHealthPoint();
            listQueen.add(new Queen(point));
            System.out.print(listQueen.get(i).getHealthPoint() + " ");
        }
        System.out.println();
    }

    @Override
    public void damage() {
        for (int i = 0; i < 10; i++) {
            int point = super.randomAttack();
            listQueen.get(i).setHealthPoint(listQueen.get(i).getHealthPoint()
                    - point);
            int currentPoint = listQueen.get(i).getHealthPoint();
            if (currentPoint < 0) {
                currentPoint = 0;
            }
            System.out.print(currentPoint + " ");
            if (currentPoint < 20) {
                System.out.println("dead");
            } else {
                System.out.println("alive");
            }
        }
    }

    public void setListQueen(ArrayList<Queen> listQueen) {
        this.listQueen = listQueen;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

}

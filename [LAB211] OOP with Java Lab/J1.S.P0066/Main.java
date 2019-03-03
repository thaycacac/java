
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thaycacac
 */
class ExceptionCar extends Exception {

    public ExceptionCar() {
    }

    public ExceptionCar(String message) {
        super(message);
    }
}

public class Main {

    private static final Scanner in = new Scanner(System.in);

    private static String checkInputString() throws ExceptionCar {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 0) {
                throw new ExceptionCar("Not empty");
            } else {
                return result;
            }
        }
    }

    private static int checkInputInt() throws ExceptionCar {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result <= 0) {
                    throw new ExceptionCar("Price greater than zero");
                }
                return result;
            } catch (NumberFormatException ex) {
                throw new ExceptionCar("Price is digit");
            }

        }
    }

    private static boolean checkYN() throws ExceptionCar {
        while (true) {
            String result = checkInputString();
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.err.println("Re-input");
        }
    }

    private static boolean checkCarExist(Car car, String color, int price,
            String today) throws ExceptionCar {
        boolean check = false;
        String[] listColor = car.getColer();
        int[] listPrice = car.getPrice();
        String[] listSold = car.getSoldOn();
        if (!color.equalsIgnoreCase("no color")) {
            for (int i = 0; i < listColor.length; i++) {
                if (color.equalsIgnoreCase(listColor[i])) {
                    check = true;
                    break;
                }
            }
        } else {
            check = true;
        }
        if (check == false) {
            throw new ExceptionCar("Color Car does not exist");
        }
        check = false;
        for (int i = 0; i < listPrice.length; i++) {
            if (price == listPrice[i] - 100) {
                check = true;
            }
        }
        if (check == false) {
            throw new ExceptionCar("Price Car does not exist");
        }
        check = false;
        for (int i = 0; i < listSold.length; i++) {
            if (today.equalsIgnoreCase(listSold[i])) {
                check = true;
            }
        }
        if (check == false) {
            throw new ExceptionCar("Car can't sell today");
        }
        return true;
    }

    private static void addCar(ArrayList<Car> lc) {
        String[] listColorAudi = {"White", "Yellow", "Orange"};
        int[] listPriceAudi = {5500, 3000, 4500};
        String[] listSoldDayAudi = {"Friday", "Sunday", "Monday"};
        lc.add(new Car("Audi", listColorAudi, listPriceAudi, listSoldDayAudi));

        String[] listColorMercedes = {"Green", "Blue", "Purple"};
        int[] listPriceMercedes = {5000, 6000, 8500};
        String[] listSoldDayMercedes = {"TueDay", "Saturday", "Wednesday"};
        lc.add(new Car("Mercedes", listColorMercedes, listPriceMercedes,
                listSoldDayMercedes));

        String[] listColorBMW = {"Pink", "Red", "Brown"};
        int[] listPriceBMW = {2500, 3000, 3500};
        String[] listSoldDayBMW = {"Monday", "Sunday", "Thurday"};
        lc.add(new Car("BMW", listColorBMW, listPriceBMW, listSoldDayBMW));
    }

    private static boolean checkNameCar(ArrayList<Car> lc, String name, String color,
            int price, String today) throws ExceptionCar {
        boolean check = false;
        for (int i = 0; i < lc.size(); i++) {
            if (name.equalsIgnoreCase(lc.get(i).getNameCar())) {
                if (checkCarExist(lc.get(i), color, price, today)) {
                    System.out.println("Sell Car");
                    System.out.print("Do you want find more?(Y/N): ");
                    if (!checkYN()) {
                        return false;
                    }
                } else {
                    System.out.println("Car break");
                }
                check = true;
                break;
            }
        }
        if (check == false) {
            throw new ExceptionCar("Can't find car.");
        }
        return true;
    }

    private static void display() throws ExceptionCar {
        ArrayList<Car> lc = new ArrayList<>();
        addCar(lc);
        System.out.println("Input information of car");
        while (true) {
            System.out.print("Name: ");
            String name = checkInputString();
            System.out.print("Color: ");
            String color = checkInputString();
            System.out.print("Price: ");
            int price = checkInputInt();
            System.out.print("Today: ");
            String today = checkInputString();
            if (!checkNameCar(lc, name, color, price, today)) {
                return;
            }
        }
    }

    public static void main(String[] args) throws ExceptionCar {
        display();
    }
}

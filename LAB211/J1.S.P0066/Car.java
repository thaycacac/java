
/**
 *
 * @author thaycacac
 */
public class Car {

    private String nameCar;
    private String[] color;
    private int[] Price;
    private String[] soldOn;

    public Car() {
    }

    public Car(String nameCar, String[] color, int[] Price, String[] soldOn) {
        this.nameCar = nameCar;
        this.color = color;
        this.Price = Price;
        this.soldOn = soldOn;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String[] getColer() {
        return color;
    }

    public void setColer(String[] color) {
        this.color = color;
    }

    public int[] getPrice() {
        return Price;
    }

    public void setPrice(int[] Price) {
        this.Price = Price;
    }

    public String[] getSoldOn() {
        return soldOn;
    }

    public void setSoldOn(String[] soldOn) {
        this.soldOn = soldOn;
    }

}

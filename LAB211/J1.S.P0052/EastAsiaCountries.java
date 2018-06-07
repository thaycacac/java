package Manager;

/**
 *
 * @author THAYCACAC
 */
public class EastAsiaCountries {

    protected String countryCode;
    protected String countryName;
    protected double countryArea;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryCode, String countryName, double countryArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryArea = countryArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(double countryArea) {
        this.countryArea = countryArea;
    }

    public void display() {

    }
}

package entity;

/**
 *
 * @author Thaycacac
 */
public class Contact {

    private int id;
    private String type;
    private String key;
    private String value;

    public Contact() {
    }

    public Contact(int id, String type, String key, String value) {
        this.id = id;
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

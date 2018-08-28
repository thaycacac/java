package dataobj;

/**
 *
 * @author Thaycacac
 */
public class Job {

    private int id;
    private String title;
    private String companyCode;
    private int exp;
    private String des;

    public Job() {
    }

    public Job(int id, String title, String companyCode, int exp, String des) {
        this.id = id;
        this.title = title;
        this.companyCode = companyCode;
        this.exp = exp;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}

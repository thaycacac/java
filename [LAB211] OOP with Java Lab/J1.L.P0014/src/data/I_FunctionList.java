package data;

public interface I_FunctionList {

    String encode();  // Convert String password to MD5 Hashing

    int login(); // Login for employee and manager

    int find(String code); // Find index and return index

    void searchAssetByName();

    void add();

    void update();

    void approveRequest();

    void printBrrowList();

    void printAssetList();


}

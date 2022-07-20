/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

/**
 *
 * @author Trung.Hoang
 */
public class AssetManagerment extends ArrayList<AssetID> implements I_FunctionList {

    ArrayList<AssetID> list;
    int index;
    File file;
    AssetList asl = new AssetList();
    BorrowList brl = new BorrowList();
    RequestList rql = new RequestList();
    EmployeeList epl = new EmployeeList();
    String accountName;

    public AssetManagerment() {
    }

    public AssetManagerment(ArrayList<AssetID> list, int index, File file, int initialCapacity) {
        super(initialCapacity);
        this.list = list;
        this.index = index;
        this.file = file;
    }

    public AssetManagerment(ArrayList<AssetID> list, int index, File file) {
        this.list = list;
        this.index = index;
        this.file = file;
    }

    public AssetManagerment(ArrayList<AssetID> list, int index, File file, Collection<? extends AssetID> c) {
        super(c);
        this.list = list;
        this.index = index;
        this.file = file;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public ArrayList<AssetID> getList() {
        return list;
    }

    public void setList(ArrayList<AssetID> list) {
        this.list = list;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public AssetList getAsl() {
        return asl;
    }

    public void setAsl(AssetList asl) {
        this.asl = asl;
    }

    public BorrowList getBrl() {
        return brl;
    }

    public void setBrl(BorrowList brl) {
        this.brl = brl;
    }

    public RequestList getRql() {
        return rql;
    }

    public void setRql(RequestList rql) {
        this.rql = rql;
    }

    public EmployeeList getEpl() {
        return epl;
    }

    public void setEpl(EmployeeList epl) {
        this.epl = epl;
    }

    public void addIntforToFile() {
        epl.addInforToFile();
        asl.addInforToFile();
        brl.addInforToFile();
        rql.addInforToFile();
    }

    @Override
    public String encode() {
        try {
            String input =Utils.getString("Password: ");
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int login() {
        accountName = Utils.getString("Employee ID: ");
        String password = encode();
        int type;
        type = epl.checkLogin(accountName, password);
        return type;
    }

    @Override
    public int find(String code) {
        index = list.indexOf(new Asset(code));
        return index;
    }

    @Override
    public void searchAssetByName() {
        asl.searchAssetList();
    }

    @Override
    public void printAssetList() {
        asl.showAssetList();
    }

    @Override
    public void add() {
        asl.createAsset();
    }

    @Override
    public void update() {
        asl.updateAsset();
    }

    @Override
    public void approveRequest() {
        rql.showRequest();
        String inputApproveRID = Utils.getString("Input the 'Request ID' that you want to approve: ");
        try {
            int quantityOfRequest = rql.gQuantity(inputApproveRID);
            String getAssetID = rql.gAssetID(inputApproveRID);
            int quantityOfAsset = asl.getQuantity(getAssetID);
            String gEmployee = rql.gEmployeeID(inputApproveRID);
            if (quantityOfRequest > quantityOfAsset) {
                System.out.println("Error! Not enough 'Quantity'");
            } else {
                // Insert new information into file brrow.dat
                brl.insertData(getAssetID, gEmployee, quantityOfRequest);
                // Remove the data line in the file request.dat
                rql.removeData(inputApproveRID);
                // Update the quantity of asset in asset.dat file
                asl.updateReductionQuantity(quantityOfRequest, getAssetID);
                System.out.println("Accepted request " + inputApproveRID);
                String checkQuit = Utils.getYesNo("Do you want to continue (Yes/No): ");
                if (checkQuit.equalsIgnoreCase("Yes")){
                    approveRequest();
                }
            }
        } catch (Exception e) {
            String check = Utils.getYesNo("Not found 'Request ID', do you want to input again (Yes/No): ");
            if (check.equalsIgnoreCase("Yes")) {
                approveRequest();
            }
        }
    }

    @Override
    public void printBrrowList() {
        brl.showBorrow();
    }

    
// ------------------------------------------------- LAB 3 -------------------------------------------------
    
    @Override
    public void borrowTheAssets() {
        asl.showAssetList();
        String aID = Utils.getString("Input the 'AssetID' that you want to borrow: ");
        if (asl.checkAID(aID) == 0) {
            System.out.println("The 'Asset ID' you input is not in the system, please re-enter it");
            borrowTheAssets();
        } else {
            int qRequest = Utils.getGreaterThan0("Input the 'Quantity' that you want to borrow: ");
            rql.createRequest(aID, accountName, qRequest);
            String check = Utils.getYesNo("Continue (Yes/No): ");
            if (check.equalsIgnoreCase("Yes")) {
                borrowTheAssets();
            }
        }
    }

    @Override
    public void cancelRequest() {
        int check = rql.showRequestByEmID(accountName);
        int count = -1;
        int x = 1;
        if (check == -1) {
            System.out.println("Your information is not in the system 'Request List'!");
        } else {
            String rIDDelete = Utils.getString("Input the 'Request ID' that you want to cancel: ");
            int checkInputID = rql.checkInputRID(rIDDelete);
            if (checkInputID != -1) {
                String check1 = Utils.getYesNo("Are you sure you want to cancel the request (Yes/No): ");
                if (check1.equalsIgnoreCase("Yes")) {
                    // Remove data line of the request list 
                    rql.removeData(rIDDelete);
                    System.out.println("Request Cancedled");
                } else {
                    System.out.println("Action Canceled");
                }
            } else {
                count = 1;
            }
            // Input Error 'Request ID'
            if (count == 1) {
                x = 2;
                String check2 = Utils.getYesNo("Input Error 'Request ID', Input Again (Yes/No): ");
                if (check2.equalsIgnoreCase("Yes")) {
                    cancelRequest();
                }
            }
            // Ask to continuous or go back to the main menu
            if (x != 2) {
                String check3 = Utils.getYesNo("Continue? (Yes/No): ");
                if (check3.equalsIgnoreCase("Yes")) {
                    cancelRequest();
                }
            }
        }
    }

    @Override
    public void returnRequest() {
        int count = -1;
        String assetID = null;
        int quantityOfAsset = -1;
        int x = 1;
        int check = brl.showBorrowByEmID(accountName);
        if (check == -1) {
            System.out.println("Your information is not in the system 'Request List'!");
        } else {
            String bIDDelete = Utils.getString("Input the 'Borrow ID' that you want to return: ");
            int checkInputID = brl.checkInputBID(bIDDelete);
            if (checkInputID != -1) {
                String check1 = Utils.getYesNo("Are you sure you want to return the borrow (Yes/No): ");
                if (check1.equalsIgnoreCase("Yes")) {
                    quantityOfAsset = brl.getQuantityBeforeRemove(bIDDelete);
                    assetID = brl.getAIDBeforeRemove(bIDDelete);
                    // Remove data line of the borrow list
                    brl.removeData(bIDDelete);
                    // Update quantity of the asset at stock (asset.dat file)
                    asl.updateIncreaseQuantity(quantityOfAsset, assetID);
                    System.out.println("Return Done");
                } else {
                    System.out.println("Action Canceled");
                }
            } else {
                count = 1;
            }
            // Input Error 'Boorow ID'
            if (count == 1) {
                x = 2;
                String check2 = Utils.getYesNo("Input Error 'Boorow ID', Input Again (Yes/No): ");
                if (check2.equalsIgnoreCase("Yes")) {
                    returnRequest();
                }
            }
            // Ask to continuous or go back to the main menu
            if (x != 2) {
                String check3 = Utils.getYesNo("Continue? (Yes/No): ");
                if (check3.equalsIgnoreCase("Yes")) {
                    returnRequest();
                }
            }
        }

    }
}

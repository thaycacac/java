/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Trung.Hoang
 */
public class AssetList extends ArrayList<Asset> implements Serializable {

    ArrayList<Asset> list;
    Asset as;
    Asset asTest;
    int index;
    private static final String NAME_OF_FILE_ASSET = "asset.dat";

    public AssetList() {
        this.list = new ArrayList<>();
        this.as = null;
    }

    public ArrayList<Asset> getList() {
        return list;
    }

    public void setList(ArrayList<Asset> list) {
        this.list = list;
    }

    public Asset getAs() {
        return as;
    }

    public void setAs(Asset as) {
        this.as = as;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void addInforToFile(){
        list.add(new Asset("A001", "Samsung projector", "White", 500, 3.2, 10));
        list.add(new Asset("A002", "Macbook pro 2016", "Sliver", 1000, 2.2, 5));
        list.add(new Asset("A003", "Ipad 3", "Black", 700, 1.6, 2));
        writeFileAsset();
    }

    public String createAID() {
        String id = null;
        int countElement = list.size();
        if (countElement == 0) {
            id = "A001";
        } else {
            // Get the id of the last element
            asTest = new Asset();
            int index = list.size() - 1;
            asTest = list.get(index);
            String gID = asTest.getAssetID();
            // Split number to get int > 0
            Pattern p = Pattern.compile("[^w][^0]");
            Matcher m = p.matcher(gID);
            String daTach = null;
            int num = 0;
            while (m.find()) {
                daTach = m.group();
                num = Integer.parseInt(daTach);
            }
            id = String.format("A%03d", num + 1);
            // 0 - để đệm với số không
            // 3 - để đặt chiều rộng thành 3
        }
        return id;
    }

    public void createAsset() {
        readFileAsset();
        as = new Asset();
        as.createAssetID(createAID());
        list.add(as);

        // Check save to file asset.dat
        String check;
        check = Utils.getYesNo("Do you want to save to file asset.dat (Yes/No): ");
        if (check.equalsIgnoreCase("Yes")) {
            writeFileAsset();
            System.out.println("Saved");
        } else {
            System.out.println("Not save!");
        }
        String checkk;
        checkk = Utils.getYesNo("Continue? (Yes/No): ");
        if (checkk.equalsIgnoreCase("Yes")) {
            createAsset();
        }
    }

    public int find(String code) {
        index = list.indexOf(new Asset(code));
        return index;
    }

    public void updateAsset() {
        readFileAsset();
        String text = Utils.getString("Enter the Asset ID that you want to update: ");
        this.index = find(text);
        if (index != -1) {
            as = list.get(index);
            as.getAssetID();
            as.updateAssetID(text);
            list.set(index, as);
            System.out.println("Updated!");
            System.out.println("-  The result of the update: ");
            System.out.println("\n\n      ----------------------------------------- ASSET LIST -----------------------------------------");
            for (AssetID asset : list) {
                System.out.println("     " + asset.toString());
            }
            System.out.println("\n");
            // Save to file asset.dat
            String check;
            check = Utils.getYesNo("\nDo you want to save to file asset.dat (Yes/No): ");
            if (check.equalsIgnoreCase("Yes")) {
                writeFileAsset();
                System.out.println("Saved");
            } else {
                System.out.println("Not save!");
            }
            System.out.println("\n");
        } else {
            System.out.println("Asset does not exist!");
        }

    }

    public void updateReductionQuantity(int quantityOfRequest, String getAssetID) {
        readFileAsset();
        for (Asset x : list) {
            if (getAssetID.equals(x.getAssetID())) {
                int k = x.getQuantity();
                k = k - quantityOfRequest;
                x.setQuantity(k);
                writeFileAsset();
            }
        }
    }
    
    public void updateIncreaseQuantity(int quantityOfRequest, String getAssetID){
        readFileAsset();
        for (Asset x : list) {
            if (getAssetID.equals(x.getAssetID())) {
                int k = x.getQuantity();
                k = k + quantityOfRequest;
                x.setQuantity(k);
                writeFileAsset();
            }
        }
    }

    public int getQuantity(String assetID) {
        readFileAsset();
        int quantity = 0;
        for (Asset li : list) {
            if (assetID.equals(li.getAssetID())) {
                quantity = li.getQuantity();
                break;
            }
        }
        return quantity;
    }
    
    public int checkAID(String assetID) {
        readFileAsset();
        int count = 0;
        for (Asset li : list) {
            if (assetID.equals(li.getAssetID())) {
                count ++;
                break;
            }
        }
        return count;
    }

    public void searchAssetList() {
        readFileAsset();
        ArrayList<Asset> clonelist = (ArrayList<Asset>) list.clone();
        Collections.sort(clonelist, new Comparator<Asset>() {
            @Override
            public int compare(Asset c1, Asset c2) {
                return (c2.assetID.compareTo(c1.assetID));
            }
        });
        String text = Utils.getString("Enter the name asset you want to find: ");
        int count = 0;
        for (Asset oo : clonelist) {
            if (oo.getName() != null && oo.getName().contains(text)) {
                count++;
                System.out.println(oo.toString());
            }
        }
        if (count == 0) {
            System.out.println("Not found!");
        }
    }

    public void showAssetList() {
        readFileAsset();
        System.out.println("      ----------------------------------------- ASSET LIST -----------------------------------------");
        for (Asset li : list) {
            System.out.println(li);
        }
        System.out.println("\n");
    }

    public void readFileAsset() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(NAME_OF_FILE_ASSET);
            ois = new ObjectInputStream(fis);
            list = (ArrayList<Asset>) ois.readObject();
//            for (Asset li : list) {
//                System.out.println(li);
//            }
//            System.out.println("\n");
        } catch (FileNotFoundException ex) {
            try {
                File file = new File(NAME_OF_FILE_ASSET);
                file.createNewFile();
                writeFileAsset();
            } catch (IOException ex1) {
            }
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    public void writeFileAsset() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(NAME_OF_FILE_ASSET);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                }
            }
        }
    }

}

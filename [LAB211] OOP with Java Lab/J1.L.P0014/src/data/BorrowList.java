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
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Trung.Hoang
 */
public class BorrowList extends ArrayList<Borrow> {

    ArrayList<Borrow> list = new ArrayList<>();
    Borrow br;
    Borrow brTest;
    File file;
    int index;

    private static final String NAME_OF_FILE_BORROW = "borrow.dat";

    public BorrowList() {
    }

    public ArrayList<Borrow> getList() {
        return list;
    }

    public void setList(ArrayList<Borrow> list) {
        this.list = list;
    }

    public Borrow getBr() {
        return br;
    }

    public void setBr(Borrow br) {
        this.br = br;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void addInforToFile(){
        list.add(new Borrow("B001", "A001", "E160001", 1, "23-12-2021 15:13:46"));
        list.add(new Borrow("B002", "A001", "E160001", 2, "25-12-2021 16:14:56"));
        list.add(new Borrow("B003", "A002", "E160798", 3, "15-12-2021 17:15:52"));
        list.add(new Borrow("B004", "A001", "E160240", 2, "26-12-2021 12:16:53"));
        list.add(new Borrow("B005", "A003", "E140449", 1, "23-12-2021 15:13:46"));
        writeFileBorrow();
    }
    
    public String createBID() {
        String id = null;
        int countElement = list.size();
        if (countElement == 0) {
            id = "B001";
        } else {
            // Get the id of the last element
            brTest = new Borrow();
            int index = list.size() - 1;
            brTest = list.get(index);
            String gID = brTest.getbID();
            // Split number to get int > 0
            Pattern p = Pattern.compile("[^w][^0]");
            Matcher m = p.matcher(gID);
            String daTach = null;
            int num = 0;
            while (m.find()) {
                daTach = m.group();
                num = Integer.parseInt(daTach);
            }
            id = String.format("B%03d", num + 1);
            // 0 - để đệm với số không
            // 3 - để đặt chiều rộng thành 3
        }
        return id;
    }

    public void showBorrow() {
        System.out.println("     ------------------------------------------- BORROW LIST -------------------------------------------");
        readFileBorrow();
        for (Borrow borrow : list) {
            System.out.println(borrow.toString());
        }
        System.out.println("\n");
    }

    public void insertData(String assetID, String employeeID, int quantity) {
        readFileBorrow();
        br = new Borrow();
        br.insertBorrow(createBID(), assetID, employeeID, quantity);
        list.add(br);
        writeFileBorrow();
    }

    public int showBorrowByEmID(String emID) {
        readFileBorrow();
        int count = -1;
        for (Borrow z : list) {
            if (emID.equals(z.getEmployyID())) {
                System.out.println(z);
                count++;
            }
        }
        System.out.println("");
        return count;
    }

    public int checkInputBID(String bID) {
        readFileBorrow();
        int check = -1;
        for (Borrow q : list) {
            if (bID.equals(q.getbID())) {
                check++;
            }
        }
        return check;
    }

    public void removeData(String inputBID) {
        readFileBorrow();
        index = 0;
        for (Borrow x : list) {
            if (inputBID.equals(x.getbID())) {
                break;
            } else {
                index++;
            }
        }
        list.remove(index);
        writeFileBorrow();
    }

    public String getAIDBeforeRemove(String inputBID) {
        String returnAID = null;
        readFileBorrow();
        index = 0;
        for (Borrow x : list) {
            if (inputBID.equals(x.getbID())) {
                returnAID = x.getAssetID();
                break;
            } else {
                index++;
            }
        }
        return returnAID;
    }

    public int getQuantityBeforeRemove(String inputBID) {
        int returnQ = -1;
        readFileBorrow();
        index = 0;
        for (Borrow x : list) {
            if (inputBID.equals(x.getbID())) {
                returnQ = x.getQuantity();
                break;
            } else {
                index++;
            }
        }
        return returnQ;
    }

    public void readFileBorrow() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(NAME_OF_FILE_BORROW);
            ois = new ObjectInputStream(fis);
            list = (ArrayList<Borrow>) ois.readObject();
//            for (Borrow vhc : list) {
//                System.out.println(vhc);
//            }
        } catch (FileNotFoundException ex) {
            try {
                File file = new File(NAME_OF_FILE_BORROW);
                file.createNewFile();
                writeFileBorrow();
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

    public void writeFileBorrow() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(NAME_OF_FILE_BORROW);
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

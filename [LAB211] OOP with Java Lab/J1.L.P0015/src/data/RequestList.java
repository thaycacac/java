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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Trung.Hoang
 */
public class RequestList extends ArrayList<Request> implements Serializable {

    ArrayList<Request> list;
    Request cd;
    Request rqTest;
    int index;

    private static final String NAME_OF_FILE_REQUEST = "request.dat";

    public RequestList() {
        this.list = new ArrayList<>();
        this.cd = null;
    }

    public ArrayList<Request> getList() {
        return list;
    }

    public void setList(ArrayList<Request> list) {
        this.list = list;
    }

    public Request getCd() {
        return cd;
    }

    public void setCd(Request cd) {
        this.cd = cd;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void addInforToFile(){
        list.add(new Request("R001", "A001", "E140449", 1, "23-12-2021 13:17:56"));
        list.add(new Request("R002", "A002", "E160001", 1, "24-12-2021 12:18:56"));
        list.add(new Request("R003", "A001", "E160798", 1, "23-12-2021 11:19:56"));
        list.add(new Request("R004", "A002", "E160240", 1, "24-12-2021 10:10:56"));
        list.add(new Request("R005", "A003", "E160001", 10, "24-12-2021 10:10:56"));
        writeFileRequest();
    }

    public String createRID() {
        String id = null;
        int countElement = list.size();
        if (countElement == 0) {
            id = "R001";
        } else {
            // Get the id of the last element
            rqTest = new Request();
            int index = list.size() - 1;
            rqTest = list.get(index);
            String gID = rqTest.getrID();
            // Split number to get int > 0
            Pattern p = Pattern.compile("[^w][^0]");
            Matcher m = p.matcher(gID);
            String daTach = null;
            int num = 0;
            while (m.find()) {
                daTach = m.group();
                num = Integer.parseInt(daTach);
            }
            id = String.format("R%03d", num + 1);
            // 0 - để đệm với số không
            // 3 - để đặt chiều rộng thành 3
        }
        return id;
    }

//    public void createRequestByHand() {
//        readFileRequest();
//        String aID = Utils.getString("Asset ID: ");
//        String eID = Utils.getString("Employee ID: ");
//        cd = new Request();
//        cd.createRequestByHand(createAID(), aID, eID);
//        list.add(cd);
//
//        System.out.println("Request added !");
//        System.out.println("");
//    }
    
    public void createRequest(String asID, String emID, int q){
        readFileRequest();
        cd = new Request();
        cd.createRequest(createRID(), asID, emID, q);
        list.add(cd);
        writeFileRequest();
    }

    public void showRequest() {
        System.out.println("       ------------------------------------------- REQUEST LIST -------------------------------------------");
        readFileRequest();
        for (Request rq : list) {
            System.out.println(rq);
        }
        System.out.println("\n");
    }

    public int gQuantity(String approveRequest) {
        int quantityOfRequest = -1;
        readFileRequest();
        for (Request x : list) {
            if (approveRequest.equals(x.getrID())) {
                quantityOfRequest = x.getQuantity();
                break;
            }
        }
        return quantityOfRequest;
    }

    public String gAssetID(String approveRequest) {
        String asID = null;
        readFileRequest();
        for (Request x : list) {
            if (approveRequest.equals(x.getrID())) {
                asID = x.getAssetID();
                break;
            }
        }
        return asID;
    }

    public String gEmployeeID(String approveRequest) {
        String eID = null;
        readFileRequest();
        for (Request x : list) {
            if (approveRequest.equals(x.getrID())) {
                eID = x.getEmployeeID();
                break;
            }
        }
        return eID;
    }

    public void removeData(String inputRID) {
        readFileRequest();
        index = 0;
        for (Request x : list) {
            if (inputRID.equals(x.getrID())) {
                break;
            } else {
                index++;
            }
        }
        list.remove(index);
        writeFileRequest();
    }
    
    public int checkInputRID(String rID){
        readFileRequest();
        int check = -1;
        for (Request q : list) {
            if (rID.equals(q.getrID())){
                check++;
            }
        }
        return check;
    }
    
    public int showRequestByEmID(String emID){
        readFileRequest();
        int count = -1;
        for (Request z : list) {
            if (emID.equals(z.getEmployeeID())){
                System.out.println(z);
                count ++;
            }
        }
        System.out.println("");
        return count;
    }

    public void readFileRequest() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(NAME_OF_FILE_REQUEST);
            ois = new ObjectInputStream(fis);
            list = (ArrayList<Request>) ois.readObject();
//            for (Request vhc : list) {
//                System.out.println(vhc);
//            }
        } catch (FileNotFoundException ex) {
            try {
                File file = new File(NAME_OF_FILE_REQUEST);
                file.createNewFile();
                writeFileRequest();
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

    public void writeFileRequest() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(NAME_OF_FILE_REQUEST);
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

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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trung.Hoang
 */
public class VehicleList extends ArrayList<Vehicle> implements I_FunctionList {

    ArrayList<Vehicle> list = new ArrayList<>();
    Vehicle vh;
    private int index;
    File file;

    public VehicleList() {
    }

    public VehicleList(Vehicle vh, int index, File file, int initialCapacity) {
        super(initialCapacity);
        this.vh = vh;
        this.index = index;
        this.file = file;
    }

    public VehicleList(Vehicle vh, int index, File file) {
        this.vh = vh;
        this.index = index;
        this.file = file;
    }

    public VehicleList(Vehicle vh, int index, File file, Collection<? extends Vehicle> c) {
        super(c);
        this.vh = vh;
        this.index = index;
        this.file = file;
    }

    public ArrayList<Vehicle> getList() {
        return list;
    }

    public void setList(ArrayList<Vehicle> list) {
        this.list = list;
    }

    public Vehicle getVh() {
        return vh;
    }

    public void setVh(Vehicle vh) {
        this.vh = vh;
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

    @Override
    public void add() {
        int choice;
        try {
            do {
                System.out.println("\n     ADD VEHICLE MENU");
                System.out.println("    1 - Add Car");
                System.out.println("    2 - Add Motorbike");
                System.out.println("    Other - Back to menu \n");
                choice = Utils.getInt("Enter your choice: ");
                switch (choice) {
                    case 1:
                        vh = new Car();
                        vh.createVehicle();
                        index = list.indexOf(vh);
                        if (index == -1) {
                            list.add(vh);
                            System.out.println("Added!");
                        } else {
                            System.out.println("Dupplicated!");
                        }
                        System.out.println("");
                        break;
                        
                    case 2:
                        vh = new Motorbike();
                        vh.createVehicle();
                        index = list.indexOf(vh);
                        if (index == -1) {
                            list.add(vh);
                            System.out.println("Added!");
                        } else {
                            System.out.println("Dupplicated!");
                        }
                        System.out.println("");
                        break;
                }
            } while (choice >= 1 && choice <= 2);
        } catch (Exception e) {
        }
    }

    // Find index.
    @Override
    public int find(String code) {
        index = list.indexOf(new Car(code));
        return index;
    }

    @Override
    public void delete() {
        this.index = find(Utils.getString("Enter Vehicle ID that you want to delete, required to enter correct Vehicle ID including uppercase and lowercase: "));
        String check;
        if (index != -1) {
            check = Utils.getYesNo("Are you sure you want to delete (Yes/No)? ");
            if (check.equalsIgnoreCase("Yes")) {
                list.remove(index);
                System.out.println("Success!");
            } else {
                System.out.println("Fail!");
            }
        } else {
            System.out.println("Not found!");
        }
    }

    @Override
    public void update() {
        this.index = find(Utils.getString("Enter the Vehicle ID that you want to update, required to enter correct Vehicle ID including uppercase and lowercase: "));
        if (index != -1) {
            vh = list.get(index);
            vh.updateVehicle();
            list.set(index, vh);
            System.out.println("Updated!");
            System.out.println("The result of the update: \n" + vh.toString());
        } else {
            System.out.println("Vehicle does not exist!");
        }
    }

    @Override
    public void search() {
        int choice;
        String text1, text2;
        int count1 = 0;
        int count2 = 0;
        
        try {
            do {
                System.out.println("\n        SEARCH VEHICLE MENU");
                System.out.println("    1 - Search by vehicle name");
                System.out.println("    2 - Search by vehicle id");
                System.out.println("    Other - Back to menu \n");
                choice = Utils.getInt("Enter your choice: ");
                switch (choice) {
                    case 1: // Search by vehicle Name (descending).
                        text1 = Utils.getString("Enter the vehicle name you want to find: ");
                        ArrayList<Vehicle> clonelist = (ArrayList<Vehicle>) list.clone();
                        Collections.sort(clonelist, new Comparator<Vehicle>() {
                            @Override
                            public int compare(Vehicle c1, Vehicle c2) {
                                return (c2.vehicleId.compareTo(c1.vehicleId));
                            }
                        });
                        for (Vehicle oo : clonelist) {
                            if (oo.getName() != null && (oo.getName().contains(text1))) {
                                System.out.println(oo.toString());
                                count1 ++;
                            }
                        }
                        if (count1 == 0) {
                            System.out.println("Not found!");
                        }
                        System.out.println("");
                        break;
                        
                    case 2: // Search by Vehicle ID.
                        text2 = Utils.getString("Enter the Vehicle ID you want to find, required to enter correct ID including uppercase and lowercase: ");
                        for (Vehicle vh : list) {
                            if (vh.getVehicleId() != null && vh.getVehicleId().equals(text2)) {
                                System.out.println(vh.toString());
                                count2 = 1;
                                break;
                            }
                        }
                        if (count2 != 1) {
                            System.out.println("Not found!");
                        }
                }
            } while (choice >= 1 && choice <= 2);
        } catch (Exception e) {
        }
    }

    @Override
    public void output() {
        int choice;
        try {
            do {
                System.out.println("\n     SHOW VEHICLE MENU");
                System.out.println("    1 - Show all");
                System.out.println("    2 - Show descending by price");
                System.out.println("    Other - Back to menu \n");
                choice = Utils.getInt("Enter your choice: ");
                switch (choice) {
                    case 1: // Show all.
                        for (Vehicle zo : list) {
                            System.out.println(zo.toString());
                        }
                        System.out.println("");
                        break;
                        
                    case 2: // Show descending by Price.
                        ArrayList<Vehicle> clonelist = (ArrayList<Vehicle>) list.clone();
                        Collections.sort(clonelist, new Comparator<Vehicle>() {
                            @Override
                            public int compare(Vehicle c1, Vehicle c2) {
                                if (c1.price < c2.price) {
                                    return 1;
                                } else {
                                    if (c1.price == c2.price) {
                                        return 0;
                                    } else {
                                        return -1;
                                    }
                                }
                            }
                        });
                        for (Vehicle zo : clonelist) {
                            System.out.println(zo.toString());
                        }
                        System.out.println("");
                        break;
                }
            } while (choice >= 1 && choice <= 2);
        } catch (Exception e) {
        }
    }

    @Override
    public void readFile() {
        System.out.println("                                                   vehicle_file.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("vehicle_file.txt");
            ois = new ObjectInputStream(fis);
            list = (ArrayList<Vehicle>) ois.readObject();
            for (Vehicle vhc : list) {
                System.out.println(vhc);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void writeFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("vehicle_file.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("Saved!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(VehicleList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

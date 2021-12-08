/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 */
public class Storekeeper {
    private int StorekeeperID;
    private String StorekeeperName;

    public Storekeeper() {
    }

    public Storekeeper(int StorekeeperID, String StorekeeperName) {
        this.StorekeeperID = StorekeeperID;
        this.StorekeeperName = StorekeeperName;
    }
    
    public int getStorekeeperID() {
        return StorekeeperID;
    }

    public void setStorekeeperID(int StorekeeperID) {
        this.StorekeeperID = StorekeeperID;
    }

    public String getStorekeeperName() {
        return StorekeeperName;
    }

    public void setStorekeeperName(String StorekeeperName) {
        this.StorekeeperName = StorekeeperName;
    }

    @Override
    public String toString() {
        return StorekeeperName;
    }
    
    
}

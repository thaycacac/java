/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author Trung.Hoang
 */
public abstract class AssetID implements Serializable {

    protected String assetID;

    public AssetID() {
    }

    public AssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getAssetID() {
        return assetID;
    }
    
    protected void createAssetID(String id) {
        this.assetID = id;
    }


    protected void updateAssetID(String id) {
        this.assetID = id;
    }
    
    @Override
    public String toString() {
        return "Asset ID = " + assetID;
    }

    @Override
    public boolean equals(Object obj) {
        return this.assetID.equals(((AssetID) obj).getAssetID());
    }

}

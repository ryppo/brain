package org.y3.brain.database.petrolstation;

import org.y3.commons.model.IModel;

/** 
 * <p>Title: org.y3.brain.database.petrolstation - PetrolStation_model</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class PetrolStation_model extends IModel {
    
    private int id;
    private String FP;
    private String brand;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFP() {
        return FP;
    }

    public void setFP(String FP) {
        this.FP = FP;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

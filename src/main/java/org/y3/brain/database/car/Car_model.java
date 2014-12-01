package org.y3.brain.database.car;

import org.y3.commons.model.IModel;

/** 
 * <p>Title: org.y3.brain.database.car - Car_model</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class Car_model extends IModel {
    
    private int id;
    private String FP;
    private String name;
    private String ownerPersonFP;

    public String getOwnerPersonFP() {
        return ownerPersonFP;
    }

    public void setOwnerPersonFP(String ownerPersonFP) {
        this.ownerPersonFP = ownerPersonFP;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

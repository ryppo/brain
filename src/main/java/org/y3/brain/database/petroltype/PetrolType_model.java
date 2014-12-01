package org.y3.brain.database.petroltype;

import org.y3.commons.model.IModel;

/** 
 * <p>Title: org.y3.brain.database.petroltype - PetrolType_model</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class PetrolType_model extends IModel {
    
    private int id;
    private String FP;
    private String name;
    private double qualityInOctan;

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

    public double getQualityInOctan() {
        return qualityInOctan;
    }

    public void setQualityInOctan(double qualityInOctan) {
        this.qualityInOctan = qualityInOctan;
    }

}

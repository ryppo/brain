package org.y3.brain.database.car;

import org.y3.brain.database.person.Person_model;

/** 
 * <p>Title: org.y3.brain.database.car - Car_modelRich</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class Car_modelRich extends Car_model {
    
    private Person_model carOwner;

    public Person_model getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(Person_model carOwner) {
        this.carOwner = carOwner;
    }

}

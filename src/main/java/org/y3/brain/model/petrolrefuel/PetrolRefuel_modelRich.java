package org.y3.brain.model.petrolrefuel;

import org.y3.brain.model.car.Car_model;
import org.y3.brain.model.currency.Currency_model;
import org.y3.brain.model.person.Person_model;
import org.y3.brain.model.petrolstation.PetrolStation_model;
import org.y3.brain.model.petroltype.PetrolType_model;
import org.y3.brain.database.tire.TireType_model;

/** 
 * <p>Title: org.y3.brain.model.petrolrefuel - PetrolRefuel_modelRich</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class PetrolRefuel_modelRich extends PetrolRefuel_model {
    
    private Car_model refueledCar;
    private Person_model refuelerPerson;
    private Currency_model currency;
    private PetrolStation_model refuledAtPetrolStation;
    private PetrolType_model refuledPetrolType;
    private TireType_model usedTireType;

    public TireType_model getUsedTireType() {
        return usedTireType;
    }

    public void setUsedTireType(TireType_model usedTireType) {
        this.usedTireType = usedTireType;
    }

    public PetrolType_model getRefuledPetrolType() {
        return refuledPetrolType;
    }

    public void setRefuledPetrolType(PetrolType_model refuledPetrolType) {
        this.refuledPetrolType = refuledPetrolType;
    }

    public PetrolStation_model getRefuledAtPetrolStation() {
        return refuledAtPetrolStation;
    }

    public void setRefuledAtPetrolStation(PetrolStation_model refuledAtPetrolStation) {
        this.refuledAtPetrolStation = refuledAtPetrolStation;
    }

    public Currency_model getCurrency() {
        return currency;
    }

    public void setCurrency(Currency_model currency) {
        this.currency = currency;
    }

    public Person_model getRefuelerPerson() {
        return refuelerPerson;
    }

    public void setRefuelerPerson(Person_model refuelerPerson) {
        this.refuelerPerson = refuelerPerson;
    }

    public Car_model getRefueledCar() {
        return refueledCar;
    }

    public void setRefueledCar(Car_model refueledCar) {
        this.refueledCar = refueledCar;
    }

}

package org.y3.brain.model.petrolrefuel;

import java.util.Date;
import org.y3.commons.model.IModel;

/** 
 * <p>Title: org.y3.brain.model.petrolconsumption - PetrolRefuelModel</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
 */
public class PetrolRefuelModel extends IModel {
    
    private int id;
    private String carName;
    private String carOwner;
    private Date refuelDate;
    private double pricePerLiter;
    private String currency;
    private double refueledLiters;
    private double tripDistanceInKilometers;
    private double absolutDistanceInKilometers;
    private double costsForRefuel;
    private double consumedLitersPer100Km;
    private double costsPerKilometer;
    private String petrolStation;
    private String refilledPetrolType;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public Date getRefuelDate() {
        return refuelDate;
    }

    public void setRefuelDate(Date refuelDate) {
        this.refuelDate = refuelDate;
    }

    public double getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(double pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getRefueledLiters() {
        return refueledLiters;
    }

    public void setRefueledLiters(double refueledLiters) {
        this.refueledLiters = refueledLiters;
    }

    public double getTripDistanceInKilometers() {
        return tripDistanceInKilometers;
    }

    public void setTripDistanceInKilometers(double tripDistanceInKilometers) {
        this.tripDistanceInKilometers = tripDistanceInKilometers;
    }

    public double getAbsolutDistanceInKilometers() {
        return absolutDistanceInKilometers;
    }

    public void setAbsolutDistanceInKilometers(double absolutDistanceInKilometers) {
        this.absolutDistanceInKilometers = absolutDistanceInKilometers;
    }

    public double getCostsForRefuel() {
        return costsForRefuel;
    }

    public void setCostsForRefuel(double costsForRefuel) {
        this.costsForRefuel = costsForRefuel;
    }

    public double getConsumedLitersPer100Km() {
        return consumedLitersPer100Km;
    }

    public void setConsumedLitersPer100Km(double consumedLitersPer100Km) {
        this.consumedLitersPer100Km = consumedLitersPer100Km;
    }

    public double getCostsPerKilometer() {
        return costsPerKilometer;
    }

    public void setCostsPerKilometer(double costsPerKilometer) {
        this.costsPerKilometer = costsPerKilometer;
    }

    public String getPetrolStation() {
        return petrolStation;
    }

    public void setPetrolStation(String petrolStation) {
        this.petrolStation = petrolStation;
    }

    public String getRefilledPetrolType() {
        return refilledPetrolType;
    }

    public void setRefilledPetrolType(String refilledPetrolType) {
        this.refilledPetrolType = refilledPetrolType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

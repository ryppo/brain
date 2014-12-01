package org.y3.brain.model.petrolrefuel;

import java.util.Date;
import org.y3.commons.model.IModel;

/** 
 * <p>Title: org.y3.brain.model.petrolconsumption - PetrolRefuel_model</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
 */
public class PetrolRefuel_model extends IModel {
    
    //identity
    private int id;
    private String FP;
    //fields
    private Date refuelDate;
    private double pricePerLiter;
    private double refueledLiters;
    private double tripDistanceInKilometers;
    private double absolutDistanceInKilometers;
    private double costsForRefuel;
    private double consumedLitersPer100Km;
    private double costsPerKilometer;
    private String comment;
    //relations
    private String carFP;
    private String refuelerPersonFP;
    private String currencyFP;
    private String tireTypeFP;

    public String getTireTypeFP() {
        return tireTypeFP;
    }

    public void setTireTypeFP(String tireTypeFP) {
        this.tireTypeFP = tireTypeFP;
    }
    
    public String getCurrencyFP() {
        return currencyFP;
    }

    public void setCurrencyFP(String currencyFP) {
        this.currencyFP = currencyFP;
    }

    public String getFP() {
        return FP;
    }

    public void setFP(String FP) {
        this.FP = FP;
    }

    public String getCarFP() {
        return carFP;
    }

    public void setCarFP(String carFP) {
        this.carFP = carFP;
    }

    public String getRefuelerPersonFP() {
        return refuelerPersonFP;
    }

    public void setRefuelerPersonFP(String refuelerPersonFP) {
        this.refuelerPersonFP = refuelerPersonFP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

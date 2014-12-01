package org.y3.brain.model.petrolrefuel;

import java.sql.ResultSet;
import org.y3.commons.model.IModelFilter;
import org.y3.commons.model.ISqliteJdbcModelMapper;

/**
 * <p>Title: org.y3.brain.model.petrolrefuel - PetrolRefuelModel_mapper</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
 */
public class PetrolRefuelModel_mapper implements ISqliteJdbcModelMapper {
    
    //////TO BE MOVED TO Y3-COMMONS
    public final static String FILTER_COMPARATOR_EQUALS = " = ";
    public final static String FILTER_COMPARATOR_LIKE = " LIKE ";
    public final static String FILTER_COMPARATOR_NOT = " NOT ";
    public final static String FILTER_COMPARATOR_SMALLER_THAN = " <= ";
    public final static String FILTER_COMPARATOR_GREATER_THAN = " >= ";
    public final static String FILTER_COMPARATOR_EXCLUDE = " <> ";
    
    //public String sqlWhere(IModelFilter _filter);
    
    public static  String addExcludeNotEmptyStringWhere(String where, String key) {
        if (where != null && where.length() > 0) {
            where += " AND ";
        } else {
            where = " WHERE ";
        }
        where += key + FILTER_COMPARATOR_EXCLUDE + "''";
        return where;
    }
    
    public static String addNotNullStringWhere(String where, String key, String comparator, String value) {
        if (value != null && value.length() > 0) {
            if (where != null && where.length() > 0) {
                where += " AND ";
            } else {
                where = " WHERE ";
            }
            where += key + comparator + "'" + value + "'";
        }
        return where;
    }
    
    public static String addNotNullIntegerWhere(String where, String key, String comparator, int value) {
        if (where != null && where.length() > 0) {
            where += " AND ";
        } else {
            where = " WHERE ";
        }
        where += key + comparator + "'" + value + "";
        return where;
    }
    
    public static String addNotNullStringWhere(String where, String key, String comparator, String[] values) {
        if (values != null && values.length > 0) {
            String multi = null;
            if (where != null && where.length() > 0) {
                where += " AND ";
            } else {
                where = " WHERE ";
            }
            for (String value : values) {
                if (multi == null) {
                    multi = "(";
                } else {
                    multi += " OR ";
                }
                multi += key + FILTER_COMPARATOR_EQUALS + "'" + value + "'";
            }
            if (multi != null) {
                multi += ")";
            }
            where += multi;
        }
        return where;
    }
    
    
    private final String DB_TABLE = "PetrolRefuel";

    public enum fields {
        id, fingerprint, carFingerprint, refuelerPersonFingerprint, refuelDate, pricePerLiter, currencyFingerPrint, refuledLiters,
        tripDistanceInKm, absolutDistanceInKm, costsForRefuel,
        cosumedLitersPer100Km, costsPerKilometer, petrolStation, refilledPetrolType,
        comment, usedTireTypeFingerprint
    };
    
    //@Override
    public String sqlWhere(IModelFilter _filter) {
        String where =  null;
        if (_filter instanceof  PetrolRefuel_modelFilter) {
            PetrolRefuel_modelFilter filter = (PetrolRefuel_modelFilter) _filter;
            //identity
            PetrolRefuelModel_mapper.addNotNullIntegerWhere(where, fields.id.name(), FILTER_COMPARATOR_EQUALS, filter.getId());
            PetrolRefuelModel_mapper.addNotNullStringWhere(where, fields.fingerprint.name(), FILTER_COMPARATOR_EQUALS, filter.getFP());
            //fields
            
            //relations
            PetrolRefuelModel_mapper.addNotNullStringWhere(where, fields.carFingerprint.name(), FILTER_COMPARATOR_EQUALS, filter.getCarFP());
            PetrolRefuelModel_mapper.addNotNullStringWhere(where, fields.refuelerPersonFingerprint.name(), FILTER_COMPARATOR_EQUALS, filter.getRefuelerPersonFP());
            PetrolRefuelModel_mapper.addNotNullStringWhere(where, fields.currencyFingerPrint.name(), FILTER_COMPARATOR_EQUALS, filter.getCurrencyFP());
            PetrolRefuelModel_mapper.addNotNullStringWhere(where, fields.usedTireTypeFingerprint.name(), FILTER_COMPARATOR_EQUALS, filter.getTireTypeFP());
        }
        return null;
    }
    
    @Override
    public String getModelSelectSql(IModelFilter filter) {
        if (filter instanceof PetrolRefuel_modelFilter) {
            return getModelSelectSql((PetrolRefuel_modelFilter) filter);
        }
        return "SELECT * FROM " + DB_TABLE + sqlWhere(filter);
    }
    
    @Override
    public String getModelsSelectSql(IModelFilter filter) {
        if (filter instanceof PetrolRefuel_modelFilter) {
            return "SELECT * FROM " + DB_TABLE + sqlWhere(filter);
        }
        return null;
    }
    
    @Override
    public PetrolRefuel_model map(ResultSet dbResult) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PetrolRefuel_modelList createModelList() {
        return new PetrolRefuel_modelList();
    }

    @Override
    public PetrolRefuel_model createModel() {
        return new PetrolRefuel_model();
    }

}

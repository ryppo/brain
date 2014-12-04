package org.y3.brain.model.petrolrefuel;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.y3.commons.model.IModel;
import org.y3.commons.model.IModelFilter;
import org.y3.commons.model.IModelMapper;
import org.y3.commons.model.ISqliteJdbcModelMapper;

/**
 * <p>Title: org.y3.brain.model.petrolrefuel - PetrolRefuelModel_mapper</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
 */
public class PetrolRefuelModel_mapper implements ISqliteJdbcModelMapper {
    
    @Override
    public String getDatabaseTableName() {
        return "PetrolRefuel";
    }

    @Override
    public String getCreateDatabaseTableSql() {
        return "CREATE TABLE '" + getDatabaseTableName() + "' ("
	+ fields.id.name() + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
	+ fields.fingerprint.name() + " TEXT NOT NULL UNIQUE,"
	+ fields.refuelDate.name() + " TEXT,"
	+ fields.pricePerLiter.name() + " REAL,"
	+ fields.refuledLiters.name() + " REAL,"
	+ fields.tripDistanceInKm.name() + " REAL,"
	+ fields.absolutDistanceInKm.name() + " REAL,"
	+ fields.costsForRefuel.name() + " REAL,"
	+ fields.cosumedLitersPer100Km.name() + " REAL,"
	+ fields.costsPerKilometer.name() + " REAL,"
	+ fields.petrolStation.name() + " NUMERIC,"
	+ fields.comment.name() + " TEXT,"
	+ fields.refilledPetrolTypeFingerprint.name() + " TEXT,"
	+ fields.usedTireTypeFingerprint.name() + " TEXT,"
	+ fields.carFingerprint.name() + " TEXT,"
	+ fields.refuelerPersonFingerprint.name() + " TEXT,"
	+ fields.currencyFingerPrint.name() + " TEXT);";
    }

    @Override
    public String getModelUpdateSql(IModel _model) {
        String sql = null;
        if (_model instanceof PetrolRefuel_model) {
            PetrolRefuel_model model = (PetrolRefuel_model) _model;
            sql = "UPDATE " + getDatabaseTableName() + " SET "
                    + fields.fingerprint.name() + "=" + ISqliteJdbcModelMapper.sqlString(model.getFP())
                    +  " WHERE " + fields.fingerprint + "='" + model.getFP() + "'";
        }
        return sql;
    }

    @Override
    public String getModelInsertSql(IModel _model) {
        String sql = null;
        if (_model instanceof PetrolRefuel_model) {
            PetrolRefuel_model model = (PetrolRefuel_model) _model;
            sql = "INSERT INTO " + getDatabaseTableName() + " ("
                    + fields.fingerprint.name() + ") VALUES ("
                    + ISqliteJdbcModelMapper.sqlString(model.getFP())
                    + ")";
        }
        return sql;
    }

    public enum fields {
        id, fingerprint, refuelDate, pricePerLiter, refuledLiters,
        tripDistanceInKm, absolutDistanceInKm, costsForRefuel,
        cosumedLitersPer100Km, costsPerKilometer, petrolStation, comment,
        refilledPetrolTypeFingerprint, usedTireTypeFingerprint, carFingerprint, refuelerPersonFingerprint, 
        currencyFingerPrint
    };
    
    //@Override
    public String sqlWhere(IModelFilter _filter) {
        String where =  null;
        if (_filter instanceof  PetrolRefuel_modelFilter) {
            PetrolRefuel_modelFilter filter = (PetrolRefuel_modelFilter) _filter;
            //identity
            IModelMapper.addNotNullIntegerWhere(where, fields.id.name(), FILTER_COMPARATOR_EQUALS, filter.getId());
            IModelMapper.addNotNullStringWhere(where, fields.fingerprint.name(), FILTER_COMPARATOR_EQUALS, filter.getFP());
            //fields
            
            //relations
            IModelMapper.addNotNullStringWhere(where, fields.carFingerprint.name(), FILTER_COMPARATOR_EQUALS, filter.getCarFP());
            IModelMapper.addNotNullStringWhere(where, fields.refuelerPersonFingerprint.name(), FILTER_COMPARATOR_EQUALS, filter.getRefuelerPersonFP());
            IModelMapper.addNotNullStringWhere(where, fields.currencyFingerPrint.name(), FILTER_COMPARATOR_EQUALS, filter.getCurrencyFP());
            IModelMapper.addNotNullStringWhere(where, fields.usedTireTypeFingerprint.name(), FILTER_COMPARATOR_EQUALS, filter.getTireTypeFP());
        }
        return null;
    }
    
    @Override
    public String getModelSelectSql(IModelFilter filter) {
        if (filter instanceof PetrolRefuel_modelFilter) {
            return getModelSelectSql((PetrolRefuel_modelFilter) filter);
        }
        return "SELECT * FROM " + getDatabaseTableName() + sqlWhere(filter);
    }
    
    @Override
    public String getModelsSelectSql(IModelFilter filter) {
        if (filter instanceof PetrolRefuel_modelFilter) {
            return "SELECT * FROM " + getDatabaseTableName() + sqlWhere(filter);
        }
        return null;
    }
    
    @Override
    public PetrolRefuel_model map(ResultSet dbResult) throws SQLException {
        PetrolRefuel_model model = new PetrolRefuel_model();
        model.setId(dbResult.getInt(fields.id.name()));
        model.setFP(dbResult.getString(fields.fingerprint.name()));
        
        return model;
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

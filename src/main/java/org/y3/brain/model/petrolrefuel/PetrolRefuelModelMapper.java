package org.y3.brain.model.petrolrefuel;

import java.sql.ResultSet;
import org.y3.commons.model.IModel;
import org.y3.commons.model.IModelFilter;
import org.y3.commons.model.ISqliteJdbcModelMapper;

/**
 * <p>Title: org.y3.brain.model.petrolrefuel - PetrolRefuelModelMapper</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
 */
public class PetrolRefuelModelMapper implements ISqliteJdbcModelMapper {

    @Override
    public String getModelSelectSql(IModelFilter filter) {
        if (filter instanceof PetrolRefuelModelFilter) {
            return getModelSelectSql((PetrolRefuelModelFilter) filter);
        }
        return null;
    }
    
    @Override
    public String getModelsSelectSql(IModelFilter filter) {
        if (filter instanceof PetrolRefuelModelFilter) {
            return getModelsSelectSql((PetrolRefuelModelFilter) filter);
        }
        return null;
    }
    
    public String getModelsSelectSql(PetrolRefuelModelFilter filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel map(ResultSet dbResult) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PetrolRefuelModelList createModelList() {
        return new PetrolRefuelModelList();
    }

    @Override
    public PetrolRefuelModel createModel() {
        return new PetrolRefuelModel();
    }

}

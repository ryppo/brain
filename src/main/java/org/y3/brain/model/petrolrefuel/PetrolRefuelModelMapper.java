package org.y3.brain.model.petrolrefuel;

import org.y3.commons.model.IModelFilter;
import org.y3.commons.model.IModelMapper;

/**
 * <p>Title: org.y3.brain.model.petrolrefuel - PetrolRefuelModelMapper</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
 */
public class PetrolRefuelModelMapper extends IModelMapper {

    @Override
    public String getModelSelectSql(IModelFilter filter) {
        if (filter instanceof PetrolRefuelModelFilter) {
            return getModelSelectSql((PetrolRefuelModelFilter) filter);
        }
        return null;
    }
    
    public String getModelSelectSql(PetrolRefuelModelFilter filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public PetrolRefuelModel mapSqliteStatementToModel(com.almworks.sqlite4java.SQLiteStatement stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package org.y3.brain.database;

import org.y3.brain.model.petrolrefuel.PetrolRefuelModel_mapper;
import org.y3.commons.database.SqliteJdbcDatabase;
import org.y3.commons.model.ISqliteJdbcModelMapper;

/**
 * <p>Title: org.y3.brain.database - BrainStorm</p>
 * <p>Description: Sql-database for brain</p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
 */
public class BrainStorm extends SqliteJdbcDatabase {
    
    private ISqliteJdbcModelMapper[] allMapper;
    private final PetrolRefuelModel_mapper petrolRefuelModel_mapper;
    
    public BrainStorm() {
        petrolRefuelModel_mapper = new PetrolRefuelModel_mapper();
        allMapper = new ISqliteJdbcModelMapper[]{
            petrolRefuelModel_mapper
        };
    }
    
    public PetrolRefuelModel_mapper getPetrolRefuelModelMapper() {
        return petrolRefuelModel_mapper;
    }

    @Override
    public void executeAfterConnect() {
        if (allMapper != null && allMapper.length > 0) {
            for (ISqliteJdbcModelMapper mapper : allMapper) {
                if (mapper != null) {
                    try {
                        createMissingModelTable(mapper);
                    } catch (Exception ex) {
                        LOG.error(ex);
                    }
                }
            }
        }
    }

}

package org.y3.brain.database;

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
    
    private ISqliteJdbcModelMapper[] mapper;
    
    public BrainStorm() {
        
    }
    
    public void setModelMapper(ISqliteJdbcModelMapper[] _mapper) {
        mapper = _mapper;
        if (mapper != null && mapper.length > 0) {
            for (ISqliteJdbcModelMapper mapper : _mapper) {
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

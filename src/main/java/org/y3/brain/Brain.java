package org.y3.brain;

import java.sql.SQLException;
import org.y3.brain.database.BrainStorm;
import org.y3.brain.view.BrainFrame;
import org.y3.brain.view.IModelView;
import org.y3.brain.view.petrolrefuel.PetrolRefuel_view;
import org.y3.commons.application.IApplication;

/** 
 * <p>Title: org.y3.brain - Brain</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
 */
public class Brain extends IApplication {
    
    public static BrainStorm brainStorm;
    public BrainFrame brainFrame;
    
    public Brain() {
        super();
    }
    
    @Override
    public void run() {
        brainFrame.setVisible(true);
    }
    
    public static void main(String args[]) {
        Brain brain = new Brain();
        brain.run();
    }

    @Override
    public String getUserPropertiesLocation() {
        return System.getProperty("user.home") + "/brain.config";
    }

    @Override
    public String getLoggerPropertiesLocation() {
        return "/org/y3/brain/log4j.properties";
    }

    @Override
    public String getResourceBundleLocation() {
        return "org/y3/brain/brain";
    }

    @Override
    public void prepare() {
        //model
        brainStorm = new BrainStorm();
        try {
            String brainStormLocation = System.getProperty("user.home") + "/brainStorm.brain";
            String lastUsedBrainStrom = UP().getProperty("brainstormlocation");
            if (lastUsedBrainStrom != null && lastUsedBrainStrom.length() > 0) {
                brainStormLocation = lastUsedBrainStrom;
            }
            LOG().debug("brainStormLocation: " + brainStormLocation);
            brainStorm.connect(brainStormLocation);
        } catch (Exception ex) {
            LOG().error(ex.getMessage(), ex);
        }
        //view
        IModelView[] modelViews = new IModelView[]{
            new PetrolRefuel_view()
        };
        brainFrame = new BrainFrame(RB(), UP(), modelViews);
        brainFrame.addWindowListener(getShutDownListener());
    }

    @Override
    public String getApplicationName() {
        return "Brain";
    }

    @Override
    public void beforeShutDown() {
        try {
            if (brainStorm != null && brainStorm.isConnected()) {
                brainStorm.disconnect();
            }
        } catch (SQLException ex) {
            LOG().error(ex);
        }
        brainFrame.saveProperties();
    }

}

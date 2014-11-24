package org.y3.brain;

import org.y3.brain.database.BrainStorm;
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
    private final String brainStromLocation = System.getProperty("user.home") + "brainStorm.brain";
    
    public Brain() {
        super();
    }
    
    @Override
    public void run() {
        brainStorm = new BrainStorm();
        try {
            brainStorm.connect(brainStromLocation);
        } catch (Exception ex) {
            LOG().error(ex);
        }
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
    }

    @Override
    public String getApplicationName() {
        return "Brain";
    }

    @Override
    public void beforeShutDown() {
        if (brainStorm != null && brainStorm.isConnected()) {
            brainStorm.disconnect();
        }
    }

}

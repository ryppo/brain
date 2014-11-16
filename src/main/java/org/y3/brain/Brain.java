package org.y3.brain;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.y3.commons.lang.PropertiesHelper;

/** 
 * <p>Title: org.y3.brain - Brain</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
 * @version $Id$
*/
public class Brain {
    
    public static ResourceBundle RB = ResourceBundle.getBundle("org/y3/brain/brain");
    private final String logFilenameAndLocation = "/org/y3/brain/log4j.properties";
    public static Logger LOG = Logger.getLogger(Brain.class.getName());
    private final String propertiesFilename = "brain.config";
    private final String propertiesLocation = System.getProperty("user.home") + "/" + propertiesFilename;
    public static Properties UP = null;
    
    public Brain() {
        init();
    }
    
    public void run() {
        
    }
    
    private void init() {
        try {
            //setup logging
            PropertyConfigurator.configure(getClass().getResourceAsStream(logFilenameAndLocation));
            //setup user properties
            File userPropertiesFile = new File(propertiesLocation);
            if (!userPropertiesFile.exists()) {
                Logger.getLogger(getClass()).debug("User properties file does not exist at: " + propertiesLocation);
                File originalPropertiesFile = new File(propertiesFilename);
                UP = new Properties();
                PropertiesHelper.saveProperties(UP, propertiesLocation, true);
            }
            UP = PropertiesHelper.loadProperties(propertiesLocation, true);
        } catch (IOException ex) {
            LOG.error("Save new properties file to " + logFilenameAndLocation + " failed", ex);
        }
    }
    
    /**
     * Receive shut down listener object which manages the application shut down operations
     * @return shut down listener object
     */
    public WindowListener getShutDownListener() {
        return new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    //save properties
                    PropertiesHelper.saveProperties(UP, propertiesLocation, true);
                } catch (IOException ex) {
                    LOG.debug(ex);
                }
                LOG.debug("System exit by window closing");
                System.exit(0);
            }
        };
    }
    
    public static void main(String args[]) {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // handle exception
        }
        Brain brain = new Brain();
        brain.run();
    }

}

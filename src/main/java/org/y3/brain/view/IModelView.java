package org.y3.brain.view;

import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** 
 * <p>Title: org.y3.brain.view - IModelView</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public abstract class IModelView {
    
    private Properties userProperties;
    private ResourceBundle RES_BUNDLE;
    
    public ResourceBundle getRES_BUNDLE() {
        return RES_BUNDLE;
    }

    public void setRES_BUNDLE(ResourceBundle RES_BUNDLE) {
        this.RES_BUNDLE = RES_BUNDLE;
    }

    public Properties getUserProperties() {
        return userProperties;
    }

    public void setUserProperties(Properties userProperties) {
        this.userProperties = userProperties;
    }
    
    public abstract String getName();
    
    public abstract JPanel getUserInterface(JFrame root);
    
    public abstract void storeUserPropertiesForShutdown();

}

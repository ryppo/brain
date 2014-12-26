package org.y3.brain.view;

import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import net.java.dev.designgridlayout.DesignGridLayout;
import org.y3.commons.lang.PropertiesHelper;

/** 
 * <p>Title: org.y3.brain.view - BrainFrame</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class BrainFrame extends JFrame {
    
    int defaultWindowHeight = 500;
    int defaultWindowWidth = 1000;
    int defaultWindowPosX = 100;
    int defaultWindowPosY = 100;
    int defaultWindowExtendedState = JFrame.NORMAL;
    
    private final IModelView[] modelViews;
    private final ResourceBundle resourceBundle;
    private final Properties userProperties;
    private JTabbedPane jtp_modelViews;
    
    public BrainFrame(ResourceBundle _resourceBundle, Properties _userProperties, IModelView[] _modelViews) {
        resourceBundle = _resourceBundle;
        userProperties = _userProperties;
        modelViews = _modelViews;
        if (modelViews != null && modelViews.length > 0) {
            for (IModelView modelView : _modelViews) {
                modelView.setRES_BUNDLE(resourceBundle);
                modelView.setUserProperties(userProperties);
            }
        }
        buildUi();
    }
    
    private void buildUi() {
        defaultWindowHeight = PropertiesHelper.getIntegerFromProperties(userProperties, "defaultWindowHeight", defaultWindowHeight);
        defaultWindowWidth = PropertiesHelper.getIntegerFromProperties(userProperties, "defaultWindowWidth", defaultWindowWidth);
        defaultWindowPosX = PropertiesHelper.getIntegerFromProperties(userProperties, "defaultWindowPosX", defaultWindowPosX);
        defaultWindowPosY = PropertiesHelper.getIntegerFromProperties(userProperties, "defaultWindowPosY", defaultWindowPosY);
        defaultWindowExtendedState = PropertiesHelper.getIntegerFromProperties(userProperties, "defaultWindowExtendedState", defaultWindowExtendedState);
        setSize(defaultWindowWidth,defaultWindowHeight);
        setLocation(defaultWindowPosX, defaultWindowPosY);
        setExtendedState(defaultWindowExtendedState);
        
        setIconImage(IconDictionary.APP_ICON);
        setTitle(resourceBundle.getString("APPLICATION_IDENTITY") + " " + resourceBundle.getString("VERSION_VALUE"));
        
        jtp_modelViews = new JTabbedPane();
        if (modelViews != null && modelViews.length > 0) {
            for (IModelView modelView : modelViews) {
                jtp_modelViews.add(modelView.getName(), modelView.getUserInterface(this));
            }
        }
        
        DesignGridLayout layout = new DesignGridLayout(this);
        layout.row().grid().add(new JScrollPane(jtp_modelViews));
    }
    
    public void saveProperties() {
        userProperties.setProperty("defaultWindowHeight", Integer.toString(getSize().height));
        userProperties.setProperty("defaultWindowWidth", Integer.toString(getSize().width));
        userProperties.setProperty("defaultWindowPosX", Integer.toString(getLocation().x));
        userProperties.setProperty("defaultWindowPosY", Integer.toString(getLocation().y));
        userProperties.setProperty("defaultWindowExtendedState", Integer.toString(getExtendedState()));
        if (modelViews != null && modelViews.length > 0) {
            for (IModelView modelView : modelViews) {
                modelView.storeUserPropertiesForShutdown();
            }
        }
    }

}

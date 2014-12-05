package org.y3.brain.view.petrolrefuel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.log4j.Logger;
import org.y3.brain.Brain;
import org.y3.brain.model.petrolrefuel.PetrolRefuelModel_mapper;
import org.y3.brain.view.IModelView;
import org.y3.commons.model.IModelList;

/** 
 * <p>Title: org.y3.brain.view.petrolrefuel - PetrolRefuel_view</p>
 * <p>Description: </p>
 * <p>Copyright: 2014</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class PetrolRefuel_view extends IModelView {
    
    private JPanel ui = null;

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public JPanel getUserInterface(JFrame root) {
        if (ui == null) {
            ui = new JPanel(new BorderLayout(0, 0));
            jt_petrolRefuel = new JTable();
            ui.add(new JScrollPane(jt_petrolRefuel), BorderLayout.CENTER);
            JButton jb_loadTable = new JButton("LOAD TABLE");
            jb_loadTable.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loadTable();
                }
            });
            JToolBar jto = new JToolBar();
            ui.add(jto, BorderLayout.NORTH);
            jto.add(jb_loadTable);
        }
        return ui;
    }
    public JTable jt_petrolRefuel;
    
    private void loadTable() {
        jt_petrolRefuel.setModel(new DefaultTableModel());
        PetrolRefuelModel_mapper petrolRefuelModelMapper = Brain.brainStorm.getPetrolRefuelModelMapper();
        try {
            IModelList loadedModels = Brain.brainStorm.loadModels(petrolRefuelModelMapper, null);
            TableModel modelsTableModel = petrolRefuelModelMapper.map(loadedModels);
            jt_petrolRefuel.setModel(modelsTableModel);
        } catch (Exception ex) {
            Logger.getLogger(getClass()).error(ex);
        }
    }

    @Override
    public void storeUserPropertiesForShutdown() {
        
    }

}

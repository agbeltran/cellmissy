/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConditionsSetupPanel.java
 *
 * Created on Apr 2, 2012, 10:41:55 AM
 */
package be.ugent.maf.cellmissy.gui.experiment;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paola
 */
public class ConditionsSetupPanel extends javax.swing.JPanel {

    /** Creates new form ConditionsSetupPanel */
    public ConditionsSetupPanel() {
        initComponents();
    }

    public JComboBox getCellLineComboBox() {
        return cellLineComboBox;
    }

    public JTextField getCellLineNameTextField() {
        return cellLineNameTextField;
    }

    public JButton getInsertCellLineButton() {
        return insertCellLineButton;
    }

    public JComboBox getMatrixDimensionComboBox() {
        return matrixDimensionComboBox;
    }

    public JPanel getAssayEcmParentPanel() {
        return assayEcmParentPanel;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        cellLinePanel = new javax.swing.JPanel();
        cellLineComboBox = new javax.swing.JComboBox();
        selectCellLineLabel = new javax.swing.JLabel();
        cellLineNameLabel = new javax.swing.JLabel();
        cellLineNameTextField = new javax.swing.JTextField();
        insertCellLineButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ecmPanel = new javax.swing.JPanel();
        ecmDimensionLabel = new javax.swing.JLabel();
        matrixDimensionComboBox = new javax.swing.JComboBox();
        assayEcmParentPanel = new javax.swing.JPanel();
        treatmentPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Conditions Set-up"));

        cellLineComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        selectCellLineLabel.setText("Select a cell line");

        cellLineNameLabel.setText("Cell line name");

        insertCellLineButton.setText("Insert cell line");

        jLabel1.setText("If the cell line is not present, insert it into DB");

        javax.swing.GroupLayout cellLinePanelLayout = new javax.swing.GroupLayout(cellLinePanel);
        cellLinePanel.setLayout(cellLinePanelLayout);
        cellLinePanelLayout.setHorizontalGroup(
            cellLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cellLinePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cellLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cellLinePanelLayout.createSequentialGroup()
                        .addComponent(selectCellLineLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cellLineComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cellLinePanelLayout.createSequentialGroup()
                        .addComponent(cellLineNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(cellLineNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(insertCellLineButton))
                    .addComponent(jLabel1))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        cellLinePanelLayout.setVerticalGroup(
            cellLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cellLinePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(cellLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCellLineLabel)
                    .addComponent(cellLineComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(cellLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cellLineNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertCellLineButton)
                    .addComponent(cellLineNameLabel))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("cell_line", cellLinePanel);

        ecmDimensionLabel.setText("Choose ECM dimension");

        matrixDimensionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        assayEcmParentPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        assayEcmParentPanel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout ecmPanelLayout = new javax.swing.GroupLayout(ecmPanel);
        ecmPanel.setLayout(ecmPanelLayout);
        ecmPanelLayout.setHorizontalGroup(
            ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecmPanelLayout.createSequentialGroup()
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ecmPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(ecmDimensionLabel)
                        .addGap(18, 18, 18)
                        .addComponent(matrixDimensionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ecmPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(assayEcmParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ecmPanelLayout.setVerticalGroup(
            ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecmPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(ecmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ecmDimensionLabel)
                    .addComponent(matrixDimensionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(assayEcmParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("ecm", ecmPanel);

        javax.swing.GroupLayout treatmentPanelLayout = new javax.swing.GroupLayout(treatmentPanel);
        treatmentPanel.setLayout(treatmentPanelLayout);
        treatmentPanelLayout.setHorizontalGroup(
            treatmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );
        treatmentPanelLayout.setVerticalGroup(
            treatmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("treatment", treatmentPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel assayEcmParentPanel;
    private javax.swing.JComboBox cellLineComboBox;
    private javax.swing.JLabel cellLineNameLabel;
    private javax.swing.JTextField cellLineNameTextField;
    private javax.swing.JPanel cellLinePanel;
    private javax.swing.JLabel ecmDimensionLabel;
    private javax.swing.JPanel ecmPanel;
    private javax.swing.JButton insertCellLineButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox matrixDimensionComboBox;
    private javax.swing.JLabel selectCellLineLabel;
    private javax.swing.JPanel treatmentPanel;
    // End of variables declaration//GEN-END:variables
}

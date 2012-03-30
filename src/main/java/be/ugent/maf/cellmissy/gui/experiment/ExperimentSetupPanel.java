/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExperimentSetupPanel.java
 *
 * Created on Mar 29, 2012, 9:01:25 AM
 */
package be.ugent.maf.cellmissy.gui.experiment;

import javax.swing.JPanel;

/**
 *
 * @author Paola
 */
public class ExperimentSetupPanel extends javax.swing.JPanel {

    /** Creates new form ExperimentSetupPanel */
    public ExperimentSetupPanel() {
        initComponents();
    }

    public JPanel getExperimentInfoParentPanel() {
        return ExperimentInfoParentPanel;
    }

    public JPanel getPlateSetupParentPanel() {
        return PlateSetupParentPanel;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ExperimentInfoParentPanel = new javax.swing.JPanel();
        PlateSetupParentPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(20, 20));
        setLayout(new java.awt.GridBagLayout());

        ExperimentInfoParentPanel.setMinimumSize(new java.awt.Dimension(40, 40));
        ExperimentInfoParentPanel.setPreferredSize(new java.awt.Dimension(10, 10));
        ExperimentInfoParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        add(ExperimentInfoParentPanel, gridBagConstraints);

        PlateSetupParentPanel.setMinimumSize(new java.awt.Dimension(30, 30));
        PlateSetupParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        PlateSetupParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.8;
        add(PlateSetupParentPanel, gridBagConstraints);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 152, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(0, 152, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 38, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(0, 39, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ExperimentInfoParentPanel;
    private javax.swing.JPanel PlateSetupParentPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

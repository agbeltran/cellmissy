/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.experiment.analysis.singlecell;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Paola
 */
public class AnalysisPanel extends javax.swing.JPanel {

    /**
     * Creates new form ConditionsPanel
     */
    public AnalysisPanel() {
        initComponents();
    }

    public JRadioButton getAngleRadioButton() {
        return angleRadioButton;
    }

    public JRadioButton getCellSpeedsRadioButton() {
        return cellSpeedsRadioButton;
    }

    public JRadioButton getCellTracksRadioButton() {
        return cellTracksRadioButton;
    }

    public JRadioButton getStatisticsRadioButton() {
        return statisticsRadioButton;
    }

    public JLabel getInfoLabel() {
        return infoLabel;
    }

    public JPanel getCellTracksParentPanel() {
        return cellTracksParentPanel;
    }

    public JPanel getPlotOptionsParentPanel() {
        return plotOptionsParentPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        radioButtonsPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        cellTracksRadioButton = new javax.swing.JRadioButton();
        cellSpeedsRadioButton = new javax.swing.JRadioButton();
        angleRadioButton = new javax.swing.JRadioButton();
        statisticsRadioButton = new javax.swing.JRadioButton();
        bottomPanel = new javax.swing.JPanel();
        cellTracksParentPanel = new javax.swing.JPanel();
        cellSpeedsParentPanel = new javax.swing.JPanel();
        plotOptionsParentPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        radioButtonsPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        infoLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        infoLabel.setMinimumSize(new java.awt.Dimension(20, 20));
        infoLabel.setPreferredSize(new java.awt.Dimension(20, 20));

        cellTracksRadioButton.setText("Cell Tracks");

        cellSpeedsRadioButton.setText("Cell Speeds");

        angleRadioButton.setText("Angle/Directionality");

        statisticsRadioButton.setText("Statistics");

        javax.swing.GroupLayout radioButtonsPanelLayout = new javax.swing.GroupLayout(radioButtonsPanel);
        radioButtonsPanel.setLayout(radioButtonsPanelLayout);
        radioButtonsPanelLayout.setHorizontalGroup(
            radioButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radioButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(radioButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(radioButtonsPanelLayout.createSequentialGroup()
                        .addComponent(cellTracksRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(cellSpeedsRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(angleRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(statisticsRadioButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(radioButtonsPanelLayout.createSequentialGroup()
                        .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(533, 533, 533))))
        );
        radioButtonsPanelLayout.setVerticalGroup(
            radioButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radioButtonsPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(radioButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cellTracksRadioButton)
                    .addComponent(cellSpeedsRadioButton)
                    .addComponent(angleRadioButton)
                    .addComponent(statisticsRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.08;
        add(radioButtonsPanel, gridBagConstraints);

        bottomPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        bottomPanel.setLayout(new java.awt.CardLayout());

        cellTracksParentPanel.setName("cellTracksParentPanel"); // NOI18N
        cellTracksParentPanel.setLayout(new java.awt.GridBagLayout());
        bottomPanel.add(cellTracksParentPanel, "cellTracksParentPanel");
        cellTracksParentPanel.getAccessibleContext().setAccessibleName("cellTracksParentPanel");

        cellSpeedsParentPanel.setLayout(new java.awt.GridBagLayout());
        bottomPanel.add(cellSpeedsParentPanel, "cellSpeedsParentPanel");
        cellSpeedsParentPanel.getAccessibleContext().setAccessibleName("cellSpeedsParentPanel");
        cellSpeedsParentPanel.getAccessibleContext().setAccessibleDescription("cellSpeedsParentPanel");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.92;
        add(bottomPanel, gridBagConstraints);

        plotOptionsParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        plotOptionsParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.08;
        add(plotOptionsParentPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton angleRadioButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel cellSpeedsParentPanel;
    private javax.swing.JRadioButton cellSpeedsRadioButton;
    private javax.swing.JPanel cellTracksParentPanel;
    private javax.swing.JRadioButton cellTracksRadioButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JPanel plotOptionsParentPanel;
    private javax.swing.JPanel radioButtonsPanel;
    private javax.swing.JRadioButton statisticsRadioButton;
    // End of variables declaration//GEN-END:variables
}
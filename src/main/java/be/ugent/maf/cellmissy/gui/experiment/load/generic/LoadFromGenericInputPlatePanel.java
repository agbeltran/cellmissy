/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.experiment.load.generic;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;

/**
 *
 * @author Paola Masuzzo
 */
public class LoadFromGenericInputPlatePanel extends javax.swing.JPanel {

    public JButton getAddDatasetButton() {
        return addDatasetButton;
    }

    public JButton getAddImagingButton() {
        return addImagingButton;
    }

    public JList getConditionsList() {
        return conditionsList;
    }

    public JTree getDataTree() {
        return dataTree;
    }

    public JTextField getDatasetNameTextField() {
        return datasetNameTextField;
    }

    public JLabel getExpNumberLabel() {
        return expNumberLabel;
    }

    public JTextField getImagingNameTextField() {
        return imagingNameTextField;
    }

    public JPanel getPlateParentPanel() {
        return plateParentPanel;
    }

    public JLabel getProjNumberLabel() {
        return projNumberLabel;
    }

    public JTextArea getPurposeTextArea() {
        return purposeTextArea;
    }

    public JTable getRawDataTable() {
        return rawDataTable;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    /**
     * Creates new form LoadFromGenericInputPlatePanel
     */
    public LoadFromGenericInputPlatePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        experimentMetadataPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        projNumberLabel = new javax.swing.JLabel();
        expNumberLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purposeTextArea = new javax.swing.JTextArea();
        conditionsOverviewPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        conditionsList = new javax.swing.JList();
        rightPanel = new javax.swing.JPanel();
        plateParentPanel = new javax.swing.JPanel();
        userInputPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dataTree = new javax.swing.JTree();
        jLabel4 = new javax.swing.JLabel();
        datasetNameTextField = new javax.swing.JTextField();
        addDatasetButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        addImagingButton = new javax.swing.JButton();
        imagingNameTextField = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        rawDataPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        rawDataTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        experimentMetadataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Experiment metadata", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        experimentMetadataPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        experimentMetadataPanel.setOpaque(false);
        experimentMetadataPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Number:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Project:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Purpose:");

        projNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        expNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        purposeTextArea.setEditable(false);
        purposeTextArea.setColumns(20);
        purposeTextArea.setRows(5);
        jScrollPane1.setViewportView(purposeTextArea);

        javax.swing.GroupLayout experimentMetadataPanelLayout = new javax.swing.GroupLayout(experimentMetadataPanel);
        experimentMetadataPanel.setLayout(experimentMetadataPanelLayout);
        experimentMetadataPanelLayout.setHorizontalGroup(
            experimentMetadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(experimentMetadataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(experimentMetadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(experimentMetadataPanelLayout.createSequentialGroup()
                        .addGroup(experimentMetadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(experimentMetadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(expNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(projNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(experimentMetadataPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        experimentMetadataPanelLayout.setVerticalGroup(
            experimentMetadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(experimentMetadataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(experimentMetadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(projNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(experimentMetadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(expNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(experimentMetadataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(experimentMetadataPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        add(experimentMetadataPanel, gridBagConstraints);

        conditionsOverviewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conditions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        conditionsOverviewPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        conditionsOverviewPanel.setName(""); // NOI18N
        conditionsOverviewPanel.setOpaque(false);
        conditionsOverviewPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jScrollPane2.setBorder(null);

        conditionsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(conditionsList);

        javax.swing.GroupLayout conditionsOverviewPanelLayout = new javax.swing.GroupLayout(conditionsOverviewPanel);
        conditionsOverviewPanel.setLayout(conditionsOverviewPanelLayout);
        conditionsOverviewPanelLayout.setHorizontalGroup(
            conditionsOverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conditionsOverviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        conditionsOverviewPanelLayout.setVerticalGroup(
            conditionsOverviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        add(conditionsOverviewPanel, gridBagConstraints);

        rightPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        rightPanel.setLayout(new java.awt.GridBagLayout());

        plateParentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Plate"));
        plateParentPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        plateParentPanel.setOpaque(false);
        plateParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        plateParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.65;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        rightPanel.add(plateParentPanel, gridBagConstraints);

        userInputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Load data"));
        userInputPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        userInputPanel.setOpaque(false);
        userInputPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Data");
        dataTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane3.setViewportView(dataTree);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Dataset");

        addDatasetButton.setText("Add dataset");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Imaging Type");

        addImagingButton.setText("Add imaging type");

        removeButton.setText("Remove dataset / imaging type");

        javax.swing.GroupLayout userInputPanelLayout = new javax.swing.GroupLayout(userInputPanel);
        userInputPanel.setLayout(userInputPanelLayout);
        userInputPanelLayout.setHorizontalGroup(
            userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInputPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButton)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imagingNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addImagingButton, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(datasetNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDatasetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        userInputPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addDatasetButton, addImagingButton, datasetNameTextField, imagingNameTextField});

        userInputPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5});

        userInputPanelLayout.setVerticalGroup(
            userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(userInputPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datasetNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addDatasetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imagingNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addImagingButton))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(removeButton)
                .addGap(45, 45, 45))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.65;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        rightPanel.add(userInputPanel, gridBagConstraints);

        rawDataPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        rawDataPanel.setOpaque(false);
        rawDataPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel6.setText("Data imported (for selected well)");

        rawDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(rawDataTable);

        javax.swing.GroupLayout rawDataPanelLayout = new javax.swing.GroupLayout(rawDataPanel);
        rawDataPanel.setLayout(rawDataPanelLayout);
        rawDataPanelLayout.setHorizontalGroup(
            rawDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rawDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rawDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        rawDataPanelLayout.setVerticalGroup(
            rawDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rawDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.35;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        rightPanel.add(rawDataPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 1.0;
        add(rightPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDatasetButton;
    private javax.swing.JButton addImagingButton;
    private javax.swing.JList conditionsList;
    private javax.swing.JPanel conditionsOverviewPanel;
    private javax.swing.JTree dataTree;
    private javax.swing.JTextField datasetNameTextField;
    private javax.swing.JLabel expNumberLabel;
    private javax.swing.JPanel experimentMetadataPanel;
    private javax.swing.JTextField imagingNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel plateParentPanel;
    private javax.swing.JLabel projNumberLabel;
    private javax.swing.JTextArea purposeTextArea;
    private javax.swing.JPanel rawDataPanel;
    private javax.swing.JTable rawDataTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel userInputPanel;
    // End of variables declaration//GEN-END:variables
}
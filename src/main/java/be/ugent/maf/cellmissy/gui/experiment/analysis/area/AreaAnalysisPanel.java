/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AreaAnalysisPanel.java
 *
 * Created on Nov 22, 2012, 10:57:22 AM
 */
package be.ugent.maf.cellmissy.gui.experiment.analysis.area;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Paola Masuzzo
 */
public class AreaAnalysisPanel extends javax.swing.JPanel {

    /**
     * Creates new form AreaAnalysisPanel
     */
    public AreaAnalysisPanel() {
        initComponents();
    }

    public JTable getTimeStepsTable() {
        return timeStepsTable;
    }

    public JTable getConvertedTimeStepsTable() {
        return convertedTimeStepsTable;
    }

    public JTabbedPane getDataInspectingTabbedPane() {
        return dataInspectingTabbedPane;
    }

    public JRadioButton getDeltaAreaButton() {
        return deltaAreaButton;
    }

    public JRadioButton getNormalizeAreaButton() {
        return normalizeAreaButton;
    }

    public JPanel getDataTablePanel() {
        return dataTablePanel;
    }

    public JRadioButton getPercentageAreaIncreaseButton() {
        return percentageAreaIncreaseButton;
    }

    public JRadioButton getCorrectedAreaButton() {
        return correctedAreaButton;
    }

    public JPanel getGraphicsParentPanel() {
        return graphicsParentPanel;
    }

    public JLabel getTableInfoLabel() {
        return tableInfoLabel;
    }

    public JScrollPane getTimeStepsTableScrollPane() {
        return timeStepsTableScrollPane;
    }

    public JPanel getGlobalAreaPanel() {
        return globalAreaPanel;
    }

    public JCheckBox getPlotErrorBarsCheckBox() {
        return plotErrorBarsCheckBox;
    }

    public JList getConditionsList() {
        return conditionsList;
    }

    public JButton getPlotSelectedConditionsButton() {
        return plotSelectedConditionsButton;
    }

    public JButton getPlotAllConditionsButton() {
        return plotAllConditionsButton;
    }

    public JPanel getLinearModelParentPanel() {
        return linearModelParentPanel;
    }

    public JCheckBox getUseCorrectedDataCheckBox() {
        return useCorrectedDataCheckBox;
    }

    public JRadioButton getCellCoveredAreaRadioButton() {
        return cellCoveredAreaRadioButton;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public JLabel getGlobalViewLabel() {
        return globalViewLabel;
    }

    public JLabel getLinearRegressionModelLabel() {
        return linearRegressionModelLabel;
    }

    public JLabel getPreProcessingLabel() {
        return preProcessingLabel;
    }
    
    public JLabel getResultsImportingLabel() {
        return resultsImportingLabel;
    }

    public JCheckBox getPlotLinesCheckBox() {
        return plotLinesCheckBox;
    }

    public JCheckBox getPlotPointsCheckBox() {
        return plotPointsCheckBox;
    }

    public JTextField getFirstTimeFrameTextField() {
        return firstTimeFrameTextField;
    }

    public JTextField getLastTimeFrameTextField() {
        return lastTimeFrameTextField;
    }

    public JCheckBox getShowTimeIntervalCheckBox() {
        return showTimeIntervalCheckBox;
    }
    
    public JLabel getDoseResponseLabel(){
        return doseResponseLabel;
    }
    
    public JRadioButton getInputDRButton(){
        return inputDRButton;
    }
    
    public JRadioButton getInitialPlotDRButton(){
        return initialPlotDRButton;
    }
    
    public JRadioButton getNormalizedPlotDRButton(){
        return normalizedPlotDRButton;
    }
    
    public JRadioButton getResultsDRButton(){
        return resultsDRButton;
    }
    
    public JPanel getDatatableDRPanel(){
        return datatableDRPanel;
    }
    
    public JPanel getGraphicsDRParentPanel(){
        return graphicsDRParentPanel;
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

        topPanel = new javax.swing.JPanel();
        resultsImportingLabel = new javax.swing.JLabel();
        preProcessingLabel = new javax.swing.JLabel();
        globalViewLabel = new javax.swing.JLabel();
        linearRegressionModelLabel = new javax.swing.JLabel();
        doseResponseLabel = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        dataInspectingPanel = new javax.swing.JPanel();
        dataInspectingTabbedPane = new javax.swing.JTabbedPane();
        timeStepsTableScrollPane = new javax.swing.JScrollPane();
        timeStepsTable = new javax.swing.JTable();
        convertedTimeStepsTableScrollPane = new javax.swing.JScrollPane();
        convertedTimeStepsTable = new javax.swing.JTable();
        preprocessingPanel = new javax.swing.JPanel();
        radioButtonsPanel = new javax.swing.JPanel();
        normalizeAreaButton = new javax.swing.JRadioButton();
        deltaAreaButton = new javax.swing.JRadioButton();
        percentageAreaIncreaseButton = new javax.swing.JRadioButton();
        correctedAreaButton = new javax.swing.JRadioButton();
        tableInfoLabel = new javax.swing.JLabel();
        cellCoveredAreaRadioButton = new javax.swing.JRadioButton();
        dataTablePanel = new javax.swing.JPanel();
        graphicsParentPanel = new javax.swing.JPanel();
        globalViewPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        conditionsList = new javax.swing.JList();
        plotErrorBarsCheckBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        plotSelectedConditionsButton = new javax.swing.JButton();
        plotAllConditionsButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        useCorrectedDataCheckBox = new javax.swing.JCheckBox();
        plotPointsCheckBox = new javax.swing.JCheckBox();
        plotLinesCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        firstTimeFrameTextField = new javax.swing.JTextField();
        lastTimeFrameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        showTimeIntervalCheckBox = new javax.swing.JCheckBox();
        globalAreaPanel = new javax.swing.JPanel();
        linearModelParentPanel = new javax.swing.JPanel();
        doseResponsePanel = new javax.swing.JPanel();
        radioButtonsDRPanel = new javax.swing.JPanel();
        inputDRButton = new javax.swing.JRadioButton();
        normalizedPlotDRButton = new javax.swing.JRadioButton();
        resultsDRButton = new javax.swing.JRadioButton();
        initialPlotDRButton = new javax.swing.JRadioButton();
        tableInfoLabel1 = new javax.swing.JLabel();
        datatableDRPanel = new javax.swing.JPanel();
        graphicsDRParentPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(new java.awt.GridBagLayout());

        topPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        topPanel.setOpaque(false);
        topPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        resultsImportingLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        resultsImportingLabel.setText("1. Data Inspecting");
        resultsImportingLabel.setToolTipText("Data loaded from DB");

        preProcessingLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        preProcessingLabel.setText("2. Pre-processing");
        preProcessingLabel.setToolTipText("Data pre-processing: normalization and outliers detection");

        globalViewLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        globalViewLabel.setText("3. Global View");
        globalViewLabel.setToolTipText("Look at all the biological conditions together");

        linearRegressionModelLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        linearRegressionModelLabel.setText("4. Linear Regression Model");
        linearRegressionModelLabel.setToolTipText("Median velocity per condition computation and statistical analysis");

        doseResponseLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        doseResponseLabel.setText("5. Dose-Response");
        doseResponseLabel.setToolTipText("Select conditions and perform logistic regression to find EC50");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultsImportingLabel)
                .addGap(18, 18, 18)
                .addComponent(preProcessingLabel)
                .addGap(18, 18, 18)
                .addComponent(globalViewLabel)
                .addGap(18, 18, 18)
                .addComponent(linearRegressionModelLabel)
                .addGap(18, 18, 18)
                .addComponent(doseResponseLabel)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultsImportingLabel)
                    .addComponent(linearRegressionModelLabel)
                    .addComponent(globalViewLabel)
                    .addComponent(preProcessingLabel)
                    .addComponent(doseResponseLabel))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.03;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(topPanel, gridBagConstraints);

        bottomPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        bottomPanel.setOpaque(false);
        bottomPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        bottomPanel.setLayout(new java.awt.CardLayout());

        dataInspectingPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        dataInspectingPanel.setName("dataInspectingPanel"); // NOI18N
        dataInspectingPanel.setOpaque(false);

        timeStepsTableScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        timeStepsTableScrollPane.setBorder(null);
        timeStepsTableScrollPane.setMinimumSize(new java.awt.Dimension(20, 20));
        timeStepsTableScrollPane.setPreferredSize(new java.awt.Dimension(20, 20));

        timeStepsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        timeStepsTable.setMinimumSize(new java.awt.Dimension(20, 20));
        timeStepsTableScrollPane.setViewportView(timeStepsTable);

        dataInspectingTabbedPane.addTab("Area Values from DB (raw data)", timeStepsTableScrollPane);

        convertedTimeStepsTableScrollPane.setBorder(null);

        convertedTimeStepsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        convertedTimeStepsTableScrollPane.setViewportView(convertedTimeStepsTable);

        dataInspectingTabbedPane.addTab("Converted Area Values", convertedTimeStepsTableScrollPane);

        javax.swing.GroupLayout dataInspectingPanelLayout = new javax.swing.GroupLayout(dataInspectingPanel);
        dataInspectingPanel.setLayout(dataInspectingPanelLayout);
        dataInspectingPanelLayout.setHorizontalGroup(
            dataInspectingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInspectingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataInspectingTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                .addContainerGap())
        );
        dataInspectingPanelLayout.setVerticalGroup(
            dataInspectingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInspectingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataInspectingTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );

        bottomPanel.add(dataInspectingPanel, "dataInspectingPanel");
        dataInspectingPanel.getAccessibleContext().setAccessibleName("");

        preprocessingPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        preprocessingPanel.setName("preprocessingPanel"); // NOI18N
        preprocessingPanel.setOpaque(false);
        preprocessingPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        preprocessingPanel.setLayout(new java.awt.GridBagLayout());

        radioButtonsPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        radioButtonsPanel.setOpaque(false);
        radioButtonsPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        normalizeAreaButton.setText("Normalized Area");
        normalizeAreaButton.setOpaque(false);

        deltaAreaButton.setText("Delta Area");
        deltaAreaButton.setOpaque(false);

        percentageAreaIncreaseButton.setText("%Area Increase");
        percentageAreaIncreaseButton.setOpaque(false);

        correctedAreaButton.setText("Corrected Area");
        correctedAreaButton.setOpaque(false);

        tableInfoLabel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        tableInfoLabel.setMinimumSize(new java.awt.Dimension(20, 20));
        tableInfoLabel.setPreferredSize(new java.awt.Dimension(20, 20));

        cellCoveredAreaRadioButton.setText("Cell Covered Area");
        cellCoveredAreaRadioButton.setOpaque(false);

        javax.swing.GroupLayout radioButtonsPanelLayout = new javax.swing.GroupLayout(radioButtonsPanel);
        radioButtonsPanel.setLayout(radioButtonsPanelLayout);
        radioButtonsPanelLayout.setHorizontalGroup(
            radioButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radioButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(radioButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tableInfoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, radioButtonsPanelLayout.createSequentialGroup()
                        .addComponent(normalizeAreaButton)
                        .addGap(18, 18, 18)
                        .addComponent(cellCoveredAreaRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(deltaAreaButton)
                        .addGap(18, 18, 18)
                        .addComponent(percentageAreaIncreaseButton)
                        .addGap(18, 18, 18)
                        .addComponent(correctedAreaButton)))
                .addContainerGap())
        );
        radioButtonsPanelLayout.setVerticalGroup(
            radioButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radioButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(radioButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deltaAreaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentageAreaIncreaseButton)
                    .addComponent(correctedAreaButton)
                    .addComponent(cellCoveredAreaRadioButton)
                    .addComponent(normalizeAreaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.09;
        preprocessingPanel.add(radioButtonsPanel, gridBagConstraints);

        dataTablePanel.setMinimumSize(new java.awt.Dimension(20, 20));
        dataTablePanel.setOpaque(false);
        dataTablePanel.setPreferredSize(new java.awt.Dimension(20, 20));
        dataTablePanel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        preprocessingPanel.add(dataTablePanel, gridBagConstraints);

        graphicsParentPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        graphicsParentPanel.setOpaque(false);
        graphicsParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        graphicsParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.61;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        preprocessingPanel.add(graphicsParentPanel, gridBagConstraints);

        bottomPanel.add(preprocessingPanel, "preprocessingPanel");

        globalViewPanel.setName("globalViewPanel"); // NOI18N
        globalViewPanel.setOpaque(false);
        globalViewPanel.setLayout(new java.awt.GridBagLayout());

        leftPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        conditionsList.setSelectedIndex(0);
        jScrollPane3.setViewportView(conditionsList);

        plotErrorBarsCheckBox.setText("plot SEM");
        plotErrorBarsCheckBox.setToolTipText("Select this if you want to plot SEM on top of area values");
        plotErrorBarsCheckBox.setOpaque(false);

        jLabel2.setText("Select Conditions to plot");

        plotSelectedConditionsButton.setText("plot selected conditions");
        plotSelectedConditionsButton.setToolTipText("Plot only the conditions selected in the above list");

        plotAllConditionsButton.setText("plot all conditions");
        plotAllConditionsButton.setToolTipText("Ignores the selection on the above list and plot all conditions");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setText("N: number of Replicates");

        useCorrectedDataCheckBox.setText("use corrected data");
        useCorrectedDataCheckBox.setToolTipText("Select this if you want to use data corrected from outliers");
        useCorrectedDataCheckBox.setOpaque(false);

        plotPointsCheckBox.setText("plot points");
        plotPointsCheckBox.setOpaque(false);

        plotLinesCheckBox.setText("plot lines");
        plotLinesCheckBox.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Time frames for analysis");

        firstTimeFrameTextField.setEditable(false);
        firstTimeFrameTextField.setBorder(null);
        firstTimeFrameTextField.setFocusable(false);
        firstTimeFrameTextField.setOpaque(false);

        lastTimeFrameTextField.setEditable(false);
        lastTimeFrameTextField.setBorder(null);
        lastTimeFrameTextField.setFocusable(false);
        lastTimeFrameTextField.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel5.setText("first");

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel6.setText("last");

        showTimeIntervalCheckBox.setText("show time interval");
        showTimeIntervalCheckBox.setToolTipText("");
        showTimeIntervalCheckBox.setOpaque(false);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plotSelectedConditionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plotAllConditionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(plotLinesCheckBox)
                    .addComponent(plotPointsCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addGroup(leftPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstTimeFrameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastTimeFrameTextField)))
                    .addComponent(useCorrectedDataCheckBox)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plotErrorBarsCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(showTimeIntervalCheckBox)))
                .addContainerGap())
        );

        leftPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, plotAllConditionsButton, plotSelectedConditionsButton});

        leftPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {plotErrorBarsCheckBox, plotLinesCheckBox, plotPointsCheckBox, useCorrectedDataCheckBox});

        leftPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {firstTimeFrameTextField, lastTimeFrameTextField});

        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstTimeFrameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastTimeFrameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showTimeIntervalCheckBox)
                .addGap(18, 18, 18)
                .addComponent(useCorrectedDataCheckBox)
                .addGap(18, 18, 18)
                .addComponent(plotPointsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plotLinesCheckBox)
                .addGap(18, 18, 18)
                .addComponent(plotErrorBarsCheckBox)
                .addGap(18, 18, 18)
                .addComponent(plotSelectedConditionsButton)
                .addGap(18, 18, 18)
                .addComponent(plotAllConditionsButton)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.9;
        globalViewPanel.add(leftPanel, gridBagConstraints);

        globalAreaPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        globalAreaPanel.setOpaque(false);
        globalAreaPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        globalAreaPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 0.9;
        globalViewPanel.add(globalAreaPanel, gridBagConstraints);

        bottomPanel.add(globalViewPanel, "globalViewPanel");

        linearModelParentPanel.setName("linearModelPanel"); // NOI18N
        linearModelParentPanel.setOpaque(false);
        linearModelParentPanel.setLayout(new java.awt.GridBagLayout());
        bottomPanel.add(linearModelParentPanel, "linearModelPanel");

        doseResponsePanel.setBackground(new java.awt.Color(255, 255, 255));
        doseResponsePanel.setLayout(new java.awt.GridBagLayout());

        radioButtonsDRPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        radioButtonsDRPanel.setOpaque(false);
        radioButtonsDRPanel.setPreferredSize(new java.awt.Dimension(436, 90));

        inputDRButton.setText("Input data");
        inputDRButton.setOpaque(false);

        normalizedPlotDRButton.setText("Normalized Plot");
        normalizedPlotDRButton.setOpaque(false);

        resultsDRButton.setText("Results");
        resultsDRButton.setOpaque(false);

        initialPlotDRButton.setText("Initial Plot");
        initialPlotDRButton.setOpaque(false);

        tableInfoLabel1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        tableInfoLabel1.setMinimumSize(new java.awt.Dimension(20, 20));
        tableInfoLabel1.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout radioButtonsDRPanelLayout = new javax.swing.GroupLayout(radioButtonsDRPanel);
        radioButtonsDRPanel.setLayout(radioButtonsDRPanelLayout);
        radioButtonsDRPanelLayout.setHorizontalGroup(
            radioButtonsDRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radioButtonsDRPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(radioButtonsDRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableInfoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(radioButtonsDRPanelLayout.createSequentialGroup()
                        .addComponent(inputDRButton)
                        .addGap(18, 18, 18)
                        .addComponent(initialPlotDRButton)
                        .addGap(18, 18, 18)
                        .addComponent(normalizedPlotDRButton)
                        .addGap(18, 18, 18)
                        .addComponent(resultsDRButton)))
                .addContainerGap(318, Short.MAX_VALUE))
        );
        radioButtonsDRPanelLayout.setVerticalGroup(
            radioButtonsDRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radioButtonsDRPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(radioButtonsDRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(normalizedPlotDRButton, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultsDRButton)
                    .addComponent(initialPlotDRButton)
                    .addComponent(inputDRButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableInfoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 846;
        gridBagConstraints.ipady = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        doseResponsePanel.add(radioButtonsDRPanel, gridBagConstraints);

        datatableDRPanel.setBackground(new java.awt.Color(255, 255, 255));
        datatableDRPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        datatableDRPanel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 877;
        gridBagConstraints.ipady = 229;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 1);
        doseResponsePanel.add(datatableDRPanel, gridBagConstraints);

        graphicsDRParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        graphicsDRParentPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 877;
        gridBagConstraints.ipady = 360;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 1);
        doseResponsePanel.add(graphicsDRParentPanel, gridBagConstraints);

        bottomPanel.add(doseResponsePanel, "card6");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.97;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(bottomPanel, gridBagConstraints);

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JRadioButton cellCoveredAreaRadioButton;
    private javax.swing.JList conditionsList;
    private javax.swing.JTable convertedTimeStepsTable;
    private javax.swing.JScrollPane convertedTimeStepsTableScrollPane;
    private javax.swing.JRadioButton correctedAreaButton;
    private javax.swing.JPanel dataInspectingPanel;
    private javax.swing.JTabbedPane dataInspectingTabbedPane;
    private javax.swing.JPanel dataTablePanel;
    private javax.swing.JPanel datatableDRPanel;
    private javax.swing.JRadioButton deltaAreaButton;
    private javax.swing.JLabel doseResponseLabel;
    private javax.swing.JPanel doseResponsePanel;
    private javax.swing.JTextField firstTimeFrameTextField;
    private javax.swing.JPanel globalAreaPanel;
    private javax.swing.JLabel globalViewLabel;
    private javax.swing.JPanel globalViewPanel;
    private javax.swing.JPanel graphicsDRParentPanel;
    private javax.swing.JPanel graphicsParentPanel;
    private javax.swing.JRadioButton initialPlotDRButton;
    private javax.swing.JRadioButton inputDRButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lastTimeFrameTextField;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel linearModelParentPanel;
    private javax.swing.JLabel linearRegressionModelLabel;
    private javax.swing.JRadioButton normalizeAreaButton;
    private javax.swing.JRadioButton normalizedPlotDRButton;
    private javax.swing.JRadioButton percentageAreaIncreaseButton;
    private javax.swing.JButton plotAllConditionsButton;
    private javax.swing.JCheckBox plotErrorBarsCheckBox;
    private javax.swing.JCheckBox plotLinesCheckBox;
    private javax.swing.JCheckBox plotPointsCheckBox;
    private javax.swing.JButton plotSelectedConditionsButton;
    private javax.swing.JLabel preProcessingLabel;
    private javax.swing.JPanel preprocessingPanel;
    private javax.swing.JPanel radioButtonsDRPanel;
    private javax.swing.JPanel radioButtonsPanel;
    private javax.swing.JRadioButton resultsDRButton;
    private javax.swing.JLabel resultsImportingLabel;
    private javax.swing.JCheckBox showTimeIntervalCheckBox;
    private javax.swing.JLabel tableInfoLabel;
    private javax.swing.JLabel tableInfoLabel1;
    private javax.swing.JTable timeStepsTable;
    private javax.swing.JScrollPane timeStepsTableScrollPane;
    private javax.swing.JPanel topPanel;
    private javax.swing.JCheckBox useCorrectedDataCheckBox;
    // End of variables declaration//GEN-END:variables
}

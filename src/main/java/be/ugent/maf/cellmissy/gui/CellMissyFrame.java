/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CellMissyFrame.java
 *
 * Created on Mar 27, 2012, 4:45:13 PM
 */
package be.ugent.maf.cellmissy.gui;

import be.ugent.maf.cellmissy.gui.controller.ApplicationValidator;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Paola
 */
public class CellMissyFrame extends javax.swing.JFrame {

    /**
     * Creates new form CellMissyFrame
     */
    public CellMissyFrame() {
        initComponents();
        // set background to white
        this.getContentPane().setBackground(new Color(255, 255, 255));
        UIManager.put("nimbusBase", Color.lightGray);      // Base color
        UIManager.put("nimbusBlueGrey", Color.lightGray);  // BlueGrey
        UIManager.put("control", Color.white);         // Control
        UIManager.put("OptionPane.background", Color.white); // Background for option pane
        UIManager.put("info", Color.white); // Background for tooltip texts (info class)
    }

    public JPanel getBackgroundPanel() {
        return backgroundPanel;
    }

    public JMenuItem getCellMiaMenuItem() {
        return cellMiaMenuItem;
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public JMenuItem getNewExperimentMenuItem() {
        return newExperimentMenuItem;
    }

    public JMenuItem getUserMenuItem() {
        return userMenuItem;
    }

    public JMenuItem getAssayMenuItem() {
        return assayMenuItem;
    }

    public JMenuItem getInstrumentMenuItem() {
        return instrumentMenuItem;
    }

    public JMenuItem getPlateMenuItem() {
        return plateMenuItem;
    }

    public JMenuItem getGenericInputMenuItem() {
        return genericInputMenuItem;
    }

    public JPanel getAreaAnalysisParentPanel() {
        return areaAnalysisParentPanel;
    }

    public JPanel getSingleCellAnalysisParentPanel() {
        return singleCellAnalysisParentPanel;
    }

    public JPanel getLoadFromCellMiaParentPanel() {
        return loadFromCellMiaParentPanel;
    }

    public JPanel getLoadFromGenericInputParentPanel() {
        return loadFromGenericInputParentPanel;
    }

    public JPanel getSetupExperimentParentPanel() {
        return setupExperimentParentPanel;
    }

    public JMenuItem getAreaMenuItem() {
        return areaMenuItem;
    }

    public JMenuItem getSingleCellMenuItem() {
        return singleCellMenuItem;
    }

    public JPanel getHomeParentPanel() {
        return homeParentPanel;
    }

    public JMenuItem getOverviewMenuItem() {
        return overviewMenuItem;
    }

    public JMenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public JMenuItem getHelpMenuItem() {
        return helpMenuItem;
    }

    public JMenuItem getExportExperimentMenuItem() {
        return exportExperimentMenuItem;
    }

    public JMenuItem getImportExperimentMenuItem() {
        return importExperimentMenuItem;
    }

    public JMenuItem getExportTemplateMenuItem() {
        return exportTemplateMenuItem;
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        homeParentPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        setupExperimentParentPanel = new javax.swing.JPanel();
        loadFromCellMiaParentPanel = new javax.swing.JPanel();
        loadFromGenericInputParentPanel = new javax.swing.JPanel();
        areaAnalysisParentPanel = new javax.swing.JPanel();
        singleCellAnalysisParentPanel = new javax.swing.JPanel();
        cellMissyMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newExperimentMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        loadDataMenu = new javax.swing.JMenu();
        genericInputMenuItem = new javax.swing.JMenuItem();
        cellMiaMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        dataAnalysisMenu = new javax.swing.JMenu();
        areaMenuItem = new javax.swing.JMenuItem();
        singleCellMenuItem = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        overviewMenuItem = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        importExperimentMenuItem = new javax.swing.JMenuItem();
        exportExperimentMenuItem = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        exportTemplateMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        assayMenuItem = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        instrumentMenuItem = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        plateMenuItem = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        userMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(30, 5, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(120, 300));

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        backgroundPanel.setLayout(new java.awt.CardLayout());

        homeParentPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        homeParentPanel.setName("homeParentPanel"); // NOI18N
        homeParentPanel.setOpaque(false);
        homeParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        homePanel.setBackground(new java.awt.Color(255, 255, 255));
        homePanel.setMinimumSize(new java.awt.Dimension(20, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Cell Migration Invasion");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel4.setText("CellMissy");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("Storage System");

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel6))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        javax.swing.GroupLayout homeParentPanelLayout = new javax.swing.GroupLayout(homeParentPanel);
        homeParentPanel.setLayout(homeParentPanelLayout);
        homeParentPanelLayout.setHorizontalGroup(
            homeParentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
            .addGroup(homeParentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homeParentPanelLayout.createSequentialGroup()
                    .addGap(0, 176, Short.MAX_VALUE)
                    .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 177, Short.MAX_VALUE)))
        );
        homeParentPanelLayout.setVerticalGroup(
            homeParentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(homeParentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homeParentPanelLayout.createSequentialGroup()
                    .addGap(0, 189, Short.MAX_VALUE)
                    .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 190, Short.MAX_VALUE)))
        );

        backgroundPanel.add(homeParentPanel, "homePanel");
        homeParentPanel.getAccessibleContext().setAccessibleName("homePanel");

        setupExperimentParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        setupExperimentParentPanel.setName("setupExperimentParentPanel"); // NOI18N
        setupExperimentParentPanel.setPreferredSize(new java.awt.Dimension(20, 20));
        setupExperimentParentPanel.setLayout(new java.awt.GridBagLayout());
        backgroundPanel.add(setupExperimentParentPanel, "setupExperimentParentPanel");
        setupExperimentParentPanel.getAccessibleContext().setAccessibleName("setupExperimentParentPanel");

        loadFromCellMiaParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        loadFromCellMiaParentPanel.setName("loadFromCellMiaParentPanel"); // NOI18N
        loadFromCellMiaParentPanel.setLayout(new java.awt.GridBagLayout());
        backgroundPanel.add(loadFromCellMiaParentPanel, "loadFromCellMiaParentPanel");
        loadFromCellMiaParentPanel.getAccessibleContext().setAccessibleName("loadFromCellMiaParentPanel");

        loadFromGenericInputParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        loadFromGenericInputParentPanel.setName("loadFromGenericInputParentPanel"); // NOI18N
        loadFromGenericInputParentPanel.setLayout(new java.awt.GridBagLayout());
        backgroundPanel.add(loadFromGenericInputParentPanel, "loadFromGenericInputParentPanel");
        loadFromGenericInputParentPanel.getAccessibleContext().setAccessibleName("loadFromGenericInputParentPanel");
        loadFromGenericInputParentPanel.getAccessibleContext().setAccessibleDescription("");

        areaAnalysisParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        areaAnalysisParentPanel.setName("areaAnalysisParentPanel"); // NOI18N
        areaAnalysisParentPanel.setLayout(new java.awt.GridBagLayout());
        backgroundPanel.add(areaAnalysisParentPanel, "areaAnalysisParentPanel");
        areaAnalysisParentPanel.getAccessibleContext().setAccessibleName("areaAnalysisParentPanel");
        areaAnalysisParentPanel.getAccessibleContext().setAccessibleDescription("");

        singleCellAnalysisParentPanel.setName("singleCellAnalysisParentPanel"); // NOI18N
        singleCellAnalysisParentPanel.setOpaque(false);
        singleCellAnalysisParentPanel.setLayout(new java.awt.GridBagLayout());
        backgroundPanel.add(singleCellAnalysisParentPanel, "singleCellAnalysisParentPanel");
        singleCellAnalysisParentPanel.getAccessibleContext().setAccessibleName("singleCellAnalysisParentPanel");

        cellMissyMenuBar.setBackground(java.awt.Color.white);
        cellMissyMenuBar.setAlignmentY(0.5F);
        cellMissyMenuBar.setMinimumSize(new java.awt.Dimension(5, 2));

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");

        newExperimentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newExperimentMenuItem.setMnemonic('E');
        newExperimentMenuItem.setText("Create Experiment");
        newExperimentMenuItem.setToolTipText("");
        newExperimentMenuItem.setIconTextGap(2);
        fileMenu.add(newExperimentMenuItem);
        fileMenu.add(jSeparator3);

        loadDataMenu.setMnemonic('L');
        loadDataMenu.setText("Load Data...");
        loadDataMenu.setIconTextGap(2);

        genericInputMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        genericInputMenuItem.setText("... from generic input");
        loadDataMenu.add(genericInputMenuItem);

        cellMiaMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        cellMiaMenuItem.setText("... from CELLMIA");
        loadDataMenu.add(cellMiaMenuItem);

        fileMenu.add(loadDataMenu);
        fileMenu.add(jSeparator4);

        dataAnalysisMenu.setText("Data Analysis...");

        areaMenuItem.setText("...area");
        dataAnalysisMenu.add(areaMenuItem);

        singleCellMenuItem.setText("...single cell");
        dataAnalysisMenu.add(singleCellMenuItem);

        fileMenu.add(dataAnalysisMenu);
        fileMenu.add(jSeparator5);

        overviewMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        overviewMenuItem.setMnemonic('O');
        overviewMenuItem.setText("Overview");
        fileMenu.add(overviewMenuItem);
        fileMenu.add(jSeparator7);

        importExperimentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        importExperimentMenuItem.setText("Import Experiment...");
        fileMenu.add(importExperimentMenuItem);

        exportExperimentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exportExperimentMenuItem.setText("Export Experiment...");
        fileMenu.add(exportExperimentMenuItem);
        fileMenu.add(jSeparator6);

        exportTemplateMenuItem.setText("Export Template...");
        fileMenu.add(exportTemplateMenuItem);
        fileMenu.add(jSeparator2);

        exitMenuItem.setMnemonic('X');
        exitMenuItem.setText("Exit");
        fileMenu.add(exitMenuItem);

        cellMissyMenuBar.add(fileMenu);

        editMenu.setMnemonic('E');
        editMenu.setText("Edit");

        assayMenuItem.setText("Assay");
        editMenu.add(assayMenuItem);
        editMenu.add(jSeparator8);

        instrumentMenuItem.setText("Instrument");
        editMenu.add(instrumentMenuItem);
        editMenu.add(jSeparator9);

        plateMenuItem.setText("Multiwell Plate");
        editMenu.add(plateMenuItem);
        editMenu.add(jSeparator10);

        userMenuItem.setText("User Management");
        userMenuItem.setIconTextGap(2);
        editMenu.add(userMenuItem);

        cellMissyMenuBar.add(editMenu);

        helpMenu.setMnemonic('H');
        helpMenu.setText("Help");

        helpMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        helpMenuItem.setMnemonic('H');
        helpMenuItem.setText("Help");
        helpMenu.add(helpMenuItem);
        helpMenu.add(jSeparator1);

        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        cellMissyMenuBar.add(helpMenu);

        setJMenuBar(cellMissyMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CellMissyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationValidator applicationValidator = new ApplicationValidator();
                applicationValidator.init();
                applicationValidator.startApplicationContext();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JPanel areaAnalysisParentPanel;
    private javax.swing.JMenuItem areaMenuItem;
    private javax.swing.JMenuItem assayMenuItem;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JMenuItem cellMiaMenuItem;
    private javax.swing.JMenuBar cellMissyMenuBar;
    private javax.swing.JMenu dataAnalysisMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem exportExperimentMenuItem;
    private javax.swing.JMenuItem exportTemplateMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem genericInputMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel homeParentPanel;
    private javax.swing.JMenuItem importExperimentMenuItem;
    private javax.swing.JMenuItem instrumentMenuItem;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenu loadDataMenu;
    private javax.swing.JPanel loadFromCellMiaParentPanel;
    private javax.swing.JPanel loadFromGenericInputParentPanel;
    private javax.swing.JMenuItem newExperimentMenuItem;
    private javax.swing.JMenuItem overviewMenuItem;
    private javax.swing.JMenuItem plateMenuItem;
    private javax.swing.JPanel setupExperimentParentPanel;
    private javax.swing.JPanel singleCellAnalysisParentPanel;
    private javax.swing.JMenuItem singleCellMenuItem;
    private javax.swing.JMenuItem userMenuItem;
    // End of variables declaration//GEN-END:variables
}

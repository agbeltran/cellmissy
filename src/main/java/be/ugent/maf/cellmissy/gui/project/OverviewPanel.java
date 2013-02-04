/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OverviewPanel.java
 *
 * Created on Jan 2, 2013, 6:43:56 PM
 */
package be.ugent.maf.cellmissy.gui.project;

import javax.swing.JList;

/**
 *
 * @author Paola Masuzzo
 */
public class OverviewPanel extends javax.swing.JPanel {

    /** Creates new form OverviewPanel */
    public OverviewPanel() {
        initComponents();
    }

    public JList getProjectJList() {
        return projectJList;
    }

    public JList getExperimentJList() {
        return experimentJList;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        projectJList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        experimentJList = new javax.swing.JList();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Projects"));
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(10, 10));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(10, 10));

        projectJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        projectJList.setMinimumSize(new java.awt.Dimension(10, 10));
        projectJList.setName(""); // NOI18N
        projectJList.setPreferredSize(new java.awt.Dimension(10, 10));
        projectJList.setSelectedIndex(0);
        projectJList.setVisibleRowCount(1);
        jScrollPane1.setViewportView(projectJList);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Experiments"));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(10, 10));
        jScrollPane3.setOpaque(false);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(10, 10));

        jScrollPane3.setViewportView(experimentJList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList experimentJList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList projectJList;
    // End of variables declaration//GEN-END:variables
}
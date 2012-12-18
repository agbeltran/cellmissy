/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.controller;

import be.ugent.maf.cellmissy.entity.Experiment;
import be.ugent.maf.cellmissy.entity.ExperimentStatus;
import be.ugent.maf.cellmissy.entity.PlateCondition;
import be.ugent.maf.cellmissy.entity.PlateFormat;
import be.ugent.maf.cellmissy.entity.Well;
import be.ugent.maf.cellmissy.entity.WellHasImagingType;
import be.ugent.maf.cellmissy.gui.experiment.load.LoadDataFromCellMiaPanel;
import be.ugent.maf.cellmissy.gui.plate.ImagedPlatePanel;
import be.ugent.maf.cellmissy.gui.plate.WellGui;
import be.ugent.maf.cellmissy.parser.ObsepFileParser;
import be.ugent.maf.cellmissy.service.ExperimentService;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * Parent Controller: CellMissy Controller (main controller)
 * Child Controllers: Imaged Plate Controller, Experiment Metadata Controller
 * @author Paola Masuzzo
 */
@Controller("loadExperimentController")
public class LoadExperimentFromCellMiaController {

    //model
    private Experiment experiment;
    //view
    private LoadDataFromCellMiaPanel loadDataFromCellMiaPanel;
    //parent controller
    @Autowired
    private CellMissyController cellMissyController;
    //child controllers
    @Autowired
    private ImagedPlateController imagedPlateController;
    @Autowired
    private ExperimentMetadataController experimentMetadataController;
    //services
    @Autowired
    private ExperimentService experimentService;
    @Autowired
    private ObsepFileParser obsepFileParser;

    /**
     * initialize controller 
     */
    public void init() {
        // init main view
        loadDataFromCellMiaPanel = new LoadDataFromCellMiaPanel();
        //init main view
        initMainPanel();
        //init child controller
        imagedPlateController.init();
        experimentMetadataController.init();
    }

    /*
     * getters and setters
     */
    public LoadDataFromCellMiaPanel getLoadDataFromCellMiaPanel() {
        return loadDataFromCellMiaPanel;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public void updateInfoLabel(JLabel label, String message) {
        cellMissyController.updateInfoLabel(label, message);
    }

    public void setCursor(Cursor cursor) {
        cellMissyController.setCursor(cursor);
    }

    public void showMessage(String message, Integer messageType) {
        cellMissyController.showMessage(message, messageType);
    }

    public int showConfirmDialog(String message, String title, Integer optionType) {
        return JOptionPane.showConfirmDialog(cellMissyController.cellMissyFrame, message, title, optionType);
    }

    public void initPlatePanel(PlateFormat plateFormat, Dimension dimension) {
        imagedPlateController.getLoadDataPlatePanel().initPanel(plateFormat, dimension);
    }

    public ImagedPlatePanel getLoadDataPlatePanel() {
        return imagedPlateController.getLoadDataPlatePanel();
    }

    /*
     * private methods and classes
     */
    /**
     * initializes the loading data panel
     */
    private void initMainPanel() {

        //disable buttons
        loadDataFromCellMiaPanel.getFinishButton().setEnabled(false);
        loadDataFromCellMiaPanel.getExpDataButton().setEnabled(false);
        loadDataFromCellMiaPanel.getForwardButton().setEnabled(false);
        loadDataFromCellMiaPanel.getCancelButton().setEnabled(false);
        //hide progress bar
        loadDataFromCellMiaPanel.getjProgressBar1().setVisible(false);

        //update info message
        cellMissyController.updateInfoLabel(loadDataFromCellMiaPanel.getInfolabel(), "Select a project and then an experiment in progress to load CELLMIA data.");

        /**
         * add action listeners
         */
        //parse obseo file from the microscope
        loadDataFromCellMiaPanel.getExpDataButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (experiment.getObsepFile() != null) {
                    File obsepFile = experiment.getObsepFile();
                    setExperimentData(obsepFile);
                } else {
                    cellMissyController.showMessage("No valid microscope file was found or different files were found.\nPlease select a file.", 0);
                    //choose file to parse form microscope folder
                    JFileChooser chooseObsepFile = new JFileChooser();
                    chooseObsepFile.setFileFilter(new FileFilter() {

                        // to select only (.obsep) files
                        @Override
                        public boolean accept(File f) {
                            return f.getName().toLowerCase().endsWith(".obsep");
                        }

                        @Override
                        public String getDescription() {
                            return ("(.obsep)");
                        }
                    });

                    // in response to the button click, show open dialog
                    int returnVal = chooseObsepFile.showOpenDialog(cellMissyController.cellMissyFrame);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File obsepFile = chooseObsepFile.getSelectedFile();
                        setExperimentData(obsepFile);
                    } else {
                        cellMissyController.showMessage("Open command cancelled by user", 1);
                    }
                }
                cellMissyController.updateInfoLabel(loadDataFromCellMiaPanel.getInfolabel(), "Click <<Forward>> to process imaging data for the experiment.");
                loadDataFromCellMiaPanel.getForwardButton().setEnabled(true);
                loadDataFromCellMiaPanel.getExpDataButton().setEnabled(false);
            }
        });

        //cancel the selection: reset Plate View
        loadDataFromCellMiaPanel.getCancelButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (WellGui wellGui : imagedPlateController.getLoadDataPlatePanel().getWellGuiList()) {

                    //empty the collection of WellHasImagingType (so color is set to default)
                    wellGui.getWell().getWellHasImagingTypeCollection().clear();

                    //remove smaller ellipsi
                    List<Ellipse2D> ellipse2DList = new ArrayList<>();
                    for (Ellipse2D ellipse2D : wellGui.getEllipsi()) {
                        if (wellGui.getEllipsi().indexOf(ellipse2D) > 0) {
                            ellipse2DList.add(ellipse2D);
                        }
                    }
                    wellGui.getEllipsi().removeAll(ellipse2DList);
                    imagedPlateController.getLoadDataPlatePanel().repaint();
                }
                //update info message (the user needs to click again on forward)
                updateInfoLabel(loadDataFromCellMiaPanel.getInfolabel(), "Click again <<Forward>> to process imaging data.");
                //set boolean isFirtTime to false
                imagedPlateController.setIsFirtTime(false);
                //disable and enable buttons
                loadDataFromCellMiaPanel.getFinishButton().setEnabled(false);
                loadDataFromCellMiaPanel.getForwardButton().setEnabled(true);
                loadDataFromCellMiaPanel.getCancelButton().setEnabled(false);
            }
        });

        //save the experiment once all data have been loaded
        loadDataFromCellMiaPanel.getFinishButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //set CellMia Data
                setCellMiaData();
                //set experiment status to "performed" and save it to DB
                experiment.setExperimentStatus(ExperimentStatus.PERFORMED);
                //launch a swing worker to save the experiment in the background thread
                SaveExperimentWorker worker = new SaveExperimentWorker();
                worker.execute();
            }
        });
    }

    /**
     * set experiment data parsing the obsep file from microscope
     * @param obsepFile: this is loaded from the experiment or it is rather chosen by the user
     */
    private void setExperimentData(File obsepFile) {
        obsepFileParser.parseObsepFile(obsepFile);
        List<Double> experimentInfo = obsepFileParser.getExperimentInfo();
        experimentMetadataController.getLoadExperimentInfoPanel().getTimeFramesTextField().setText(experimentInfo.get(0).toString());
        experimentMetadataController.getLoadExperimentInfoPanel().getIntervalTextField().setText(experimentInfo.get(1).toString());
        experimentMetadataController.getLoadExperimentInfoPanel().getUnitLabel().setText(obsepFileParser.getUnit().name().toLowerCase());
        experimentMetadataController.getLoadExperimentInfoPanel().getDurationTextField().setText(experimentInfo.get(2).toString());
    }

    /**
     * this method sets Migration data of wells, before the experiment is saved to DB
     */
    private void setCellMiaData() {

        for (PlateCondition plateCondition : experiment.getPlateConditionCollection()) {
            for (WellGui wellGui : imagedPlateController.getLoadDataPlatePanel().getWellGuiList()) {

                //if the wellGui has a well with a NOT empty collection of wellHasImagingTypes, the well has been imaged
                //if the wellGui has a rectangle, the well belongs to a certain condition
                //only if these two conditions are true, motility data must be set and stored to DB
                if (!wellGui.getWell().getWellHasImagingTypeCollection().isEmpty() && wellGui.getRectangle() != null) {

                    for (Well well : plateCondition.getWellCollection()) {
                        //check for coordinates
                        if (well.getColumnNumber() == wellGui.getColumnNumber() && well.getRowNumber() == wellGui.getRowNumber()) {
                            //set collection of wellHasImagingType to the well of the plateCondition
                            well.setWellHasImagingTypeCollection(wellGui.getWell().getWellHasImagingTypeCollection());

                            //the other way around: set the well for each wellHasImagingType
                            for (WellHasImagingType wellHasImagingType : well.getWellHasImagingTypeCollection()) {
                                wellHasImagingType.setWell(well);
                            }
                        }

                    }
                }
            }
        }
    }

    /**
     * Swing Worker to save the Experiment
     */
    private class SaveExperimentWorker extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {

            //disable the Finish button and show a waiting cursor
            loadDataFromCellMiaPanel.getFinishButton().setEnabled(false);
            cellMissyController.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            //show a progress bar (indeterminate)
            loadDataFromCellMiaPanel.getjProgressBar1().setVisible(true);
            loadDataFromCellMiaPanel.getjProgressBar1().setIndeterminate(true);

            //INSERT experiment to DB
            experimentService.save(experiment);
            return null;
        }

        @Override
        protected void done() {

            //show back default cursor and hide the progress bar
            cellMissyController.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            loadDataFromCellMiaPanel.getjProgressBar1().setVisible(false);
            //update info for the user
            showMessage("Experiment was successfully saved to DB.", 1);
            updateInfoLabel(loadDataFromCellMiaPanel.getInfolabel(), "Experiment was successfully saved to DB.");
        }
    }
}
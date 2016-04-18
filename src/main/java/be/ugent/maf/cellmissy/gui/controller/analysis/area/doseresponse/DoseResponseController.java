/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.controller.analysis.area.doseresponse;

import be.ugent.maf.cellmissy.analysis.area.doseresponse.SigmoidFitter;
import be.ugent.maf.cellmissy.entity.PlateCondition;
import be.ugent.maf.cellmissy.entity.result.area.AreaAnalysisResults;
import be.ugent.maf.cellmissy.entity.result.area.doseresponse.DoseResponseAnalysisGroup;
import be.ugent.maf.cellmissy.entity.result.area.doseresponse.DoseResponseAnalysisResults;
import be.ugent.maf.cellmissy.entity.result.area.doseresponse.SigmoidFittingResultsHolder;
import be.ugent.maf.cellmissy.gui.CellMissyFrame;
import be.ugent.maf.cellmissy.gui.controller.analysis.area.AreaMainController;
import be.ugent.maf.cellmissy.gui.experiment.analysis.area.doseresponse.DRPanel;
import be.ugent.maf.cellmissy.gui.view.renderer.table.TableHeaderRenderer;
import be.ugent.maf.cellmissy.gui.view.table.model.NonEditableTableModel;
import be.ugent.maf.cellmissy.utils.AnalysisUtils;
import be.ugent.maf.cellmissy.utils.GuiUtils;
import be.ugent.maf.cellmissy.utils.JFreeChartUtils;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Controller for area dose-response analysis
 *
 * @author Gwendolien
 */
@Controller("doseResponseController")
public class DoseResponseController {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(DoseResponseController.class);
    //model
    private JTable dataTable;
    private int standardHillslope;
    private DoseResponseAnalysisGroup dRAnalysisGroup;
    private boolean firstFitting;
    //view
    private DRPanel dRPanel;
    // parent controller
    @Autowired
    private AreaMainController areaMainController;
    // child controller
    @Autowired
    private DRInputController dRInputController;
    @Autowired
    private DRInitialController dRInitialController;
    @Autowired
    private DRNormalizedController dRNormalizedController;
    @Autowired
    private DRResultsController dRResultsController;
    // services
    @Autowired
    private SigmoidFitter sigmoidFitter;
    private GridBagConstraints gridBagConstraints;

    /**
     * Initialize controller
     */
    public void init() {
        gridBagConstraints = GuiUtils.getDefaultGridBagConstraints();
        //init view
        initMainView();
        //init child controllers
        dRInputController.init();
        dRInitialController.init();
        dRNormalizedController.init();
        dRResultsController.init();
    }

    /**
     * Getters and setters
     *
     * @return
     */
    public DRPanel getDRPanel() {
        return dRPanel;
    }

    public int getStandardHillslope() {
        return standardHillslope;
    }

    public void setStandardHillslope(int standardHillslope) {
        this.standardHillslope = standardHillslope;
    }

    public void setdRAnalysisGroup(DoseResponseAnalysisGroup dRAnalysisGroup) {
        this.dRAnalysisGroup = dRAnalysisGroup;
    }

    public DoseResponseAnalysisGroup getdRAnalysisGroup() {
        return dRAnalysisGroup;
    }

    public Map<PlateCondition, AreaAnalysisResults> getLinearResultsAnalysisMap() {
        return areaMainController.getLinearResultsAnalysisMap();
    }

    public List<Integer> getNumberOfReplicates() {
        return areaMainController.getNumberOfReplicates();
    }

    public CellMissyFrame getCellMissyFrame() {
        return areaMainController.getCellMissyFrame();
    }

    public boolean isFirstFitting() {
        return firstFitting;
    }

    public void setFirstFitting(boolean firstFitting) {
        this.firstFitting = firstFitting;
    }
    
    public LinkedHashMap<Double, List<Double>> getDataToFit(boolean normalized) {
        if (normalized) {
            return dRNormalizedController.getDataToFit();
        } else {
            return dRInitialController.getDataToFit();
        }
    }

    /**
     * Called by parent controller, initialize tables
     */
    public void onDoseResponse() {
        dRInputController.initDRInputData();
        //switch shared table view
        updateModelInTable(dRInputController.getTableModel());
        updateTableInfoMessage("This table contains all conditions and their respective slopes");
    }

    /**
     * Do a fitting according to initial, standard parameters.
     */
    public void initFirstFitting() {
        dRInitialController.initDRInitialData();
        dRNormalizedController.initDRNormalizedData();
    }

    /**
     * update information message above table. Message will be different for
     * each subview
     *
     * @param messageToShow
     */
    public void updateTableInfoMessage(String messageToShow) {
        dRPanel.getTableInfoLabel().setText(messageToShow);
    }

    /**
     * Plots the fitted data.
     */
    public void plotDoseResponse(ChartPanel chartPanel, LinkedHashMap<Double, List<Double>> dataToPlot, DoseResponseAnalysisGroup analysisGroup, boolean normalized) {
        JFreeChart doseResponseChart = createDoseResponseChart(dataToPlot, analysisGroup, normalized);
        chartPanel.setChart(doseResponseChart);
        //add chartpanel to graphics parent panel and repaint
        //dRPanel.getGraphicsDRParentPanel().add(chartPanel,gridBagConstraints);
        //dRPanel.getGraphicsDRParentPanel().repaint();
    }

    /**
     * Perform fitting according to user specifications. This method will check
     * how many parameters have been constrained and pick the right fitter
     * class.
     *
     * @param dataToFit The data (log-transformed concentration - velocity)
     * @param resultsHolder The class that will contain the results from fitting
     * @param bottomConstrained Double if user constrains, otherwise null
     * @param topConstrained Double if user constrains, otherwise null
     * @param standardHillcurve If true, will use standardHillSlope field to
     * constrain
     */
    public void performFitting(LinkedHashMap<Double, List<Double>> dataToFit, SigmoidFittingResultsHolder resultsHolder, Double bottomConstrained, Double topConstrained, boolean standardHillcurve) {
        if (bottomConstrained != null) {

            if (topConstrained != null) {
                if (standardHillcurve) {
                    sigmoidFitter.fitBotTopHillConstrain(dataToFit, resultsHolder, bottomConstrained, topConstrained, getStandardHillslope());
                } else {
                    sigmoidFitter.fitBotTopConstrain(dataToFit, resultsHolder, bottomConstrained, topConstrained);
                }
            } else if (standardHillcurve) {
                sigmoidFitter.fitBotHillConstrain(dataToFit, resultsHolder, bottomConstrained, getStandardHillslope());
            } else {
                sigmoidFitter.fitBotConstrain(dataToFit, resultsHolder, bottomConstrained);
            }
        } else if (topConstrained != null) {
            if (standardHillcurve) {
                sigmoidFitter.fitTopHillConstrain(dataToFit, resultsHolder, topConstrained, getStandardHillslope());
            } else {
                sigmoidFitter.fitTopConstrain(dataToFit, resultsHolder, topConstrained);
            }
        } else if (standardHillcurve) {
            sigmoidFitter.fitHillConstrain(dataToFit, resultsHolder, getStandardHillslope());
        } else {
            sigmoidFitter.fitNoConstrain(dataToFit, resultsHolder);
        }
    }

    /**
     * Gets conditions that were processed in previous area analysis steps. This
     * is nessesary to populate table when on input panel.
     *
     * @return list of all processed conditions viable for dose-response
     * analysis
     */
    public List<PlateCondition> getProcessedConditions() {
        List<PlateCondition> processedConditions = areaMainController.getProcessedConditions();
        return processedConditions;
    }

    /**
     * Reset views on cancel
     */
    public void resetOnCancel() {
        dataTable.setModel(new DefaultTableModel());
        dRInputController.getdRInputPanel().getSlopesTable().setModel(new DefaultTableModel());
        dRInitialController.getInitialChartPanel().setChart(null);
        dRNormalizedController.getNormalizedChartPanel().setChart(null);
        dRResultsController.getResultsChartPanel().setChart(null);
        dRPanel.getGraphicsDRParentPanel().remove(dRInputController.getdRInputPanel());
        dRPanel.getGraphicsDRParentPanel().remove(dRInitialController.getDRInitialPlotPanel());
        dRPanel.getGraphicsDRParentPanel().remove(dRNormalizedController.getDRNormalizedPlotPanel());
        dRPanel.getGraphicsDRParentPanel().remove(dRResultsController.getdRResultsPanel());
        dRPanel.getGraphicsDRParentPanel().revalidate();
        dRPanel.getGraphicsDRParentPanel().repaint();
    }

    /**
     * Returns a dose-response chart containing scattered xy experimental values
     * and the curve (line) from the fitting. To be visible in the program,
     * another method adds the chart to the right panel.
     *
     * @param dataToPlot The map created in a child controller, maps
     * log-transformed concentration to replicate (normalized) velocities.
     * @param analysisGroup The dose-response analysis group
     * @param normalized Whether the data is normalized or not
     * @return
     */
    public JFreeChart createDoseResponseChart(LinkedHashMap<Double, List<Double>> dataToPlot, DoseResponseAnalysisGroup analysisGroup, boolean normalized) {
        //a single plot contains both scatter data and fitted line
        XYPlot plot = new XYPlot();
        //setup scatter data of experimental concentrations/slopes, renderer and axis
        XYSeriesCollection experimentalData = new XYSeriesCollection();
        XYSeries scatterXYSeries = JFreeChartUtils.generateXYSeries(AnalysisUtils.generateXValues(dataToPlot), AnalysisUtils.generateYValues(dataToPlot));
        scatterXYSeries.setKey("Experimental data");
        experimentalData.addSeries(scatterXYSeries);
        XYItemRenderer renderer1 = new XYDotRenderer();   // Shapes only
        ValueAxis domain1 = new NumberAxis("Log of concentration");
        ValueAxis range1 = new NumberAxis("Velocity");
        // Set the scatter data, renderer, and axis into plot
        plot.setDataset(0, experimentalData);
        plot.setRenderer(0, renderer1);
        plot.setDomainAxis(0, domain1);
        plot.setRangeAxis(0, range1);
        // Map the scatter to the first Domain and first Range
        plot.mapDatasetToDomainAxis(0, 0);
        plot.mapDatasetToRangeAxis(0, 0);

        // Create the line data, renderer, and axis
        XYSeriesCollection fitting = new XYSeriesCollection();
        // create xy series of simulated data from the parameters from the fitting
        XYSeries fittingData = simulateData(analysisGroup, normalized);
        fittingData.setKey("Fitting");
        fitting.addSeries(fittingData);
        XYItemRenderer renderer2 = new XYSplineRenderer();   // Lines only
        ValueAxis domain2 = new NumberAxis("Domain2");
        ValueAxis range2 = new NumberAxis("Range2");
        // Set the line data, renderer, and axis into plot
        plot.setDataset(1, fitting);
        plot.setRenderer(1, renderer2);
        plot.setDomainAxis(1, domain2);
        plot.setRangeAxis(1, range2);
        // Map the line to the second Domain and second Range
        plot.mapDatasetToDomainAxis(1, 1);
        plot.mapDatasetToRangeAxis(1, 1);

        // show the r squared value
        SigmoidFittingResultsHolder resultsholder = null;
        if (normalized) {
            resultsholder = analysisGroup.getDoseResponseAnalysisResults().getNormalizedFittingResults();
        } else {
            resultsholder = analysisGroup.getDoseResponseAnalysisResults().getInitialFittingResults();
        }
        plot.addAnnotation(new XYTextAnnotation("R2=" + AnalysisUtils.computeRSquared(dataToPlot, resultsholder),0.00001,100.0));

        // Create the chart with the plot and no legend
        JFreeChart chart = new JFreeChart("Title", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
        String title = new String();
        if (normalized) {
            title = "Normalized fitting";
        } else {
            title = "Initial fitting";
        }
        JFreeChartUtils.setupDoseResponseChart(chart, title);
        return chart;
    }

    /**
     * This method takes the fitted parameters that make up the dose-response
     * function from the analysis group results holder and creates x and y
     * values. This is needed to put the fitted function curve on the plot.
     *
     * @param analysisGroup
     * @param normalized Whether the method takes the fitted parameters from the
     * normalized or initial fitting
     */
    public XYSeries simulateData(DoseResponseAnalysisGroup analysisGroup, boolean normalized) {
        DoseResponseAnalysisResults analysisResults = analysisGroup.getDoseResponseAnalysisResults();
        SigmoidFittingResultsHolder resultsholder = null;
        if (!normalized) {
            resultsholder = analysisResults.getInitialFittingResults();
        } else {
            resultsholder = analysisResults.getNormalizedFittingResults();
        }
        return JFreeChartUtils.createFittedDataset(resultsholder.getTop(), resultsholder.getBottom(), resultsholder.getHillslope(), resultsholder.getLogEC50());
    }

    /**
     * private methods
     */
    /**
     * Initialize main view
     */
    private void initMainView() {
        dRPanel = new DRPanel();
        //create a ButtonGroup for the radioButtons used for analysis
        ButtonGroup mainDRRadioButtonGroup = new ButtonGroup();
        //adding buttons to a ButtonGroup automatically deselect one when another one gets selected
        mainDRRadioButtonGroup.add(dRPanel.getInputDRButton());
        mainDRRadioButtonGroup.add(dRPanel.getInitialPlotDRButton());
        mainDRRadioButtonGroup.add(dRPanel.getNormalizedPlotDRButton());
        mainDRRadioButtonGroup.add(dRPanel.getResultsDRButton());
        //select as default first button
        dRPanel.getInputDRButton().setSelected(true);
        //init dataTable
        dataTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(dataTable);
        //the table will take all the viewport height available
        dataTable.setFillsViewportHeight(true);
        scrollPane.getViewport().setBackground(Color.white);
        dataTable.getTableHeader().setReorderingAllowed(false);
        //row and column selection must be false
        //dataTable.setColumnSelectionAllowed(false);
        //dataTable.setRowSelectionAllowed(false);
        dRPanel.getDatatableDRPanel().add(scrollPane);

        /**
         * When button is selected, switch view to corresponding subview
         */
        dRPanel.getInputDRButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //switch shared table view
                updateModelInTable(dRInputController.getTableModel());
                updateTableInfoMessage("This table contains all conditions and their respective slopes");
                /**
                 * for (int columnIndex = 0; columnIndex <
                 * dataTable.getColumnCount(); columnIndex++) {
                 * GuiUtils.packColumn(dataTable, columnIndex); }
                 */
                dataTable.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(SwingConstants.RIGHT));
                //remove other panels
                dRInitialController.getInitialChartPanel().setChart(null);
                dRNormalizedController.getNormalizedChartPanel().setChart(null);
                dRResultsController.getResultsChartPanel().setChart(null);
//                dRPanel.getGraphicsDRParentPanel().remove(dRInitialController.getDRInitialPlotPanel());
//                dRPanel.getGraphicsDRParentPanel().remove(dRNormalizedController.getDRNormalizedPlotPanel());
//                dRPanel.getGraphicsDRParentPanel().remove(dRResultsController.getdRResultsPanel());
//                dRPanel.getGraphicsDRParentPanel().repaint();
//                //add panel to view
//                dRPanel.getGraphicsDRParentPanel().add(dRInputController.getdRInputPanel(), gridBagConstraints);
            }
        });

        dRPanel.getInitialPlotDRButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isFirstFitting()) {
                    initFirstFitting();
                    setFirstFitting(false);
                }
                //switch shared table view
                updateModelInTable(dRInitialController.getTableModel());
                updateTableInfoMessage("Concentrations of conditions selected previously have been log-transformed, slopes have not been changed");
                /**
                 * for (int columnIndex = 0; columnIndex <
                 * dataTable.getColumnCount(); columnIndex++) {
                 * GuiUtils.packColumn(dataTable, columnIndex); }
                 */
                dataTable.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(SwingConstants.RIGHT));
                //remove other panels
//                dRNormalizedController.getNormalizedChartPanel().setChart(null);
//                dRResultsController.getResultsChartPanel().setChart(null);
//                dRPanel.getGraphicsDRParentPanel().remove(dRInputController.getdRInputPanel());
//                dRPanel.getGraphicsDRParentPanel().remove(dRNormalizedController.getDRNormalizedPlotPanel());
//                dRPanel.getGraphicsDRParentPanel().remove(dRResultsController.getdRResultsPanel());
//                dRPanel.getGraphicsDRParentPanel().repaint();
//                dRPanel.getGraphicsDRParentPanel().add(dRInitialController.getDRInitialPlotPanel(), gridBagConstraints);
                //plot according to 'data to fit' - the plotting method add the panel to the view
                //plot
            }
        });

        dRPanel.getNormalizedPlotDRButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //in case user skips "initial" subview and goes straight to normalization
                if (isFirstFitting()) {
                    initFirstFitting();
                    setFirstFitting(false);
                }
                //switch shared table view
                updateModelInTable(dRNormalizedController.getTableModel());
                updateTableInfoMessage("Log-transformed concentrations with their normalized responses per replicate");
                /**
                 * for (int columnIndex = 0; columnIndex <
                 * dataTable.getColumnCount(); columnIndex++) {
                 * GuiUtils.packColumn(dataTable, columnIndex); }
                 */
                dataTable.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(SwingConstants.RIGHT));
                //remove other panels
                dRInitialController.getInitialChartPanel().setChart(null);
//                dRResultsController.getResultsChartPanel().setChart(null);
//                dRPanel.getGraphicsDRParentPanel().remove(dRInputController.getdRInputPanel());
//                dRPanel.getGraphicsDRParentPanel().remove(dRInitialController.getDRInitialPlotPanel());
//                dRPanel.getGraphicsDRParentPanel().remove(dRResultsController.getdRResultsPanel());
//                dRPanel.getGraphicsDRParentPanel().repaint();
//                dRPanel.getGraphicsDRParentPanel().add(dRNormalizedController.getDRNormalizedPlotPanel(), gridBagConstraints);
                //plot according to 'data to fit' - the plotting method add the panel to the view
                //plot
            }
        });

        dRPanel.getResultsDRButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //switch shared table view
                updateModelInTable(dRResultsController.getTableModel());
                updateTableInfoMessage("Statistical values from the curve fit of the initial and normalized data.");

                //remove other panels
                dRInitialController.getInitialChartPanel().setChart(null);
                dRNormalizedController.getNormalizedChartPanel().setChart(null);
//                dRPanel.getGraphicsDRParentPanel().remove(dRInputController.getdRInputPanel());
//                dRPanel.getGraphicsDRParentPanel().remove(dRInitialController.getDRInitialPlotPanel());
//                dRPanel.getGraphicsDRParentPanel().remove(dRNormalizedController.getDRNormalizedPlotPanel());
//                dRPanel.getGraphicsDRParentPanel().repaint();
//                dRPanel.getGraphicsDRParentPanel().add(dRResultsController.getdRResultsPanel(), gridBagConstraints);
                // re-plot both initial and normalized plots
            }
        });

        //add view to parent panel
        areaMainController.getAreaAnalysisPanel().getDoseResponseParentPanel().add(dRPanel, gridBagConstraints);
    }

    /**
     * When switching to a different subview, change the model for the main
     * table.
     */
    private void updateModelInTable(NonEditableTableModel tableModel) {
        dataTable.setModel(tableModel);
    }

}

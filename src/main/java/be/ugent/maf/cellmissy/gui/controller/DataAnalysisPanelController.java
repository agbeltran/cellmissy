/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.controller;

import be.ugent.maf.cellmissy.entity.Algorithm;
import be.ugent.maf.cellmissy.entity.Experiment;
import be.ugent.maf.cellmissy.entity.ExperimentStatus;
import be.ugent.maf.cellmissy.entity.ImagingType;
import be.ugent.maf.cellmissy.entity.PlateCondition;
import be.ugent.maf.cellmissy.entity.Project;
import be.ugent.maf.cellmissy.entity.TimeStep;
import be.ugent.maf.cellmissy.entity.Well;
import be.ugent.maf.cellmissy.entity.WellHasImagingType;
import be.ugent.maf.cellmissy.gui.GuiUtils;
import be.ugent.maf.cellmissy.gui.experiment.DataAnalysisPanel;
import be.ugent.maf.cellmissy.service.ExperimentService;
import be.ugent.maf.cellmissy.service.ProjectService;
import be.ugent.maf.cellmissy.service.WellService;
import be.ugent.maf.cellmissy.spring.ApplicationContextProvider;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JList;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Paola Masuzzo
 */
public class DataAnalysisPanelController {

    //model
    private Experiment experiment;
    private ObservableList<Algorithm> algorithmBindingList;
    private ObservableList<ImagingType> imagingTypeBindingList;
    private ObservableList<Project> projectBindingList;
    private ObservableList<Experiment> experimentBindingList;
    private List<PlateCondition> plateConditionList;
    private BindingGroup bindingGroup;
    //view
    private DataAnalysisPanel dataAnalysisPanel;
    //parent controller
    private CellMissyController cellMissyController;
    //child controllers
    private BulkCellAnalysisPanelController bulkCellAnalysisPanelController;
    //services
    private ExperimentService experimentService;
    private ProjectService projectService;
    private WellService wellService;
    private ApplicationContext context;

    /**
     * constructor
     * @param cellMissyController 
     */
    public DataAnalysisPanelController(CellMissyController cellMissyController) {
        this.cellMissyController = cellMissyController;

        //init view
        dataAnalysisPanel = new DataAnalysisPanel();
        //init child controllers
        bulkCellAnalysisPanelController = new BulkCellAnalysisPanelController(this);
        //init services
        context = ApplicationContextProvider.getInstance().getApplicationContext();
        experimentService = (ExperimentService) context.getBean("experimentService");
        projectService = (ProjectService) context.getBean("projectService");
        wellService = (WellService) context.getBean("wellService");

        bindingGroup = new BindingGroup();

        initExperimentDataPanel();
    }

    /**
     * getters and setters
     * @return 
     */
    public DataAnalysisPanel getDataAnalysisPanel() {
        return dataAnalysisPanel;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    /**
     * private methods and classes
     */
    private void initExperimentDataPanel() {

        //init projectJList
        projectBindingList = ObservableCollections.observableList(projectService.findAll());
        JListBinding jListBinding = SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE, projectBindingList, dataAnalysisPanel.getProjectJList());
        bindingGroup.addBinding(jListBinding);

        //init algorithms combobox
        algorithmBindingList = ObservableCollections.observableList(new ArrayList<Algorithm>());
        JComboBoxBinding jComboBoxBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE, algorithmBindingList, dataAnalysisPanel.getAlgorithmComboBox());
        bindingGroup.addBinding(jComboBoxBinding);

        //init imagingtypes combo box
        imagingTypeBindingList = ObservableCollections.observableList(new ArrayList<ImagingType>());
        jComboBoxBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE, imagingTypeBindingList, dataAnalysisPanel.getImagingTypeComboBox());
        bindingGroup.addBinding(jComboBoxBinding);
        //do the binding
        bindingGroup.bind();

        /**
         * add mouse listeners
         */
        //when a project from the list is selected, show all experiments performed for that project        
        dataAnalysisPanel.getProjectJList().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                //init experimentJList
                int locationToIndex = dataAnalysisPanel.getProjectJList().locationToIndex(e.getPoint());
                if (experimentService.findExperimentsByProjectIdAndStatus(projectBindingList.get(locationToIndex).getProjectid(), ExperimentStatus.PERFORMED) != null) {
                    experimentBindingList = ObservableCollections.observableList(experimentService.findExperimentsByProjectIdAndStatus(projectBindingList.get(locationToIndex).getProjectid(), ExperimentStatus.PERFORMED));
                    JListBinding jListBinding = SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE, experimentBindingList, dataAnalysisPanel.getExperimentJList());
                    bindingGroup.addBinding(jListBinding);
                    bindingGroup.bind();
                } else {
                    cellMissyController.showMessage("There are no experiments performed yet for this project!", 1);
                    if (experimentBindingList != null && !experimentBindingList.isEmpty()) {
                        experimentBindingList.clear();
                    }
                }
            }
        });

        //when an experiment is selected, show algorithms used for that experiment
        dataAnalysisPanel.getExperimentJList().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int locationToIndex = dataAnalysisPanel.getExperimentJList().locationToIndex(e.getPoint());
                experiment = experimentBindingList.get(locationToIndex);
                plateConditionList = new ArrayList<>();
                plateConditionList.addAll(experiment.getPlateConditionCollection());

                for (PlateCondition plateCondition : plateConditionList) {
                    for (Well well : plateCondition.getWellCollection()) {
                        //show algorithms used for experiment
                        for (Algorithm algorithm : wellService.findAlgosByWellId(well.getWellid())) {
                            if (!algorithmBindingList.contains(algorithm)) {
                                algorithmBindingList.add(algorithm);
                            }
                        }
                        //show imaging types used for experiment
                        for (ImagingType imagingType : wellService.findImagingTypesByWellId(well.getWellid())) {
                            if (!imagingTypeBindingList.contains(imagingType)) {
                                imagingTypeBindingList.add(imagingType);
                            }
                        }
                    }
                }
                //set selected algorithm to the first of the list
                dataAnalysisPanel.getAlgorithmComboBox().setSelectedIndex(0);
                //set selected imaging types to the first of the list
                dataAnalysisPanel.getImagingTypeComboBox().setSelectedIndex(0);
                //show conditions for selected experiment
                showConditions();
                //show conditions in the plate panel
                bulkCellAnalysisPanelController.getAnalysisPlatePanel().setExperiment(experiment);
                bulkCellAnalysisPanelController.getAnalysisPlatePanel().repaint();
            }
        });

        dataAnalysisPanel.getConditionsList().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int locationToIndex = dataAnalysisPanel.getConditionsList().locationToIndex(e.getPoint());
                for (Well well : plateConditionList.get(locationToIndex).getWellCollection()) {
                    //fetch time step collection for the wellhasimagingtype of interest
                    wellService.fetchTimeSteps(well, algorithmBindingList.get(dataAnalysisPanel.getAlgorithmComboBox().getSelectedIndex()).getAlgorithmid(), imagingTypeBindingList.get(dataAnalysisPanel.getImagingTypeComboBox().getSelectedIndex()).getImagingTypeid());
                }
                updateTimeStepList(plateConditionList.get(locationToIndex));
                bulkCellAnalysisPanelController.showTimeSteps();
            }
        });

    }

    /**
     * update conditions list for current experiment 
     */
    private void showConditions() {

        //set cell renderer for the List
        dataAnalysisPanel.getConditionsList().setCellRenderer(new ConditionsRenderer());
        ObservableList<PlateCondition> plateConditionBindingList = ObservableCollections.observableList(plateConditionList);
        JListBinding jListBinding = SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE, plateConditionBindingList, dataAnalysisPanel.getConditionsList());
        bindingGroup.addBinding(jListBinding);
        bindingGroup.bind();
    }

    /**
     * once a plateCondition is selected get all time steps for that condition 
     * @param well (of the condition)
     */
    private void updateTimeStepList(PlateCondition plateCondition) {
        if (!bulkCellAnalysisPanelController.getTimeStepBindingList().isEmpty()) {
            bulkCellAnalysisPanelController.getTimeStepBindingList().clear();
        }
        for (Well well : plateCondition.getWellCollection()) {
            for (WellHasImagingType wellHasImagingType : well.getWellHasImagingTypeCollection()) {
                Collection<TimeStep> timeStepCollection = wellHasImagingType.getTimeStepCollection();
                for (TimeStep timeStep : timeStepCollection) {
                    bulkCellAnalysisPanelController.getTimeStepBindingList().add(timeStep);
                }
            }
        }
    }

    /**
     * renderer for the Conditions JList
     */
    private class ConditionsRenderer extends DefaultListCellRenderer {

        /*
         *constructor
         */
        public ConditionsRenderer() {

            setOpaque(true);
            setIconTextGap(10);
        }

        //Overrides method from the DefaultListCellRenderer
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            int conditionIndex = plateConditionList.indexOf((PlateCondition) value);
            setIcon(new rectIcon(GuiUtils.getAvailableColors()[conditionIndex + 1]));
            return this;
        }
    }

    /**
     * rectangular icon for the Condition list
     */
    private class rectIcon implements Icon {

        private final Integer rectHeight = 10;
        private final Integer rectWidth = 25;
        private Color color;

        /**
         * constructor
         * @param color 
         */
        public rectIcon(Color color) {
            this.color = color;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2d = (Graphics2D) g;
            //loadDataPlatePanelController.getLoadDataPlatePanel().setGraphics(g2d);
            g2d.setColor(color);
            g2d.fillRect(x, y, rectWidth, rectHeight);
        }

        @Override
        public int getIconWidth() {
            return rectWidth;
        }

        @Override
        public int getIconHeight() {
            return rectHeight;
        }
    }
}

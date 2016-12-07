/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.analysis;

import be.ugent.maf.cellmissy.utils.AnalysisUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Paola Masuzzo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mySpringXMLConfig.xml")
public class AnalysisUtilsTest {

    @Test
    public void testMedianForOddDatasets() {
        double[] data = {4, 5, 7, 2, 1};
        double median = AnalysisUtils.computeMedian(data);
        assertEquals(4.0, median);
    }

    @Test
    public void testMedianForEvenDatasets() {
        double[] data = {4, 5, 7, 2, 1, 8};
        double median = AnalysisUtils.computeMedian(data);
        assertEquals(4.5, median);
    }

    @Test
    public void testStandardDeviation() {
        double[] data = {13, 23, 12, 44, 55};
        double standardDeviation = AnalysisUtils.computeStandardDeviation(data);
        Double rounded = AnalysisUtils.roundThreeDecimals(standardDeviation);
        assertEquals(17.212, rounded);
    }

    @Test
    public void testQuantilesEstimation() {
        double[] data = {13, 23, 12, 44, 55};
        double lowerQuartile = AnalysisUtils.estimateQuantile(data, 25);
        assertEquals(13.0, lowerQuartile);
        double upperQuartile = AnalysisUtils.estimateQuantile(data, 75);
        assertEquals(44.0, upperQuartile);
    }

    @Test
    public void testGetMaxOfAList() {
        List<Double[]> data = new ArrayList<>();
        data.add(new Double[]{15.0, 12.54});
        data.add(new Double[]{80.0, 1.23});
        data.add(new Double[]{66.0, 80.15});
        Double max = AnalysisUtils.getMaxOfAList(data);
        assertEquals(80.15, max);
    }

    @Test
    public void testLogTransform() {
        Double logConc = AnalysisUtils.logTransform(1.0, "µM");
        assertEquals(-6.0, logConc);
        logConc = AnalysisUtils.logTransform(1.0, "mM");
        assertEquals(-3.0, logConc);
        logConc = AnalysisUtils.logTransform(10.0, "nM");
        assertEquals(-8.0, logConc);
    }
    
    @Test
    public void testGetDiagonalCovariances() {
        double[][] matrix = new double[4][4];
        for (int i = 0; i < matrix.length; i++) {
            double[] column = new double[]{1,2,3,4};
            matrix[i] = column;
        }
        double[] covariances = AnalysisUtils.getDiagonalCovariances(matrix);
        assertEquals(1.0, covariances[0]);
        assertEquals(2.0, covariances[1]);
        assertEquals(3.0, covariances[2]);
        assertEquals(4.0, covariances[3]);
    }
}

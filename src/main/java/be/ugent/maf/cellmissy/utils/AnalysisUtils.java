/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.utils;

import be.ugent.maf.cellmissy.entity.PlateCondition;
import be.ugent.maf.cellmissy.entity.Track;
import be.ugent.maf.cellmissy.entity.Well;
import be.ugent.maf.cellmissy.entity.WellHasImagingType;
import be.ugent.maf.cellmissy.entity.result.area.doseresponse.SigmoidFittingResultsHolder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.correlation.Covariance;

/**
 * Utility class for Analysis -- basic math and statistics methods
 *
 * @author Paola Masuzzo
 */
public class AnalysisUtils {

    /**
     * Exclude null values from an array of Double
     *
     * @param data
     * @return another Double array with no longer null values
     */
    public static Double[] excludeNullValues(Double[] data) {
        List<Double> list = new ArrayList<>();
        for (Double value : data) {
            if (value != null) {
                list.add(value);
            }
        }
        return list.toArray(new Double[list.size()]);
    }

    /**
     * Exclude NaN values from an array of Double
     *
     * @param data
     * @return another Double array with no longer NaN values
     */
    public static Double[] excludeNaNvalues(Double[] data) {
        List<Double> list = new ArrayList<>();
        for (Double value : data) {
            if (value != Double.NaN) {
                list.add(value);
            }
        }
        return list.toArray(new Double[list.size()]);
    }

    /**
     * Transpose a 2D array of Double
     *
     * @param data
     * @return the same 2D array but transposed
     */
    public static Double[][] transpose2DArray(Double[][] data) {
        Double[][] transposed = new Double[data[0].length][data.length];
        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < data[0].length; columnIndex++) {
                if (data[rowIndex][columnIndex] != null) {
                    transposed[columnIndex][rowIndex] = data[rowIndex][columnIndex];
                }
            }
        }
        return transposed;
    }

    /**
     * Transpose a 2D array of double
     *
     * @param data
     * @return the same 2D array but transposed
     */
    public static double[][] transpose2DArray(double[][] data) {
        double[][] transposed = new double[data[0].length][data.length];
        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < data[0].length; columnIndex++) {
                if (data[rowIndex][columnIndex] != 0.0) {
                    transposed[columnIndex][rowIndex] = data[rowIndex][columnIndex];
                }
            }
        }
        return transposed;
    }

    /**
     * Transpose a 2D array of boolean
     *
     * @param matrix
     * @return
     */
    public static boolean[][] transposeBooleanMatrix(boolean[][] matrix) {
        boolean[][] transposed = new boolean[matrix.length][matrix[0].length];
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) {
                if (matrix[rowIndex][columnIndex]) {
                    transposed[columnIndex][rowIndex] = true;
                }
            }
        }
        return transposed;
    }

    /**
     * Formatting a symmetric matrix: make the matrix diagonal, so that
     * symmetric (identical) values are not shown anymore, i.e. they are set to
     * null. With a customized renderer, these null values can be shown as a
     * dash (-), as we do for example in the p values matrix.
     *
     * @param matrix
     * @return
     */
    public static Double[][] formatSymmetricMatrix(Double[][] matrix) {

        Double[][] formattedMatrix = new Double[matrix.length][matrix[0].length];
        // copy content to new matrix
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            System.arraycopy(matrix[rowIndex], 0, formattedMatrix[rowIndex], 0, matrix[0].length);
        }
        // iterate through the raows and columns
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) {
                // get current value in the matrix
                Double value = formattedMatrix[rowIndex][columnIndex];
                // get the summetric value in the matrix
                Double symmValue = formattedMatrix[columnIndex][rowIndex];
                if (value != null && symmValue != null) {
                    if (value.equals(symmValue)) {
                        formattedMatrix[rowIndex][columnIndex] = null;
                    }
                }
            }
        }
        return formattedMatrix;
    }

    /**
     * Round up to three decimals
     *
     * @param d
     * @return
     */
    public static Double roundThreeDecimals(Double d) {
        DecimalFormat threeForm = new DecimalFormat("###.###");
        return Double.valueOf(threeForm.format(d));
    }

    /**
     * Round up to two decimals
     *
     * @param d
     * @return
     */
    public static Double roundTwoDecimals(Double d) {
        DecimalFormat twoDForm = new DecimalFormat("###.##");
        return Double.valueOf(twoDForm.format(d));
    }

    /**
     * Compute mean value of an array of double
     *
     * @param data
     * @return mean
     */
    public static double computeMean(double[] data) {
        // sum of all the elements
        double sum = 0;
        for (double aData : data) {
            sum += aData;
        }
        return sum / data.length;
    }

    /**
     * Compute median value of an array of double
     *
     * @param data
     * @return median
     */
    public static double computeMedian(double[] data) {
        // sort the input data, i.e. arrange the data points in ascending order
        Arrays.sort(data);
        //make a distinction between odd and even dataset sizes
        // odd size: return the data point in the middle position
        if (data.length % 2 == 1) {
            return data[(data.length + 1) / 2 - 1];
        } else {
            // even size
            double lower = data[(data.length / 2 - 1)];
            double upper = data[(data.length / 2)];
            return (lower + upper) / 2;
        }
    }

    /**
     * Compute Standard Deviation of an array of double
     *
     * @param data
     * @return sd
     */
    public static double computeStandardDeviation(double[] data) {
        double sum = 0;
        double mean = computeMean(data);
        for (double aData : data) {
            double diff = aData - mean;
            sum += diff * diff;
        }
        return Math.sqrt(sum / data.length);
    }

    /**
     * Compute Standard Error of the Mean (SEM) of a given array of double
     *
     * @param data
     * @return SEM
     */
    public static double computeSEM(double[] data) {
        return (computeStandardDeviation(data) / Math.sqrt(data.length));
    }

    /**
     * Compute Median Absolute Deviation (MAD) of an array of double
     *
     * @param data
     * @return MAD
     */
    private static double computeMAD(double[] data) {
        double[] deviations = new double[data.length];
        double median = computeMedian(data);
        for (int i = 0; i < data.length; i++) {
            deviations[i] = Math.abs(data[i] - median);
        }
        return computeMedian(deviations);
    }

    /**
     * Scale MAD in order to use it as a consistent estimator for the estimation
     * of the standard deviation
     *
     * @param data
     * @return sd (related to MAD)
     */
    public static double scaleMAD(double[] data) {
        //scale factor for asymptotically normal consistency
        final double constant = 1.4826;
        return constant * computeMAD(data);
    }

    /**
     * This method is using the Descriptive Statistics Class from
     * org.apache.commons.math to estimate sample quantiles Cfr algorithm type 6
     * in R, EXCEL, Minitab and SPSS. Continuous sample quantiles
     *
     * @param data
     * @param p
     * @return
     */
    public static double computeQuantile(double[] data, double p) {
        DescriptiveStatistics dataStatistics = new DescriptiveStatistics();
        for (double aData : data) {
            dataStatistics.addValue(aData);
        }
        // get an estimate for the pth percentile of the data
        return dataStatistics.getPercentile(p);
    }

    /**
     * This method is estimating quantiles making use of algorithm type 7 in R.
     * This is used by S as well. This implementation is more sensitive,
     * especially with small datasets (less than 15 data points)
     *
     * @param data -- array of double (distribution of data points)
     * @param p -- percentile
     * @return a double
     */
    public static double estimateQuantile(double[] data, double p) {
        double estimation = 0;
        //get order statistics
        Arrays.sort(data);
        int dataSize = data.length;
        // criterium to estimate the quantile: 1+p(N-1)
        double criterium = 1 + (p / 100) * (dataSize - 1);
        // get the int part of this criterium
        int k = (int) criterium;
        // get the double part of this criterium
        double d = criterium - k;
        // check for the range in which k falls
        if (k > 0 && k < dataSize) {
            estimation = data[k - 1] + d * (data[k] - data[k - 1]);
        } else if (k == 0) {
            estimation = data[0];
        } else if (k == dataSize) {
            estimation = data[dataSize - 1];
        }
        return estimation;
    }

    /**
     * Get the maximum double of a list of array of doubles
     *
     * @param list
     * @return maximum double
     */
    public static double getMaxOfAList(List<Double[]> list) {
        double max = 0;
        for (Double[] doubles : list) {
            Arrays.sort(doubles);
            double tempMax = doubles[doubles.length - 1];
            if (tempMax > max) {
                max = tempMax;
            }
        }
        return max;
    }

    /**
     * Compute maximum number of Replicates overall the experiment
     *
     * @param plateConditions
     * @return
     */
    public static int getMaximumNumberOfReplicates(List<PlateCondition> plateConditions) {
        int max = 0;
        for (PlateCondition plateCondition : plateConditions) {
            int numberOfSamplesPerCondition = getNumberOfAreaAnalyzedSamples(plateCondition);
            if (numberOfSamplesPerCondition > max) {
                max = numberOfSamplesPerCondition;
            }
        }
        return max;
    }

    /**
     * Get number of samples that produced area results values.
     *
     * @param plateCondition
     * @return
     */
    public static int getNumberOfAreaAnalyzedSamples(PlateCondition plateCondition) {
        int areaAnalyzedSamples = 0;
        List<Well> areaAnalyzedWells = plateCondition.getAreaAnalyzedWells();
        for (Well well : areaAnalyzedWells) {
            areaAnalyzedSamples += getNumberOfAreaAnalyzedSamplesPerWell(well);
        }
        return areaAnalyzedSamples;
    }

    /**
     * Get number of samples that produced single cell analysis results.
     *
     * @param plateCondition
     * @return
     */
    public static int getNumberOfSingleCellAnalyzedSamples(PlateCondition plateCondition) {
        int singleCellAnalyzedSamples = 0;
        List<Well> singleCellAnalyzedWells = plateCondition.getSingleCellAnalyzedWells();
        for (Well well : singleCellAnalyzedWells) {
            singleCellAnalyzedSamples += getNumberOfSingleCellAnalyzedSamplesPerWell(well);
        }
        return singleCellAnalyzedSamples;
    }

    /**
     * Get number of sample points per each well
     *
     * @param well
     * @return
     */
    public static int getNumberOfAreaAnalyzedSamplesPerWell(Well well) {
        int numberOfSamplesPerWell = 0;
        for (WellHasImagingType wellHasImagingType : well.getWellHasImagingTypeList()) {
            if (!wellHasImagingType.getTimeStepList().isEmpty()) {
                numberOfSamplesPerWell++;
            }
        }
        return numberOfSamplesPerWell;
    }

    /**
     *
     * @param well
     * @return
     */
    private static int getNumberOfSingleCellAnalyzedSamplesPerWell(Well well) {
        int numberOfSamplesPerWell = 0;
        for (WellHasImagingType wellHasImagingType : well.getWellHasImagingTypeList()) {
            if (!wellHasImagingType.getTrackList().isEmpty()) {
                numberOfSamplesPerWell++;
            }
        }
        return numberOfSamplesPerWell;
    }

    /**
     *
     * @param well
     * @return
     */
    public static List<Integer> getNumbersOfTrackPoints(Well well) {
        List<Integer> list = new ArrayList<>();
        for (WellHasImagingType wellHasImagingType : well.getWellHasImagingTypeList()) {
            List<Track> trackList = wellHasImagingType.getTrackList();
            int number = 0;
            if (!trackList.isEmpty()) {
                for (Track track : trackList) {
                    number += track.getTrackPointList().size();
                }
                list.add(number);
            }
        }
        return list;
    }

    /**
     *
     * @param well
     * @return
     */
    public static List<Integer> getNumbersOfTracks(Well well) {
        List<Integer> list = new ArrayList<>();
        for (WellHasImagingType wellHasImagingType : well.getWellHasImagingTypeList()) {
            List<Track> trackList = wellHasImagingType.getTrackList();
            if (!trackList.isEmpty()) {
                list.add(trackList.size());
            }
        }
        return list;
    }

    /**
     * Generate an array of x values from a HashMap.
     *
     * @param data The HashMap that maps one x value to replicate y values.
     * @return An array of x values duplicated to the according amount of
     * replicates in the original map.
     */
    public static double[] generateXValues(LinkedHashMap<Double, List<Double>> data) {
        List<Double> xValues = new ArrayList<>();
        for (Map.Entry<Double, List<Double>> entry : data.entrySet()) {
            for (Double value : entry.getValue()) {
                if (value != null) {
                    xValues.add(entry.getKey());
                }

            }
        }
        return ArrayUtils.toPrimitive(xValues.toArray(new Double[xValues.size()]));
    }

    /**
     * Generate an array of y values from a Hashmap.
     *
     * @param data The HashMap that maps one x value to replicate y values.
     * @return An array of all y values in the original map
     */
    public static double[] generateYValues(LinkedHashMap<Double, List<Double>> data) {
        List<Double> yValues = new ArrayList<>();
        for (Map.Entry<Double, List<Double>> entry : data.entrySet()) {
            for (Double yValue : entry.getValue()) {
                if (yValue != null) {
                    yValues.add(yValue);
                }

            }
        }
        return ArrayUtils.toPrimitive(yValues.toArray(new Double[yValues.size()]));
    }

    /**
     * Log-transform a concentration according to its concentration unit.
     *
     * @param concentration Set by user in experimental setup screen
     * @param unit The concentration unit (µM, nM...)
     * @return The log-transformed value of the concentration (eg. 1 µm becomes
     * -6)
     */
    public static Double logTransform(Double concentration, String unit) {
        Double value = concentration;
        if (unit.equals("mM")) {
            value *= Math.pow(10, -3);
        } else if (unit.equals("µM")) {
            value *= Math.pow(10, -6);
        } else if (unit.equals("nM")) {
            value *= Math.pow(10, -9);
        }
        return Math.log10(value);
    }

    /**
     * Return a comparator for comparing Doubles. This method can be used to
     * find a max or min value in a list.
     *
     * @return
     */
    public static Comparator doublesComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Double.valueOf(o1).compareTo(Double.valueOf(o2));
            }
        };
    }

    /**
     * Compute the R² of a non-linear fitting.
     *
     * @param data Log transformed concentrations mapped to replicate velocities
     * (normalized or not)
     * @param resultsholder Contains the best-fit value parameters of the
     * initial or normalized fitting
     * @return
     */
    public static double computeRSquared(LinkedHashMap<Double, List<Double>> data, SigmoidFittingResultsHolder resultsholder) {
        double ssRes = 0.0;
        double ssTot = 0.0;
        double[] experimentalYS = generateYValues(data);
        double[] experimentalXS = generateXValues(data);
        double mean = computeMean(experimentalYS);

        for (int i = 0; i < experimentalYS.length; i++) {
            ssTot += (experimentalYS[i] - mean) * (experimentalYS[i] - mean);
            ssRes += (experimentalYS[i] - calculatePredictedValue(experimentalXS[i], resultsholder))
                    * (experimentalYS[i] - calculatePredictedValue(experimentalXS[i], resultsholder));
        }

        return 1 - (ssRes / ssTot);
    }

    /**
     * Calculate the Y value of a non-linear fit predicted by the best-fit
     * parameters.
     *
     * @param xValue
     * @param resultsholder
     * @return
     */
    private static double calculatePredictedValue(double xValue, SigmoidFittingResultsHolder resultsholder) {
        return (resultsholder.getBottom()
                + (resultsholder.getTop() - resultsholder.getBottom())
                / (1 + Math.pow(10, (resultsholder.getLogEC50() - xValue) * resultsholder.getHillslope())));
    }

    /**
     * Calculate a confidence interval given an estimated value, it's standard
     * error and the quantile which determines the confidence level. A possible
     * extra param is the quantile of the normal distribution. This is 1.96 for a
     * standard 95% confidence interval
     *
     * @param value
     * @param standardError
     *
     * @return The lower and upper boundaries of the confidence interval.
     */
    public static double[] calculateConfidenceIntervalBoundaries(double value, double standardError) {
        double[] result = new double[2];
        result[0] = value - (standardError * 1.96);
        result[1] = value + (standardError * 1.96);
        return result;
    }

    /**
     * Calculates the entire covariance matrix for a given data set.
     *
     * @param intermediateValues Contains estimates for the parameters. Columns
     * contain variable values.
     * @return
     */
    private static double[][] calculateCovarianceMatrix(double[][] intermediateValues) {
        Covariance covariance = (new Covariance(intermediateValues));
        return covariance.getCovarianceMatrix().getData();
    }

    /**
     * Acquire the diagonal covariances for a given data set. These can be used
     * for calculating standard errors.
     *
     * @param intermediateValues Contains estimates for the parameters. Columns
     * contain variable values.
     * @return Array containing the diagonal matrix values of the covariance
     * matrix.
     */
    public static double[] getDiagonalCovariances(double[][] intermediateValues) {
        double[][] covarianceMatrix = calculateCovarianceMatrix(intermediateValues);
        double[] result = new double[covarianceMatrix.length];
        for (int i = 0; i < covarianceMatrix.length; i++) {
            result[i] = covarianceMatrix[i][i];
        }
        return result;
    }

    /**
     * Calculates the standard errors of the estimated best-fit parameter values
     * of a dose-response estimation.
     *
     * @param data Log transformed concentrations mapped to replicate velocities
     * (normalized or not)
     * @param resultsholder Contains the best-fit value parameters of the
     * initial or normalized fitting
     * @param parameterDistributions Intermediate fitter values mapped to
     * parameter name
     * @return
     */
    public static double[] calculateStandardErrors(LinkedHashMap<Double, List<Double>> data, SigmoidFittingResultsHolder resultsholder) {
        //lenght of the result array is always 4, for the max amount of parameters possible to be estimated in a dose-response fit.
        double[] result = new double[4];
        List<String> constrainedParameters = new ArrayList<>();
        HashMap<String, List<Double>> parameterDistributions = resultsholder.getParameterDistributions();
        //calculate residual sum of squares
        double ssRes = 0.0;
        double[] experimentalYS = generateYValues(data);
        double[] experimentalXS = generateXValues(data);
        for (int i = 0; i < experimentalYS.length; i++) {
            ssRes += (experimentalYS[i] - calculatePredictedValue(experimentalXS[i], resultsholder))
                    * (experimentalYS[i] - calculatePredictedValue(experimentalXS[i], resultsholder));
        }
        //the degrees of freedom is the amount of data points minus the number of parameters fit
        int degreesFreedom = experimentalXS.length - parameterDistributions.size();

        //bottom and/or top parameter can be constrained: lenght of covariance array will change
        List<Double> bottomDistribution = parameterDistributions.get("bottom");
        if (bottomDistribution == null) {
            constrainedParameters.add("bottom");
        }
        List<Double> topDistribution = parameterDistributions.get("top");
        if (topDistribution == null) {
            constrainedParameters.add("top");
        }
        //get the diagonal values from the covariance matrix
        double[] covariances = getDiagonalCovariances(convertParameterDistributions(parameterDistributions, constrainedParameters));

        //second to last and last value of covariances array will always be of logEC50 and hillslope
        //size of distributions map is always equal to lenght of covariances array
        result[2] = Math.sqrt((ssRes / degreesFreedom) * covariances[parameterDistributions.size() - 2]);
        result[3] = Math.sqrt((ssRes / degreesFreedom) * covariances[parameterDistributions.size() - 1]);

        //if the parameter was constrained in the fitting, there is no distribution
        //the standard error will be set to 0, so that later it can be correctly displayed in the GUI
        if (bottomDistribution == null) {
            result[0] = 0;
            if (topDistribution == null) {
                result[1] = 0;
            } else {
                result[1] = Math.sqrt((ssRes / degreesFreedom) * covariances[0]);
            }
        } else {
            //calculate the standard error
            result[0] = Math.sqrt((ssRes / degreesFreedom) * covariances[0]);
            if (topDistribution == null) {
                result[1] = 0;
            } else {
                result[1] = Math.sqrt((ssRes / degreesFreedom) * covariances[1]);
            }
        }
        return result;
    }

    /**
     * Convert type so that correlation matrix can be constructed. The columns
     * of the result array contain the the variable values per parameter. The
     * amount of columns thus is equal to the number of parameters estimated.
     *
     * @param parameterDistributions
     * @return
     */
    private static double[][] convertParameterDistributions(HashMap<String, List<Double>> parameterDistributions, List<String> contrainedParameters) {
        double[][] result = new double[parameterDistributions.size()][];
        //Intermediate array to help convert from Double to double
        Double[] tempArray = new Double[parameterDistributions.get("logec50").size()];

        if (contrainedParameters.isEmpty()) {
            parameterDistributions.get("bottom").toArray(tempArray);
            result[0] = ArrayUtils.toPrimitive(tempArray.clone());
            parameterDistributions.get("top").toArray(tempArray);
            result[1] = ArrayUtils.toPrimitive(tempArray.clone());
        } else if (contrainedParameters.size() == 1) {
            if (contrainedParameters.contains("bottom")) {
                parameterDistributions.get("top").toArray(tempArray);
                result[0] = ArrayUtils.toPrimitive(tempArray.clone());
            } else {
                parameterDistributions.get("bottom").toArray(tempArray);
                result[0] = ArrayUtils.toPrimitive(tempArray.clone());
            }
        }
        parameterDistributions.get("logec50").toArray(tempArray);
        result[result.length - 2] = ArrayUtils.toPrimitive(tempArray.clone());
        parameterDistributions.get("hillslope").toArray(tempArray);
        result[result.length - 1] = ArrayUtils.toPrimitive(tempArray.clone());
        //currently the estimates per parameter are in the rows, while they should be in the columns
        return transpose2DArray(result);
    }
}

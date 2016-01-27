/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.analysis.singlecell.preprocessing.impl;

import be.ugent.maf.cellmissy.analysis.singlecell.preprocessing.TrackInterpolator;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.util.MathArrays;

/**
 *
 * This implementation for the track interpolator computes a natural (also known
 * as "free", "un-clamped") cubic spline interpolation for the data set. The x
 * values passed to the interpolator must be ordered in ascending order. It is
 * not valid to evaluate the function for values outside the range x0..xN --
 * will throw an OutOfRangeException.
 *
 * @author Paola
 */
public class TrackSplineInterpolator implements TrackInterpolator {

    @Override
    public List<double[]> interpolateTrack(double[] time, double[] x, double[] y, int interpolationPoints) {
        List<double[]> interpolatedData = new ArrayList<>();
        // create a new spline interpolator
        SplineInterpolator splineInterpolator = new SplineInterpolator();

        // create arrays to hold the interpolant time, the interpolated X and the interpolated Y
        double[] interpolantTime = new double[interpolationPoints];
        double[] interpolatedX = new double[interpolationPoints];
        double[] interpolatedY = new double[interpolationPoints];
        // the step used for the interpolation in both direction
        double interpolationStep = (double) (time[time.length - 1] - time[0]) / interpolationPoints;

        // check for monotonicity
        boolean monotonic = MathArrays.isMonotonic(time, MathArrays.OrderDirection.INCREASING, false);
        // in case time is not monotonic, sort in place time, x and y coodrinates
        if (!monotonic) {
            MathArrays.sortInPlace(time, x, y);
        }

        // call the interpolator, and actually do the interpolation
        PolynomialSplineFunction functionX = splineInterpolator.interpolate(time, x);
        PolynomialSplineFunction functionY = splineInterpolator.interpolate(time, y);

        for (int i = 0; i < interpolationPoints; i++) {
            interpolantTime[i] = time[0] + (i * interpolationStep);
            interpolatedX[i] = functionX.value(interpolantTime[i]);
            interpolatedY[i] = functionY.value(interpolantTime[i]);
        }
        interpolatedData.add(interpolantTime);
        interpolatedData.add(interpolatedX);
        interpolatedData.add(interpolatedY);
        return interpolatedData;
    }
}

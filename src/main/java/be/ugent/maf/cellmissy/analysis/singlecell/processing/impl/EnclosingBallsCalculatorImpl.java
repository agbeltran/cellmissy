/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.analysis.singlecell.processing.impl;

import be.ugent.maf.cellmissy.analysis.kdtree.KDTree;
import be.ugent.maf.cellmissy.analysis.kdtree.exception.KeySizeException;
import be.ugent.maf.cellmissy.analysis.singlecell.processing.EnclosingBallsCalculator;
import be.ugent.maf.cellmissy.entity.result.singlecell.EnclosingBall;
import be.ugent.maf.cellmissy.entity.result.singlecell.GeometricPoint;
import be.ugent.maf.cellmissy.entity.result.singlecell.StepCentricDataHolder;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 * An implementation for the "enclosing balls calculator" interface.
 *
 * @author Paola
 */
@Component("enclosingBallsCalculator")
public class EnclosingBallsCalculatorImpl implements EnclosingBallsCalculator {

    @Override
    public List<EnclosingBall> computeEnclosingBalls(StepCentricDataHolder stepCentricDataHolder, double radius) {

        List<EnclosingBall> enclosingBalls = new ArrayList<>();
        // the 2D tree of the step centric data holder
        KDTree<GeometricPoint> kdTree = stepCentricDataHolder.getkDTree();
        GeometricPoint m_0 = stepCentricDataHolder.getTrack().getTrackPointList().get(0).getGeometricPoint();

        Ellipse2D ball = new Ellipse2D.Double();
        ball.setFrameFromCenter(m_0.getX(), m_0.getY(), m_0.getX() + radius, m_0.getY() + radius);

        EnclosingBall enclosingBall = new EnclosingBall(ball, radius);
        enclosingBall.getPoints().add(m_0);
        enclosingBalls.add(enclosingBall); // first ball: always add it to the list

        // now start counting from 1
        for (int i = 1; i < stepCentricDataHolder.getTrack().getTrackPointList().size(); i++) {
            GeometricPoint m_i = stepCentricDataHolder.getTrack().getTrackPointList().get(i).getGeometricPoint();
            // try to get the points close to the current point:
            // i.e. points m_i such that ||m_i - m_t|| 2 <= radius 
            try {
                List<GeometricPoint> nearestPoints = kdTree.nearestEuclidean(new double[]{m_i.getX(), m_i.getY()}, radius);
                if (nearestPoints.size() == 1) {
                    GeometricPoint nearest = nearestPoints.get(0);
                    ball = new Ellipse2D.Double();
                    ball.setFrameFromCenter(nearest.getX(), nearest.getY(), nearest.getX() + radius, nearest.getY() + radius);
                    enclosingBall = new EnclosingBall(ball, radius);
                    enclosingBall.getPoints().add(nearest);
                    if (!enclosingBalls.contains(enclosingBall)) {
                        enclosingBalls.add(enclosingBall);
                    }
                } else {
                    for (GeometricPoint nearest : nearestPoints) {
                        if (!nearest.equals(m_i)) {
                            boolean ballsContainPoint = ballsContainPoint(enclosingBalls, nearest);
                            if (!ballsContainPoint) {
                                ball = new Ellipse2D.Double();
                                ball.setFrameFromCenter(nearest.getX(), nearest.getY(), nearest.getX() + radius, nearest.getY() + radius);
                                enclosingBall = new EnclosingBall(ball, radius);
                                if (!enclosingBalls.contains(enclosingBall)) {
                                    enclosingBalls.add(enclosingBall);
                                }
                            } else {
                                EnclosingBall whichBallContainsPoint = whichBallContainsPoint(enclosingBalls, nearest);
                                whichBallContainsPoint.getPoints().add(m_i);
                            }
                        }
                    }
                }
            } catch (KeySizeException ex) {
                Logger.getLogger(EnclosingBallsCalculatorImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return enclosingBalls;

    }

    /**
     * Check if the current list of balls contain a specific geometric point.
     *
     * @param enclosingBalls
     * @param point
     * @return
     */
    private boolean ballsContainPoint(List<EnclosingBall> enclosingBalls, GeometricPoint point) {
        return enclosingBalls.stream().map((enclosingBall) -> enclosingBall.getBall()).anyMatch((ball) -> (ball.contains(point.getX(), point.getY())));
    }

    private EnclosingBall whichBallContainsPoint(List<EnclosingBall> enclosingBalls, GeometricPoint point) {
        EnclosingBall found = null;
        for (Iterator<EnclosingBall> it = enclosingBalls.iterator(); it.hasNext();) {
            EnclosingBall ball = it.next();
            if (ball.getBall().contains(point.getX(), point.getY())) {
                found = ball;
            }
        }
        return found;
    }
}
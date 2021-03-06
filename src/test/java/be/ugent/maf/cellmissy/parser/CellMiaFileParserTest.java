/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.parser;

import be.ugent.maf.cellmissy.entity.TimeStep;
import be.ugent.maf.cellmissy.entity.Track;
import java.io.File;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

/**
 * A test unit for the CELLMIA file parser.
 *
 * @author Paola
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mySpringXMLConfig.xml")
public class CellMiaFileParserTest {

    @Autowired
    private CellMiaFileParser cellMiaFileParser;

    /**
     * Test CellMiaFileParserClass: get List of Tracks and TimeSteps parsing
     * cellMia files
     */
    @Test
    public void testCellMiaFileParser() {

        File trackingFile = new File(CellMiaFileParserTest.class.getClassLoader().getResource("tracking.txt").getPath());
        List<Track> trackList = cellMiaFileParser.parseTrackingFile(trackingFile);

        File bulkCellFile = new File(CellMiaFileParserTest.class.getClassLoader().getResource("bulkcell.txt").getPath());
        List<TimeStep> timeStepList = cellMiaFileParser.parseBulkCellFile(bulkCellFile);

        Assert.assertTrue(!trackList.isEmpty());
        Assert.assertTrue(trackList.size() == 91);
        Assert.assertTrue(!timeStepList.isEmpty());
        Assert.assertTrue(timeStepList.size() == 108);
    }
}

package be.ugent.maf.cellmissy.parser;

import be.ugent.maf.cellmissy.entity.ImagingType;
import be.ugent.maf.cellmissy.entity.WellHasImagingType;
import be.ugent.maf.cellmissy.exception.FileParserException;
import be.ugent.maf.cellmissy.exception.PositionListMismatchException;
import java.io.IOException;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author Paola
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mySpringXMLConfig.xml")
public class PositionListParserTest {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(PositionListParserTest.class);
    @Autowired
    private PositionListParser positionListParser;
    @Autowired
    private ObsepFileParser obsepFileParser;

    /**
     * Test PositionListParser Class: get a map between ImagingType and list of WellHasImagingType
     *
     * @throws IOException
     */
    @Test
    public void testPositionListParser() throws IOException {

        Resource obsepResource = new ClassPathResource("gffp.obsep");
        obsepFileParser.parseObsepFile(obsepResource.getFile());
        Map<ImagingType, String> imagingTypeToPosListMap = obsepFileParser.mapImagingTypetoPositionList();

        //folder in which position lists are located
        File setupFolder = new File(ObsepFileParserTest.class.getClassLoader().getResource("position_list_files").getPath());
        try {
            Map<ImagingType, List<WellHasImagingType>> imagingTypeMap = positionListParser.parsePositionList(imagingTypeToPosListMap, setupFolder);
            Assert.assertTrue(!imagingTypeMap.isEmpty());
            Collection<List<WellHasImagingType>> values = imagingTypeMap.values();

            values.stream().map((list) -> list.size()).forEach((size) -> {
                System.out.println("size of list: " + size);
            });
        } catch (FileParserException | PositionListMismatchException ex) {
            LOG.error(ex.getMessage());
        }

    }
}

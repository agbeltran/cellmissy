/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.repository;

import be.ugent.maf.cellmissy.entity.Project;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Paola Masuzzo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mySpringXMLConfig.xml", "classpath:myTestSpringXMLConfig.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ExperimentRepositoryTest {

    @Autowired
    ExperimentRepository experimentRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void testRepository() {
        List<Project> projects = projectRepository.findAll();
        Assert.assertTrue(!projects.isEmpty());
    }
}

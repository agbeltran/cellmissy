/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.repository.impl;

import be.ugent.maf.cellmissy.entity.Experiment;
import be.ugent.maf.cellmissy.entity.ExperimentStatus;
import be.ugent.maf.cellmissy.repository.ExperimentRepository;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paola
 */
@Repository("experimentRepository")
public class ExperimentJpaRepository extends GenericJpaRepository<Experiment, Long> implements ExperimentRepository {

    @Override
    public List<Integer> findExperimentNumbersByProjectId(Long projectId) {

        //annotated query
        Query byNameQuery = getEntityManager().createNamedQuery("Experiment.findExperimentNumbersByProjectId");
        byNameQuery.setParameter("projectid", projectId);
        List<Integer> resultList = byNameQuery.getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }

    @Override
    public List<Experiment> findExperimentsByProjectIdAndStatus(Long projectId, ExperimentStatus experimentStatus) {
        //annotated query
        Query byNameQuery = getEntityManager().createNamedQuery("Experiment.findExperimentsByProjectIdAndStatus");
        byNameQuery.setParameter("projectid", projectId);
        byNameQuery.setParameter("experimentStatus", experimentStatus);
        List<Experiment> resultList = byNameQuery.getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }

    @Override
    public List<Experiment> findExperimentsByProjectId(Long projectId) {
        //annotated query
        Query byNameQuery = getEntityManager().createNamedQuery("Experiment.findExperimentsByProjectId");
        byNameQuery.setParameter("projectid", projectId);
        List<Experiment> resultList = byNameQuery.getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        } else {
            return null;
        }
    }
}

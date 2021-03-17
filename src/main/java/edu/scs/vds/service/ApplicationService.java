package edu.scs.vds.service;

import edu.scs.vds.model.Application;
import edu.scs.vds.model.User;
import edu.scs.vds.repository.ApplicationDatatableRepository;
import edu.scs.vds.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ApplicationService {

    @Autowired
    private ApplicationRepository repo;

    @Autowired
    ApplicationDatatableRepository applicationDatatableRepository;

    public List<Application> listAll() {
        return repo.findAll();
    }

    public void save(Application application) {
        repo.save(application);
    }

    public Application get(Integer id) {
        return repo.findById(id).get();
    }

    public Application getByUser(User user) {
        return repo.findByUser(user);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public DataTablesOutput<Application> listAllDatatable(DataTablesInput input, Integer stepNo){

        DataTablesOutput<Application> applicationDataTablesOutput = applicationDatatableRepository.findAll(input,(Specification<Application>) (root, cq, cb) -> {
            Predicate p = cb.conjunction();
            p = cb.equal(root.get("user").get("appointmentStep"),stepNo);
            return p;
        });
        return applicationDataTablesOutput;
    }


//    public DataTablesOutput<Application> listAcceptableApplications(DataTablesInput input){
//
//        DataTablesOutput<Application> applicationDataTablesOutput = applicationDatatableRepository.findAll(input,(Specification<Application>) (root, cq, cb) -> {
//            Predicate p = cb.conjunction();
////            p = cb.equal(root.get("user").get("appointmentStep"),6);
////            return p;
//
//            List<Integer> parentList = Arrays.asList(6,8);
//            CriteriaBuilder.In<String> in = cb.in(root.get("user"));
//            parentList.forEach(p -> in.value(p));
//
//            cq.where(root.get("User").get("appointmentStep").in(parentList)).ge;
//            return p;
//        });
//        return applicationDataTablesOutput;
//    }

}

package edu.scs.vds.service;

import edu.scs.vds.model.Application;
import edu.scs.vds.model.User;
import edu.scs.vds.repository.ApplicationDatatableRepository;
import edu.scs.vds.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public DataTablesOutput<Application> listAllDatatable(DataTablesInput input){
        return applicationDatatableRepository.findAll(input);
    }



}

package edu.scs.vds.service;

import edu.scs.vds.model.Application;
import edu.scs.vds.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApplicationService {

    @Autowired
    private ApplicationRepository repo;

    public List<Application> listAll() {
        return repo.findAll();
    }

    public void save(Application application) {
        repo.save(application);
    }

    public Application get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}

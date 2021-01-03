package edu.scs.vds.service;

import edu.scs.vds.model.Booth;
import edu.scs.vds.repository.BoothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BoothService {

    @Autowired
    private BoothRepository repo;

    public List<Booth> listAll() {
        return repo.findAll();
    }

    public void save(Booth booth) {
        repo.save(booth);
    }

    public Booth get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}

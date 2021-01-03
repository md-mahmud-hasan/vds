package edu.scs.vds.service;

import edu.scs.vds.model.Vaccine;
import edu.scs.vds.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VaccineService {

    @Autowired
    private VaccineRepository repo;

    public List<Vaccine> listAll() {
        return repo.findAll();
    }

    public void save(Vaccine vaccine) {
        repo.save(vaccine);
    }

    public Vaccine get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}

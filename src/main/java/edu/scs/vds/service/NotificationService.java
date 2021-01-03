package edu.scs.vds.service;

import edu.scs.vds.model.Notification;
import edu.scs.vds.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NotificationService {

    @Autowired
    private NotificationRepository repo;

    public List<Notification> listAll() {
        return repo.findAll();
    }

    public void save(Notification notification) {
        repo.save(notification);
    }

    public Notification get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}

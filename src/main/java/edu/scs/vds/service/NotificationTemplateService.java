package edu.scs.vds.service;

import edu.scs.vds.model.NotificationTemplate;
import edu.scs.vds.repository.NotificationTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NotificationTemplateService {

    @Autowired
    private NotificationTemplateRepository repo;

    public List<NotificationTemplate> listAll() {
        return repo.findAll();
    }

    public void save(NotificationTemplate notificationTemplate) {
        repo.save(notificationTemplate);
    }

    public NotificationTemplate get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}

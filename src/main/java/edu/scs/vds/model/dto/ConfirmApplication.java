package edu.scs.vds.model.dto;

import java.util.Date;
import java.util.List;

public class ConfirmApplication {
    List<Integer> applicationIds;
    Date date;

    public List<Integer> getApplicationIds() {
        return applicationIds;
    }

    public void setApplicationIds(List<Integer> applicationIds) {
        this.applicationIds = applicationIds;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

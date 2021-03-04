package edu.scs.vds.model.dto;

import java.util.Date;
import java.util.List;

public class ConfirmApplication {
    List<Integer> applicationIds;
    Date applicationDate;

    public List<Integer> getApplicationIds() {
        return applicationIds;
    }

    public void setApplicationIds(List<Integer> applicationIds) {
        this.applicationIds = applicationIds;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }
}

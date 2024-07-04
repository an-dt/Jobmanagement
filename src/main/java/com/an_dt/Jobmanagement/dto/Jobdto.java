package com.an_dt.Jobmanagement.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class Jobdto {
    private int idJob;

    private String jobstatus;

    private String triggerValue;

    private String statusEnum;

    private String triggerDesc;

    private Date startTime;

    private Date endTime;

    private Timestamp lastUpdate;

    private String errorMessage;


}

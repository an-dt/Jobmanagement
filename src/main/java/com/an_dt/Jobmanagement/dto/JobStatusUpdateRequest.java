package com.an_dt.Jobmanagement.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobStatusUpdateRequest {
    private String jobId;
    private String jobStatus;
    private String statusEnum;
}

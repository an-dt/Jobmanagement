package com.an_dt.Jobmanagement.Service.imp;

import com.an_dt.Jobmanagement.dto.Jobdto;
import com.an_dt.Jobmanagement.entity.Job;

import java.util.List;

public interface JobServiceimp {
    List<Jobdto> getAllJobs();
    void updateJobStatus(String jobId,String jobGroup , String jobStatus, String statusEnum);
    void stopJob(String jobId );
}

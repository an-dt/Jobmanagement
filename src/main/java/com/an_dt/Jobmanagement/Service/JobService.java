package com.an_dt.Jobmanagement.Service;

import com.an_dt.Jobmanagement.Repository.JobRepository;
import com.an_dt.Jobmanagement.Service.imp.JobServiceimp;
import com.an_dt.Jobmanagement.dto.Jobdto;
import com.an_dt.Jobmanagement.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobService implements JobServiceimp {
    @Autowired
    JobRepository jobRepository;
    @Override
    public List<Jobdto> getAllJobs() {
        List<Job> listjob = jobRepository.findAll();
            List<Jobdto> jobdtoList  = new ArrayList<>();
        for (Job job : listjob) {
            Jobdto jobdto = new Jobdto();
            jobdto.setIdJob(job.getId());
            jobdto.setJobstatus(job.getJobStatus());
            jobdto.setEndTime(job.getEndTime());
            jobdto.setStartTime(job.getStartTime());
            jobdto.setErrorMessage((job.getErrorMessage()));
            jobdto.setTriggerValue(job.getTriggerValue());
            jobdto.setStatusEnum(job.getStatusEnum());
            jobdto.setLastUpdate(job.getLastUpdate());
            jobdto.setTriggerDesc(job.getTriggerDesc());
            jobdtoList.add(jobdto);
            System.out.println(job.getJobStatus());
        }
        return jobdtoList;
    }
    public void updateJobStatus(String jobId, String jobStatus, String statusEnum) {
        Job job = jobRepository.findByJobId(jobId);
        if (job != null) {
            job.setJobStatus(jobStatus);
            job.setStatusEnum(statusEnum);
            LocalDateTime now = LocalDateTime.now();
            job.setLastUpdate(Timestamp.valueOf(now));
            jobRepository.save(job);
        }
    }

}

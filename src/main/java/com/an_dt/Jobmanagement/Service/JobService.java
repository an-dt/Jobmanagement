package com.an_dt.Jobmanagement.Service;

import com.an_dt.Jobmanagement.Repository.JobGroupRepository;
import com.an_dt.Jobmanagement.Repository.JobRepository;
import com.an_dt.Jobmanagement.Service.imp.JobServiceimp;
import com.an_dt.Jobmanagement.dto.Jobdto;
import com.an_dt.Jobmanagement.entity.Job;
import com.an_dt.Jobmanagement.entity.JobGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobService implements JobServiceimp {
    final Logger logger = LoggerFactory.getLogger(JobService.class);
    @Autowired
    JobRepository jobRepository;
    @Autowired
    JobGroupRepository jobGroupRepository;
    @Override
    public List<Jobdto> getAllJobs() {
        List<Job> listjob = jobRepository.findAll();
        List<Jobdto> jobdtoList = new ArrayList<>();
        for (Job job : listjob) {
            Jobdto jobdto = new Jobdto();
            jobdto.setIdJob(job.getId());
            jobdto.setJobstatus(job.getJobStatus());
            jobdto.setEndTime(job.getEndTime());
            jobdto.setStartTime(job.getStartTime());
            jobdto.setErrorMessage(job.getErrorMessage());
            jobdto.setTriggerValue(job.getTriggerValue());
            jobdto.setStatusEnum(job.getStatusEnum());
            jobdto.setLastUpdate(job.getLastUpdate());
            jobdto.setTriggerDesc(job.getTriggerDesc());
            jobdto.setJobId(job.getJobId());
            jobdto.setJobGroup(job.getJobGroup() != null ? job.getJobGroup().getName() : "N/A");  // Thêm giá trị jobGroup
            jobdtoList.add(jobdto);
            System.out.println(job.getJobStatus());
        }
        return jobdtoList;
    }
    public void updateJobStatus(String jobId, String jobGroup , String jobStatus, String statusEnum) {
        Job job = jobRepository.findByJobId(jobId);
        if (job != null) {
            JobGroup foundJobGroup = jobGroupRepository.findByName(jobGroup);
            job.setJobGroup(foundJobGroup);
            job.setJobStatus(jobStatus);
            job.setStatusEnum(statusEnum);
            LocalDateTime now = LocalDateTime.now();
            job.setLastUpdate(Timestamp.valueOf(now));
            jobRepository.save(job);
        }
    }

    @Override
    public void stopJob(String jobId ) {
        try {
            Job job = jobRepository.findByJobId(jobId);
            if (job != null) {
            job.setJobStatus("Stopping");
            job.setStatusEnum("Job Stop");
            job.setLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
            jobRepository.save(job);
            } else {
                logger.warn("Job not found with jobId: {}", jobId);
            }
        } catch (Exception e) {
            logger.error("Error stopping job: {}", e.getMessage());
        }
    }

}

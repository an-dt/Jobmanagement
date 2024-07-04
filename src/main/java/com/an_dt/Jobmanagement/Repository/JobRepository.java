package com.an_dt.Jobmanagement.Repository;

import com.an_dt.Jobmanagement.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    Job findByJobId(String jobId);

}

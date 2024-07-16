package com.an_dt.Jobmanagement.Repository;

import com.an_dt.Jobmanagement.entity.JobGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobGroupRepository extends JpaRepository<JobGroup, Integer> {
    JobGroup findByName(String name);
}

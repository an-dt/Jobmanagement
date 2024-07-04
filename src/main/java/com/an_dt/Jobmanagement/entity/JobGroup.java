package com.an_dt.Jobmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity(name = "job_group")
@Getter
@Setter
public class JobGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGroup;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "jobGroup") // Change to "jobGroup"
    private List<Job> jobs;

}

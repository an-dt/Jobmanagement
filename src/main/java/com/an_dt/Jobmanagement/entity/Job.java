package com.an_dt.Jobmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;
@Entity(name = "job")
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Thay đổi tên biến thành id

    @Column(name = "jobId")
    private String jobId;

    @Column(name = "jobstatus") // Ánh xạ tên cột với annotation @Column
    private String jobStatus;

    @Column(name = "triggervalue")
    private String triggerValue;

    @Column(name = "status_enum")
    private String statusEnum;

    @Column(name = "trigger_desc")
    private String triggerDesc;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Column(name = "error_message")
    private String errorMessage;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private JobGroup jobGroup;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @OneToMany(mappedBy = "job")
    private Set<Follow> listFollow;


}

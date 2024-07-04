package com.an_dt.Jobmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "follow")
@Getter
@Setter
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFollow;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "id_job")
    private Job job;


}

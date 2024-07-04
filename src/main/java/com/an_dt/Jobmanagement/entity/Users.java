package com.an_dt.Jobmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<Follow> listFollow;

    @OneToMany(mappedBy = "users")
    private Set<Job> listJob;


}

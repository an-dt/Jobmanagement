package com.an_dt.Jobmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(mappedBy = "roles")
    private Set<Users> listUsers;


}

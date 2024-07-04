package com.an_dt.Jobmanagement;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@SpringBootApplication
public class JobmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobmanagementApplication.class, args);
	}

}

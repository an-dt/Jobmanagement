package com.an_dt.Jobmanagement.Controller;

import com.an_dt.Jobmanagement.Service.imp.JobServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class ManagerController {
    @Autowired
    JobServiceimp jobServiceimp;

    @GetMapping("")
    public ResponseEntity<?> getAllJobs(){
        return new ResponseEntity<>(jobServiceimp.getAllJobs(), HttpStatus.OK);
    }

}

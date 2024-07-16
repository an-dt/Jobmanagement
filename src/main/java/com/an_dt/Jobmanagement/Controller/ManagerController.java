package com.an_dt.Jobmanagement.Controller;

import com.an_dt.Jobmanagement.Service.imp.JobServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@CrossOrigin("http://127.0.0.1:5501/")
public class ManagerController {
    @Autowired
    JobServiceimp jobServiceimp;

    @GetMapping("")
    public ResponseEntity<?> getAllJobs(){
       return new ResponseEntity<>(jobServiceimp.getAllJobs(), HttpStatus.OK);
    }

}

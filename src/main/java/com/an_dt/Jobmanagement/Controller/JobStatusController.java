package com.an_dt.Jobmanagement.Controller;

import com.an_dt.Jobmanagement.Service.JobService;
import com.an_dt.Jobmanagement.Service.imp.JobServiceimp;
import com.an_dt.Jobmanagement.dto.JobStatusUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3030")
public class JobStatusController {
    @Autowired
    private JobServiceimp jobServiceimp;

    @PostMapping("/job-status")
    public ResponseEntity<Void> updateJobStatus(@RequestBody JobStatusUpdateRequest request) {
        jobServiceimp.updateJobStatus(request.getJobId(), request.getJobStatus(), request.getStatusEnum());
        return ResponseEntity.ok().build();
    }
}

package com.an_dt.Jobmanagement.Controller;

import com.an_dt.Jobmanagement.Service.imp.JobServiceimp;
import com.an_dt.Jobmanagement.dto.JobStatusUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3030")
@Component
public class JobStatusController {
    final Logger logger = LoggerFactory.getLogger(JobStatusController.class);
    @Autowired
    private JobServiceimp jobServiceimp;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostMapping("/job-status")
    public ResponseEntity<Void> updateJobStatus(@RequestBody JobStatusUpdateRequest request) {
        jobServiceimp.updateJobStatus(request.getJobId(),request.getJobGroup() , request.getJobStatus(), request.getStatusEnum());
        return ResponseEntity.ok().build();
    }
    @PostMapping("/jobs/{jobId}/stop")
    public ResponseEntity<Void> stopJob(@PathVariable String jobId) {
        try {
            jobServiceimp.stopJob(jobId);
            sendToSource(jobId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private void sendToSource(String jobId) {
        rabbitTemplate.convertAndSend("jobStoppingExchange", "jobStoppingRoutingKey", jobId);
        logger.info("Đã gửi jobId {} vào queue", jobId);
    }


}

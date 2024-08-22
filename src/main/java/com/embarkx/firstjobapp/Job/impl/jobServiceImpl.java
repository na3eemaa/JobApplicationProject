package com.embarkx.firstjobapp.Job.impl;

import com.embarkx.firstjobapp.Job.Job;
import com.embarkx.firstjobapp.Job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
@Service
public class jobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

}

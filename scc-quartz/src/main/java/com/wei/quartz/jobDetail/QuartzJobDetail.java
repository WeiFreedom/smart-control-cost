package com.wei.quartz.jobDetail;

import com.wei.quartz.job.QuartzJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;

//@Configuration
public class QuartzJobDetail {
    @Bean
    public JobDetail getJobDetail(){
        JobDetail job = JobBuilder.newJob(QuartzJob.class)
                .withIdentity(QuartzJob.class.getName())
                .build();
        return job;
    }
}

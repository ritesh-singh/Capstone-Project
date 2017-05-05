package com.example.riteshkumarsingh.capstone_stage2.utils;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

import com.example.riteshkumarsingh.capstone_stage2.data.sync.JobSchedulerService;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

public final class UiUtils {

    private UiUtils() {
        throw new AssertionError("No instances for utility class");
    }

    public static float getScreenDensity(Context context){
        return context.getResources().getDisplayMetrics().density;
    }

    public static void scheduleJob(Context context){
        ComponentName componentName = new ComponentName(context,
                JobSchedulerService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0,
                componentName);
        builder.setRequiresCharging(true);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setRequiresDeviceIdle(true);
        builder.setPeriodic(86400000); //  24 hr

        JobScheduler jobScheduler =
                (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(builder.build());
    }
}

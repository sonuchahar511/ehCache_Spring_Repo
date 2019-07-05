package com.chahar.cache.appointment.impl;

import com.chahar.cache.appointment.AppointmentService;
import com.chahar.common.TimeUtil;
import com.chahar.dto.AppointmentDto;
import com.google.common.base.Stopwatch;
import org.springframework.cache.annotation.Cacheable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AppointmentServiceImpl implements AppointmentService {

    @Override
    @Cacheable(value = "appointmentCache", key = "#doctorId")
    public AppointmentDto findAppointment(String doctorId) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        stopwatch.elapsed(TimeUnit.MILLISECONDS);

        //Time consuming process: Complex Database query / any external system call
        TimeUtil.slowQuery(2000);

        stopwatch.stop();

        System.out.println("Time taken for checking appointment: " + stopwatch.toString() + "for doctor " + doctorId);

        return new AppointmentDto("patient1@gmail.com", new Date(), new Date(), "OPD", doctorId);
    }

}

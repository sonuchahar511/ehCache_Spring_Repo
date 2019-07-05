package com.chahar.cache;

import com.chahar.cache.appointment.AppointmentService;
import com.chahar.dto.AppointmentDto;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuickerCacheApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:cache-context/quicker-cache-context.xml");

        AppointmentService appointmentService = context.getBean(
                "appointmentService", AppointmentService.class);
        for (int i = 0; i < 1000000; i++) {
            AppointmentDto dto1 = appointmentService.findAppointment("Namit Gupta");
            System.out.println(dto1);
        }

        AppointmentDto dto1 = appointmentService.findAppointment("Namit Gupta");
        AppointmentDto dto2 = appointmentService.findAppointment("Namit Gupta");

        System.out.println(dto1);
        System.out.println(dto2);
        context.destroy();
    }
}

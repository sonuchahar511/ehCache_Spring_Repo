package com.chahar.cache.appointment;

import com.chahar.dto.AppointmentDto;

public interface AppointmentService {

    public AppointmentDto findAppointment(String doctorId);

}

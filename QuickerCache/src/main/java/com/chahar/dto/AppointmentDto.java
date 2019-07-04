package com.chahar.dto;

import java.util.Date;

public class AppointmentDto {
    private String patient;
    private Date when;
    private Date creationTime;
    private String purpose;
    private String doctorId;

    public AppointmentDto(String patient, Date when, Date creationTime, String purpose, String doctorId) {
        this.patient = patient;
        this.when = when;
        this.creationTime = creationTime;
        this.purpose = purpose;
        this.doctorId = doctorId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return super.toString() + "-> AppointmentDto{" +
                "patient='" + patient + '\'' +
                ", when=" + when +
                ", creationTime=" + creationTime +
                ", purpose='" + purpose + '\'' +
                ", doctorId=" + doctorId +
                '}';
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}

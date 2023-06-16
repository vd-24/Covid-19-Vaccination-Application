package com.covid19.Services;

import java.util.List;

import com.covid19.Models.Appointment;

public interface AppointmentService {
	public List<Appointment> getAllAppoinments();
	public Appointment getAppointmentById(Integer Id);
	public Appointment addAppointment(Appointment appointment);
	public Appointment updateAppointment(Integer appointmentId, Appointment appointment);
	public boolean deleteAppointment(Integer appointmentId);
}

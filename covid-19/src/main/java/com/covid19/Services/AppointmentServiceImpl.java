package com.covid19.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid19.Exception.AppointmentException;
import com.covid19.Models.Appointment;
import com.covid19.Repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Override
	public List<Appointment> getAllAppoinments() {
		List<Appointment> list = appointmentRepo.findAll();
		if(list.isEmpty()) throw new AppointmentException("No Appointments Found");
		
		return list;
	}

	@Override
	public Appointment getAppointmentById(Integer Id) {
		Optional<Appointment> opt = appointmentRepo.findById(Id);
		if(opt.isEmpty()) throw new AppointmentException("No Appoinment Found Of This ID");
		
		return opt.get();
	}

	@Override
	public Appointment addAppointment(Appointment appointment) {
		Optional<Appointment> opt = appointmentRepo.findById(appointment.getBookingId());
		if(opt.isPresent()) throw new AppointmentException("Appointment Already Present");
		
		return appointmentRepo.save(appointment);
	}

	@Override
	public Appointment updateAppointment(Integer appointmentId, Appointment appointment) {
		Optional<Appointment> opt = appointmentRepo.findById(appointmentId);
		if(opt.isEmpty()) throw new AppointmentException("Appointment Not Found");
		
		Appointment oldApp = opt.get();
		oldApp.setDateOfBooking(appointment.getDateOfBooking());
		oldApp.setMobileNo(appointment.getMobileNo());
		oldApp.setSlot(appointment.getSlot());
		oldApp.setVaccinationCenter(appointment.getVaccinationCenter());
		
		return appointmentRepo.save(oldApp);
	}

	@Override
	public boolean deleteAppointment(Integer appointmentId) {
		// TODO Auto-generated method stub
		return false;
	}

}

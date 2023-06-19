package com.covid19.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid19.Exception.AppointmentException;
import com.covid19.Exception.MemberException;
import com.covid19.Exception.VaccinationCenterException;
import com.covid19.Models.Appointment;
import com.covid19.Models.Member;
import com.covid19.Models.VaccinationCenter;
import com.covid19.Repository.AppointmentRepository;
import com.covid19.Repository.MemberRepository;
import com.covid19.Repository.VaccinationCenterRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	VaccinationCenterRepository center;
	
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

	public Appointment addAppointment(Integer memberId , Appointment appointment,Integer vaccinationCenterId) {
		Optional<Member> mem = memberRepo.findById(memberId);
		Optional<VaccinationCenter> cen = center.findById(vaccinationCenterId);
		if(cen.isEmpty()) throw new VaccinationCenterException("No Center Present Of This Id");
		if(mem.isEmpty()) throw new MemberException("No Member Found Of This Id");
		
		if(mem.get().isDose1() == true && mem.get().isDose2()==true) {
			throw new MemberException("Member already vaccinated with 2 doses");
		}
		
		if(mem.get().isDose1()==false && mem.get().isDose2()==false) {
			mem.get().setDose1(true);
			mem.get().setDose1date(appointment.getDateOfBooking());
		}else {
			mem.get().setDose2(true);
			mem.get().setDose2date(appointment.getDateOfBooking());
		}
		
		
		Optional<Appointment> opt = appointmentRepo.findById(appointment.getBookingId());
		if(opt.isPresent()) throw new AppointmentException("Appointment Already Present");
		
		appointment.setMember(mem.get());
		mem.get().setAppointment(appointment);
		appointment.setVaccinationCenter(cen.get());
		cen.get().setAppointment(appointment);
		
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
		Optional<Appointment> opt = appointmentRepo.findById(appointmentId);
		if(opt.isEmpty()) throw new AppointmentException("Appointment Not Found");
		
	   Appointment oldApp = opt.get();
	   if(oldApp==null) return false;
	   appointmentRepo.delete(oldApp);
	   return true;
	}
	
	

}

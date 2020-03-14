package com.mm.pas.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Doctors" database table.
 * 
 */
@Entity
@Table(name="doctors", schema="demo")
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private Integer doctorId;

	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="user_id")
	private String userId;

	//bi-directional many-to-one association to Appointment
//	@OneToMany(mappedBy="doctor")
//	private List<Appointment> appointments;

	public Doctor() {
	}

	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

//	public List<Appointment> getAppointments() {
//		return this.appointments;
//	}
//
//	public void setAppointments(List<Appointment> appointments) {
//		this.appointments = appointments;
//	}
//
//	public Appointment addAppointment(Appointment appointment) {
//		getAppointments().add(appointment);
//		appointment.setDoctor(this);
//
//		return appointment;
//	}
//
//	public Appointment removeAppointment(Appointment appointment) {
//		getAppointments().remove(appointment);
//		appointment.setDoctor(null);
//
//		return appointment;
//	}

}
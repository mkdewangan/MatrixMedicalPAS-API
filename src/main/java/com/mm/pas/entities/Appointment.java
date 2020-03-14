package com.mm.pas.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;

/**
 * The persistent class for the appointments database table.
 * 
 */
@Entity
@Table(name = "appointments", schema = "demo")
@NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Integer appointmentId;

	@Column(name = "appointment_datetime")
	private Timestamp appointmentDatetime;

	@Column(name = "conf_code")
	private String confCode;

	

	@Column(name = "doctor_id")
	private Integer doctorId;
	
//	@OneToOne
//	@JoinColumn(name = "doctor_id")
//	private Doctor doctor;

	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "status")
	private String status;
	

	public Appointment() {
	}

	public Integer getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Timestamp getAppointmentDatetime() {
		return this.appointmentDatetime;
	}

	public void setAppointmentDatetime(Timestamp appointmentDatetime) {
		this.appointmentDatetime = appointmentDatetime;
	}

	public String getConfCode() {
		return this.confCode;
	}

	public void setConfCode(String confCode) {
		this.confCode = confCode;
	}



	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
//
//	public Doctor getDoctor() {
//		return doctor;
//	}
//
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDatetime=" + appointmentDatetime
				+ ", confCode=" + confCode + ", doctorId=" + doctorId + ", userId=" + userId + ", status=" + status
				+ "]";
	}
}
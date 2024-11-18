package com.example.demo.Entity;

import java.time.LocalDate;

public class AttendanceDto {
    private Long studentId;
    private LocalDate date;
    private Attendance.Status status;
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Attendance.Status getStatus() {
		return status;
	}
	public void setStatus(Attendance.Status status) {
		this.status = status;
	}


}

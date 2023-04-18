package com.bookmycon.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Booking {

    private int bookingId;
    
    private LocalDate bookingDateFrom;
    
    private LocalDate bookingDateTo;

    private LocalTime bookingTimeFrom;

	private LocalTime bookingTimeTO;
 
    private String bookingAgenda;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDateFrom() {
		return bookingDateFrom;
	}

	public void setBookingDateFrom(LocalDate bookingDateFrom) {
		this.bookingDateFrom = bookingDateFrom;
	}

	public LocalDate getBookingDateTo() {
		return bookingDateTo;
	}

	public void setBookingDateTo(LocalDate bookingDateTo) {
		this.bookingDateTo = bookingDateTo;
	}

	public LocalTime getBookingTimeFrom() {
		return bookingTimeFrom;
	}

	public void setBookingTimeFrom(LocalTime bookingTimeFrom) {
		this.bookingTimeFrom = bookingTimeFrom;
	}

	public LocalTime getBookingTimeTO() {
		return bookingTimeTO;
	}

	public void setBookingTimeTO(LocalTime bookingTimeTO) {
		this.bookingTimeTO = bookingTimeTO;
	}

	public String getBookingAgenda() {
		return bookingAgenda;
	}

	public void setBookingAgenda(String bookingAgenda) {
		this.bookingAgenda = bookingAgenda;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDateFrom=" + bookingDateFrom + ", bookingDateTo="
				+ bookingDateTo + ", bookingTimeFrom=" + bookingTimeFrom + ", bookingTimeTO=" + bookingTimeTO
				+ ", bookingAgenda=" + bookingAgenda + "]";
	}

	public Booking(int bookingId, LocalDate bookingDateFrom, LocalDate bookingDateTo, LocalTime bookingTimeFrom,
			LocalTime bookingTimeTO, String bookingAgenda) {
		super();
		this.bookingId = bookingId;
		this.bookingDateFrom = bookingDateFrom;
		this.bookingDateTo = bookingDateTo;
		this.bookingTimeFrom = bookingTimeFrom;
		this.bookingTimeTO = bookingTimeTO;
		this.bookingAgenda = bookingAgenda;
	}

	public Booking() {
		super();
	}

}


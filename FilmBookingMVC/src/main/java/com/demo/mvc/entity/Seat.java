package com.demo.mvc.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private long sId;
	
	@ElementCollection
	private List<String> seatNo;
	
	@ElementCollection
	private List<Double> price;
	
	@Column(name="total")
	private double total;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CurrentDateOperation operation;

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public List<String> getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(List<String> seatNo) {
		this.seatNo = seatNo;
	}

	public List<Double> getPrice() {
		return price;
	}

	public void setPrice(List<Double> price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CurrentDateOperation getOperation() {
		return operation;
	}

	public void setOperation(CurrentDateOperation operation) {
		this.operation = operation;
	}

	public Seat(List<String> seatNo, List<Double> price, double total, Customer customer,
			CurrentDateOperation operation) {
		super();
		this.seatNo = seatNo;
		this.price = price;
		this.total = total;
		this.customer = customer;
		this.operation = operation;
	}

	public Seat(long sId, List<String> seatNo, List<Double> price, double total, Customer customer,
			CurrentDateOperation operation) {
		super();
		this.sId = sId;
		this.seatNo = seatNo;
		this.price = price;
		this.total = total;
		this.customer = customer;
		this.operation = operation;
	}

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Seat [sId=" + sId + ", seatNo=" + seatNo + ", price=" + price + ", total=" + total + ", customer="
				+ customer + ", operation=" + operation + "]";
	}

		
	
}

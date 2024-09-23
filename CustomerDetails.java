package com.tap.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="customer_details")
public class CustomerDetails {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="mobile")
	private int mobile;
	//this is for bidirectional
	@OneToOne(mappedBy="ccid",cascade = CascadeType.ALL)
	private Customer customer;
	public CustomerDetails(int id, String email, int mobile) {
		super();
		this.id = id;
		this.email = email;
		this.mobile = mobile;}
	public CustomerDetails() {
		super();}
	public int getId() {
		return id;}
	public void setId(int id) {
		this.id = id;}
	public String getEmail() {
		return email;}
	public void setEmail(String email) {
		this.email = email;}
	public int getMobile() {
		return mobile;}
	public void setMobile(int mobile) {
		this.mobile = mobile;}
	public Customer getCustomer() {
		return customer;}
	public void setCustomer(Customer customer) {
		this.customer = customer;}
	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
	

}

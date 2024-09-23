package com.tap.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="cid")
	private  int cid;
	@Column(name="name")
	private  String name;
	@JoinColumn(name="id")     //join the customerdetails column to customer
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDetails ccid;

	public Customer(int cid, String name) {
		super();
		this.cid = cid;
		this.name = name;}
    public Customer() {
		super();}
	public int getCid() {
		return cid;}
	public void setCid(int cid) {
		this.cid = cid;}
    public String getName() {
		return name;}
	public void setName(String name) {
		this.name = name;}
	public CustomerDetails getCcid() {
		return ccid;}
	public void setCcid(CustomerDetails ccid) {
		this.ccid = ccid;}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", ccid=" + ccid + "]";
	}
	
	
   
}

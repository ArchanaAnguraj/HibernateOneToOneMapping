package com.tap.entity;

public class launch {
    public static void main(String[] args) {
	HibernateManager hm=new HibernateManager();
	//for add OneToOne
	CustomerDetails cd = new CustomerDetails(1,"anu@gmail.com",1234);
	Customer c=new Customer(1,"anu");
	//unidirectional
        hm.add(c);                    //this is for adding
	hm.add(cd);
	    
       //bidirectional---///
	c.setCcid(cd);
	cd.setCustomer(c);
	hm.add(cd);


	    
	//select for bidirectional
	cd=hm.getCDbasedonId(2);
	System.out.println(cd.getCustomer().getName()+" "+cd.getCustomer().getCid()+" "+cd.getEmail()+" "+cd.getMobile());
	//for select OneToOne

	    
	Customer c1=hm.getbasedId(1);
	if(c1!=null) {
	System.out.println(c1.getCid()+" "+c1.getName());   //this for get value from customer table
	System.out.println(c1.getCcid().getId()+" "+c1.getCcid().getEmail()); //this for get value from customerDetails table .
	}                                     //how to use customerDetails?by  i alredy give the referance ccid using that 
	else {
		System.out.println("no records found");
	}
	    
	//for update OneToOne
	hm.update(1, "anu", "anu@gmail.com");
	    
	//for delete
	hm.delete(2);
	    
	//fetch all
	hm.getAll();
	}	
}

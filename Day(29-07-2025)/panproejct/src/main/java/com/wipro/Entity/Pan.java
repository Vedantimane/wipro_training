package com.wipro.Entity;

import org.hibernate.annotations.AnyDiscriminatorImplicitValues.Strategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Pan")
public class Pan {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 int PanId;
	 
	 @Column(name="panholder_name")
	 String panholderName;
	 
	 @Column(name="panholder_name")
	 String panNumber;

}

package edu.mum.ea.entity;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.mum.ea.entity.enumtype.RequestStatus;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="requestType", discriminatorType = DiscriminatorType.STRING)
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Customer customer;
	
	@Enumerated(EnumType.STRING)
	private RequestStatus requestStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	
}

package com.example.lab6_micro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "compte")
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double solde;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@Enumerated(EnumType.ORDINAL)
	private TypeCompte type;
}

package com.javabydeveloper;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="Patients")
@Entity(name = "Pac")
public class Paciente {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
		@GenericGenerator(name = "native", strategy = "native")
		
		@Column(name = "id")
		private int patientId;
		
		@Column(name = "dni")
		private String Pdni;

		@Column(name = "names")
		private String Pnames;

		@Column(name = "father_surname")
		private String Pfather_surname;

		@Column(name = "mother_surname")
		private String Pmother_surname;
		
		@Column(name = "gender")
		private Boolean Pgender;
		
		@Column(name = "birth")
		private Date Pbirth;
		
		@Column(name = "blood_type")
		private String Pblood;
		
		@Column(name = "size")
		private Float Psize;
		
		@Column(name = "weight")
		private Float Pweight;
		
		@Column(name = "phone")
		private String Pphone;
		
		@Column(name = "address")
		private String Paddress;

		@Column(name = "email")
		private String Pemail;
		
		@Column(name = "others")
		private String Pothers;
		
		public int getPatientId() {
			return patientId;
		}
		
		public String getPdni() {
			return Pdni;
		}

		public void setPdni(String pdni) {
			Pdni = pdni;
		}

		public String getPnames() {
			return Pnames;
		}

		public void setPnames(String pnames) {
			Pnames = pnames;
		}

		public String getPfather_surname() {
			return Pfather_surname;
		}

		public void setPfather_surname(String pfather_surname) {
			Pfather_surname = pfather_surname;
		}

		public String getPmother_surname() {
			return Pmother_surname;
		}

		public void setPmother_surname(String pmother_surname) {
			Pmother_surname = pmother_surname;
		}

		public Boolean getPgender() {
			return Pgender;
		}

		public void setPgender(Boolean pgender) {
			Pgender = pgender;
		}

		public Date getPbirth() {
			return Pbirth;
		}

		public void setPbirth(Date pbirth) {
			Pbirth = pbirth;
		}

		public String getPblood() {
			return Pblood;
		}

		public void setPblood(String pblood) {
			Pblood = pblood;
		}

		public Float getPsize() {
			return Psize;
		}

		public void setPsize(Float psize) {
			Psize = psize;
		}

		public Float getPweight() {
			return Pweight;
		}

		public void setPweight(Float pweight) {
			Pweight = pweight;
		}

		public String getPphone() {
			return Pphone;
		}

		public void setPphone(String pphone) {
			Pphone = pphone;
		}

		public String getPaddress() {
			return Paddress;
		}

		public void setPaddress(String paddress) {
			Paddress = paddress;
		}

		public String getPemail() {
			return Pemail;
		}

		public void setPemail(String pemail) {
			Pemail = pemail;
		}

		public String getPothers() {
			return Pothers;
		}

		public void setPothers(String pothers) {
			Pothers = pothers;
		}

		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}

		@Override
		public String toString() {
			return "Paciente [Id=" + patientId + ", dni=" + Pdni + ", names=" + Pnames + ", father_surname="
					+ Pfather_surname + ", mother_surname=" + Pmother_surname + ", gender=" + Pgender + ", birth="
					+ Pbirth + ", blood=" + Pblood + ", size=" + Psize + ", weight=" + Pweight + ", phone=" + Pphone
					+ ", address=" + Paddress + ", email=" + Pemail + ", others=" + Pothers + "]";
		}
		
}
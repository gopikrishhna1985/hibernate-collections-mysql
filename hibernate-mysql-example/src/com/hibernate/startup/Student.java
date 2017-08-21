package com.hibernate.startup;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENT_INFO")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private int studentId;
	@Column(name = "STUDENT_NAME")
	private String studentName;
	@Temporal(TemporalType.DATE)
	@Column(name = "ADMISSION_DATE")
	private Date admissionDate;
	@Column(name = "CLASS_SECTION")
	private String section;
	@Lob
	@Column(name = "STUDENT_DESC")
	private String studentDesc;
	@Transient
	private String nickName;
	// @Embedded
	// private Address address;

	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "STUDENT_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	private Set<Address> addressSet = new HashSet();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStudentDesc() {
		return studentDesc;
	}

	public void setStudentDesc(String studentDesc) {
		this.studentDesc = studentDesc;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Set<Address> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<Address> addressSet) {
		this.addressSet = addressSet;
	}

}

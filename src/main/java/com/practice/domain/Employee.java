/*
 * 
 */
package com.practice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class Employee.
 */
@Entity
public class Employee implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1087785649826583834L;

	/** The id. */
	@Id
	private Long id;

	/** The name. */
	@Column(nullable = false)
	private String name;

	/** The designation. */
	@Column(nullable = false)
	private String designation;

	/** The monthly salary. */
	@Column(nullable = false)
	private Long monthlySalary;

	/**
	 * Instantiates a new employee.
	 */
	public Employee() {

	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param id the id
	 * @param name the name
	 * @param designation the designation
	 * @param monthlySalary the monthly salary
	 */
	public Employee(Long id, String name, String designation, Long monthlySalary) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.monthlySalary = monthlySalary;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the new designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the monthly salary.
	 *
	 * @return the monthly salary
	 */
	public Long getMonthlySalary() {
		return monthlySalary;
	}

	/**
	 * Sets the monthly salary.
	 *
	 * @param monthlySalary the new monthly salary
	 */
	public void setMonthlySalary(Long monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Name:" + name + ", Designation:" + designation + ", Salary:" + monthlySalary;
	}

}
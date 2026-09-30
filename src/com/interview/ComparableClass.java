package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee>{
	
	int empId;
	int empAge;
	double salary;
	String empName;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if(this.empAge > o.empAge) {
		return 0;
		}else {
			return -1;
		}
	}	

}

public class ComparableClass{
	public static void main(String[] args) {
		
		Employee c1 = new Employee();
		c1.setEmpAge(29);
		c1.setEmpId(123);
		c1.setEmpName("Kumar");
		c1.setSalary(20000.00);
		Employee c2 = new Employee();
		c2.setEmpAge(27);
		c2.setEmpId(124);
		c2.setEmpName("ArunKumar");
		c2.setSalary(50000.00);
		Employee c3 = new Employee();
		c3.setEmpAge(30);
		c3.setEmpId(125);
		c3.setEmpName("Arun");
		c3.setSalary(80000.00);
		
		List<Employee> listclass = new ArrayList<>();
		listclass.add(c1);
		listclass.add(c2);
		listclass.add(c3);
		
		
		//List<Employee> sortedByName = listclass.stream().map(Comparable.compareTo(Employee::getName)).toList();
		Collections.sort(listclass);
		
		for(Employee emp : listclass) {
			System.out.println(
					emp.getEmpId() + " " +
					emp.getEmpName() + " " +
					emp.getEmpAge() + " " +
					emp.getSalary());
		}
	}
}

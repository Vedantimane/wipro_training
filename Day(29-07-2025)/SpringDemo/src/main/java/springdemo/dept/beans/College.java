package springdemo.dept.beans;


public class College {
	
	String collegename;
	Department department;
	
	
	public College() {
		super();
	}


	public College(String collegename, Department department) {
		super();
		this.collegename = collegename;
		this.department = department;
	}


	public String getCollegename() {
		return collegename;
	}


	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "College [collegename=" + collegename + ", department=" + department + "]";
	}
	
	

}

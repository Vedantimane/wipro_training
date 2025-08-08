package springdemo.dept.beans;

public class Department {
	
	String deptCode;
	String deptName;
	
	public Department() {
		super();
	}

	public Department(String deptCode, String deptName) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptCode=" + deptCode + ", deptName=" + deptName + "]";
	}
	

}

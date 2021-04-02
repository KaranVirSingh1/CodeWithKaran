package code.with.karan;

public class Employee {
	
	private int eid;
	private String ename;
	private int sal;
	private int depNo;
	private String status="active";
	
	public Employee() {
		System.out.println("Employee :: 0 param constructor");
	}

	public Employee(int eid, String ename, int sal, int depNo, String status) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.depNo = depNo;
		this.status = status;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getDepNo() {
		return depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", depNo=" + depNo + ", status=" + status
				+ "]";
	}
	
}

package spring1;

public class Employee {
	private int eid,depid;
	private String ename;
	public Employee() {
	}
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", depid=" + depid + "]";
		
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
}
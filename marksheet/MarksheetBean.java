package in.jdbc.marksheetResourceBundle;

public class MarksheetBean {
	private int id;
	private String roll_No;
	private String Fname;
	private String Lname;
	private int chemistry;
	private int physics;
	private int maths;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoll_No() {
		return roll_No;
	}
	public void setRoll_No(String roll_No) {
		this.roll_No = roll_No;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public int getChemistry() {
		return chemistry;
	}
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public MarksheetBean(){}
}

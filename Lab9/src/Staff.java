public class Staff extends Person {
	
	private String school;
	private double pay;
	
	public Staff(String name, String address, double pay) {
		this.setName(name);
		this.setAddress(address);
		this.pay = pay;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}
	
	@Override
	public String toString() {
		return "Staff\nName: " + this.getName() + "\nAddress: " + this.getAddress() + "\nSchool: " + school + "\nPay: " + pay;
	}

}
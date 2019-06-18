package chap1;

public class CarTax extends VehicleTax {
	private int displacement;
	double carTax;
	
	
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	public int getDisplacement() {
		return displacement;
	}
	
	public void makeCarTax(int displacement) {
		if(displacement<1000) {
			carTax = price*0.02;
		} else if(displacement<2000) {
			carTax = price*0.04;
		} else {
			carTax = price*0.06;
		}
	}
}
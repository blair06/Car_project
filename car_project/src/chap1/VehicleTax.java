package chap1;

public class VehicleTax extends Vehicle {
	String vehicleType = null;
	@Override 
	String getModelName() {
		return this.modelName;
	}
	int getPrice() {
		return this.price;
	}
	void setPrice(int newPrice) {
		this.price = newPrice;
	}
}
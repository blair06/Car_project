package chap1;

public class TruckTax extends VehicleTax {
	private int load;
	double truckTax;
	
		public void setLoad(int load) {
			this.load = load;
		};
		
		public int getLoad() {
			return load;
		}
		
		public void makeTruckTax(int load) {
			if(load<1) {
				truckTax = price*0.01;
			} else if(load<3) {
				truckTax = price*0.03;
			} else {
				truckTax = price*0.05;
			}
		}
}


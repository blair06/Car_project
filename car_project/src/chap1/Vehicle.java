package chap1;

public abstract class Vehicle {
	protected String modelName;
	protected int price;
	abstract String getModelName();
	abstract int getPrice();
	abstract void setPrice(int newPrice);
}
package chap1;
import java.util.Scanner;
public class VehicleTaxExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;
		int i =0;
		VehicleTax[] vt = new VehicleTax[10];
		
		
		
		//�޴�����ȭ��
		while(true) {
			System.out.println("==================================");
			System.out.println("1.���� ���� �Է� | 2.���� ���� ��ȸ | 3.���� ���� ���� | 4.��ü ��			�� ���� ��� | 5.���α׷� ����");
			System.out.println("==================================");
			System.out.print("�޴��� �����Ͻʽÿ�. >");
			int num = scanner.nextInt();
			
			//���� ���� �Է�
			if(num == 1) {
				System.out.print("���������� �Է��ϼ��� (car/truck) >");
			
				if (scanner.next().equals("car")) {
					vt[i] = new CarTax();
					
					vt[i].vehicleType = "car";
					System.out.println("�𵨸��� �Է��ϼ���");
					name = scanner.next();
					
					//�ߺ��� �̸� ����Ұ����
					Boolean isExistsModelName = false;
					for(int j= 0 ; j < vt.length ; j++){
						if(vt[j] == null){
							break; 
						} else if(name.equals(vt[j].getModelName())){
							isExistsModelName = true;
							break;
						}
					}
				if(isExistsModelName){
					System.out.println("�̹� �Էµ� �𵨸��Դϴ�. �޴��� ���ư���						��."); 
					continue;
					} else {
						vt[i].modelName = name;
						
						System.out.println("���� ������ �Է��ϼ���");
						int newPrice = scanner.nextInt();
						vt[i].setPrice(newPrice);
							
						System.out.println("��ⷮ�� �Է��ϼ���");
						int displacement = scanner.nextInt();
						//��ⷮ ����޼ҵ� 
							
						((CarTax)vt[i]).setDisplacement(displacement);
						((CarTax)vt[i]).makeCarTax(displacement);
						i++;
					}
				} else {
					//Ʈ�����ý�
					vt[i] = new TruckTax();
					vt[i].vehicleType = "truck";
					System.out.println("�𵨸��� �Է��ϼ���");
					name = scanner.next();
					Boolean isExistsModelName = false;
					for(int j= 0 ; j < vt.length ; j++){
						if(vt[j] == null){
							break; 
						} else if(name.equals(vt[j].getModelName())){
							isExistsModelName = true;
							break;
						}
					}

				if(isExistsModelName){
					System.out.println("�̹� �Էµ� �𵨸��Դϴ�. �޴��� ���ư���						��."); 
					continue;
					} else {
						vt[i].modelName = name;
							
						System.out.println("���� ������ �Է��ϼ���");
						int newPrice = scanner.nextInt();
						vt[i].setPrice(newPrice);
								
						System.out.println("���緮�� �Է��ϼ���");
						int load = scanner.nextInt();
						//���緮 ����޼ҵ� 
						((TruckTax)vt[i]).setLoad(load);
						((TruckTax)vt[i]).makeTruckTax(load);
						i++;
					}
				}
			} else if(num==2) {
				System.out.println("ã�����ϴ� ������ �𵨸��� �Է��ϼ���");
				name = scanner.next();
				
				for(int j= 0 ; j < i ; j++){
					System.out.println("=========================");
					if(name.equals(vt[j].getModelName())){
						if(vt[j].vehicleType.equals("car")) {
							System.out.println("�𵨸�:"+ name);
							System.out.println("��������:"+ vt[j].price);
							System.out.println("��ⷮ:"+ 										((CarTax)vt[j]).getDisplacement());
							System.out.println("����:"+ ((CarTax)vt[j]).carTax);
							break;
						} else if(vt[j].vehicleType.equals("truck")){
							System.out.println("�𵨸�:"+ name);
							System.out.println("��������:"+ vt[j].price);
							System.out.println("���緮:"+ 										((TruckTax)vt[j]).getLoad());
							System.out.println("����:"+ 										((TruckTax)vt[j]).truckTax);
							break;
						}		
					} else {
						System.out.println("!���� ��ȸ�� �����Ͽ����ϴ�.!");
						break;
					}
				}
			} else if(num==3) {
				System.out.println("�����ϰ����ϴ� �𵨸��� �Է��ϼ���");
				name = scanner.next();
				for(int j= 0 ; j < vt.length ; j++){
					if(vt[j] == null){
						break; 
					} else if(name.equals(vt[j].getModelName())){
						System.out.println("������ ������ �Է��ϼ���.");
						int newPrice = scanner.nextInt();
						vt[j].setPrice(newPrice);		
					}
				}
		
			} else if(num==4) {
				for(int k = 0 ; k < i ; k++){
					System.out.println("=========================");
					System.out.print("�� �� : " + vt[k].getModelName() + " | ");
					System.out.print("�������� : " + vt[k].getPrice() + " | ");

					if(vt[k].vehicleType.equals("car")){
						System.out.print("���� Ÿ�� : Car | ");
						System.out.println("��ⷮ : " + 										((CarTax)vt[k]).getDisplacement() + " | ");
					}
					else{
						System.out.print("���� Ÿ�� : Truck | ");
						System.out.println("���緮 : " + ((TruckTax)vt[k]).getLoad() + 						" | ");
					}
				}
			} else if(num == 5) {
				break;
			}
		}	
	}
}

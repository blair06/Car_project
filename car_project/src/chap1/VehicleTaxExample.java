package chap1;
import java.util.Scanner;
public class VehicleTaxExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;
		int i =0;
		VehicleTax[] vt = new VehicleTax[10];
		
		
		
		//메뉴선택화면
		while(true) {
			System.out.println("==================================");
			System.out.println("1.차량 정보 입력 | 2.차량 정보 조회 | 3.차량 정보 수정 | 4.전체 차			량 정보 출력 | 5.프로그램 종료");
			System.out.println("==================================");
			System.out.print("메뉴를 선택하십시오. >");
			int num = scanner.nextInt();
			
			//차량 정보 입력
			if(num == 1) {
				System.out.print("차량유형을 입력하세요 (car/truck) >");
			
				if (scanner.next().equals("car")) {
					vt[i] = new CarTax();
					
					vt[i].vehicleType = "car";
					System.out.println("모델명을 입력하세요");
					name = scanner.next();
					
					//중복된 이름 저장불가기능
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
					System.out.println("이미 입력된 모델명입니다. 메뉴로 돌아갑니						다."); 
					continue;
					} else {
						vt[i].modelName = name;
						
						System.out.println("차량 가격을 입력하세요");
						int newPrice = scanner.nextInt();
						vt[i].setPrice(newPrice);
							
						System.out.println("배기량을 입력하세요");
						int displacement = scanner.nextInt();
						//배기량 변경메소드 
							
						((CarTax)vt[i]).setDisplacement(displacement);
						((CarTax)vt[i]).makeCarTax(displacement);
						i++;
					}
				} else {
					//트럭선택시
					vt[i] = new TruckTax();
					vt[i].vehicleType = "truck";
					System.out.println("모델명을 입력하세요");
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
					System.out.println("이미 입력된 모델명입니다. 메뉴로 돌아갑니						다."); 
					continue;
					} else {
						vt[i].modelName = name;
							
						System.out.println("차량 가격을 입력하세요");
						int newPrice = scanner.nextInt();
						vt[i].setPrice(newPrice);
								
						System.out.println("적재량을 입력하세요");
						int load = scanner.nextInt();
						//적재량 변경메소드 
						((TruckTax)vt[i]).setLoad(load);
						((TruckTax)vt[i]).makeTruckTax(load);
						i++;
					}
				}
			} else if(num==2) {
				System.out.println("찾고자하는 차량의 모델명을 입력하세요");
				name = scanner.next();
				
				for(int j= 0 ; j < i ; j++){
					System.out.println("=========================");
					if(name.equals(vt[j].getModelName())){
						if(vt[j].vehicleType.equals("car")) {
							System.out.println("모델명:"+ name);
							System.out.println("차량가격:"+ vt[j].price);
							System.out.println("배기량:"+ 										((CarTax)vt[j]).getDisplacement());
							System.out.println("세금:"+ ((CarTax)vt[j]).carTax);
							break;
						} else if(vt[j].vehicleType.equals("truck")){
							System.out.println("모델명:"+ name);
							System.out.println("차량가격:"+ vt[j].price);
							System.out.println("적재량:"+ 										((TruckTax)vt[j]).getLoad());
							System.out.println("세금:"+ 										((TruckTax)vt[j]).truckTax);
							break;
						}		
					} else {
						System.out.println("!정보 조회에 실패하였습니다.!");
						break;
					}
				}
			} else if(num==3) {
				System.out.println("수정하고자하는 모델명을 입력하세요");
				name = scanner.next();
				for(int j= 0 ; j < vt.length ; j++){
					if(vt[j] == null){
						break; 
					} else if(name.equals(vt[j].getModelName())){
						System.out.println("수정할 가격을 입력하세요.");
						int newPrice = scanner.nextInt();
						vt[j].setPrice(newPrice);		
					}
				}
		
			} else if(num==4) {
				for(int k = 0 ; k < i ; k++){
					System.out.println("=========================");
					System.out.print("모델 명 : " + vt[k].getModelName() + " | ");
					System.out.print("차량가격 : " + vt[k].getPrice() + " | ");

					if(vt[k].vehicleType.equals("car")){
						System.out.print("차량 타입 : Car | ");
						System.out.println("배기량 : " + 										((CarTax)vt[k]).getDisplacement() + " | ");
					}
					else{
						System.out.print("차량 타입 : Truck | ");
						System.out.println("적재량 : " + ((TruckTax)vt[k]).getLoad() + 						" | ");
					}
				}
			} else if(num == 5) {
				break;
			}
		}	
	}
}

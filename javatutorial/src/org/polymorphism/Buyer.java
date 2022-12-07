package org.polymorphism;
import java.util.ArrayList;

class Buyer {				//고객, 물건을 사는 사람
	int money = 1000;		//소유금액
	int bonusPoint = 0;		//보너스점수
	ArrayList<Object> item = new ArrayList<Object>();
	int i = 0;
	
	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;			//가진 돈에서 구입한 제품의 가격을 뺀다.
		bonusPoint += p.bonusPoint;	//제품의 보너스 점수를 추가한다.
		item.add(p);
		System.out.println(p+ "을/를 구입하셨습니다.");
	}
	void refund(Product p) {
		if (item.remove(p)) {
			money += p.price;			
			bonusPoint -= p.bonusPoint;	
			System.out.println(p+"을/를 반품하셨습니다.");
		} else {
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}
	void summary() {
		int sum = 0;
		String itemList = "";
		
		for (int i = 0; i < item.size(); i++) {
			Product p = (Product)item.get(i);
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p;
		}
		System.out.println("구입하신 물품의 총금액은 "+sum+"만원입니다.");
		System.out.println("구입하신 제품은 "+itemList+"입니다.");
	}
}

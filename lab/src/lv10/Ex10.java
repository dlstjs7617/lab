package lv10;

import java.util.Random;

interface Damageable2{
	public void damage();
}

interface Repairable2{
	
}

abstract class Unit2{
	public final int MAX_HP;
	private int hp;
	private String name;
	private boolean isDead;
	
	public Unit2 (String name, int hp){
		this.MAX_HP = hp;
		this.hp = hp;
		this.name = name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHpPlus() {
		if(!isDead)
			this.hp++;
	}
	
	public void setHpMinus() {
		if(hp > 0)
			this.hp--;			
		else if(hp <= 0) {
			this.isDead = true;
			this.hp = 0;
			System.out.println(this.name +"이 사망");
			return;
		}
	}
	
	public boolean isDead() {
		return this.isDead;
	}
	
	@Override
	public String toString() {
		return String.format("%s [%d/%d]", this.name, this.hp ,this.MAX_HP);
	}
}

abstract class GroundUnit2 extends Unit2{

	public GroundUnit2(String name, int hp) {
		super(name, hp);
	}
}

abstract class AirUnit2 extends Unit2{
	
	public AirUnit2(String name, int hp) {
		super(name, hp);
	}

	abstract void fly();
}

class Tank2 extends GroundUnit2 implements Repairable2, Damageable2{

	public Tank2() {
		super("공성전차", 175);
	}

	@Override
	public void damage() {
		Random ran = new Random();
		int damage = ran.nextInt(120)+15;
		
		System.out.println(this + "가 " + damage + "를 입었습니다.");
		while(damage-- > 0) {
			setHpMinus();
			if(isDead())
				break;
		}
		if(!isDead())
			System.out.println(this);
	}
	
}

class Marine2 extends GroundUnit2 implements Damageable2{
	
	public Marine2() {
		super("해병", 40);
	}

	@Override
	public void damage() {
		Random ran = new Random();
		int damage = ran.nextInt(40)+5;
		
		System.out.println(this + "가 " + damage + "를 입었습니다.");
		while(damage-- > 0) {
			setHpMinus();
			if(isDead())
				break;
		}
		if(!isDead())
			System.out.println(this);
	}
	
}

class SCV2 extends GroundUnit2 implements Repairable2, Damageable2{
	
	public SCV2() {
		super("SCV", 40);
	}

	@Override
	public void damage() {
		Random ran = new Random();
		int damage = ran.nextInt(40)+5;
		
		System.out.println(this + "가 " + damage + "를 입었습니다.");
		while(damage-- > 0) {
			setHpMinus();
			if(isDead())
				break;
		}
		if(!isDead())
			System.out.println(this);
	}
	
	public void repair(Unit2 unit) {
		if(unit instanceof Repairable2) {
			if(unit.isDead()) {
				System.out.println("죽은 유닛은 수리가 불가능합니다.");
			}else {
				int cnt = 0;
				while(unit.getHp() < unit.MAX_HP) {
					unit.setHpPlus();
					if(++cnt % 5 == 0) {
						System.out.println(unit + " 수리중...");
					}
					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}
				}
				System.out.println("수리 완료");
				System.out.println(unit);
			}
		}
	}
	
}

class DropShip2 extends AirUnit2 implements Repairable2, Damageable2{

	public DropShip2() {
		super("수송선", 120);
		fly();
	}


	@Override
	public void damage() {
		Random ran = new Random();
		int damage = ran.nextInt(120)+15;
		
		System.out.println(this + "가 " + damage + "를 입었습니다.");
		while(damage-- > 0) {
			setHpMinus();
			if(isDead())
				break;
		}
		if(!isDead())
			System.out.println(this);
	}
	

	@Override
	public void fly() {
		System.out.println("탑승 준비 완료");
	}
	
}


public class Ex10 {

	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Marine2 marine = new Marine2();
		SCV2 scv = new SCV2();
		DropShip2 dropShip = new DropShip2();
		
		tank.damage();
		scv.repair(tank);
		marine.damage();
		scv.damage();
		scv.repair(scv);
		dropShip.damage();
		scv.repair(dropShip);
	}

}

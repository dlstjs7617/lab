package lv10;

import java.util.Random;

// 스타크래프트

interface Repairable {
	// 메소드를 담지 않으면 -> 마크 인터페이스 Marker Interface	
}

interface Damageable{
	public void damage();
}

abstract class Unit{
	private int hp;
	private final int MAX_HP;
	private String name;
	private boolean isDead; // 0까지 도달되면 사망처리 -> 수리불가;
	
	public Unit(String name, int hp) {
		MAX_HP = hp;
		this.hp = hp;
		this.name = name;
		System.out.println(String.format("%s의 탄생...", this.name));
	}
	
	public int getMaxHp() {
		return this.MAX_HP;
	}
	
	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getIsDead() {
		return this.isDead;
	}
	
	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	@Override
	public String toString() {
		return String.format("%s hp : [%d/%d]", name,hp, MAX_HP);
	}
}

abstract class GroundUnit extends Unit{

	public GroundUnit(String name, int hp) {
		super(name, hp);
	}
	
}

abstract class AirUnit extends Unit{
	public AirUnit(String name, int hp) {
		super(name, hp);
	}
	
	abstract public void fly();
}

class Tank extends GroundUnit implements Repairable, Damageable{
	public Tank() {
		super("TANK", 80);
	}
	
	@Override
	public void damage() {
		Random ran = new Random();
		int damage = ran.nextInt(100);
		System.out.printf("%s유닛이 %d의 데미지를 입었습니다.\n", this.getName(), damage);
		if(damage >= this.getHp()) {
			this.setIsDead(true);
			System.out.printf("%s가 사망했습니다.\n",this.getName());
		}
		
		if(!this.getIsDead()) {
			this.setHp(this.getHp()-damage);		
		}
	}
	
}

class Marine extends GroundUnit implements Damageable{
	public Marine() {
		super("Marine", 100);
	}

	@Override
	public void damage() {
		Random ran = new Random();
		int damage = ran.nextInt(30);
		System.out.printf("%s유닛이 %d의 데미지를 입었습니다.\n", this.getName(), damage);
		if(damage >= this.getHp()) {
			this.setIsDead(true);
			System.out.printf("%s가 사망했습니다.\n",this.getName());
		}
		
		if(!this.getIsDead()) {
			this.setHp(this.getHp()-damage);		
		}
	}
	
}

class SCV extends GroundUnit implements Repairable , Damageable{
	public SCV() {
		super("SCV", 20);
	}
	
	public void repair(Repairable unit) {
		Unit target = (Unit) unit;
		int cnt = 0;
		
		if(this.getIsDead()) {
			System.err.println("SCV가 죽어서 수리를 못합니다.");
			return;
		}
		
		if(target.getIsDead()) {
			System.err.println("죽은 유닛은 수리가 불가능합니다.");
			return;
		}
		while(target.getHp() < target.getMaxHp()) {
			
			int hp = target.getHp() + 1;
			target.setHp(hp);
			
			if(cnt++ % 3 == 0) {
				System.out.println("수리중...");
				System.out.println(target);				
			}
			try {
				Thread.sleep(200);
			} catch (Exception e) {

			}
		}
		System.out.println("[수리완료]");
		System.out.println(target);
	}

	@Override
	public void damage() {
		Random ran = new Random();
		int damage = ran.nextInt(100);
		System.out.printf("%s유닛이 %d의 데미지를 입었습니다.\n",  this.getName(), damage);
		if(damage >= this.getHp()) {
			this.setIsDead(true);
			System.out.printf("%s가 사망했습니다.\n",this.getName());
		}
		
		if(!this.getIsDead()) {
			this.setHp(this.getHp()-damage);		
		}
	}
	
}

class DropShip extends AirUnit implements Repairable , Damageable{

	public DropShip() {
		super("DropShip", 110);
		fly();
	}

	@Override
	public void fly() {
		System.out.println("I can fly~");
	}
	
	@Override
	public void damage() {
		Random ran = new Random();
		int damage = ran.nextInt(100);
		System.out.printf("%s유닛이 %d의 데미지를 입었습니다.\n",  this.getName(), damage);
		if(damage >= this.getHp()) {
			this.setIsDead(true);
			System.out.printf("%s가 사망했습니다.\n",this.getName());
		}
		
		if(!this.getIsDead()) {
			this.setHp(this.getHp()-damage);		
		}
	}
	
}

public class Ex09 {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv = new SCV();
		DropShip dropShip = new DropShip();
//		Emeny emeny = new Emeny();
		// 추상 클래스는 new 키워드로 객체 생성을 할 수 X
//		new GroundUnit();
//		new AirUnit();
		
//		new Unit("", 0);
		
		tank.damage();
		scv.repair(tank);
		marine.damage();
		scv.damage();
		scv.repair(scv);
		dropShip.damage();
		scv.repair(dropShip);
	}
}

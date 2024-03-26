package lv10t;

// 스타크래프트

interface Repairable {
	// 메소드를 담지 않으면 -> 마크 인터페이스 Marker Interface	
}

interface Damageable{
	public void damage(int attack);
}

abstract class Unit{
	private int hp;
	public final int MAX_HP;
	private String name;
	private boolean isDead;
	
	public Unit(String name, int hp) {
		MAX_HP = hp;
		this.hp = hp;
		this.name = name;
		
		System.out.println(String.format("%s의 탄생...", this.name));
	}
	
	public int getHp() {
		return this.hp;
	}

	public void setHpMinus() {
		if(this.hp > 0) {
			this.hp --;
			
			if(this.hp == 0)
				this.isDead = true;
		}
	}
	
	public void setHpPlus() {
		if(this.hp < MAX_HP)
			this.hp++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isDead() {
		return this.isDead;
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
	protected AirUnit(String name, int hp) {
		super(name, hp);
	}
	
	abstract public void fly();
	
}

class Tank extends GroundUnit implements Repairable, Damageable{
	public Tank() {
		super("TANK", 80);
	}

	@Override
	public void damage(int attack) {
		while(attack > 0) {
			setHpMinus();
			attack --;
 		}
		System.out.println("[공격받음]" + this);
	}
}

class Marine extends GroundUnit implements Damageable {
	public Marine() {
		super("Marine", 100);
	}

	@Override
	public void damage(int attack) {
		while(attack > 0) {
			setHpMinus();
			attack --;
		}
		System.out.println("[공격받음]" + this);
	}
}

class SCV extends GroundUnit implements Repairable, Damageable{
	public SCV() {
		super("SCV", 20);
	}
	
//	public void repair(Repairable unit) {
	public void repair(Unit unit) {
		
		if(unit instanceof Repairable) {
			Unit target = (Unit) unit;
			
			if(!target.isDead()) {
				while(target.getHp() < target.MAX_HP) {
					int hp = target.getHp() + 1;
					target.setHpMinus();
					
					System.out.println("수리중...");
					
					try {
						Thread.sleep(200);
					} catch (Exception e) {	
					}
				}
				System.out.println("[수리완료]" + target);
			}
		}else {
			System.err.println("퉤-");
		}
	}

	@Override
	public void damage(int attack) {
		while(attack > 0) {
			setHpMinus();
			attack --;
		}
		System.out.println("[공격받음]" + this);
	}
}

class DropShip extends AirUnit implements Repairable, Damageable{

	public DropShip() {
		super("DropShip", 110);
		fly();
	}

	@Override
	public void fly() {
		System.out.println("I can fly~");
	}

	@Override
	public void damage(int attack) {
		while(attack > 0) {
			setHpMinus();
			attack --;
		}
		System.out.println("[공격받음]" + this);
	}
	
}

public class Ex09 {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv = new SCV();
		DropShip dropShip = new DropShip();
		
		// 추상 클래스는 new 키워드로 객체 생성을 할 수 X
//		new GroundUnit();
//		new AirUnit();
		
//		new Unit("", 0);
		
//		System.out.println(tank);
//		System.out.println(marine);
//		System.out.println(scv);
//		System.out.println(dropShip);
		scv.damage(19);
		scv.repair(tank);
//		scv.repair(marine);			// 수리불가
	}
}

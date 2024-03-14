package lv08t;

class Monster{
	private static int hp;
	private String name;
	private int height;
	
	public Monster(String name, int height) {
		this.name = name;
		this.height = height;
		this.hp = 100;
		
		System.out.printf("몬스터 %s의 탄생.... \n", this.name);
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		if(hp >= this.hp)
			return;
		
		
		while(this.hp != hp) {
			this.hp --;
			System.out.printf("몬스터 %s hp[%d/100] \n", this.name, this.hp);
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
		}
		this.hp = hp;
		
		if(this.hp <= 0) {
			System.out.printf("몬스터 %s 깨꼬닥. \n", this.name);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHeath() {
		return this.height;
	}
	
	@Override
	public String toString() {
		return String.format("몬스터 %s hp [%d/100]", this.name, this.hp);
	}
}



public class Ex10 {

	public static void main(String[] args) {
		
		Monster orc = new Monster("Orc", 120);
		orc.setHp(0);
		Monster wolf = new Monster("Wolf", 200);
		wolf.setHp(200);
		Monster snake = new Monster("Snake", 10);
		snake.setHp(99);
		
		System.err.println(orc);
		System.err.println(wolf);
		System.err.println(snake);

	}

}

package lv05;

import java.util.Arrays;

public class Ex24 {

	public static void main(String[] args) {
		String nameData = "";
		nameData +=	"100001/이만수";nameData += "\n";		
		nameData += "100002/이영희";nameData += "\n";
		nameData += "100003/유재석";nameData += "\n";
		nameData += "100004/박명수";nameData += "\n";
		nameData += "100005/김지연";nameData += "\n";
		nameData += "100006/박연미";
		
		String  moneyData = "";
		moneyData += "100001/600";moneyData += "\n";	
		moneyData += "100003/7000";moneyData += "\n";		
		moneyData += "100001/100";moneyData += "\n";		
		moneyData += "100002/400";moneyData += "\n";		
		moneyData += "100001/600";moneyData += "\n";		
		moneyData += "100004/900";moneyData += "\n";		
		moneyData += "100001/130";moneyData += "\n";		
		moneyData += "100003/200";moneyData += "\n";		
		moneyData += "100002/700";moneyData += "\n";	
		moneyData += "100002/900";moneyData += "\n";
		moneyData += "100004/800";
		
		//문제) moneyData 와 nameData 를 조합해서 아래와 같이 만들어 보세요
		//ㄴ userData를 완성할 떄, moneyData 기준 해당 데이터의 주인의 이름을 함께 출력
		
		String userData = "";
		/*
		 *  100001/이만수/600
		 *  100003/유재석/7000
		 *  100001/이만수/100
		 *  100002/이영희/400
		 *  100001/이만수/600
		 *  100004/박명수/900
		 *  100001/이만수/130
		 *  100003/유재석/200
		 *  100002/이영희/700
		 *  100002/이영희/900
		 *  100004/이만수/800
		 */
		String[] nameArr = nameData.split("[/|\\n]");
		String[] moneyArr = moneyData.split("[/|\\n]");
//		System.out.println(Arrays.toString(nameArr));
//		System.out.println(Arrays.toString(moneyArr));
		for(int i=0; i<moneyArr.length; i+=2) {
			
			for(int j=0; j<nameArr.length; j+=2) {
				if(nameArr[j].equals(moneyArr[i])) {
					userData += nameArr[j]+nameArr[j+1]+moneyArr[i+1]+"\n"; 
					System.out.printf("%s/%s/%s \n",nameArr[j],nameArr[j+1],moneyArr[i+1]);
				}
			}
		}
	}

}

package lv05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Ex18 {

	public static void main(String[] args) {
		String[] ids = null;
		String[] pws = null;
		int[] moneys = null;
		
		String fileName ="fileTest02.txt";
		
		FileReader fr = null;
		BufferedReader br = null;
		String data = "";
		String temp = "";
		String[] arr;
		int cnt =0;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			while (true) {
				temp = br.readLine();
				if (temp != null) {
					cnt++;
					data += temp + "/";
				} else {
					break;
				}
			}
			
			arr = data.split("/");
			
			ids = new String[cnt];
			pws = new String[cnt];
			moneys = new int[cnt];
			cnt = 0;
			
			for (int i = 0; i < arr.length; i += 3) {
				ids[cnt] = arr[i];
				pws[cnt] = arr[i + 1];
				moneys[cnt] = Integer.parseInt(arr[i + 2]);
				cnt++;
			}
			
			System.out.println(Arrays.toString(ids));
			System.out.println(Arrays.toString(pws));
			System.out.println(Arrays.toString(moneys));
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

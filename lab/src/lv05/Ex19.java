package lv05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex19 {

	public static void main(String[] args) {
		
		// 파일 디렉토리
		// ㄴ 기본 경로 : 프로젝트 하위에 위치
		// * 변경 가능
		
//		System.out.println(System.getProperty("user.home"));
//		System.out.println(System.getProperty("file.separator"));
//		System.out.println(System.getProperty("os.arch"));
//		System.out.println(System.getProperty("os.name"));
//		System.out.println(System.getProperty("os.version"));
//		System.out.println(System.getProperty("user.dir"));
		
		// 바탕화면(유저 홈 경로 하위에 desktop)에 파일 생성
		// ㄴ /Users/dlstj/desktop/test.txt
		
		String fileName = "test.txt";
		String filePath = System.getProperty("user.home");
		String sep = System.getProperty("file.separator");
		
//		filePath += sep + "desktop" + sep +fileName;
		filePath += sep + "desktop";
		System.out.println(filePath);
		
//		File file = new File(filePath);
		File file = new File(filePath, fileName);
		FileWriter fw = null;
		
		
		try {
			fw = new FileWriter(file);
			fw.write("이인선");
			fw.close();
			System.out.println("파일저장 완료");
		} catch (IOException e) {
			System.out.println("파일저장 실패");
			e.printStackTrace();
		}
	}

}

package main;

import java.util.Scanner;

import dao.AccountDao;
import file.FileProc;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	날짜 
		 	용도
		 	수입/지출
		 	금액
		 	내용
		 	
		 	추가,삭제,검색(용도->제목 / 날짜로검색/ 월별결산 / 기간별 결산 2023.05.31 ~ 2023.06.09),수정(용도,금액,내용),입출력
		 	
		 	File로 저장
		 	Singleton사용
		 	Github로 올리기(압축파일로 업로드)
		 */
		
		Scanner sc = new Scanner(System.in);
		
		AccountDao dao = new AccountDao();
		FileProc fp = new FileProc("accountBook");
		
		fp.read();
		
		boolean ab = true;
		while(ab) {
			System.out.println("----------메뉴를 선택하세요----------");
			System.out.println("1.가계부 추가하기");
			System.out.println("2.가계부 삭제하기");
			System.out.println("3.가계부 검색하기");
			System.out.println("4.가계부 월 합산하기");
			System.out.println("5.가계부 기간별 합산하기");
			System.out.println("6.가계부 수정하기");
			System.out.println("7.가계부 전체보기");
			System.out.println("8.가계부 저장하기");
			System.out.println("9.가계부 종료하기");
			
			
			System.out.println("메뉴 =>> ");
			int menu = sc.nextInt();
			
			switch(menu) {
			
			
			case 1:
				dao.insert();
				break;
			case 2:
				dao.delete();
				break;
			case 3:
				dao.searchUsage();
				break;
			case 4:
				dao.searchMonthly();
				break;
			case 5:
				dao.searchPeriod();
				break;
			case 6:
				dao.update();
				break;
			case 7:
				dao.allPrint();
				break;
			case 8:
				fp.write();
				break;
			case 9:
				System.out.println("시스템을 종료합니다.");
				ab = false;
			}
		}
		

	}

}

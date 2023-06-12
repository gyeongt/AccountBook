package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AccountDto;
import singleton.Singleton;

public class AccountDao {

	private Scanner sc = new Scanner(System.in);
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private List<AccountDto> findUsage = new ArrayList<AccountDto>();
	public AccountDao() {
		
	}
	
	
	public void insert() {
		System.out.println("가계부를 입력합니다.");
		
		System.out.print("용도 = ");
		String usage = "";
		
		try {
			usage = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.print("날짜 = ");
		String date = sc.next();
		
		
		
		System.out.print("수입 = ");
		int income = sc.nextInt();
		
		System.out.print("지출 = ");
		int outcome = sc.nextInt();
		
		System.out.print("금액 = ");
		int amount = sc.nextInt();
		
		System.out.print("내용 = ");
		String detail= "";
		
		try {
			detail = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Singleton s = Singleton.getInstance();
		s.accountBook.add(new AccountDto(usage, date, income, outcome, amount, detail));
	}
		
	
	public void delete() {
		System.out.print("삭제할 용도를 검색합니다 = ");
		String usage = sc.next();
		
		int index = search(usage);
		
		if(index == -1) {
			System.out.println("검색하신 내용을 찾을 수 없습니다.");
		}
		else {
			Singleton s = Singleton.getInstance();
			s.accountBook.remove(index);
			
			System.out.println(usage + "의 내용을 삭제했습니다.");
		}
	}
	
	public void searchUsage() {
		//TODO:searchUsage

			System.out.print("용도를 검색 합니다 = ");
			String usages = sc.next();
			
			Singleton s = Singleton.getInstance();
			
			
			
			for (int i = 0; i < s.accountBook.size(); i++) {
				AccountDto dto = s.accountBook.get(i);
				if(dto.getUsage().contains(usages)) { 
				findUsage.add(dto);
				}
			}
			
			if(findUsage.size() == 0) {
				System.out.println("검색된 내용이 없습니다.");
				return;
			}
			else  {
				System.out.println("검색된 내용입니다.");
				for (int i = 0; i < findUsage.size(); i++) {
					System.out.println(findUsage.toString());
				}
				
			}
	}
			


	public void searchMonthly() {
		
		System.out.print("합산하실 달을 입력하세요  = ");
		String monthly = sc.next();
		
		Singleton s = Singleton.getInstance();
		
		List<AccountDto> findDate = new ArrayList<AccountDto>();
		
		for (int i = 0; i < s.accountBook.size(); i++) {
			AccountDto dto = s.accountBook.get(i);
			if(dto.getDate().contains(monthly)) { 
			findDate.add(dto);
			}
		}
		
		if(findDate.size() == 0) {
			System.out.println("검색된 내용이 없습니다.");
			return;
		}
		else {
			
			int income = 0;
			int incomePlus = 0;
			
			for (int i = 0; i < findDate.size(); i++) {
				income = findDate.get(i).getIncome();
				incomePlus = incomePlus + income;
			}
			
			int outcome = 0;
			int outcomePlus = 0;
			for (int i = 0; i < findDate.size(); i++) {
				outcome = findDate.get(i).getOutcome();
				outcomePlus =  outcomePlus + outcome;
			}
			System.out.println("이달의 수입 합산" + incomePlus);
			
			System.out.println("이달의 지출 합산" + outcomePlus);
			
			System.out.println("이달의 손익 금액" + (incomePlus - outcomePlus));
		}
		
	}
	
public void searchPeriod() {
		
		System.out.print("결산을 시작 할 날짜를 입력해주세요(ex:2023.01.01) = ");
		String start = sc.next();
		
		System.out.print("결산을 끝 낼 날짜를 입력해주세요 (ex:2023.01.31) = ");
		String end = sc.next();
		
		Singleton s = Singleton.getInstance();
		
		List<AccountDto> findperiod = new ArrayList<AccountDto>();
	
		for (int i = 0; i < s.accountBook.size() ; i++) {
			AccountDto dto = s.accountBook.get(i);
			char askii = dto.getDate().charAt(0);
			char askiiStart = start.charAt(0);
			char askiiEnd = end.charAt(0);
			if(askii >= askiiStart && askii <= askiiEnd) { 
			findperiod.add(dto);
			}
			
		}
		
		if(findperiod.size() == 0) {
			System.out.println("검색된 내용이 없습니다.");
			return;
		}
	
		else {
			
			int income = 0;
			int incomePlus = 0;
			
			for (int i = 0; i < findperiod.size(); i++) {
				income = findperiod.get(i).getIncome();
				incomePlus = incomePlus + income;
			}
			
			int outcome = 0;
			int outcomePlus = 0;
			for (int i = 0; i < findperiod.size(); i++) {
				outcome = findperiod.get(i).getOutcome();
				outcomePlus =  outcomePlus + outcome;
			}
			System.out.println("기간 수입 합산" + incomePlus);
			
			System.out.println("기간 지출 합산" + outcomePlus);
			
			System.out.println("기간 손익 금액" + (incomePlus - outcomePlus));
		}
		
	}
	
	
	
	public void update() {
		System.out.println("수정할 용도를 검색하세요.");
		String usage = sc.next();
		
		
		int index = search(usage);
		if(index == -1) {
			System.out.println("용도를 찾을 수 없습니다.");
			return;
		}
		
		System.out.println("용도");
		String usage1 = sc.next();
		
		System.out.println("금액");
		int amount = sc.nextInt();
		
		System.out.println("내용");
		String detail = sc.next();
		
		Singleton s = Singleton.getInstance();
		
		s.accountBook.get(index).setUsage(usage1);
		s.accountBook.get(index).setAmount(amount);
		s.accountBook.get(index).setDetail(detail);
		
		System.out.println("수정을 완료 했습니다.");
		
	}
	public int search(String usage) {
		Singleton s = Singleton.getInstance();
		
		int index = -1;
			
			for (int i = 0; i < s.accountBook.size(); i++) {
				AccountDto dto = s.accountBook.get(i);
				if(dto.getUsage().contains(usage)) { 
				index = i;
				break;
				}
			}
			
		return index;		
	}
		
		
	
	public void allPrint() {
		
		Singleton s = Singleton.getInstance();
		
		if(s.accountBook.isEmpty()) {
			System.out.println("데이터가 없습니다.");
			return;
		}
		
		for(int i = 0; i < s.accountBook.size(); i++) {
			System.out.println(s.accountBook.get(i).toString());
		}
		
	}
	
}

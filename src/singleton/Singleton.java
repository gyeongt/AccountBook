package singleton;

import java.util.ArrayList;
import java.util.List;

import dto.AccountDto;

public class Singleton {

	private static Singleton sc = null;
	
	public List<AccountDto> accountBook = null;
	
	public Singleton() {
		accountBook = new ArrayList<AccountDto>();
		
	}
	
	public static Singleton getInstance() {
		if(sc == null) {
			sc = new Singleton();
		}
		return sc;
	}
}

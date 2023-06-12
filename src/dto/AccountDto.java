package dto;

public class AccountDto {

	private String usage;
	private String date;
	private int income;
	private int outcome;
	private int amount;
	private String detail;
	
	public AccountDto() {
		
	}
	
	
	public AccountDto(String usage, String date, int income, int outcome, int amount, String detail) {
		super();
		this.usage = usage;
		this.date = date;
		this.income = income;
		this.outcome = outcome;
		this.amount = amount;
		this.detail = detail;
	}


	public String getUsage() {
		return usage;
	}


	public void setUsage(String usage) {
		this.usage = usage;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getIncome() {
		return income;
	}


	public void setIncome(int income) {
		this.income = income;
	}


	public int getOutcome() {
		return outcome;
	}


	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	@Override
	public String toString() {
		return "가계부 [용도 =" + usage + ", 날짜 =" + date + ", 수입 =" + income + ", 지출 =" + outcome
				+ ", 금액 =" + amount + ", 내용 =" + detail + "]";
	}
	
	
	public String print() {
		return  usage + "\\t" + date + "\\t" + income + "\\t" + outcome + "\\t" + amount + "\\t" + detail;
	}
	
	

	
	
	
	
}

package Entity;
import Exception.AccountException;
import Exception.DepositException;
import Exception.MinusWithdrawException;
import Exception.WithdrawException;

public class Account implements Cloneable
{
	private int accID;
	private int accPW;
	private int balance;
	private String name;
	private int index;
	
	public Account(int id,int bal,int pw,String name,int ind)
	{
		this.accID = id;
		this.accPW = pw;
		this.balance = bal;
		this.name = name;
		this.setIndex(ind);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Account) (super.clone());
	}
	/**
	 * @return the accID
	 */
	public int getAccID() {
		return accID;
	}
	

	/**
	 * @return the accPW
	 */
	public int getAccPW() {
		return accPW;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}
	

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void Deposit(int money) throws AccountException 
	{
		if(money < 0)
			throw new DepositException(money);
		
		balance += money;
	}
	
	public int Withdraw(int money) throws AccountException
	{
		if(balance < money)
			throw new MinusWithdrawException(money);
		
		if(money < 0)
			throw new WithdrawException(money);
			
		balance -= money;
		return balance;	
	}
	
	public void ShowInfo() {
		System.out.println("���� ID: " + accID);
		System.out.println("�̸�: " + name);
		System.out.println("�ܾ�: " + balance);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}

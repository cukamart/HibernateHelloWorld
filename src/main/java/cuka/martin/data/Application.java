package cuka.martin.data;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cuka.martin.data.doa.BankDao;
import entities.Account;
import entities.Address;
import entities.Bank;
import entities.Bond;
import entities.Credential;
import entities.Stock;
import entities.Transaction;
import entities.User;

public class Application {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			BankDao dao = new BankDao();
			dao.setSession(session);

			tx = session.beginTransaction();

			Bank bank= createBank();

			//dao.save(bank);
			System.out.println("SOM TU " +dao.findById(4L).getName());

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	private static Bond createBond() {
		Bond bond = new Bond();
		bond.setInterestRate(new BigDecimal("666.66"));
		bond.setIssuer("MOJA");
		bond.setMaturityDate(new Date());
		bond.setPurchaseDate(new Date());
		bond.setName("MOJA");
		bond.setValue(new BigDecimal("6.66"));
		return bond;
	}

	private static Stock createStock() {
		Stock stock = new Stock();
		stock.setIssuer("TVOJA");
		stock.setName("TVOJA");
		stock.setPurchaseDate(new Date());
		stock.setQuantity(new BigDecimal("666"));
		stock.setSharePrice(new BigDecimal("666.00"));
		return stock;
	}

	private static Bank createBank() {
		Bank bank = new Bank();
		bank.setName("First United Federal");
		bank.setAddressLine1("103 Washington Plaza");
		bank.setAddressLine2("Suite 332");
		bank.getAddress().setAddressType("PRIMARY");
		bank.setCity("New York");
		bank.setCreatedBy("Kevin Bowersox");
		bank.setCreatedDate(new Date());
		bank.setInternational(false);
		bank.setLastUpdatedBy("Kevin Bowersox");
		bank.setLastUpdatedDate(new Date());
		bank.setState("NY");
		bank.setZipCode("10000");
		return bank;
	}

	private static Credential createCredential(User user) {
		Credential credential = new Credential();
		credential.setUser(user);
		credential.setUsername("test_username");
		credential.setPassword("test_password");
		return credential;
	}

	private static Address createAddress() {
		Address address = new Address();
		address.setAddressLine1("101 Address Line");
		address.setAddressLine2("102 Address Line");
		address.setCity("New York");
		address.setState("PA");
		address.setZipCode("10000");
		address.setAddressType("PRIMARY");
		return address;
	}

	private static Transaction createNewBeltPurchase(Account account) {
		Transaction beltPurchase = new Transaction();
		beltPurchase.setAccount(account);
		beltPurchase.setTitle("Dress Belt");
		beltPurchase.setAmount(new BigDecimal("50.00"));
		beltPurchase.setClosingBalance(new BigDecimal("0.00"));
		beltPurchase.setCreatedBy("Kevin Bowersox");
		beltPurchase.setCreatedDate(new Date());
		beltPurchase.setInitialBalance(new BigDecimal("0.00"));
		beltPurchase.setLastUpdatedBy("Kevin Bowersox");
		beltPurchase.setLastUpdatedDate(new Date());
		beltPurchase.setNotes("New Dress Belt");
		beltPurchase.setTransactionType("Debit");
		return beltPurchase;
	}

	private static Transaction createShoePurchase(Account account) {
		Transaction shoePurchase = new Transaction();
		shoePurchase.setAccount(account);
		shoePurchase.setTitle("Work Shoes");
		shoePurchase.setAmount(new BigDecimal("100.00"));
		shoePurchase.setClosingBalance(new BigDecimal("0.00"));
		shoePurchase.setCreatedBy("Kevin Bowersox");
		shoePurchase.setCreatedDate(new Date());
		shoePurchase.setInitialBalance(new BigDecimal("0.00"));
		shoePurchase.setLastUpdatedBy("Kevin Bowersox");
		shoePurchase.setLastUpdatedDate(new Date());
		shoePurchase.setNotes("Nice Pair of Shoes");
		shoePurchase.setTransactionType("Debit");
		return shoePurchase;
	}

	private static Account createNewAccount() {
		Account account = new Account();
		account.setCloseDate(new Date());
		account.setOpenDate(new Date());
		account.setCreatedBy("Kevin Bowersox");
		account.setInitialBalance(new BigDecimal("50.00"));
		account.setName("Savings Account");
		account.setCurrentBalance(new BigDecimal("100.00"));
		account.setLastUpdatedBy("Kevin Bowersox");
		account.setLastUpdatedDate(new Date());
		account.setCreatedDate(new Date());
		return account;
	}

}

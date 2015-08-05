package cuka.martin.data;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Address;
import entities.Bank;
import entities.TimeTest;
import entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Bank bank = new Bank();
		// user(session);
		// timeTest(session);
		// userFormula(session);
		bankCompositeType(session);
		// userWithAddressComposite(session);
		
		transaction.commit();

		session.close();
	}

	private static void userWithAddressComposite(Session session) {
		User user = new User();
		Address address = new Address();
		user.setAge(22);
		user.setBirthDate(new Date());
		user.setCreatedBy("Kevin");
		user.setCreatedDate(new Date());
		user.setEmailAddress("kmb3");
		user.setFirstName("kevin");
		user.setLastName("bowersox");
		user.setLastUpdatedby("kmb");
		user.setLastUpdatedDate(new Date());

		address.setAddressLine1("line 1");
		address.setAddressLine2("line2");
		address.setCity("Philadelphia");
		address.setState("PA");
		address.setZipCode("12345");

		user.setAddress(address);
		session.save(user);
	}

	private static void bankCompositeType(Session session) {
		Bank bank = new Bank();
		bank.setName("Federal Trust");
		bank.setAddressLine1("33 Wall Street");
		bank.setAddressLine2("Suite 302");
		bank.setCity("New York");
		bank.setState("NY");
		bank.setZipCode("27914");
		bank.setCreatedBy("Kevin BowerSox");
		bank.setCreatedDate(new Date());
		bank.setLastUpdatedBy("Kevin BowerSox");
		bank.setLastUpdatedDate(new Date());
		bank.setInternational(false);
		bank.getContacts().put("MANAGER", "Joe");
		bank.getContacts().put("TELLER", "Marry");
		session.save(bank);
	}

	private static void userFormula(Session session) {
		User user = new User();
		user.setBirthDate(getMyBirthday());
		user.setCreatedBy("Martin");
		user.setCreatedDate(new Date());
		user.setEmailAddress("cuk@gmail.com");
		user.setFirstName("Martin");
		user.setLastName("Cuka");
		user.setLastUpdatedby("MartinCuk");
		user.setLastUpdatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();

		session.refresh(user); // @Formula funguje az po SELECT refresh je
								// vlastne SELECT...

		System.out.println(user.getAge());
	}

	private static void timeTest(Session session) {
		TimeTest test = new TimeTest(new Date());
		session.save(test);
		session.getTransaction().commit();

		session.refresh(test);

		System.out.println(test.toString());
	}

	private static void user(Session session) {
		User user = new User();
		user.setBirthDate(new Date());
		user.setCreatedBy("Martin");
		user.setCreatedDate(new Date());
		user.setEmailAddress("cuk@gmail.com");
		user.setFirstName("Martin");
		user.setLastName("Cuka");
		user.setLastUpdatedby("MartinCuk");
		user.setLastUpdatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();

		session.beginTransaction();
		User dbUser = (User) session.get(User.class, user.getUserId());

		dbUser.setFirstName("John");
		session.update(dbUser);
		session.getTransaction().commit();
	}

	private static Date getMyBirthday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1992);
		calendar.set(Calendar.MONTH, 10);
		calendar.set(Calendar.DATE, 22);

		return calendar.getTime();
	}
}

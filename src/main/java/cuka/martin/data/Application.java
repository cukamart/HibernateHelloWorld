package cuka.martin.data;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Address;
import entities.Bank;
import entities.Credential;
import entities.TimeTest;
import entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();

			User user = new User();
			setUserFields(user);
			
			Credential credential = new Credential();
			credential.setPassword("letmein");
			credential.setUsername("John");
			
			credential.setUser(user);
			user.setCredential(credential);
			
			session.save(credential); // kedze v credential mam cascade nastaveny ulozi aj usera ;)
			transaction.commit();
			
			User dbUser = (User)session.get(User.class, credential.getUser().getUserId());
			System.out.println(dbUser.getFirstName());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	private static void setAddressFields(Address address) {
		address.setAddressLine1("line 1");
		address.setAddressLine2("line2");
		address.setCity("Philadelphia");
		address.setState("PA");
		address.setZipCode("12345");
	}
	
	private static void setAddressFields2(Address address) {
		address.setAddressLine1("line 3");
		address.setAddressLine2("line 4");
		address.setCity("Philadelphia");
		address.setState("PA");
		address.setZipCode("12345");
	}

	private static void setUserFields(User user) {
		user.setAge(22);
		user.setBirthDate(new Date());
		user.setCreatedBy("Kevin");
		user.setCreatedDate(new Date());
		user.setEmailAddress("kmb3");
		user.setFirstName("kevin");
		user.setLastName("bowersox");
		user.setLastUpdatedby("kmb");
		user.setLastUpdatedDate(new Date());
	}
}

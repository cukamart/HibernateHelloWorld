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
		try {
			Transaction transaction = session.beginTransaction();

			User user = new User();
			Address address = new Address();
			Address address2 = new Address();

			setAddressFields(address);
			setAddressFields2(address2);
			
			user.getAddress().add(address);
			user.getAddress().add(address2);
			setUserFields(user);
			
			session.save(user);
			transaction.commit();

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

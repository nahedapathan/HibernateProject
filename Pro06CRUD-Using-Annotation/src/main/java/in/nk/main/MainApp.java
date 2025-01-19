package in.nk.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.nk.model.User;

public class MainApp {
	public static void main(String[] args) {

		//Step 1: Set up hibernate and get a session Factory
		SessionFactory sessionfactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		//Step 2:Adding a User
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		System.out.println("Connection Success!");
		
		User newUser=new User();
		newUser.setId(1);
		newUser.setName("naheda");
		newUser.setEmail("nk@gmail.com");
		
		session.save(newUser);
		session.getTransaction().commit();
		session.close();
		System.out.println("User has been added in to the database");
		
		//Step 3:Retrieve data User on bassis of id
		session=sessionfactory.openSession();
		session.beginTransaction();
		
		User retrieveUser=session.get(User.class,1);
		if(retrieveUser!=null)
		{
			System.out.println("Retrieved User Details"+retrieveUser.getId()+" "+retrieveUser.getName()+" "+retrieveUser.getEmail());
			
		}
		else
		{
			System.out.println("User not found");
		}
		
		session.getTransaction().commit();
		session.close();
		
		
		//Step 4:Update the User by Id
		session=sessionfactory.openSession();
		session.beginTransaction();
		
		User updateUser=session.get(User.class, 1);
		if(updateUser!=null)
		{
			updateUser.setName("Rajesh Khana");
			System.out.println("Data Updated Successfully");
		}
		else
		{
			System.out.println("User not found for Updating");
		}
		session.getTransaction().commit();
		session.close();
		
		
		//Step 5:Delete Data from User
		session=sessionfactory.openSession();
		session.beginTransaction();
		User deleteUser=session.get(User.class, 1);
		if(deleteUser!=null)
		{
			session.delete(deleteUser);
			System.out.println("User Deleted Successfully");
		}
		else
		{
			System.out.println("User not found ");
		}
		session.getTransaction().commit();
		session.close();
	}
}

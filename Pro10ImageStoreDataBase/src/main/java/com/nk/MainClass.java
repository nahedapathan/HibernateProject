package com.nk;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) throws IOException {
		System.out.println("Project Started...........");
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		//Creating Address Object
		Address ad=new Address();
		ad.setStreet("street1");
		ad.setCity("Delhi");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1234.321);
		
		//Reading image
		FileInputStream fis=new FileInputStream("src/main/java/pic.png");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		
		session.save(ad);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done...........");
	}
	
}

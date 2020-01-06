package com.joydeep.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.joydeep.hibernate.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        for(int i=0;i<=18;i++)
        {
        	UserDetails temp=new UserDetails();
        	temp.setUserName("UserName "+i);
        	temp.setJoinedDate(new Date());
            temp.setAddress("Address "+i);
            temp.setDescription("Description "+i);
            session.save(temp);
        }
        
        UserDetails sixthUser=session.get(UserDetails.class,6);
        sixthUser.setUserName("Updated username");
       session.update(sixthUser);
       
        session.delete(sixthUser);
        
        session.getTransaction().commit();
        session.close();
	}

}

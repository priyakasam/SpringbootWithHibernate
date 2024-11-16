package in.priya.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.priya.main.entities.User;

@SpringBootApplication
public class SpringbootWithHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithHibernateApplication.class, args);
		Configuration config=new Configuration();
		config.configure("/in/priya/main/config/hibernate.cfg.xml");
		SessionFactory sf=config.buildSessionFactory();
		Session ss=sf.openSession();
//		Transaction ts=ss.beginTransaction();
//		
		try {
			User user=ss.get(User.class,4L);
			if(user!=null)
			{
				System.out.println(user.getCity());
				System.out.println(user.getEmail());
				
				
			}
			else
			{
				System.out.println("User not found");
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}

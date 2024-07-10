package pack;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Main {
	public static void main(String[] args) {
		// join
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		try {
			//JPQL 사용
			String jpql = "select j.jikwonNo,j.jikwonName,b.buserName,j.jikwonIbsail " +
							"from Jikwon j join j.buser b";
			
			TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
			List<Object[]> results = query.getResultList();
			// Hibernate: select j.jikwonNo,j.jikwonName,b.buserName,j.jikwonIbsail from Jikwon j join j.buser b  
			// select jikwon0_.jikwon_no as col_0_0_, jikwon0_.jikwon_name as col_1_0_, buser1_.buser_name as col_2_0_, jikwon0_.jikwon_ibsail as col_3_0_ from jikwon jikwon0_ inner join buser buser1_ on jikwon0_.buser_num=buser1_.buser_no

			for(Object[] result:results) {
				int year = getYearMy((Date)result[3]);
				System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + year);
			}
			
			System.out.println("------------");
			//Native SQL 사용
			String sql = "select jikwon_no,jikwon_name,buser_name,year(jikwon_ibsail) " +
							"from jikwon join buser on buser_num=buser_no";
			Query query2 = em.createNativeQuery(sql);
			List<Object[]> results2 = query2.getResultList();
			
			for(Object[] result:results2) {
				System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3] );
			}
		} catch (Exception e) {
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close();
		}
	}
	
	private static int getYearMy(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
}

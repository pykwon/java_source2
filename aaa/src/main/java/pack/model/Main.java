package pack.model;

import javax.persistence.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        
        try {
        	// em.getTransaction().begin();
        	
            // JPQL 쿼리 작성
            String jpql = "SELECT j.jikwonNo, j.jikwonName, b.buserName, j.jikwonIbsail " +
                          "FROM Jikwon j JOIN j.buser b";

            // 쿼리 실행
            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            List<Object[]> results = query.getResultList();

            // 결과 출력 : 칼럼명을 사용하려면 Tuple 사용해 별명을 줘야 함.
            for (Object[] result : results) {
                int year = getYear((Date) result[3]);
                System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + year);
            }

            System.out.println("\n---네이티브 SQL 쿼리 작성----------");
            String sql = "SELECT jikwon_no, jikwon_name, buser_name, YEAR(jikwon_ibsail) " +
                         "FROM jikwon JOIN buser ON buser_num = buser_no";

            Query query2 = em.createNativeQuery(sql);
            List<Object[]> results2 = query2.getResultList();

            for (Object[] result : results2) {
                System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
            }
            
            // em.getTransaction().commit();
        } catch (Exception e) {
        	// EntityManager 인스턴스에서 관리 중인 트랜잭션이 활성화되어 있는지 여부를 확인
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    // 년도를 추출하는 헬퍼 메서드
    private static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }
}
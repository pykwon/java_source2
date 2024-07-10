package pack.model;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import pack.mybatis.SqlMapConfig;

@Repository
public class Jikwon_Impl implements Jikwon_Inter {
    private SqlSessionFactory sessionFactory = SqlMapConfig.getSqlSession();

    @Override
    public List<JikwonDTO> selectDataAll() {
        SqlSession sqlSession = sessionFactory.openSession();
        List<JikwonDTO> list = null; 
        
        try {
            SqlMapper_Inter mapper = sqlSession.getMapper(SqlMapper_Inter.class);
            list = mapper.selectDataAll();
        } catch (Exception e) {
            System.out.println("selectDataAll error : " + e);
        } finally {
            if(sqlSession != null) sqlSession.close();
        }
        
        return list;
    }

    @Override
    public int getBuserCount(String buserNum) {
        SqlSession sqlSession = sessionFactory.openSession();
        int count = 0;

        try {
            SqlMapper_Inter mapper = sqlSession.getMapper(SqlMapper_Inter.class);
            count = mapper.buserCount(buserNum);
        } catch (Exception e) {
            System.out.println("getBuserCount error : " + e);
        } finally {
            if(sqlSession != null) sqlSession.close();
        }

        return count;
    }

    @Override
    public JikwonDTO getHighestPay(String buserNum) {
        SqlSession sqlSession = sessionFactory.openSession();
        JikwonDTO highestPaid = null;

        try {
            SqlMapper_Inter mapper = sqlSession.getMapper(SqlMapper_Inter.class);
            highestPaid = mapper.getHightPay(buserNum);
        } catch (Exception e) {
            System.out.println("getHighestPay error : " + e);
        } finally {
            if(sqlSession != null) sqlSession.close();
        }

        return highestPaid;
    }
}
package pack.model;
import java.util.List;

public interface Jikwon_Inter {
    List<JikwonDTO> selectDataAll();
    int getBuserCount(String buserNum);
    JikwonDTO getHighestPay(String buserNum);
}
package pack.model;

import java.sql.Date;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "jikwon")
public class Jikwon {
    @Id
    @Column(name = "jikwon_no")
    private int jikwonNo;

    @Column(name = "jikwon_name")
    private String jikwonName;

    @ManyToOne
    @JoinColumn(name = "buser_num", referencedColumnName = "buser_no")
    private Buser buser;

    @Column(name = "jikwon_ibsail")
    private Date jikwonIbsail;

}
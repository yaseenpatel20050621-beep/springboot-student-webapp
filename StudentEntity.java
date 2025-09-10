package Student.Management.System.Student.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "division" , nullable = false)

    private String div;
    @Column(name = "roll_no" , nullable = false)

    private String rollNo;
    @Column(name = "email" , nullable = false)

    private String emails;
}

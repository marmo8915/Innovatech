import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}

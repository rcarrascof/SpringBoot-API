package RcxDev.example.superPos.Repository;
import RcxDev.example.superPos.Entities.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface loginRepository  extends JpaRepository<users, Long> {


    @Query("Select u from users u where u.email=?1 and u.password=?2")
    public users findUser(String email, String Password);

}

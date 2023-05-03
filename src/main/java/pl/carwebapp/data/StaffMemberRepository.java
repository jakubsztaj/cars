package pl.carwebapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.StaffMember;

import java.util.Optional;

@Repository
public interface StaffMemberRepository extends JpaRepository<StaffMember, Long> {

    Optional<StaffMember> findById(String id);
    Optional<StaffMember> findByUsername(String username);
    Optional<StaffMember> findByPassword(String password);
}

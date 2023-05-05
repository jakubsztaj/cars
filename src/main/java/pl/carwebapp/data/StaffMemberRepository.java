package pl.carwebapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.StaffMember;

import java.util.Optional;

@Repository
public interface StaffMemberRepository extends JpaRepository<StaffMember, Long> {
    Optional<StaffMember> findByStaffMemberId(Long staffMemberId);
    Optional<StaffMember> findByLogin(String login);
    Optional<StaffMember> findByPassword(String password);
    Optional<StaffMember> findByPesel(String pesel);

}

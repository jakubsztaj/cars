package pl.carwebapp.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Renter;
import pl.carwebapp.model.StaffMember;

import java.util.Optional;

@Repository
public interface StaffMemberRepository extends MongoRepository<StaffMember, String> {

    Optional<StaffMember> findByStaffId(String staffId);
    Optional<StaffMember> findByUsername(String username);
}

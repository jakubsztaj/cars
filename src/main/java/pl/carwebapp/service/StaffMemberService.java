package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.StaffMemberRepository;
import pl.carwebapp.model.StaffMember;


import java.util.List;

@Service
public class StaffMemberService {

    StaffMemberRepository staffMemberRepository;

    public StaffMemberService(StaffMemberRepository staffMemberRepository) {
        this.staffMemberRepository = staffMemberRepository;
    }

    public List<StaffMember> getAllStaffMembers() {
        return staffMemberRepository.findAll();
    }

    public void addStaff(String username, String password) {
        staffMemberRepository.save(new StaffMember(username, password));
    }

    public void deleteStaffMember(String staffId) {
        staffMemberRepository.findByStaffId(staffId).ifPresent(staffMember -> {
            if (staffMember.getStaffId().equalsIgnoreCase(staffId)) {
                staffMemberRepository.delete(staffMember);
            }
        });
    }

    public void deleteAllStaffMembers() {
        staffMemberRepository.deleteAll();
    }

}

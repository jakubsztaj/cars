package pl.carwebapp.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.carwebapp.data.StaffMemberRepository;
import pl.carwebapp.model.StaffMember;


import java.util.List;
import java.util.Optional;

@Service
public class StaffMemberService {

    StaffMemberRepository staffMemberRepository;

    public StaffMemberService(StaffMemberRepository staffMemberRepository) {
        this.staffMemberRepository = staffMemberRepository;
    }

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String password = bCryptPasswordEncoder.encode("ababbaba");

    public String getPassword() {
        return password;
    }

    public List<StaffMember> getAllStaffMembers() {
        return staffMemberRepository.findAll();
    }


    public Optional<StaffMember> getStaffMemberByLogin(String username) {
        return staffMemberRepository.findByUsername(username);
    }

    public void addStaff(String username, String password) {
        staffMemberRepository.save(new StaffMember(username, password));
    }

    public void deleteStaffMember(Long id) {
        staffMemberRepository.findById(id).ifPresent(staffMember -> {
            if (staffMember.getId().equals(id)) {
                staffMemberRepository.delete(staffMember);
            }
        });
    }

    public void deleteAllStaffMembers() {
        staffMemberRepository.deleteAll();
    }

    public boolean checkStaffPassword(StaffMember staffMember, String password) {
        return BCrypt.checkpw(password, staffMember.getPassword());
    }
}
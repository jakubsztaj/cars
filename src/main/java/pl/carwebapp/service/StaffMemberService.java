package pl.carwebapp.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.carwebapp.data.StaffMemberRepository;
import pl.carwebapp.model.StaffMember;
import pl.carwebapp.util.DataGenerator;


import java.util.List;
import java.util.Optional;

@Service
public class StaffMemberService {

    StaffMemberRepository staffMemberRepository;

    public StaffMemberService(StaffMemberRepository staffMemberRepository) {
        this.staffMemberRepository = staffMemberRepository;
    }

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String password = bCryptPasswordEncoder.encode("abc");

    public String getPassword() {
        return password;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<StaffMember> getAllStaffMembers() {
        return staffMemberRepository.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public StaffMember getStaffByPesel(String pesel) {
        return staffMemberRepository.findByPesel(pesel).orElseThrow(IllegalStateException::new);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public StaffMember getStaffMemberByLogin(String login) {
        return staffMemberRepository.findByLogin(login).orElseThrow(IllegalStateException::new);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addStaff(String firstName, String lastName, String placeOfResidence, String login, String password) {
        staffMemberRepository.save(new StaffMember(firstName, lastName, placeOfResidence, DataGenerator.randomPersonalIdNumber(), DataGenerator.randomPhoneNumber(), login, password));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteStaffMember(Long id) {
        staffMemberRepository.findById(id).ifPresent(staffMember -> {
            if (staffMember.getStaffMemberId().equals(id)) {
                staffMemberRepository.delete(staffMember);
            }
        });
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteAllStaffMembers() {
        staffMemberRepository.deleteAll();
    }

    public boolean checkStaffPassword(StaffMember staffMember, String password) {
        return BCrypt.checkpw(password, staffMember.getPassword());
    }
}

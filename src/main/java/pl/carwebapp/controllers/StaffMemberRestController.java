package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.StaffMemberDto;
import pl.carwebapp.model.StaffMember;
import pl.carwebapp.service.StaffMemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffMemberRestController {

    StaffMemberService staffMemberService;

    public StaffMemberRestController(StaffMemberService staffMemberService) {
        this.staffMemberService = staffMemberService;
    }

    @GetMapping
    public List<StaffMember> returnStaff() {
        return staffMemberService.getAllStaffMembers();
    }

    @PostMapping("/add")
    void addStaffDto(@RequestBody StaffMemberDto staffMemberDto) {
        staffMemberService.addStaff(staffMemberDto.getStaffMemberRole());
    }

    @DeleteMapping("/delete/{staffId}")
    void deleteByStaffId(@PathVariable Long staffId) {
        staffMemberService.deleteStaffMember(staffId);
    }

    @DeleteMapping("/delete")
    void delete() {
        staffMemberService.deleteAllStaffMembers();
    }

    @GetMapping("/{username}/{password}")
    boolean checkPassword(@PathVariable String username, @PathVariable String password) {
        Optional<StaffMember> optionalStaffMember = staffMemberService.getStaffMemberByLogin(username);
        if (optionalStaffMember.isPresent()) {
            StaffMember staffMember = optionalStaffMember.get();
            return staffMemberService.checkStaffPassword(staffMember, password);
        } else {
            return false;
        }
    }
}

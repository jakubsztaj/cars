package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.StaffMemberDto;
import pl.carwebapp.model.Rental;
import pl.carwebapp.model.StaffMember;
import pl.carwebapp.service.StaffMemberService;

import java.util.List;

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
        staffMemberService.addStaff(staffMemberDto.getUsername(),staffMemberDto.getPassword());
    }

    @DeleteMapping("/delete/{staffId}")
    void deleteByStaffId(@PathVariable String staffId) {
        staffMemberService.deleteStaffMember(staffId);
    }

    @DeleteMapping("/delete")
    void delete() {
        staffMemberService.deleteAllStaffMembers();
    }
}

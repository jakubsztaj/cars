package pl.carwebapp.controller;

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

    @GetMapping("/load/staff/{pesel}")
    public StaffMember loadStaffMemberByPesel(@PathVariable String pesel) {
        return staffMemberService.getStaffByPesel(pesel);
    }

    @PostMapping("/add")
    void addStaffDto(@RequestBody StaffMemberDto staffMemberDto) {
        staffMemberService.addStaff(staffMemberDto.getFirstName(), staffMemberDto.getLastName(), staffMemberDto.getPlaceOfResidence(), staffMemberDto.getLogin(), staffMemberDto.getPassword());
    }

    @DeleteMapping("/delete/{staffId}")
    void deleteByStaffId(@PathVariable Long staffId) {
        staffMemberService.deleteStaffMember(staffId);
    }

    @DeleteMapping("/delete")
    void delete() {
        staffMemberService.deleteAllStaffMembers();
    }

    @GetMapping("/{login}/{password}")
    boolean checkPassword(@PathVariable String login, @PathVariable String password) {
        Optional<StaffMember> optionalStaffMember = Optional.ofNullable(staffMemberService.getStaffMemberByLogin(login));
        if (optionalStaffMember.isPresent()) {
            StaffMember staffMember = optionalStaffMember.get();
            return staffMemberService.checkStaffPassword(staffMember, password);
        } else {
            return false;
        }
    }
}

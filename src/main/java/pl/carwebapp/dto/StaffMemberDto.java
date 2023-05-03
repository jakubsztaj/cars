package pl.carwebapp.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StaffMemberDto {

     BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
     private String password = bCryptPasswordEncoder.encode("eee");

    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password = bCryptPasswordEncoder.encode("ddd");
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

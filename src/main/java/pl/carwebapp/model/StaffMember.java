package pl.carwebapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;


@Document
public class StaffMember extends AbstractUser implements Serializable {

    @Id
    protected String staffId;

    public StaffMember(String username, String password) {
        super(username, password);
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}

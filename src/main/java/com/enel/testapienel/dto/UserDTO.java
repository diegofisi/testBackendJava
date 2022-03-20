package com.enel.testapienel.dto;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Schema(description = "Paciente DTO Data")
public class UserDTO {

    private Integer id;

    @Schema(description = "nombres del paciente")
    @NotEmpty
    @Size(min = 3, message = "{nombres.size}")
    private String firstName;

    @Schema(description = "apellidos del paciente")
    @NotNull
    @Size(min = 3, message = "{apellidos.size}")
    private String lastName;

    @Email
    private String emailId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}

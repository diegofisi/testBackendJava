package com.enel.testapienel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Useru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombres", nullable = false, length = 70)
    private String firstName;

    @Column(name="apellidos", nullable = false, length = 70)
    private String lastName;

    @Column(name="email", nullable = false, length = 55)
    private String emailID;

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

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
}



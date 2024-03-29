package com.itra.course.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class RegisterForm {

    @Size(min=4, max=32)
    @NotEmpty(message = "Field cannot be empty")
    private String username;

    @Email
    private String email;

    @Size(min = 4, max = 32)
    @NotEmpty(message = "Field cannot be empty")
    private String password;

    @Size(min=4, max=32)
    @NotEmpty(message = "Field cannot be empty")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

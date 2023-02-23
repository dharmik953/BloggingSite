package com.training.bloggingsite.dtos;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private static final String passwordErrorMessage = """
            Password must be at least 8 characters and at most 20 characters,
            contains at least one digit,
            contains at least one upper case alphabet,
            contains at least one lower case alphabet,
            contains at least one special character which includes (@ $ %).""";

    private static final String emailRegx = "^[a-zA-Z0-9_\\.\\-]+\\@[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,4}$";
    private static final String passwordRegx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\$\\@\\%]).{8,20}$";

    private long id;

    @NotBlank(message = "\nFull Name cannot be Blank !!")
    @Size(min=5,message = "\nPlease enter a valid Full Name !!")
    private String name;

    @NotBlank(message = "\nEmail cannot be Blank !!")
    @Pattern(regexp = emailRegx ,message = "\nPlease enter a valid Email !!")
    private String email;

    @NotBlank(message = "\nPassword cannot be Blank !!")
    @Pattern(regexp = passwordRegx, message = passwordErrorMessage)
    private String password;

}

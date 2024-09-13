package br.com.mvc.projectmvc.dto;

import br.com.mvc.projectmvc.enuns.Role;
import br.com.mvc.projectmvc.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column; 

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CadastroDto {

    @NotBlank
    @Column(unique = true)
    private String username;
    @NotBlank
    private String password;
    @NotNull
    private Role role;

    public User toUser(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        return user;
    }
}

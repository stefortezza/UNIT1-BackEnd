package it.epicode.Lezione.controller;

import it.epicode.Lezione.DTO.UserDto;
import it.epicode.Lezione.DTO.UserLoginDto;
import it.epicode.Lezione.exception.BadRequestException;
import it.epicode.Lezione.service.AuthService;
import it.epicode.Lezione.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    public UserService userService;

    @PostMapping("/auth/register")
    public String registerUsers(@RequestBody @Validated UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }

        return userService.saveUser(userDto);
    }

    @PostMapping("/auth/login")
    public String loginUser(@RequestBody @Validated UserLoginDto userLoginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return authService.authenticateUserAndCreateToken(userLoginDto);
    }
}

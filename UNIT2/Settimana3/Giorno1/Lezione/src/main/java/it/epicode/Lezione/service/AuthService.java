package it.epicode.Lezione.service;

import it.epicode.Lezione.DTO.UserLoginDto;
import it.epicode.Lezione.entity.User;
import it.epicode.Lezione.exception.UnauthorizedException;
import it.epicode.Lezione.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTool jwtTool;

    public String authenticateUserAndCreateToken(UserLoginDto userLoginDto) {
        User user = userService.getUserByEmail(userLoginDto.getEmail());

        if (user.getPassword().equals(userLoginDto.getPassword())) {
            return jwtTool.createToken(user);
        } else {
            throw new UnauthorizedException("Error in authorization, relogin!");
        }
    }
}

package it.epicode.GestioneEventi.Service;

import it.epicode.GestioneEventi.DTO.UserLoginDto;
import it.epicode.GestioneEventi.Entity.Utente;
import it.epicode.GestioneEventi.Exception.UnauthorizedException;
import it.epicode.GestioneEventi.Security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUserAndCreateToken(UserLoginDto userLoginDto) {
        Utente utente = utenteService.getUserByEmail(userLoginDto.getEmail());

        if (passwordEncoder.matches(userLoginDto.getPassword(), utente.getPassword())) {
            return jwtTool.createToken(utente);
        } else {
            throw new UnauthorizedException("Error in authorization, relogin!");
        }
    }
}

package it.epicode.GestioneEventi.Controller;

import it.epicode.GestioneEventi.DTO.UserLoginDto;
import it.epicode.GestioneEventi.DTO.UtenteDto;
import it.epicode.GestioneEventi.Exception.BadRequestException;
import it.epicode.GestioneEventi.Service.AuthService;
import it.epicode.GestioneEventi.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/auth/register")
    public String register(@RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).reduce("",(s, s2) -> s+s2));
        }
        return utenteService.saveUser(utenteDto);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated UserLoginDto userLoginDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).reduce("",(s, s2) -> s+s2));
        }
        return authService.authenticateUserAndCreateToken(userLoginDto);
    }
}

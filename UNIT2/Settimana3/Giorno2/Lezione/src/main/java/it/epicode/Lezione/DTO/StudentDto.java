package it.epicode.Lezione.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {
    @NotBlank (message = "Name can't be empty or null or only space!")
    private String name;
    @NotBlank (message = "Surname can't be empty or null or only space!")
    private String surname;
    @NotNull(message = "BirthDate can't be empty or null or only space!")
    private LocalDate birthDate;
}

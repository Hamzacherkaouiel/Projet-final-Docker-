package projet.docker.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOStudent {
    private Long id_student;
    private String nom;
    private LocalDate date;
    //private List<DTONote> Notes;
    private double Moyen;
}

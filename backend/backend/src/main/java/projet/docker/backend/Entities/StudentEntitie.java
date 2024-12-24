package projet.docker.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntitie {
    @Id
    @GeneratedValue
    @Column(name = "id_student")
    private Long id;
    @Column(name = "Name",nullable = false)
    private String name;
    @Column(name = "DateofCreation")
    private LocalDate date;
    @OneToMany(mappedBy = "student")
    List<NoteEntity> Notes;
    // prototype pattern
    public StudentEntitie Clone(){
        StudentEntitie SE=new StudentEntitie();
        SE.setId(this.getId());
        SE.setName(this.getName());
        SE.setDate(this.getDate());
        SE.setNotes(this.getNotes());
        return SE;
    }


}

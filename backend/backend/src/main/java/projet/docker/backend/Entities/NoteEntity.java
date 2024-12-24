package projet.docker.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteEntity {
    @Id
    @GeneratedValue
    @Column(name = "id_note")
    private  Long id;
    @Column(name="NomNote")
    private String Nom;
    @Column(name = "Value")
    private  float note;
    @ManyToOne
    @JoinColumn(name = "id_student")
    private  StudentEntitie student;
    // prototype pattern
    public NoteEntity Clone(){
        NoteEntity NE=new NoteEntity();
        NE.setId(this.getId());
        NE.setNote(this.getNote());
        NE.setNom(this.getNom());
        NE.setStudent(this.getStudent());
        return NE;
    }

}

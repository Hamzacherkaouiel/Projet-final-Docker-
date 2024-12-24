package projet.docker.backend.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.docker.backend.DTO.DTOStudent;
import projet.docker.backend.Entities.NoteEntity;
import projet.docker.backend.Entities.StudentEntitie;
import projet.docker.backend.Mappers.StudentMapper;
import projet.docker.backend.RepositoryInterfaces.RepositoryStudent;
import projet.docker.backend.Triage.TriiParMoyenne;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ServiceStudent {
    @Autowired
    RepositoryStudent RS;
    @Autowired
    StudentMapper SM;

    public List<DTOStudent> getAllStudents(){
        List<StudentEntitie> Students=this.RS.findAll();
        List<DTOStudent> DaoStudents=new ArrayList<>();
        for(int i=0;i<Students.size();i++){
            DTOStudent student=SM.MappedToDAOStudent(Students.get(i));
            student.setMoyen(this.calculMoyen(Students.get(i).getNotes()));
            DaoStudents.add(student);

        }

        return DaoStudents ;
    }
    public List<DTOStudent> getStudentsOrderByAverage(){
        List<StudentEntitie> Students=this.RS.findAll();
        List<DTOStudent> DaoStudents=new ArrayList<>();
        for(int i=0;i<Students.size();i++){
            DTOStudent student=SM.MappedToDAOStudent(Students.get(i));
            student.setMoyen(this.calculMoyen(Students.get(i).getNotes()));
            DaoStudents.add(student);
        }
        Comparator Comaparteur=new TriiParMoyenne();
        Collections.sort(DaoStudents,Comaparteur);
        System.out.println("SORTED BY AVG ");
        return DaoStudents ;
    }
    public DTOStudent getStudent(Long id){
        StudentEntitie SE=this.RS.findById(id).get();
        DTOStudent DS=this.SM.MappedToDAOStudent(SE);
        DS.setMoyen(this.calculMoyen(SE.getNotes()));
        return DS;
    }
    public void CreateStudent(DTOStudent Student){

       StudentEntitie SE= this.SM.MappedToStudent(Student);
       SE.setDate(LocalDate.now());
       this.RS.save(SE);
    }
    public void UpdateStudent(DTOStudent Student,Long id){
        StudentEntitie SE=this.SM.MappedToStudent(Student);
        SE.setId(id);
        this.RS.save(SE);

    }
    public void DeleteStudent(Long id){
        this.RS.deleteById(id);
    }
    public boolean Exists(Long id){
        return this.RS.existsById(id);
    }
    public double calculMoyen(List<NoteEntity> Notes ){
        double moyenne=0;
        if(Notes!=null){
            for(int i=0;i<Notes.size();i++){
                moyenne+=Notes.get(i).getNote();
            }
            moyenne=moyenne/Notes.size();
        }

        return moyenne;
    }

}

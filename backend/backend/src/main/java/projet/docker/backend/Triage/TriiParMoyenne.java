package projet.docker.backend.Triage;

import projet.docker.backend.DTO.DTOStudent;

import java.util.Comparator;

public class TriiParMoyenne implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        DTOStudent Student1= (DTOStudent) o1;
        DTOStudent Student2= (DTOStudent) o2;
        if(Student1.getMoyen()>Student2.getMoyen()){
            return -1;
        }
        return 1;
    }



}

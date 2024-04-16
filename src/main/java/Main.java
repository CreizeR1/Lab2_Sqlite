import entity.Doctor;
import entity.Patient;

import repository.DoctorRepository;
import repository.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;


public class Main {
    private static final Logger log= LogManager.getLogger(Main.class);
    public static void main(String[] args) throws SQLException {

        DoctorRepository doctorRepository = new DoctorRepository();
        PatientRepository patientRepository = new PatientRepository();


        log.info(patientRepository.getAll());
        patientRepository.insert( new Patient(4,"Петров Иван Петрович","1980-04-10",true));
//        doctorRepository.insert(new Doctor("Петров Иван Иванович","79125294655","Дерматолог","2023-05-18",305,));



    }
}
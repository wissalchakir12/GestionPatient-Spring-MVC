package org.example.gestionpatient;

import org.example.gestionpatient.entities.Patient;
import org.example.gestionpatient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class GestionPatientApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionPatientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        // la création de patient en utilisant builder
        //Patient patient= Patient.builder()
                //.nom("wissal")
                //.dateNaissance(new Date())
                //.score(100)
                //.malade(false)
                //.build();

        patientRepository.save(new Patient(null,"wissal",new Date(),false,100));
        patientRepository.save(new Patient(null,"aya",new Date(),false,50));
        patientRepository.save(new Patient(null,"thami",new Date(),false,20));
    }
}

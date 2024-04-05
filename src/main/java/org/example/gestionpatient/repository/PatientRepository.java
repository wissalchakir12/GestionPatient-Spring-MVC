package org.example.gestionpatient.repository;

import org.example.gestionpatient.entities.Patient;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long>
{
    Page <Patient> findByNomContains(String keyword, Pageable pageable); // quand la methode retourne Page , elle doit avoir un param de type pageable!!

    //on peut utiliser le HQl en utilisant l'annotation @Query
}

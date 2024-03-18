package net.mmourouh.hospitalapp.repositories;

import net.mmourouh.hospitalapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//Spring data
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    List<Patient> findBySick(boolean sick);

    List<Patient> findByNameContains(String keyword);

    //Using @Query
    @Query("SELECT p FROM Patient p WHERE p.name LIKE :x")
    List<Patient> search(@Param("x") String keyword);

    List<Patient> findByScoreGreaterThan(int score);

    //Using @Query
    @Query("SELECT p FROM Patient p WHERE p.score > :x")
    List<Patient> searchByScore(@Param("x") int score);


}

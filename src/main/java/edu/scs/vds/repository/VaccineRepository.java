package edu.scs.vds.repository;

import edu.scs.vds.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {
}

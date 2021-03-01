package edu.scs.vds.repository;

import edu.scs.vds.model.Application;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface ApplicationDatatableRepository extends DataTablesRepository<Application, Integer> {}

package com.application.PortScanner.repository;

import com.application.PortScanner.model.Port;
import org.springframework.data.repository.CrudRepository;

public interface PortRepository extends CrudRepository<Port,Long> {
}

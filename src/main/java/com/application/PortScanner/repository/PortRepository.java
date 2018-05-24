package com.application.PortScanner.repository;

import com.application.PortScanner.model.Port;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Kevin Neag
 */
public interface PortRepository extends CrudRepository<Port, Long>{
}

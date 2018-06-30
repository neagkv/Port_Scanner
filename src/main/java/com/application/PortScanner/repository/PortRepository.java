package com.application.PortScanner.repository;

import com.application.PortScanner.domain.Port;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kevin Neag
 */
@Repository
public interface PortRepository extends JpaRepository<Port, Long> {



}

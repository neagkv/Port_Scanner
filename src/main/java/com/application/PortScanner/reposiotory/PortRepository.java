package com.application.PortScanner.reposiotory;

import com.application.PortScanner.domain.Port;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kevin Neag
 */
public interface PortRepository extends JpaRepository<Port, Long> {

    Port save(long portNumb);
}

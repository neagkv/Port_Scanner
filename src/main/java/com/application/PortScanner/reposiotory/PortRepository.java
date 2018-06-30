package com.application.PortScanner.reposiotory;

import com.application.PortScanner.domain.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author Kevin Neag
 */
public interface PortRepository extends JpaRepository<Port, Long> {


}

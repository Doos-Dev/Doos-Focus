package com.doos.doosfocus;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface BloqueDiarioRepository extends JpaRepository<BloqueDiario, Long> {

    List<BloqueDiario> findByMetaIdOrderByFechaAsc(Long metaId);

    boolean existsByMetaIdAndFecha(Long metaId, LocalDate fecha);
}
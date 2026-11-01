package com.doos.doosfocus;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BloqueDiarioRepository extends JpaRepository<BloqueDiario, Long> {

    List<BloqueDiario> findByMetaIdOrderByFechaAsc(Long metaId);
}
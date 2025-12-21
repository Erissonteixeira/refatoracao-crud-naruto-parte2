package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.repository;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity.NinjaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaEntity, Long> {
}

package com.bastos.aluraflix.dataprovider.repository;

import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
    Optional<List<VideoEntity>> findByCategoriaId(Long id);
    List<VideoEntity> findByTituloContains(String search);
}

package com.bastos.aluraflix.dataprovider.repository;

import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
    Optional<List<VideoEntity>> findByCategoriaId(Long id);

    @Query("select video from VideoEntity video where lower(video.titulo) like %:titulo%")
    Page<VideoEntity> findByTitulo(@Param("titulo") String search, Pageable pageable);
}

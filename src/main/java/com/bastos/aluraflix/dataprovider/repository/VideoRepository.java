package com.bastos.aluraflix.dataprovider.repository;

import com.bastos.aluraflix.dataprovider.repository.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
}

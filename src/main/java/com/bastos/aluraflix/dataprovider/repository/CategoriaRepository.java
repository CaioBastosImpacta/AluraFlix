package com.bastos.aluraflix.dataprovider.repository;

import com.bastos.aluraflix.dataprovider.repository.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

}

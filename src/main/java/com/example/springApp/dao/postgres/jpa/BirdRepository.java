package com.example.springApp.dao.postgres.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BirdRepository extends JpaRepository<BirdEntity, UUID>, PagingAndSortingRepository<BirdEntity, UUID> {

    @Query("SELECT b FROM BirdEntity b WHERE b.latinname = ?1")
    Optional<BirdEntity> findBirdByLatinName(String latinName);
}

package com.bootcamp.fruitbox.repository;

import com.bootcamp.fruitbox.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    @Query("SELECT e FROM Fruit e WHERE e.deleted = false")
    List<Fruit> findAllActive();

    @Query("SELECT e FROM Fruit e WHERE e.id = :id AND e.deleted = false")
    Optional<Fruit> findByIdAndNotDeleted(@Param("id") Long id);
}

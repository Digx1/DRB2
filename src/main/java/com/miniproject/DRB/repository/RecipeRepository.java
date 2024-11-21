package com.miniproject.DRB.repository;

import com.miniproject.DRB.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r ORDER BY r.id ASC")
    List<Recipe> findAllSorted();

}

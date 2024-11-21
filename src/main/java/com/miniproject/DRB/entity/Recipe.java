package com.miniproject.DRB.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

    @Entity
    @Data
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="recipe")
    public class Recipe {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="name")
        private String name;
        @Column(name="dcr")
        private String description;

        @ElementCollection
        @Column(name="elements")
        private List<String> ingredients;

        @ElementCollection
        @Column(name="method")
        private List<String> steps;

        @Column(name="type")
        private String category;

        @Column(name="time")
        private int cookingTime;

        @Column(name="tag")
        private String tags;
    }



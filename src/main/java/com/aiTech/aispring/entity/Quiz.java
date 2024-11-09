package com.aiTech.aispring.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("quiz")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz {
    @Id
    private String id;
    private String title;
    private String description;
    private int pointsRequired; // Points nécessaires pour réussir le quiz
    private int score; // Score obtenu par l'utilisateur
    private boolean isCompleted; // Statut d'achèvement du quiz
    private int totalQuestions; // Nombre total de questions dans le quiz
    private int timeLimit; // Limite de temps pour le quiz (en minutes)
    private String category; // Catégorie du quiz (ex: 'PMI', 'Management')
    private Date dateCreated; // Date de création du quiz

    @DBRef
    private List<Question> questions; // Liste des questions du quiz
}

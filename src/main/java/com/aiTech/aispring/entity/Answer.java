package com.aiTech.aispring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    private String id;

    @DBRef
    private Question question;

    @DBRef
    private Option option;

}
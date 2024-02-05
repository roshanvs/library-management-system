package com.mrvs.lms.jpaOneModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NewsLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

}

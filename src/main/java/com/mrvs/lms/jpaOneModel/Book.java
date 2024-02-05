package com.mrvs.lms.jpaOneModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String name;
    private String bookNo;
    private int cost;
    @Enumerated
    private BookType type;
    @ManyToOne
    @JoinColumn
    private Student student;
    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("bookList")
    private Author author;
    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<Transaction> txnList;
}
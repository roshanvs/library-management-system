package com.mrvs.lms.jpaOneModel;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String name;
    @Column(length = 30, unique = true, nullable = false)
    private String email;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
    @OneToMany(mappedBy = "author")
//    @JsonIgnore
    private List<Book> bookList;}
//    private String temp;

package com.mrvs.lms.jpaOneModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String name;
    @Column(length = 30, unique = true)
    private String email;
    @Column(length = 15, unique = true, nullable = false)
    private String phoneNo;
    private String address;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
    @Enumerated(value = EnumType.STRING)
    private StudentType status;
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Book> list;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Transaction> txnList;

}
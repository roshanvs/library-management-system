package com.mrvs.lms.jpaOneModel;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String txnId;

    @JoinColumn
    @ManyToOne
    private Student student;

    @JoinColumn
    @ManyToOne
    private Book book;

    private int paidAmount;

    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus status;}
package com.teaCloud.entity;



import javax.persistence.*;

@Entity
@Table(name = "members")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberid", nullable = false, unique = true)
    private Long memberID;

    private String password;
}

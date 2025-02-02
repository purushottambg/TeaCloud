package com.teaCloud.entity;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "members")
@RequiredArgsConstructor
@Getter
@Setter

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberid", nullable = false, unique = true)
    private Long memberID;

    @Column(name = "name", nullable = false)
    private String Name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name="department")
    private String department;

    private String password;
}

package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @OneToOne
    private User username;

}

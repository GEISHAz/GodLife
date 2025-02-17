package com.glcom.godlife.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue()
    private String userId;

    private String userPwd;

    private Timestamp createdDate;
}

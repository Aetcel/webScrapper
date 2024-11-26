package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gender;

    @Column(name = "name_title")
    private String nameTitle;

    @Column(name = "name_first")
    private String nameFirst;

    @Column(name = "name_last")
    private String nameLast;

    @Column(name = "street_number")
    private Integer streetNumber;

    @Column(name = "street_name")
    private String streetName;

    private String city;

    private String state;

    private String country;

    private Integer postcode;

    @Column(name = "coordinates_latitude")
    private String coordinatesLatitude;

    @Column(name = "coordinates_longitude")
    private String coordinatesLongitude;

    @Column(name = "timezone_offset")
    private String timezoneOffset;

    @Column(name = "timezone_description")
    private String timezoneDescription;

    private String email;

    @Column(name = "login_uuid")
    private UUID loginUuid;

    @Column(name = "login_username")
    private String loginUsername;

    @Column(name = "login_password")
    private String loginPassword;

    @Column(name = "login_salt")
    private String loginSalt;

    @Column(name = "login_md5")
    private String loginMd5;

    @Column(name = "login_sha1")
    private String loginSha1;

    @Column(name = "login_sha256")
    private String loginSha256;

    @Column(name = "dob_date")
    private String dobDate;

    @Column(name = "dob_age")
    private Integer dobAge;

    @Column(name = "registered_date")
    private String registeredDate;

    @Column(name = "registered_age")
    private Integer registeredAge;

    private String phone;

    private String cell;

    @Column(name = "id_name")
    private String idName;

    @Column(name = "id_value")
    private String idValue;

    @Column(name = "picture_large")
    private String pictureLarge;

    @Column(name = "picture_medium")
    private String pictureMedium;

    @Column(name = "picture_thumbnail")
    private String pictureThumbnail;

    private String nationality;
}

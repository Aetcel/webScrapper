package com.example.demo.service.impl;

import com.example.demo.model.entity.UserData;
import com.example.demo.repository.UserDataRepository;
import com.example.demo.service.UserDataInterface;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;

@Service
public class UserDataService implements UserDataInterface {

    UserDataRepository userDataRepository;

    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }


    public void InterdayReq () {

        try {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://randomuser.me/api/"))
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        UserData userData = new UserData();
        JsonNode jsonNode = new ObjectMapper().readTree(response.body());

        userData.setGender(jsonNode.at("/results/0/gender").asText());
        userData.setNameTitle(jsonNode.at("/results/0/name/title").asText());
        userData.setNameFirst(jsonNode.at("/results/0/name/first").asText());
        userData.setNameLast(jsonNode.at("/results/0/name/last").asText());
        userData.setStreetNumber(jsonNode.at("/results/0/location/street/number").asInt());
        userData.setStreetName(jsonNode.at("/results/0/location/street/name").asText());
        userData.setCity(jsonNode.at("/results/0/location/city").asText());
        userData.setState(jsonNode.at("/results/0/location/state").asText());
        userData.setCountry(jsonNode.at("/results/0/location/country").asText());
        userData.setPostcode(jsonNode.at("/results/0/location/postcode").asInt());
        userData.setCoordinatesLatitude(jsonNode.at("/results/0/location/coordinates/latitude").asText());
        userData.setCoordinatesLongitude(jsonNode.at("/results/0/location/coordinates/longitude").asText());
        userData.setTimezoneOffset(jsonNode.at("/results/0/location/timezone/offset").asText());
        userData.setTimezoneDescription(jsonNode.at("/results/0/location/timezone/description").asText());
        userData.setEmail(jsonNode.at("/results/0/email").asText());
        userData.setLoginUuid(UUID.fromString(jsonNode.at("/results/0/login/uuid").asText()));
        userData.setLoginUsername(jsonNode.at("/results/0/login/username").asText());
        userData.setLoginPassword(jsonNode.at("/results/0/login/password").asText());
        userData.setLoginSalt(jsonNode.at("/results/0/login/salt").asText());
        userData.setLoginMd5(jsonNode.at("/results/0/login/md5").asText());
        userData.setLoginSha1(jsonNode.at("/results/0/login/sha1").asText());
        userData.setLoginSha256(jsonNode.at("/results/0/login/sha256").asText());
        userData.setDobDate(jsonNode.at("/results/0/dob/date").asText());
        userData.setDobAge(jsonNode.at("/results/0/dob/age").asInt());
        userData.setRegisteredDate(jsonNode.at("/results/0/registered/date").asText());
        userData.setRegisteredAge(jsonNode.at("/results/0/registered/age").asInt());
        userData.setPhone(jsonNode.at("/results/0/phone").asText());
        userData.setCell(jsonNode.at("/results/0/cell").asText());
        userData.setIdName(jsonNode.at("/results/0/id/name").asText());
        userData.setIdValue(jsonNode.at("/results/0/id/value").isNull() ? null : jsonNode.at("/results/0/id/value").asText());
        userData.setPictureLarge(jsonNode.at("/results/0/picture/large").asText());
        userData.setPictureMedium(jsonNode.at("/results/0/picture/medium").asText());
        userData.setPictureThumbnail(jsonNode.at("/results/0/picture/thumbnail").asText());
        userData.setNationality(jsonNode.at("/results/0/nat").asText());

        userDataRepository.save(userData);
        System.out.println(userData);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

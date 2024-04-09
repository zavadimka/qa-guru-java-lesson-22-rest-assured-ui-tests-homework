package com.zavadimka.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.zavadimka.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class DemoQaApiSpecification {

    public static RequestSpecification baseRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().method()
            .log().uri()
            .log().headers()
            .log().body();

    public static ResponseSpecification userSuccessfulLoginResponseSpecWithStatusCode200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/user_successful_login_schema.json"))
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}

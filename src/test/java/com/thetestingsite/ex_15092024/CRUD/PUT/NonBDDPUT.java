package com.thetestingsite.ex_15092024.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDPUT {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;


    // 6762
    // Token - Token?
    // Payload {
    //    "firstname" : "Jim",
    //    "lastname" : "Brown",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}

    // POST - Auth  - token
    // POST - Booking ID
    // PUT - token and BookingID

   /* public void get_token(){

    }

    public void get_booking_id(){
          return bookingid;

    }
*/
    @Test
    public void test_put_positive_tc(){
        // POST - Auth - token

        String token = "5bdb40f28f095e2";
        String bookingid = "685";
        Response response1;

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Pankaj\",\n" +
                "    \"lastname\" : \"Singhal\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();

        // Get Validatable response to perform validation

         validatableResponse = response.then().log().all();
         validatableResponse.statusCode(200);




    }



    
}

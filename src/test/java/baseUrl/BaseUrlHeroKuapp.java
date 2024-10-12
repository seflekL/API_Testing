package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.runner.Request;

public class BaseUrlHeroKuapp {

    protected RequestSpecification specHeroKuapp ;

    @Before

    public  void setup(){

        specHeroKuapp= new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }

}

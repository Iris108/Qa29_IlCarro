package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
    @BeforeMethod
    public void precondition(){

    }
    @Test
    public void registrationTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("LIS","Slow","slow"+i+"@gmail.com","Ss12345");
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
    }
    @Test
    public void registrationTestNegative(){

    }
    @AfterMethod
    public void postCondition(){

    }
}

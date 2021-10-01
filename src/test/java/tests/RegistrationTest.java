package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class RegistrationTest extends TestBase {
        @BeforeMethod
        public void precondition() {
            if (app.userHelper().isLogoutPresent()) {
                app.userHelper().logout();
            }
        }

        @Test
        public void registrationTest() {
            int i = (int) ((System.currentTimeMillis()/1000)%3600);
            app.userHelper().openRegistrationForm();
            app.userHelper().fillRegistrationForm("Lis", "Slow", "slow" + i + "@gmail.com", "Ss12" + i + "$");
            app.userHelper().checkPolicy();
            app.userHelper().submitForm();

            Assert.assertTrue(app.userHelper().isRegistrationSuccess());
        }

    //@Test
    //public void registrationTestNegative(){


    @AfterMethod
    public void postCondition(){
    app.userHelper().clickOkButton();

    }
}

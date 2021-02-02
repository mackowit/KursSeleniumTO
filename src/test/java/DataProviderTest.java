import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class DataProviderTest {

    @Test(dataProvider = "getData")
    public void test(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {"username1", "password1"},
                {"username2", "password2"}
        };
    }
}

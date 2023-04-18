package parameterization;
import com.google.common.collect.Lists;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class TestParameterization4 {
    @Test(dataProviderClass = DataProviders.class,dataProvider = "dp1")
    public void login1(String userName, String password) {
        System.out.println("username------->" + userName + " and " + "password------->" + password);
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "dp2")
    public void login2(String fName, String lName, String age ) {
        System.out.println("fName------->" + fName + " and " + "lName------->" + lName+"age------->" + age);
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "dp3")
    public void login3(Hashtable<String,String> table) {
        System.out.println("username------->" + table.get("UserName") + " and " + "password------->" + table.get("Password"));
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "dp5")
    public void login4(String userName, String password) {
        System.out.println("username------->" + userName + " and " + "password------->" + password);
    }
    @Test(dataProviderClass = DataProviders.class,dataProvider = "dp5")
    public void login5(String fName, String lName, String age ) {
        System.out.println("fName------->" + fName + " and " + "lName------->" + lName+"age------->" + age);
    }
}

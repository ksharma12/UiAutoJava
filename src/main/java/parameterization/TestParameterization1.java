package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization1 {

    @Test(dataProvider = "getData")
    public void login1(String username, String password){
        System.out.println("username------->"+username+" and "+"password--------->"+password);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];
        data[0][0] = "trip@logixshapers.com";
        data[0][1] = "12345asdfg";
        data[1][0] = "keshavSharma.tu@gmail.com";
        data[1][1] = "0987poiuy";
        data[2][0] = "Logix.shapers@asdf.com";
        data[2][1] = "4567TYUU";
        return data;
    }
}

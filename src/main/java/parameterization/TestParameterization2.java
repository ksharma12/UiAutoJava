package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;

public class TestParameterization2 {

    public static ExcelReader excel = null;
    @Test(dataProvider = "getData")
    public void login2(String username, String password){
        System.out.println("username------->"+username+" and "+"password--------->"+password);
    }

    @DataProvider
    public Object[][] getData(){
        if(excel == null){
            excel = new ExcelReader("src/main/java/testData/TestingExcel.xlsx");
        }
        String sheetName = "Credentials";
        int rows = excel.getRowCount(sheetName);
        int columns = excel.getColumnCount(sheetName);
        System.out.println(rows);
        System.out.println(columns);
        Object[][] data = new Object[rows - 1][columns];
        System.out.println(data.length);
        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            for (int colNum = 0; colNum < columns; colNum++) {
                data[rowNum-2][colNum] = excel.getCellData(sheetName,colNum,rowNum);
            }
        }
        return data;
    }
}

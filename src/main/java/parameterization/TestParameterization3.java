package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.util.Hashtable;

public class TestParameterization3 {
    public static ExcelReader excel = null;
    @Test(dataProvider = "getData")
    public void login3(Hashtable<String,String> data){
        System.out.println("username------->"+data.get("UserName")+" and "+"password------->"+data.get("Password"));
    }

    @DataProvider
    public Object[][] getData(){
        if(excel == null){
            excel = new ExcelReader("src/main/java/testData/TestingExcel.xlsx");
        }
        String sheetName = "Credentials";
        int rows = excel.getRowCount(sheetName);
        int columns = excel.getColumnCount(sheetName);
        Object[][] data = new Object[rows - 1][1];
        Hashtable<String,String> table = null;
        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            table = new Hashtable<>();
            for (int colNum = 0; colNum < columns; colNum++) {
                table.put(excel.getCellData(sheetName,colNum,1),excel.getCellData(sheetName,colNum,rowNum));
                data[rowNum-2][0] = table;
            }
        }
        return data;
    }
}

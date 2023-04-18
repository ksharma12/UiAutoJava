package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class DataProviders {
    public static ExcelReader excel = null;

    @DataProvider(name = "dp1")
    public static Object[][] getData1() {
        Object[][] data = new Object[2][2];
        data[0][0] = "Keshav";
        data[0][1] = "asdf1234";
        data[1][0] = "Sharma";
        data[1][1] = "aete335";
        return data;
    }

    @DataProvider(name = "dp2")
    public static Object[][] getData2() {
        Object[][] data = new Object[2][3];
        data[0][0] = "Rahul";
        data[0][1] = "Dhani";
        data[0][2] = "34";
        data[1][0] = "Roy";
        data[1][1] = "Kapoor";
        data[1][2] = "54";
        return data;
    }

    @DataProvider(name = "dp3")
    public Object[][] getData3() {
        if (excel == null) {
            excel = new ExcelReader("src/main/java/testData/TestingExcel.xlsx");
        }
        String sheetName = "Credentials";
        int rows = excel.getRowCount(sheetName);
        int columns = excel.getColumnCount(sheetName);
        Object[][] data = new Object[rows - 1][1];
        Hashtable<String, String> table = null;
        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            table = new Hashtable<>();
            for (int colNum = 0; colNum < columns; colNum++) {
                table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
                data[rowNum - 2][0] = table;
            }
        }
        return data;
    }

    @DataProvider(name = "dp4")
    public Object[][] getData4() {
        if (excel == null) {
            excel = new ExcelReader("src/main/java/testData/TestingExcel.xlsx");
        }
        String sheetName = "UserData";
        int rows = excel.getRowCount(sheetName);
        int columns = excel.getColumnCount(sheetName);
        Object[][] data = new Object[rows - 1][1];
        Hashtable<String, String> table = null;
        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            table = new Hashtable<>();
            for (int colNum = 0; colNum < columns; colNum++) {
                table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
                data[rowNum - 2][0] = table;
            }
        }
        return data;
    }

    // different test cases access the same data provider as well as same data provider
    @DataProvider(name = "dp5")
    public static Object[][] getData5(Method m) {
        Object[][] data = null;
        if (m.getName().equals("login4")) {
            data = new Object[2][3];
            data[0][0] = "Rahul";
            data[0][1] = "Dhani";
            data[0][2] = "34";
            data[1][0] = "Roy";
            data[1][1] = "Kapoor";
            data[1][2] = "54";
        } else if (m.getName().equals("login5")) {
            data = new Object[2][3];
            data[0][0] = "Rahul";
            data[0][1] = "Dhani";
            data[0][2] = "34";
            data[1][0] = "Roy";
            data[1][1] = "Kapoor";
            data[1][2] = "54";
        }
        return data;
    }
}

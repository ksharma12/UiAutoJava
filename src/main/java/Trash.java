import java.lang.reflect.Field;

public class Trash {
    //    public By selector_dict(String locator){
//        HashMap<String,By> map = new HashMap<String,By>();
//        map.put("xpath",By.xpath(locator));
//        map.put("id",By.id(locator));
//        map.put("partialLinkText",By.partialLinkText(locator));
//        map.put("linkText",By.linkText(locator));
//        map.put("name",By.name(locator));
//        map.put("className",By.className(locator));
//        map.put("cssSelector",By.cssSelector(locator));
//        map.put("tagName",By.tagName(locator));
//
//    }

//    public By selector(By locator){
//        if (selector == null) {
//            try {
//                String locatorSignature = "\""+locator+"\"".split("__")[0];
////                String locatorValue = locator.split("__")[0];
//                switch (locatorSignature) {
//                    case "xpath":
//                        selector = By.xpath(locator);
//                        break;
//                    case "id":
//                        selector = By.id(locator);
//                        break;
//                    case "cssSelector":
//                        selector = By.cssSelector(locator);
//                        break;
//                    case "name":
//                        selector = By.name(locator);
//                        break;
//                    case "partialLinkText":
//                        selector = By.partialLinkText(locator);
//                        break;
//                    case "className":
//                        selector = By.className(locator);
//                        break;
//                    case "tagName":
//                        selector = By.tagName(locator);
//                        break;
//                    default:
//                        selector = By.linkText(locator);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return selector;
//    }
//
//    public String locatorName(String locator) {
//        if (locatorVariableName == null) {
//            try {
//                ObjectRepository objRepo = new ObjectRepository();
//                Class clazz = locator.getClass();
//                Field asdf = clazz.getDeclaredField(locator);
//                System.out.println(asdf.getName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return locatorVariableName;
//    }
}

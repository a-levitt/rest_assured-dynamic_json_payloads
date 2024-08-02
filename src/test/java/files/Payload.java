package files;

public class Payload {
    public static String addBookBody(String isbn, String aisle) {
        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"" + isbn + "\",\n" +
                "\"aisle\":\"" + aisle + "\",\n" +
                "\"author\":\"John foe\"\n" +
                "}";
    }

    public static String deleteBooksBody(String isbn, String aisle) {
        return "{\n" +
                "    \"ID\": \"" + isbn + aisle + "\"\n" +
                "}\n";
    }
}

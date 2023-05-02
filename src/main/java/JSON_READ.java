import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSON_READ {
    public static void main(String[] args) {
        try (FileReader jsonFile = new FileReader("students.json")) {
            JSONObject students = (JSONObject) new JSONParser().parse(jsonFile);
            System.out.println(students);

            JSONArray studentsArray = (JSONArray) students.get("students");

            studentsArray.forEach(st -> printStudent((JSONObject) st));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void printStudent(JSONObject student) {
        System.out.println("Student id: " + student.get("id"));
        System.out.println("        firstname: " + student.get("firstname"));
        System.out.println("        lastname: " + student.get("lastname"));
        System.out.println("        subject: " + student.get("subject"));
        System.out.println("        marks: " + student.get("marks"));
    }
}

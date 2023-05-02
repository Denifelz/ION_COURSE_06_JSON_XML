import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSON_WRITE {
    public static void main(String[] args) {
        JSONArray studentsArray = new JSONArray();
        studentsArray.add(createStudent("001", "Alina", "Ianciuc", "Physics", "6"));
        studentsArray.add(createStudent("002", "Olga", "Advahova", "Chemistry", "9"));
        studentsArray.add(createStudent("003", "Valentina", "Criclivaia", "English", "7"));
        studentsArray.add(createStudent("004", "Nadejda", "Gutul", "Math", "8"));

        JSONObject students = new JSONObject();
        students.put("students", studentsArray);

        try (FileWriter jsonFile = new FileWriter("students.json")) {
            jsonFile.write(students.toJSONString());
            jsonFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject createStudent(String id, String firstname, String lastname, String subject, String marks) {
        JSONObject student = new JSONObject();
        student.put("id", id);
        student.put("firstname", firstname);
        student.put("lastname", lastname);
        student.put("subject", subject);
        student.put("marks", marks);

        return student;
    }
}

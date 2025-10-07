package murach.data;

import murach.business.User;
import java.io.*;
import java.util.*;

public class UserDB {

    public static void insert(User user, String filepath) {
        List<User> users = getAll(filepath);
        users.add(user);
        saveAll(users, filepath);
    }

    public static List<User> getAll(String filepath) {
        List<User> users = new ArrayList<>();
        File file = new File(filepath);
        if (!file.exists()) {
            return users;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Giả sử mỗi dòng: email,firstName,lastName
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.add(new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static void saveAll(List<User> users, String filepath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filepath))) {
            for (User u : users) {
                pw.println(u.getEmail() + "," + u.getFirstName() + "," + u.getLastName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
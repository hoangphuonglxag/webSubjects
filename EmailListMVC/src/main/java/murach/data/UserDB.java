package murach.data;

import java.io.*;
import java.util.*;
import murach.business.User;

public class UserDB {
    public static void insert(User user, String path) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))) {
            out.println(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getAll(String path) {
        List<User> users = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    users.add(new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
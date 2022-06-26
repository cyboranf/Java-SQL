import entity.User;
import entity.UserDAO;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User newUser = new User();
        newUser.setUserName("janek");
        newUser.setEmail("jan@mail.com");
        newUser.setPassword("haslo");

        User newUser2 = new User();
        newUser2.setUserName("franek");
        newUser2.setEmail("franek@mail2.com");
        newUser2.setPassword("haslo");

        User nonExistingUser = new User();
        nonExistingUser.setId(100000);

        User nullUser = null;

        User userToUpdateCorrect = new User();
        userToUpdateCorrect.setId(1);
        userToUpdateCorrect.setUserName("update");
        userToUpdateCorrect.setEmail("filip_updated@mail.com");
        userToUpdateCorrect.setPassword("haslo");

//        User userToUpdateDuplicateEmail = new User();
//        userToUpdateDuplicateEmail.setId(2);
//        userToUpdateDuplicateEmail.setUserName("update2");
//        userToUpdateDuplicateEmail.setEmail("filip_updated@mail.com");
//        userToUpdateDuplicateEmail.setPassword("haslo");

        //Testing create method
        System.out.println("CREATE method:");
        createUser(newUser);
        createUser(newUser2);

        //Testing read method
        System.out.println("READ method:");
        readUser(newUser.getId());
        readUser(nonExistingUser.getId());


//        System.out.println("UPDATE method:");
//        updateUser(userToUpdateCorrect);
//        updateUser(userToUpdateDuplicateEmail);
//        updateUser(nonExistingUser);
//        updateUser(nullUser);


        System.out.println("DELETE method:");
        deleteUser(newUser.getId());
        readUser(newUser.getId());
        deleteUser(nonExistingUser.getId());


        System.out.println("FINDALL method:");
        findAllUser();
    }

    static void createUser(User user) {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.create(user));
    }

    static void readUser(int id) {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.read(id));
    }

    static void updateUser(User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.update(user);
    }

    static void deleteUser(int id) {
        UserDAO userDAO = new UserDAO();
        userDAO.delete(id);
    }

    static void findAllUser() {
        UserDAO userDAO = new UserDAO();
        System.out.println(Arrays.toString(userDAO.findAll()));
    }

}
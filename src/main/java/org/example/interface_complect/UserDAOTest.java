package org.example.interface_complect;

public class UserDAOTest {

    private final UserDAO userDAO = new UserDAOImpl();


    public static void main(String[] args) {
        User user = new User("Jake",22);
        UserDAOTest userDAOTest = new UserDAOTest();
        userDAOTest.userDAO.create(user);
    }
}

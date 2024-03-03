package org.example.interface_complect;

import java.util.Collection;




public interface UserDAO {
    void create(User user);
    void delete(User user);

    Collection<User> list();
    User get(String name);

}

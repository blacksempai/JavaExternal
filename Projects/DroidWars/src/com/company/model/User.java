package com.company.model;

import com.company.view.InvalidUsernameEcxeption;
import com.company.strategy.Role;

import java.io.*;


public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private Role role;
    File users = new File("./users/");

    public User() {

    }

    public User(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void addUser() throws InvalidUsernameEcxeption {
        User user = new User(userName, password, role);
        String fileName = userName.concat(".ser");
        File userProfile = new File("./users/" + fileName);
        users.mkdir();

        if (userProfile.exists()) {
            throw new InvalidUsernameEcxeption();
        }
        try (FileOutputStream outputStream = new FileOutputStream("./users/" + fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Role deserialize() throws IOException, ClassNotFoundException {
        Role userExist = null;
        String fileName = userName.concat(".ser");
        try (FileInputStream inputStream = new FileInputStream("./users/" + fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            User user = (User) objectInputStream.readObject();
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                userExist = user.getRole();

            }
        }

        return userExist;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

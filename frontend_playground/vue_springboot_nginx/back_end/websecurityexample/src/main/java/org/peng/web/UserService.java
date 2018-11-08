package org.peng.web;

public class UserService {
    public static String getPassword(String username){
        if (username.equals("admin"))
            return "admin";
        else return null;
    }

    public static String getCredentialsSalt(String username) {
        return "salt"+username;
    }
}

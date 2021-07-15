package service;

import model.User;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "username";
    public static final String TESTDATA_PASSWORD = "password";
    public static User userWithCredentials() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), TestDataReader.getTestData(TESTDATA_PASSWORD));
    }
}

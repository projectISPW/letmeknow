package progettoispw.controller;

public interface User {
    String getUserid();
    String getType();
    boolean confirmCredentials(String password);
}

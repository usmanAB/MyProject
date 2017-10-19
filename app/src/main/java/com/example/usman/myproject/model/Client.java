package com.example.usman.myproject.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by usman on 05/10/2017.
 */

public class Client {

    public Client() {
    }

    private enum Gender{
        MAN,WOMAN
    }

    private static List<Client> clients;
    static{

        clients = new ArrayList<>();
        for (int i=0;i<20;i++){
            Client client = new Client(
                    "nom"+i,"prenom"+i,"email"+i,new Date(),
                    i%3==0 ? Gender.MAN : Gender.WOMAN,"Debutant",true
            );
            clients.add(client);
        }
    }

    public static List<Client> getClient(){
        return clients;
    }

    public static void setClient(Client c){
        clients.add(c);
    }


    private String lastname;
    private String firstname;
    private String email;
    private Date age;
    private Gender gender;
    private String level;
    private boolean active;


    public Client(String lastname, String firstname, String email, Date age, Gender gender, String level, boolean active) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.level = level;
        this.active = active;
    }



    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }





}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.talabard.instalike.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ILUser extends BusinessEntity {

    private Long id;

    private final Collection<ILSubscription> subscriptions;
    private final Collection<ILSubscriptionGroup> subscriptionsGroup;

    private final Collection<ILPicture> pictures;

    private final Date dateInscript;
    private String name;
    private String firstname;
    private String mail;
    private String password;
    private String pictureUrl;


     public ILUser(String name, String firstname, String mail, String password) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.pictureUrl = null;
        this.password = password;
        this.dateInscript = new Date();
        this.pictures = new ArrayList<>();
        this.subscriptions = new ArrayList<>();
        this.subscriptionsGroup = new ArrayList<>();
    }

    public Date getDateInscript() {
        return dateInscript;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }


    public String getMail() {
        return mail;
    }


    public String getPassword() {
        return password;
    }


    public String getPictureUrl() {
        return pictureUrl;
    }


}

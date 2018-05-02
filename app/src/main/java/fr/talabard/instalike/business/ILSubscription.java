/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.talabard.instalike.business;

import java.util.Date;

/**
 *
 * @author jerem
 */
public class ILSubscription extends BusinessEntity{

    private Long id;
    
    private ILUser user;
    private final Date dateSubscription;
    
    private final ILUser subscribeUser;


    public ILSubscription(ILUser subscribeUser) {
        this.subscribeUser = subscribeUser;
        dateSubscription = new Date();
    }

    public ILUser getUser() {
        return user;
    }


    public Date getDateSubscription() {
        return dateSubscription;
    }

    

    
}

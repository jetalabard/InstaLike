/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.talabard.instalike.business;


import java.util.Date;

/**
 *
 * @author Mahon--Puget
 */
public class ILComment extends BusinessEntity {

    private Long id;

    private final ILUser user;

    private ILPicture picture;

    private final Date date;

    private final String comment;


    public ILComment(ILUser user, String comment) {
        this.user = user;
        this.comment = comment;
        date = new Date();
    }

    public ILUser getUser() {
        return user;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setPicture(ILPicture picture) {
        this.picture = picture;
    }

    public Date getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    
}

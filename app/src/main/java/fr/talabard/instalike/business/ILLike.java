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
public class ILLike extends BusinessEntity {

    private Long id;
    
    private ILPicture picture;
    
    private final Date dateLike;
    
    private final ILUser userWhoLike;


    public ILLike( ILUser userWhoLike) {
        this.userWhoLike = userWhoLike;
        dateLike =new Date();
    }

    public void setPicture(ILPicture picture) {
        this.picture = picture;
    }

    public ILUser getUserWhoLike() {
        return userWhoLike;
    }

    public Date getDateLike() {
        return dateLike;
    }
    

}

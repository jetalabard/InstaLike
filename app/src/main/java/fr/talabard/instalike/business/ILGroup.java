/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.talabard.instalike.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Mahon--Puget
 */
public class ILGroup extends BusinessEntity {

    private Long id;

    private final Collection<ILUser> members;

    private final Date creationDate;
    
    private String title;
    
    private String description;


     public ILGroup(String title, String description) {
        members = new ArrayList<>();
        creationDate = new Date();
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }


    public String getTitle() {
        return title;
    }


}

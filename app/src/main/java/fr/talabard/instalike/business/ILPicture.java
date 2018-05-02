/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.talabard.instalike.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ILPicture extends BusinessEntity{
    
    private Long id;
    
    private ILUser user;
    
    private Date publicationDate;
   
    private Collection<ILComment> comments;
    
    private Collection<ILLike> likes ;
    
    private String url;
    
    private String description;
    private String title;
    
    private ILVisibility visibility;
    

    
    public ILPicture(String description, ILVisibility visibility, String title) {
        this.url = null;
        this.description = description;
        this.publicationDate = new Date();
        this.visibility = visibility;
        this.title = title;
        comments= new ArrayList<>();
        likes = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }


    public ILUser getUser() {
        return user;
    }


    public Date getPublicationDate() {
        return publicationDate;
    }



    public String getUrl() {
        return url;
    }


    public String getTitle(){
        return title;
    }

    public Collection<ILComment> getComments() {
        return comments;
    }

    public Collection<ILLike> getLikes() {
        return likes;
    }



   
    
}

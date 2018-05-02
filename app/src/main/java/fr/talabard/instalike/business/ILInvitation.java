/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.talabard.instalike.business;

/**
 *
 * @author jerem
 */
public class ILInvitation extends BusinessEntity{
    
    private Long id;
    
    private final ILUser userInvited;
    private final ILUser userWhoHasInvite;
    
    private final ILGroup groupWhichInvite;


     public ILInvitation(ILUser userInvited, ILUser userWhoHasInvite, ILGroup groupWhichInvite) {
        this.userInvited = userInvited;
        this.userWhoHasInvite = userWhoHasInvite;
        this.groupWhichInvite = groupWhichInvite;
    }
    

    public ILUser getUserInvited() {
        return userInvited;
    }

    public ILUser getUserWhoHasInvite() {
        return userWhoHasInvite;
    }

    public ILGroup getGroupWhichInvite() {
        return groupWhichInvite;
    }

    public Long getId() {
        return id;
    }
    
    

   
    
    
}

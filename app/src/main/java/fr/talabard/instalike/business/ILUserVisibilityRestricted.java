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
public class ILUserVisibilityRestricted extends BusinessEntity {

    private Long id;
    
    private ILVisibility visibility;
    
    private ILUser userWhoCanSeePictureRestricted;


    public ILUserVisibilityRestricted(ILUser user) {
        this.userWhoCanSeePictureRestricted = user;
    }


    public ILUser getUserWhoCanSeePictureRestricted() {
        return userWhoCanSeePictureRestricted;
    }
    
    
}

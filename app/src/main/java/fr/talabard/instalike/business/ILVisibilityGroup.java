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
public class ILVisibilityGroup extends BusinessEntity{

    private Long id;
    
    private ILVisibility visibility;
    
    private ILGroup groupWhoCanSeePicture;

    public ILVisibilityGroup(ILGroup group) {
        this.groupWhoCanSeePicture = group;
    }


}

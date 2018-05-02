/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.talabard.instalike.business;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author jerem
 */
public class ILVisibility extends BusinessEntity{

    private Long id;
    
    private VisibilityEnum visibility;
    private Collection<ILUserVisibilityRestricted> visibiltyRestrictedUsers;
    private Collection<ILVisibilityGroup> visibilityGroup;

    public ILVisibility() {
        visibility = VisibilityEnum.PUBLIC;
    }
    
    public ILVisibility(VisibilityEnum visibility) {
        this.visibility = visibility;
        switch (visibility) {
            case GROUP:
                visibilityGroup= new ArrayList<>();
                break;
            case RESTRICTED:
                visibiltyRestrictedUsers = new ArrayList<>();
                break;
            default://public //followers
                break;
        }
    }
    
    public VisibilityEnum getVisibility() {
        return visibility;
    }

    public Collection<ILUserVisibilityRestricted> getVisibiltyRestrictedUsers() {
        return visibiltyRestrictedUsers;
    }

    public Collection<ILVisibilityGroup> getVisibilityGroup() {
        return visibilityGroup;
    }
    
    

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ILVisibility)) {
            return false;
        }
        ILVisibility other = (ILVisibility) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}

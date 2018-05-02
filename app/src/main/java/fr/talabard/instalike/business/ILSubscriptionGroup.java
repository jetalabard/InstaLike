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
public class ILSubscriptionGroup extends BusinessEntity{

    private Long id;
    private ILUser user;
    private final Date dateSubscription;
    private final ILGroup subscribeGroup;

    public ILSubscriptionGroup(ILGroup subscribeGroup) {
        this.subscribeGroup = subscribeGroup;
        dateSubscription =new Date();
    }

    public ILUser getUser() {
        return user;
    }

    public ILGroup getSubscribeGroup() {
        return subscribeGroup;
    }
}

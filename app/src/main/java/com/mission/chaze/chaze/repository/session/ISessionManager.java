package com.mission.chaze.chaze.repository.session;

import com.mission.chaze.chaze.models.CartBusiness;
import com.mission.chaze.chaze.models.CartEcommerce;

import java.util.Date;


public interface ISessionManager {

    void setFirstTimeLaunch(boolean isFirstTime);

    boolean isFirstTimeLaunch();

    void setFbUserSavedMobile(String mobile);

    String getFbUserSavedMobile();

    void setFbUserSavedEmail(String mobile);

    String getFbUserSavedEmail();

    void setGmailUserSavedMobile(String mobile);

    String getGmailUserSavedMobile();

    void setGmailUserSavedEmail(String mobile);

    String getGmailUserSavedEmail();

    void setAddress(String address);

    String getAddress();

    void setLogin(boolean isLoggedIn, String authProvide);


    boolean isLoggedIn();

    String getKeyAuthProvider();


    void setSelectedService(String service);

    String getSelectedService();


    void setCurrentCartStateFood(CartBusiness cartFood);

    CartBusiness getCurrentCartStateFood();

    void setCurrentCartStateEcommerce(CartEcommerce cartEcommerce);

    CartEcommerce getCurrentCartStateEcommerce();


    void setPreviousOrderCartEcommerce(CartEcommerce cartEcommerce);


    void setPreviousOrderCartFood(CartBusiness cartFood);

    CartEcommerce getPreviousOrderCartEcommerce();

    CartBusiness getPreviousOrderCartFood();


    Date getPreviousOrderTime();

}
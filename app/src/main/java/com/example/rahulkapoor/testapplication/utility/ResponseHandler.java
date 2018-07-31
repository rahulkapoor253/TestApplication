package com.example.rahulkapoor.testapplication.utility;

import com.facebook.FacebookException;

public interface ResponseHandler {

    /**
     * On success.
     *
     * @param fbData the fb user data
     */
    void onSuccess(SocialData fbData);

    /**
     * On cancel.
     *
     * @param msg msg
     */
    void onCancel(String msg);

    /**
     * On error.
     *
     * @param e exception;
     */
    void onError(FacebookException e);

}

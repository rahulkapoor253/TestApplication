package com.example.rahulkapoor.testapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.rahulkapoor.testapplication.utility.FacebookManager;
import com.example.rahulkapoor.testapplication.utility.ResponseHandler;
import com.example.rahulkapoor.testapplication.utility.SharedPref;
import com.example.rahulkapoor.testapplication.utility.SocialData;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;

import java.util.Arrays;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private Button btnFacebook, btnGoogle;
    private CallbackManager callbackManager;
    private FacebookManager facebookManager;
    private FacebookSdk facebookSdk;
    private static final Collection<String> PERMISSIONS_LIST = Arrays.asList("public_profile", "email");
    private String facebookID = "";
    private String googleID = "";
    private String facebookEmail;
    private String userFirstName = "";
    private String userLastName = "";
    private String facebookToken = "";
    private String userImage = "";
    private SocialData socialData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //previously logged in or not;
        if (!SharedPref.getInstance(getApplicationContext()).read_token(getApplicationContext()).isEmpty()) {
            //take user to home activity;
            goToHomeActivity();
        }

        init();

        //facebook sdk init;
        callbackManager = CallbackManager.Factory.create();
        facebookManager = new FacebookManager(MainActivity.this);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                facebookLogin();
            }
        });
    }

    /**
     * login via facebook;
     */
    private void facebookLogin() {

        facebookManager.getFbUserDetails(callbackManager, new ResponseHandler() {
            @Override
            public void onSuccess(final SocialData fbData) {

                Log.i("onSuccess", "Successful hit");
                Log.i("fbid", fbData.getID());
                Log.i("accesstoken", String.valueOf(AccessToken.getCurrentAccessToken().getToken()));
                Log.i("fb_data", fbData.getID() + " " + fbData.getEmail() + " " + fbData.getFirstName() + " " + fbData.getPicture());
                facebookID = fbData.getID();
                facebookToken = AccessToken.getCurrentAccessToken().getToken();
                facebookEmail = fbData.getEmail();
                userFirstName = fbData.getFirstName();
                userLastName = fbData.getLastName();
                userImage = fbData.getPicture();

                //save token from fb to maintain session state;
                SharedPref.getInstance(getApplicationContext()).save_token(facebookToken, getApplicationContext());

                socialData = fbData;

                //save user Email, Name, Picture to shared pref to fetch on main screen if req.
                SharedPref.getInstance(getApplicationContext()).save_picture(userImage, MainActivity.this);
                SharedPref.getInstance(getApplicationContext()).save_email(facebookEmail, MainActivity.this);
                String resName = "";
                if (!userFirstName.isEmpty()) {
                    resName = resName + userFirstName + " ";
                }
                if (!userLastName.isEmpty()) {
                    resName = resName + userLastName;
                }
                SharedPref.getInstance(getApplicationContext()).save_username(resName, getApplicationContext());

                //take user to home activity;
                goToHomeActivity();


            }

            @Override
            public void onCancel(final String msg) {
                callSocialAlertDialog(msg);
            }

            @Override
            public void onError(final FacebookException e) {
                callSocialAlertDialog(e.getMessage());
            }
        });

    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //for facebook;
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * intent fired to home;
     */
    public void goToHomeActivity() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }


    /**
     * alert dialog for fb,google;
     *
     * @param errmsg message to be displayed
     */
    private void callSocialAlertDialog(final String errmsg) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this)
                .setMessage("Failed Login: " + errmsg)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        //let user click again
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }


    /**
     * design init made;
     */
    private void init() {

        btnFacebook = (Button) findViewById(R.id.btn_facebook);
        btnGoogle = (Button) findViewById(R.id.btn_gmail);


    }


}

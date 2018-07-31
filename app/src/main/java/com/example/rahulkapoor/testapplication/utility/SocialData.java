package com.example.rahulkapoor.testapplication.utility;

import android.os.Parcel;
import android.os.Parcelable;

public class SocialData implements Parcelable {
    private String id, firstName, lastName, email, picture;

    public SocialData(final String id, final String firstName,
                      final String lastName, final String email, final String picture) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        this.picture = picture;
    }

    protected SocialData(Parcel in) {
        id = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();

        picture = in.readString();
    }

    public static final Parcelable.Creator<SocialData> CREATOR = new Parcelable.Creator<SocialData>() {
        @Override
        public SocialData createFromParcel(Parcel in) {
            return new SocialData(in);
        }

        @Override
        public SocialData[] newArray(int size) {
            return new SocialData[size];
        }
    };

    public String getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public String getPicture() {
        return picture;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(id);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(email);
        dest.writeString(picture);
    }
}

package com.robertsimoes.shareable;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;

import java.util.List;

public class Shareable {

    private final Context context;
    private final int socialChannel;   //cup
    private final String url;  //cup
    private final Uri image;
    private final String message;

    public Context getContext() {
        return context;
    }

    public static class Builder {

        public static final int FACEBOOK = 1;
        public static final int TWITTER = 2;
        public  static final int TUMBLR = 3;
        public static final int LINKED_IN =4;
        public static final int GOOGLE_PLUS =5;
        public static final int REDDIT = 6;
        public static final int MESSAGES = 7;
        public static final int EMAIL = 8;
        public static final int ANY=0;

        private Context c=null;
        private int socialChannel =ANY;
        private String url=null;
        private Uri image=null; // If uses image, then it overrides text post
        private String message=null;   //spoon

        //builder methods for setting property
        public Builder (Context c) {
            this.c=c;
        }

        public Builder socialChannel(int channel) {this.socialChannel =channel;return this;}

        public Builder url(String url) {this.url = url;return this;}

        public Builder image(Uri img) {this.image = img;return this;}

        public Builder message(String message) {this.message=message; return this;}

        //return fully build object
        public Shareable build() {
            return new Shareable(this);
        }
    }

    //private constructor to enforce object creation through builder
    private Shareable(Builder builder) {
        this.context=builder.c;
        this.socialChannel=builder.socialChannel;
        this.message=builder.message;
        this.url=builder.url;
        this.image=builder.image;
    }

    /**
     * Creates activity chooser if social channel is set to ANY
     */
    public void share() {
        Intent socialIntent = new Intent();
        socialIntent.setAction(Intent.ACTION_SEND);

        if (this.socialChannel!= Builder.ANY) {
            socialIntent.setType("text/*");
            String packageName = resolve(socialIntent,this.socialChannel);
            if (packageName!=null) {
               socialIntent.setPackage(packageName);
            }
        }
        /*
            If there's an image then override as an image share vs text.
            Adds URI and appropriate permissions
         */
        if (this.image!=null) {
            socialIntent.putExtra(Intent.EXTRA_STREAM, this.image);
            socialIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            socialIntent.putExtra(Intent.EXTRA_TEXT, this.message + "\n"+this.url);
            socialIntent.setType("*/*");
        } else {
            //Plain text post
            socialIntent.setType("text/plain");
            socialIntent.putExtra(Intent.EXTRA_TEXT, this.message + "\n" + this.url);
        }

        this.getContext().startActivity(Intent.createChooser(socialIntent, "Choose an application"));
    }

    /**
     * Iterates through aval packages matching the provided social channel
     * @param share share intent
     * @param channelType, channel type from builder static types
     * @return package string or null if not found
     */
    private String resolve(Intent share,int channelType) {
        String partialAppName = parseType(channelType);
        try {
            List<ResolveInfo> resInfo = getContext().getPackageManager().queryIntentActivities(share, 0);
            if (!resInfo.isEmpty()) {
                for (ResolveInfo info : resInfo) {
                    if (info.activityInfo.packageName.toLowerCase().contains(partialAppName) ||
                            info.activityInfo.name.toLowerCase().contains(partialAppName)) {
                        return info.activityInfo.packageName;
                    }
                }
            }
        } catch (Exception e){
            Log.e("Shareable", "Failed to resolve packages for sharing.. defaulting to any. "+ e.getMessage());
            return null;
        }
        return null;

    }

    /**
     *
     * @param type
     * @return
     */
    private String parseType(int type) {
        switch (type) {
            case Builder.FACEBOOK:
                return "faceb";
            case Builder.TWITTER:
                return "twi";
            case Builder.GOOGLE_PLUS:
                return "plus";
            case Builder.TUMBLR:
                return "tumblr";
            case Builder.LINKED_IN:
                return "linkedin";
            case Builder.EMAIL:
                return "mail";
            case Builder.MESSAGES:
                return "messag";
            case Builder.REDDIT:
                return "reddit";
            default:
                return null;
        }
    }
}


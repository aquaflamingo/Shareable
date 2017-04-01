package com.robertsimoes.socialsharing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.robertsimoes.shareable.Shareable;


public class MainActivity extends AppCompatActivity {

    Button fb;
    Button twitter;
    Button gplus;
    Button messages;
    Button email;
    Button linkedin;
    Button tumblr;
    Button reddit;
    Button defaultb;

    String message = "This is my share message!";
    String url = "http://example.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fb = (Button) findViewById(R.id.button_facebook);
        twitter= (Button) findViewById(R.id.button_twitter);
        gplus = (Button) findViewById(R.id.button_gplus);
        messages= (Button) findViewById(R.id.button_messages);
        email= (Button) findViewById(R.id.button_email);
        linkedin= (Button) findViewById(R.id.button_linkedin);
        tumblr= (Button) findViewById(R.id.button_tumblr);
        reddit= (Button) findViewById(R.id.button_reddit);
        defaultb = (Button) findViewById(R.id.button_default);



    }

    public void facebook(View v) {
        Shareable shareInstance = new Shareable.Builder(this)
                .message(message)
                .socialChannel(Shareable.Builder.FACEBOOK)
                .url(url)
                .build();
        shareInstance.share();
    }

    public void twitter(View v) {
        Shareable shareInstance = new Shareable.Builder(this)
                .message(message)
                .socialChannel(Shareable.Builder.TWITTER)
                .url(url)
                .build();
        shareInstance.share();
    }
    public void plus(View v) {
        Shareable shareInstance = new Shareable.Builder(this)
                .message(message)
                .socialChannel(Shareable.Builder.GOOGLE_PLUS)
                .url(url)
                .build();
        shareInstance.share();
    }

    public void messages(View v) {
        Shareable shareInstance = new Shareable.Builder(this)
                .message(message)
                .socialChannel(Shareable.Builder.MESSAGES)
                .url(url)
                .build();
        shareInstance.share();
    }

    public void linkedin(View v) {
        Shareable shareInstance = new Shareable.Builder(this)
                .message(message)
                .socialChannel(Shareable.Builder.LINKED_IN)
                .url(url)
                .build();
        shareInstance.share();
    }

    public void email(View v) {
        Shareable shareInstance = new Shareable.Builder(this)
                .message(message)
                .socialChannel(Shareable.Builder.EMAIL)
                .url(url)
                .build();
        shareInstance.share();
    }

    public void reddit(View v) {
        Shareable shareInstance = new Shareable.Builder(this)
                .message(message)
                .socialChannel(Shareable.Builder.REDDIT)
                .url(url)
                .build();
        shareInstance.share();
    }

    public void tumblr(View v) {
        Shareable shareInstance = new Shareable.Builder(this)
                .message(message)
                .socialChannel(Shareable.Builder.TUMBLR)
                .url(url)
                .build();
        shareInstance.share();
    }

    public void defaultAction(View v) {
        Shareable shareInstance = new Shareable.Builder(this)
                .message(message)
                .url(url)
                .build();
        shareInstance.share();
    }

}

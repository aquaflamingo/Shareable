# Shareable

Deprecated - I am no longer maintaining this library. 

## Intro 

Social Sharing is a small android library to help implement direct share and social media actions into your android app.

For example if you want to share something specifically to Twitter or Facebook. 

The API is design to allow you to specify specific social channels to share to using the Builder design pattern.

If the app is not available the default is to use all `Intent.ACTION_SEND` apps on the phone.

## Install
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Shareable-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5570) 
[![](https://jitpack.io/v/robertsimoes/Shareable.svg)](https://jitpack.io/#robertsimoes/Shareable) Via [Jitpack.io](http://jitpack.io)

in root project build.gradle
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

in app project build.gradle
```
dependencies {
	        compile 'com.github.robertsimoes:Shareable:0.1.0'
	}
```

## Usage
### Basic Text Post
```
Shareable shareAction = new Shareable.Builder(this)
                        .message("This is my message")
                        .url("http://example.com")
                        .socialChannel(Shareable.Builder.TWITTER)
                        .build();
shareAction.share();
```

### Image Post
```
Uri uri = "content://com.example.package/myFile.png"
Shareable imageShare = new Shareable.Builder(this)
                        .message("This is my message")
                        .image(uri)
                        .url("http://example.com")
                        .socialChannel(Shareable.Builder.TWITTER)
                        .build();
imageShare.share();
```


## Current Social Channels Supported 

[Google+](http://plus.google.com)   
[Facebook](http://facebook.com)   
[Twitter](http://twitter.com)   
[Tumblr](http://tumblr.com)   
[LinkedIn](http://linkedin.com)   
[Reddit (tbd)](http://reddit.com)   

## License

Shareable is open-sourced under [MIT-License](https://opensource.org/licenses/MIT).




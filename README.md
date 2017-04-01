# Social Sharing

## Intro 

Social Sharing is a small android library to help implement direct share and social media actions into your android app.

For example if you want to share something specifically to Twitter or Facebook. 

The API is design to allow you to specify specific social channels to share to using the Builder design pattern.

If the app is not available the default is to use all `Intent.ACTION_SEND` apps on the phone.

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

## Author

[@RobertSimoes](http://twitter.com/robertsimoes)  
[Website](http://robertsimoes.com)

## License

```

MIT License

Copyright (c) 2017 Robert Simoes

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

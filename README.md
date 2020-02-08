# YTPlayer 

When android:autoLink="all" or Linkify.addLinks(textView, Linkify.ALL) is used to add links to web URLs, phone-numbers, map addresses or email addresses in a TextView, Android uses a class known as LinkMovementMethod that handles highlighting links when they're focused and dispatching an Intent when they're clicked.

BetterLinkify improves over Hyperlinks, shown below:

 String yourText = "Clicks are reported across all platforms. Learn more <a href='https://www.google.com'><strong>Click here</strong></a> <p><br>Please contact us on:- <br><br>MobileNo:9891983694 <br>Email-ID:alpha@gmail.com <br><br>Reference:http://google.com</p>";


<p align="left">
  <img src="https://raw.githubusercontent.com/appsfeaturebetter-linkify/master/screenshots/preview.png" alt="Preview 1" width="200" /> 
</p>
  
## Setup Project

Add this to your project build.gradle

Project-level build.gradle (<project>/build.gradle):

``` gradle 
allprojects {
    repositories {
        google()
        jcenter() 
        maven { url 'https://jitpack.io' } 
    } 
}
```

Add this to your project build.gradle

Module-level build.gradle (<module>/build.gradle): 

#### [![](https://jitpack.io/v/appsfeature/better-linkify.svg)](https://jitpack.io/#appsfeature/better-linkify)
```gradle  

dependencies {
    implementation 'com.github.appsfeature:better-linkify:x.y'
} 
```
 

#### In your layout.xml file:
```xml 

    <com.linkify.TextViewLinkify
        android:id="@+id/tv_linkify"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
                                
```

#### In your activity class:
```java 
      public class MainActivity extends AppCompatActivity {

    String yourText = "Clicks are reported across all platforms. Learn more <a href='https://www.google.com'><strong>Click here</strong></a> <p><br>Please contact us on:- <br><br>MobileNo:9891983694 <br>Email-ID:alpha@gmail.com <br><br>Reference:http://google.com</p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextViewLinkify tvDesc = findViewById(R.id.tv_post);

        tvDesc.setText(getTextData());
        tvDesc.addLinks(Linkify.ALL);
    }

    private CharSequence getTextData() {
        return LinkifyUtil.loadHtmlData(LinkifyUtil.htmlData(yourText));
    }

}
                                
```
 

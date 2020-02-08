package com.betterlinkify;

import android.os.Bundle;
import android.text.util.Linkify;

import androidx.appcompat.app.AppCompatActivity;

import com.linkify.TextViewLinkify;
import com.linkify.util.LinkifyUtil;

public class MainActivity extends AppCompatActivity {

    String yourText = "Clicks are reported across all platforms. Outcomes and session duration are available for mobile only right now, on paid plans only. Learn more <a href='https://www.google.com'><strong>Click here</strong></a>"
                        + "<p><br>Please contact us on:- <br><br>MobileNo:9891983694 <br>Email-ID:alpha@gmail.com <br><br>Reference:http://google.com</p>";

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

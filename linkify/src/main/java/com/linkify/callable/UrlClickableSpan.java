package com.linkify.callable;

import android.text.style.ClickableSpan;
import android.view.View;


import com.linkify.util.LinkifyUtil;

public class UrlClickableSpan extends ClickableSpan {

    private String url;

    public UrlClickableSpan(String url) {
        this.url = url;
    }

    @Override
    public void onClick(View v) {
        LinkifyUtil.openLinkInBrowser(v.getContext(), url);
    }
}

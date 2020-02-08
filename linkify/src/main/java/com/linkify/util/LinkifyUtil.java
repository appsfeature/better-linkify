package com.linkify.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;

public class LinkifyUtil {
    public static void openLinkInBrowser(Context context, String webUrl) {
        try {
            if (context != null) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    public static CharSequence loadHtmlData(String htmlData) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return trimHtmlData(Html.fromHtml(htmlData, Html.FROM_HTML_MODE_COMPACT));
        } else {
            return trimHtmlData(Html.fromHtml(htmlData));
        }
    }

    public static CharSequence trimHtmlData(CharSequence text) {
        while (text.charAt(text.length() - 1) == '\n') {
            text = text.subSequence(0, text.length() - 1);
        }
        return text;
    }

    public static String htmlData(String myContent) {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<html><head>"
                + "<head><body>" + "<div >" + myContent + "</div>" + "</body></html>";
        return s;
    }

}

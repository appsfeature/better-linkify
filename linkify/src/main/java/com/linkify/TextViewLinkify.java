package com.linkify;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.widget.TextView;

import com.linkify.callable.UrlClickableSpan;


/**
 * Remove both from xml resource file if added
 * android:linksClickable="true"
 * android:autoLink="web"
 */
public class TextViewLinkify extends TextView {

    public TextViewLinkify(Context context) {
        super(context);
        init();
    }

    public TextViewLinkify(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewLinkify(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setMovementMethod(LinkMovementMethod.getInstance());
        setLinksClickable(false);
        setAutoLinkMask(0x00);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
    }

    public void addLinks(int linkifyMask) {
        setHyperLinkClickableSpan();
        Linkify.addLinks(this, linkifyMask);
    }

    private void setHyperLinkClickableSpan() {
        Spannable sp = new SpannableString(getText());
        int end = sp.length();
        URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);
        SpannableStringBuilder style = new SpannableStringBuilder(sp);
        style.clearSpans();
        for (URLSpan urlSpan : urls) {
            ClickableSpan myURLSpan = new UrlClickableSpan(urlSpan.getURL());
            int start = sp.getSpanStart(urlSpan);
            int endPos = sp.getSpanEnd(urlSpan);
            style.setSpan(myURLSpan, start,
                    endPos,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        }
        setText(style);
    }
}

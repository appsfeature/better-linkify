package com.linkify;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.widget.TextView;

import com.linkify.callable.UrlClickableSpan;

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


    public void addLinks(int linkifyMask) {
        setHyperLinkClickableSpan();
        Linkify.addLinks(this, linkifyMask);
    }

    private void setHyperLinkClickableSpan() {
        setText(getSpannableStringBuilder(new SpannableString(getText())));
    }

    private SpannableStringBuilder getSpannableStringBuilder(Spannable sp) {
        SpannableStringBuilder style = new SpannableStringBuilder(sp);
        style.clearSpans();
        setEnableAllHyperLinkClickable(style, sp);
        return style;
    }

    private void setEnableAllHyperLinkClickable(SpannableStringBuilder style, Spannable sp) {
        for (URLSpan urlSpan : getURLSpan(sp)) {
            style.setSpan(new UrlClickableSpan(urlSpan.getURL()), sp.getSpanStart(urlSpan),
                    sp.getSpanEnd(urlSpan),
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        }
    }

    private URLSpan[] getURLSpan(Spannable sp) {
        return sp.getSpans(0, sp.length(), URLSpan.class);
    }
}

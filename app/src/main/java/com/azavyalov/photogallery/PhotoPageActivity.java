package com.azavyalov.photogallery;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

public class PhotoPageActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return PhotoPageFragment.newInstance(getIntent().getData());
    }

    public static Intent newIntent(Context context, Uri photoPageUrl) {
        Intent intent = new Intent(context, PhotoPageActivity.class);
        intent.setData(photoPageUrl);
        return intent;
    }

    @Override
    public void onBackPressed() {
        WebView webView = findViewById(R.id.web_view);
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

package com.example.youtube.chamiapps.youtubedowloder;


import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;





public class MainActivity extends AppCompatActivity {
    public String url;
    public FloatingActionButton fab;
    WebView mmyWebView;
    ProgressDialog progressDialog;
    ProgressBar bar;
    private FrameLayout customViewContainer;
    private WebChromeClient.CustomViewCallback customViewCallback;
    private View mCustomView;
    private myWebChromeClient mWebChromeClient;
    private myWebViewClient mWebViewClient;
    private ProgressDialog mpro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customViewContainer = (FrameLayout) findViewById(R.id.customViewContainer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" YouTube");
        toolbar.setSubtitle("  Downloader");
        //toolbar.setLogo(R.drawable.youtube11);


        // mpro=new ProgressDialog(NewsDetails.this);


        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        // progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
       // progressDialog.setIcon(R.drawable.sinhalennewsmall);
        progressDialog.setTitle("Please Wait !!!!");



        mmyWebView = (WebView) findViewById(R.id.webview);
        // bar=(ProgressBar) findViewById(R.id.progressBar2);

        WebSettings webSettings = mmyWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mmyWebView.setBackgroundColor(Color.TRANSPARENT);
        mWebViewClient = new myWebViewClient();
        mmyWebView.setWebViewClient(mWebViewClient);

        mWebChromeClient = new myWebChromeClient();
        mmyWebView.setWebChromeClient(mWebChromeClient);

        mmyWebView.getSettings().setJavaScriptEnabled(true);
        mmyWebView.getSettings().setAppCacheEnabled(true);
        mmyWebView.getSettings().setBuiltInZoomControls(true);
        mmyWebView.getSettings().setSaveFormData(true);
        mmyWebView.getSettings().setBuiltInZoomControls(false);
        mmyWebView.getSettings().setDisplayZoomControls(false);

        // Bundle bundle = getIntent().getExtras();
        // String message = bundle.getString("message");
        url = "http://www.youtube.com";


        //   mpro.setMessage("Loading");
        //    mpro.show();
        //    mpro.setCancelable(false);

        // Bundle bundle=getIntent().getExtras();
        //  progressDialog.show();

        Toast.makeText(MainActivity.this, "Loading please Wait!", Toast.LENGTH_SHORT).show();
        mmyWebView.loadUrl(url);


        //  progressDialog.dismiss();
        //String link="www.youtube.com";
        //mmyWebView.loadUrl(link);

        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getBaseContext(),"oopssss Something Wrong please select a video !",Toast.LENGTH_LONG).show();
            }
        });

        button.setVisibility(View.GONE);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main1, menu);

        MenuItem itemSitch = menu.findItem(R.id.show_secure);

        itemSitch.setActionView(R.layout.show_protected_switch);

        final Switch sw =(Switch) menu.findItem(R.id.show_secure).getActionView().findViewById(R.id.action_switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getBaseContext(), "If you click this button first you need to select a video !", Toast.LENGTH_LONG).show();

                    Toast.makeText(getBaseContext(), "Download Enable!", Toast.LENGTH_LONG).show();


                    Button button = (Button) findViewById(R.id.button3);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //  mmyWebView.reload();
                            String webUrl = mmyWebView.getUrl();
                            String user="user";
                            String channel= "channel";
                            String assest="android_asset";
                            String savefrom="en.savefrom";
                            // String neww = webUrl.replace("m.","ss");

                            //  mmyWebView.loadUrl(neww);
                            //   mmyWebView.scrollTo(100,100);

                            // if(webUrl.charAt(24) == 'u'){
                            // Toast.makeText(NewsDetails.this, "It is not downlode link", Toast.LENGTH_SHORT).show();

                            //   }

                            // if(mmyWebView.getUrl().isEmpty()){


                            if (TextUtils.isEmpty(webUrl)) {
                                Toast.makeText(MainActivity.this, "Downlode not available", Toast.LENGTH_SHORT).show();

                            } else if (TextUtils.regionMatches(webUrl, 22, user, 0, 4)) {
                                Toast.makeText(MainActivity.this, "Downlode not available please select a video !", Toast.LENGTH_SHORT).show();
                            }

                            else if(TextUtils.regionMatches(webUrl,22,channel,0,4)){

                                Toast.makeText(MainActivity.this, "Downlode not available please select a video !", Toast.LENGTH_SHORT).show();

                            }

                            else if(TextUtils.regionMatches(webUrl,8,assest,0,4)){

                                Toast.makeText(MainActivity.this, "Downlode not available!", Toast.LENGTH_SHORT).show();

                            }
                /*


                else if(TextUtils.regionMatches(webUrl,6,savefrom,0,10)){

                    Toast.makeText(NewsDetails.this, "Downlode not available!", Toast.LENGTH_SHORT).show();

                }

                */

                            else{

/*
                    mpro.setMessage("Loading");
                    mpro.show();
                    mpro.setCancelable(false);
*/
                                String neww = webUrl.replace("m.","ss");

                                mmyWebView.loadUrl(neww);

                                Button button = (Button) findViewById(R.id.button3);

                                button.setVisibility(View.INVISIBLE);


                                Toast.makeText(MainActivity.this, "processing To Download Wait!!!!!", Toast.LENGTH_SHORT).show();
                                for(int i=0;i<3;i++) {

                                    Toast.makeText(MainActivity.this, "Please Wait!!!!", Toast.LENGTH_SHORT).show();
                                }

                                Toast.makeText(MainActivity.this,"Redirect to savefrom.net!!!!!", Toast.LENGTH_SHORT).show();

                                // mpro.dismiss();
                            }


                            mmyWebView.setDownloadListener(new DownloadListener() {

                                public void onDownloadStart(String url, String userAgent,
                                                            String contentDisposition, String mimetype,
                                                            long contentLength) {
                                    DownloadManager.Request request = new DownloadManager.Request(
                                            Uri.parse(url));

                                    request.allowScanningByMediaScanner();
                                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Youtube Downloader!!!! ");
                                    DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                                    dm.enqueue(request);
                                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                                    intent.setType("*/*");
                                    intent.describeContents();
                                    Toast.makeText(getApplicationContext(), "Downloading File!",
                                            Toast.LENGTH_LONG).show();

                                }
                            });
                        }
                    });

                    button.setVisibility(View.VISIBLE);

                }
                else{
                    Button button = (Button) findViewById(R.id.button3);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                        }
                    });

                    button.setVisibility(View.INVISIBLE);
                    Toast.makeText(getBaseContext(), "Download Disable!", Toast.LENGTH_LONG).show();

                }
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings1) {

            mmyWebView.reload();
            Toast.makeText(MainActivity.this, "Refershing......", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "Loading please Wait!", Toast.LENGTH_SHORT).show();


            return true;
        }

        if (id== R.id.show_secure){


            return  true;
        }





        if (id == R.id.action_settings2) {
            Intent myintent = new Intent(Intent.ACTION_SEND);
            String webUrl = mmyWebView.getUrl();
            //String title = "Subscribe this channel";
            myintent.setType("text/plain");
            myintent.putExtra(Intent.EXTRA_TEXT, "SHARE via Youtube Downloader" +"\n" + webUrl);
            //  myintent.putExtra(Intent.EXTRA_TEXT, url);
            startActivity(Intent.createChooser(myintent, "Youtube Downloader Youtube | Share Using"));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public boolean inCustomView() {return (mCustomView != null);
    }

    public void hideCustomView() {
        mWebChromeClient.onHideCustomView();
    }





    @Override
    protected void onPause() {
        super.onPause();
        mmyWebView.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mmyWebView.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (inCustomView()) {
            hideCustomView();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (inCustomView()) {
                hideCustomView();
                return true;
            }

            if ((mCustomView == null) && mmyWebView.canGoBack()) {
                mmyWebView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportActionBar().hide();
            Toast.makeText(MainActivity.this, "Orientation Changed", Toast.LENGTH_SHORT).show();

            Toast.makeText(MainActivity.this, "Action Bar hide!", Toast.LENGTH_SHORT).show();

        } else {
            getSupportActionBar().show();
            Toast.makeText(MainActivity.this, "Orientation Changed", Toast.LENGTH_SHORT).show();
        }
    }

    class myWebChromeClient extends WebChromeClient {
        private Bitmap mDefaultVideoPoster;
        private View mVideoProgressView;

        @Override
        public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) {
            onShowCustomView(view, callback);
        }

        @Override
        public void onShowCustomView(View view,CustomViewCallback callback) {


            if (mCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }
            mCustomView = view;
            mmyWebView.setVisibility(View.GONE);
            customViewContainer.setVisibility(View.VISIBLE);
            customViewContainer.addView(view);
            customViewCallback = callback;
        }

        @Override
        public View getVideoLoadingProgressView() {

            if (mVideoProgressView == null) {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                mVideoProgressView = inflater.inflate(R.layout.video_progress, null);
            }
            return mVideoProgressView;
        }







        @Override
        public void onHideCustomView() {
            super.onHideCustomView();
            if (mCustomView == null)
                return;

            mmyWebView.setVisibility(View.VISIBLE);
            customViewContainer.setVisibility(View.GONE);


            mCustomView.setVisibility(View.GONE);


            customViewContainer.removeView(mCustomView);
            customViewCallback.onCustomViewHidden();

            mCustomView = null;
        }



    }

    class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);


        }


        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressDialog.dismiss();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressDialog.show();
        }






        public void onReceivedError(WebView mmyWebView, int errorCode, String description, String failingUrl) {

            Toast.makeText(MainActivity.this, "Please Check Internet connection!", Toast.LENGTH_SHORT).show();

        }





    }


}

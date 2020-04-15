package com.avidly.sample;


import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "IronSourceMd_log";
    private String IronSourc_AppKey = "bf38208d";
    private String rewardVideoPlacement = "DefaultRewardedVideo";
    private String interAdsPlacement = "DefaultInterstitial";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.DEBUG) {
            IntegrationHelper.validateIntegration(this);
            IronSource.setAdaptersDebug(true);
        }

        // 用户选择同意遵守CDPR AND CPPA
        IronSource.setConsent(true);
        IronSource.setMetaData("do_not_sell","true");

        Bundle extras = new Bundle();
        extras.putString("npa", "1");
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.tagForChildDirectedTreatment(true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, extras);

        IronSource.init(this, IronSourc_AppKey);
        IronSource.loadInterstitial();
        IronSource.setRewardedVideoListener(new MyRewardVideoListener());
        IronSource.setInterstitialListener(new MyInterAdsListener());


    }

    @Override
    protected void onResume() {
        super.onResume();
        IronSource.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        IronSource.onPause(this);
    }

    public void ShowInter(View view) {
        if (IronSource.isInterstitialReady()) {
            IronSource.showInterstitial(interAdsPlacement);
        } else {
            Toast.makeText(this, "no inter ads ready", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShowRewardVideo(View view) {
        if (IronSource.isRewardedVideoAvailable()) {
            IronSource.showRewardedVideo(rewardVideoPlacement);
        } else {
            Toast.makeText(this, "no reward video ready", Toast.LENGTH_SHORT).show();
        }

    }

    class MyRewardVideoListener implements RewardedVideoListener {

        @Override
        public void onRewardedVideoAdOpened() {
            Log.i(TAG, "onRewardedVideoAdOpened: ");
        }

        @Override
        public void onRewardedVideoAdClosed() {
            Log.i(TAG, "onRewardedVideoAdClosed: ");

        }

        @Override
        public void onRewardedVideoAvailabilityChanged(boolean b) {
            Log.i(TAG, "onRewardedVideoAvailabilityChanged: " + b);

        }

        @Override
        public void onRewardedVideoAdStarted() {
            Log.i(TAG, "onRewardedVideoAdStarted: ");
        }

        @Override
        public void onRewardedVideoAdEnded() {
            Log.i(TAG, "onRewardedVideoAdEnded: ");

        }

        @Override
        public void onRewardedVideoAdRewarded(Placement placement) {
            Log.i(TAG, "onRewardedVideoAdRewarded: " + placement);

        }

        @Override
        public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
            Log.i(TAG, "onRewardedVideoAdShowFailed: " + ironSourceError.getErrorMessage());

        }

        @Override
        public void onRewardedVideoAdClicked(Placement placement) {
            Log.i(TAG, "onRewardedVideoAdClicked: " + placement);

        }
    }

    class MyInterAdsListener implements InterstitialListener {

        @Override
        public void onInterstitialAdReady() {
            Log.i(TAG, "onInterstitialAdReady: ");
        }

        @Override
        public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
            Log.i(TAG, "onInterstitialAdLoadFailed: " + ironSourceError.getErrorMessage());
        }

        @Override
        public void onInterstitialAdOpened() {
            Log.i(TAG, "onInterstitialAdOpened: ");
        }

        @Override
        public void onInterstitialAdClosed() {
            Log.i(TAG, "onInterstitialAdClosed: ");
        }

        @Override
        public void onInterstitialAdShowSucceeded() {
            Log.i(TAG, "onInterstitialAdShowSucceeded: ");
        }

        @Override
        public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
            Log.i(TAG, "onInterstitialAdShowFailed: " + ironSourceError.getErrorMessage());
        }

        @Override
        public void onInterstitialAdClicked() {
            Log.i(TAG, "onInterstitialAdClicked: ");

        }
    }
}

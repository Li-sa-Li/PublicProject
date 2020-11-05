package com.unstall.meetdeleteapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.tradplus.ads.mobileads.*
import com.tradplus.ads.mobileads.TradPlusView.FSAdViewListener
import com.tradplus.ads.mobileads.util.TestDeviceUtil
import com.tradplus.ads.network.OnAllInterstatitialLoadedStatusListener

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TradPlus.invoker().initSDK(this, "FDC48B1D9D9E1F5CBD0C327159C8191C")
        TestDeviceUtil.getInstance().isNeedTestDevice=true
        var banner = findViewById<Button>(R.id.btn_banner)
        var native = findViewById<Button>(R.id.btn_native)
        var interstitialLoad = findViewById<Button>(R.id.btn_interstitial_load)
        var interstitialShow = findViewById<Button>(R.id.btn_interstitial_show)
        var rewardLoad = findViewById<Button>(R.id.btn_reward_load)
        var rewardShow = findViewById<Button>(R.id.btn_reward_show)
        var nativeView = findViewById<TradPlusView>(R.id.native_view)
        nativeView.setAdLayoutName("native_ad_list_item")
        nativeView.setAdViewListener(object : FSAdViewListener {
            override fun onAdViewFailed(p0: TradPlusView?, p1: TradPlusErrorCode?) {
                if (p1 != null) {
                    println(p1.code)
                    println(p1.errormessage)
                }
                Toast.makeText(this@MainActivity, "onAdViewFailed", Toast.LENGTH_SHORT).show()
            }

            override fun onAdViewLoaded(p0: TradPlusView?) {
                Toast.makeText(this@MainActivity, "onAdViewLoaded", Toast.LENGTH_SHORT).show()
            }


            override fun onAdViewExpanded(p0: TradPlusView?) {
                Toast.makeText(this@MainActivity, "onAdViewExpanded", Toast.LENGTH_SHORT).show()
            }

            override fun onAdViewClicked(p0: TradPlusView?) {
                Toast.makeText(this@MainActivity, "onAdViewClicked", Toast.LENGTH_SHORT).show()
            }

            override fun onAdViewCollapsed(p0: TradPlusView?) {
                Toast.makeText(this@MainActivity, "onAdViewCollapsed", Toast.LENGTH_SHORT).show()
            }

            override fun onAdsSourceLoaded(p0: Any?) {
                Toast.makeText(this@MainActivity, "onAdsSourceLoaded", Toast.LENGTH_SHORT).show()
            }

        });
        nativeView.adUnitId="717DBEA164515602CE57A1A68349CC7F"//7高级原生1
//        nativeView.adUnitId="04D8F97E539A50D52E01BA0898135E02"//3高级原生1
        var bannerView = findViewById<TradPlusView>(R.id.banner_view)
//        bannerView.adUnitId="08AC7169347CCD56B0578A142C7CA209"//7横幅2
        bannerView.adUnitId="E89A890466180B9215487530A8EB519F"//3横幅1

        bannerView.setAdViewListener(object : FSAdViewListener {
            override fun onAdViewFailed(p0: TradPlusView?, p1: TradPlusErrorCode?) {
                if (p1 != null) {
                    println(p1.code)
                    println(p1.errormessage)
                }
                Log.i(TAG,"onAdViewFailed")
                Toast.makeText(this@MainActivity, "onAdViewFailed", Toast.LENGTH_SHORT).show()
            }

            override fun onAdViewLoaded(p0: TradPlusView?) {
                Log.i(TAG, "onAdViewLoaded: ")
                Toast.makeText(this@MainActivity, "onAdViewLoaded", Toast.LENGTH_SHORT).show()
            }


            override fun onAdViewExpanded(p0: TradPlusView?) {
                Log.i(TAG, "onAdViewExpanded: ")
                Toast.makeText(this@MainActivity, "onAdViewExpanded", Toast.LENGTH_SHORT).show()
            }

            override fun onAdViewClicked(p0: TradPlusView?) {
                Log.i(TAG, "onAdViewClicked: ")
                Toast.makeText(this@MainActivity, "onAdViewClicked", Toast.LENGTH_SHORT).show()
            }

            override fun onAdViewCollapsed(p0: TradPlusView?) {
                Log.i(TAG, "onAdViewCollapsed: ")
                Toast.makeText(this@MainActivity, "onAdViewCollapsed", Toast.LENGTH_SHORT).show()
            }

            override fun onAdsSourceLoaded(p0: Any?) {
                Log.i(TAG, "onAdsSourceLoaded: ")
                Toast.makeText(this@MainActivity, "onAdsSourceLoaded", Toast.LENGTH_SHORT).show()
            }

        })
        banner.setOnClickListener {
            bannerView.loadAd()
        }
        native.setOnClickListener{
            nativeView.loadAd()
        }
//        var tradPlusInterstitialExt = TradPlusInterstitialExt(this,"60D08A0E5B5422D9771D237B8CE8AC9A")//7插屏1
        var tradPlusInterstitialExt = TradPlusInterstitialExt(this,"788E1FCB278B0D7E97282231154458B7")//3插屏1
        tradPlusInterstitialExt.setCanLoadListener {
            tradPlusInterstitialExt.load()
        }

        tradPlusInterstitialExt.setOnAllInterstatitialLoadedStatusListener(object :OnAllInterstatitialLoadedStatusListener{
            override fun onLoadStatus(p0: Boolean, p1: String?) {
                Log.i(TAG, "onLoadStatus: ")
                Toast.makeText(this@MainActivity, "onLoadStatus", Toast.LENGTH_SHORT).show()
            }

        })
        tradPlusInterstitialExt.setInterstitialAdListener(object : TradPlusInterstitial.InterstitialAdListener {
            override fun onInterstitialLoaded(p0: TradPlusInterstitial?) {
                Log.i(TAG, "onInterstitialLoaded: ")
                Toast.makeText(this@MainActivity, "onInterstitialLoaded", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialShown(p0: TradPlusInterstitial?) {
                Log.i(TAG, "onInterstitialShown: ")
                Toast.makeText(this@MainActivity, "onInterstitialShown", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialFailed(p0: TradPlusInterstitial?, p1: TradPlusErrorCode?) {
                if (p1 != null) {
                    println(p1.code)
                    println(p1.errormessage)
                }
                Log.i(TAG, "onInterstitialFailed: ")
                Toast.makeText(this@MainActivity, "onInterstitialFailed", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialRewarded(p0: TradPlusInterstitial?, p1: String?, p2: Int) {
                Log.i(TAG, "onInterstitialRewarded: ")
                Toast.makeText(this@MainActivity, "onInterstitialRewarded", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialDismissed(p0: TradPlusInterstitial?) {
                Log.i(TAG, "onInterstitialDismissed: ")
                Toast.makeText(this@MainActivity, "onInterstitialDismissed", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialLoad(p0: TradPlusInterstitial?) {
                Log.i(TAG, "onInterstitialLoad: ")
                Toast.makeText(this@MainActivity, "onInterstitialLoad", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialClicked(p0: TradPlusInterstitial?) {
                Log.i(TAG, "onInterstitialClicked: ")
                Toast.makeText(this@MainActivity, "onInterstitialClicked", Toast.LENGTH_SHORT).show()
            }

        })
        tradPlusInterstitialExt.initUnitId()
        interstitialLoad.setOnClickListener {
            Log.i(TAG, "onCreate: load.....")
            Toast.makeText(this@MainActivity,"load....",Toast.LENGTH_SHORT).show();
            tradPlusInterstitialExt.load()
        }
        interstitialShow.setOnClickListener {
            Log.i(TAG, "onCreate: show.....")
            Toast.makeText(this@MainActivity,"show....",Toast.LENGTH_SHORT).show();
            tradPlusInterstitialExt.show()
        }
//        var tradPlusReward = TradPlusInterstitialExt(this, "DCCFE625A6DF34848DFAFBD9018401B0")//7激励
        var tradPlusReward = TradPlusInterstitialExt(this, "702208A872E622C1729FC621025D4B1D")//3激励1
        tradPlusReward.setCanLoadListener {
            tradPlusReward.load()
        }

        tradPlusReward.setOnAllInterstatitialLoadedStatusListener(object :OnAllInterstatitialLoadedStatusListener{
            override fun onLoadStatus(p0: Boolean, p1: String?) {
                Log.i(TAG, "onLoadStatus: ")
                Toast.makeText(this@MainActivity, "onLoadStatus", Toast.LENGTH_SHORT).show()
            }

        })
        tradPlusReward.setInterstitialAdListener(object : TradPlusInterstitial.InterstitialAdListener {
            override fun onInterstitialLoaded(p0: TradPlusInterstitial?) {
                Log.i(TAG, "onInterstitialLoaded: ")
                Toast.makeText(this@MainActivity, "onInterstitialLoaded", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialShown(p0: TradPlusInterstitial?) {
                Log.i(TAG, "onInterstitialShown: ")
                Toast.makeText(this@MainActivity, "onInterstitialShown", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialFailed(p0: TradPlusInterstitial?, p1: TradPlusErrorCode?) {
                if (p1 != null) {
                    println(p1.code)
                    println(p1.errormessage)
                }
                Log.i(TAG, "onInterstitialFailed: ")
                Toast.makeText(this@MainActivity, "onInterstitialFailed", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialRewarded(p0: TradPlusInterstitial?, p1: String?, p2: Int) {
                Log.i(TAG, "onInterstitialRewarded: ")
                Toast.makeText(this@MainActivity, "onInterstitialRewarded", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialDismissed(p0: TradPlusInterstitial?) {
                Log.i(TAG, "onInterstitialDismissed: ")
                Toast.makeText(this@MainActivity, "onInterstitialDismissed", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialLoad(p0: TradPlusInterstitial?) {
                Log.i(TAG, "onInterstitialLoad: ")
                Toast.makeText(this@MainActivity, "onInterstitialLoad", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialClicked(p0: TradPlusInterstitial?) {
                Log.i(TAG, "onInterstitialClicked: ")
                Toast.makeText(this@MainActivity, "onInterstitialClicked", Toast.LENGTH_SHORT).show()
            }

        })
        tradPlusReward.initUnitId()
        rewardLoad.setOnClickListener {
            tradPlusReward.load()
        }
        rewardShow.setOnClickListener {
            tradPlusReward.show()
        }
    }
    var interstitialListener = object : TradPlusInterstitial.InterstitialAdListener {
        override fun onInterstitialLoaded(p0: TradPlusInterstitial?) {
            Log.i(TAG, "onInterstitialLoaded: ")
            Toast.makeText(this@MainActivity, "onInterstitialLoaded", Toast.LENGTH_SHORT).show()
        }

        override fun onInterstitialShown(p0: TradPlusInterstitial?) {
            Log.i(TAG, "onInterstitialShown: ")
            Toast.makeText(this@MainActivity, "onInterstitialShown", Toast.LENGTH_SHORT).show()
        }

        override fun onInterstitialFailed(p0: TradPlusInterstitial?, p1: TradPlusErrorCode?) {
            if (p1 != null) {
                println(p1.code)
                println(p1.errormessage)
            }
            Log.i(TAG, "onInterstitialFailed: ")
            Toast.makeText(this@MainActivity, "onInterstitialFailed", Toast.LENGTH_SHORT).show()
        }

        override fun onInterstitialRewarded(p0: TradPlusInterstitial?, p1: String?, p2: Int) {
            Log.i(TAG, "onInterstitialRewarded: ")
            Toast.makeText(this@MainActivity, "onInterstitialRewarded", Toast.LENGTH_SHORT).show()
        }

        override fun onInterstitialDismissed(p0: TradPlusInterstitial?) {
            Log.i(TAG, "onInterstitialDismissed: ")
            Toast.makeText(this@MainActivity, "onInterstitialDismissed", Toast.LENGTH_SHORT).show()
        }

        override fun onInterstitialLoad(p0: TradPlusInterstitial?) {
            Log.i(TAG, "onInterstitialLoad: ")
            Toast.makeText(this@MainActivity, "onInterstitialLoad", Toast.LENGTH_SHORT).show()
        }

        override fun onInterstitialClicked(p0: TradPlusInterstitial?) {
            Log.i(TAG, "onInterstitialClicked: ")
            Toast.makeText(this@MainActivity, "onInterstitialClicked", Toast.LENGTH_SHORT).show()
        }

    }
    var value = object : FSAdViewListener {
        override fun onAdViewFailed(p0: TradPlusView?, p1: TradPlusErrorCode?) {
            if (p1 != null) {
                println(p1.code)
                println(p1.errormessage)
            }
            Log.i(TAG, "onAdViewFailed: ")
            Toast.makeText(this@MainActivity, "onAdViewFailed", Toast.LENGTH_SHORT).show()
        }

        override fun onAdViewLoaded(p0: TradPlusView?) {
            Log.i(TAG, "onAdViewLoaded: ")
            Toast.makeText(this@MainActivity, "onAdViewLoaded", Toast.LENGTH_SHORT).show()
        }


        override fun onAdViewExpanded(p0: TradPlusView?) {
            Log.i(TAG, "onAdViewExpanded: ")
            Toast.makeText(this@MainActivity, "onAdViewExpanded", Toast.LENGTH_SHORT).show()
        }

        override fun onAdViewClicked(p0: TradPlusView?) {
            Log.i(TAG, "onAdViewClicked: ")
            Toast.makeText(this@MainActivity, "onAdViewClicked", Toast.LENGTH_SHORT).show()
        }

        override fun onAdViewCollapsed(p0: TradPlusView?) {
            Log.i(TAG, "onAdViewCollapsed: ")
            Toast.makeText(this@MainActivity, "onAdViewCollapsed", Toast.LENGTH_SHORT).show()
        }

        override fun onAdsSourceLoaded(p0: Any?) {
            Log.i(TAG, "onAdsSourceLoaded: ")
            Toast.makeText(this@MainActivity, "onAdsSourceLoaded", Toast.LENGTH_SHORT).show()
        }

    }
}
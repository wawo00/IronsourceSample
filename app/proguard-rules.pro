-keepclassmembers class com.ironsource.sdk.controller.IronSourceWebView$JSInterface {
    public *;
}
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keep public class com.google.android.gms.ads.** {
   public *;
}
-keep class com.ironsource.adapters.** { *;
}
-dontwarn com.ironsource.mediationsdk.**
-dontwarn com.ironsource.adapters.**
-dontwarn com.moat.**
-keep class com.moat.** { public protected private *; }

# For communication with AdColony's WebView
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}
# Keep ADCNative class members unobfuscated
-keepclassmembers class com.adcolony.sdk.ADCNative** {
    *;
 }

 -keepattributes Signature,InnerClasses,Exceptions,Annotation
 -keep public class com.applovin.sdk.AppLovinSdk{ *; }
 -keep public class com.applovin.sdk.AppLovin* { public protected *; }
 -keep public class com.applovin.nativeAds.AppLovin* { public protected *; }
 -keep public class com.applovin.adview.* { public protected *; }
 -keep public class com.applovin.mediation.* { public protected *; }
 -keep public class com.applovin.mediation.ads.* { public protected *; }
 -keep public class com.applovin.impl.*.AppLovin { public protected *; }
 -keep public class com.applovin.impl.**.*Impl { public protected *; }
 -keepclassmembers class com.applovin.sdk.AppLovinSdkSettings { private java.util.Map localSettings; }
 -keep class com.applovin.mediation.adapters.** { *; }
 -keep class com.applovin.mediation.adapter.**{ *; }



# google
-keep class * extends java.util.ListResourceBundle {
    protected java.lang.Object[][] getContents();
}
-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}
-keepclassmembers enum * {
  public static **[] values();
  public static ** valueOf(java.lang.String);
}
-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}
-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
-keep class * extends java.util.ListResourceBundle {
    protected java.lang.Object[][] getContents();
}
-keep class com.google.android.gms.ads.** {*;}
-keep class com.google.android.gms.common.** {*;}
-dontwarn com.google.android.gms.**
-dontwarn com.google.protobuf.**
-keep class com.google.ads.mediation.** {*;}
-dontwarn com.google.ads.mediation.**
# google end


#google gms identifier start
-keep class com.google.android.gms.ads.identifier.** { *; }
#google gms identifier end


-keep class com.chartboost.** { *; }

-dontwarn com.facebook.ads.internal.**
-keeppackagenames com.facebook.*
-keep public class com.facebook.ads.**{ public protected *; }


-keepattributes Signature
-keepattributes *Annotation*
-keep class com.mintegral.** {*; }
-keep interface com.mintegral.** {*; }
-keep class android.support.v4.** { *; }
-dontwarn com.mintegral.**
-keep class **.R$* { public static final int mintegral*; }
-keep class com.alphab.** {*; }
-keep interface com.alphab.** {*; }

# Keep filenames and line numbers for stack traces
-keepattributes SourceFile,LineNumberTable
# Keep JavascriptInterface for WebView bridge
-keepattributes JavascriptInterface
# Sometimes keepattributes is not enough to keep annotations
-keep class android.webkit.JavascriptInterface {
   *;
}
# Keep all classes in Unity Ads package
-keep class com.unity3d.ads.** {
   *;
}
# Keep all classes in Unity Services package
-keep class com.unity3d.services.** {
   *;
}
-dontwarn com.google.ar.core.**
-dontwarn com.unity3d.services.**
-dontwarn com.ironsource.adapters.unityads.**


# Vungle
-keep class com.vungle.warren.** { *; }
-dontwarn com.vungle.warren.error.VungleError$ErrorCode
# Moat SDK
-keep class com.moat.** { *; }
-dontwarn com.moat.**
# Okio
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
# Retrofit
-dontwarn okio.**
-dontwarn retrofit2.Platform$Java8
# Gson
-keepattributes Signature
-keepattributes *Annotation*
-dontwarn sun.misc.**
-keep class com.google.gson.examples.android.model.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
# Google Android Advertising ID
-keep class com.google.android.gms.internal.** { *; }
-dontwarn com.google.android.gms.ads.identifier.**
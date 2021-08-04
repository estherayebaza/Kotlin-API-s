# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#Leakcanary
-dontwarn com.squareapp.haha.guava.**
-dontwarn com.squareapp.haha.perflib.**
-dontwarn com.squareapp.haha.trove.**
-dontwarn com.squareapp.leakcanary.**
#noinspection ShrinkerUnRessolvedRefrence
-keep class com.squareapp.haha.**{*;}
-keep class com.squareapp.leakcanary.**{*;}
-dontwarn android.app.Notification
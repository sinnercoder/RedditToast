# RedditToast
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=14)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)

![Screenshot_20210408-123136__01](https://user-images.githubusercontent.com/22097600/113993996-a06b1c80-9872-11eb-84b5-c96a8d92d90c.jpg)

This library is inspired by Toast of Reddit android app. You can use this Toast and configure it accordingly as per you your UI.

It takes  your app icon as your default icon, you can change the icon passing drawable or resource Id in parameter.

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
  implementation 'com.github.sinnercoder:RedditToast:1.1'
}
```

## RedditToast Configuration
You can Configure your Toast, but this is  optional. You can use it anywhere in your code:
```java
RedditToast.RedditToastConfiguration.getInstance()
                .setDuration(RedditToast.LENGTH_LONG)
                .setTextColor(Color.BLACK)
                .setBackgroundColor(Color.WHITE)
                .setUseIcon(false)
                .setTextSize(13)
                .setToastTypeface(Typeface.createFromAsset(getAssets(), "custom.ttf"))
                .commit();
```
Reset the toast configuration using `reset` method:
```java
RedditToast.RedditToastConfiguration.resetConfiguration();
```

## Usage

Each method always returns a `Toast` object, so you can customize the Toast much more. **DON'T FORGET THE `show()` METHOD!**

To display a default Toast:

``` java
RedditToast.makeToast(MainActivity.this, "This is default toast!", RedditToast.ToastType.DEFAULT).show());
```

To display an error Toast:

``` java
RedditToast.makeToast(MainActivity.this, "This is error toast!", RedditToast.ToastType.ERROR).show());
```

To display a success Toast:

``` java
RedditToast.makeToast(MainActivity.this, "This is success toast!", RedditToast.ToastType.SUCCESS).show());
```

To display a warning Toast:

``` java
RedditToast.makeToast(MainActivity.this, "This is warning toast!", RedditToast.ToastType.WARNING).show());
```

To display an info Toast:

``` java
RedditToast.makeToast(MainActivity.this, "This is info toast!", RedditToast.ToastType.INFO).show());
```

To display toast with custom  icon:

``` java
Drawable icon = AppCompatResources.getDrawable(MainActivity.this, R.drawable.check);
RedditToast.makeToast(MainActivity.this, "This is with icon toast!", icon, RedditToast.ToastType.SUCCESS).show();

//You can directly use Resource Id too.
RedditToast.makeToast(MainActivity.this, "This is with icon toast!", R.drawable.check, RedditToast.ToastType.SUCCESS).show();
```

To display a toast by changing background color and text color:

``` java
RedditToast.RedditToastConfiguration.getInstance().setBackgroundColor(Color.WHITE).setTextColor(Color.BLACK).commit();
RedditToast.makeToast(MainActivity.this, "Toast with White background.", RedditToast.ToastType.SUCCESS).show();
RedditToast.RedditToastConfiguration.resetConfiguration();
```

To display a toast without icon:

``` java
RedditToast.RedditToastConfiguration.getInstance().setUseIcon(false).commit();
RedditToast.makeToast(MainActivity.this, "This is without icon toast!",RedditToast.ToastType.WARNING).show();
RedditToast.RedditToastConfiguration.resetConfiguration();
```

To display a toast with Custom Font:

``` java
Typeface typeface = Typeface.createFromAsset(getAssets(), "mr_robot.ttf");
RedditToast.RedditToastConfiguration.getInstance().setToastTypeface(typeface).setDuration(RedditToast.LENGTH_LONG).commit();
RedditToast.makeToast(MainActivity.this, "Mr. Robot! ", R.drawable.robot, RedditToast.ToastType.WARNING).show();
RedditToast.RedditToastConfiguration.resetConfiguration();
```

## Screenshots

**Please click the image below to enlarge.**
![screenshot jpg](https://user-images.githubusercontent.com/22097600/113986876-60546b80-986b-11eb-8836-988f4d39d376.png)


## Contribute
If you find any bugs or want to contribute project with any feature you are most welcome.

You can fork this project and contribute using the 
[pull requests](https://github.com/sinnercoder/RedditToast/pulls).

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2021 SinnerCoder

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

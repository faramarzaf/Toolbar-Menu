# Toolbar-Menu   

**Toolbar**  

<p align="center">
  <img src="https://i.stack.imgur.com/wJvoA.png" />
</p>

These steps describe how to set up a Toolbar as your activity's app bar:  

- Add the `v7 appcompat` support library to your project, as described in Support Library Setup.  
- Make sure the activity extends `AppCompatActivity`:  
 
 ```java
    public class MyActivity extends AppCompatActivity {
      // ...
    }
```

In the app manifest, set the `<application>` element to use one of appcompat's NoActionBar themes. Using one of these themes prevents the app from using the native ActionBar class to provide the app bar. For example:  

```xml
<application
    android:theme="@style/Theme.AppCompat.Light.NoActionBar"
    />
```
Add a Toolbar to the activity's layout. For example, the following layout code adds a Toolbar and gives it the appearance of floating above the activity:  

```xml
<android.support.v7.widget.Toolbar
   android:id="@+id/my_toolbar"
   android:layout_width="match_parent"
   android:layout_height="?attr/actionBarSize"
   android:background="?attr/colorPrimary"
   android:elevation="4dp"
   android:theme="@style/ThemeOverlay.AppCompat.ActionBar"
   app:popupTheme="@style/ThemeOverlay.AppCompat.Light"/>
```
 
In the activity's `onCreate()` method, call the activity's `setSupportActionBar()` method, and pass the activity's toolbar. This method sets the toolbar as the app bar for the activity. For example:  

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);
    Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
    setSupportActionBar(myToolbar);
}
```

<p align="center">
  <img src="https://storage.googleapis.com/spec-host-backup/mio-components%2Fassets%2F1nsuL8VDpBW_LZYXgabK1H0uq6icmmKYt%2Fnav-drawer-intro.png" height=450 width=330/>
  
   <img src="https://nexttechpro.com/wp-content/uploads/2019/11/Android-Navigation-Drawer-576x1024.png" height=450 width=300/>
</p>

**Navigation drawer**  
Navigation drawers provide access to destinations in your app.   
Android Navigation Drawer is a sliding left/right menu that is used to display the important links in the application.   
It’s not visible by default and it needs to opened either by sliding from left or clicking its icon in the ActionBar.   




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

**Navigation drawer**  
Navigation drawers provide access to destinations in your app.   
Android Navigation Drawer is a sliding left/right menu that is used to display the important links in the application.   
It’s not visible by default and it needs to opened either by sliding from left or clicking its icon in the ActionBar. 


<p align="center">
  <img src="https://storage.googleapis.com/spec-host-backup/mio-components%2Fassets%2F1nsuL8VDpBW_LZYXgabK1H0uq6icmmKYt%2Fnav-drawer-intro.png" height=450 width=330/>
  
   <img src="https://nexttechpro.com/wp-content/uploads/2019/11/Android-Navigation-Drawer-576x1024.png" height=450 width=300/>
</p>

  
**Menu**
In android, Options Menu is a primary collection of menu items for an activity and it is useful to implement actions that have a global impact on the app, such as Settings, Search, etc.  


<p align="center">
   <img src="https://storage.googleapis.com/spec-host-backup/mio-components%2Fassets%2F1ixtKTgDPwib40W0c02LwLm_dBMiJ6Wi2%2Fmenu-shrine-ahero.png"/>
</p>

To define the menu, create an XML file inside your project's `res/menu/` directory and build the menu with the following elements:   

`<menu>`  
Defines a Menu, which is a container for menu items. A `<menu>` element must be the root node for the file and can hold one or more `<item>` and `<group>` elements.  

`<item>`
Creates a MenuItem, which represents a single item in a menu. This element may contain a nested `<menu>` element in order to create a submenu.  

`<group>`
An optional, invisible container for `<item>` elements. It allows you to categorize menu items so they share properties such as active state and visibility.   
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/new_game"
          android:icon="@drawable/ic_new_game"
          android:title="@string/new_game"
          android:showAsAction="ifRoom"/>
    <item android:id="@+id/help"
          android:icon="@drawable/ic_help"
          android:title="@string/help" />
</menu>
```

To specify the options menu for an activity, override `onCreateOptionsMenu(`) (fragments provide their own `onCreateOptionsMenu()` callback). In this method, you can inflate your menu resource (defined in XML) into the Menu provided in the callback. For example:  
```java
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.your_menu, menu);
    return true;
}
```

- Handling click events

When the user selects an item from the options menu (including action items in the app bar), the system calls your activity's `onOptionsItemSelected()` method. This method passes the  MenuItem selected. You can identify the item by calling `getItemId()`, which returns the unique ID for the menu item (defined by the `android:id` attribute in the menu resource or with an integer given to the `add()` method). You can match this ID against known menu items to perform the appropriate action. For example:   

```java
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
        case R.id.exit:
            exit();
            return true;
        case R.id.setting:
            showSetting();
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}
```











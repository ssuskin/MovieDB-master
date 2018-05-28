package net.suskin.moviedb.utilities;




// https://developer.android.com/training/basics/network-ops/connecting
// https://stackoverflow.com/questions/1560788/how-to-check-internet-access-on-android-inetaddress-never-times-out

//http://www.gadgetsaint.com/android/no-internet-connectivity-android/#.WvZrXogvz-g

// I like this one.....pop up a toast if no network
// https://stackoverflow.com/questions/1560788/how-to-check-internet-access-on-android-inetaddress-never-times-out/39766506#39766506

// google this before deciding  android check for internet connection

// ooo this one is good.  https://developer.android.com/training/monitoring-device-state/connectivity-monitoring#java
/*
ConnectivityManager cm =
        (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
boolean isConnected = activeNetwork != null &&
                      activeNetwork.isConnectedOrConnecting();
*/


public class CheckForActiveNetwork {

    // TODO: this class will check to be certain there is an active network.

}

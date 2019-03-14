package sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.access;

import android.app.Activity;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.widget.EditText;

import java.util.List;

import de.dailab.apppets.plib.access.PLibGrantAccess;
import de.dailab.apppets.plib.access.handler.contacts.PlibContact;
import de.dailab.apppets.plib.access.helper.PLibAccessCallback;
import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.sink.SendSource;

/**
 * Created by arik on 03.07.2017.
 */

public class AccessLib {

    public static void getTestString(final Activity activity, final EditText tv,
                                     final boolean send) {

        PLibAccessCallback<String> cb = new PLibAccessCallback<String>() {

            @Override
            public void grantedData(String grantedData) {

                tv.setText(grantedData == null ? "NULL" : grantedData);
                if (tv.getText().toString().equals("")) {
                    tv.setText("---");
                }
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    grantedData == null ? "NULL" : grantedData.toString());
                }
            }
        };
        PLibGrantAccess.getTestString(activity, "Please grant access to the test string", cb, true);

    }

    public static void getAndroidId(final Activity activity, final EditText tv,
                                    final boolean send) {

        PLibAccessCallback<String> cb = new PLibAccessCallback<String>() {

            @Override
            public void grantedData(String grantedData) {

                tv.setText(grantedData == null ? "NULL" : grantedData);
                if (tv.getText().toString().equals("")) {
                    tv.setText("---");
                }
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    grantedData == null ? "NULL" : grantedData.toString());
                }
            }
        };
        PLibGrantAccess.getAndroidId(activity, "Please grant access to the android id", cb, true);

    }

    public static void getLastLocation(final Activity activity, final EditText tv,
                                       final boolean send) {

        PLibAccessCallback<Location> cb = new PLibAccessCallback<Location>() {

            @Override
            public void grantedData(Location grantedData) {

                tv.setText(grantedData == null ? "NULL" : grantedData.toString());
                if (tv.getText().toString().equals("")) {
                    tv.setText("---");
                }
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    grantedData == null ? "NULL" : grantedData.toString());
                }
            }
        };
        PLibGrantAccess
                .getLastLocation(activity, "Please grant access to last gps location", cb, true);
    }

    public static void getImei(final Activity activity, final EditText tv, final boolean send) {

        PLibAccessCallback<String> cb = new PLibAccessCallback<String>() {

            @Override
            public void grantedData(String grantedData) {

                tv.setText(grantedData == null ? "NULL" : grantedData);
                if (tv.getText().toString().equals("")) {
                    tv.setText("---");
                }
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    grantedData == null ? "NULL" : grantedData.toString());
                }
            }
        };
        PLibGrantAccess.getImei(activity, "Please grant access to the imei", cb, true);
    }

    public static void getPhoneNumber(final Activity activity, final EditText tv,
                                      final boolean send) {

        PLibAccessCallback<String> cb = new PLibAccessCallback<String>() {

            @Override
            public void grantedData(String grantedData) {

                tv.setText(grantedData == null ? "NULL" : grantedData);
                if (tv.getText().toString().equals("")) {
                    tv.setText("---");
                }
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    grantedData == null ? "NULL" : grantedData.toString());
                }
            }
        };
        PLibGrantAccess
                .getPhoneNumber(activity, "Please grant access to the phone number", cb, true);
    }

    public static void getSimSerialNumber(final Activity activity, final EditText tv,
                                          final boolean send) {

        PLibAccessCallback<String> cb = new PLibAccessCallback<String>() {

            @Override
            public void grantedData(String grantedData) {

                tv.setText(grantedData == null ? "NULL" : grantedData);
                if (tv.getText().toString().equals("")) {
                    tv.setText("---");
                }
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    grantedData == null ? "NULL" : grantedData.toString());
                }
            }
        };
        PLibGrantAccess
                .getSimSerialNumber(activity, "Please grant access to the sim serial number", cb,
                        true);

    }

    public static void getSubscriberId(final Activity activity, final EditText tv,
                                       final boolean send) {

        PLibAccessCallback<String> cb = new PLibAccessCallback<String>() {

            @Override
            public void grantedData(String grantedData) {

                tv.setText(grantedData == null ? "NULL" : grantedData);
                if (tv.getText().toString().equals("")) {
                    tv.setText("---");
                }
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    grantedData == null ? "NULL" : grantedData.toString());
                }
            }
        };
        PLibGrantAccess
                .getSubscriberId(activity, "Please grant access to the subscriber id", cb, true);

    }

    public static void getWifiInfo(final Activity activity, final EditText tv, final boolean send) {
        PLibAccessCallback<WifiInfo> cb = new PLibAccessCallback<WifiInfo>() {

            @Override
            public void grantedData(WifiInfo grantedData) {

                tv.setText(grantedData == null ? "NULL" : grantedData.toString());
                if (tv.getText().toString().equals("")) {
                    tv.setText("---");
                }
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    grantedData == null ? "NULL" : grantedData.toString());
                }
            }
        };
        PLibGrantAccess
                .getWifiInfo(activity, "Please grant access to the wifi info", cb, true);
    }

    public static void getWifiMac(final Activity activity, final EditText tv, final boolean send) {
        PLibAccessCallback<String> cb = new PLibAccessCallback<String>() {

            @Override
            public void grantedData(String grantedData) {

                tv.setText(grantedData == null ? "NULL" : grantedData);
                if (tv.getText().toString().equals("")) {
                    tv.setText("---");
                }
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    grantedData == null ? "NULL" : grantedData.toString());
                }
            }
        };
        PLibGrantAccess
                .getWifiMac(activity, "Please grant access to the wifi mac address", cb, true);
    }

    public static void getBluetoothMac(final Activity activity, final EditText tv,
                                       final boolean send) {
        PLibAccessCallback<String> cb = new PLibAccessCallback<String>() {

            @Override
            public void grantedData(String grantedData) {

                tv.setText(grantedData == null ? "NULL" : grantedData);
                if (tv.getText().toString().equals("")) {
                    tv.setText("---");
                }
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    grantedData == null ? "NULL" : grantedData.toString());
                }
            }
        };
        PLibGrantAccess
                .getBluetoothMac(activity, "Please grant access to the bluetooth mac address", cb,
                        true);
    }

    public static void getContacts(final Activity activity, final EditText tv, final boolean send) {
        PLibAccessCallback<List<PlibContact>> cb = new PLibAccessCallback<List<PlibContact>>() {

            @Override
            public void grantedData(List<PlibContact> grantedData) {

                if (grantedData == null) {
                    tv.setText("NULL");
                    if (send) {
                        SendSource
                                .sendSource(activity.getApplicationContext(),
                                        tv.getHint().toString(),
                                        "NULL");
                    }
                    return;
                }
                StringBuffer result = new StringBuffer();
                for (PlibContact p : grantedData) {
                    result = result.append(p.getName()).append(": ").append(p.getNumber()).append("\n");
                }
                tv.setText(result.toString());
                if (send) {
                    SendSource.sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                            result.toString());
                }
            }
        };
        PLibGrantAccess
                .getContacts(activity, "Please grant access to specific contacts", cb);
    }
}

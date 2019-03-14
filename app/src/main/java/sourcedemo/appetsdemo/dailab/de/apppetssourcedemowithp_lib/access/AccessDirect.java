package sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.access;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.R;
import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.access.contacts.ContactsAdapter;
import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.access.contacts.Person;
import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.sink.SendSource;

import static android.content.Context.WIFI_SERVICE;

/**
 * Created by arik on 03.07.2017.
 */

public class AccessDirect {

    public static void getWifiInfo(final Activity activity, final EditText tv, final boolean send) {

        @SuppressLint("WifiManagerLeak") WifiManager wifiManager = (WifiManager) activity
                .getSystemService(WIFI_SERVICE);
        assert wifiManager != null;
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        tv.setText(wifiInfo.toString());
        if (send) {
            SendSource
                    .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                            wifiInfo == null ? "NULL" : wifiInfo.toString());
        }
    }


    public static void getWifiMac(final Activity activity, final EditText tv, final boolean send) {

        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) {
                    continue;
                }

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    tv.setText("");
                    if (send) {
                        SendSource
                                .sendSource(activity.getApplicationContext(),
                                        tv.getHint().toString(),
                                        "");
                    }
                    return;
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:", b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                tv.setText(res1.toString());
                if (send) {
                    SendSource
                            .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                                    res1.toString());
                }
                return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tv.setText("02:00:00:00:00:00");
        if (send) {
            SendSource.sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                    "02:00:00:00:00:00");
        }
    }

    public static void getBluetoothMac(final Activity activity, final EditText tv,
                                       final boolean send) {

        String macAddress = android.provider.Settings.Secure
                .getString(activity.getContentResolver(), "bluetooth_address");
        tv.setText(macAddress);
        if (send) {
            SendSource
                    .sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                            macAddress);
        }

    }

    public static void getAndroidId(final Activity activity, final EditText tv,
                                    final boolean send) {

        String str = Settings.Secure
                .getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID);
        tv.setText(str);
        if (send) {
            SendSource.sendSource(activity.getApplicationContext(), tv.getHint().toString(), str);
        }
    }

    public static void getLastLocation(final Activity activity, final EditText tv,
                                       final boolean send) {

        LocationManager mLocationManager = (LocationManager) activity
                .getSystemService(Context.LOCATION_SERVICE);
        assert mLocationManager != null;
        @SuppressLint("MissingPermission") android.location.Location locationGPS = mLocationManager
                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (ActivityCompat
                .checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(activity, "No permission!", Toast.LENGTH_SHORT).show();
            return;
        }
        android.location.Location locationNet = mLocationManager
                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        long GPSLocationTime = 0;
        if (null != locationGPS) {
            GPSLocationTime = locationGPS.getTime();
        }
        long NetLocationTime = 0;
        if (null != locationNet) {
            NetLocationTime = locationNet.getTime();
        }
        android.location.Location res = null;
        if (0 < GPSLocationTime - NetLocationTime) {
            res = locationGPS;
        } else {
            res = locationNet;
        }
        String str = res == null ? "No Location" : res.toString();
        tv.setText(str);
        if (send) {
            SendSource.sendSource(activity.getApplicationContext(), tv.getHint().toString(), str);
        }
    }

    @SuppressLint("MissingPermission")
    public static void getImei(Activity activity, EditText tv, final boolean send) {
        TelephonyManager tm = (TelephonyManager) activity
                .getSystemService(Context.TELEPHONY_SERVICE);
        tv.setText(tm.getDeviceId());
        if (send) {
            SendSource.sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                    tm.getDeviceId());
        }
    }

    @SuppressLint("MissingPermission")
    public static void getPhoneNumber(Activity activity, EditText tv, final boolean send) {
        TelephonyManager tm = (TelephonyManager) activity
                .getSystemService(Context.TELEPHONY_SERVICE);
        tv.setText(tm.getLine1Number());
        if (send) {
            SendSource.sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                    tm.getLine1Number());
        }
    }

    @SuppressLint("MissingPermission")
    public static void getSimSerialNumber(Activity activity, EditText tv, final boolean send) {
        TelephonyManager tm = (TelephonyManager) activity
                .getSystemService(Context.TELEPHONY_SERVICE);
        tv.setText(tm.getSimSerialNumber());
        if (send) {
            SendSource.sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                    tm.getSimSerialNumber());
        }
    }

    @SuppressLint("MissingPermission")
    public static void getSubscriberId(Activity activity, EditText tv, final boolean send) {
        TelephonyManager tm = (TelephonyManager) activity
                .getSystemService(Context.TELEPHONY_SERVICE);
        tv.setText(tm.getSubscriberId());
        if (send) {
            SendSource.sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                    tm.getSubscriberId());
        }
    }

    public static void getContacts(final Activity activity, final EditText tv,
                                   final boolean send) {

        ContentResolver cr = activity.getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor c = null;
        c = cr.query(uri, null, null, null, null);
        if (c == null || c.getCount() < 1) {
            tv.setText("---");
            return;
        }
        final List<Person> persons = new ArrayList<>();
        while (c.moveToNext()) {
            Person p = new Person();
            p.setName(c.getString(
                    c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
            p.setNumber(
                    c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
            String photoUri = c
                    .getString(c.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI));
            if (photoUri != null) {
                Uri person = Uri.parse(photoUri);
                p.setUrl(person);
            }

            String[] columnNames = c.getColumnNames();
            Properties contentOfPerson = new Properties();
            for (String s : columnNames) {
                int i = c.getColumnIndex(s);
                String content = c.getString(i);
                if (content != null) {
                    contentOfPerson.put(s, content);
                }
            }
            p.setProperties(contentOfPerson);

            persons.add(p);

        }
        c.close();
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });


        final AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View convertView = inflater.inflate(R.layout.contacts_layout, null);
        final ListView lv = convertView.findViewById(R.id.listView);
        lv.setFastScrollEnabled(true);
        final ContactsAdapter ca = new ContactsAdapter(activity, R.id.listView, persons);
        lv.setAdapter(ca);

        dialog.setView(convertView);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setCancelable(true);
        dialog.setPositiveButton(R.string.select, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                List<Person> list0 = ca.getData();
                List<Person> selected = new ArrayList<>();
                for (Person f : list0) {
                    if (f.isSelected()) {
                        selected.add(f);
                        f.setSelected(false);
                    }
                }
                StringBuffer result = new StringBuffer();
                for (Person p : selected) {
                    result = result.append(p.getName()).append(": ").append(p.getNumber()).append("\n");
                }
                tv.setText(result.toString());
                if (send) {
                    SendSource.sendSource(activity.getApplicationContext(), tv.getHint().toString(),
                            result.toString());
                }

                dialog.dismiss();
            }
        });
        dialog.setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        dialog.setNegativeButton(R.string.select_all, null);
        final Dialog d = dialog.create();
        d.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {

                Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEGATIVE);
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        for (Person p : persons) {
                            p.setSelected(true);
                        }
                        ca.notifyDataSetChanged();
                    }
                });
            }
        });
        d.show();
    }
}

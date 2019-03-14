package sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.dailab.apppets.plib.api.PLibApiUi;
import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.access.AccessLib;
import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.global.PermissionHandler;
import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.sink.SendSource;
import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.test.AppChecker;

public class MainActivity extends AppCompatActivity {
    
    private static int FROM_PERMISSION_REQUEST = 1002;
    private static boolean hasAllRequiredPermissions = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppChecker.checkAppSignature(getApplicationContext());

        handleActions();
        
    }
    
    private void handleActions() {
        
        final List<EditText> viewsToClear = new ArrayList<>();
        Button btnGet = null;
        Button btnSend = null;
        final Activity activity = MainActivity.this;
        
        // Test String
        btnGet = findViewById(R.id.get_sign);
        final EditText tv00 = findViewById(R.id.input_sign);
        viewsToClear.add(tv00);
        btnSend = findViewById(R.id.send_sign);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                
                getHashedApkSignature(activity, tv00, false);
                
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                
                getHashedApkSignature(activity, tv00, true);
            }
        });
        
        // Test String
        btnGet = findViewById(R.id.get_test);
        final EditText tv0 = findViewById(R.id.input_test);
        viewsToClear.add(tv0);
        btnSend = findViewById(R.id.send_test);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getTestString(activity, tv0, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getTestString(activity, tv0, true);
            }
        });
        
        // Android ID
        btnGet = findViewById(R.id.get_and_id);
        final EditText tv1 = findViewById(R.id.input_and_id);
        viewsToClear.add(tv1);
        btnSend = findViewById(R.id.send_and_id);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getAndroidId(activity, tv1, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getAndroidId(activity, tv1, true);
            }
        });
        
        // IMEI
        btnGet = findViewById(R.id.get_imei);
        final EditText tv2 = findViewById(R.id.input_imei);
        viewsToClear.add(tv2);
        btnSend = findViewById(R.id.send_imei);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getImei(activity, tv2, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getImei(activity, tv2, true);
            }
        });
        
        // PHONE_NUMBER
        btnGet = findViewById(R.id.get_phone);
        final EditText tv3 = findViewById(R.id.input_phone);
        viewsToClear.add(tv3);
        btnSend = findViewById(R.id.send_phone);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getPhoneNumber(activity, tv3, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getPhoneNumber(activity, tv3, true);
            }
        });
        
        // SIM_SERIAL
        btnGet = findViewById(R.id.get_sim_serial);
        final EditText tv4 = findViewById(R.id.input_sim_serial);
        viewsToClear.add(tv4);
        btnSend = findViewById(R.id.send_sim_serial);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getSimSerialNumber(activity, tv4, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getSimSerialNumber(activity, tv4, true);
            }
        });
        
        // SUBSCRIBER_ID
        btnGet = findViewById(R.id.get_subscriber_id);
        final EditText tv5 = findViewById(R.id.input_subscriber_id);
        viewsToClear.add(tv5);
        btnSend = findViewById(R.id.send_subscriber_id);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getSubscriberId(activity, tv5, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getSubscriberId(activity, tv5, true);
            }
        });
        
        
        // Last Location
        btnGet = findViewById(R.id.get_last_loc);
        final EditText tv6 = findViewById(R.id.input_last_loc);
        viewsToClear.add(tv6);
        btnSend = findViewById(R.id.send_last_loc);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getLastLocation(activity, tv6, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getLastLocation(activity, tv6, true);
            }
        });
        
        // Wifi Info
        btnGet = findViewById(R.id.get_wifi_info);
        final EditText tv7 = findViewById(R.id.input_wifi_info);
        viewsToClear.add(tv7);
        btnSend = findViewById(R.id.send_wifi_info);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getWifiInfo(activity, tv7, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getWifiInfo(activity, tv7, true);
            }
        });
        
        // Wifi Mac
        btnGet = findViewById(R.id.get_wifi_mac);
        final EditText tv8 = findViewById(R.id.input_wifi_mac);
        viewsToClear.add(tv8);
        btnSend = findViewById(R.id.send_wifi_mac);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getWifiMac(activity, tv8, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getWifiMac(activity, tv8, true);
            }
        });
        
        // Bluetooth Mac
        btnGet = findViewById(R.id.get_bt_mac);
        final EditText tv9 = findViewById(R.id.input_bt_mac);
        viewsToClear.add(tv9);
        btnSend = findViewById(R.id.send_bt_mac);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getBluetoothMac(activity, tv9, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getBluetoothMac(activity, tv9, true);
            }
        });
        
        // All contacs
        btnGet = findViewById(R.id.get_contacts);
        final EditText tv10 = findViewById(R.id.input_contacts);
        viewsToClear.add(tv10);
        btnSend = findViewById(R.id.send_contacts);
        btnGet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getContacts(activity, tv10, false);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                AccessLib.getContacts(activity, tv10, true);
            }
        });
        
        
        // Final: clear
        Button btnClear = findViewById(R.id.remove);
        btnClear.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                for (TextView view : viewsToClear) {
                    view.setText("");
                }
            }
        });
        
        
    }
    
    private void getHashedApkSignature(Activity activity, TextView tv, boolean send) {
        
        String str = AppChecker.getHashedApkSignature(getApplicationContext());
        tv.setText(str);
        if (send) {
            SendSource.sendSource(activity.getApplicationContext(), tv.getHint().toString(), str);
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_plib:
                PLibApiUi.showPlibUi(MainActivity.this, null);
                return true;
            case R.id.action_test:
                doTest();
                return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    private void doTest() {

    }
    
    @Override
    protected void onResume() {
        
        super.onResume();
        ArrayList<String> notGrantedPermissions = PermissionHandler
                                                          .getNotGrantedPermissions(
                                                                  getApplicationContext());
        hasAllRequiredPermissions = notGrantedPermissions.size() <= 0;
        if (!hasAllRequiredPermissions) {
            handlePermissions();
        }
    }
    
    @SuppressLint("NewApi")
    private void handlePermissions() {
        
        // hasAllRequiredPermissions
        ArrayList<String> list = PermissionHandler
                                         .getNotGrantedPermissions(getApplicationContext());
        if (list.isEmpty()) {
            hasAllRequiredPermissions = true;
            return;
        }
        String[] p = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            p[i] = list.get(i);
        }
        requestPermissions(p, FROM_PERMISSION_REQUEST);
        
    }
}

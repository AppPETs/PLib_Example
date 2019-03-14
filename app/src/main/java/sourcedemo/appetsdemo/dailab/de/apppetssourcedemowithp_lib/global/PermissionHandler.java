package sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.global;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.ArrayList;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by arik on 05.01.2017.
 */

public class PermissionHandler {

    public static final String[] PERMS_ALL = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE,
            "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.READ_PHONE_STATE", "android.permission.READ_CALENDAR",
            "android.permission.WRITE_CALENDAR", "android.permission.READ_CONTACTS"};

    public static final String[] PERMS_MIN = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE,
            "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.READ_PHONE_STATE", "android.permission.READ_CALENDAR",
            "android.permission.WRITE_CALENDAR", "android.permission.READ_CONTACTS"};

    public static ArrayList<String> getNotGrantedPermissions(Context ctx) {

        ArrayList<String> res = new ArrayList<>();
        for (String p : PERMS_ALL) {
            if (!hasPermission(ctx, p)) {
                res.add(p);
            }
        }
        return res;
    }

    @SuppressLint("NewApi")
    public static boolean hasPermission(Context ctx, String permission) {

        if (useRuntimePermissions()) {
            return (ctx.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
        }
        return (true);
    }

    public static boolean useRuntimePermissions() {

        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    public static boolean hasPermissionTest(Context ctx, String permission) {

        boolean retValue = false;

        if (permission.equals(android.Manifest.permission.WAKE_LOCK)) {
            return false;
        }
        return retValue;
    }
}

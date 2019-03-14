package sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.sink;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.R;

/**
 * Created by arik on 05.07.2017.
 */

public class SendSource {

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void sendSource(final Context context, final String title, final String content) {

        boolean sent;
        String s = sf.format(new Date()) + ": " + content;
        sent = sendAsNetwork(content, s);
        if (sent) {
            Toast.makeText(context, "Sent:\n" + s, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Could not send:\n" + s, Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean sendAsNetwork(String content, String s) {
        
        int i = 1;
        if (i == 0) {
            try {
                Socket socket = new Socket("127.0.0.1", 1111);
                OutputStream o = socket.getOutputStream();
                o.write(s.getBytes());
                o.flush();
                o.close();
                socket.close();
            } catch (Exception e) {
            }
        }

        return true;
    }

    private static boolean sendAsFile(Context context, String name, String content) {
        File f = new File(Environment.getExternalStorageDirectory(),
                context.getString(R.string.app_name));
        f.mkdirs();
        f = new File(f, name + "-source.txt");
        Writer out = null;
        try {
            out = new FileWriter(f, true);
            out.append(content).append("\r\n");
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}

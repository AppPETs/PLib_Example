package sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.test;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by arik on 05.07.2017.
 */

public class Test {

    public static ArrayList<Person> getAllContactsWithPhoto(Context context) {

        ArrayList<Person> allContacts = new ArrayList<Person>();
        ContentResolver cr = context.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
                null, null, null);

        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(cur
                        .getColumnIndex(ContactsContract.Contacts._ID));

                if (Integer
                        .parseInt(cur.getString(cur
                                .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {

                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null, ContactsContract.Data.CONTACT_ID + " = ?",
                            new String[] {id}, null);

                    while (pCur.moveToNext()) {

                        // fill object data
                        Person aPerson = new Person();
                        aPerson.setName(pCur.getString(pCur
                                .getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME)));
                        aPerson.setNumber(pCur.getString(pCur
                                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));

                        // getting error in log cat.
                        Uri my_contact_Uri = Uri.withAppendedPath(
                                ContactsContract.Contacts.CONTENT_URI,
                                String.valueOf(id));

                        aPerson.setImage_Uri(my_contact_Uri);

                        Log.d(" Number List",
                                " " + aPerson.getName() + " "
                                        + aPerson.getNumber() + " "
                                        + aPerson.getImage_Uri());

                        allContacts.add(aPerson);
                    }
                    pCur.close();
                }
            }
        }
        return allContacts;
    }

    public static class Person {
        // has setter & getter
        private String name;
        private String phone_number;
        private Uri image_uri;
        private String number;
        private Uri image_Uri;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Uri getImage_Uri() {
            return image_Uri;
        }

        public void setImage_Uri(Uri image_Uri) {
            this.image_Uri = image_Uri;
        }
    }
}

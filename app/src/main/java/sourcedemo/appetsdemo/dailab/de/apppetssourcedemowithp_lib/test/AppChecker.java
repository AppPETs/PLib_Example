package sourcedemo.appetsdemo.dailab.de.apppetssourcedemowithp_lib.test;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;


/**
 * Created by arik on 02.08.2017.
 */

public class AppChecker {

	private static final int VALID = 0;

	private static final int INVALID = 1;

	private static String SIGNATURE_DEV = "C4DLBXASbV8A5KB1hv5CGUxTlGw=";
	private static String SIGNATURE_RUN = "C4DLBXASbV8A5KB1hv5CGUxTlGw=";

	public static int checkAppSignature(Context context){

		try{

			PackageInfo packageInfo = context.getPackageManager()

					.getPackageInfo(context.getPackageName(),

									PackageManager.GET_SIGNATURES);

			for(Signature signature : packageInfo.signatures){

				byte[] signatureBytes = signature.toByteArray();

				MessageDigest md = MessageDigest.getInstance("SHA");

				md.update(signature.toByteArray());

				byte[] digest = md.digest();

				final String currentSignature = Base64.encodeToString(digest, Base64.DEFAULT);

				Log.d("REMOVE_ME", "Include this string as a value for SIGNATURE:" + currentSignature);

				//compare signatures

				if(SIGNATURE_DEV.equals(currentSignature) ||
						SIGNATURE_RUN.equals(currentSignature)){

					return VALID;

				}

			}

		}
		catch(Exception e){

			//assumes an issue in checking signature., but we let the caller decide on what to do.

		}

		return INVALID;

	}

	public static String getHashedApkSignature(Context context){
		try{

			PackageInfo packageInfo = context.getPackageManager()

					.getPackageInfo(context.getPackageName(),

							PackageManager.GET_SIGNATURES);

			for(Signature signature : packageInfo.signatures){

				byte[] signatureBytes = signature.toByteArray();

				MessageDigest md = MessageDigest.getInstance("SHA");

				md.update(signature.toByteArray());

				byte[] digest = md.digest();

				final String currentSignature = Base64.encodeToString(digest, Base64.DEFAULT);

				return currentSignature;

			}

		}
		catch(Exception e){

			//assumes an issue in checking signature., but we let the caller decide on what to do.

		}
		return null;
	}

}

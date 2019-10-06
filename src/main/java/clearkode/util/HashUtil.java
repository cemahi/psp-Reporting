package clearkode.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class HashUtil {
    private static HashUtil ourInstance = new HashUtil();

    public static HashUtil getInstance() {
        return ourInstance;
    }

    private HashUtil() {
    }
    public static String getSHA1Text(String text) throws Exception {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");

        return (new BASE64Encoder()).encode(sha1.digest(text.getBytes("UTF-8")));
    }

}

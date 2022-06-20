package com.l3azh.management.SpendingManagement.Utils;

import java.util.Base64;

public class AppUtils {

    public static String convertByteToBase64String(byte[] theInputByteArray){
        return  Base64.getEncoder().encodeToString(theInputByteArray);
    }

    public static byte[] convertStringBase64ToByteArray(String theInputStringEncode){
        return Base64.getDecoder().decode(theInputStringEncode);
    }
}

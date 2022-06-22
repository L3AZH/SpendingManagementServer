package com.l3azh.management.SpendingManagement.Utils;

import com.google.gson.Gson;
import com.l3azh.management.SpendingManagement.Dtos.ErrorResponseDto;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

public class AppUtils {

    public static String convertByteToBase64String(byte[] theInputByteArray){
        return  Base64.getEncoder().encodeToString(theInputByteArray);
    }

    public static byte[] convertStringBase64ToByteArray(String theInputStringEncode){
        return Base64.getDecoder().decode(theInputStringEncode);
    }

    public static void sendError(HttpServletResponse response, int code, String message) throws IOException {
        response.setHeader("Content-type", "application/json");
        response.setStatus(code);
        ErrorResponseDto responseDto = new ErrorResponseDto(code, false, message);
        response.getWriter().write(new Gson().toJson(responseDto));
    }
}

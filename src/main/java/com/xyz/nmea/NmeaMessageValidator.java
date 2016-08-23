package com.xyz.nmea;

/**
 * Created by chin on 8/23/16.
 */
public class NmeaMessageValidator {

    public static boolean isValid(String msg, String type) {
        if (!isValid(msg)) return false;
        Tokenizer tokenizer = new Tokenizer(msg, ",");
        return tokenizer.nextToken().endsWith(type);
    }

    public static boolean isValid(String msg) {
        return (msg.startsWith(NmeaConst.MSG_START)
                || msg.startsWith(NmeaConst.VDM_START)
        )&& (msg.indexOf(NmeaConst.FIELD_SEP)==(1+NmeaConst.FIELD_1_LEN));

    }
}

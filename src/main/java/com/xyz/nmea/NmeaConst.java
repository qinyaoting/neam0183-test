package com.xyz.nmea;

/**
 * Created by chin on 8/22/16.
 */
public class NmeaConst {

    static final String MSG_START = "$";
    static final String VDM_START = "!";
    static final String MSG_END = "\r\n";
    static final String FIELD_SEP = ",";
    static final String CHECKSUM_SEP = "*";
    static final int FIELD_1_LEN = 5;

    static final String MSG_TYPE_GGA = "GGA";
    static final String MSG_TYPE_RMC = "RMC";
    static final String MSG_TYPE_GLL = "GLL";
    static final String MSG_TYPE_VDM = "VDM";
}

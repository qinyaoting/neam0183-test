package com.xyz.nmea;

/**
 * Created by chin on 8/22/16.
 */
public abstract class AbstractNmeaObject {

    private String objType;

    protected AbstractNmeaObject(String objType) {
        this.objType = objType;
    }

    public String getObjType() {
        return objType;
    }

}

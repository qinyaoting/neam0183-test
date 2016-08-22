package com.xyz.nmea;

import java.util.List;
import java.util.Observable;

/**
 * Created by chin on 8/22/16.
 */
public abstract class AbstractNmeaCodec extends Observable {

    public abstract void decode(String content);

    public abstract List<String> encode(AbstractNmeaObject obj);
}

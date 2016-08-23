package com.xyz.nmea;

import org.junit.Test;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by wuf2 on 2/21/2015.
 */
public class CodecManagerTest {


    @Test
    public void decodeMessage() throws Exception {
        String content = "$GPGGA,092750.000,5321.6802,N,00630.3372,W,1,8,1.03,61.7,M,55.2,M,,*76\n";
        CodecManager manager = new CodecManager();
        manager.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        });
        manager.decode(content);

    }

    @Test
    public void decodeConcatenatedMessage() throws Exception {
        CodecManager manager = new CodecManager();
        manager.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        });
        manager.decode("$GPRMC,092751.000,A,5");
        manager.decode("321.6802,N,00630.3371,W,0.06,31.66,280511,,,A*45\r\n");
    }


    @Test
    public void encode() {
        final GgaNmeaCodec codec = new GgaNmeaCodec();
        final String content = "$GPGGA,092750.000,5321.6802,N,00630.3372,W,1,8,1.03,61.7,M,55.2,M,,*76\r\n";
        codec.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                try {
                    CodecManager manager = new CodecManager();
                    AbstractNmeaObject obj = (AbstractNmeaObject) arg;
                    List<String> contents = manager.encode(obj);
                    assertThat(contents.get(0), equalTo(content));
                } catch (Exception e) {
                    assertTrue("Expect no exception " + e, false);
                }
            }
        });

        codec.decode(content);
    }
}

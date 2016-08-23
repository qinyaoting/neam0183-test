package com.xyz.nmea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chin on 8/22/16.
 */
public class Buffer {
    private StringBuffer sb = new StringBuffer();

    @Override
    public String toString() {
        return sb.toString();
    }

    public List<String> appendContent(String content) {
        ArrayList<String> result = new ArrayList<>();
        sb.append(content);
        String str = sb.toString();
        Tokenizer tokenizer = new Tokenizer(str, NmeaConst.MSG_END);
        int len = 0;
        while (tokenizer.hasMoreTokens(true)) {
            String item = tokenizer.nextToken();
            result.add(item);
            len += item.length() + 2;
        }
        if (!result.isEmpty()) {
            sb.delete(0, len);
        }

        return result;
    }
}

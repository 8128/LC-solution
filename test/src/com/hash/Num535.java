package com.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-09-28 03:35
 * @modified By：
 */
public class Num535 {
    public class Codec {
        Map<Integer, String> map = new HashMap<>();
        int i = 0;

        public String encode(String longUrl) {
            map.put(i, longUrl);
            return "http://tinyurl.com/" + i++;
        }

        public String decode(String shortUrl) {
            return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}

package com.crio.shorturl;

import java.util.HashMap;

class XUrlImpl implements XUrl {

    HashMap<String, String> map = new HashMap<>();
    HashMap<String, String> r_map = new HashMap<>();
    HashMap<String, Integer> h_map = new HashMap<>();


    public String registerNewUrl(String longUrl) {
        String shortUrl;
        if (map.containsKey(longUrl)) {
            shortUrl = map.get(longUrl);
        } else {
            shortUrl = getRandomString();
            map.put(longUrl, shortUrl);
            r_map.put(shortUrl, longUrl);
            h_map.put(longUrl, 0);
        }
        return shortUrl;
    }


    public String getRandomString() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(9);
        for (int i = 0; i < 9; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return "http://short.url/" + sb.toString();
    }

    @Override
    public String registerNewUrl(String longUrl, String shortUrl) {
        if (map.containsValue(shortUrl)) {
            return null;
        } else {
            map.put(longUrl, shortUrl);
            r_map.put(shortUrl, longUrl);
            h_map.put(longUrl, 0);
            return shortUrl;
        }
    }

    public String getUrl(String shortUrl) {
        String longUrl;
        if (r_map.containsKey(shortUrl)) {
            longUrl = r_map.get(shortUrl);
            if (h_map.containsKey(longUrl)) {
                int value = h_map.get(longUrl);
                h_map.put(longUrl, value+1);
            }
        } else {
            longUrl = null;
        }
        return longUrl;
    }

    public Integer getHitCount(String longUrl) {
        if (h_map.containsKey(longUrl)) {
            return h_map.get(longUrl);
        } else {
            return 0;
        }
    }

    public String delete(String longUrl) {
        String shortUrl = map.get(longUrl);
        r_map.remove(shortUrl);
        map.remove(longUrl);
        return getUrl(shortUrl);
    }

}
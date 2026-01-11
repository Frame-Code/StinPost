package Entities.Util;

import java.util.List;

public class Util {
    public static <T> void add(List<T> list, T object, String message) {
        if(object == null)
            throw new IllegalArgumentException(message);
        list.add(object);
    }

    public static <T, U> void remove(List<T> list, U object, String message, Callback<T> callback) {
        if(object == null)
            throw new IllegalArgumentException(message);
        var result = callback.search();
        if(result == null)
            throw new IllegalArgumentException(message);
        list.remove(result);
    }

}

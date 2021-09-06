package lesson1.generics;

import lesson1.generics.generic.*;
import lesson1.generics.generic.utils.CollectionUtils;

public class TestImport {

    public static void main(String[] args) {
        new Pair<String, Integer>("", 1);
        CollectionUtils.transform(null, null);
    }
}

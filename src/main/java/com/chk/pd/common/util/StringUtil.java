package com.chk.pd.common.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {

    public static List<String> StringToList(String str, String spar){
        String strs[] = str.split(spar);
        return Arrays.asList(strs);
    }

}

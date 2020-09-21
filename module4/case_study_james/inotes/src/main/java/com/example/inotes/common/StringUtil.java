package com.example.inotes.common;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class StringUtil {
    public static final Object serviceType = "db";

    public static void setStaticConstant(Object newVal) throws Exception {
        final Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        final Unsafe unsafe = (Unsafe) unsafeField.get(null);

        final Field ourField = StringUtil.class.getDeclaredField("serviceType");
        final Object staticFieldBase = unsafe.staticFieldBase(ourField);
        final long staticFieldOffset = unsafe.staticFieldOffset(ourField);

        unsafe.putObject(staticFieldBase, staticFieldOffset, newVal);
    }

}

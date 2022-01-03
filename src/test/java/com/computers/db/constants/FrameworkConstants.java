package com.computers.db.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {}

    private static final long EXPLICIT_WAIT = 30;
    private static final long IMPLICIT_WAIT = 10;
    
    public static long getExplicitWait() {
        return EXPLICIT_WAIT;
    }
    
    public static long getImplicitWait() {
        return IMPLICIT_WAIT;
    }
}


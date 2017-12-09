package com.artshell.multipager.utils;

/**
 * Created by artshell on 2017/11/2.
 */

public class Numbers {

    private Numbers() {
        throw new AssertionError("No com.artshell.multipager.utils.Numbers instances for you!");
    }

    /* ======  check for long  ====== */
    public static boolean requireNonNegative(long number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonNegative(long number, String tip) {
        if (number < 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonNegative(long number, Provider<String> tipProvider) {
        if (number < 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }

    /* ======  check for double  ====== */
    public static boolean requireNonNegative(double number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonNegative(double number, String tip) {
        if (number < 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonNegative(double number, Provider<String> tipProvider) {
        if (number < 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }

    /* ======  check for float  ====== */
    public static boolean requireNonNegative(float number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonNegative(float number, String tip) {
        if (number < 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonNegative(float number, Provider<String> tipProvider) {
        if (number < 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }

    /* ======  check for int  ====== */
    public static boolean requireNonNegative(int number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonNegative(int number, String tip) {
        if (number < 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonNegative(int number, Provider<String> tipProvider) {
        if (number < 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }

    /* ======  check for short  ====== */
    public static boolean requireNonNegative(short number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean requireNonNegative(short number, String tip) {
        if (number < 0) {
            throw new IllegalStateException(tip);
        }
        return true;
    }

    public static boolean requireNonNegative(short number, Provider<String> tipProvider) {
        if (number < 0) {
            throw new IllegalStateException(tipProvider.get());
        }
        return true;
    }
}

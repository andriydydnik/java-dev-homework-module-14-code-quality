package com.example.app;

public final class AppConstants {
    public static final char PLAYER_SYMBOL = 'X';
    public static final char OPPONENT_SYMBOL = 'O';
    public static final char EMPTY_SYMBOL = ' ';

    private AppConstants() {
        throw new IllegalStateException("Utility class");
    }
}

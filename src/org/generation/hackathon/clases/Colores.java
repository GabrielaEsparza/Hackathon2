package org.generation.hackathon.clases;

public class Colores {
    // Reset
    public static final String RESET = "\033[0m";
    
    // Regular
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";
    
    // Bold
    public static final String BOLD = "\033[1m";
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String WHITE_BOLD = "\033[1;37m";
    
    // BG
    public static final String BLACK_BG = "\033[40m";
    public static final String RED_BG = "\033[41m";
    public static final String GREEN_BG = "\033[42m";
    public static final String YELLOW_BG = "\033[43m";
    public static final String BLUE_BG = "\033[44m";
    public static final String PURPLE_BG = "\033[45m";
    public static final String CYAN_BG = "\033[46m";
    public static final String WHITE_BG = "\033[47m";
    
    // HM
    public static String success(String text) {
        return GREEN_BOLD + "✓ " + text + RESET;
    }
    
    public static String error(String text) {
        return RED_BOLD + "✗ " + text + RESET;
    }
    
    public static String warning(String text) {
        return YELLOW_BOLD + "⚠ " + text + RESET;
    }
    
    public static String info(String text) {
        return CYAN_BOLD + "ℹ " + text + RESET;
    }
    
    public static String title(String text) {
        return BLUE_BOLD + text + RESET;
    }
}
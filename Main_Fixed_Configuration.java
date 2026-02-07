class Config {
    public static final String APP_NAME = "UTILITY APP";
    public static final int MAX_LOGIN_ATTEMPTS = 3;
    public static final double TAX_PERCENT = 18.0;

    private Config() { }
}

public class Main_Fixed_Configuration {
    public static void main(String[] args) {
        System.out.println("APP NAME           : " + Config.APP_NAME);
        System.out.println("MAX LOGIN ATTEMPTS : " + Config.MAX_LOGIN_ATTEMPTS);
        System.out.println("TAX PERCENT        : " + Config.TAX_PERCENT + "%");
    }
}

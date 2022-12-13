package ru.job4j.oop;

public class Error {

    private  boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Fatal error: " + active);
        System.out.println("Reload after: " + status + " seconds");
        System.out.println("Press any key to " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error noFail = new Error(false, 50, "continue");
        noFail.printInfo();
        Error fail = new Error(true, 10, "restart");
        fail.printInfo();
    }
}

package implementing_an_asynchronous_api;

public class Main {
    public static void main(String[] args) {
        var service = new MailService();
        service.sendAsync();
        System.out.println("Hello World");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

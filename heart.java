public class heart {
    public static void main(String[] args) {
        ha h = new ha();
        h.start();

    }

    public static class ha extends Thread {

        public void run() {
            System.out.println("thread läudt" + Thread.currentThread().getName());

        }

    }
}
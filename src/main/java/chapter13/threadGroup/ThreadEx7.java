package chapter13.threadGroup;

public class ThreadEx7 {
    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup gr1 = new ThreadGroup("Group1");
        ThreadGroup gr2 = new ThreadGroup("Group2");

        ThreadGroup sub = new ThreadGroup(gr1,"subGroup");

        gr1.setMaxPriority(3);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        };

        new Thread(gr1,r,"th1").start();
        new Thread(sub,r,"th2").start();
        new Thread(gr2,r,"th3").start();

        System.out.println("main.getName: " + main.getName());
        System.out.println("activGroupCount:  " + main.activeGroupCount());
        System.out.println("actuveCount : "+ main.activeCount());
        main.list();

    }
}

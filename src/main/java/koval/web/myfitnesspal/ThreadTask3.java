package koval.web.myfitnesspal;

public class ThreadTask3 implements Runnable{

        private final String name;

        public ThreadTask3(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Executing task: " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed: " + name);
        }
}

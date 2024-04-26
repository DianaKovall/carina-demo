package koval.web.myfitnesspal;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ThreadTest {

    @Test()
    @MethodOwner(owner = "dkoval")
    public void threadTest() {
        // 1. Create 2 Threads using Runnable and Thread.
        ThreadExample thread1 = new ThreadExample();
        thread1.start();

        RunnableTask runnableTask = new RunnableTask();
        Thread threadRunnable = new Thread(runnableTask);
        thread1.start();

    }

    @Test()
    @MethodOwner(owner = "dkoval")
    public void concurrentPackageTest() {
        // 2. Create Connection Pool. Use collection from java.util.concurrent package. Connection class may be mocked. The pool should be threadsafe and lazy initialized.
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable task = new ThreadTask3("Task " + i);
            executor.submit(task);
        }
        executor.shutdown();
    }

    @Test()
    @MethodOwner(owner = "dkoval")
    public void connectionPoolTest() {
        // 3. Initialize pool with 5 sizes. Load Connection Pool using threads and Thread Pool(7 threads). 5 threads should be able to get the connection. 2 Threads should wait for the next available connection. The program should wait as well.
        int poolSize = 5;
        int numThreads = 7;
        ConnectionPool pool = new ConnectionPool(poolSize);
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        for (int i = 0; i < numThreads; i++) {
            executor.execute(() -> {
                String connection = pool.getConnection();
                if (connection != null) {
                    System.out.println(Thread.currentThread().getName() + " got connection: " + connection);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pool.releaseConnection(connection);
                } else {
                    System.out.println(Thread.currentThread().getName() + " couldn't get connection.");
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test()
    @MethodOwner(owner = "dkoval")
    public void completableStageTest() {
        // 4. Implement 3rd point but with IFuture and CompletableStage usage.
        CompletableFuture<String> future = simulateAsyncOperation();
        future.thenAccept(result -> {
            System.out.println("Asynchronous operation completed with result: " + result);
        });
        System.out.println("Continuing with other tasks while the asynchronous operation is in progress...");
    }

    public static CompletableFuture<String> simulateAsyncOperation() {
        CompletableFuture<String> future = new CompletableFuture<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(() -> {
            try {
                Thread.sleep(2000);
                future.complete("Result of the asynchronous operation");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            } finally {
                executor.shutdown();
            }
        });
        return future;
    }


}

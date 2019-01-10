package Client;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ColoursTest {

    private Colours colours = Colours.getInstance();

    @Test
    public void testGetSingleton() {
        assertNotNull(colours);
    }

    @Test
    public void checksize() {
        assertEquals(colours.size(), 7);

    }


    @Test
    public void testMultiThreading() {
        List<Thread> threads = new ArrayList<>();
        List<Colours> references = Collections.synchronizedList(new ArrayList<Colours>());

        for (int i = 0; i < 10; i++) {
            Thread worker = new Thread(new Worker(i, references));
            threads.add(worker);
            worker.start();
        }

        for (Thread thread : threads) {
            while (thread.isAlive()) {

            }
            System.out.println("Thread " + thread.getId() + " died!");

        }
        for (int i = 0; i < references.size(); i++) {
            Colours expected = references.get(i);
            for (int j = i; j < references.size(); j++) {
                assertEquals(expected, references.get(j));
            }
        }

    }

    class Worker implements Runnable {

        private int number;
        private List<Colours> myReferences;

        Worker(int number, List<Colours> references) {
            this.setNumber(number);
            this.myReferences = references;
        }

        @Override
        public void run() {
            this.myReferences.add(Colours.getInstance());

        }

        void setNumber(int number) {
            this.number = number;
        }

    }


}
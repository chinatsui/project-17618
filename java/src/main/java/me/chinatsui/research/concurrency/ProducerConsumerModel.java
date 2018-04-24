package me.chinatsui.research.concurrency;

import java.util.LinkedList;

import me.chinatsui.util.RandomString;

public class ProducerConsumerModel {

    public static void main(String[] args) {
        Repo repo = new Repo();
        Thread pThread = new Thread(new Producer(repo));
        Thread cThread = new Thread(new Consumer(repo));
        pThread.start();
        cThread.start();
    }


    static class Producer implements Runnable {

        private Repo repo;

        public Producer(Repo repo) {
            this.repo = repo;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (repo) {
                        if (repo.isFull()) {
                            repo.wait();
                        } else {
                            while (!repo.isFull()) {
                                Good g = new Good(RandomString.get(10));
                                System.out.println("Producing: " + g);
                                repo.put(g);
                            }
                            repo.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Consumer implements Runnable {

        private Repo repo;

        public Consumer(Repo repo) {
            this.repo = repo;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (repo) {
                        if (repo.isEmpty()) {
                            repo.wait();
                        } else {
                            while (!repo.isEmpty()) {
                                System.out.println("Consuming: " + repo.get());
                            }
                            repo.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Repo {

        LinkedList<Good> goods = new LinkedList();

        boolean isFull() {
            return goods.size() == 5;
        }

        boolean isEmpty() {
            return goods.isEmpty();
        }

        Good get() {
            return goods.poll();
        }

        void put(Good good) {
            goods.add(good);
        }

    }

    static class Good {

        private String name;

        public Good(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }

    }

}

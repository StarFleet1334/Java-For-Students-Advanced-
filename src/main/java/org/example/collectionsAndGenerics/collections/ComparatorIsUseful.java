package org.example.collectionsAndGenerics.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Worker {
    private int id;

    Worker(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                '}';
    }
}

class Boss implements Comparable<Boss> {
    private int id;

    Boss(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(Boss o) {
        // natural order in ascending order
        return this.id - o.id;
    }
}

public class ComparatorIsUseful {

    public static void main(String[] args) {
        Set<Boss> bossSet = new TreeSet<>();
        bossSet.add(new Boss(20));
        bossSet.add(new Boss(10));
        bossSet.add(new Boss(15));
        System.out.println(bossSet);


        // Here we should get error
        // TO fix that we should cast so we pass compatartor
        Set<Worker> workers = new TreeSet<>(Comparator.comparing(Worker::getId));
        workers.add(new Worker(30));
        workers.add(new Worker(20));
        workers.add(new Worker(10));
        workers.add(new Worker(21));
        System.out.println(workers);
    }
}
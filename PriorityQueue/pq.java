package Advance_dsa_java.PriorityQueue;

import java.util.*;

public class pq {

    static class Employee implements Comparable<Employee> {

        String role;
        int salary;

        public Employee(String role, int  salary) {
            this.role = role;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee s2) {
            return (this.salary - s2.salary);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Employee> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Employee("sde-1", 100000));
        pq.add(new Employee("sde-2", 125000));
        pq.add(new Employee("sde-3", 150000));
        pq.add(new Employee("scientist", 200000));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().role + "->" + pq.peek().salary);
            pq.remove();
        }
    }
}
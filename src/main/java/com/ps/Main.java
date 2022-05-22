package com.ps;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student> {
    private final int id;
    private final String name;
    private final double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCGPA() {
        return this.cgpa;
    }

    @Override
    public int compareTo(Student st) {
        if (st.cgpa > this.cgpa) {
            return 1;
        } else if (st.cgpa < this.cgpa) {
            return -1;
        }

        if (this.cgpa == st.cgpa && !this.name.equals(st.name)) {
            return this.name.compareTo(st.name);
        }

        return this.id - st.id;
    }
}


class Priorities {

    public List<Student> getStudents(List<String> events) {
        NavigableSet<Student> studentsSet = new TreeSet<>();

        for (String event : events) {
            String[] parts = event.split(" ");
            String eventName = parts[0];
            if (eventName.equals("SERVED")) {
                studentsSet.pollFirst();
                continue;
            }
            String studentName = parts[1];
            double studentCGPA = Double.parseDouble(parts[2]);
            int studentId = Integer.parseInt(parts[3]);
            Student student = new Student(studentId, studentName, studentCGPA);
            studentsSet.add(student);
        }
        return new ArrayList<>(studentsSet);
    }
}

public class Main {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
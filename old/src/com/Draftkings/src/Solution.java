import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        ConsoleProcessor processor = new ConsoleProcessor();
        processor.processAllLines();
    }
}

class ConsoleProcessor {

    public OrgChart orgChart = new OrgChart();
    public void processAllLines() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer numLines = 0;

        try {
            numLines = Integer.valueOf(line.trim());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < numLines; i++) {
            processLine(in.nextLine());
        }

        in.close();
    }

    protected void processLine(String line) {
        String[] parsedCommand = line.split(",");

        // ignore empty lines
        if (parsedCommand.length == 0) {
            return;
        }
        // add,10,sharilyn,-1
        switch (parsedCommand[0]) {
            case "add":
                orgChart.add(parsedCommand[1], parsedCommand[2], parsedCommand[3]);
                break;
            case "print":
                orgChart.print();
                break;
            case "remove":
                orgChart.remove(parsedCommand[1]);
                break;
            case "move":
                orgChart.move(parsedCommand[1], parsedCommand[2]);
                break;
            case "count":
                System.out.println(orgChart.count(parsedCommand[1]));
                break;
        }
    }
}

class Employee {
    String name;
    String managerId;
    int sumOfReporters = 0;
    List<String> children;

    public Employee(String name, String managerId, List<String> children) {
        this.name = name;
        this.managerId = managerId;
        this.children = children;
    }

}
class OrgChart {
    LinkedHashMap<String, Employee> map = new LinkedHashMap<>();
    public void add(String id, String name, String managerId) {
        if (map.containsKey(id)) return;
        if (!map.containsKey(managerId)) managerId = "-1";
        Employee employee = new Employee(name, managerId, new LinkedList<>());
        map.put(id, employee);
        String manager = managerId;
        while (!manager.equals("-1")) {
            Employee obj = map.get(manager);
            obj.sumOfReporters++;
            manager = obj.managerId;
        }

        if (map.containsKey(managerId)) {
            map.get(managerId).children.add(id);
        }
    }

    public void print() {
        for (String employeeId : map.keySet()) {
            if (map.get(employeeId).managerId.equals("-1")) {
                printDFS(employeeId, 0);
            }
        }
    }

    private void printDFS(String employeeId, int layer) {
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < layer; i++) {
            space.append("  ");
        }
        System.out.print(space.toString());
        Employee employee = map.get(employeeId);
        System.out.println(employee.name + " " + "[" + employeeId + "]");
        for (String child : map.get(employeeId).children) {
            printDFS(child, layer + 1);
        }
    }

    public void remove(String employeeId) {
        if (!map.containsKey(employeeId)) return;
        Employee toRemoved = map.get(employeeId);
        String manager = toRemoved.managerId;
        while (!manager.equals("-1")) {
            Employee obj = map.get(manager);
            obj.sumOfReporters--;
            manager = obj.managerId;
        }

        for (String child : map.get(employeeId).children) {
            map.get(child).managerId = toRemoved.managerId;
        }
        if (!toRemoved.managerId.equals("-1")) {
            map.get(toRemoved.managerId).children.remove(employeeId);
            map.get(toRemoved.managerId).children.addAll(map.get(employeeId).children);
        }
        map.remove(employeeId);
    }

    public void move(String employeeId, String newManagerId) {
        if (!map.containsKey(employeeId)) return;
        if (!map.containsKey(newManagerId)) return;
        if (map.containsKey(employeeId) && map.containsKey(newManagerId)) {
            moveDFS(employeeId, newManagerId);
        }
    }

    private void moveDFS(String employeeId, String newManagerId) {
        List<String> children = map.get(employeeId).children;
        Employee toRemoved = map.get(employeeId);

        String name = toRemoved.name;
        String manager = toRemoved.managerId;
        while (!manager.equals("-1")) {
            Employee obj = map.get(manager);
            obj.sumOfReporters--;
            manager = obj.managerId;
        }
        if (!toRemoved.managerId.equals("-1")) {
            map.get(toRemoved.managerId).children.remove(employeeId);
            map.get(toRemoved.managerId).children.addAll(children);
        }
        for (String child : children) {
            map.get(child).managerId = toRemoved.managerId;
        }
        map.remove(employeeId);

        Employee newObj = map.get(newManagerId);
        newObj.children.add(employeeId);
        Employee newEmployee = new Employee(name, newManagerId, new LinkedList<>());
        newEmployee.sumOfReporters = newObj.sumOfReporters;
        map.put(employeeId, newEmployee);

        String newManager = newManagerId;
        while (!newManager.equals("-1")) {
            Employee obj = map.get(newManager);
            obj.sumOfReporters++;
            newManager = obj.managerId;
        }

        for (String child : children) {
            moveDFS(child, employeeId);
        }
    }

    public int count(String employeeId) {
        if (!map.containsKey(employeeId)) return 0;
        return map.get(employeeId).sumOfReporters;
    }
}

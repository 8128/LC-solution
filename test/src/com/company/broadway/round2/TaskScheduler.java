package com.company.broadway.round2;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-08 14:53
 */
public class TaskScheduler {

    HashSet<Task> allTasks;
    HashSet<Task> finished;

    class Task {

        String name;
        Set<Task> dependencies;

        public Task(String name) {
            this.name = name;
        }

        public void addDependency(Task task) {
            dependencies.add(task);
        }
    }

    public void addDependency(Task task1, Task task2) {
        task1.addDependency(task2);
        allTasks.add(task2);
    }

    public void addCompletedTask(Task task) {
        finished.add(task);
    }

    public List<Task> getRunnab‍‌‍‌‍‍‌‌‌‍‍‍‌‌‍‌‌‍‍leTasks() {
        List<Task> ans = new ArrayList<>();
        for (Task task : allTasks) {
            boolean bl = true;
            for(Task neededTask : task.dependencies){
                if (!finished.contains(neededTask)) {
                    bl = false;
                }
            }
            if (bl) {
                ans.add(task);
            }
        }
        return ans;
    }
}

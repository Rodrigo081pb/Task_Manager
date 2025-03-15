package com.boardtarefas.repository;

import com.boardtarefas.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Optional<Task> getTaskById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst();
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public boolean removeTask(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }
    
    // Em um sistema real, este método poderia persistir alterações
    public void updateTask(Task task) {
        // Como estamos trabalhando com objetos referenciados, a atualização é reflexiva.
    }
}

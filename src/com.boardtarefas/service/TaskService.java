package com.boardtarefas.service;

import com.boardtarefas.model.Task;
import com.boardtarefas.model.TaskStatus;
import com.boardtarefas.repository.TaskRepository;
import java.util.List;
import java.util.Optional;

public class TaskService {
    private TaskRepository repository = new TaskRepository();
    private int currentId = 1;

    public Task criarTask(String titulo, String descricao) {
        Task task = new Task(currentId++, titulo, descricao, TaskStatus.TODO);
        repository.addTask(task);
        return task;
    }

    public Optional<Task> getTaskById(int id) {
        return repository.getTaskById(id);
    }

    public List<Task> listarTasks() {
        return repository.getAllTasks();
    }

    public boolean removerTask(int id) {
        return repository.removeTask(id);
    }

    public boolean atualizarStatusTask(int id, TaskStatus novoStatus) {
        Optional<Task> optionalTask = repository.getTaskById(id);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setStatus(novoStatus);
            repository.updateTask(task);
            return true;
        }
        return false;
    }
}

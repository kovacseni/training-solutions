package intromethods;

import java.util.List;
import java.util.ArrayList;

public class TodoList {

    List<Todo> todoList = new ArrayList<>();

    public void addTodo(String caption) {
        Todo todo = new Todo(caption);
        todoList.add(todo);
    }

   public void finishTodos(String caption) {
        for (Todo t : todoList) {
            if (t.getCaption().equals(caption)) {
                t.finish();
            }
        }
    }

    public List<String> todosToFinish() {
        List<String> todosToFinish = new ArrayList<>();
        for (Todo t : todoList) {
            if (t.isFinished() == false) {
                todosToFinish.add(t.getCaption());
            }
        }
        return todosToFinish;
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for (Todo t : todoList) {
            t.finish();
        }
    }

    public int numberOfFinishedTodos() {
        int number = 0;
        for (Todo t : todoList) {
            if (t.isFinished()) {
                number = number + 1;
            }
        }
        return number;
    }

    @Override
    public String toString() {
        return todoList.toString();
    }






}

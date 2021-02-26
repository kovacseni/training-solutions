package exam03retake02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }

    public int getNumberOfItemsLeft() {
        int leftItems = 0;
        for (Todo t : todos) {
            if (t.getState() == State.NON_COMPLETED) {
                leftItems++;
            }
        }
        return leftItems;
    }

    public List<String> getMostImportantTodosText() {
        List<String> mostImportantTodosText = new ArrayList<>();
        todos.sort(Comparator.comparing(Todo::getPriority));
        int min = todos.get(0).getPriority();
        for (Todo t : todos) {
           if (t.getPriority() == min) {
               mostImportantTodosText.add(t.getText());
           }
        }
        return mostImportantTodosText;
    }

    public void deleteCompleted() {
       for (Iterator<Todo> iter = todos.iterator(); iter.hasNext();) {
           Todo todo = iter.next();
           if (todo.getState() == State.COMPLETED) {
               iter.remove();
           }
       }
    }
}

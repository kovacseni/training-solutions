package intromethods;

import java.util.Arrays;
import java.util.List;

public class TodoListMain {

    public static void main(String[] args) {

        TodoList todo = new TodoList();

        todo.addTodo("Projektmunkát megcsinálni");
        todo.addTodo("Virágokat megöntözni");
        todo.addTodo("Szennyest berakni a gépbe");
        todo.addTodo("Gyerekeknek uzsonnát pakolni");
        todo.addTodo("Vacsorát főzni");
        todo.addTodo("Postára menni");

        System.out.println(todo);

        todo.finishTodos("Virágokat megöntözni");
        todo.finishTodos("Projektmunkát megcsinálni");

        System.out.println(todo);

        System.out.println(todo.todosToFinish());
        System.out.println(todo.numberOfFinishedTodos());
    }

}

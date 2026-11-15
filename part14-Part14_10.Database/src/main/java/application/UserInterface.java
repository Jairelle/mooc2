package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            if (command.equals("1")) {
                list();
            } else if (command.equals("2")) {
                add();
            } else if (command.equals("3")) {
                markAsDone();
            } else if (command.equals("4")) {
                remove();
            }
        }

        System.out.println("Thank you!");
    }


    private void list() throws SQLException {
        List<Todo> todos = this.database.list();

        for (Todo todo : todos) {
            System.out.println(todo.getId() + ": " + todo.getName()
                    + " (" + todo.getDescription() + ")"
                    + (todo.getDone() ? " DONE" : ""));
        }
    }

    private void add() throws SQLException {
        System.out.print("name: ");
        String name = this.scanner.nextLine();
        System.out.print("description: ");
        String description = this.scanner.nextLine();

        this.database.add(new Todo(name, description, Boolean.FALSE));
    }

    private void markAsDone() throws SQLException {
        System.out.print("id: ");
        int id = Integer.valueOf(this.scanner.nextLine());

        this.database.markAsDone(id);
    }

    private void remove() throws SQLException {
        System.out.print("id: ");
        int id = Integer.valueOf(this.scanner.nextLine());

        this.database.remove(id);
    }
}

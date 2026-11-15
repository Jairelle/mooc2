package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private Button[][] board;
    private Label turnLabel;
    private String turn;
    private boolean gameOver;

    @Override
    public void start(Stage window) {
        this.board = new Button[3][3];
        this.turn = "X";
        this.gameOver = false;
        this.turnLabel = new Label("Turn: " + this.turn);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                Button button = new Button("");
                button.setPrefSize(60, 60);

                final int buttonRow = row;
                final int buttonColumn = column;
                button.setOnAction((event) -> play(buttonRow, buttonColumn));

                this.board[row][column] = button;
                grid.add(button, column, row);
            }
        }

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setTop(this.turnLabel);
        layout.setCenter(grid);
        BorderPane.setAlignment(this.turnLabel, Pos.CENTER);

        window.setTitle("Tic-Tac-Toe");
        window.setScene(new Scene(layout, 260, 300));
        window.show();
    }

    private void play(int row, int column) {
        if (this.gameOver) {
            return;
        }

        Button button = this.board[row][column];
        if (!button.getText().trim().isEmpty()) {
            return;
        }

        button.setText(this.turn);

        if (hasWon(this.turn) || boardIsFull()) {
            this.gameOver = true;
            this.turnLabel.setText("The end!");
            return;
        }

        this.turn = this.turn.equals("X") ? "O" : "X";
        this.turnLabel.setText("Turn: " + this.turn);
    }

    private boolean hasWon(String player) {
        for (int i = 0; i < 3; i++) {
            if (isPlayers(player, i, 0) && isPlayers(player, i, 1) && isPlayers(player, i, 2)) {
                return true;
            }

            if (isPlayers(player, 0, i) && isPlayers(player, 1, i) && isPlayers(player, 2, i)) {
                return true;
            }
        }

        if (isPlayers(player, 0, 0) && isPlayers(player, 1, 1) && isPlayers(player, 2, 2)) {
            return true;
        }

        return isPlayers(player, 0, 2) && isPlayers(player, 1, 1) && isPlayers(player, 2, 0);
    }

    private boolean isPlayers(String player, int row, int column) {
        return this.board[row][column].getText().trim().equals(player);
    }

    private boolean boardIsFull() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (this.board[row][column].getText().trim().isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}

/*

        в пустой (мёртвой) клетке, рядом с которой ровно три живые клетки, зарождается жизнь;
        если у живой клетки есть две или три живые соседки, то эта клетка продолжает жить; в противном случае (если соседей меньше двух или больше трёх) клетка умирает («от одиночества» или «от перенаселённости»)
        Игра прекращается, если на поле не останется ни одной «живой» клетки, если при очередном шаге ни одна из клеток не меняет своего состояния (складывается стабильная конфигурация) или если конфигурация на очередном шаге в точности (без сдвигов и поворотов) повторит себя же на одном из более ранних шагов (складывается периодическая конфигурация).
*/

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        RandomCellStateProvider randomgame = new RandomCellStateProvider();
        FileCellStateProvider filegame = new FileCellStateProvider();

        int size = filegame.getSize();
        GameManager game = new GameManager(filegame, size);


        while (true) {
            clearScreen();
            ArrayList<Cell> cells = game.getWorld().getCellList();
            String cont;

            for (int y = 0; y < size; y++) {
                for (int i = 0; i < size; i++) {

                    int index = y * size + i;

                    if (cells.get(index).getIsAlive()) {
                        cont = "█";
                    } else {
                        cont = "░";
                    }
                    System.out.print(cont + " ");
                }
                System.out.println();
            }
            System.in.read();
            game.processTick();
        }

    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

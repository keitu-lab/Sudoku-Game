package Sudoku;

import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.*;

public class Tiles
 {
    private Sudoku sudoku;
    private String[] puzzle = 
    {
        "--74916-5",
        "2---6-3-9",
        "-----7-1-",
        "-586----4",
        "--3----9-",
        "--62--187",
        "9-4-7---2",
        "67-87----",
        "81--45---",
    };

    private String[] solution = 
    {
        "387491625",
        "241568379",
        "569327418",
        "758619234",
        "123784596",
        "496253187",
        "934176852",
        "675832941",
        "812945763",
    };

    public Tiles(Sudoku sudoku) 
    {
        this.sudoku = sudoku;
    }

    public void setupTiles() 
    {
        for (int r = 0; r < 9; r++) 
        {
            for (int c = 0; c < 9; c++) 
            {
                char tileChar = puzzle[r].charAt(c);
                boolean isPreset = (tileChar != '-');
                Sudoku.Tile tile = sudoku.new Tile(r, c, isPreset);
                
                if (isPreset) 
                {
                    tile.setFont(new Font("Arial", Font.BOLD, 20));
                    tile.setText(String.valueOf(tileChar));
                    tile.setBackground(Color.lightGray);
                    tile.setEnabled(false);
                } else {
                    tile.setFont(new Font("Arial", Font.PLAIN, 20));
                    tile.setBackground(Color.white);
                }

                if ((r == 2 && c == 2) || (r == 2 && c == 5) || (r == 5 && c == 2) || (r == 5 && c == 5)) {
                    tile.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, Color.BLACK));
                } else if (r == 2 || r == 5) {
                    tile.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, Color.BLACK));
                } else if (c == 2 || c == 5) {
                    tile.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.BLACK));
                } else {
                    tile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }

                tile.setFocusable(false);
                sudoku.boardPanel.add(tile);

                tile.addActionListener(new ActionListener() 
                {public void actionPerformed(ActionEvent e) 
                    {
                        Sudoku.Tile tile = (Sudoku.Tile) e.getSource();
                        if (tile.isPreset) return;
                        
                        if (sudoku.numSelected != null) 
                        {
                            String numSelectedText = sudoku.numSelected.getText();
                            String tileSolution = String.valueOf(solution[tile.r].charAt(tile.c));
                            
                            if (tileSolution.equals(numSelectedText)) 
                            {
                                tile.setText(numSelectedText);
                                tile.setForeground(Color.BLACK);

                            } else {
                                sudoku.errors++;
                                sudoku.textLabel.setText("Sudoku: " + sudoku.errors);
                                tile.setText(numSelectedText);
                                tile.setForeground(Color.RED);
                               
                            }
                        }
                    }
                });
            }
        }
    }
}
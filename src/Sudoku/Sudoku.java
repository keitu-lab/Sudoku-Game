package Sudoku;

import java.awt.*;
import javax.swing.*;

public class Sudoku 
{
    int boardWidth = 600;
    int boardHeight = 650;

    class Tile extends JButton 
    {
        int r;
        int c;
        boolean isPreset;
        
        Tile(int r, int c, boolean isPreset)
         {
            this.r = r;
            this.c = c;
            this.isPreset = isPreset;
        }
    }

    protected JFrame frame = new JFrame("Sudoku");
    protected JLabel textLabel = new JLabel();
    protected JPanel textPanel = new JPanel();
    protected JPanel boardPanel = new JPanel();
    protected JPanel buttonsPanel = new JPanel();
    protected JButton numSelected = null;
    protected int errors = 0;

    public Sudoku()
     {
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Sudoku: 0");
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(9, 9));
        new Tiles(this).setupTiles();
        frame.add(boardPanel, BorderLayout.CENTER);

        buttonsPanel.setLayout(new GridLayout(1, 9));
        new InputButtons(this).inputButtons();
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
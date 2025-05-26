package Sudoku;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class InputButtons implements Buttons 
{
    private Sudoku sudoku;

    public InputButtons(Sudoku sudoku) 
    {
        this.sudoku = sudoku;
    }
    
    public void inputButtons() 
    {
        for (int i = 1; i < 10; i++) 
        {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setText(String.valueOf(i));
            button.setFocusable(false);
            button.setBackground(Color.WHITE);
            sudoku.buttonsPanel.add(button);

            button.addActionListener(new ActionListener() 
            {public void actionPerformed(ActionEvent e) 
                {
                    JButton button = (JButton) e.getSource();
                    if (sudoku.numSelected != null)
                    {
                        sudoku.numSelected.setBackground(Color.WHITE);
                    }
                    sudoku.numSelected = button;
                    sudoku.numSelected.setBackground(Color.LIGHT_GRAY);
                }
            });
        }
    }
}
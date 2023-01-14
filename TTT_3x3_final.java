package ttt_3x3;

import java.awt.Color;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTT_3x3_final extends javax.swing.JFrame {

    private String startGame;
//    private String user;
    private int xCount = 0;
    private int oCount = 0;
    private int counter = 0;
    private boolean gameEnded = false;
    private boolean playerSelect = false;
    private boolean CompFirst = false;
    List<JButton> availableButtons = new ArrayList<JButton>();
    
    public TTT_3x3_final() {
        initComponents();
//        disableButtons();
    }
        
    private void disableButtons() {
        txtbtn1.setEnabled(false);
        txtbtn2.setEnabled(false);
        txtbtn3.setEnabled(false);
        txtbtn4.setEnabled(false);
        txtbtn5.setEnabled(false);
        txtbtn6.setEnabled(false);
        txtbtn7.setEnabled(false);
        txtbtn8.setEnabled(false);
        txtbtn9.setEnabled(false);
    }

    private void enableButtons() {
        txtbtn1.setEnabled(true);
        txtbtn2.setEnabled(true);
        txtbtn3.setEnabled(true);
        txtbtn4.setEnabled(true);
        txtbtn5.setEnabled(true);
        txtbtn6.setEnabled(true);
        txtbtn7.setEnabled(true);
        txtbtn8.setEnabled(true);
        txtbtn9.setEnabled(true);
    }
        
    private void gameScore()
    {
        val_player.setText(String.valueOf(xCount));
        val_comp.setText(String.valueOf(oCount));
        checkForTie();
    }
    
    private void choose_a_Player()
    {
        String[] options = {"Player", "Comp"};
        int choice = JOptionPane.showOptionDialog(this, "Choose a player to start:", "Start Game", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if(options[choice].equals("Player")){
            startGame = "X";
            CompFirst = false;
        }
        else{
            startGame = "O";
            CompFirst = true;
        }
        
//        if(options[choice].equals("Player")){
//            user = "Player";
//        }else{
//            user = "Computer";
//        }
        playerSelect = true;
        counter = 0;
        gameEnded = false;
    }
    
    private void gameplay()
    {
        if(startGame.equalsIgnoreCase("X"))
        {
            startGame = "O";
        }
        else
        {
            startGame = "X";
        }
    }
    
     private boolean checkForWin() {
        String b1 = txtbtn1.getText();
        String b2 = txtbtn2.getText();
        String b3 = txtbtn3.getText();
   
        String b4 = txtbtn4.getText();
        String b5 = txtbtn5.getText();
        String b6 = txtbtn6.getText();
        
        String b7 = txtbtn7.getText();
        String b8 = txtbtn8.getText();
        String b9 = txtbtn9.getText();
        
        // check for winning combination for player X
        if(b1 == ("X") && b2 ==("X") && b3 == ("X")){
            return true;
        }
        if(b4 == ("X") && b5 ==("X") && b6 == ("X")){
            return true;
        }
        if(b7 == ("X") && b8 ==("X") && b9 == ("X")){
            return true;
        }
        if(b1 == ("X") && b4 ==("X") && b7 == ("X")){
            return true;
        }
        if(b2 == ("X") && b5 ==("X") && b8 == ("X")){
            return true;
        }
        if(b3 == ("X") && b6 ==("X") && b9 == ("X")){
            return true;
        }
        if(b1 == ("X") && b5 ==("X") && b9 == ("X")){
            return true;
        }
        if(b3 == ("X") && b5 ==("X") && b7 == ("X")){
            return true;
        }
        
        // check for winning combination for computer player
        if(b1 == ("O") && b2 ==("O") && b3 == ("O")){
            return true;
        }
        if(b4 == ("O") && b5 ==("O") && b6 == ("O")){
            return true;
        }
        if(b7 == ("O") && b8 ==("O") && b9 == ("O")){
            return true;
        }
        if(b1 == ("O") && b4 ==("O") && b7 == ("O")){
            return true;
        }
        if(b2 == ("O") && b5 ==("O") && b8 == ("O")){
            return true;
        }
        if(b3 == ("O") && b6 ==("O") && b9 == ("O")){
            return true;
        }
        if(b1 == ("O") && b5 ==("O") && b9 == ("O")){
            return true;
        }
        if(b3 == ("O") && b5 ==("O") && b7 == ("O")){
            return true;
        }
        return false;
}
    
    private void checkForTie() {
        if (!gameEnded && counter >= 10 && !checkForWin()) {
        JOptionPane.showMessageDialog(this, "Tie", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
        gameEnded = true;
        playerSelect = true;
    }
}
    
 private void computerMove() {
    // Create a list to store all available buttons (empty spots on the board)
    // Add all empty buttons to the list
    if (txtbtn1.getText().isEmpty()) {
        availableButtons.add(txtbtn1);
    }
    if (txtbtn2.getText().isEmpty()) {
        availableButtons.add(txtbtn2);
    }
    if (txtbtn3.getText().isEmpty()) {
        availableButtons.add(txtbtn3);
    }
    if (txtbtn4.getText().isEmpty()) {
        availableButtons.add(txtbtn4);
    }
    if (txtbtn5.getText().isEmpty()) {
        availableButtons.add(txtbtn5);
    }
    if (txtbtn6.getText().isEmpty()) {
        availableButtons.add(txtbtn6);
    }
    if (txtbtn7.getText().isEmpty()) {
        availableButtons.add(txtbtn7);
    }
    if (txtbtn8.getText().isEmpty()) {
        availableButtons.add(txtbtn8);
    }
    if (txtbtn9.getText().isEmpty()) {
        availableButtons.add(txtbtn9);
    }

    // Use Math.random() to generate a random index
    int randomIndex = (int) (Math.random() * availableButtons.size());
    // Get the button at the random index
    JButton randomButton = availableButtons.get(randomIndex);
    // Set the text of the button to "O" (for the computer's move)
    randomButton.setText(startGame);
    randomButton.setForeground(new java.awt.Color(235,94,40));
    // Decrement the counter
    counter++;
    // Check for win or tie
    gameplay();
    winningGame();
    checkForTie();
}

    
     private void winningGame()
    {
        String b1 = txtbtn1.getText();
        String b2 = txtbtn2.getText();
        String b3 = txtbtn3.getText();
       
        String b4 = txtbtn4.getText();
        String b5 = txtbtn5.getText();
        String b6 = txtbtn6.getText();
        
        String b7 = txtbtn7.getText();
        String b8 = txtbtn8.getText();
        String b9 = txtbtn9.getText();
        
        
        // PLAYER X CODING
        if (!gameEnded && checkForWin()) {
            if(b1 == ("X") && b2 ==("X") && b3 == ("X"))
            {
                JOptionPane.showMessageDialog(this, "Player wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                xCount++;
                gameScore();

                txtbtn1.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn2.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn3.setBackground(new java.awt.Color(42, 157, 143));

            }

            if(b4 == ("X") && b5 ==("X") && b6 == ("X"))
            {
                JOptionPane.showMessageDialog(this, "Player wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                xCount++;
                gameScore();

                txtbtn4.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn5.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn6.setBackground(new java.awt.Color(42, 157, 143));           
            }

            if(b7 == ("X") && b8 ==("X") && b9 == ("X"))
            {
                JOptionPane.showMessageDialog(this, "Player wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                xCount++;
                gameScore();

                txtbtn7.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn8.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn9.setBackground(new java.awt.Color(42, 157, 143));           
            }

            if(b1 == ("X") && b4 ==("X") && b7 == ("X"))
            {
                JOptionPane.showMessageDialog(this, "Player wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                xCount++;
                gameScore();

                txtbtn1.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn4.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn7.setBackground(new java.awt.Color(42, 157, 143));           
            }

            if(b2 == ("X") && b5 ==("X") && b8 == ("X"))
            {
                JOptionPane.showMessageDialog(this, "Player wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                xCount++;
                gameScore();

                txtbtn2.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn5.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn8.setBackground(new java.awt.Color(42, 157, 143));           
            }
            if(b3 == ("X") && b6 ==("X") && b9 == ("X"))
            {
                JOptionPane.showMessageDialog(this, "Player wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                xCount++;
                gameScore();

                txtbtn3.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn6.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn9.setBackground(new java.awt.Color(42, 157, 143));           
            }


            if(b1 == ("X") && b5 ==("X") && b9 == ("X"))
            {
                JOptionPane.showMessageDialog(this, "Player wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                xCount++;
                gameScore();

                txtbtn1.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn5.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn9.setBackground(new java.awt.Color(42, 157, 143));           
            }

            if(b3 == ("X") && b5 ==("X") && b7 == ("X"))
            {
                JOptionPane.showMessageDialog(this, "Player wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                xCount++;
                gameScore();

                txtbtn3.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn5.setBackground(new java.awt.Color(42, 157, 143));
                txtbtn7.setBackground(new java.awt.Color(42, 157, 143));           
            }



            // PLAYER O CODING


            if(b1 == ("O") && b2 ==("O") && b3 == ("O"))
            {
                JOptionPane.showMessageDialog(this, "Comp wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                oCount++;
                gameScore();

                txtbtn1.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn2.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn3.setBackground(new java.awt.Color(64, 61, 57));

            }

            if(b4 == ("O") && b5 ==("O") && b6 == ("O"))
            {
                JOptionPane.showMessageDialog(this, "Comp wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                oCount++;
                gameScore();

                txtbtn4.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn5.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn6.setBackground(new java.awt.Color(64, 61, 57));           
            }

            if(b7 == ("O") && b8 ==("O") && b9 == ("O"))
            {
                JOptionPane.showMessageDialog(this, "Comp wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                oCount++;
                gameScore();

                txtbtn7.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn8.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn9.setBackground(new java.awt.Color(64, 61, 57));           
            }

            if(b1 == ("O") && b4 ==("O") && b7 == ("O"))
            {
                JOptionPane.showMessageDialog(this, "Comp wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                oCount++;
                gameScore();

                txtbtn1.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn4.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn7.setBackground(new java.awt.Color(64, 61, 57));           
            }

            if(b2 == ("O") && b5 ==("O") && b8 == ("O"))
            {
                JOptionPane.showMessageDialog(this, "Comp wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                oCount++;
                gameScore();

                txtbtn2.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn5.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn8.setBackground(new java.awt.Color(64, 61, 57));           
            }
            if(b3 == ("O") && b6 ==("O") && b9 == ("O"))
            {
                JOptionPane.showMessageDialog(this, "Comp wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                oCount++;
                gameScore();

                txtbtn3.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn6.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn9.setBackground(new java.awt.Color(64, 61, 57));           
            }


            if(b1 == ("O") && b5 ==("O") && b9 == ("O"))
            {
                JOptionPane.showMessageDialog(this, "Comp wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                oCount++;
                gameScore();

                txtbtn1.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn5.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn9.setBackground(new java.awt.Color(64, 61, 57));           
            }

            if(b3 == ("O") && b5 ==("O") && b7 == ("O"))
            {
                JOptionPane.showMessageDialog(this, "Comp wins", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                oCount++;
                gameScore();

                txtbtn3.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn5.setBackground(new java.awt.Color(64, 61, 57));
                txtbtn7.setBackground(new java.awt.Color(64, 61, 57));           
            } 
            gameEnded = true;
            return;
        }
    } 
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtbtn1 = new javax.swing.JButton();
        txtbtn2 = new javax.swing.JButton();
        txtbtn3 = new javax.swing.JButton();
        txtbtn4 = new javax.swing.JButton();
        txtbtn5 = new javax.swing.JButton();
        txtbtn6 = new javax.swing.JButton();
        txtbtn7 = new javax.swing.JButton();
        txtbtn8 = new javax.swing.JButton();
        txtbtn9 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        player = new javax.swing.JLabel();
        comp = new javax.swing.JLabel();
        val_player = new javax.swing.JLabel();
        val_comp = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(231, 111, 81));
        jPanel5.setFont(new java.awt.Font("Montserrat Medium", 0, 36)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TIC TAC TOE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jLabel5.getAccessibleContext().setAccessibleName("title");

        txtbtn1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtn1ActionPerformed(evt);
            }
        });

        txtbtn2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtn2ActionPerformed(evt);
            }
        });

        txtbtn3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtn3ActionPerformed(evt);
            }
        });

        txtbtn4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtn4ActionPerformed(evt);
            }
        });

        txtbtn5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtn5ActionPerformed(evt);
            }
        });

        txtbtn6.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtbtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtn6ActionPerformed(evt);
            }
        });

        txtbtn7.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtbtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtn7ActionPerformed(evt);
            }
        });

        txtbtn8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtbtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtn8ActionPerformed(evt);
            }
        });

        txtbtn9.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtbtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtn9ActionPerformed(evt);
            }
        });

        player.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 24)); // NOI18N
        player.setForeground(new java.awt.Color(64, 61, 57));
        player.setText("Player   :");

        comp.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 24)); // NOI18N
        comp.setForeground(new java.awt.Color(64, 61, 57));
        comp.setText("Comp    :");

        val_player.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 24)); // NOI18N
        val_player.setForeground(new java.awt.Color(64, 61, 57));

        val_comp.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 24)); // NOI18N
        val_comp.setForeground(new java.awt.Color(64, 61, 57));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comp)
                    .addComponent(player))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(val_comp)
                    .addComponent(val_player))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(val_player)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(val_comp))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(player)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comp)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButtonReset.setBackground(new java.awt.Color(233, 196, 106));
        jButtonReset.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jButtonReset.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReset.setText("RESET");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonExit.setBackground(new java.awt.Color(244, 162, 67));
        jButtonExit.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("EXIT");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonStart.setBackground(new java.awt.Color(42, 157, 143));
        jButtonStart.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jButtonStart.setForeground(new java.awt.Color(255, 255, 255));
        jButtonStart.setText("START");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtbtn9, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonStart, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtn1ActionPerformed
        // TODO add your handling code here:
        if(!gameEnded){
            txtbtn1.setText(startGame);

            if(startGame.equalsIgnoreCase("X"))
            {
                txtbtn1.setForeground(new java.awt.Color(64, 61, 57));
            }
            else
            {
                txtbtn1.setForeground(new java.awt.Color(235,94,40));
            }

            counter++;
            gameplay(); //Swap value after X to O or otherwise
            winningGame(); //Check condition if winning the Game
            checkForTie(); //Check condition if game is tie
            if(startGame.equalsIgnoreCase("O")){    
            computerMove(); //Randomize
            }
        }
    }//GEN-LAST:event_txtbtn1ActionPerformed
    
    private void txtbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtn2ActionPerformed
        // TODO add your handling code here:
        if(!gameEnded){
            txtbtn2.setText(startGame);

            if(startGame.equalsIgnoreCase("X"))
            {
                txtbtn2.setForeground(new java.awt.Color(64, 61, 57));
            }
            else
            {
                txtbtn2.setForeground(new java.awt.Color(235,94,40));
            }

            counter++;
            gameplay();
            winningGame();
            checkForTie();
            if(startGame.equalsIgnoreCase("O")){    
            computerMove(); //Randomize
            }
        }
    }//GEN-LAST:event_txtbtn2ActionPerformed

    private void txtbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtn3ActionPerformed
        // TODO add your handling code here:
        if(!gameEnded){
            txtbtn3.setText(startGame);

            if(startGame.equalsIgnoreCase("X"))
            {
                txtbtn3.setForeground(new java.awt.Color(64, 61, 57));
            }
            else
            {
                txtbtn3.setForeground(new java.awt.Color(235,94,40));
            }

            counter++;
            gameplay();
            winningGame();
            checkForTie();
            if(startGame.equalsIgnoreCase("O")){    
            computerMove(); //Randomize
            }
        }
    }//GEN-LAST:event_txtbtn3ActionPerformed

    private void txtbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtn4ActionPerformed
        // TODO add your handling code here:
        if(!gameEnded){
            txtbtn4.setText(startGame);

            if(startGame.equalsIgnoreCase("X"))
            {
                txtbtn4.setForeground(new java.awt.Color(64, 61, 57));
            }
            else
            {
                txtbtn4.setForeground(new java.awt.Color(235,94,40));
            }

            counter++;
            gameplay();
            winningGame();
            checkForTie();
            if(startGame.equalsIgnoreCase("O")){    
            computerMove(); //Randomize
            }
        }
    }//GEN-LAST:event_txtbtn4ActionPerformed

    private void txtbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtn5ActionPerformed
        // TODO add your handling code here:
        if(!gameEnded){
            txtbtn5.setText(startGame);

            if(startGame.equalsIgnoreCase("X"))
            {
                txtbtn5.setForeground(new java.awt.Color(64, 61, 57));
            }
            else
            {
                txtbtn5.setForeground(new java.awt.Color(235,94,40));
            }

            counter++;
            gameplay();
            winningGame();
            checkForTie();
            if(startGame.equalsIgnoreCase("O")){    
            computerMove(); //Randomize
            }
        }
    }//GEN-LAST:event_txtbtn5ActionPerformed

    private void txtbtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtn6ActionPerformed
        // TODO add your handling code here:
        if(!gameEnded){
            txtbtn6.setText(startGame);

            if(startGame.equalsIgnoreCase("X"))
            {
                txtbtn6.setForeground(new java.awt.Color(64, 61, 57));
            }
            else
            {
                txtbtn6.setForeground(new java.awt.Color(235,94,40));
            }

            counter++;
            gameplay();
            winningGame();
            checkForTie();
            if(startGame.equalsIgnoreCase("O")){    
            computerMove(); //Randomize
            }
        }
    }//GEN-LAST:event_txtbtn6ActionPerformed

    private void txtbtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtn7ActionPerformed
        // TODO add your handling code here:
        if(!gameEnded){
            txtbtn7.setText(startGame);

            if(startGame.equalsIgnoreCase("X"))
            {
                txtbtn7.setForeground(new java.awt.Color(64, 61, 57));
            }
            else
            {
                txtbtn7.setForeground(new java.awt.Color(235,94,40));
            }

            counter++;
            gameplay();
            winningGame();
            checkForTie();
            if(startGame.equalsIgnoreCase("O")){    
            computerMove(); //Randomize
            }
        }
    }//GEN-LAST:event_txtbtn7ActionPerformed

    private void txtbtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtn8ActionPerformed
        // TODO add your handling code here:
        if(!gameEnded){
            txtbtn8.setText(startGame);

            if(startGame.equalsIgnoreCase("X"))
            {
                txtbtn8.setForeground(new java.awt.Color(64, 61, 57));
            }
            else
            {
                txtbtn8.setForeground(new java.awt.Color(235,94,40));
            }

            counter++;
            gameplay();
            winningGame();
            checkForTie();
            if(startGame.equalsIgnoreCase("O")){    
            computerMove(); //Randomize
            }
        }
    }//GEN-LAST:event_txtbtn8ActionPerformed

    private void txtbtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtn9ActionPerformed
        // TODO add your handling code here:
        if(!gameEnded){
            txtbtn9.setText(startGame);

            if(startGame.equalsIgnoreCase("X"))
            {
                txtbtn9.setForeground(new java.awt.Color(64, 61, 57));
            }
            else
            {
                txtbtn9.setForeground(new java.awt.Color(235,94,40));
            }

            counter++;
            gameplay();
            winningGame();
            checkForTie();
            if(startGame.equalsIgnoreCase("O")){    
            computerMove(); //Randomize
            }
        }
    }//GEN-LAST:event_txtbtn9ActionPerformed
  
    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        // TODO add your handling code here:
        if(gameEnded){
            JOptionPane.showMessageDialog(this, "Restart game first!", "Tic Tac Toe", JOptionPane.WARNING_MESSAGE);
        }else{
        enableButtons();
        choose_a_Player();
        playerSelect = true;
        if(CompFirst){
            computerMove();
        }
        }
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Confirm if you want Exit", 
                "Tic Tac Toe",
                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
 
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        
        if(!playerSelect){
            JOptionPane.showMessageDialog(this, "Please select a player first!", "Tic Tac Toe", JOptionPane.WARNING_MESSAGE);
        }
        else{
            if (JOptionPane.showConfirmDialog(this, "Reset the game?", 
                    "Tic Tac Toe",
                    JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
            {
                playerSelect = false;
                disableButtons();
                txtbtn1.setText(null);
                txtbtn2.setText(null);
                txtbtn3.setText(null);

                txtbtn4.setText(null);
                txtbtn5.setText(null);
                txtbtn6.setText(null);

                txtbtn7.setText(null);
                txtbtn8.setText(null);
                txtbtn9.setText(null);

                txtbtn1.setBackground(Color.WHITE);
                txtbtn2.setBackground(Color.WHITE);
                txtbtn3.setBackground(Color.WHITE);

                txtbtn4.setBackground(Color.WHITE);
                txtbtn5.setBackground(Color.WHITE);
                txtbtn6.setBackground(Color.WHITE);

                txtbtn7.setBackground(Color.WHITE);
                txtbtn8.setBackground(Color.WHITE);
                txtbtn9.setBackground(Color.WHITE);
                counter = 0;
                availableButtons.clear();
                gameEnded = false;
            }
        }
    }//GEN-LAST:event_jButtonResetActionPerformed
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TTT_3x3_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TTT_3x3_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TTT_3x3_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TTT_3x3_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TTT_3x3_final().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel comp;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel player;
    private javax.swing.JButton txtbtn1;
    private javax.swing.JButton txtbtn2;
    private javax.swing.JButton txtbtn3;
    private javax.swing.JButton txtbtn4;
    private javax.swing.JButton txtbtn5;
    private javax.swing.JButton txtbtn6;
    private javax.swing.JButton txtbtn7;
    private javax.swing.JButton txtbtn8;
    private javax.swing.JButton txtbtn9;
    private javax.swing.JLabel val_comp;
    private javax.swing.JLabel val_player;
    // End of variables declaration//GEN-END:variables
}

package com.droidrank.tictactoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    Button block1, block2, block3, block4, block5, block6, block7, block8, block9, restart;
    TextView result;

    List<List<Button>> winningCombinations = new ArrayList<List<Button>>();

    boolean gameIsOver = false;

    private int clickCounter;

    private void setUpWinningCombinations(){
        winningCombinations.add(Arrays.asList(block1,block2,block3));
        winningCombinations.add(Arrays.asList(block1,block4,block7));
        winningCombinations.add(Arrays.asList(block1,block5,block9));
        winningCombinations.add(Arrays.asList(block2,block5,block8));
        winningCombinations.add(Arrays.asList(block3,block6,block9));
        winningCombinations.add(Arrays.asList(block3,block5,block7));
        winningCombinations.add(Arrays.asList(block4,block5,block6));
        winningCombinations.add(Arrays.asList(block7,block8,block9));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        block1 = (Button) findViewById(R.id.bt_block1);
        block1.setOnClickListener(this);
        block2 = (Button) findViewById(R.id.bt_block2);
        block2.setOnClickListener(this);
        block3 = (Button) findViewById(R.id.bt_block3);
        block3.setOnClickListener(this);
        block4 = (Button) findViewById(R.id.bt_block4);
        block4.setOnClickListener(this);
        block5 = (Button) findViewById(R.id.bt_block5);
        block5.setOnClickListener(this);
        block6 = (Button) findViewById(R.id.bt_block6);
        block6.setOnClickListener(this);
        block7 = (Button) findViewById(R.id.bt_block7);
        block7.setOnClickListener(this);
        block8 = (Button) findViewById(R.id.bt_block8);
        block8.setOnClickListener(this);
        block9 = (Button) findViewById(R.id.bt_block9);
        block9.setOnClickListener(this);
        result = (TextView) findViewById(R.id.tv_show_result);
        restart = (Button) findViewById(R.id.bt_restart_game);


        



        /**
         * Restarts the game
         */
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameIsOver){
                    restart();
                }else{
                    confirmRestart();
                }
            }
        });

    }

    private void confirmRestart() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to restart?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Restarting game...", Toast.LENGTH_SHORT).show();
                restart();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Resuming game", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    public void restart(){
        this.recreate();
    }

    public void checkWhoWon(){
        setUpWinningCombinations();
        boolean player1Won = checkForThreeInARow("O");
        boolean player2Won = checkForThreeInARow("X");
        String playerString = "Player ";
        String wonString = " Wins";

        if(player1Won) {
            result.setText(playerString + 1 + wonString);
            gameIsOver = true;
            restart.setText("Start New Game");
        }else if (player2Won){
            result.setText(playerString + 2 + wonString);
            gameIsOver = true;
            restart.setText("Start New Game");
        }else if (allTilesHaveValue() && (!player1Won && !player2Won)){
            result.setText("It's a Tie");
            gameIsOver = true;
            restart.setText("Start New Game");
        }
    }

    private boolean checkForThreeInARow(String playerSymbol){
        boolean thisPlayerWon = false;
        for(List<Button> winningCombination : winningCombinations){
            int cellCounter = 0;
            for(Button btn : winningCombination){
                if(btn.getText().equals(playerSymbol)){
                    cellCounter+=1;
                }
                if(cellCounter == 3){
                    thisPlayerWon = true;
                    break;
                }
            }
            if(thisPlayerWon){
                break;
            }
        }
        return thisPlayerWon;
    }

    private boolean allTilesHaveValue(){
        boolean allTilesHaveAValue = true;
        List<Button> buttons = new ArrayList<Button>(Arrays.asList(block1,block2,block3,block4,block6,block7,block8,block9));
        for(Button btn : buttons){
            if(btn.getText() != null){
                allTilesHaveAValue = false;
                break;
            }
        }
        return allTilesHaveAValue;
    }


    @Override
    public void onClick(View v) {
        clickCounter+=1;
        if(clickCounter == 1){
            restart.setText("Restart");
        }
        String blockTextValue = clickCounter % 2 == 0 ? "X" :"O";
        if(!gameIsOver){
            if(v.getId() == R.id.bt_block1) {
                if(block1.getText().length() == 0){
                    block1.setText(blockTextValue);
                }
            }else if(v.getId() == R.id.bt_block2){
                if(block2.getText().length() == 0){
                    block2.setText(blockTextValue);
                }
            }else if(v.getId() == R.id.bt_block3){
                if(block3.getText().length() == 0){
                    block3.setText(blockTextValue);
                }
            }else if(v.getId() == R.id.bt_block4){
                if(block4.getText().length() == 0){
                    block4.setText(blockTextValue);
                }
            }else if(v.getId() == R.id.bt_block5){
                if(block5.getText().length() == 0){
                    block5.setText(blockTextValue);
                }
            }else if(v.getId() == R.id.bt_block6){
                if(block6.getText().length() == 0){
                    block6.setText(blockTextValue);
                }
            }else if(v.getId() == R.id.bt_block7){
                if(block7.getText().length() == 0){
                    block7.setText(blockTextValue);
                }
            }else if(v.getId() == R.id.bt_block8){
                if(block8.getText().length() == 0){
                    block8.setText(blockTextValue);
                }
            }else if(v.getId() == R.id.bt_block9){
                if(block9.getText().length() == 0){
                    block9.setText(blockTextValue);
                }
            }  //probably should have done switch-case
        }
        checkWhoWon();
    }
}

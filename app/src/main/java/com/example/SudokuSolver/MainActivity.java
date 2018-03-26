package com.example.SudokuSolver;
import com.example.myfirstapp.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private static final String KEY_TEXT_VALUE = "1";

    private TextView textView;

    private int[][] mTijdelijkResultaat;
    private int[][] mImportUitInterface;

    private boolean IsItLegal(int iX, int iY, int i)
    {
        for (int x = 0; x < 9; x++)
        {
            if (mImportUitInterface[x][iY] == i)
                if (x != iX)
                    return false;
            if (mTijdelijkResultaat[x][iY] == i)
                if (x != iX)
                    return false;
        }

        for (int y = 0; y < 9; y++)
        {
            if (mImportUitInterface[iX][y] == i)
                if (y != iY)
                    return false;
            if (mTijdelijkResultaat[iX][y] == i)
                if (y != iY)
                    return false;
        }

        //T// /get cells sector.
        int tX, tY;
        tX = (iX / 3) * 3;
        tY = (iY / 3) * 3;

        // check cells sector.
        for (int x = tX; x < (tX + 3); x++)
        {
            for (int y = tY; y < (tY + 3); y++)
            {
                if (mImportUitInterface[x][y] == i)
                    if (x != iX)
                        if (y != iY)
                            return false;
                if (mTijdelijkResultaat[x][y] == i)
                    if (x != iX)
                        if (y != iY)
                            return false;
            }
        }
        return true;
    }

    private int GetNextPos(int iX, int iY)
    {
        if (mImportUitInterface[iX][iY] != 0)
        {
            return 2;
        }

        while (mTijdelijkResultaat[iX][iY] < 9)
        {
            mTijdelijkResultaat[iX][iY] += 1;
            if (IsItLegal(iX, iY, mTijdelijkResultaat[iX][iY]))
            {
                return 1;
            }
        }
        mTijdelijkResultaat[iX][iY] = 0;
        return -1; // No More Possibilities.
    }

    private boolean GetSolution()
    {
        /*
         * berekeningen hier.
         * */
        int error = 0;

        for (int x = 0; x < 9; x++)
        {
            for (int y = 0; y < 9; y++)
            {
                int temp = GetNextPos(x, y);
                if (temp == -1)
                {
                    error = 1;
                }
                else if (temp == 1)
                {
                    error = 0;
                }

                if (error == 1)
                {
                    if (y > 0)
                    {
                        y -= 2;
                    }
                    else if (y == 0 && x > 0)
                    {
                        x--;
                        y = 7;
                    }
                    else if ((x == 0) && (y == 0))
                    {
                        /*
                         * Not valid.
                         * */
                        return true;
                    }
                }
                //first solution.
            }
        }
        return false;
    }

    private boolean InputValid()
    {
        /*
         * check if input is valide
         * */
        for (int x = 0; x < 9; x++)
        {
            for (int y = 0; y < 9; y++)
            {
                if (mImportUitInterface[x][y] != 0)
                {
                    if (!IsItLegal(x, y, mImportUitInterface[x][y]))
                    {
                        /*
                         * not valid.
                         * */
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
        {
            ArrayList<String> list = savedInstanceState.getStringArrayList(KEY_TEXT_VALUE);

            ((TextView)findViewById(R.id.TextView_1)).setText(list.get(0));
            ((TextView)findViewById(R.id.TextView_2)).setText(list.get(1));
            ((TextView)findViewById(R.id.TextView_3)).setText(list.get(2));
            ((TextView)findViewById(R.id.TextView_4)).setText(list.get(3));
            ((TextView)findViewById(R.id.TextView_5)).setText(list.get(4));
            ((TextView)findViewById(R.id.TextView_6)).setText(list.get(5));
            ((TextView)findViewById(R.id.TextView_7)).setText(list.get(6));
            ((TextView)findViewById(R.id.TextView_8)).setText(list.get(7));
            ((TextView)findViewById(R.id.TextView_9)).setText(list.get(8));
            ((TextView)findViewById(R.id.TextView_10)).setText(list.get(9));
            ((TextView)findViewById(R.id.TextView_11)).setText(list.get(10));
            ((TextView)findViewById(R.id.TextView_12)).setText(list.get(11));
            ((TextView)findViewById(R.id.TextView_13)).setText(list.get(12));
            ((TextView)findViewById(R.id.TextView_14)).setText(list.get(13));
            ((TextView)findViewById(R.id.TextView_15)).setText(list.get(14));
            ((TextView)findViewById(R.id.TextView_16)).setText(list.get(15));
            ((TextView)findViewById(R.id.TextView_17)).setText(list.get(16));
            ((TextView)findViewById(R.id.TextView_18)).setText(list.get(17));
            ((TextView)findViewById(R.id.TextView_19)).setText(list.get(18));
            ((TextView)findViewById(R.id.TextView_20)).setText(list.get(19));
            ((TextView)findViewById(R.id.TextView_21)).setText(list.get(20));
            ((TextView)findViewById(R.id.TextView_22)).setText(list.get(21));
            ((TextView)findViewById(R.id.TextView_23)).setText(list.get(22));
            ((TextView)findViewById(R.id.TextView_24)).setText(list.get(23));
            ((TextView)findViewById(R.id.TextView_25)).setText(list.get(24));
            ((TextView)findViewById(R.id.TextView_26)).setText(list.get(25));
            ((TextView)findViewById(R.id.TextView_27)).setText(list.get(26));
            ((TextView)findViewById(R.id.TextView_28)).setText(list.get(27));
            ((TextView)findViewById(R.id.TextView_29)).setText(list.get(28));
            ((TextView)findViewById(R.id.TextView_30)).setText(list.get(29));
            ((TextView)findViewById(R.id.TextView_31)).setText(list.get(30));
            ((TextView)findViewById(R.id.TextView_32)).setText(list.get(31));
            ((TextView)findViewById(R.id.TextView_33)).setText(list.get(32));
            ((TextView)findViewById(R.id.TextView_34)).setText(list.get(33));
            ((TextView)findViewById(R.id.TextView_35)).setText(list.get(34));
            ((TextView)findViewById(R.id.TextView_36)).setText(list.get(35));
            ((TextView)findViewById(R.id.TextView_37)).setText(list.get(36));
            ((TextView)findViewById(R.id.TextView_38)).setText(list.get(37));
            ((TextView)findViewById(R.id.TextView_39)).setText(list.get(38));
            ((TextView)findViewById(R.id.TextView_40)).setText(list.get(39));
            ((TextView)findViewById(R.id.TextView_41)).setText(list.get(40));
            ((TextView)findViewById(R.id.TextView_42)).setText(list.get(41));
            ((TextView)findViewById(R.id.TextView_43)).setText(list.get(42));
            ((TextView)findViewById(R.id.TextView_44)).setText(list.get(43));
            ((TextView)findViewById(R.id.TextView_45)).setText(list.get(44));
            ((TextView)findViewById(R.id.TextView_46)).setText(list.get(45));
            ((TextView)findViewById(R.id.TextView_47)).setText(list.get(46));
            ((TextView)findViewById(R.id.TextView_48)).setText(list.get(47));
            ((TextView)findViewById(R.id.TextView_49)).setText(list.get(48));
            ((TextView)findViewById(R.id.TextView_50)).setText(list.get(49));
            ((TextView)findViewById(R.id.TextView_51)).setText(list.get(50));
            ((TextView)findViewById(R.id.TextView_52)).setText(list.get(51));
            ((TextView)findViewById(R.id.TextView_53)).setText(list.get(52));
            ((TextView)findViewById(R.id.TextView_54)).setText(list.get(53));
            ((TextView)findViewById(R.id.TextView_55)).setText(list.get(54));
            ((TextView)findViewById(R.id.TextView_56)).setText(list.get(55));
            ((TextView)findViewById(R.id.TextView_57)).setText(list.get(56));
            ((TextView)findViewById(R.id.TextView_58)).setText(list.get(57));
            ((TextView)findViewById(R.id.TextView_59)).setText(list.get(58));
            ((TextView)findViewById(R.id.TextView_60)).setText(list.get(59));
            ((TextView)findViewById(R.id.TextView_61)).setText(list.get(60));
            ((TextView)findViewById(R.id.TextView_62)).setText(list.get(61));
            ((TextView)findViewById(R.id.TextView_63)).setText(list.get(62));
            ((TextView)findViewById(R.id.TextView_64)).setText(list.get(63));
            ((TextView)findViewById(R.id.TextView_65)).setText(list.get(64));
            ((TextView)findViewById(R.id.TextView_66)).setText(list.get(65));
            ((TextView)findViewById(R.id.TextView_67)).setText(list.get(66));
            ((TextView)findViewById(R.id.TextView_68)).setText(list.get(67));
            ((TextView)findViewById(R.id.TextView_69)).setText(list.get(68));
            ((TextView)findViewById(R.id.TextView_70)).setText(list.get(69));
            ((TextView)findViewById(R.id.TextView_71)).setText(list.get(70));
            ((TextView)findViewById(R.id.TextView_72)).setText(list.get(71));
            ((TextView)findViewById(R.id.TextView_73)).setText(list.get(72));
            ((TextView)findViewById(R.id.TextView_74)).setText(list.get(73));
            ((TextView)findViewById(R.id.TextView_75)).setText(list.get(74));
            ((TextView)findViewById(R.id.TextView_76)).setText(list.get(75));
            ((TextView)findViewById(R.id.TextView_77)).setText(list.get(76));
            ((TextView)findViewById(R.id.TextView_78)).setText(list.get(77));
            ((TextView)findViewById(R.id.TextView_79)).setText(list.get(78));
            ((TextView)findViewById(R.id.TextView_80)).setText(list.get(79));
            ((TextView)findViewById(R.id.TextView_81)).setText(list.get(80));
        }
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putStringArrayList(KEY_TEXT_VALUE, GetGridData());
    }

    protected ArrayList<String> GetGridData()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add(((TextView)findViewById(R.id.TextView_1)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_2)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_3)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_4)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_5)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_6)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_7)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_8)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_9)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_10)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_11)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_12)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_13)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_14)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_15)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_16)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_17)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_18)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_19)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_20)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_21)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_22)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_23)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_24)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_25)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_26)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_27)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_28)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_29)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_30)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_31)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_32)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_33)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_34)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_35)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_36)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_37)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_38)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_39)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_40)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_41)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_42)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_43)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_44)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_45)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_46)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_47)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_48)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_49)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_50)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_51)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_52)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_53)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_54)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_55)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_56)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_57)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_58)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_59)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_60)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_61)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_62)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_63)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_64)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_65)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_66)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_67)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_68)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_69)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_70)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_71)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_72)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_73)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_74)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_75)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_76)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_77)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_78)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_79)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_80)).getText().toString());
        list.add(((TextView)findViewById(R.id.TextView_81)).getText().toString());

        return list;
    }

    protected void SetGridData(ArrayList<String> list)
    {
        ((TextView)findViewById(R.id.TextView_1)).setText(list.get(0));
        ((TextView)findViewById(R.id.TextView_2)).setText(list.get(1));
        ((TextView)findViewById(R.id.TextView_3)).setText(list.get(2));
        ((TextView)findViewById(R.id.TextView_4)).setText(list.get(3));
        ((TextView)findViewById(R.id.TextView_5)).setText(list.get(4));
        ((TextView)findViewById(R.id.TextView_6)).setText(list.get(5));
        ((TextView)findViewById(R.id.TextView_7)).setText(list.get(6));
        ((TextView)findViewById(R.id.TextView_8)).setText(list.get(7));
        ((TextView)findViewById(R.id.TextView_9)).setText(list.get(8));
        ((TextView)findViewById(R.id.TextView_10)).setText(list.get(9));
        ((TextView)findViewById(R.id.TextView_11)).setText(list.get(10));
        ((TextView)findViewById(R.id.TextView_12)).setText(list.get(11));
        ((TextView)findViewById(R.id.TextView_13)).setText(list.get(12));
        ((TextView)findViewById(R.id.TextView_14)).setText(list.get(13));
        ((TextView)findViewById(R.id.TextView_15)).setText(list.get(14));
        ((TextView)findViewById(R.id.TextView_16)).setText(list.get(15));
        ((TextView)findViewById(R.id.TextView_17)).setText(list.get(16));
        ((TextView)findViewById(R.id.TextView_18)).setText(list.get(17));
        ((TextView)findViewById(R.id.TextView_19)).setText(list.get(18));
        ((TextView)findViewById(R.id.TextView_20)).setText(list.get(19));
        ((TextView)findViewById(R.id.TextView_21)).setText(list.get(20));
        ((TextView)findViewById(R.id.TextView_22)).setText(list.get(21));
        ((TextView)findViewById(R.id.TextView_23)).setText(list.get(22));
        ((TextView)findViewById(R.id.TextView_24)).setText(list.get(23));
        ((TextView)findViewById(R.id.TextView_25)).setText(list.get(24));
        ((TextView)findViewById(R.id.TextView_26)).setText(list.get(25));
        ((TextView)findViewById(R.id.TextView_27)).setText(list.get(26));
        ((TextView)findViewById(R.id.TextView_28)).setText(list.get(27));
        ((TextView)findViewById(R.id.TextView_29)).setText(list.get(28));
        ((TextView)findViewById(R.id.TextView_30)).setText(list.get(29));
        ((TextView)findViewById(R.id.TextView_31)).setText(list.get(30));
        ((TextView)findViewById(R.id.TextView_32)).setText(list.get(31));
        ((TextView)findViewById(R.id.TextView_33)).setText(list.get(32));
        ((TextView)findViewById(R.id.TextView_34)).setText(list.get(33));
        ((TextView)findViewById(R.id.TextView_35)).setText(list.get(34));
        ((TextView)findViewById(R.id.TextView_36)).setText(list.get(35));
        ((TextView)findViewById(R.id.TextView_37)).setText(list.get(36));
        ((TextView)findViewById(R.id.TextView_38)).setText(list.get(37));
        ((TextView)findViewById(R.id.TextView_39)).setText(list.get(38));
        ((TextView)findViewById(R.id.TextView_40)).setText(list.get(39));
        ((TextView)findViewById(R.id.TextView_41)).setText(list.get(40));
        ((TextView)findViewById(R.id.TextView_42)).setText(list.get(41));
        ((TextView)findViewById(R.id.TextView_43)).setText(list.get(42));
        ((TextView)findViewById(R.id.TextView_44)).setText(list.get(43));
        ((TextView)findViewById(R.id.TextView_45)).setText(list.get(44));
        ((TextView)findViewById(R.id.TextView_46)).setText(list.get(45));
        ((TextView)findViewById(R.id.TextView_47)).setText(list.get(46));
        ((TextView)findViewById(R.id.TextView_48)).setText(list.get(47));
        ((TextView)findViewById(R.id.TextView_49)).setText(list.get(48));
        ((TextView)findViewById(R.id.TextView_50)).setText(list.get(49));
        ((TextView)findViewById(R.id.TextView_51)).setText(list.get(50));
        ((TextView)findViewById(R.id.TextView_52)).setText(list.get(51));
        ((TextView)findViewById(R.id.TextView_53)).setText(list.get(52));
        ((TextView)findViewById(R.id.TextView_54)).setText(list.get(53));
        ((TextView)findViewById(R.id.TextView_55)).setText(list.get(54));
        ((TextView)findViewById(R.id.TextView_56)).setText(list.get(55));
        ((TextView)findViewById(R.id.TextView_57)).setText(list.get(56));
        ((TextView)findViewById(R.id.TextView_58)).setText(list.get(57));
        ((TextView)findViewById(R.id.TextView_59)).setText(list.get(58));
        ((TextView)findViewById(R.id.TextView_60)).setText(list.get(59));
        ((TextView)findViewById(R.id.TextView_61)).setText(list.get(60));
        ((TextView)findViewById(R.id.TextView_62)).setText(list.get(61));
        ((TextView)findViewById(R.id.TextView_63)).setText(list.get(62));
        ((TextView)findViewById(R.id.TextView_64)).setText(list.get(63));
        ((TextView)findViewById(R.id.TextView_65)).setText(list.get(64));
        ((TextView)findViewById(R.id.TextView_66)).setText(list.get(65));
        ((TextView)findViewById(R.id.TextView_67)).setText(list.get(66));
        ((TextView)findViewById(R.id.TextView_68)).setText(list.get(67));
        ((TextView)findViewById(R.id.TextView_69)).setText(list.get(68));
        ((TextView)findViewById(R.id.TextView_70)).setText(list.get(69));
        ((TextView)findViewById(R.id.TextView_71)).setText(list.get(70));
        ((TextView)findViewById(R.id.TextView_72)).setText(list.get(71));
        ((TextView)findViewById(R.id.TextView_73)).setText(list.get(72));
        ((TextView)findViewById(R.id.TextView_74)).setText(list.get(73));
        ((TextView)findViewById(R.id.TextView_75)).setText(list.get(74));
        ((TextView)findViewById(R.id.TextView_76)).setText(list.get(75));
        ((TextView)findViewById(R.id.TextView_77)).setText(list.get(76));
        ((TextView)findViewById(R.id.TextView_78)).setText(list.get(77));
        ((TextView)findViewById(R.id.TextView_79)).setText(list.get(78));
        ((TextView)findViewById(R.id.TextView_80)).setText(list.get(79));
        ((TextView)findViewById(R.id.TextView_81)).setText(list.get(80));
    }

    public void Clear(View v)
    {
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i<81; i++)
            list.add("0");
        SetGridData(list);
    }

    public void Send(View v)
    {
        mTijdelijkResultaat = new int[9][];
        for (int y = 0; y < 9; y++)
        {
            mTijdelijkResultaat[y] = new int[9];
        }

        mImportUitInterface = new int[9][];
        for (int y = 0; y < 9; y++)
        {
            mImportUitInterface[y] = new int[9];
        }

        ArrayList<String> grid = GetGridData();
        for (int x=0;x<9;x++)
            for (int y=0;y<9;y++)
                mImportUitInterface[x][y] = Integer.parseInt(grid.get((x*9)+y));

        if (InputValid())
        {
            Toast.makeText(this, "Your Sudoku is inValid.", Toast.LENGTH_LONG).show();
            return;
        }

        if (GetSolution())
        {
            Toast.makeText(this, "No valid solution found.", Toast.LENGTH_LONG).show();
            return;
        }

        for (int x=0;x<9;x++)
            for (int y=0;y<9;y++)
                grid.set((x*9)+y, Integer.valueOf( mTijdelijkResultaat[x][y]==0?mImportUitInterface[x][y]:mTijdelijkResultaat[x][y] ).toString() );

        SetGridData(grid);

        Toast.makeText(this, "Solution found.", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void SetFocus(View v)
    {
        if ( textView != null )
            textView.setTextColor(Color.BLACK);

        textView=(TextView)v;
        textView.setTextColor(Color.RED);
    }

    public void SetInput(View v)
    {
        if ( textView != null )
        {
            switch (v.getId()) {
                case (R.id.button1):
                    textView.setText("1");
                break;
                case (R.id.button2):
                    textView.setText("2");
                break;
                case (R.id.button3):
                    textView.setText("3");
                break;
                case (R.id.button4):
                    textView.setText("4");
                break;
                case (R.id.button5):
                    textView.setText("5");
                break;
                case (R.id.button6):
                    textView.setText("6");
                break;
                case (R.id.button7):
                    textView.setText("7");
                break;
                case (R.id.button8):
                    textView.setText("8");
                break;
                case (R.id.button9):
                    textView.setText("9");
                break;
                case (R.id.button0):
                    textView.setText("0");
                break;

            }
        }
    }
}

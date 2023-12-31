package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView inputText , outputText;
    private String input ,output , newOutput;

    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,
            buttonAdd,buttonMultiplay , buttonSubs ,buttonDivision , buttonPoint,buttonPercent,
            buttonPower,buttonEqual,buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input_text);
        outputText=findViewById(R.id.output_text);

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonAdd =findViewById(R.id.addition_btn);
        buttonMultiplay =findViewById(R.id.multiply_btn);
        buttonSubs=findViewById(R.id.substraction_btn);
        buttonDivision=findViewById(R.id.division_btn);
        buttonPercent=findViewById(R.id.percent_btn);
        buttonPoint=findViewById(R.id.btnpoint);
        buttonEqual=findViewById(R.id.equal_btn);
        buttonPower=findViewById(R.id.power_btn);
        buttonClear=findViewById(R.id.clear_btn);

    }
    public void onButtonClicked(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "C":
                input=null;
                output=null;
                outputText.setText("");
                break;
            case "^":
                input+="^";
                solve();
                break;
            case "*":
                input+="*";
                solve();
                break;
            case "=":
                solve();
                break;
            case "%":
                input+="%";
                double d =Double.parseDouble(inputText.getText().toString())/100;
                outputText.setText(String.valueOf(d));
                break;
            default:
                if(input == null){
                    input="";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")){
                    solve();
                }
                input+=data;
        }
        inputText.setText(input);
    }
    private void solve(){
        if(input.split("\\+").length==2){
            String numbers[]=input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0])+ Double.parseDouble(numbers[1]);
                output= Double.toString(d);
                newOutput= cutdecimal(output);
                outputText.setText(newOutput);
                input=d+"";
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\*").length==2){
            String numbers[]=input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0])* Double.parseDouble(numbers[1]);
                output= Double.toString(d);
                newOutput= cutdecimal(output);
                outputText.setText(newOutput);
                input=d+"";
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\/").length==2){
            String numbers[]=input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0])/ Double.parseDouble(numbers[1]);
                output= Double.toString(d);
                newOutput= cutdecimal(output);
                outputText.setText(newOutput);
                input=d+"";
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\^").length==2){
            String numbers[]=input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output= Double.toString(d);
                newOutput= cutdecimal(output);
                outputText.setText(newOutput);
                input=d+"";
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\-").length==2){
            String numbers[]=input.split("\\-");
            try {
                if(Double.parseDouble(numbers[0])< Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[0])- Double.parseDouble(numbers[1]);
                    output= Double.toString(d);
                    newOutput= cutdecimal(output);
                    outputText.setText("-"+newOutput);
                    input=d+"";
                }else{
                    double d = Double.parseDouble(numbers[0])- Double.parseDouble(numbers[1]);
                    output= Double.toString(d);
                    newOutput= cutdecimal(output);
                    outputText.setText(newOutput);
                    input=d+"";
                }
            }catch (Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
    }
    private String cutdecimal(String number){
        String n [] = number.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                number=n[0];
            }
        }
        return number;
    }
}
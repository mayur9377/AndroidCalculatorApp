package com.example.calculatorpro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static ArrayList<String> history=new ArrayList<String>();
    TextView exp,res;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,b00,equal,dot,add,sub,mul,div,clear,per,cut,sin,cos,tan,log,pi,power,fac,paren1,paren2,root,e,ln1,history_button,inverse,deg;
    String expfinal="";
    String ans1="";
    int flag=1,flag_equal=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exp=(TextView) findViewById(R.id.exp);
        res=(TextView) findViewById(R.id.res);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        b0=(Button)findViewById(R.id.b0);
        b00=(Button)findViewById(R.id.b00);
        equal=(Button)findViewById(R.id.equal);
        dot=(Button)findViewById(R.id.dot);
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        mul=(Button)findViewById(R.id.mul);
        div=(Button)findViewById(R.id.div);
        clear=(Button)findViewById(R.id.clear);
        per=(Button)findViewById(R.id.per);
        cut=(Button)findViewById(R.id.cut);
        sin=(Button)findViewById(R.id.sin);
        cos=(Button)findViewById(R.id.cos);
        tan=(Button)findViewById(R.id.tan);
        pi=(Button)findViewById(R.id.pi);
        log=(Button)findViewById(R.id.log);
        ln1=(Button)findViewById(R.id.ln1);
        root=(Button)findViewById(R.id.root);
        inverse=(Button)findViewById(R.id.inverse);
        paren1=(Button)findViewById(R.id.paren1);
        paren2=(Button)findViewById(R.id.paren2);
        power=(Button)findViewById(R.id.power);
        fac=(Button)findViewById(R.id.fac);
        e=(Button)findViewById(R.id.e);
        history_button=(Button)findViewById(R.id.history_button);
        deg=(Button)findViewById(R.id.deg);
        deg.setOnClickListener(this);
        history_button.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        b00.setOnClickListener(this);
        equal.setOnClickListener(this);
        dot.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        clear.setOnClickListener(this);
        per.setOnClickListener(this);
        cut.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        log.setOnClickListener(this);
        ln1.setOnClickListener(this);
        e.setOnClickListener(this);
        power.setOnClickListener(this);
        paren1.setOnClickListener(this);
        paren2.setOnClickListener(this);
        fac.setOnClickListener(this);
        pi.setOnClickListener(this);
        root.setOnClickListener(this);
        inverse.setOnClickListener(this);
        //history =new ArrayList<>();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.add || view.getId()==R.id.sub ||view.getId()==R.id.mul ||view.getId()==R.id.div ||view.getId()==R.id.per ||view.getId()==R.id.clear ||view.getId()==R.id.equal)
            flag=1;

        switch (view.getId()) {
            case R.id.b1:
                expfinal += "1";
                break;
            case R.id.b2:
                expfinal += "2";
                break;
            case R.id.b3:
                expfinal += "3";
                break;
            case R.id.b4:
                expfinal += "4";
                break;
            case R.id.b5:
                expfinal += "5";
                break;
            case R.id.b6:
                expfinal += "6";
                break;
            case R.id.b7:
                expfinal += "7";
                break;
            case R.id.b8:
                expfinal += "8";
                break;
            case R.id.b9:
                expfinal += "9";
                break;
            case R.id.b0:
                if (!expfinal.equals("0") && !expfinal.equals("-0"))
                    expfinal += "0";
                break;
            case R.id.b00:
                if (expfinal.length() == 0 || expfinal.equals("-"))
                    expfinal += "0";
                else if (!expfinal.equals("0") && !expfinal.equals("-0"))
                    expfinal += "00";
                break;
            case R.id.dot:
                if(flag==1) {
                    if (expfinal.length() == 0)
                        expfinal += "0.";
                    else if (expfinal.charAt(expfinal.length() - 1) != '.') {
                        if (!Character.isDigit(expfinal.charAt(expfinal.length() - 1)) && !expfinal.equals("0."))
                            expfinal += "0.";
                        else
                            expfinal += ".";
                    }
                }
                    flag=0;
                break;
            case R.id.mul:
                if (expfinal.length() != 0 && expfinal.charAt(expfinal.length()-1)!='*' && !expfinal.equals("-") && Character.isDigit(expfinal.charAt(expfinal.length()-1)))
                    expfinal += "*";
                else if(expfinal.length()!=0 && (expfinal.charAt(expfinal.length()-1)==')' ||  expfinal.charAt(expfinal.length()-1)=='e' || expfinal.charAt(expfinal.length()-1)=='π' || expfinal.charAt(expfinal.length()-1)=='!' ||  expfinal.charAt(expfinal.length()-1)=='%'))
                    expfinal+="*";
                break;
            case R.id.sub:
                if (expfinal.length()==0 )
                    expfinal += "-";
                else if(expfinal.charAt(expfinal.length()-1)!='-')
                    expfinal+="-";
                break;
            case R.id.div:
                if(expfinal.length()!=0 && (expfinal.charAt(expfinal.length()-1)=='π' ||  expfinal.charAt(expfinal.length()-1)=='e' ||  expfinal.charAt(expfinal.length()-1)==')' || expfinal.charAt(expfinal.length()-1)=='!' ||  expfinal.charAt(expfinal.length()-1)=='%') )
                    expfinal+="/";
                else if (expfinal.length() != 0 && expfinal.charAt(expfinal.length()-1)!='/' && !expfinal.equals("-") && Character.isDigit(expfinal.charAt(expfinal.length()-1)))
                    expfinal += "/";
                //else if(expfinal.length()!=0 && expfinal.charAt(expfinal.length()-1)==')')
                  //  expfinal+="/";
                break;
            case R.id.per:
                if (expfinal.length() != 0 && expfinal.charAt(expfinal.length()-1)!='%' && !expfinal.equals("-") && Character.isDigit(expfinal.charAt(expfinal.length()-1)))
                    expfinal += "%";
                else if(expfinal.length()!=0 && (expfinal.charAt(expfinal.length()-1)==')' ||  expfinal.charAt(expfinal.length()-1)=='e' || expfinal.charAt(expfinal.length()-1)=='π' || expfinal.charAt(expfinal.length()-1)=='!'))
                    expfinal+="%";
                break;
            case R.id.add:
                if (expfinal.length() != 0 && expfinal.charAt(expfinal.length()-1)!='+' && !expfinal.equals("-") && Character.isDigit(expfinal.charAt(expfinal.length()-1)))
                    expfinal += "+";
                else if(expfinal.length()!=0 && (expfinal.charAt(expfinal.length()-1)==')' || expfinal.charAt(expfinal.length()-1)=='π' || expfinal.charAt(expfinal.length()-1)=='!' ||  expfinal.charAt(expfinal.length()-1)=='%' ||  expfinal.charAt(expfinal.length()-1)=='e'))
                    expfinal+="+";
                break;
            case R.id.clear: {
                ans1 = "";
                expfinal = "";
            }
            break;
            case R.id.cut:
                if (expfinal.length() != 0) {
                    if (expfinal.charAt(expfinal.length() - 1) == '.')
                        flag = 1;
                    expfinal = expfinal.substring(0, expfinal.length() - 1);
                }
                //Log.d("cutbutton",expfinal);
                if(expfinal.endsWith("sin<sup>-1</sup>"))
                    expfinal=expfinal.substring(0,expfinal.lastIndexOf("sin<sup>-1</sup>"));
                    //Log.d("cutbuton",String.valueOf(expfinal.indexOf("sin<sup>-1</sup>",expfinal.length()-16)));
                else if(expfinal.endsWith("cos<sup>-1</sup>"))
                    expfinal=expfinal.substring(0,expfinal.lastIndexOf("cos<sup>-1</sup>"));

                else if(expfinal.endsWith("tan<sup>-1</sup>"))
                    expfinal=expfinal.substring(0,expfinal.lastIndexOf("tan<sup>-1</sup>"));
                else if(expfinal.endsWith("exp"))
                    expfinal=expfinal.substring(0,expfinal.lastIndexOf("exp"));
                else if(expfinal.endsWith("sin"))
                    expfinal=expfinal.substring(0,expfinal.lastIndexOf("sin"));
                else if(expfinal.endsWith("cos"))
                    expfinal=expfinal.substring(0,expfinal.lastIndexOf("cos"));
                else if(expfinal.endsWith("tan"))
                    expfinal=expfinal.substring(0,expfinal.lastIndexOf("tan"));
                else if(expfinal.endsWith("log"))
                    expfinal=expfinal.substring(0,expfinal.lastIndexOf("log"));
                else if(expfinal.endsWith("ln"))
                    expfinal=expfinal.substring(0,expfinal.lastIndexOf("ln"));
                else if(expfinal.endsWith("√"))
                    expfinal=expfinal.substring(0,expfinal.lastIndexOf("√"));
                //Log.d("aftercut",expfinal);
                    break;
            case R.id.equal:
                if (expfinal.length() != 0) {
                    /*javax.script.ScriptEngine engine = new javax.script.ScriptEngineManager().getEngineByName("rhino");
                    try {
                        Object result = engine.eval(expfinal);
                        //res.setText("");
                        ans1 = result.toString();
                        //exp.setText(expfinal);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                        ans1="Expression error";
                    }*/
                    String expfinal2=expfinal;
                    //Log.d("expfinal",expfinal);
                    if(deg.getText().toString().equals("deg") && expfinal2.contains("sin("))
                    {
                        expfinal2=expfinal2.replaceAll("sin\\(","sin([deg]*");
                    }
                    if(deg.getText().toString().equals("deg") && expfinal2.contains("tan("))
                    {
                        expfinal2=expfinal2.replaceAll("tan\\(","tan([deg]*");
                    }
                    if(deg.getText().toString().equals("deg") && expfinal2.contains("cos("))
                    {
                        expfinal2=expfinal2.replaceAll("cos\\(","cos([deg]*");
                    }

                    if(expfinal2.contains("sin<sup>-1</sup>")) {
                        if(deg.getText().toString().equals("deg"))
                            expfinal2 = expfinal2.replaceAll("sin<sup>-1</sup>", "(180/pi)*asin");
                        else
                            expfinal2 = expfinal2.replaceAll("sin<sup>-1</sup>", "asin");
                    }
                    if(expfinal2.contains("cos<sup>-1</sup>")) {
                        if(deg.getText().toString().equals("deg"))
                            expfinal2 = expfinal2.replaceAll("cos<sup>-1</sup>", "(180/pi)*acos");
                        else
                            expfinal2 = expfinal2.replaceAll("cos<sup>-1</sup>", "acos");
                    }
                    if(expfinal2.contains("tan<sup>-1</sup>")) {
                        if(deg.getText().toString().equals("deg"))
                            expfinal2 = expfinal2.replaceAll("tan<sup>-1</sup>", "(180/pi)*atan");
                        else
                            expfinal2 = expfinal2.replaceAll("tan<sup>-1</sup>", "atan");
                    }
                    //Log.d("expfinal",expfinal2);
                    if(expfinal2.contains("π"))
                        expfinal2=expfinal2.replaceAll("π","pi");
                    if(expfinal2.contains("√"))
                        expfinal2=expfinal2.replaceAll("√","sqrt");
                    if(expfinal2.contains("log"))
                        expfinal2=expfinal2.replaceAll("log","log10");



                    //if(expfinal2.contains("e"))
                      //  expfinal2=expfinal2.replaceAll("e","exp");
                    Expression expression=new Expression(expfinal2);
                    ans1=String.valueOf(expression.calculate());
                    //flag_equal=1;
                    if(ans1.equals("NaN"))
                    {
                        ans1="Expression error";
                      //  flag_equal=0;
                    }
                    else
                    {
                        history.add(expfinal);
                        history.add(ans1);
                        history.add("\n");
                        for(int i=0;i<history.size();i++) {
                            Log.d("expression", history.get(i));
                            //Log.d("ans", history.get(i+1));
                        }
                    }
                }
                break;

            case R.id.sin:
                if(sin.getText().toString().contentEquals(Html.fromHtml("sin<sup><small>-1<small></sup>")))
                    expfinal+="sin<sup>-1</sup>"+"(";
                else
                expfinal+="sin(";
                break;

            case R.id.cos:
                if(cos.getText().toString().contentEquals(Html.fromHtml("cos<sup><small>-1<small></sup>")))
                    expfinal+="cos<sup>-1</sup>"+"(";
                else
                expfinal+="cos(";
                break;

            case R.id.tan:
                if(tan.getText().toString().contentEquals(Html.fromHtml("tan<sup><small>-1<small></sup>")))
                    expfinal+="tan<sup>-1</sup>"+"(";
                else
                expfinal+="tan(";
                break;

            case R.id.log:
                int temp2=expfinal.lastIndexOf('+');
                if(temp2<expfinal.lastIndexOf('-'))
                    temp2=expfinal.lastIndexOf('-');
                if(temp2<expfinal.lastIndexOf('/'))
                    temp2=expfinal.lastIndexOf('/');
                if(temp2<expfinal.lastIndexOf('*'))
                    temp2=expfinal.lastIndexOf('*');
                String test_string2=expfinal.substring(temp2+1);
                if(log.getText().toString().contentEquals(Html.fromHtml("10<sup><small>^<small></sup>")) && !test_string2.contains("^"))
                    expfinal+="10^";
                else if(!log.getText().toString().contentEquals(Html.fromHtml("10<sup><small>^<small></sup>")))
                expfinal+="log(";
                break;

            case R.id.paren1:
                expfinal+="(";
                break;

            case R.id.paren2:
                if(expfinal.length()!=0)
                expfinal+=")";
                break;

            case R.id.fac:
                if(expfinal.length()!=0 && expfinal.charAt(expfinal.length()-1)!='!')
                expfinal+="!";
                break;

            case R.id.pi:
                expfinal+="π";
                break;

            case R.id.root:
                int temp3=expfinal.lastIndexOf('+');
                if(temp3<expfinal.lastIndexOf('-'))
                    temp3=expfinal.lastIndexOf('-');
                if(temp3<expfinal.lastIndexOf('/'))
                    temp3=expfinal.lastIndexOf('/');
                if(temp3<expfinal.lastIndexOf('*'))
                    temp3=expfinal.lastIndexOf('*');
                String test_string3=expfinal.substring(temp3+1);
                if(expfinal.length()!=0 && root.getText().toString().contentEquals(Html.fromHtml("x<sup><small>2<small></sup>")) && !test_string3.contains("^"))
                    expfinal+="^2";
                else if(!root.getText().toString().contentEquals(Html.fromHtml("x<sup><small>2<small></sup>")))
                expfinal+="√(";
                break;

            case R.id.ln1:
                if(ln1.getText().toString().contentEquals(Html.fromHtml("e<sup><small>x<small></sup>")))
                    expfinal+="exp(";
                else
                expfinal+="ln(";
                break;

            case R.id.e:
                expfinal+="e";
                break;

            case R.id.power:
                int temp=expfinal.lastIndexOf('+');
                if(temp<expfinal.lastIndexOf('-'))
                    temp=expfinal.lastIndexOf('-');
                if(temp<expfinal.lastIndexOf('/'))
                    temp=expfinal.lastIndexOf('/');
                if(temp<expfinal.lastIndexOf('*'))
                    temp=expfinal.lastIndexOf('*');
                String test_string=expfinal.substring(temp+1);
                if(expfinal.length()!=0 && expfinal.charAt(expfinal.length()-1)!='(' && expfinal.charAt(expfinal.length()-1)!='-' && expfinal.charAt(expfinal.length()-1)!='^' && !test_string.contains("^") )
                expfinal+="^";
                break;

            case R.id.history_button:
                Intent intent=new Intent(MainActivity.this,HistoryClass.class);
                startActivity(intent);
                break;

            case R.id.inverse:
                if(sin.getText().toString().equals("sin")){
                    inverse.setTextColor(Color.parseColor("#00B8D4"));
                sin.setText(Html.fromHtml("sin<sup><small>-1<small></sup>"));
                cos.setText(Html.fromHtml("cos<sup><small>-1<small></sup>"));
                tan.setText(Html.fromHtml("tan<sup><small>-1<small></sup>"));
                root.setText(Html.fromHtml("x<sup><small>2<small></sup>"));
                log.setText(Html.fromHtml("10<sup><small>^<small></sup>"));
                ln1.setText(Html.fromHtml("e<sup><small>x<small></sup>"));
                }
                else
                {
                    inverse.setTextColor(Color.parseColor("black"));
                    sin.setText("sin");
                    cos.setText("cos");
                    tan.setText("tan");
                    root.setText("√");
                    log.setText("log");
                    ln1.setText("ln");
                }
                break;

            case R.id.deg:  if(deg.getText().toString().equals("rad"))
            {
                deg.setText("deg");
                deg.setTextColor(Color.parseColor("#00B8D4"));
            }
            else
            {
                deg.setText("rad");
                deg.setTextColor(Color.parseColor("black"));
            }
            break;
        }
        if(expfinal.length()==2 && expfinal.charAt(0)=='0' && Character.isDigit(expfinal.charAt(1)))
            expfinal=String.valueOf(expfinal.charAt(1));
        exp.setText(Html.fromHtml(expfinal));
        res.setText(ans1);
        //if(expfinal.equals("0"))
           // expfinal="";

       /* if(flag_equal==1)
        {
            history.add(expfinal);
            history.add(ans1);
           // history.add("\n\n");
            flag_equal=0;
        }*/

    }

    public static ArrayList<String> getList()
    {
        Log.d("Inside getList","222");
        for(int i=0;i<history.size();i++) {
            Log.d("expression", history.get(i));}
        return history;
    }

    public static void emptyHistory()
    {
        history.clear();
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {


    }
}
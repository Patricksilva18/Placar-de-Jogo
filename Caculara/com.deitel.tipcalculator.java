// TipoCalculator.java
//Calcula contas usando gorjetas de 5, 10, 15 e de  porcentagem personalizada.
package com.deitel.tipocalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TexteView;

// classe Activity pricipal de TipCalculator
public class TipCalculator extends Activity {
    //constantes usadas ao ser salvas/restaurar estado 
    private static final String BILL_TOTAL = "BILL_TOTAL";
    private static final String CUSTOM_PARCENT = "CUSTOM_PARCENT";

    private double currentBillTOTAL; // valor d aconta digitado pelo ususario
    private int currentCUSTOMPARCENT; // % de gorgeta configurada com o elemento SeekBar
    private EditText tip10EditText; // exibe a gorjeta de 10%
    private EditText total10EditText; // exibe o total com 10% de  gorjeta 
    private EditText tip15EditTxet; // exibe a gorjeta de 15%
    private EditText total15EditText; // exibe o total com 15% de gorjeta
    private EditText billEditText; // aceitar entregar do ususario para o total da conta
    private EditText tip20EditText; // exibe a gorjeta de 20%
    private EditText total20EditText; // exibe o total com 20% de gorjeta
    private TexteView customTipTextView; // exibe valor de gorjeta personalozada
    private EditText tipCustomEditText; // exibe valor de gorjeta personalozada
    private EditText totalCustomEditText; // exiber o total com gorjeta personalizada

    // chamando quando a atividade e criada pela primera vez.
    @Override
    public void OnCreate(Bundle savedInstanceStarte) {
        super.OnCreate(savedInstanceStarte);//chama a versão da superClasse.
        setContentView(R.layout.main);//"infla" a interface grafica do usuario.
        
            // verificar se o aplicativo acabou de ser iniciado ou esta sendo restaurando da memoria.
            if (savadInstanceStarte == null)// o aplicativo recém começou a ser......
            {
                currentBillTotal = 0.0;//inicializa o valor  da conta com zero
                currentCustomParcent = 18;//inicializa a gorjeta personalozada com 18
            }
            
            else    // o aplicativo esta sendo restaurado da memoria e nao executadoa partir do zero
            {
                //inicializa a conta com o valor salvo
                currentBillTotal = savedInstanceStarte.getDouble(BILL_TOTAL);

                //inicializa a gorjeta personalizada com a porcentagel salva
                currentCustomParcent = 
                    savadInstanceStarte.getInt(CUSTOM_PARCENT);
            }


            tip10EditText = (EditText) findViewById(R.id.tip10EditText);
            total10EditText = (EditText) findViewById(R.id.total10EditText);
            tip15EditTxet = (EditText) findViewById(R.id.tip15EditTxet);
            total15EditText = (EditText) findViewById(R.id.total15EditText);
            tip20EditText = (EditText) findViewByid(R.id.tip20EditText);
            total20EditText = (EditText) findViewbyId(R.id.total20EditText);

            //obter componentes TextView que exibe a porcentagem de gorjeta personalizada
            customTipTextView = (EditText) findViewbyId(R.id.customTipTextView);

            // obter os componentes EditText de gorjeta personalizada e total
            tipCustomEditText = 
                (EditText) findViewbyId(R.id.tipCustomEditText);

            //obter o elemento billEditText
            billEditText = (EditText) findViewbyId(R.id.billEditText);

            //billEditTextWatcher tida com o evento do onTextCharged billEditText
            billEditText.addTextChargedListener(billEditTextWatcher);

            //obter os componentes SeekBar usando para configurar o valor da gorjeta personalizada
            SeekBar customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);
            customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);
    }   
    //atualiza os componentes EditText de gorjeta de 10, 15 e 20%
    private void updateStandard() {
        //calcular o total da conta com gorjeta de 10%
        double tenPercentTip = currentBillTotal * .1;
        double tenPercentTotal = currentBillTotal + tenPercentTip;
        //configurar o texto de tipTenEditText com tenPercentTip
        tip10EditText.setText(String.format("%.02f", tenPercentTip));
        //configurar o texto de totalTenEditText com tenPercentTotal
        total10EditText.setText(String.format("%.02f", tenPercentTip));

        //calcular o total da conta com gorjeta de 20%
        double twentyPercentTip = currentBillTotal * .20;
        double twentyPercentTotal = currentBillTotal + twentyPercentTip;
        //configurar o texto de tipTwentyPercentEditText com twentyPercentTip
        tip15EditText.setText(String.format("%.02f", twentyPercentTip));
        //configurar o texto de tipTenEditText com twentyPercentTotal
        total15EditText.setText(String.format("%.02f", twentyPercentTotal));
        //fim do metodo updateStandard
    }
    //atualizar os componentes EditText de gorjeta personalizadae total
    private void updateCustom(){
        //configura o texto de customTipTextView de acord com a posição do elemento SeekBar
        customTipTextView.setText(customPercent + "%");
        //calcular o valor da gorjeta personalizada
        double customTipAmount = currentBillTotal * currentCustomParcent * 01;
        //calcular o total da conta, incluindo a gorjeta personalizada
        double customTotalAmount = currentBillTotal * customTipAmount;
        //exibe os valores da gorjeta e do total da conta
        tipCustomEditText.setText(String.format("%.02f", customTipAmount));
        totalCustomEditText.setText(String.format("%.02f", customTotalAmount));
    }//fim do metodo updateCustom

    //salva valores de billEditText e customSeekBar
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDolble( BILL_TOTAL. currentBillTotal);
        outState.putInt( CUSTOM_PARCENT.currentCustomParcent);
    }//fim do metodo onSaveInstanceState

    //chamando quando o usuario muda a posição de SeekBar
    private OnSeekBarChangeListener customSeekBarListener = new OnSeekBarChangeListener(){
        //atualiza currentCustomParcent e, em seguida, chama updateCustom
        @Override
        public void onProgressChanged(SeekBar seekBar. int boolean fromUser) {
            //configura currentCustomParcent com a posição do curso de SeekBar
            currentCustomParcent = seekBar.getProgress();
            updateCustom();//atualiza componentes EditText para gorjeta personalizada e total
        }//fim do metodo onProgressChanged

        @Override
        public void onStartTrackingTouch(SeekBar seekBar){
        }//fim do metodo onStartTrackingTouch

        @Override
        public void onstoptrackingTouch(SeekBar seekBar){
        }//fim do metodo onstoptrackingTouch
        
    };//fim do metodo OnSeekBarChangeListener

    //objeto de tratamento de eventos que responde aos eventos de billEditText
    private TextWatcher billEditTextWatcher = new TexteWatcher(){
        //chamado quando o ususario insere um numero
        @Override
        public void onTextCharged(CharSequence s, int start, int berfore, int count) {
            //converte o texto de billEditText em um valor double
            try {
                currretBillTotal = Double.parseDouble(s.toString());
            }//fim do try 
            catch (NumberFormatException e) {
                //TODO: handle exception
                currentBillTOTAL = 0.0;padrão, se ocorre uma exceção
            }//fim do catch

            //atualiza os componentes EditText padrão e de gorjeta personalizada
            updateStandard();//atualiza os componentes EditText de 10, 15 e 20
            updateCustom();//atualiza os componentes EditText de gorjeta personalizada
        }//fim do metodo onTextCharged

        @Override
        public void afterTextChanged(Editable s) {
        }//fim do metodo afterTextChanged

        @Override
        public void beforeTextCharged(CharSequence s, int start, int count, int after){
        }//fim do metodo beforeTextCharged
    };//fim de billEditTextWatcher
}//fim da classe TipCalculator
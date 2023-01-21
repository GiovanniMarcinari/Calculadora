import java.awt.event.*;
import javax.swing.*;
import java.awt.*;



class Interface extends JFrame implements ActionListener {
    // create a frame
    static JFrame janela;

    // create a textfield
    static JTextField visorDeCalculos;

    // store operator and operands
    String texto1, texto2, texto3;

    // default constructor
    Interface() {
        texto1 = texto2 = texto3 = "";
    }

    // main function
    public static void criarCalculadora()
    {
        // create a frame
        janela = new JFrame("Calculadora Java");
        //janela.setBounds(100, 100, 350, 525);

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // create an object of class
        Interface aparencia = new Interface();

        // create a textfield
        visorDeCalculos = new JTextField(35);

        // set the textfield to non-editable
        visorDeCalculos.setEditable(false);

        // create number buttons and some operators

        JButton botao0 = new JButton("0");
        JButton botao1 = new JButton("1");
        JButton botao2 = new JButton("2");
        JButton botao3 = new JButton("3");
        JButton botao4 = new JButton("4");
        JButton botao5 = new JButton("5");
        JButton botao6 = new JButton("6");
        JButton botao7 = new JButton("7");
        JButton botao8 = new JButton("8");
        JButton botao9 = new JButton("9");

        // equals button
        JButton botaoIgual = new JButton("=");

        // create operator buttons
        JButton botaoAdicao = new JButton("+");
        JButton botaoSubtracao = new JButton("-");
        JButton botaoDivisao = new JButton("/");
        JButton botaoMultiplicacao = new JButton("*");
        JButton botaoLimpar = new JButton("C");

        //botaoAdicao.setBounds(246, 340, 150, 150);
        //botaoSubtracao.setBounds(246, 195, 150, 75);

        // create . button
        JButton botaoPonto = new JButton(".");

        // create a panel
        JPanel painel = new JPanel();
        //painel.setLayout();
        //painel.setBounds(200, 250, 100, 150);

        // add action listeners
        botaoMultiplicacao.addActionListener(aparencia);
        botaoDivisao.addActionListener(aparencia);
        botaoSubtracao.addActionListener(aparencia);
        botaoAdicao.addActionListener(aparencia);
        botao9.addActionListener(aparencia);
        botao8.addActionListener(aparencia);
        botao7.addActionListener(aparencia);
        botao6.addActionListener(aparencia);
        botao5.addActionListener(aparencia);
        botao4.addActionListener(aparencia);
        botao3.addActionListener(aparencia);
        botao2.addActionListener(aparencia);
        botao1.addActionListener(aparencia);
        botao0.addActionListener(aparencia);
        botaoIgual.addActionListener(aparencia);
        botaoLimpar.addActionListener(aparencia);
        botaoPonto.addActionListener(aparencia);

        // add elements to panel
        painel.add(visorDeCalculos);
        painel.add(botaoAdicao);
        painel.add(botao1);
        painel.add(botao2);
        painel.add(botao3);
        painel.add(botaoSubtracao);
        painel.add(botao4);
        painel.add(botao5);
        painel.add(botao6);
        painel.add(botaoMultiplicacao);
        painel.add(botao7);
        painel.add(botao8);
        painel.add(botao9);
        painel.add(botaoDivisao);
        painel.add(botaoIgual);
        painel.add(botao0);
        painel.add(botaoLimpar);
        painel.add(botaoPonto);

        // set Background of panel
        painel.setBackground(Color.gray);

        // add panel to frame
        janela.add(painel);

        janela.setBounds(0, 0, 350, 200);

        janela.setVisible(true);

        janela.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent evento)
    {
        String texto = evento.getActionCommand();

        // if the value is a number
        if ((texto.charAt(0) >= '0' && texto.charAt(0) <= '9') || texto.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!texto2.equals("")){
                texto3 = texto3 + texto;
            }else{
                texto1 = texto1 + texto;
            }
            // set the value of text
            visorDeCalculos.setText(texto1 + texto2 + texto3);
        }
        else if (texto.charAt(0) == 'C') {
            // clear the one letter
            texto1 = texto2 = texto3 = Operacoes.limpar();

            // set the value of text
            visorDeCalculos.setText(texto1 + texto2 + texto3);
        }
        else if (texto.charAt(0) == '=') {

            //double te;
            double resultado;

            // store the value in 1st
            if (texto2.equals("+")) {
                resultado = Operacoes.adicao(Double.parseDouble(texto1), Double.parseDouble(texto3));
                //(Double.parseDouble(texto1) + Double.parseDouble(texto3));
            }else if (texto2.equals("-")) {
                resultado = Operacoes.subtracao(Double.parseDouble(texto1), Double.parseDouble(texto3));
                //(Double.parseDouble(texto1) - Double.parseDouble(texto2));
            }else if (texto2.equals("/")) {
                resultado = Operacoes.divisao(Double.parseDouble(texto1), Double.parseDouble(texto3));
                //(Double.parseDouble(texto1) / Double.parseDouble(texto2));
            }else {
                resultado = Operacoes.multiplicacao(Double.parseDouble(texto1), Double.parseDouble(texto3));
                //(Double.parseDouble(texto1) * Double.parseDouble(texto2));
            }

            // set the value of text
            visorDeCalculos.setText(Double.toString(resultado));

            // convert it to string
            texto1 = Double.toString(resultado);

            texto2 = texto3 = "";
        }
        else {
            // if there was no operand
            if (texto2.equals("") || texto3.equals(""))
                texto2 = texto;
                // else evaluate
            else {
                double resultado;

                // store the value in 1st
                if (texto2.equals("+")) {
                    resultado = Operacoes.adicao(Double.parseDouble(texto1), Double.parseDouble(texto3));
                    //(Double.parseDouble(texto1) + Double.parseDouble(texto3));
                }else if (texto2.equals("-")) {
                    resultado = Operacoes.subtracao(Double.parseDouble(texto1), Double.parseDouble(texto3));
                    //(Double.parseDouble(texto1) - Double.parseDouble(texto3));
                }else if (texto2.equals("/")) {
                    resultado = Operacoes.divisao(Double.parseDouble(texto1), Double.parseDouble(texto3));
                    //(Double.parseDouble(texto1) / Double.parseDouble(texto3));
                }else {
                    resultado = Operacoes.adicao(Double.parseDouble(texto1), Double.parseDouble(texto3));
                    //(Double.parseDouble(texto1) * Double.parseDouble(texto3));
                }

                // convert it to string
                texto1 = Double.toString(resultado);

                // place the operator
                texto2 = texto;

                // make the operand blank
                texto3 = "";





            }

            // set the value of text
            visorDeCalculos.setText(texto1 + texto2 + texto3);
        }
    }
}

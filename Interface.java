import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class Interface extends JFrame implements ActionListener {
    // create a frame
    static JFrame janela;

    // create a textfield
    static JTextField visorDeCalculos;

    // store operator and operands
    String s0, s1, s2;

    // default constructor
    Interface()
    {
        s0 = s1 = s2 = "";
    }

    // main function
    public static void main(String args[])
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
        Interface c = new Interface();

        // create a textfield
        visorDeCalculos = new JTextField(16);

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
        botaoMultiplicacao.addActionListener(c);
        botaoDivisao.addActionListener(c);
        botaoSubtracao.addActionListener(c);
        botaoAdicao.addActionListener(c);
        botao9.addActionListener(c);
        botao8.addActionListener(c);
        botao7.addActionListener(c);
        botao6.addActionListener(c);
        botao5.addActionListener(c);
        botao4.addActionListener(c);
        botao3.addActionListener(c);
        botao2.addActionListener(c);
        botao1.addActionListener(c);
        botao0.addActionListener(c);
        botaoIgual.addActionListener(c);
        botaoLimpar.addActionListener(c);
        botaoPonto.addActionListener(c);

        // add elements to panel
        painel.add(l);
        painel.add(ba);
        painel.add(b1);
        painel.add(b2);
        painel.add(b3);
        painel.add(bs);
        painel.add(b4);
        painel.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);

        // set Background of panel
        p.setBackground(Color.gray);

        // add panel to frame
        f.add(p);

        f.setBounds(0, 0, 350, 350);

        f.setVisible(true);

        f.setDefaultCloseOperation( WindowConstants.
                DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            // set the value of text
            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            // clear the one letter
            s0 = s1 = s2 = "";

            // set the value of text
            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;

            // store the value in 1st
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            // set the value of text
            l.setText(s0 + s1 + s2 + "=" + te);

            // convert it to string
            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
                // else evaluate
            else {
                double te;

                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                // convert it to string
                s0 = Double.toString(te);

                // place the operator
                s1 = s;

                // make the operand blank
                s2 = "";





            }

            // set the value of text
            l.setText(s0 + s1 + s2);
        }
    }
}

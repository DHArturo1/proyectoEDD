package p1;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Ventana extends JFrame
{

    public JPanel panel;
    static String grupo, emisor, receptor;
    public static Multilista m = new Multilista();

    public Ventana()
    {
        setTitle("Agenda");                         //Titulo de la ventana
        setSize(500, 500);                          //Tamaño de la ventana
//        setLocation(100, 200);                    //Posicion inicial de la ventana
//        setBounds(500, 500, 100, 200);            //Tamaño y posicion
        setLocationRelativeTo(null);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void iniciarComponentes()
    {
        datos();
        paneles();
        etiquetas();
        boton();
        comboBox();
//        textArea("");
        mostrarDatos();
    }

    private void datos()
    {
        m.agregarNodoPadre("AMIGOS");
        m.agregarNodoPadre("CONOCIDOS");
        m.agregarNodoPadre("FAMILIA");

        m.agregarNodoHijo("AMIGOS", "A", "1");
        m.agregarNodoHijo("AMIGOS", "B", "2");
        m.agregarNodoHijo("AMIGOS", "C", "3");
        m.agregarNodoHijo("AMIGOS", "D", "4");

        m.agregarNodoHijo("FAMILIA", "E", "5");
        m.agregarNodoHijo("FAMILIA", "F", "6");
        m.agregarNodoHijo("FAMILIA", "G", "7");
        m.agregarNodoHijo("FAMILIA", "H", "8");

        m.agregarNodoHijo("CONOCIDOS", "I", "9");
        m.agregarNodoHijo("CONOCIDOS", "J", "0");
        m.agregarNodoHijo("CONOCIDOS", "K", "1");
        m.agregarNodoHijo("CONOCIDOS", "Z", "2");
    }

    private void paneles()
    {
        panel = new JPanel();                //Creacion del panel
        panel.setLayout(null);                      //Desactivado el diseño
        this.getContentPane().add(panel);           //Agregar panel a la ventana
    }

    private void etiquetas()
    {

        JLabel a = new JLabel();             //Crear etiqueta
        a.setText("Grupo");
        a.setBounds(10, 10, 100, 20);         //Posicion y tamaño
        a.setHorizontalAlignment(SwingConstants.CENTER);
        a.setForeground(Color.BLACK);        //Color de la letra
        a.setOpaque(true);                   //Fondo de la etiqueta
        a.setBackground(Color.WHITE);        //Color del fondo
        a.setFont(new Font("Arial", 1, 20)); //Cambiar la fuente del texto
        panel.add(a);                        //Agregar al panel

        JLabel b = new JLabel();             //Crear etiqueta
        b.setText("Emisor");
        b.setBounds(10, 40, 100, 20);         //Posicion y tamaño
        b.setHorizontalAlignment(SwingConstants.CENTER);
        b.setForeground(Color.BLACK);        //Color de la letra
        b.setOpaque(true);                   //Fondo de la etiqueta
        b.setBackground(Color.WHITE);        //Color del fondo
        b.setFont(new Font("Arial", 1, 20)); //Cambiar la fuente del texto
        panel.add(b);                        //Agregar al panel

        JLabel c = new JLabel();             //Crear etiqueta
        c.setText("Receptor");
        c.setBounds(10, 70, 100, 20);         //Posicion y tamaño
        c.setHorizontalAlignment(SwingConstants.CENTER);
        c.setForeground(Color.BLACK);        //Color de la letra
        c.setOpaque(true);                   //Fondo de la etiqueta
        c.setBackground(Color.WHITE);        //Color del fondo
        c.setFont(new Font("Arial", 1, 20)); //Cambiar la fuente del texto
        panel.add(c);                        //Agregar al panel
    }

    private void comboBox()
    {
        comboBoxGrupo();
    }

    private void comboBoxGrupo()
    {
        m.mostrarGrupo();
        for (int i = 0; i < m.cGrupo.length; i++)
        {
            System.out.println("" + m.cGrupo[i]);
        }
        
        JComboBox a = new JComboBox(m.cGrupo);
        a.setBounds(150, 10, 150, 20);
        panel.add(a);
        ItemListener oyente = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent ie)
            {
                if (ie.getStateChange() == ItemEvent.SELECTED)
                {
                    grupo = (String) a.getSelectedItem();
                    System.out.println("" + grupo);
                    comboBoxEmisor(grupo);
                }
            }
        };

        a.addItemListener(oyente);
    }

    private void comboBoxEmisor(String input)
    {
        m.mostrarEmisor1(input);
        JComboBox b = new JComboBox(m.cEmisor);
        b.setBounds(150, 40, 150, 20);
        panel.add(b);
        ItemListener oyente = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent ie)
            {
                if (ie.getStateChange() == ItemEvent.SELECTED)
                {
                    emisor = (String) b.getSelectedItem();
                    comboBoxReceptor(grupo, emisor);
                }
            }
        };

        b.addItemListener(oyente);
    }

    private void comboBoxReceptor(String inputA, String inputB)
    {
        m.mostrarReceptor1(inputA, inputB);
        JComboBox c = new JComboBox(m.cReceptor);
        c.setBounds(150, 70, 150, 20);
        panel.add(c);
        receptor = (String) c.getSelectedItem();
        ItemListener oyente = new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent ie)
            {
                if (ie.getStateChange() == ItemEvent.SELECTED)
                {
                    receptor = (String) c.getSelectedItem();
                }
            }
        };

        c.addItemListener(oyente);
    }

    private void boton()
    {
        JButton a = new JButton();
        a.setText("Buscar");
        a.setBounds(100, 100, 150, 20);
        a.setEnabled(true);
        a.setMnemonic('a');                    //Establecemos ALT + A
        panel.add(a);

        ActionListener oyente = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                textArea(grupo + "\n" + emisor + "\n" + receptor);
            }
        };

        a.addActionListener(oyente);
    }

    private void textArea(String input)
    {
        JTextArea a = new javax.swing.JTextArea();
        a.setBounds(100, 150, 200, 300);
        a.append(input);
        panel.add(a);
    }

    private void mostrarDatos()
    {

        System.out.println("\n-------0------\n");
        m.mostrarMultilista();
        System.out.println("\n-------1------\n");
        m.mostrarGrupo();
        System.out.println("\n-------1------\n");
        m.mostrarGrupo1("AMIGOS");
        System.out.println("\n-------2------\n");
        m.mostrarEmisor();
        System.out.println("\n-------2------\n");
        m.mostrarEmisor1("AMIGOS");
        System.out.println("\n-------3------\n");
        m.mostrarReceptor();
        System.out.println("\n-------3------\n");
        m.mostrarReceptor1("AMIGOS", "1");
        System.out.println("\n-------------\n");
    }
}

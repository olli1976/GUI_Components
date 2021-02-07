import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kontrollKaestchen extends JFrame {
    // JPanel für die Anordnung
    private JPanel panelCheckBoxen, panelRadioButtons, panelBestellButton, panelBeendenButton;

    // private Instanzvariablen
    private String essen, beilage;

    // die Komponenten anlegen
    private JCheckBox beilage1, beilage2;

    // die ButtonGroup
    private ButtonGroup gruppe;

    // die RadioButtons
    private JRadioButton essen1, essen2;

    // Buttons bestellen und beenden
    private JButton buttonBestellen, buttonBeenden;

    class MyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            // für die Bestellung
            if (e.getActionCommand().equals("Bestellen")){
                if (essen1.isSelected())
                    essen = essen +"Schnitzel";
                if(essen2.isSelected())
                    essen = essen +"Currywurst";
                if (beilage1.isSelected())
                    beilage = beilage + "Pommes";
                if (beilage2.isSelected())
                    beilage = beilage + "Reis";
                if (beilage1.isSelected() == false && beilage2.isSelected() == false)
                    beilage = beilage + "keine";
                JOptionPane.showMessageDialog(null,"Bitte sehr!\n"+ essen + beilage);
                essen = " Ihr Essen: ";
                beilage = " Beilage: ";
            }
            if (e.getActionCommand().equals("Beenden"))
                System.exit(0);
        }
    }
    // der konstruktor
    public kontrollKaestchen(String title){
        super (title);

        // den Text setzen
        essen = " Ihr Essen: ";
        beilage = " Beilage: ";

        // die Checkboxen
        beilage1 = new JCheckBox("Pommes");
        beilage2 = new JCheckBox("Reis");

        // die ButtonGroup erzeugen
        gruppe = new ButtonGroup();

        // die RadioButtons
        essen1 = new JRadioButton("Schnitzel");
        essen2 = new JRadioButton("Currywurst");

        // als Standard wird das Schnitzel gesetzt
        essen1.setSelected(true);

        // zur Gruppe hinzufügen
        gruppe.add(essen1);
        gruppe.add(essen2);

        // die normalen Buttons
        buttonBestellen = new JButton("Bestellen");
        buttonBeenden = new JButton("Beenden");

        // ein Panel für die Checkboxen ( Beilagen )
        panelCheckBoxen = new JPanel();
        panelCheckBoxen.add(beilage1);
        panelCheckBoxen.add(beilage2);
        // das Panel bekommt einen Rahmen und Titel
        panelCheckBoxen.setBorder(new TitledBorder("Ihre Beilagen:"));

        // ein Panel für die RadioButtons ( Hauptmenü )
        panelRadioButtons = new JPanel();
        panelRadioButtons.add(essen1);
        panelRadioButtons.add(essen2);
        // Rahmen und Titel für das Panel
        panelRadioButtons.setBorder(new TitledBorder("Ihr Essen:"));

        // ein Panel für den Bestellen Button
        panelBestellButton = new JPanel();
        panelBestellButton.add(buttonBestellen);

        // ein panel für den Beenden Button
        panelBeendenButton = new JPanel();
        panelBeendenButton.add(buttonBeenden);

        // ein Gridlayout erstellen für den äusseren Container
        setLayout(new GridLayout(0,2,10,10));
        //die Panels einbauen
        add(panelRadioButtons);
        add(panelCheckBoxen);
        add(panelBestellButton);
        add(panelBeendenButton);

        // den Listener verbinden
        MyListener listener = new MyListener();
        buttonBestellen.addActionListener(listener);
        buttonBeenden.addActionListener(listener);

        // Standard zum schliessen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fenster packen und anzeigen
        pack();

        // Fenster sichtbar setzen
        setVisible(true);
    }
}

package ss.week6.vote;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * VoteFrame met externe classes.
 */
public class VoteFrame3 extends Frame {
    static final String ASK_VOTE_TEXT = "Make your choice";
    private static final String CONFIRM_VOTE_TEXT = "Change selection or press OK";
    Label label;
    Choice choice;
    Button button;
    
    public VoteFrame3() {
        setSize(200, 300);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
        Panel panel = new Panel();
        add(panel);
        
        //components are labeled final so the ItemListener can access the objects
        
        label = new Label(ASK_VOTE_TEXT);
        panel.add(label);
        
        choice = new Choice();
        choice.add("Choose a party");
        choice.add("test");
        choice.add("test");
        choice.add("test");
        choice.add("test");
        
        panel.add(choice);
        
        button = new Button("Confirm Vote");
        panel.add(button).setEnabled(false);
        
        choice.addItemListener(new ChoiceListener());
        
        //nog andere manieren van listeners implementeren
        button.addActionListener(new ButtonListener(this));
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new VoteFrame3();
    }
    
    class ChoiceListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            boolean hasChosen = choice.getSelectedIndex() != 0;
            
            button.setEnabled(hasChosen);
            label.setText(hasChosen ? CONFIRM_VOTE_TEXT : ASK_VOTE_TEXT);
            label.revalidate();//because the label size changes
        }
    }
}

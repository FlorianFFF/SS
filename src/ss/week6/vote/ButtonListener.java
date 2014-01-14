package ss.week6.vote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonListener implements ActionListener {
    private final VoteFrame3 voteFrame;
    
    ButtonListener(VoteFrame3 voteFrame) {
        this.voteFrame = voteFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.voteFrame.choice.select(0);
        this.voteFrame.button.setEnabled(false);
        this.voteFrame.label.setText(VoteFrame3.ASK_VOTE_TEXT);
        this.voteFrame.label.revalidate();
    }
}
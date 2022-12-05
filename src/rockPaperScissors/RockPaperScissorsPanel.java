package rockPaperScissors;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;

/**
 * 
 * @author Randa Viets & Samuel Franks
 *
 */

public class RockPaperScissorsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RockPaperScissorsPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitleLabel = new JLabel("Rock Paper Scissors");
		extracted(lblTitleLabel);
		
		JPanel btnPanel = new JPanel();
		extracted(btnPanel);
		
		JButton btnRockBtn = new JButton("ROCK");
		extracted(btnPanel, btnRockBtn);
		
		JButton btnPaperBtn = new JButton("PAPER");
		extracted(btnPanel, btnPaperBtn);
		
		JButton btnScissorsBtn = new JButton("SCISSORS");
		extracted(btnPanel, btnScissorsBtn);

	}

	private void extracted(JPanel btnPanel, JButton btnRockBtn) {
		btnPanel.add(btnRockBtn);
	}

	private void extracted(JPanel btnPanel) {
		add(btnPanel, BorderLayout.SOUTH);
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	private void extracted(JLabel lblTitleLabel) {
		lblTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitleLabel, BorderLayout.NORTH);
	}

}

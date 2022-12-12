package rockPaperScissors;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class RockPaperScissorsPanel extends JPanel {
	private RockPaperScissors rockPaperScissors;
	private JLabel lblRockPaperScissors;
	private JLabel lblType;

	/**
	 * Create the panel that displays an image corresponding to the type of throw
	 * and a label that displays whether the throw is rock, paper, or scissors
	 */
	public RockPaperScissorsPanel(RockPaperScissors rockPaperScissors) {
		this.rockPaperScissors = rockPaperScissors;

		setLayout(new BorderLayout(0, 0));

		lblRockPaperScissors = createLblRockPaperScissors();
		add(lblRockPaperScissors, BorderLayout.CENTER);

		lblType = createLblType();
		add(lblType, BorderLayout.SOUTH);

	}

	public RockPaperScissors getRockPaperScissors() {
		return rockPaperScissors;
	}

	public void updateRockPaperScissors(RockPaperScissors rockPaperScissors) {
		this.rockPaperScissors = rockPaperScissors;
		lblRockPaperScissors.setIcon(getThrowIcon());
		lblType.setText(rockPaperScissors.getType().toString());
	}

	private JLabel createLblType() {
		JLabel lblType = new JLabel(rockPaperScissors.getType().toString());
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblType.setBorder(new EmptyBorder(8, 0, 8, 0));
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		return lblType;
	}

	private JLabel createLblRockPaperScissors() {
		JLabel lblRockPaperScissors = new JLabel("");
		lblRockPaperScissors.setOpaque(true);
		lblRockPaperScissors.setBackground(Color.WHITE);
		lblRockPaperScissors.setIcon(getThrowIcon());
		lblRockPaperScissors.setHorizontalAlignment(SwingConstants.CENTER);
		return lblRockPaperScissors;
	}

	private Icon getThrowIcon() {
		String imagePath;

		switch (rockPaperScissors.getType()) {
		case ROCK:
			imagePath = "/rockPaperScissorsImages/rock.jpg";
			break;
		case PAPER:
			imagePath = "/rockPaperScissorsImages/paper.jpg";
			break;
		case SCISSORS:
			imagePath = "/rockPaperScissorsImages/scissors.jpg";
			break;
		default:
			imagePath = null;
			break;
		}

		return new ImageIcon(RockPaperScissorsPanel.class.getResource(imagePath));
	}

}

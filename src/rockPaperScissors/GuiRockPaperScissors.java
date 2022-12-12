package rockPaperScissors;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class GuiRockPaperScissors extends JFrame {

	private JPanel contentPane;
	private RockPaperScissorsPanel leftThrowPanel;
	private RockPaperScissorsPanel rightThrowPanel;
	private JLabel lblEqual;
	private final Random rand = new Random();
	private JRadioButton rdbtnRock;
	private JRadioButton rdbtnPaper;
	private JRadioButton rdbtnScissors;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRockPaperScissors frame = new GuiRockPaperScissors();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiRockPaperScissors() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblTitle = createLblTitle();
		contentPane.add(lblTitle, BorderLayout.NORTH);

		JPanel displayPanel = createDisplayPanel();
		contentPane.add(displayPanel, BorderLayout.CENTER);

		JPanel controlPanel = createControlPanel();
		contentPane.add(controlPanel, BorderLayout.SOUTH);
	}

	private JPanel createDisplayPanel() {
		JPanel displayPanel = new JPanel();
		displayPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		displayPanel.setLayout(new GridLayout(1, 0, 10, 0));

		leftThrowPanel = new RockPaperScissorsPanel(getRandomThrow());
		displayPanel.add(leftThrowPanel);

		rightThrowPanel = new RockPaperScissorsPanel(getRandomThrow());
		displayPanel.add(rightThrowPanel);
		return displayPanel;
	}

	private RockPaperScissors getRandomThrow() {
		ThrowType[] allTypes = ThrowType.values();
		int randomIndex = rand.nextInt(allTypes.length);
		ThrowType randomType = allTypes[randomIndex];

		return new RockPaperScissors(randomType);
	}

	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();
		rdbtnRock = new JRadioButton("Rock");
		controlPanel.add(rdbtnRock);
		
		rdbtnPaper = new JRadioButton("Paper");
		controlPanel.add(rdbtnPaper);
		
		rdbtnScissors = new JRadioButton("Scissors");
		controlPanel.add(rdbtnScissors);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnRock);
		group.add(rdbtnPaper);
		group.add(rdbtnScissors);
		JButton btnThrow = new JButton("Throw");
		btnThrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPaper.isSelected()) {
					leftThrowPanel.updateRockPaperScissors(new RockPaperScissors(ThrowType.PAPER));
				}
				else if(rdbtnRock.isSelected()) {
					leftThrowPanel.updateRockPaperScissors(new RockPaperScissors(ThrowType.ROCK));
				}
				else if(rdbtnScissors.isSelected()) {
					leftThrowPanel.updateRockPaperScissors(new RockPaperScissors(ThrowType.SCISSORS));
				}
				
				rightThrowPanel.updateRockPaperScissors(getRandomThrow());
				updateLblEqual();
			}
		});
		controlPanel.add(btnThrow);
		

		lblEqual = new JLabel();
		updateLblEqual();
		controlPanel.add(lblEqual);
		return controlPanel;
	}

	private JLabel createLblTitle() {
		JLabel lblTitle = new JLabel("Rock Paper Scissors");
		lblTitle.setBorder(new EmptyBorder(8, 0, 8, 0));
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		return lblTitle;
	}

	private void updateLblEqual() {
		RockPaperScissors leftThrow = leftThrowPanel.getRockPaperScissors();
		RockPaperScissors rightThrow = rightThrowPanel.getRockPaperScissors();
		if (leftThrow.equals(rightThrow))
			lblEqual.setText("TIE");
		else if(leftThrow.getType().equals(ThrowType.PAPER)&& rightThrow.getType().equals(ThrowType.ROCK)) {
			lblEqual.setText("You Win!!!");
		}
		else if(leftThrow.getType().equals(ThrowType.ROCK)&& rightThrow.getType().equals(ThrowType.PAPER)) {
			lblEqual.setText("You Win!!!");
		}
		else if(leftThrow.getType().equals(ThrowType.SCISSORS)&& rightThrow.getType().equals(ThrowType.PAPER)) {
			lblEqual.setText("You Win!!!");
		}
		else {
			lblEqual.setText("You Lose :(");
		}
	}

}

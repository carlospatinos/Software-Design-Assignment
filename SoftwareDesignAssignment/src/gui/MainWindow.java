package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.Player;

public class MainWindow {

	private JFrame frmPlayerDetailsApplication;
	private JTextField nameText;
	private JTextField shirtNumberText;
	private JTextField dobText;
	private JTextField birthplaceText;
	private JTextField joinDateText;
	private JTextField joinedFromText;
	private JTextField internationalText;
	private JTextField debutText;
	private JTextField appsText;
	private JTextField goalsText;
	private JTextField searchTextField;
	private JTextField dobDisplay;
	private JTextField birthplaceDisplay;
	private JTextField jtcDisplay;
	private JTextField joinedFromDisplay;
	private JTextField internationalDisplay;
	private JTextField debutDisplay;
	private JTextField appsDisplay;
	private JTextField goalsDisplay;
	private JTextField positionDisplay;
	private JTextField shirtnumberDisplay;
	private JTextField playerNameDisplay;
	private JTextField newValueText;
	private JTextField searchNumberTextField;

	HashSet<Player> set = new HashSet<Player>();
	int current = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmPlayerDetailsApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		Collections.addAll(set, new Player("David De Gea", 1, "07 Nov 1990",
				"Madrid, Spain", "GK", "01 Jul 2011", "Atletico Madrid",
				"Spain", "7 Aug 2011 v Man City (N)", 259, 0), new Player(
				"Paul Pogba", 6, "15 Mar 1993", "Lagny-sur-Marne", "CM",
				"08 Aug 2016", "Juventus", "France", "20 Sep 2011 v Leeds (A)",
				45, 7), new Player("Zlatan Ibrahimovic", 9, "03 Oct 1981",
				"Malmo, Sweden", "ST", "01 Jul 2016", "Free Agent",
				"Sweden (retired)", "7 Aug 2016 v Leicester City (N)", 40, 26));
		initialize();
		if (set.size() != 0) {
			display(goToElement(0));
		}
	}

	private void display(Player element) {
		positionDisplay.setText(element.getPosition());
		shirtnumberDisplay.setText("#" + element.getShirt_number());
		playerNameDisplay.setText(element.getName());
		dobDisplay.setText(element.getDob());
		birthplaceDisplay.setText(element.getBirthPlace());
		jtcDisplay.setText(element.getJoined_club());
		joinedFromDisplay.setText(element.getJoined_from());
		internationalDisplay.setText(element.getInternational());
		debutDisplay.setText(element.getClub_debut());
		appsDisplay.setText("" + element.getApps());
		goalsDisplay.setText("" + element.getGoals());
	}

	private Player goToElement(int index) {
		Player res = null;
		Iterator<Player> iter = set.iterator();
		int count = 0;
		while (iter.hasNext() && count <= index) {
			res = (Player) iter.next();
			count++;
		}
		return res;
	}

	private Player search(String searchedName) {
		Player res = null;
		Iterator<Player> iter = set.iterator();
		while (iter.hasNext()) {
			Player element = (Player) iter.next();
			if (element == null || searchedName == "") {
				JOptionPane.showMessageDialog(searchTextField,
						"No player found!!");
			} else if (searchedName.equals(element.getName())) {
				res = element;
			}
		}
		return res;
	}

	private Player searchByNumber(int searchedNumber) {
		Player res = null;
		Iterator<Player> iter = set.iterator();
		while (iter.hasNext()) {
			Player element = (Player) iter.next();
			if (element == null || searchedNumber < 1 || searchedNumber > 99) {
				JOptionPane.showMessageDialog(searchTextField,
						"No player found!!");
			} else if (searchedNumber == element.getShirt_number()) {
				res = element;
			}
		}
		return res;

	}

	private void editField(String field, String value) {
		Player element = goToElement(current);

		if (field == "Name") {
			element.setName(value);
		} else if (field == "Shirt Number") {
			int temp = Integer.parseInt(value);
			element.setShirt_number(temp);
		} else if (field == "Date of Birth") {
			element.setDob(value);
		} else if (field == "Birthplace") {
			element.setBirthPlace(value);
		} else if (field == "Position") {
			element.setPosition(value);
		} else if (field == "Joined the Club") {
			element.setJoined_club(value);
		} else if (field == "Joined From") {
			element.setJoined_from(value);
		} else if (field == "International") {
			element.setInternational(value);
		} else if (field == "Debut") {
			element.setClub_debut(value);
		} else if (field == "Appearances") {
			int temp = Integer.parseInt(value);
			element.setApps(temp);
		} else if (field == "Goals") {
			int temp = Integer.parseInt(value);
			element.setGoals(temp);
		}
		display(goToElement(current));
	}

	private void initialize() {
		frmPlayerDetailsApplication = new JFrame();
		frmPlayerDetailsApplication.setTitle("Player Details Application");
		frmPlayerDetailsApplication.setBounds(100, 100, 720, 400);
		frmPlayerDetailsApplication
				.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerDetailsApplication.getContentPane().setLayout(null);

		JLabel insertNewPlayerLabel = new JLabel("Insert New Player");
		insertNewPlayerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		insertNewPlayerLabel.setBounds(10, 11, 167, 27);
		frmPlayerDetailsApplication.getContentPane().add(insertNewPlayerLabel);

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(10, 49, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(nameLabel);

		nameText = new JTextField();
		nameText.setBounds(111, 46, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(nameText);
		nameText.setColumns(10);

		JLabel shirtNumberLabel = new JLabel("Shirt Number:");
		shirtNumberLabel.setBounds(10, 74, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(shirtNumberLabel);

		shirtNumberText = new JTextField();
		shirtNumberText.setBounds(111, 71, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(shirtNumberText);
		shirtNumberText.setColumns(10);

		JLabel dobLabel = new JLabel("Date of Birth:");
		dobLabel.setBounds(10, 99, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(dobLabel);

		dobText = new JTextField();
		dobText.setBounds(111, 96, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(dobText);
		dobText.setColumns(10);

		JLabel birthplaceLabel = new JLabel("Birthplace:");
		birthplaceLabel.setBounds(10, 124, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(birthplaceLabel);

		birthplaceText = new JTextField();
		birthplaceText.setBounds(111, 121, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(birthplaceText);
		birthplaceText.setColumns(10);

		JLabel lblPositiopositionLabeln = new JLabel("Position:");
		lblPositiopositionLabeln.setBounds(10, 149, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(
				lblPositiopositionLabeln);

		JComboBox<Object> positionComboBox = new JComboBox<Object>();
		positionComboBox
				.setModel(new DefaultComboBoxModel<Object>(new String[] { "GK",
						"RB", "CB", "LB", "RM", "CM", "LM", "ST" }));
		positionComboBox.setBounds(111, 146, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(positionComboBox);

		JLabel jtcLabel = new JLabel("Joined the Club:");
		jtcLabel.setBounds(10, 174, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(jtcLabel);

		JLabel joinedFromLabel = new JLabel("Joined From:");
		joinedFromLabel.setBounds(10, 199, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(joinedFromLabel);

		joinDateText = new JTextField();
		joinDateText.setBounds(111, 171, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(joinDateText);
		joinDateText.setColumns(10);

		joinedFromText = new JTextField();
		joinedFromText.setBounds(111, 196, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(joinedFromText);
		joinedFromText.setColumns(10);

		JLabel debutLabel = new JLabel("Debut:");
		debutLabel.setBounds(10, 249, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(debutLabel);

		internationalText = new JTextField();
		internationalText.setBounds(111, 221, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(internationalText);
		internationalText.setColumns(10);

		JLabel internationalLabel = new JLabel("International:");
		internationalLabel.setBounds(10, 224, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(internationalLabel);

		debutText = new JTextField();
		debutText.setBounds(111, 246, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(debutText);
		debutText.setColumns(10);

		JLabel appsLabel = new JLabel("Appearances:");
		appsLabel.setBounds(10, 274, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(appsLabel);

		appsText = new JTextField();
		appsText.setBounds(111, 271, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(appsText);
		appsText.setColumns(10);

		JLabel goalsLabel = new JLabel("Goals:");
		goalsLabel.setBounds(10, 299, 91, 14);
		frmPlayerDetailsApplication.getContentPane().add(goalsLabel);

		goalsText = new JTextField();
		goalsText.setBounds(111, 296, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(goalsText);
		goalsText.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				int shirtNumber = Integer.parseInt(shirtNumberText.getText());
				String dob = dobText.getText();
				String birthplace = birthplaceText.getText();
				String position = (String) positionComboBox.getSelectedItem();
				String joinDate = joinDateText.getText();
				String joinedFrom = joinedFromText.getText();
				String international = internationalText.getText();
				String debut = debutText.getText();
				int apps = Integer.parseInt(appsText.getText());
				int goals = Integer.parseInt(goalsText.getText());

				if (name.length() > 0 && shirtNumber > 0 && shirtNumber < 100
						&& dob.length() > 0 && birthplace.length() > 0
						&& position.length() == 2 && joinDate.length() > 0
						&& joinedFrom.length() > 0
						&& international.length() > 0 && debut.length() > 0) {
					Player element = new Player(name, shirtNumber, dob,
							birthplace, position, joinDate, joinedFrom,
							international, debut, apps, goals);
					set.add(element);
					JOptionPane.showMessageDialog(btnSubmit,
							"Player added successfully!!");

				} else {
					JOptionPane
							.showMessageDialog(btnSubmit, "Please try again");
				}
			}
		});
		btnSubmit.setBounds(10, 327, 91, 20);
		frmPlayerDetailsApplication.getContentPane().add(btnSubmit);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearFields();
			}
		});
		btnClear.setBounds(137, 327, 91, 20);
		frmPlayerDetailsApplication.getContentPane().add(btnClear);

		JLabel playerDetailsLabel = new JLabel("Player Details");
		playerDetailsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		playerDetailsLabel.setBounds(299, 26, 157, 22);
		frmPlayerDetailsApplication.getContentPane().add(playerDetailsLabel);

		JButton previousButton = new JButton("<<");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (set.isEmpty()) {
					JOptionPane.showMessageDialog(previousButton,
							"No Player Information Stored");
				} else {
					if (current > 0) {
						current--;
					}
					display(goToElement(current));
				}
			}
		});
		previousButton.setBounds(396, 212, 89, 23);
		frmPlayerDetailsApplication.getContentPane().add(previousButton);

		JButton nextButton = new JButton(">>");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (set.isEmpty()) {
					JOptionPane.showMessageDialog(nextButton,
							"No Player Information Stored");
				} else {
					if (current < set.size() - 1) {
						current++;
					}
					display(goToElement(current));
				}
			}
		});
		nextButton.setBounds(495, 212, 89, 23);
		frmPlayerDetailsApplication.getContentPane().add(nextButton);

		JButton firstButton = new JButton("First");
		firstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (set.isEmpty()) {
					JOptionPane.showMessageDialog(firstButton,
							"No Player Information Stored");
				} else {
					current = 0;
					display(goToElement(current));
				}
			}
		});
		firstButton.setBounds(299, 212, 89, 23);
		frmPlayerDetailsApplication.getContentPane().add(firstButton);

		JButton lastButton = new JButton("Last");
		lastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (set.isEmpty()) {
					JOptionPane.showMessageDialog(lastButton,
							"No Player Information Stored");
				} else {
					current = set.size() - 1;
					display(goToElement(current));
				}
			}
		});
		lastButton.setBounds(594, 212, 89, 23);
		frmPlayerDetailsApplication.getContentPane().add(lastButton);

		JLabel editLabel = new JLabel("Choose field to edit:");
		editLabel.setBounds(299, 302, 115, 14);
		frmPlayerDetailsApplication.getContentPane().add(editLabel);

		JComboBox<Object> fieldComboBox = new JComboBox<Object>();
		fieldComboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {
				"Name", "Shirt Number", "Date of Birth", "Birthplace",
				"Position", "Joined the Club", "Joined From", "International",
				"Debut", "Appearances", "Goals" }));
		fieldComboBox.setBounds(424, 298, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(fieldComboBox);

		JButton editButton = new JButton("GO!");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = newValueText.getText();
				String field = (String) fieldComboBox.getSelectedItem();
				editField(field, value);
			}
		});
		editButton.setBounds(594, 324, 89, 23);
		frmPlayerDetailsApplication.getContentPane().add(editButton);

		JLabel searchByNameLabel = new JLabel("Search by Name:");
		searchByNameLabel.setBounds(299, 253, 115, 14);
		frmPlayerDetailsApplication.getContentPane().add(searchByNameLabel);

		searchTextField = new JTextField();
		searchTextField.setBounds(424, 250, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(searchTextField);
		searchTextField.setColumns(10);

		JButton searchButton = new JButton("GO!");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchedName = searchTextField.getText();
				Player p = search(searchedName);
				display(p);
			}
		});
		searchButton.setBounds(594, 249, 89, 23);
		frmPlayerDetailsApplication.getContentPane().add(searchButton);

		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(299, 112, 89, 14);
		frmPlayerDetailsApplication.getContentPane().add(lblDateOfBirth);

		dobDisplay = new JTextField();
		dobDisplay.setBounds(396, 109, 97, 20);
		frmPlayerDetailsApplication.getContentPane().add(dobDisplay);
		dobDisplay.setColumns(10);

		JLabel lblBirthplace = new JLabel("Birthplace:");
		lblBirthplace.setBounds(511, 112, 89, 14);
		frmPlayerDetailsApplication.getContentPane().add(lblBirthplace);

		birthplaceDisplay = new JTextField();
		birthplaceDisplay.setBounds(586, 109, 97, 20);
		frmPlayerDetailsApplication.getContentPane().add(birthplaceDisplay);
		birthplaceDisplay.setColumns(10);

		JLabel lblJoinedTheClub = new JLabel("Joined the Club:");
		lblJoinedTheClub.setBounds(299, 137, 89, 14);
		frmPlayerDetailsApplication.getContentPane().add(lblJoinedTheClub);

		jtcDisplay = new JTextField();
		jtcDisplay.setBounds(396, 134, 97, 20);
		frmPlayerDetailsApplication.getContentPane().add(jtcDisplay);
		jtcDisplay.setColumns(10);

		JLabel lblJoinedFrom = new JLabel("Joined From:");
		lblJoinedFrom.setBounds(511, 137, 73, 14);
		frmPlayerDetailsApplication.getContentPane().add(lblJoinedFrom);

		joinedFromDisplay = new JTextField();
		joinedFromDisplay.setBounds(586, 134, 97, 20);
		frmPlayerDetailsApplication.getContentPane().add(joinedFromDisplay);
		joinedFromDisplay.setColumns(10);

		JLabel lblInternational = new JLabel("International:");
		lblInternational.setBounds(299, 162, 89, 14);
		frmPlayerDetailsApplication.getContentPane().add(lblInternational);

		internationalDisplay = new JTextField();
		internationalDisplay.setBounds(396, 159, 97, 20);
		frmPlayerDetailsApplication.getContentPane().add(internationalDisplay);
		internationalDisplay.setColumns(10);

		JLabel lblDebut = new JLabel("Debut:");
		lblDebut.setBounds(511, 162, 73, 14);
		frmPlayerDetailsApplication.getContentPane().add(lblDebut);

		debutDisplay = new JTextField();
		debutDisplay.setBounds(586, 159, 97, 20);
		frmPlayerDetailsApplication.getContentPane().add(debutDisplay);
		debutDisplay.setColumns(10);

		JLabel lblAppearances = new JLabel("Appearances:");
		lblAppearances.setBounds(299, 187, 89, 14);
		frmPlayerDetailsApplication.getContentPane().add(lblAppearances);

		appsDisplay = new JTextField();
		appsDisplay.setBounds(396, 184, 97, 20);
		frmPlayerDetailsApplication.getContentPane().add(appsDisplay);
		appsDisplay.setColumns(10);

		JLabel lblGoals = new JLabel("Goals:");
		lblGoals.setBounds(511, 187, 46, 14);
		frmPlayerDetailsApplication.getContentPane().add(lblGoals);

		goalsDisplay = new JTextField();
		goalsDisplay.setBounds(586, 184, 97, 20);
		frmPlayerDetailsApplication.getContentPane().add(goalsDisplay);
		goalsDisplay.setColumns(10);

		positionDisplay = new JTextField();
		positionDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		positionDisplay.setBounds(299, 62, 58, 39);
		frmPlayerDetailsApplication.getContentPane().add(positionDisplay);
		positionDisplay.setColumns(10);

		shirtnumberDisplay = new JTextField();
		shirtnumberDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		shirtnumberDisplay.setBounds(370, 62, 58, 39);
		frmPlayerDetailsApplication.getContentPane().add(shirtnumberDisplay);
		shirtnumberDisplay.setColumns(10);

		playerNameDisplay = new JTextField();
		playerNameDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		playerNameDisplay.setBounds(438, 62, 245, 39);
		frmPlayerDetailsApplication.getContentPane().add(playerNameDisplay);
		playerNameDisplay.setColumns(10);

		JLabel newValueLabel = new JLabel("New Value:");
		newValueLabel.setBounds(299, 328, 115, 14);
		frmPlayerDetailsApplication.getContentPane().add(newValueLabel);

		newValueText = new JTextField();
		newValueText.setBounds(424, 325, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(newValueText);
		newValueText.setColumns(10);

		JButton deletePlayerButton = new JButton("Delete Player");
		deletePlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (set.isEmpty()) {
					JOptionPane.showMessageDialog(deletePlayerButton,
							"No Player Information Stored");
				} else {
					Player element = goToElement(current);
					set.remove(element);
					if (set.isEmpty()) {
						clearFields2();
					} else {
						display(goToElement(0));
					}
				}
			}
		});
		deletePlayerButton.setBounds(511, 26, 172, 20);
		frmPlayerDetailsApplication.getContentPane().add(deletePlayerButton);

		JLabel lblSearchByNumber = new JLabel("Search by Number:");
		lblSearchByNumber.setBounds(299, 277, 129, 14);
		frmPlayerDetailsApplication.getContentPane().add(lblSearchByNumber);

		searchNumberTextField = new JTextField();
		searchNumberTextField.setBounds(424, 271, 140, 20);
		frmPlayerDetailsApplication.getContentPane().add(searchNumberTextField);
		searchNumberTextField.setColumns(10);

		JButton button = new JButton("GO!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int searchedNumber = Integer.parseInt(searchNumberTextField
						.getText());
				Player p = searchByNumber(searchedNumber);
				display(p);
			}
		});
		button.setBounds(594, 270, 89, 23);
		frmPlayerDetailsApplication.getContentPane().add(button);
	}

	private void clearFields() {
		nameText.setText("");
		shirtNumberText.setText("");
		dobText.setText("");
		birthplaceText.setText("");
		joinDateText.setText("");
		joinedFromText.setText("");
		internationalText.setText("");
		debutText.setText("");
		appsText.setText("");
		goalsText.setText("");
	}

	private void clearFields2() {
		positionDisplay.setText("");
		shirtnumberDisplay.setText("");
		playerNameDisplay.setText("");
		dobDisplay.setText("");
		birthplaceDisplay.setText("");
		jtcDisplay.setText("");
		joinedFromDisplay.setText("");
		internationalDisplay.setText("");
		debutDisplay.setText("");
		appsDisplay.setText("");
		goalsDisplay.setText("");
	}
}

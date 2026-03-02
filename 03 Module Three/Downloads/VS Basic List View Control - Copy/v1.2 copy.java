// //
// ****************************************************************************************
// // Title: Travel List
// |***********************************************************
// // Developed by: Ryan Hatch
// |***********************************************************
// // Last Updated: Nov 16th 2023
// |***********************************************************
// // Version: 1.2 |***********************************************************
// //
// ****************************************************************************************

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.List;
// import java.util.ArrayList;
// import javax.swing.Icon;

// class TopDestinationListFrame extends JFrame {
// private List<TextAndIcon> destinations;
// private JLabel imageLabel;
// private JTextPane textPane;
// private int currentIndex = 0;
// private Timer slideshowTimer;

// public class TextAndIcon {
// private String text;
// private Icon icon;

// public TextAndIcon(String text, Icon icon) {
// this.text = text;
// this.icon = icon;
// }

// public String getText() {
// return text;
// }

// public Icon getIcon() {
// return icon;
// }

// public void setText(String text) {
// this.text = text;
// }

// public void setIcon(Icon icon) {
// this.icon = icon;
// }
// }

// public TopDestinationListFrame() {
// super("Top Five Destination List");
// setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// setSize(900, 750);
// setLocationRelativeTo(null);

// // Create a label with my name
// JLabel nameLabel = new JLabel("Ryan Hatch");
// nameLabel.setHorizontalAlignment(JLabel.CENTER); // Center the label
// horizontally
// nameLabel.setVerticalAlignment(JLabel.TOP); // Align the label to the top of
// its display area
// nameLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set the font for the
// label
// nameLabel.setForeground(Color.BLACK); // Set the foreground (text) color for
// the label
// nameLabel.setBackground(Color.GRAY); // Set the background color for the
// label
// nameLabel.setOpaque(true); // Make the label opaque

// destinations = new ArrayList<>();
// // 2 Antigua, Guatemala
// addDestinationNameAndPicture(
// "<html><div style='text-align: center; font-size: 18px;'>" +
// "1. Antigua, Guatemala:<br><br>" +
// "Celebrated for its well-preserved Spanish baroque architecture and a storied
// past as a former colonial capital.<br>"
// +
// "Antigua is a UNESCO World Heritage site teeming with historical ruins and
// vibrant culture.<br>"
// +
// "It is also acclaimed for its scenic coffee plantations and proximity to
// majestic volcanoes.<br>"
// +
// "<a href='https://ryanshatch.com'>Book Now!</a>",
// new ImageIcon(getClass().getResource("/resources/Guatemala.jpg")));

// // 1 Mallorca, Spain
// addDestinationNameAndPicture(
// "<html><div style='text-align: center; font-size: 18px;'>" +
// "2. Mallorca, Spain:<br><br>" +
// "Recognized for its impressive cathedral, vibrant beach resorts, amazing
// Spanish cuisine, and a variety of luxury accommodations.<br>"
// +
// "Enjoy the beautiful coastlines and immerse yourself in the rich cultural
// heritage of this stunning island.<br>"
// +
// "<a href='https://ryanshatch.com'>Book Now!</a>",
// new ImageIcon(getClass().getResource("/resources/Spain.jpg")));

// // 3 Sicily, Italy
// addDestinationNameAndPicture(
// "<html><div style='text-align: center; font-size: 18px;'>" +
// "3. Sicily, Italy:<br><br>" +
// "Known for the Noto Valley and the UNESCO World Heritage sites, rich
// architecture, and from the show 'The White Lotus'.<br>"
// +
// "Explore the ancient ruins and savor the exquisite Sicilian cuisine in this
// Mediterranean paradise.<br>"
// +
// "<a href='https://ryanshatch.com'>Book Now!</a>",
// new ImageIcon(getClass().getResource("/resources/Italy.jpg")));

// // 4 The Isle of Skye, Scotland
// addDestinationNameAndPicture(
// "<html><div style='text-align: center; font-size: 18px;'>" +
// "4. The Isle of Skye, Scotland:<br><br>" +
// "Offers breathtaking landscapes, historical sites, and unique accommodations
// like pod hotels and traditional lodges.<br>"
// +
// "Discover the rugged beauty of Skye and the rich Gaelic culture that pervades
// this mystical island.<br>"
// +
// "<a href='https://ryanshatch.com'>Book Now!</a>",
// new ImageIcon(getClass().getResource("/resources/Scotland.jpg")));

// // 5 Nice, France
// addDestinationNameAndPicture(
// "<html><div style='text-align: center; font-size: 18px;'>" +
// "5. Nice, France:<br><br>" +
// "Stands out for its eco-friendly transportation, pedestrian streets,
// flourishing old town district, new restaurants, and boutique hotels.<br>"
// +
// "Experience the allure of the French Riviera with its stunning seaside
// promenades and vibrant cultural scene.<br>"
// +
// "<a href='https://ryanshatch.com'>Book Now!</a>",
// new ImageIcon(getClass().getResource("/resources/France.jpg")));

// imageLabel = new JLabel();
// textPane = new JTextPane();
// textPane.setContentType("text/html");
// textPane.setEditable(false);
// textPane.setBackground(Color.GRAY);
// // textPane.setFont(new Font("Arial", Font.BOLD, 24));

// setLayout(new BorderLayout());
// // add a label and text pane to the frame
// add(nameLabel, BorderLayout.NORTH); // Add the label to the frame (by
// default, it's in the center
// add(imageLabel, BorderLayout.CENTER); // Add the text pane to the frame
// add(textPane, BorderLayout.SOUTH); // Add the text pane to the frame

// // Initialize and start the slideshow timer
// slideshowTimer = new Timer(24000, new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// showNextDestination();
// }
// });
// slideshowTimer.start();

// initializeDestinations();
// updateDestinationDisplay(); // Display the first destination immediately
// }

// private void showNextDestination() {
// currentIndex = (currentIndex + 1) % destinations.size();
// updateDestinationDisplay();
// }

// private void updateDestinationDisplay() {
// TextAndIcon current = destinations.get(currentIndex);
// imageLabel.setIcon(current.getIcon());
// textPane.setText(current.getText());
// }

// private void addDestinationNameAndPicture(String text, Icon icon) {
// destinations.add(new TextAndIcon(text, icon));
// }

// private void initializeDestinations() {

// }

// // Add each destination with its name and picture
// // 2 Antigua, Guatemala
// // addDestinationNameAndPicture(
// // "1. Antigua, Guatemala:<br><br>" +
// // "Celebrated for its well-preserved Spanish baroque architecture and a
// storied
// // past as a former colonial capital.<br>"
// // +
// // "Antigua is a UNESCO World Heritage site teeming with historical ruins and
// // vibrant cultural experiences.<br>"
// // +
// // "It is also acclaimed for its scenic coffee plantations and proximity to
// // majestic volcanoes.<br>" +
// // "<a href='https://ryanshatch.com'>Book Now!</a>",
// // new ImageIcon(getClass().getResource("/resources/Guatemala.jpg")));

// // // 1 Mallorca, Spain
// // addDestinationNameAndPicture(
// // "2. Mallorca, Spain:<br><br>" +
// // "Recognized for its impressive cathedral, vibrant beach resorts, amazing
// // Spanish cuisine, and a variety of luxury accommodations.<br>"
// // +
// // "Enjoy the beautiful coastlines and immerse yourself in the rich cultural
// // heritage of this stunning island.<br>"
// // +
// // "<a href='https://ryanshatch.com'>Book Now!</a>",
// // new ImageIcon(getClass().getResource("/resources/Spain.jpg")));

// // // 3 Sicily, Italy
// // addDestinationNameAndPicture(
// // "3. Sicily, Italy:<br><br>" +
// // "Known for the Noto Valley and the UNESCO World Heritage sites, rich
// // architecture, and from the show 'The White Lotus'.<br>"
// // +
// // "Explore the ancient ruins and savor the exquisite Sicilian cuisine in
// this
// // Mediterranean paradise.<br>" +
// // "<a href='https://ryanshatch.com'>Book Now!</a>",
// // new ImageIcon(getClass().getResource("/resources/Italy.jpg")));

// // // 4 The Isle of Skye, Scotland
// // addDestinationNameAndPicture(
// // "4. The Isle of Skye, Scotland:<br><br>" +
// // "Offers breathtaking landscapes, historical sites, and unique
// accommodations
// // like pod hotels and traditional lodges.<br>"
// // +
// // "Discover the rugged beauty of Skye and the rich Gaelic culture that
// pervades
// // this mystical island.<br>" +
// // "<a href='https://ryanshatch.com'>Book Now!</a>",
// // new ImageIcon(getClass().getResource("/resources/Scotland.jpg")));

// // // 5 Nice, France
// // addDestinationNameAndPicture(
// // "5. Nice, France:<br><br>" +
// // "Stands out for its eco-friendly transportation, pedestrian streets,
// // flourishing old town district, new restaurants, and boutique hotels.<br>"
// // +
// // "Experience the allure of the French Riviera with its stunning seaside
// // promenades and vibrant cultural scene.<br>"
// // +
// // "<a href='https://ryanshatch.com'>Book Now!</a>",
// // new ImageIcon(getClass().getResource("/resources/France.jpg")));
// // addDestinationNameAndPicture("Paris, France", new
// // ImageIcon("src/resources/paris.jpg"));
// // addDestinationNameAndPicture("Rome, Italy", new
// // ImageIcon("src/resources/rome.jpg"));
// // addDestinationNameAndPicture("Sydney, Australia", new
// // ImageIcon("src/resources/sydney.jpg"));
// // addDestinationNameAndPicture("Tokyo, Japan", new
// // ImageIcon("src/resources/tokyo.jpg"));
// // addDestinationNameAndPicture("New York City, USA", new
// // ImageIcon("src/resources/newyork.jpg"));

// private void addNavigationButtons() {
// // Create two separate panels for the buttons
// JPanel westPanel = new JPanel();
// JPanel eastPanel = new JPanel();

// // Create the buttons
// JButton prevButton = new JButton("Back");
// JButton nextButton = new JButton("Next");

// // Add action listeners for the buttons
// prevButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// currentIndex = (currentIndex - 1 + destinations.size()) %
// destinations.size();
// updateDestinationDisplay();
// }
// });

// nextButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// showNextDestination();
// }
// });

// // Add buttons to their respective panels
// westPanel.add(prevButton);
// eastPanel.add(nextButton);

// // Add the panels to the main container
// add(westPanel, BorderLayout.WEST);
// add(eastPanel, BorderLayout.EAST);
// westPanel.setBackground(Color.GRAY);
// eastPanel.setBackground(Color.GRAY);
// }

// // Main method to run the frame
// public static void main(String[] args) {
// SwingUtilities.invokeLater(new Runnable() {
// public void run() {
// TopDestinationListFrame frame = new TopDestinationListFrame();
// frame.addNavigationButtons();
// frame.setVisible(true);
// }
// });
// }
// }
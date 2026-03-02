// ****************************************************************************************
// Title: Detox Travel List    |***********************************************************
// Developed by: Ryan Hatch    |***********************************************************
// Last Updated: Nov 22nd 2023 |***********************************************************
// Version: 2.0                |***********************************************************
// ****************************************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.Icon;

// Display a list of the top five travel destinations with pictures and descriptions for each destination.
class TopDestinationListFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  private List<TextAndIcon> destinations;
  private JLabel imageLabel;
  private JTextPane textPane;
  private int currentIndex = 0; // The index of the currently displayed destination.
  private Timer slideshowTimer;

  public class TextAndIcon { // Class to store the text and icon for a destination
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) { // Constructor for the class to set the text and icon for a destination
      this.text = text;
      this.icon = icon;
    }

    public String getText() {
      return text;
    }

    public Icon getIcon() {
      return icon;
    }

    public void setText(String text) {
      this.text = text;
    }

    public void setIcon(Icon icon) {
      this.icon = icon;
    }
  }

  // Set colors for the frame, text, and icons for the destinations list and
  // navigation buttons.

  Color white = Color.WHITE; // Standard white color for headers
  Color darkGrey = new Color(43, 43, 43); // RGB for a dark grey color for body text
  Color brightBlue = new Color(0, 123, 255); // RGB for Bright Blue
  Color warmOrange = new Color(255, 165, 0); // RGB for Warm Orange
  Color terracotta = new Color(226, 114, 91); // RGB for Terracotta
  Color forestGreen = new Color(34, 139, 34); // RGB for Forest Green
  Color oceanTeal = new Color(72, 209, 204); // RGB for Ocean Teal
  Color lightGrey = new Color(211, 211, 211); // RGB for Light Grey
  Color darkGrey2 = new Color(105, 105, 105); // RGB for Dark Grey

  public TopDestinationListFrame() { // Constructor for the frame.
    super("Top Five Destinations"); // Set the title.
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Set the default close operation for the frame to exit
                                                             // the application when closed.
    setSize(900, 750); // Set the size of the frame.
    setLocationRelativeTo(null); // Center the frame on the screen.

    Color deepSkyBlue = new Color(0, 191, 255); // RGB values for deep sky blue
    Color sandyBeige = new Color(245, 245, 220); // RGB values for sandy beige
    Color white = Color.WHITE; // Standard white color for headers
    Color darkGrey = new Color(43, 43, 43); // RGB for a dark grey color for body text

    // Commented out Colors, just in case I want to use them later.

    // Color brightBlue = new Color(0, 123, 255); // RGB for Bright Blue
    // Color warmOrange = new Color(255, 165, 0); // RGB for Warm Orange
    // Color terracotta = new Color(226, 114, 91); // RGB for Terracotta
    // Color forestGreen = new Color(34, 139, 34); // RGB for Forest Green
    // Color oceanTeal = new Color(72, 209, 204); // RGB for Ocean Teal
    // Color lightGrey = new Color(211, 211, 211); // RGB for Light Grey
    // Color darkGrey2 = new Color(105, 105, 105); // RGB for Dark Grey

    // Create a label with my name
    JLabel nameLabel = new JLabel("Ryan Hatch");
    nameLabel.setHorizontalAlignment(JLabel.CENTER);
    nameLabel.setVerticalAlignment(JLabel.TOP); // Align the label to the top.
    nameLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set the font for the label.
    nameLabel.setForeground(white); // Set the text color for the label.
    nameLabel.setBackground(deepSkyBlue); // Set the background color for the label.
    nameLabel.setOpaque(true);
    destinations = new ArrayList<>();

    // Costa Rica
    addDestinationNameAndPicture( // Add the destination name and picture to the list as well as the description
                                  // of the destinations top characteristics.
        "<html><div style='text-align: center;'>" +
            "<h1>1. Costa Rica</h1>" +
            "<h2>Offers a range of activities like surfing, jungle hikes, and visits to magnificent waterfalls. The Rio Celeste in Tenorio Volcano National Park is a highlight, with its brilliant aquamarine-hued pool.</h2>"
            +
            "The country`s top beach resorts provide a perfect setting for relaxation and reconnection with nature.<br><br>"
            +
            "<a href='https://ryanshatch.com'>Book Here!</a>",
        new ImageIcon(getClass().getResource("/resources/CostaRica.jpg")));

    // Blue Lagoon, Iceland
    addDestinationNameAndPicture( // Add the destination name and picture to the list as well as the description
                                  // of the destinations top characteristics.
        "<html><div style='text-align: center;'>" +
            "<h1>2. Blue Lagoon, Iceland</h1>" +
            "<h2>The Blue Lagoon in Iceland is ideal for a wellness retreat. The warm, milky turquoise waters set in a volcanic landscape offer a surreal experience.</h2>"
            +
            "Visitors can enjoy in-water massages and a variety of treatments, along with nutritious dining options.<br><br>"
            +
            "<a href='https://ryanshatch.com'>Book Here!</a>",
        new ImageIcon(getClass().getResource("/resources/BlueLagoon.jpg")));

    // Aruba
    addDestinationNameAndPicture( // Add the destination name and picture to the list as well as the description
                                  // of the destinations top characteristics.
        "<html><div style='text-align: center;'>" +
            "<h1>3. Aruba</h1>" +
            "<h2>This Caribbean island offers pristine white sand beaches and a variety of natural wonders. Activities such as snorkeling, paddle boarding, kayaking, and exploring caves and national parks provide ample opportunities for reconnecting with nature.</h2>"
            +
            "The Manchebo Beach Resort & Spa offers mineral-rich mud baths and beach yoga​.<br><br>"
            +
            "<a href='https://ryanshatch.com'>Book Here!</a>",
        new ImageIcon(getClass().getResource("/resources/Aruba.jpg")));

    // The Maldives
    addDestinationNameAndPicture( // Add the destination name and picture to the list as well as the description
                                  // of the destinations top characteristics.
        "<html><div style='text-align: center;'>" +
            "<h1>4. The Maldives</h1>" +
            "<h2>Synonymous with luxury, the Maldives offers many resorts specifically designed for wellness retreats.</h2>"
            +
            "Visitors can enjoy spa treatments, yoga sessions, water sports, and relaxation on soft white sands beside crystal-clear lagoons​.<br><br>"
            +
            "<a href='https://ryanshatch.com'>Book Here!</a>",
        new ImageIcon(getClass().getResource("/resources/Maldives.jpg")));

    // Ubud, Bali
    addDestinationNameAndPicture( // Add the destination name and picture to the list as well as the description
                                  // of the destinations top characteristics.
        "<html><div style='text-align: center;'>" +
            "<h1>5. Ubud, Bali</h1>" +
            "<h2>Ubud is a major center for yoga and spiritual wellness.</h2>"
            +
            "It offers a variety of yoga classes set amidst stunning natural beauty, treks in the jungle, and healthy dining options, including vegetarian eateries like The Elephant​<br><br>"
            +
            "<a href='https://ryanshatch.com'>Book Here!</a>",
        new ImageIcon(getClass().getResource("/resources/Bali.jpg")));

    // Create a label for the image and a text pane for the description.
    imageLabel = new JLabel(); // Create a label for the image.
    textPane = new JTextPane(); // Create a text pane for the description.
    textPane.setContentType("text/html"); // Set the content type to HTML.
    textPane.setEditable(false);
    textPane.setBackground(sandyBeige); // Set the background color for the text pane.
    textPane.setForeground(darkGrey); // Set the text color.
    textPane.setFont(new Font("Arial", Font.PLAIN, 24)); // Set the font.
    textPane.setMargin(new Insets(10, 10, 10, 10));
    setLayout(new BorderLayout());

    add(nameLabel, BorderLayout.NORTH);
    add(imageLabel, BorderLayout.CENTER);
    add(textPane, BorderLayout.SOUTH);

    // add naviagation buttons
    addNavigationButtons();

    // Initialize and start the slideshow timer
    slideshowTimer = new Timer(24000, new ActionListener() { // 24 seconds between slides.
      @Override
      public void actionPerformed(ActionEvent e) {
        showNextDestination();
      }
    });
    slideshowTimer.start(); // Start the timer.

    initializeDestinations(); // Initialize the destinations list.
    updateDestinationDisplay(); // Display the first destination.
  }

  private void showNextDestination() { // Method to show the next destination in the list
    currentIndex = (currentIndex + 1) % destinations.size(); // Increment the current index
    updateDestinationDisplay(); // Update the display
  }

  private void updateDestinationDisplay() { // Method to update the display with the current destination
    TextAndIcon current = destinations.get(currentIndex); // Get the current destination
    imageLabel.setIcon(current.getIcon()); // Set the icon for the current destination
    textPane.setText(current.getText()); // Set the text for the current destination
  }

  private void addDestinationNameAndPicture(String text, Icon icon) {
    destinations.add(new TextAndIcon(text, icon));
  }

  private void initializeDestinations() {

  }

  // Method to add navigation buttons to the frame
  private void addNavigationButtons() {

    JPanel westPanel = new JPanel(); // Panel for the "Back" button
    JPanel eastPanel = new JPanel(); // Panel for the "Next" button

    Color deepSkyBlue = new Color(0, 191, 255); // RGB values for deep sky blue
    Color terracotta = new Color(226, 114, 91); // RGB for Terracotta
    Color forestGreen = new Color(34, 139, 34); // RGB for Forest Green

    // Commented out Colors, just in case I want to use them later, once again.

    // Color oceanTeal = new Color(72, 209, 204); // RGB for Ocean Teal
    // Color sandyBeige = new Color(245, 245, 220); // RGB for Sandy Beige

    // Create the buttons
    JButton prevButton = new JButton("Back");
    JButton nextButton = new JButton("Next");

    // set as opaque so the background color shows up
    prevButton.setOpaque(true);
    nextButton.setOpaque(true);

    // set the font for the buttons
    prevButton.setFont(new Font("Arial", Font.BOLD, 24));
    nextButton.setFont(new Font("Arial", Font.BOLD, 24));

    // set the size of the buttons
    prevButton.setPreferredSize(new Dimension(150, 50));
    nextButton.setPreferredSize(new Dimension(150, 50));

    // set the background and foreground colors for the buttons
    prevButton.setBackground(brightBlue); // Set the background color for the button
    prevButton.setForeground(white); // Set the text color for the button
    nextButton.setBackground(warmOrange); // Set the background color for the button
    nextButton.setForeground(white);

    // set the border for the buttons (thickness and color)
    prevButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    nextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

    // Use the accent color for the buttons
    prevButton.setBackground(terracotta); // Set the background color for the button
    prevButton.setForeground(Color.WHITE); // Set the text color for the button
    nextButton.setBackground(forestGreen); // Set the background color for the button
    nextButton.setForeground(Color.WHITE); // Set the text color for the button

    // Add action listeners for the buttons
    prevButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        currentIndex = (currentIndex - 1 + destinations.size()) % destinations.size();
        updateDestinationDisplay();
      }
    });

    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        showNextDestination();
      }
    });

    // Add buttons to their respective panels
    westPanel.add(prevButton);
    eastPanel.add(nextButton);

    // Add the panels to the main container
    add(westPanel, BorderLayout.WEST); // Add the west panel to the left side of the frame
    add(eastPanel, BorderLayout.EAST); // Add the east panel to the right side of the frame
    westPanel.setBackground(deepSkyBlue); // Set the background color for the west panel
    eastPanel.setBackground(deepSkyBlue); // Set the background color for the east panel
  }

  // Main method to run the frame
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        TopDestinationListFrame frame = new TopDestinationListFrame();
        frame.addNavigationButtons();
        frame.setVisible(true);
      }
    });
  }
}
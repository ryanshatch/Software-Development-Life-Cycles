// ****************************************************************************************
// Title: Travel List          |***********************************************************
// Developed by: Ryan Hatch    |***********************************************************
// Last Updated: Nov 17th 2023 |***********************************************************
// Version: 1.3                |***********************************************************
// ****************************************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.Icon;

class TopDestinationListFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  private List<TextAndIcon> destinations;
  private JLabel imageLabel;
  private JTextPane textPane;
  private int currentIndex = 0; // The index of the currently displayed destination in the destinations list
  private Timer slideshowTimer; // Timer for the slideshow

  public class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
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

  Color white = Color.WHITE; // Standard white color for headers
  Color darkGrey = new Color(43, 43, 43); // RGB for a dark grey color for body text
  Color brightBlue = new Color(0, 123, 255); // RGB for Bright Blue
  Color warmOrange = new Color(255, 165, 0); // RGB for Warm Orange
  Color terracotta = new Color(226, 114, 91); // RGB for Terracotta
  Color forestGreen = new Color(34, 139, 34); // RGB for Forest Green
  Color oceanTeal = new Color(72, 209, 204); // RGB for Ocean Teal
  Color lightGrey = new Color(211, 211, 211); // RGB for Light Grey
  Color darkGrey2 = new Color(105, 105, 105); // RGB for Dark Grey

  public TopDestinationListFrame() {
    super("Top Five Destinations");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(900, 750);
    setLocationRelativeTo(null);

    Color deepSkyBlue = new Color(0, 191, 255); // RGB values for deep sky blue
    Color sandyBeige = new Color(245, 245, 220); // RGB values for sandy beige
    Color white = Color.WHITE; // Standard white color for headers
    Color darkGrey = new Color(43, 43, 43); // RGB for a dark grey color for body text
    // Color brightBlue = new Color(0, 123, 255); // RGB for Bright Blue
    // Color warmOrange = new Color(255, 165, 0); // RGB for Warm Orange
    // Color terracotta = new Color(226, 114, 91); // RGB for Terracotta
    // Color forestGreen = new Color(34, 139, 34); // RGB for Forest Green
    // Color oceanTeal = new Color(72, 209, 204); // RGB for Ocean Teal
    // Color lightGrey = new Color(211, 211, 211); // RGB for Light Grey
    // Color darkGrey2 = new Color(105, 105, 105); // RGB for Dark Grey

    // Create a label with my name
    JLabel nameLabel = new JLabel("Ryan Hatch");
    nameLabel.setHorizontalAlignment(JLabel.CENTER); // Center the label horizontally
    nameLabel.setVerticalAlignment(JLabel.TOP); // Align the label to the top of its display area
    nameLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set the font for the label
    nameLabel.setForeground(white); // Set the foreground (text) color for the label
    nameLabel.setBackground(deepSkyBlue); // Set the background color for the label
    nameLabel.setOpaque(true); // This is necessary for the color to show up on the label (opaque means "not
    // transparent")

    destinations = new ArrayList<>();
    // Antigua, Guatemala
    addDestinationNameAndPicture(
        "<html><div style='text-align: center;'>" +
            "<h1>1. Antigua, Guatemala</h1>" +
            "<h2>Celebrated for its well-preserved architecture and storied past as a former colonial capital.</h2>" +
            "Also acclaimed for its coffee plantations and volcanoes, Antigua is a UNESCO World Heritage site teeming with historical ruins and vibrant culture.<br><br>"
            +
            // "Antigua is also acclaimed for its scenic coffee plantations and proximity to
            // majestic volcanoes.<br>" +
            "<a href='https://ryanshatch.com'>Book Here!</a>",
        new ImageIcon(getClass().getResource("/resources/Guatemala.jpg")));

    // Mallorca, Spain
    addDestinationNameAndPicture(
        "<html><div style='text-align: center;'>" +
            "<h1>2. Mallorca, Spain</h1>" +
            "<h2>Recognized for its cathedral, beach resorts, Spanish cuisine, and a variety of luxury accommodations.</h2>"
            +
            "Enjoy the beautiful coastlines and immerse yourself in the rich cultural heritage of this stunning island.<br><br>"
            +
            "<a href='https://ryanshatch.com'>Book Here!</a>",
        new ImageIcon(getClass().getResource("/resources/Spain.jpg")));

    // Sicily, Italy
    addDestinationNameAndPicture(
        "<html><div style='text-align: center;'>" +
            "<h1>3. Sicily, Italy</h1>" +
            "<h2>Known for the UNESCO World Heritage sites, rich architecture, the Noto Valley.</h2>" +
            "Explore the ancient ruins and savor the exquisite Sicilian cuisine in this Mediterranean paradise.<br><br>"
            +
            "<a href='https://ryanshatch.com'>Book Here!</a>",
        new ImageIcon(getClass().getResource("/resources/Italy.jpg")));

    // The Isle of Skye, Scotland
    addDestinationNameAndPicture(
        "<html><div style='text-align: center;'>" +
            "<h1>4. The Isle of Skye, Scotland</h1>" +
            "<h2>Offers breathtaking landscapes, historical sites, and accommodations like pod hotels and traditional lodges.</h2>"
            +
            "Discover the rugged beauty of Skye and the rich Gaelic culture that pervades this mystical island.<br><br>"
            +
            "<a href='https://ryanshatch.com'>Book Here!</a>",
        new ImageIcon(getClass().getResource("/resources/Scotland.jpg")));

    // Nice, France
    addDestinationNameAndPicture(
        "<html><div style='text-align: center;'>" +
            "<h1>5. Nice, France</h1>" +
            "<h2>Known for its eco-friendly transportation, flourishing old town district, new restaurants, and boutique hotels.</h2>"
            +
            "Experience the allure of the French Riviera with its stunning seaside promenades and vibrant cultural scene.<br><br>"
            +
            "<a href='https://ryanshatch.com'>Book Here!</a>",
        new ImageIcon(getClass().getResource("/resources/France.jpg")));

    imageLabel = new JLabel();
    textPane = new JTextPane();
    textPane.setContentType("text/html"); // Set the content type to HTML
    textPane.setEditable(false);
    textPane.setBackground(sandyBeige); // Set the background color for the text pane (this is the color of the text
    // area)
    textPane.setForeground(darkGrey); // Set the foreground (text) color for the text pane
    textPane.setFont(new Font("Arial", Font.PLAIN, 24)); // Set the font for the text pane
    textPane.setMargin(new Insets(10, 10, 10, 10)); // Set the margins for the text pane (top, left, bottom, right)
    setLayout(new BorderLayout());
    // add a label and text pane to the frame
    add(nameLabel, BorderLayout.NORTH); // Add the label to the frame (by default, it's in the center
    add(imageLabel, BorderLayout.CENTER); // Add the text pane to the frame
    add(textPane, BorderLayout.SOUTH); // Add the text pane to the frame

    // add naviagation buttons with color customization
    addNavigationButtons();

    // Initialize and start the slideshow timer
    slideshowTimer = new Timer(24000, new ActionListener() { // 24 seconds between slides (24,000 milliseconds)
      @Override
      public void actionPerformed(ActionEvent e) {
        showNextDestination();
      }
    });
    slideshowTimer.start(); // Start the timer

    initializeDestinations(); // Initialize the destinations list
    updateDestinationDisplay(); // Display the first destination immediately
  }

  private void showNextDestination() {
    currentIndex = (currentIndex + 1) % destinations.size(); // Increment the current index
    updateDestinationDisplay(); // Update the display
  }

  private void updateDestinationDisplay() {
    TextAndIcon current = destinations.get(currentIndex); // Get the current destination
    imageLabel.setIcon(current.getIcon()); // Set the icon for the current destination
    textPane.setText(current.getText()); // Set the text for the current destination
  }

  private void addDestinationNameAndPicture(String text, Icon icon) {
    destinations.add(new TextAndIcon(text, icon));
  }

  private void initializeDestinations() {

  }

  // Add each destination with its name and picture
  // 2 Antigua, Guatemala
  // addDestinationNameAndPicture(
  // "1. Antigua, Guatemala:<br><br>" +
  // "Celebrated for its well-preserved Spanish baroque architecture and a storied
  // past as a former colonial capital.<br>"
  // +
  // "Antigua is a UNESCO World Heritage site teeming with historical ruins and
  // vibrant cultural experiences.<br>"
  // +
  // "It is also acclaimed for its scenic coffee plantations and proximity to
  // majestic volcanoes.<br>" +
  // "<a href='https://ryanshatch.com'>Book Now!</a>",
  // new ImageIcon(getClass().getResource("/resources/Guatemala.jpg")));

  // // 1 Mallorca, Spain
  // addDestinationNameAndPicture(
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
  // "3. Sicily, Italy:<br><br>" +
  // "Known for the Noto Valley and the UNESCO World Heritage sites, rich
  // architecture, and from the show 'The White Lotus'.<br>"
  // +
  // "Explore the ancient ruins and savor the exquisite Sicilian cuisine in this
  // Mediterranean paradise.<br>" +
  // "<a href='https://ryanshatch.com'>Book Now!</a>",
  // new ImageIcon(getClass().getResource("/resources/Italy.jpg")));

  // // 4 The Isle of Skye, Scotland
  // addDestinationNameAndPicture(
  // "4. The Isle of Skye, Scotland:<br><br>" +
  // "Offers breathtaking landscapes, historical sites, and unique accommodations
  // like pod hotels and traditional lodges.<br>"
  // +
  // "Discover the rugged beauty of Skye and the rich Gaelic culture that pervades
  // this mystical island.<br>" +
  // "<a href='https://ryanshatch.com'>Book Now!</a>",
  // new ImageIcon(getClass().getResource("/resources/Scotland.jpg")));

  // // 5 Nice, France
  // addDestinationNameAndPicture(
  // "5. Nice, France:<br><br>" +
  // "Stands out for its eco-friendly transportation, pedestrian streets,
  // flourishing old town district, new restaurants, and boutique hotels.<br>"
  // +
  // "Experience the allure of the French Riviera with its stunning seaside
  // promenades and vibrant cultural scene.<br>"
  // +
  // "<a href='https://ryanshatch.com'>Book Now!</a>",
  // new ImageIcon(getClass().getResource("/resources/France.jpg")));
  // addDestinationNameAndPicture("Paris, France", new
  // ImageIcon("src/resources/paris.jpg"));
  // addDestinationNameAndPicture("Rome, Italy", new
  // ImageIcon("src/resources/rome.jpg"));
  // addDestinationNameAndPicture("Sydney, Australia", new
  // ImageIcon("src/resources/sydney.jpg"));
  // addDestinationNameAndPicture("Tokyo, Japan", new
  // ImageIcon("src/resources/tokyo.jpg"));
  // addDestinationNameAndPicture("New York City, USA", new
  // ImageIcon("src/resources/newyork.jpg"));

  private void addNavigationButtons() {
    // Create two separate panels for the buttons
    JPanel westPanel = new JPanel(); // Panel for the "Back" button
    JPanel eastPanel = new JPanel(); // Panel for the "Next" button

    Color deepSkyBlue = new Color(0, 191, 255); // RGB values for deep sky blue
    Color terracotta = new Color(226, 114, 91); // RGB for Terracotta
    Color forestGreen = new Color(34, 139, 34); // RGB for Forest Green
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
    prevButton.setForeground(white); // Set the foreground (text) color for the button
    nextButton.setBackground(warmOrange); // Set the background color for the button
    nextButton.setForeground(white); // Set the foreground (text) color for the button
    // set the border for the buttons (thickness and color)
    prevButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    nextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

    // Use the accent color for the buttons
    prevButton.setBackground(terracotta); // Set the background color for the button
    prevButton.setForeground(Color.WHITE); // Set the foreground (text) color for the button
    nextButton.setBackground(forestGreen); // Set the background color for the button
    nextButton.setForeground(Color.WHITE); // Set the foreground (text) color for the button

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
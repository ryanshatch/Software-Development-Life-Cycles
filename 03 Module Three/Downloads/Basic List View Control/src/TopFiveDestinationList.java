// ****************************************************************************************
// Title: Travel List          |***********************************************************
// Developed by: Ryan Hatch    |***********************************************************
// Last Updated: Nov 8th 2023  |***********************************************************
// Version: 1.0                |***********************************************************
// ****************************************************************************************

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList { // main class

  // private static final int MAX_WIDTH = 300; // Maximum width in pixels for the
  // text

  public static void main(String[] args) { // This is the main method
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
        topDestinationListFrame.setTitle("Top 5 Destinations"); // This is the title of the frame
        topDestinationListFrame.setVisible(true);
      }
    });
  }
}

class TopDestinationListFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  // private static final Object MAX_WIDTH = null;
  private DefaultListModel<TextAndIcon> listModel;

  public TopDestinationListFrame() {
    super("Top Five Destination List");

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(900, 750); // This is the size of the frame
    setLocationRelativeTo(null); // This centers the frame on the screen

    // Create a label with my name
    JLabel nameLabel = new JLabel("Ryan Hatch");
    nameLabel.setHorizontalAlignment(JLabel.CENTER); // Center the label horizontally
    nameLabel.setVerticalAlignment(JLabel.TOP); // Align the label to the top of its display area
    nameLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set the font for the label
    nameLabel.setForeground(Color.DARK_GRAY); // Set the foreground (text) color for the label
    nameLabel.setBackground(Color.CYAN); // Set the background color for the label
    nameLabel.setOpaque(true); // Make the label opaque

    listModel = new DefaultListModel<>(); // List of destinations and pictures

    // 2 Antigua, Guatemala
    addDestinationNameAndPicture(
        "1. Antigua, Guatemala:<br><br>" +
            "Celebrated for its well-preserved Spanish baroque architecture and a storied past as a former colonial capital.<br>"
            +
            "Antigua is a UNESCO World Heritage site teeming with historical ruins and vibrant cultural experiences.<br>"
            +
            "It is also acclaimed for its scenic coffee plantations and proximity to majestic volcanoes.<br>" +
            "<a href='https://ryanshatch.com'>Book Now!</a>",
        new ImageIcon(getClass().getResource("/resources/Guatemala.jpg")));

    // 1 Mallorca, Spain
    addDestinationNameAndPicture(
        "2. Mallorca, Spain:<br><br>" +
            "Recognized for its impressive cathedral, vibrant beach resorts, amazing Spanish cuisine, and a variety of luxury accommodations.<br>"
            +
            "Enjoy the beautiful coastlines and immerse yourself in the rich cultural heritage of this stunning island.<br>"
            +
            "<a href='https://ryanshatch.com'>Book Now!</a>",
        new ImageIcon(getClass().getResource("/resources/Spain.jpg")));

    // 3 Sicily, Italy
    addDestinationNameAndPicture(
        "3. Sicily, Italy:<br><br>" +
            "Known for the Noto Valley and the UNESCO World Heritage sites, rich architecture, and from the show 'The White Lotus'.<br>"
            +
            "Explore the ancient ruins and savor the exquisite Sicilian cuisine in this Mediterranean paradise.<br>" +
            "<a href='https://ryanshatch.com'>Book Now!</a>",
        new ImageIcon(getClass().getResource("/resources/Italy.jpg")));

    // 4 The Isle of Skye, Scotland
    addDestinationNameAndPicture(
        "4. The Isle of Skye, Scotland:<br><br>" +
            "Offers breathtaking landscapes, historical sites, and unique accommodations like pod hotels and traditional lodges.<br>"
            +
            "Discover the rugged beauty of Skye and the rich Gaelic culture that pervades this mystical island.<br>" +
            "<a href='https://ryanshatch.com'>Book Now!</a>",
        new ImageIcon(getClass().getResource("/resources/Scotland.jpg")));

    // 5 Nice, France
    addDestinationNameAndPicture(
        "5. Nice, France:<br><br>" +
            "Stands out for its eco-friendly transportation, pedestrian streets, flourishing old town district, new restaurants, and boutique hotels.<br>"
            +
            "Experience the allure of the French Riviera with its stunning seaside promenades and vibrant cultural scene.<br>"
            +
            "<a href='https://ryanshatch.com'>Book Now!</a>",
        new ImageIcon(getClass().getResource("/resources/France.jpg")));

    JList<TextAndIcon> list = new JList<>(listModel);
    JScrollPane scrollPane = new JScrollPane(list);

    TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

    list.setCellRenderer(renderer);

    getContentPane().add(nameLabel, BorderLayout.NORTH);
    getContentPane().add(scrollPane, BorderLayout.CENTER);
  }

  private void addDestinationNameAndPicture(String text, Icon icon) {
    int MAX_WIDTH = 700; // Maximum width in pixels for the text
    String formattedText = String.format(
        "<html><center><div style='width: %dpx; word-wrap: break-word;'>%s</div></center></html>",
        MAX_WIDTH, text); // This is the text that will be displayed and formatted to fit the frame
    TextAndIcon tai = new TextAndIcon(formattedText, icon);
    listModel.addElement(tai);
  }
}

class TextAndIcon {
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

class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer<TextAndIcon> {

  private static final long serialVersionUID = 1L;
  private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
  private Border insideBorder;

  // Custom colors for list items

  // private static final Color BACKGROUND_COLOR = new Color(240, 240, 240); //
  // Light gray background
  private static final Color BACKGROUND_COLOR = new Color(120, 240, 120); // Light green background
  private static final Color SELECTED_BACKGROUND_COLOR = new Color(0, 120, 0); // A dark green shade for selection
  private static final Color SELECTED_TEXT_COLOR = Color.WHITE; // White text for selection

  public TextAndIconListCellRenderer(int padding) {
    insideBorder = BorderFactory.createEmptyBorder(padding, padding, padding, padding);
    setOpaque(true); // This is the background color

    // Custom font for the list items
    setFont(new Font("Arial", Font.BOLD, 14)); // This is the font type, style, and size
  }

  public Component getListCellRendererComponent(JList<? extends TextAndIcon> list, TextAndIcon value,
      int index, boolean isSelected, boolean cellHasFocus) {
    setText(value.getText());
    setIcon(value.getIcon());

    if (isSelected) {
      setBackground(SELECTED_BACKGROUND_COLOR);
      setForeground(SELECTED_TEXT_COLOR);
    } else {
      setBackground(BACKGROUND_COLOR);
      setForeground(list.getForeground());
    }

    Border outsideBorder = cellHasFocus ? UIManager.getBorder("List.focusCellHighlightBorder") : NO_FOCUS_BORDER;
    setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));

    setHorizontalAlignment(CENTER);
    setVerticalAlignment(CENTER);
    setHorizontalTextPosition(TRAILING);
    setVerticalTextPosition(CENTER);

    return this;
  }

  // Overridden methods for performance
  public void validate() {
  }

  public void invalidate() {
  }

  public void repaint() {
  }

  public void revalidate() {
  }

  public void repaint(long tm, int x, int y, int width, int height) {
  }

  public void repaint(Rectangle r) {
  }
}
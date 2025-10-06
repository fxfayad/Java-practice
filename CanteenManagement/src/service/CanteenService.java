package service;

import model.MenuItem;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CanteenService extends JFrame {

    private final List<MenuItem> menu = new ArrayList<>();
    private final List<MenuItem> cart = new ArrayList<>();
    private final DefaultListModel<String> cartModel = new DefaultListModel<>();
    private final JLabel totalLabel = new JLabel("Total: 0 Taka");

    public CanteenService() {
        loadMenu();
        initUI();
    }

    private void loadMenu() {
        menu.add(new MenuItem("Burger", 120));
        menu.add(new MenuItem("Sandwich", 80));
        menu.add(new MenuItem("Tea", 20));
        menu.add(new MenuItem("Coffee", 30));
        menu.add(new MenuItem("Pizza", 250));
        menu.add(new MenuItem("Pasta", 180));
        menu.add(new MenuItem("Fried Rice", 150));
        menu.add(new MenuItem("Juice", 50));
    }

    private void initUI() {
        setTitle("University Canteen Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));


        JLabel heading = new JLabel("Welcome to University Canteen Menu", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 24));
        heading.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(heading, BorderLayout.NORTH);


        JPanel menuPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        for (MenuItem item : menu) menuPanel.add(createMenuCard(item));
        add(new JScrollPane(menuPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);


        JPanel cartPanel = new JPanel(new BorderLayout(10, 10));
        cartPanel.setPreferredSize(new Dimension(250, 0));
        cartPanel.setBorder(BorderFactory.createTitledBorder("Your Order"));

        JList<String> cartList = new JList<>(cartModel);
        cartPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(totalLabel);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton placeOrderBtn = new JButton("Place Order");
        placeOrderBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        placeOrderBtn.addActionListener(e -> showBill());
        bottomPanel.add(placeOrderBtn);

        cartPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(cartPanel, BorderLayout.EAST);

        setVisible(true);
    }


    private JPanel createMenuCard(MenuItem item) {
        JPanel card = new JPanel(new BorderLayout(5, 5));
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // black border

        JLabel nameLabel = new JLabel(item.getName(), SwingConstants.CENTER);
        JLabel priceLabel = new JLabel(item.getPrice() + " Taka", SwingConstants.CENTER);

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(e -> addToCart(item));

        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.add(nameLabel);
        centerPanel.add(priceLabel);

        card.add(centerPanel, BorderLayout.CENTER);
        card.add(addBtn, BorderLayout.SOUTH);

        return card;
    }

    private void addToCart(MenuItem item) {
        cart.add(item);
        cartModel.addElement(item.getName() + " - " + item.getPrice() + " Taka");
        updateTotal();
    }

    private void updateTotal() {
        double total = cart.stream().mapToDouble(MenuItem::getPrice).sum();
        totalLabel.setText("Total: " + total + " Taka");
    }

    private void showBill() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No items in your order.", "Empty Cart",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder bill = new StringBuilder("===== YOUR BILL =====\n");
        double total = 0;
        for (MenuItem item : cart) {
            bill.append(item.getName()).append(" - ").append(item.getPrice()).append(" Taka\n");
            total += item.getPrice();
        }
        bill.append("\nTotal: ").append(total).append(" Taka");

        JOptionPane.showMessageDialog(this, bill.toString(), "Bill Summary", JOptionPane.INFORMATION_MESSAGE);
        cart.clear();
        cartModel.clear();
        updateTotal();
    }
}

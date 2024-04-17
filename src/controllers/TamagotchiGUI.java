package src.controllers;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;
import java.util.Map;
import src.services.PetService;
import src.models.Pet;
import src.enums.Status;

public class TamagotchiGUI extends JFrame {

    private Pet pet;
    private PetService petService;
    private JLabel statusLabel;
    private Map<Status, Integer> previousStatusValues = new EnumMap<>(Status.class);

    public TamagotchiGUI(Pet pet) {
        this.pet = pet;
        this.petService = new PetService(pet);
        setTitle("Tamagotchi Game");
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(createButton("Feed Pet", new Color(102, 204, 255)));
        buttonPanel.add(createButton("Play with Pet", new Color(255, 178, 102)));
        buttonPanel.add(createButton("Clean Pet", new Color(153, 255, 153)));
        buttonPanel.add(createButton("Rest Pet", new Color(255, 204, 229)));
        buttonPanel.add(createButton("Show Pet Status", new Color(255, 255, 153)));

        add(buttonPanel, BorderLayout.NORTH);

        // Status Label
        statusLabel = createStatusLabel();
        updateStatusLabel(); // Para inicializar com os valores atuais
        add(statusLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.addActionListener(e -> performAction(text));
        return button;
    }

    private JLabel createStatusLabel() {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        return label;
    }

    private void performAction(String command) {
        switch (command) {
            case "Feed Pet":
                petService.feedPet();
                break;
            case "Play with Pet":
                petService.playWithPet();
                break;
            case "Clean Pet":
                petService.cleanPet();
                break;
            case "Rest Pet":
                petService.restPet();
                break;
            case "Show Pet Status":
                // Pode ser necessário apenas chamar o updateStatusLabel se os status são automaticamente atualizados
                break;
        }
        updateStatusLabel(); // Atualizar status após cada ação
    }

    private void updateStatusLabel() {
        StringBuilder statusText = new StringBuilder("<html><h2>Status do Pet:</h2>");
        for (Status status : Status.values()) {
            int currentValue = pet.getStatusValues().get(status);
            int lastChange = previousStatusValues.getOrDefault(status, currentValue);
            int change = currentValue - lastChange;
            String changeString = change > 0 ? " (+" + change + ")" : (change < 0 ? " (" + change + ")" : "");

            statusText.append("<b>").append(status.getDescription()).append(":</b> ")
            .append("<span style='color:red;'>").append(currentValue)
            .append("</span>").append("<span style='color:blue;'>").append(changeString)
            .append("</span>").append("<br>");
            
            // Atualize o valor anterior para o próximo cálculo
            previousStatusValues.put(status, currentValue);
        }
        statusText.append("</html>");
        statusLabel.setText(statusText.toString());
    }
    
}

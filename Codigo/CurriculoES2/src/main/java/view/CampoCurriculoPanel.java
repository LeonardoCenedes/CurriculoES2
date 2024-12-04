package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CampoCurriculoPanel extends JPanel {

    public CampoCurriculoPanel(String titulo, String descricao, Runnable verPdfAction) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margens entre os componentes

        // Label para o título
        JLabel tituloLabel = new JLabel(titulo);
        tituloLabel.setPreferredSize(new Dimension(300, 20)); // Ajuste da largura
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        gbc.gridwidth = 1; // Apenas uma célula
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Expande no eixo horizontal
        add(tituloLabel, gbc);

        // Botão para visualizar o PDF
        JButton verPdfButton = new JButton("Ver PDF");
        verPdfButton.addActionListener(e -> verPdfAction.run());
        gbc.gridx = 1; // Coluna 1 (na mesma linha do título)
        gbc.gridy = 0; // Linha 0
        gbc.weightx = 0; // Não expande
        gbc.fill = GridBagConstraints.NONE; // Mantém o tamanho do botão
        add(verPdfButton, gbc);

        // TextArea para a descrição
        JTextArea descricaoTextArea = new JTextArea(descricao);
        descricaoTextArea.setLineWrap(true); // Quebra de linha automática
        descricaoTextArea.setWrapStyleWord(true);
        descricaoTextArea.setEditable(false); // Não editável
        JScrollPane scrollPane = new JScrollPane(descricaoTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(400, 80)); // Ajuste da altura

        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 1; // Linha 1 (abaixo do título e botão)
        gbc.gridwidth = 2; // Ocupa duas colunas
        gbc.fill = GridBagConstraints.BOTH; // Expande em ambas direções
        gbc.weightx = 1.0; // Expande horizontalmente
        gbc.weighty = 1.0; // Expande verticalmente
        add(scrollPane, gbc);

        // Configuração do painel
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    @Override
    public Dimension getPreferredSize() {
        // Garante tamanho consistente para cada painel de campo
        return new Dimension(500, 150); // Ajuste conforme necessário
    }
}

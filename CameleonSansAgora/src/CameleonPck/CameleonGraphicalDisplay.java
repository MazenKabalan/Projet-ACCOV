/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CameleonPck;

import java.awt.Color;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


/**
 * interface graphique JFrame pour afficher le comportement des cameleons
 * peut afficher le comportement au plus de neuf (9) cameleons
 * affiche la derniere mutation entre deux cameleons
 *
 * @author mazen
 */
public class CameleonGraphicalDisplay  extends JFrame {
	
	private JTextArea jTextArea1;
        private JTextArea jTextArea2;
        private JTextArea jTextArea3;
        private JTextArea jTextArea4;
        private JTextArea jTextArea5;
        private JTextArea jTextArea6;
        private JTextArea jTextArea7;
        private JTextArea jTextArea8;
        private JTextArea jTextArea9;
        private JTextArea jTextArea99;
        
    /**
     *
     */
    public CameleonGraphicalDisplay() {
		initComponents();

	}
        
    /**
     *
     * sert a mettre a jour :
     * 1- le statut (le comportement actuel du cameleon)
     * 2- le Font
     * 3- la bordure
     * de la place reserve sur l'interface pour un cameleon specific
     * 
     * @param textAreaId
     * @param s
     * @param c
     * @param f
     * @param borderThickness
     */
    public void setTextArea(int textAreaId, String s, int c, Font f, int borderThickness) {
            Color camColor = Color.BLUE;
            Border border = BorderFactory.createLineBorder(Color.BLACK,borderThickness);
                
            switch (c) {
                case 0:
                    camColor = Color.BLUE;
                    break;
                case 1:
                    camColor = Color.RED; 
                    break;
                case 2:
                    camColor = Color.YELLOW;
                    break;
                default:
                    break;
            }
            
 
            switch (textAreaId) {
                case 1:
                    jTextArea1.setText(s);
                    jTextArea1.setBackground(camColor);
                    jTextArea1.setFont(f);
                    jTextArea1.setBorder(BorderFactory.createCompoundBorder(border,
                           BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    break;
                case 2:
                    jTextArea2.setText(s);
                    jTextArea2.setBackground(camColor);
                    jTextArea2.setFont(f);
                    jTextArea2.setBorder(BorderFactory.createCompoundBorder(border,
                           BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    break;
                case 3:
                    jTextArea3.setText(s);
                    jTextArea3.setBackground(camColor);
                    jTextArea3.setFont(f);
                    jTextArea3.setBorder(BorderFactory.createCompoundBorder(border,
                           BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    break;
                case 4:
                    jTextArea4.setText(s);
                    jTextArea4.setBackground(camColor);
                    jTextArea4.setFont(f);
                    jTextArea4.setBorder(BorderFactory.createCompoundBorder(border,
                           BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    break;
                case 5:
                    jTextArea5.setText(s);
                    jTextArea5.setBackground(camColor);
                    jTextArea5.setFont(f);
                    jTextArea5.setBorder(BorderFactory.createCompoundBorder(border,
                           BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    break;
                case 6:
                    jTextArea6.setText(s);
                    jTextArea6.setBackground(camColor);
                    jTextArea6.setFont(f);
                    jTextArea6.setBorder(BorderFactory.createCompoundBorder(border,
                           BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    break;
                case 7:
                    jTextArea7.setText(s);
                    jTextArea7.setBackground(camColor);
                    jTextArea7.setFont(f);
                    jTextArea7.setBorder(BorderFactory.createCompoundBorder(border,
                           BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    break;
                case 8:
                    jTextArea8.setText(s);
                    jTextArea8.setBackground(camColor);
                    jTextArea8.setFont(f);
                    jTextArea8.setBorder(BorderFactory.createCompoundBorder(border,
                           BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    break;
                case 9:
                    jTextArea9.setText(s);
                    jTextArea9.setBackground(camColor);
                    jTextArea9.setFont(f);
                    jTextArea9.setBorder(BorderFactory.createCompoundBorder(border,
                           BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    break;
                case 99:
                    jTextArea99.setText(s);
                    jTextArea99.setBackground(camColor);
                    jTextArea99.setFont(f);
                    jTextArea99.setBorder(BorderFactory.createCompoundBorder(border,
                           BorderFactory.createEmptyBorder(10, 10, 10, 10)));
                    break;
                default:
                    break;
            }
                
	}

        /**
         * sert a initialiser et a definir l'interface
         */
	@SuppressWarnings("unchecked")
	private void initComponents() {
		
                int gapSize = 50;
                
                int textAreaWidth = 250;
                int textAreaHeight = 100;
                int mutationLabelSize = (textAreaWidth * 3) + (gapSize*4);
                
                jTextArea1 = new JTextArea();
                jTextArea2 = new JTextArea();
                jTextArea3 = new JTextArea();
                jTextArea4 = new JTextArea();
                jTextArea5 = new JTextArea();
                jTextArea6 = new JTextArea();
                jTextArea7 = new JTextArea();
                jTextArea8 = new JTextArea();
                jTextArea9 = new JTextArea();
                jTextArea99 = new JTextArea();
                
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jTextArea1.setEditable(false);
                jTextArea2.setEditable(false);
                jTextArea3.setEditable(false);
                jTextArea4.setEditable(false);
                jTextArea5.setEditable(false);
                jTextArea6.setEditable(false);
                jTextArea7.setEditable(false);
                jTextArea8.setEditable(false);
                jTextArea9.setEditable(false);
                jTextArea99.setEditable(false);
                
                Border border = BorderFactory.createLineBorder(Color.BLACK,0);

                jTextArea1.setText("");
                jTextArea1.setBackground(Color.WHITE);
                jTextArea1.setFont(new Font("Verdana", Font.PLAIN, Simulation.fontSize));
                jTextArea1.setBorder(BorderFactory.createCompoundBorder(border,
                       BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                jTextArea2.setText("");
                jTextArea2.setBackground(Color.WHITE);
                jTextArea2.setFont(new Font("Verdana", Font.PLAIN, Simulation.fontSize));
                jTextArea2.setBorder(BorderFactory.createCompoundBorder(border,
                       BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                jTextArea3.setText("");
                jTextArea3.setBackground(Color.WHITE);
                jTextArea3.setFont(new Font("Verdana", Font.PLAIN, Simulation.fontSize));
                jTextArea3.setBorder(BorderFactory.createCompoundBorder(border,
                       BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                jTextArea4.setText("");
                jTextArea4.setBackground(Color.WHITE);
                jTextArea4.setFont(new Font("Verdana", Font.PLAIN, Simulation.fontSize));
                jTextArea4.setBorder(BorderFactory.createCompoundBorder(border,
                       BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                jTextArea5.setText("");
                jTextArea5.setBackground(Color.WHITE);
                jTextArea5.setFont(new Font("Verdana", Font.PLAIN, Simulation.fontSize));
                jTextArea5.setBorder(BorderFactory.createCompoundBorder(border,
                       BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                jTextArea6.setText("");
                jTextArea6.setBackground(Color.WHITE);
                jTextArea6.setFont(new Font("Verdana", Font.PLAIN, Simulation.fontSize));
                jTextArea6.setBorder(BorderFactory.createCompoundBorder(border,
                       BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                jTextArea7.setText("");
                jTextArea7.setBackground(Color.WHITE);
                jTextArea7.setFont(new Font("Verdana", Font.PLAIN, Simulation.fontSize));
                jTextArea7.setBorder(BorderFactory.createCompoundBorder(border,
                       BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                jTextArea8.setText("");
                jTextArea8.setBackground(Color.WHITE);
                jTextArea8.setFont(new Font("Verdana", Font.PLAIN, Simulation.fontSize));
                jTextArea8.setBorder(BorderFactory.createCompoundBorder(border,
                       BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                jTextArea9.setText("");
                jTextArea9.setBackground(Color.WHITE);
                jTextArea9.setFont(new Font("Verdana", Font.PLAIN, Simulation.fontSize));
                jTextArea9.setBorder(BorderFactory.createCompoundBorder(border,
                       BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                jTextArea99.setText("");
                jTextArea99.setBackground(Color.WHITE);
                jTextArea99.setFont(new Font("Verdana", Font.PLAIN, Simulation.fontSize));
                jTextArea99.setBorder(BorderFactory.createCompoundBorder(border,
                       BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                    
                GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
                
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                	.addGap(gapSize)
					.addComponent(jTextArea99,GroupLayout.Alignment.LEADING, mutationLabelSize,mutationLabelSize,mutationLabelSize)
					.addGroup(layout.createSequentialGroup()
						.addGap(gapSize)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment. LEADING)
							.addComponent(jTextArea1, textAreaWidth, textAreaWidth, textAreaWidth)
							.addComponent(jTextArea2, textAreaWidth, textAreaWidth, textAreaWidth)
							.addComponent(jTextArea3, textAreaWidth, textAreaWidth, textAreaWidth))
						.addGap(gapSize)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(jTextArea4, textAreaWidth, textAreaWidth, textAreaWidth)
							.addComponent(jTextArea5, textAreaWidth, textAreaWidth, textAreaWidth)
							.addComponent(jTextArea6, textAreaWidth, textAreaWidth, textAreaWidth))
                                                .addGap(gapSize)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(jTextArea7, textAreaWidth, textAreaWidth, textAreaWidth)
							.addComponent(jTextArea8, textAreaWidth, textAreaWidth, textAreaWidth)
							.addComponent(jTextArea9, textAreaWidth, textAreaWidth, textAreaWidth))
                                                .addGap(gapSize)
						)
				         
                        );

                
                
		layout.setVerticalGroup(
                   layout.createSequentialGroup()
                      .addGap(gapSize)
		      .addComponent(jTextArea99)
		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addGroup(layout.createSequentialGroup()
				.addGap(gapSize)
			        //.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jTextArea1,textAreaHeight,textAreaHeight,textAreaHeight)
					.addComponent(jTextArea4,textAreaHeight,textAreaHeight,textAreaHeight)
					.addComponent(jTextArea7,textAreaHeight,textAreaHeight,textAreaHeight))
				.addGap(gapSize)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jTextArea2,textAreaHeight,textAreaHeight,textAreaHeight)
					.addComponent(jTextArea5,textAreaHeight,textAreaHeight,textAreaHeight)
					.addComponent(jTextArea8,textAreaHeight,textAreaHeight,textAreaHeight))
				.addGap(gapSize)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jTextArea3,textAreaHeight,textAreaHeight,textAreaHeight)
					.addComponent(jTextArea6,textAreaHeight,textAreaHeight,textAreaHeight)
					.addComponent(jTextArea9,textAreaHeight,textAreaHeight,textAreaHeight))
				.addGap(gapSize)
				)
		               )
                );

		pack();
	}



}

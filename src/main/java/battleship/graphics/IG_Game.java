package battleship.graphics;

import battleship.models.Boat;
import battleship.services.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IG_Game extends JFrame implements ActionListener{

	Sound sound = new Sound();
	// JFrame
    JFrame fgame = new JFrame("Navale Battle Game");

	// JPanel
    JPanel game_panel = new JPanel();
    JPanel player_panel = new JPanel();
    JPanel IA_panel = new JPanel();
    JPanel panel_deco = new JPanel();
    JPanel panel_background_player = new JPanel();
	JPanel panel_background_IA = new JPanel();

	// JLabel
    JLabel player_lb = new JLabel("Player 1");
    JLabel IA_lb = new JLabel("Player 2");
    JLabel status_game = new JLabel("Press 'START' to begin");

	// Icon
	Icon sea = new ImageIcon(new ImageIcon("src/main/java/battleship/images/sea.png").getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT));;
	Icon touch = new ImageIcon(new ImageIcon("src/main/java/battleship/images/touch.gif").getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT));
	Icon sank = new ImageIcon(new ImageIcon("src/main/java/battleship/images/sank.jpg").getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT));
	Icon missed = new ImageIcon(new ImageIcon("src/main/java/battleship/images/missed.gif").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
	Icon deco = new ImageIcon(new ImageIcon("src/main/java/battleship/images/deco.jpg").getImage().getScaledInstance(1980, 680, Image.SCALE_DEFAULT));

	// JButton
	JButton Grille1[]; // Déclaration du tableau (grille) pour le Player 1
    JButton Grille2[]; // Déclaration du tableau (grille) pour le Player 2
    JButton quit_button = new JButton("QUIT");
    JButton restart_button = new JButton("RESTART");
    JButton start_button = new JButton("START");

	// Initialisation des bateaux pour le P1
	private Boat torpedoBoatP1;
	private Boat submarinP1;
	private Boat destroyerP1;
	private Boat cruiserP1;
	private Boat aircraftCarrierP1;

	// Initialisation des bateaux pour le P2
	private Boat torpedoBoatP2;
	private Boat submarinP2;
	private Boat destroyerP2;
	private Boat cruiserP2;
	private Boat aircraftBoat2;

	int counter1 = 0; // Compteur de bateau(x) coulé(s) pour le Player 1
	int counter2 = 0; // Compteur de bateau(x) coulé(s) pour le Player 2

    private static final long serialVersionUID = 1L;

	// Méthode pour la création de la page IG_Game
    public void createGame() {
        fgame.setVisible(true);
        fgame.setResizable(true);
        fgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane_game(fgame.getContentPane());
        fgame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

	// Création des éléments sur la page IG_Game
    private void addComponentsToPane_game(Container pane_game) {
        pane_game.setLayout(null);

        player_lb.setBounds(350, 40, 100, 25);
        player_lb.setFont(new Font("TimesRoman", Font.BOLD, 24));
        
        IA_lb.setBounds(950, 40, 100, 25);
        IA_lb.setFont(new Font("TimesRoman", Font.BOLD, 24));

        game_panel.setBackground(Color.lightGray);

        game_panel.setBounds(0, 0, 1920, 100);



       // panel_deco.setBackground (new ImageIcon("deco.jpg"));
        panel_deco.setBounds(0, 100,1920, 980 );


        status_game.setBounds(550, 40, 300, 25);////////////////////+++++++++++++++
        status_game.setFont(new Font("TimesRoman", Font.BOLD, 24));
		status_game.setVisible(true);

        player_panel.setBounds(30, 120, 560, 400);
        IA_panel.setBounds(700, 120, 560, 400);
		panel_background_IA.setBackground(Color.white);
		panel_background_IA.setBounds(695, 115, 570, 410 );

		panel_background_player.setBackground(Color.white);
		panel_background_player.setBounds(25, 115, 570, 410 );

		start_button.setBounds(280, 570,150,60);
        start_button.setBackground(Color.GREEN);
        restart_button.setBounds(580, 570,150,60);
        quit_button.setBounds(880, 570,150,60);

        start_button.addActionListener(this);
        restart_button.addActionListener(this);
        quit_button.addActionListener(this);

        pane_game.add(start_button);
        pane_game.add(restart_button);
        pane_game.add(quit_button);
        pane_game.add(player_lb);
        pane_game.add(IA_lb);
        pane_game.add(status_game);
        pane_game.add(game_panel);
        pane_game.add(player_panel);
        pane_game.add(IA_panel);
        pane_game.add(panel_background_player);
        pane_game.add(panel_background_IA);

        JLabel image = new JLabel(deco);
		panel_deco.add(image);
        pane_game.add(panel_deco);

        Grille1 = new JButton[100]; // Initialisation du tableau (grille) pour le Player 1
        Grille2 = new JButton[100]; // Initialisation du tableau (grille) pour le Player 2

        player_panel.setLayout(new GridLayout(10,10));
        IA_panel.setLayout(new GridLayout(10,10));

		// Boucle - création des boutons (nom, icone, etc) dans le tableau pour le Player 1
        for(int i = 0; i <= 99; i++)
        {
            Grille1[i] = new JButton(""); // Déclare un nouveau bouton
            Grille1[i].setName(""+(i+1)); // Lui donne un nom [i] (indice du tableau + 1)
			Grille1[i].setIcon(sea); // Lui donne une icone comme fond
			Grille1[i].setActionCommand("Grille1"+i); // Commande pour l'événement d'action déclenché
            Grille1[i].addActionListener(this); // Déclare un listener sur le bouton
			player_panel.add(Grille1[i]); // L'ajoute au panel
        }

		// Boucle - création des boutons (nom, icone, etc) dans le tableau pour le Player 2
        for(int i = 0; i <= 99; i++)
        {
            Grille2[i] = new JButton("" ); 
            Grille2[i].setName(""+((i+101)));
			Grille2[i].setIcon(sea); 
			Grille2[i].setActionCommand("Grille2"+i); 
			Grille2[i].addActionListener(this); 
            IA_panel.add(Grille2[i]);
        }
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		
		int tabl[] = null;
		int tabl2[] = null;

		// 0 si bateau n'est pas touché 
		// 1 si le bateau est touché dans le plateau du Joueur 1
		// 2 si le bateau est touché dans le plateau du Joueur 2
		int state = 0;
		
		String ButtonRecovery = ((JButton) e.getSource()).getName() ;
		String actionButton = ((JButton) e.getSource()).getActionCommand() ;
		
		
		// Test si le bouton restart est utilisé
		if(actionButton.equals(restart_button.getActionCommand()))
		{
			IG_Game game = new IG_Game();
            game.createGame();
            this.fgame.setVisible(false);
		}
		else if(actionButton.equals(quit_button.getActionCommand()))
		{
            System.exit(0); // Ferme le programme
		} 
		
		// Test si le bouton start est utilisé
		else if(actionButton == start_button.getActionCommand()){
			start_button.setEnabled(false);
			status_game.setText("You can start playing");
			status_game.repaint(); // Méthode pour actualisé l'affichage
			sound.playSound();

			// Boucle pour l'ordre de jeu Player 1 -> Player 2 -> Player 1 etc..
			for(int i = 0; i <= 99; i++)
			{
				Grille1[i].setEnabled(true);
				Grille2[i].setEnabled(false);
			}
				// Initilisation des objets "BOAT" pour le P1 avec le nom + le nombre de cases
				torpedoBoatP1 = new Boat("torpedoBoatG2", 2);
				submarinP1 = new Boat("Sous-MarinG2", 3);
				destroyerP1 = new Boat("Contre-torpedoBoatG2", 3);
				cruiserP1 = new Boat("cruiserG2", 4);
				aircraftCarrierP1 = new Boat("Porte-AvionG2", 5);

				// Initilisation des objets "BOAT" pour le P2 avec le nom + le nombre de cases
				torpedoBoatP2 = new Boat("torpedoBoat", 2);
				submarinP2 = new Boat("Sous-Marin", 3);
				destroyerP2 = new Boat("Contre-torpedoBoat", 3);
				cruiserP2 = new Boat("cruiser", 4);
				aircraftBoat2 = new Boat("Porte-Avion", 5);
				
                //Positions des bateaux pour le Player 1
				torpedoBoatP1.SetPosition(158);
				torpedoBoatP1.SetPosition(159);

				submarinP1.SetPosition(116);
				submarinP1.SetPosition(117);
				submarinP1.SetPosition(118);
				
				destroyerP1.SetPosition(186);
				destroyerP1.SetPosition(187);
				destroyerP1.SetPosition(188);
				
				cruiserP1.SetPosition(131);
				cruiserP1.SetPosition(132);
				cruiserP1.SetPosition(133);
				cruiserP1.SetPosition(134);
				
				aircraftCarrierP1.SetPosition(151);
				aircraftCarrierP1.SetPosition(161);
				aircraftCarrierP1.SetPosition(171);
				aircraftCarrierP1.SetPosition(181);
				aircraftCarrierP1.SetPosition(191);

                //Positions des bateaux pour le Player 2
				torpedoBoatP2.SetPosition(95);
				torpedoBoatP2.SetPosition(96);
				
				submarinP2.SetPosition(1);
				submarinP2.SetPosition(2);
				submarinP2.SetPosition(3);
				
				destroyerP2.SetPosition(29);
				destroyerP2.SetPosition(39);
				destroyerP2.SetPosition(49);
				
				cruiserP2.SetPosition(33);
				cruiserP2.SetPosition(34);
				cruiserP2.SetPosition(35);
				cruiserP2.SetPosition(36);
				
				aircraftBoat2.SetPosition(70);
				aircraftBoat2.SetPosition(71);
				aircraftBoat2.SetPosition(72);
				aircraftBoat2.SetPosition(73);
				aircraftBoat2.SetPosition(74);
				
				// Change de joueur
				for (int i=0; i<=99; i++)
				{
					Grille2[i].setEnabled(false);
				}
		}
		
		else
		{
			int nameBtnPress = Integer.parseInt(ButtonRecovery);
			nameBtnPress = (nameBtnPress-1);
			
			// test si le bouton appuyer est une case
			if(nameBtnPress<=199 && nameBtnPress>=0)
			{
				// Test si le bouton appuyer fait partie du tableau Player 1
				if(nameBtnPress<=99 && nameBtnPress>=0)
				{
					// Donne la valeur lors d'un clique pour pouvoir l'attribuer à un bateau
					//System.out.println(" " + (nameBtnPress + 100));
	
						for (int i=0; i<=99; i++)
						{
							Grille2[i].setEnabled(true);
							Grille1[i].setEnabled(false);
						}
						if (torpedoBoatP1.testPosition(nameBtnPress + 100) > 1){
							Grille1[nameBtnPress].setIcon(touch);
							Grille1[nameBtnPress].repaint();
							if (torpedoBoatP1.addTouch()){
								tabl = new int[torpedoBoatP1.getValue()];
								tabl = torpedoBoatP1.getPositions();
								state = 1;
							}
						}
						else if (submarinP1.testPosition(nameBtnPress + 100) > 1){
							Grille1[nameBtnPress].setIcon(touch);
							Grille1[nameBtnPress].repaint();
							if (submarinP1.addTouch()){
								tabl = new int[submarinP1.getValue()];
								tabl = submarinP1.getPositions();
								state = 1;
							}
						}
						else if (destroyerP1.testPosition(nameBtnPress + 100) > 1){
							Grille1[nameBtnPress].setIcon(touch);
							Grille1[nameBtnPress].repaint();
							if (destroyerP1.addTouch()){
								tabl = new int[destroyerP1.getValue()];
								tabl = destroyerP1.getPositions();
								state = 1;
							}
						}
						else if (cruiserP1.testPosition(nameBtnPress + 100) > 1){
							Grille1[nameBtnPress].setIcon(touch);
							Grille1[nameBtnPress].repaint();
							if (cruiserP1.addTouch()){
								tabl = new int[cruiserP1.getValue()];
								tabl = cruiserP1.getPositions();
								state = 1;
							}
						}
						else if (aircraftCarrierP1.testPosition(nameBtnPress + 100) > 1){
							Grille1[nameBtnPress].setIcon(touch);
							Grille1[nameBtnPress].repaint();
							if (aircraftCarrierP1.addTouch()){
								tabl = new int[aircraftCarrierP1.getValue()];
								tabl = aircraftCarrierP1.getPositions();
								state = 1;
							}
						}
						else{ 
							Grille1[nameBtnPress].setIcon(missed);
							Grille1[nameBtnPress].repaint();
						}
					if(state == 1){
						counter1++;
						for(int i = 0; i < tabl.length; i++){
							Grille1[tabl[i] - 100].setIcon(sank);
							Grille1[tabl[i] - 100].repaint();
						}
					}
					if (counter1 == 5){
						status_game.setText("PLAYER 1 WIN !");
						status_game.setBackground(Color.GREEN);
						status_game.repaint();
						start_button.setEnabled(false);
						start_button.setBackground(Color.RED);
						restart_button.setBackground(Color.GREEN);
						for(int i = 0; i <= 99; i++){
							Grille1[i].setEnabled(false);
							Grille2[i].setEnabled(false);
						}
					}
				}
				else
				{
					//test si le bouton appuyer fait partie du deuxieme tableau
					if(nameBtnPress<=199 && nameBtnPress>=100){
						
						// Donne la valeur lors d'un clique pour pouvoir l'attribuer à un bateau
						// System.out.println(" " + (nameBtnPress - 100))						
							for (int i=0; i<=99; i++)
							{
								Grille2[i].setEnabled(false);
								Grille1[i].setEnabled(true);
							}
							if (torpedoBoatP2.testPosition(nameBtnPress - 100) > 1){
								Grille2[nameBtnPress - 100].setIcon(sank);
								Grille2[nameBtnPress - 100].repaint();
								if (torpedoBoatP2.addTouch()){
									tabl2 = new int[torpedoBoatP2.getValue()];
									tabl2 = torpedoBoatP2.getPositions();
									state = 2;
								}
							}
							else if (submarinP2.testPosition(nameBtnPress - 100) > 1){
								Grille2[nameBtnPress - 100].setIcon(touch);
								Grille2[nameBtnPress - 100].repaint();
								if (submarinP2.addTouch()){
									tabl2 = new int[submarinP2.getValue()];
									tabl2 = submarinP2.getPositions();
									state = 2;
								}
							}
							else if (destroyerP2.testPosition(nameBtnPress - 100) > 1){
								Grille2[nameBtnPress - 100].setIcon(touch);
								Grille2[nameBtnPress - 100].repaint();
								if (destroyerP2.addTouch()){
									tabl2 = new int[destroyerP2.getValue()];
									tabl2 = destroyerP2.getPositions();
									state = 2;
								}
							}
							else if (cruiserP2.testPosition(nameBtnPress - 100) > 1){
								Grille2[nameBtnPress - 100].setIcon(touch);
								Grille2[nameBtnPress - 100].repaint();
								if (cruiserP2.addTouch()){
									tabl2 = new int[cruiserP2.getValue()];
									tabl2 = cruiserP2.getPositions();
									state = 2;
								}
							}
							else if (aircraftBoat2.testPosition(nameBtnPress - 100) > 1){
								Grille2[nameBtnPress - 100].setIcon(touch);
								Grille2[nameBtnPress - 100].repaint();
								if (aircraftBoat2.addTouch()){
									tabl2 = new int[aircraftBoat2.getValue()];
									tabl2 = aircraftBoat2.getPositions();
									state = 2;
								}
							}
							else {
								Grille2[nameBtnPress - 100].setIcon(missed);
								Grille2[nameBtnPress - 100].repaint();
							}
						if(state == 2){
							// counter2++;
							for(int j = 0; j < tabl2.length; j++){
								Grille2[tabl2[j]].setIcon(sank);
								Grille2[tabl2[j]].repaint();
							}
						}
						if (counter2 == 5){
							status_game.setText("PLAYER 2 WIN !");
							status_game.setBackground(Color.GREEN);
							status_game.repaint();
							start_button.setEnabled(false);
							start_button.setBackground(Color.RED);
							restart_button.setBackground(Color.GREEN);
							for(int i = 0; i <= 99; i++){
								Grille1[i].setEnabled(false);
								Grille2[i].setEnabled(false);
							}
						}
				}
			}
		}
	}
}
}
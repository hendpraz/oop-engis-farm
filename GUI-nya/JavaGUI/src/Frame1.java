import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class Frame1 {

	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Frame1() {
		initialize();
	}

	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 616, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		///SETUP
		////HardCode
		int Brs = 10 , Kol = 9 ;
		
		//Tanpa Hewan
		StringBuilder file = new StringBuilder() ;
		
		file.append("Wxxxxx***") ;
	 	file.append("*xxxxx***") ;
	 	file.append("*xxxxxxxx") ;
	 	file.append("----=+---") ;
		file.append("----=+---") ;
		file.append("---+#M---") ;
		file.append("T+===#===") ;
		file.append("==##=#===") ;
		file.append("===###=#=") ;
		file.append("==####===") ;

		//Count Object
		int n_Barn = 0, n_Grassland = 0, n_Coop = 0 , n_Mixer = 0 , n_Well = 0 , n_Truck = 0 ;
		
		int n = file.length(); 
	    char[] char_array = new char[n]; 
	    
	    //strcpy(char_array, file.c_str() ); 
	    for(int i = 0; i < file.length(); i++){
			char_array[i] = file.charAt(i);
		}
	    
	    for (int i = 0; i < n; i++) {
	    	if ( char_array[i] == 'x' || char_array[i] == '*' ) {
	    		n_Barn += 1 ;
	    	} else if ( char_array[i] == '-' || char_array[i] == '+' ) {
	    		n_Grassland  += 1 ;
	    	} else if ( char_array[i] == '=' || char_array[i] == '#' ) {
	    		n_Coop += 1 ;
	    	} else if ( char_array[i] == 'M'  ) {
	    		n_Mixer += 1 ;
	    	} else if ( char_array[i] == 'W'  ) {
	    		n_Well += 1 ;
	    	} else if ( char_array[i] == 'T'  ) {
	    		n_Truck += 1 ;
	    	}
	    }
		
		Barn[] g_barn = new Barn[n_Barn] ;
		Grassland[] g_grassland = new Grassland [n_Grassland] ;
		Coop[] g_coop = new Coop [n_Coop] ;
		Mixer[] g_mixer = new Mixer [n_Mixer] ;
		Well[] g_well = new Well [n_Well] ;
		Truck[] g_truck = new Truck[n_Truck] ;
		
		///Create Map
		Map gmap = new Map (Brs,Kol) ;	
		
		///SET Map		
		int iterator_file = 0 ;
	
		int iterator_barn = 0 ;
		int iterator_grassland = 0 ;
		int iterator_mixer = 0 ;
		int iterator_well = 0 ;
		int iterator_truck = 0 ;		
		int iterator_coop = 0 ;	
		
		for(int i = 0 ; i < gmap.getWidth() ; i ++ ){
			for(int j = 0 ; j < gmap.getHeight() ; j ++ ){	
					switch(char_array[iterator_file]) {
					case 'x' :
						g_barn[iterator_barn] = new Barn();
						g_barn[iterator_barn].setGrass(false) ;
						gmap.setCell(i,j,g_barn[iterator_barn] ) ;
						iterator_barn += 1 ;
						break ;
					case '*' :
						g_barn[iterator_barn] = new Barn();
						g_barn[iterator_barn].setGrass(true) ;
						gmap.setCell(i,j,g_barn[iterator_barn] ) ;
						iterator_barn += 1 ;
						break ;	
					case '-' :
						g_grassland[iterator_grassland] = new Grassland();
						g_grassland[iterator_grassland].setGrass(false) ;
						gmap.setCell(i,j,g_grassland[iterator_grassland] ) ;
						iterator_grassland += 1 ;
						break ;	
					case '+' :
						g_grassland[iterator_grassland] = new Grassland();
						g_grassland[iterator_grassland].setGrass(true) ;
						gmap.setCell(i,j,g_grassland[iterator_grassland] ) ;
						iterator_grassland += 1 ;
						break ;
					case '=' :
						g_coop[iterator_coop] = new Coop();
						g_coop[iterator_coop].setGrass(false) ;
						gmap.setCell(i,j,g_coop[iterator_coop] ) ;
						iterator_coop += 1 ;
						break ;	
					case '#' :
						g_coop[iterator_coop] = new Coop();
						g_coop[iterator_coop].setGrass(true) ;
						gmap.setCell(i,j,g_coop[iterator_coop] ) ;
						iterator_coop += 1 ;
						break ;	
					case 'W' :
						g_well[iterator_well] = new Well();
						gmap.setCell(i,j,g_well[iterator_well] ) ;
						iterator_well += 1 ;
						break ;	
					case 'M' :
						g_mixer[iterator_mixer] = new Mixer();
						gmap.setCell(i,j,g_mixer[iterator_mixer] ) ;
						iterator_mixer += 1 ;
						break ;	
					case 'T' :
						g_truck[iterator_truck] = new Truck();
						gmap.setCell(i,j,g_truck[iterator_truck] ) ;
						iterator_truck += 1 ;
						break ;	
						
					default :
						break ;	
					}
								
				iterator_file += 1 ;			
			}
		}
		
		player = new Player();
		int BrsPlayer = 1 , KolPlayer = 1 ;
		
		c = new Chicken();	
		int BrsChicken = 0 , KolChicken = 4 ;
		
		///Setting Player And Animal
		c.setMap(gmap) ;
		c.setPosisi(BrsChicken,KolChicken) ;	
		c.getMap().getCell(c.getPosBaris() , c.getPosKolom() ).setCreation(c) ;
		
		player.setMap(gmap) ;	
		player.setPosisi(BrsPlayer,KolPlayer) ;	
		player.getMap().getCell(player.getPosBaris() , player.getPosKolom() ).setCreation(player) ;
		
		
		JButton btnAtas = new JButton("ATAS");
		btnAtas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.Bergerak(1) ;
				Update() ;
				Render(Brs,Kol) ;				
			}
		});
		btnAtas.setBounds(346, 91, 94, 23);		
		frame.getContentPane().add(btnAtas);
	
		JButton btnBawah = new JButton("BAWAH");
		btnBawah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.Bergerak(3) ;
				Update() ;
				Render(Brs,Kol) ;
			}
		});
		btnBawah.setBounds(346, 159, 94, 23);		
		frame.getContentPane().add(btnBawah);
		
		JButton btnKanan = new JButton("KANAN");
		btnKanan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.Bergerak(2) ;
				Update() ;
				Render(Brs,Kol) ;
			}
		});
		btnKanan.setBounds(391, 125, 94, 23);		
		frame.getContentPane().add(btnKanan);
		
		JButton btnKiri = new JButton("KIRI");
		btnKiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.Bergerak(0) ;
				Update() ;
				Render(Brs,Kol) ;
			}
		});
		btnKiri.setBounds(286, 125, 88, 23);		
		frame.getContentPane().add(btnKiri);
		
		//Render
		Init_Render(Brs,Kol) ;

	}
	
	Player player ;
	Chicken c ;
	
	JLabel[][] lbl_cell ;
	JLabel lblInventory ;
	JLabel lblMoney ;
	JLabel lblWater ;
	
	void Update() {
		for(int i = 0 ; i < player.getMap().getWidth() ; i ++ ){
			for(int j = 0 ; j < player.getMap().getHeight() ; j ++ ){
				player.getMap().getCell(i,j).update() ;
			}
		}
		for(int i = 0 ; i < player.getMap().getWidth() ; i ++ ){
			for(int j = 0 ; j < player.getMap().getHeight() ; j ++ ){								
				Creation this_C = player.getMap().getCell(i,j).getCreation();
				if (this_C != null) {
					this_C.Action(99) ;	
				}
				
			}
		}
		
	}
	
	void Init_Render(int Brs, int Kol) {
		lbl_cell = new JLabel[ Brs ][ Kol ] ;	
		for(int i = 0 ; i < Brs ; i += 1) {
			for(int j = 0 ; j < Kol ; j += 1) {
				lbl_cell[i][j] = new JLabel("");
				lbl_cell[i][j].setBounds(20*j, 20*i, 20, 20);							
				frame.getContentPane().add(lbl_cell[i][j] );
			}
		}

		//ItemPlayer
		lblMoney = new JLabel("Money : " + player.getMoney() );
		lblWater= new JLabel("Water : " + player.getWater() );
		lblInventory = new JLabel("Inventory : " + player.showInventory() );
		
		lblInventory.setBounds(10, 203, 569, 44);
		frame.getContentPane().add(lblInventory);
		
		lblMoney.setBounds(293, 51, 192, 29);
		frame.getContentPane().add(lblMoney);
		
		lblWater.setBounds(293, 11, 192, 29);
		frame.getContentPane().add(lblWater);
		
		Render(Brs,Kol) ;
	}

	void Render(int Brs,int Kol) {			
		for(int i = 0 ; i < Brs ; i += 1) {
			for(int j = 0 ; j < Kol ; j += 1) {		
				Image img_ ; 			
				switch (player.getMap().getCell(i, j).render() ) {
					case '*' :
						img_ = new ImageIcon(this.getClass().getResource("/barn_berumput.png")).getImage() ;
						break ;
					case 'x' :
						img_ = new ImageIcon(this.getClass().getResource("/barn_no_berumput.png")).getImage() ;
						break ;	
					case '#' :
						img_ = new ImageIcon(this.getClass().getResource("/coop_berumput.png")).getImage() ;
						break ;
					case '=' :
						img_ = new ImageIcon(this.getClass().getResource("/coop_no_berumput.png")).getImage() ;
						break ;		
					case '+' :
						img_ = new ImageIcon(this.getClass().getResource("/grassland_berumput.png")).getImage() ;
						break ;
					case '-' :
						img_ = new ImageIcon(this.getClass().getResource("/grassland_no_berumput.png")).getImage() ;
						break ;		
					case 'M' :
						img_ = new ImageIcon(this.getClass().getResource("/mixer.png")).getImage() ;
						break ;	
					case 'W' :
						img_ = new ImageIcon(this.getClass().getResource("/well.png")).getImage() ;
						break ;	
					case 'T' :
						img_ = new ImageIcon(this.getClass().getResource("/truck.png")).getImage() ;
						break ;	
					case 'a' :
						img_ = new ImageIcon(this.getClass().getResource("/chicken_lapar.png")).getImage() ;
						break ;	
					case 'A' :
						img_ = new ImageIcon(this.getClass().getResource("/chicken_no_lapar.png")).getImage() ;
						break ;		
					case 'P' :
						img_ = new ImageIcon(this.getClass().getResource("/player.png")).getImage() ;
						break ;	
					default :
						img_ = new ImageIcon(this.getClass().getResource("/coop_no_berumput.png")).getImage() ;
						break ;
				}			
				lbl_cell[i][j].setIcon(new ImageIcon(img_) ) ;		
			}
		}

		//ItemPlayer
		lblMoney.setText("Money : " + player.getMoney()  );
		lblWater.setText("Water : " + player.getWater()  );
		lblInventory.setText("Inventory : " + player.showInventory() );	
		
		frame.validate();
        frame.repaint();
	}
}

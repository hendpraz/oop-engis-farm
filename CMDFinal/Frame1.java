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

import facilities.*;
import farmanimal.*;
import land.*;
import products.*;
import products.farm.*;
import products.side.*;
import src.*;

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
		frame.setBounds(100, 100, 840, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/// SETUP
		//// HardCode
		int Brs = 10, Kol = 9;

		// Tanpa Hewan
		StringBuilder file = new StringBuilder();

		file.append("Wxxxxx***");
		file.append("*xxxxx***");
		file.append("*xxxxxxxx");
		file.append("----=+---");
		file.append("----=+---");
		file.append("---+#M---");
		file.append("T+===#===");
		file.append("==##=#===");
		file.append("===###=#=");
		file.append("==####===");

		// Count Object
		int n_Barn = 0, n_Grassland = 0, n_Coop = 0, n_Mixer = 0, n_Well = 0, n_Truck = 0;

		int n = file.length();
		char[] char_array = new char[n];

		// strcpy(char_array, file.c_str() );
		for (int i = 0; i < file.length(); i++) {
			char_array[i] = file.charAt(i);
		}

		for (int i = 0; i < n; i++) {
			if (char_array[i] == 'x' || char_array[i] == '*') {
				n_Barn += 1;
			} else if (char_array[i] == '-' || char_array[i] == '+') {
				n_Grassland += 1;
			} else if (char_array[i] == '=' || char_array[i] == '#') {
				n_Coop += 1;
			} else if (char_array[i] == 'M') {
				n_Mixer += 1;
			} else if (char_array[i] == 'W') {
				n_Well += 1;
			} else if (char_array[i] == 'T') {
				n_Truck += 1;
			}
		}

		Barn[] g_barn = new Barn[n_Barn];
		Grassland[] g_grassland = new Grassland[n_Grassland];
		Coop[] g_coop = new Coop[n_Coop];
		Mixer[] g_mixer = new Mixer[n_Mixer];
		Well[] g_well = new Well[n_Well];
		Truck[] g_truck = new Truck[n_Truck];

		/// Create Map
		Map gmap = new Map(Brs, Kol);

		/// SET Map
		int iterator_file = 0;

		int iterator_barn = 0;
		int iterator_grassland = 0;
		int iterator_mixer = 0;
		int iterator_well = 0;
		int iterator_truck = 0;
		int iterator_coop = 0;

		for (int i = 0; i < gmap.getWidth(); i++) {
			for (int j = 0; j < gmap.getHeight(); j++) {
				switch (char_array[iterator_file]) {
				case 'x':
					g_barn[iterator_barn] = new Barn();
					g_barn[iterator_barn].setGrass(false);
					gmap.setCell(i, j, g_barn[iterator_barn]);
					iterator_barn += 1;
					break;
				case '*':
					g_barn[iterator_barn] = new Barn();
					g_barn[iterator_barn].setGrass(true);
					gmap.setCell(i, j, g_barn[iterator_barn]);
					iterator_barn += 1;
					break;
				case '-':
					g_grassland[iterator_grassland] = new Grassland();
					g_grassland[iterator_grassland].setGrass(false);
					gmap.setCell(i, j, g_grassland[iterator_grassland]);
					iterator_grassland += 1;
					break;
				case '+':
					g_grassland[iterator_grassland] = new Grassland();
					g_grassland[iterator_grassland].setGrass(true);
					gmap.setCell(i, j, g_grassland[iterator_grassland]);
					iterator_grassland += 1;
					break;
				case '=':
					g_coop[iterator_coop] = new Coop();
					g_coop[iterator_coop].setGrass(false);
					gmap.setCell(i, j, g_coop[iterator_coop]);
					iterator_coop += 1;
					break;
				case '#':
					g_coop[iterator_coop] = new Coop();
					g_coop[iterator_coop].setGrass(true);
					gmap.setCell(i, j, g_coop[iterator_coop]);
					iterator_coop += 1;
					break;
				case 'W':
					g_well[iterator_well] = new Well();
					gmap.setCell(i, j, g_well[iterator_well]);
					iterator_well += 1;
					break;
				case 'M':
					g_mixer[iterator_mixer] = new Mixer();
					gmap.setCell(i, j, g_mixer[iterator_mixer]);
					iterator_mixer += 1;
					break;
				case 'T':
					g_truck[iterator_truck] = new Truck();
					gmap.setCell(i, j, g_truck[iterator_truck]);
					iterator_truck += 1;
					break;

				default:
					break;
				}

				iterator_file += 1;
			}
		}

		player = new Player();
		int BrsPlayer = 1, KolPlayer = 1;

		c = new Chicken();
		int BrsChicken = 0, KolChicken = 4;

		/// Setting Player And Animal
		c.setMap(gmap);
		c.setPosisi(BrsChicken, KolChicken);
		c.getMap().getCell(c.getPosBaris(), c.getPosKolom()).setCreation(c);

		player.setMap(gmap);
		player.setPosisi(BrsPlayer, KolPlayer);
		player.getMap().getCell(player.getPosBaris(), player.getPosKolom()).setCreation(player);

		SetupButton();

		// Render
		Init_Render();

	}

	void SetupButton() {

		/// y_button
		int y_button = 50;

		JButton btnAtas = new JButton("ATAS");
		btnAtas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FarmAnimal.getCountAnimal() != 0) {
					player.Bergerak(1);
					Update();
					Render();
				}
			}
		});
		btnAtas.setBounds(panjang_img * player.getMap().getHeight() + 50 + margin_X, y_button + 20, 90, 20);
		frame.getContentPane().add(btnAtas);

		JButton btnBawah = new JButton("BAWAH");
		btnBawah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FarmAnimal.getCountAnimal() != 0) {
					player.Bergerak(3);
					Update();
					Render();
				}
			}
		});
		btnBawah.setBounds(panjang_img * player.getMap().getHeight() + 50 + margin_X, y_button + 20 + 50 + 10, 90, 20);
		frame.getContentPane().add(btnBawah);

		JButton btnKanan = new JButton("KANAN");
		btnKanan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FarmAnimal.getCountAnimal() != 0) {
					player.Bergerak(2);
					Update();
					Render();
				}
			}
		});
		btnKanan.setBounds(panjang_img * player.getMap().getHeight() + 100 + margin_X, y_button + 50, 90, 20);
		frame.getContentPane().add(btnKanan);

		JButton btnKiri = new JButton("KIRI");
		btnKiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FarmAnimal.getCountAnimal() != 0) {
					player.Bergerak(0);
					Update();
					Render();
				}
			}
		});
		btnKiri.setBounds(panjang_img * player.getMap().getHeight() + 0 + margin_X, y_button + 50, 90, 20);
		frame.getContentPane().add(btnKiri);

		JButton btnKill = new JButton("KILL");
		btnKill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FarmAnimal.getCountAnimal() != 0) {
					player.Kill();
					Update();
					Render();
				}
			}
		});
		btnKill.setBounds(panjang_img * player.getMap().getHeight() + 200 + margin_X, 38, 120, 20);
		frame.getContentPane().add(btnKill);

		JButton btnGrow = new JButton("GROW");
		btnGrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FarmAnimal.getCountAnimal() != 0) {
					player.Grow();
					Update();
					Render();
				}
			}
		});
		btnGrow.setBounds(panjang_img * player.getMap().getHeight() + 200 + margin_X, 68, 120, 20);
		frame.getContentPane().add(btnGrow);

		JButton btnInteract = new JButton("INTERACT");
		btnInteract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FarmAnimal.getCountAnimal() != 0) {
					player.interact();
					Update();
					Render();
				}
			}
		});
		btnInteract.setBounds(panjang_img * player.getMap().getHeight() + 200 + margin_X, 98, 120, 20);
		frame.getContentPane().add(btnInteract);

		JButton btnTalk = new JButton("TALK");
		btnTalk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FarmAnimal.getCountAnimal() != 0) {
					player.Talk();
					Update();
					Render();
				}
			}
		});
		btnTalk.setBounds(panjang_img * player.getMap().getHeight() + 200 + margin_X, 128, 120, 20);
		frame.getContentPane().add(btnTalk);

		JButton btnMix = new JButton("MIX");
		btnMix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (FarmAnimal.getCountAnimal() != 0) {
					player.Mix();
					Update();
					Render();
				}
			}
		});
		btnMix.setBounds(panjang_img * player.getMap().getHeight() + 200 + margin_X, 158, 120, 20);
		frame.getContentPane().add(btnMix);
	}

	Player player;
	Chicken c;

	JLabel[][] lbl_cell;
	JLabel lblInventory;
	JLabel[] lblInventory_value;
	JLabel lblMoney;
	JLabel lblWater;
	int panjang_img = 50;
	int margin_X = 20; // margin antar field dan tombol

	void Update() {
		for (int i = 0; i < player.getMap().getWidth(); i++) {
			for (int j = 0; j < player.getMap().getHeight(); j++) {
				player.getMap().getCell(i, j).update();
			}
		}
		for (int i = 0; i < player.getMap().getWidth(); i++) {
			for (int j = 0; j < player.getMap().getHeight(); j++) {
				Creation this_C = player.getMap().getCell(i, j).getCreation();
				if (this_C != null) {
					this_C.Action(99);
				}

			}
		}

		if (FarmAnimal.getCountAnimal() == 0) {
			JOptionPane.showMessageDialog(null, "Game Over");
		}

	}

	void Init_Render() {
		// Cell
		lbl_cell = new JLabel[player.getMap().getWidth()][player.getMap().getHeight()];
		for (int i = 0; i < player.getMap().getWidth(); i += 1) {
			for (int j = 0; j < player.getMap().getHeight(); j += 1) {
				lbl_cell[i][j] = new JLabel("");
				lbl_cell[i][j].setBounds(panjang_img * j, panjang_img * i, panjang_img, panjang_img);
				frame.getContentPane().add(lbl_cell[i][j]);
			}
		}

		/// Value Inventory
		lblInventory_value = new JLabel[14]; // Macam2 product = 14
		for (int i = 0; i < 14; i++) {
			String str = "";
			switch (i) {
			case 0:
				str += "Chicken Egg";
				break;
			case 1:
				str += "Chicken Meat";
				break;
			case 2:
				str += "Cow Meat";
				break;
			case 3:
				str += "Cow Milk";
				break;
			case 4:
				str += "Duck Egg";
				break;
			case 5:
				str += "Duck Meat";
				break;
			case 6:
				str += "GooseEgg";
				break;
			case 7:
				str += "GooseMeat";
				break;
			case 8:
				str += "GoatMeat";
				break;
			case 9:
				str += "Beef Rolade";
				break;
			case 10:
				str += "Butter";
				break;
			case 11:
				str += "Ommelet";
				break;
			case 12:
				str += "GoatMilk";
				break;
			case 13:
				str += "SheepMeat";
				break;
			}
			int[] value_inventory = player.showInventory();
			lblInventory_value[i] = new JLabel(str + " : " + String.valueOf(value_inventory[i]));
			lblInventory_value[i].setBounds(panjang_img * player.getMap().getHeight() + 50 + margin_X, 280 + 20 * i,
					250, 20);
			frame.getContentPane().add(lblInventory_value[i]);
		}

		// ItemPlayer
		lblMoney = new JLabel("Money : " + player.getMoney());
		lblWater = new JLabel("Water : " + player.getWater());

		lblInventory = new JLabel("Inventory : " + ""); // player.showInventory() );

		lblInventory.setBounds(panjang_img * player.getMap().getHeight() + margin_X, 50 + 200, 200, 30);
		frame.getContentPane().add(lblInventory);

		lblMoney.setBounds(panjang_img * player.getMap().getHeight() + margin_X, 30 + 200, 200, 30);
		frame.getContentPane().add(lblMoney);

		lblWater.setBounds(panjang_img * player.getMap().getHeight() + margin_X, 10 + 200, 200, 30);
		frame.getContentPane().add(lblWater);

		Render();
	}

	void Render() {
		for (int i = 0; i < player.getMap().getWidth(); i += 1) {
			for (int j = 0; j < player.getMap().getHeight(); j += 1) {
				Image img_;
				switch (player.getMap().getCell(i, j).render()) {
				case '*':
					img_ = new ImageIcon(this.getClass().getResource("/img/barn_berumput.png")).getImage();
					break;
				case 'x':
					img_ = new ImageIcon(this.getClass().getResource("/img/barn_no_berumput.png")).getImage();
					break;
				case '#':
					img_ = new ImageIcon(this.getClass().getResource("/img/coop_berumput.png")).getImage();
					break;
				case '=':
					img_ = new ImageIcon(this.getClass().getResource("/img/coop_no_berumput.png")).getImage();
					break;
				case '+':
					img_ = new ImageIcon(this.getClass().getResource("/img/grassland_berumput.png")).getImage();
					break;
				case '-':
					img_ = new ImageIcon(this.getClass().getResource("/img/grassland_no_berumput.png")).getImage();
					break;
				case 'M':
					img_ = new ImageIcon(this.getClass().getResource("/img/mixer.png")).getImage();
					break;
				case 'W':
					img_ = new ImageIcon(this.getClass().getResource("/img/well.png")).getImage();
					break;
				case 'T':
					img_ = new ImageIcon(this.getClass().getResource("/img/truck.png")).getImage();
					break;

				case 'a':
					img_ = new ImageIcon(this.getClass().getResource("/img/chicken_lapar.png")).getImage();
					break;
				case 'A':
					img_ = new ImageIcon(this.getClass().getResource("/img/chicken_no_lapar.png")).getImage();
					break;

				case 'b':
					img_ = new ImageIcon(this.getClass().getResource("/img/duck_lapar.png")).getImage();
					break;
				case 'B':
					img_ = new ImageIcon(this.getClass().getResource("/img/duck_no_lapar.png")).getImage();
					break;

				case 's':
					img_ = new ImageIcon(this.getClass().getResource("/img/cow_lapar.png")).getImage();
					break;
				case 'S':
					img_ = new ImageIcon(this.getClass().getResource("/img/cow_no_lapar.png")).getImage();
					break;

				case 'k':
					img_ = new ImageIcon(this.getClass().getResource("/img/goat_lapar.png")).getImage();
					break;
				case 'K':
					img_ = new ImageIcon(this.getClass().getResource("/img/goat_no_lapar.png")).getImage();
					break;

				case 'g':
					img_ = new ImageIcon(this.getClass().getResource("/img/goose_lapar.png")).getImage();
					break;
				case 'G':
					img_ = new ImageIcon(this.getClass().getResource("/img/goose_no_lapar.png")).getImage();
					break;

				case 'd':
					img_ = new ImageIcon(this.getClass().getResource("/img/sheep_lapar.png")).getImage();
					break;
				case 'D':
					img_ = new ImageIcon(this.getClass().getResource("/img/sheep_no_lapar.png")).getImage();
					break;

				case 'P':
					img_ = new ImageIcon(this.getClass().getResource("/img/player.png")).getImage();
					break;

				default:
					img_ = new ImageIcon(this.getClass().getResource("/img/coop_no_berumput.png")).getImage();
					break;
				}
				lbl_cell[i][j].setIcon(new ImageIcon(img_));
			}
		}

		// ItemPlayer
		lblMoney.setText("Money : " + player.getMoney());
		lblWater.setText("Water : " + player.getWater());
		lblInventory.setText("Inventory : " + ""); // player.showInventory() );

		for (int i = 0; i < 14; i++) {
			String str = "";
			switch (i) {
			case 0:
				str += "Chicken Egg";
				break;
			case 1:
				str += "Chicken Meat";
				break;
			case 2:
				str += "Cow Meat";
				break;
			case 3:
				str += "Cow Milk";
				break;
			case 4:
				str += "Duck Egg";
				break;
			case 5:
				str += "Duck Meat";
				break;
			case 6:
				str += "GooseEgg";
				break;
			case 7:
				str += "GooseMeat";
				break;
			case 8:
				str += "GoatMeat";
				break;
			case 9:
				str += "Beef Rolade";
				break;
			case 10:
				str += "Butter";
				break;
			case 11:
				str += "Ommelet";
				break;
			case 12:
				str += "GoatMilk";
				break;
			case 13:
				str += "SheepMeat";
				break;
			}
			int[] value_inventory = player.showInventory();
			lblInventory_value[i].setText(str + " : " + String.valueOf(value_inventory[i]));
		}

		frame.validate();
		frame.repaint();
	}
}

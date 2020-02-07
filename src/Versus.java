import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseAdapter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Versus extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame myJFrame;
	ArrayList<JButton> KalanCards;
	ArrayList<JButton> oyuncu1CardsButton;
	ArrayList<JButton> oyuncu2CardsButton;
	JButton oynananCard1;
	JButton oynananCard2;
	JLabel oyuncu1Skor , oyuncu2Skor , oyuncu1Ad , oyuncu2Ad , kazanan;
	ArrayList<Pokemon> content , oyuncu1Cards , oyuncu2Cards;
	Pokemon sonOynananCard1 , sonOynananCard2;
	private int index ,index2 , index3;
	JLabel logo;
	JButton turButton;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
	public Versus(oyuncu oyuncu_1 , oyuncu oyuncu_2 , ArrayList<Pokemon> kalanKartlar) throws IOException {
		KalanCards = new ArrayList<JButton>();
		
		//oyuncu 1'in elinde bulunan kartlarý gösteren butonlar
		oyuncu1CardsButton = new ArrayList<JButton>();
		
		//oyuncu 2'nin elinde bulunan kartlarý gösteren butonlar
		oyuncu2CardsButton = new ArrayList<JButton>();
		
		content = new ArrayList<Pokemon>(kalanKartlar);
		oyuncu1Cards = new ArrayList<Pokemon>(oyuncu_1.getCards());
		oyuncu2Cards = new ArrayList<Pokemon>(oyuncu_2.getCards());
		
		//oyuncu 1 'in oynadýðý kart butonu
		oynananCard1 = new JButton();
		oynananCard1.setBounds(380,300 ,100, 150);
		oynananCard1.setVisible(false);
		this.add(oynananCard1);
		
		//oyuncu 2 'nin oynadýðý kart butonu
		oynananCard2 = new JButton();
		oynananCard2.setBounds(540,300 ,100, 150);
		oynananCard2.setVisible(false);
		this.add(oynananCard2);
		
		kazanan = new JLabel();
		kazanan.setBounds(430,570,200,20);
		kazanan.setVisible(false);
		this.add(kazanan);
		
		oyuncu1Skor = new JLabel("Skor : "+oyuncu_1.getSkor());
		oyuncu1Skor.setBounds(280 , 450 , 60,50);
		this.add(oyuncu1Skor);
		
		oyuncu2Skor = new JLabel("Skor : "+oyuncu_2.getSkor());
		oyuncu2Skor.setBounds(930 , 450 , 60,50);
		this.add(oyuncu2Skor);
		
		oyuncu1Ad = new JLabel("Oyuncu Adý : "+oyuncu_1.getOyuncuAdi());
		oyuncu1Ad.setBounds(30, 450, 200, 50);
		this.add(oyuncu1Ad);
		oyuncu2Ad = new JLabel("Oyuncu Adý : "+oyuncu_2.getOyuncuAdi());
		oyuncu2Ad.setBounds(680, 450, 200, 50);
		this.add(oyuncu2Ad);


		logo = new JLabel(new ImageIcon(ImageIO.read(new File("images/pokemon_logo_5.jpg"))));
		logo.setBounds(300, 0, 400, 100);
		JLabel logo2 = new JLabel(new ImageIcon(ImageIO.read(new File("images/pikachu_logo.png"))));
		logo2.setBounds(10, 170, 250,150);
		JLabel versus = new JLabel(new ImageIcon(ImageIO.read(new File("images/versus.png"))));
		versus.setBounds(475, 350, 70,70);
		JLabel logo3 = new JLabel(new ImageIcon(ImageIO.read(new File("images/logo3.jpg"))));
		logo3.setBounds(710, 170, 250,150);
		
		
		//bilgisayar vs bilgisayar durumu
		if(oyuncu_2 instanceof bilgisayar) {
			myJFrame = new JFrame("PC VS PC");
			turButton = new JButton("OYNA");
			turButton.setBounds(450, 600, 100, 30);
			this.add(turButton);
            oynananCard1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {

            		JButton btn = (JButton)e.getSource();
            		try {
            			btn.removeAll();
            			btn.setIcon(new ImageIcon(ImageIO.read(new File(sonOynananCard1.getPokemonIcon()))));
            			btn.setBackground(Color.white);
            			btn.add(butonDegistir(sonOynananCard1));

            		} catch (Exception e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
            		repaint();
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
            		JButton btn = (JButton)e.getSource();
            		try {
            			btn.removeAll();
            			btn.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
            		} catch (Exception e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
            		repaint();
				}
            });
            oynananCard2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {

            		JButton btn = (JButton)e.getSource();
            		try {
            			btn.removeAll();
            			btn.setIcon(new ImageIcon(ImageIO.read(new File(sonOynananCard2.getPokemonIcon()))));
            			btn.setBackground(Color.white);
            			btn.add(butonDegistir(sonOynananCard2));

            		} catch (Exception e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
            		repaint();
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
            		JButton btn = (JButton)e.getSource();
            		try {
            			btn.removeAll();
            			btn.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
            		} catch (Exception e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
            		repaint();
				}
            });

			for(int i=0;i<4;i++) {
	        	KalanCards.add(new JButton());
	            KalanCards.get(i).setSize(100, 150);
	            KalanCards.get(i).setLocation((KalanCards.get(i).getSize().width*i)+300, 120);
	            KalanCards.get(i).setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
	            index = i;
	            KalanCards.get(i).addMouseListener(new MouseAdapter() {
					private int myIndex;
					{
						this.myIndex = index;
					}
					@Override
					public void mouseEntered(MouseEvent e) {

	            		JButton btn = (JButton)e.getSource();
	            		try {
	            			btn.removeAll();
	            			btn.setIcon(new ImageIcon(ImageIO.read(new File(content.get(myIndex).getPokemonIcon()))));
	            			btn.setBackground(Color.white);
	            			btn.add(butonDegistir(content.get(myIndex)));

	            		} catch (Exception e1) {
	            			// TODO Auto-generated catch block
	            			e1.printStackTrace();
	            		}
	            		repaint();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
	            		JButton btn = (JButton)e.getSource();
	            		try {
	            			btn.removeAll();
	            			btn.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
	            		} catch (Exception e1) {
	            			// TODO Auto-generated catch block
	            			e1.printStackTrace();
	            		}
	            		repaint();
					}
	            });
	            this.add(KalanCards.get(i));
			}
			for(int i=0;i<3;i++) {
				oyuncu1CardsButton.add(new JButton());
				oyuncu1CardsButton.get(i).setSize(100, 150);
				oyuncu1CardsButton.get(i).setLocation((oyuncu1CardsButton.get(i).getSize().width*i)+30, 500);
				oyuncu1CardsButton.get(i).setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
				index = i;
				oyuncu1CardsButton.get(i).addMouseListener(new MouseAdapter() {
					private int myIndex;
					{
						this.myIndex = index;
					}
					@Override
					public void mouseEntered(MouseEvent e) {
	            		JButton btn = (JButton)e.getSource();
	            		try {
	            			btn.removeAll();
	            			btn.setIcon(new ImageIcon(ImageIO.read(new File(oyuncu1Cards.get(myIndex).getPokemonIcon()))));
	            			btn.setBackground(Color.white);
	            			btn.add(butonDegistir(oyuncu1Cards.get(myIndex)));
	 
	            		} catch (Exception e1) {
	            			// TODO Auto-generated catch block
	            			e1.printStackTrace();
	            		}
	            		repaint();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
	            		JButton btn = (JButton)e.getSource();
	            		try {
	            			btn.removeAll();
	            			btn.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
	 
	            		} catch (Exception e1) {
	            			// TODO Auto-generated catch block
	            			e1.printStackTrace();
	            		}
	            		repaint();
					}
				});
				this.add(oyuncu1CardsButton.get(i));
			}
			
			
			for(int i=0;i<3;i++) {
				oyuncu2CardsButton.add(new JButton());
				oyuncu2CardsButton.get(i).setSize(100, 150);
				oyuncu2CardsButton.get(i).setLocation((oyuncu2CardsButton.get(i).getSize().width*i)+680, 500);
				oyuncu2CardsButton.get(i).setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
	            index =i;
	            oyuncu2CardsButton.get(i).addMouseListener(new MouseAdapter() {
					private int myIndex;
					{
						this.myIndex = index;
					}
					@Override
					public void mouseEntered(MouseEvent e) {

	            		JButton btn = (JButton)e.getSource();
	            		try {
	            			btn.removeAll();
	            			btn.setIcon(new ImageIcon(ImageIO.read(new File(oyuncu2Cards.get(myIndex).getPokemonIcon()))));
	            			btn.setBackground(Color.white);
	            			btn.add(butonDegistir(oyuncu2Cards.get(myIndex)));

	            		} catch (Exception e1) {
	            			// TODO Auto-generated catch block
	            			e1.printStackTrace();
	            		}
	            		repaint();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
	            		JButton btn = (JButton)e.getSource();
	            		try {
	            			btn.removeAll();
	            			btn.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
	            		} catch (Exception e1) {
	            			// TODO Auto-generated catch block
	            			e1.printStackTrace();
	            		}
	            		repaint();
					}
	            });
				
				this.add(oyuncu2CardsButton.get(i));
			}
			turButton.addMouseListener(new MouseAdapter() {	
				@Override
				public void mouseClicked(MouseEvent e) {
					if(kalanKartlar.size()<=0) {
						if(oyuncu_1.getCards().size()<=0) {
							if(oyuncu_1.getSkor()>oyuncu_2.getSkor()) {
								kazanan.setText("Oyunu "+oyuncu_1.getOyuncuAdi()+" kazandý.");
							}
							else if(oyuncu_1.getSkor()<oyuncu_2.getSkor()) {
								kazanan.setText("Oyunu "+oyuncu_2.getOyuncuAdi()+" kazandý.");
							}
							else {
								kazanan.setText("Oyunu DOSTLUK kazandý.");
							}
							kazanan.setVisible(true);
							repaint();
								

						}
						else {
							sonOynananCard1 = oyuncu_1.kartSec();
							oyuncu_1.getCards().remove(sonOynananCard1);
							System.out.println("OYUNCU 1 : "+sonOynananCard1+" SEÇTÝ");
							sonOynananCard2 = oyuncu_2.kartSec();
							oyuncu_2.getCards().remove(sonOynananCard2);
							System.out.println("OYUNCU 2 : "+sonOynananCard2+" SEÇTÝ");
							try {
								oynananCard1.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
								oynananCard2.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							for(int i =0;i<oyuncu1Cards.size();i++) {
								if(oyuncu1Cards.get(i).equals(sonOynananCard1)) {
									oyuncu1CardsButton.get(i).setVisible(false);
								}
									
							}
							for(int i =0;i<oyuncu2Cards.size();i++) {
								if(oyuncu2Cards.get(i).equals(sonOynananCard2)) {
									oyuncu2CardsButton.get(i).setVisible(false);
								}
									
							}
							if(sonOynananCard1.getHasarPuani()>sonOynananCard2.getHasarPuani()) {
								oyuncu_1.setSkor(oyuncu_1.getSkor()+1);
								oyuncu1Skor.setText("Skor : "+oyuncu_1.getSkor());
							}
								
							else if(sonOynananCard1.getHasarPuani()<sonOynananCard2.getHasarPuani()) {
								oyuncu_2.setSkor(oyuncu_2.getSkor()+1);
								oyuncu2Skor.setText("Skor : "+oyuncu_2.getSkor());
							}
								
							repaint();
							
						}
						
					}
					else {
						sonOynananCard1 = oyuncu_1.kartSec();
						sonOynananCard2 = oyuncu_2.kartSec();
						try {
							oynananCard1.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
							oynananCard2.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						oynananCard1.setVisible(true);
						oynananCard2.setVisible(true);
						Pokemon poke1 = kartSec(kalanKartlar);
						kalanKartlar.remove(poke1);
						Pokemon poke2 = kartSec(kalanKartlar);
						kalanKartlar.remove(poke2);
						
						
						for(int i =0;i<oyuncu_1.getCards().size();i++) {
							if(oyuncu_1.getCards().get(i).equals(sonOynananCard1)) {
								System.out.println("OYUNCU 1 :"+oyuncu_1.getCards().get(i)+" --> "+poke1);
								oyuncu_1.getCards().set(i, poke1);
								oyuncu1Cards.set(i, poke1);
								
							}
								
						}

						for(int i =0;i<oyuncu_2.getCards().size();i++) {
							if(oyuncu_2.getCards().get(i).equals(sonOynananCard2)) {
								System.out.println("OYUNCU 2 :"+oyuncu_2.getCards().get(i)+" --> "+poke2);
								oyuncu_2.getCards().set(i, poke2);
								oyuncu2Cards.set(i, poke2);
								
							}
								
						}
						if(sonOynananCard1.getHasarPuani()>sonOynananCard2.getHasarPuani()) {
							oyuncu_1.setSkor(oyuncu_1.getSkor()+1);
							oyuncu1Skor.setText("Skor : "+oyuncu_1.getSkor());
						}
							
						else if(sonOynananCard1.getHasarPuani()<sonOynananCard2.getHasarPuani()) {
							oyuncu_2.setSkor(oyuncu_2.getSkor()+1);
							oyuncu2Skor.setText("Skor : "+oyuncu_2.getSkor());
						}
						repaint();
						
					}

					
				}
			});
		}
		
		//bilgisayar vs insan durumu
		else {
			myJFrame = new JFrame("PC VS PERSON");
			
			
			oynananCard1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					
					JButton btn = (JButton)e.getSource();
					
					try {
						btn.removeAll();
						btn.setIcon(new ImageIcon(ImageIO.read(new File(sonOynananCard1.getPokemonIcon()))));
						btn.setBackground(Color.WHITE);
						btn.add(butonDegistir(sonOynananCard1));
					}
					catch(Exception e1) {
						
					}
					repaint();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					try {
						oynananCard1.removeAll();
						oynananCard1.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaint();
				}
				
				
			});
			oynananCard2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					
					JButton btn = (JButton)e.getSource();
					
					try {
						btn.removeAll();
						btn.setIcon(new ImageIcon(ImageIO.read(new File(sonOynananCard2.getPokemonIcon()))));
						btn.setBackground(Color.WHITE);
						btn.add(butonDegistir(sonOynananCard2));
					}
					catch(Exception e1) {
						
					}
					repaint();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					try {
						oynananCard2.removeAll();
						oynananCard2.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaint();
				}
				
				
			});
			
			for(int i=0;i<4;i++) {
	        	KalanCards.add(new JButton());
	            KalanCards.get(i).setSize(100, 150);
	            KalanCards.get(i).setLocation((KalanCards.get(i).getSize().width*i)+300, 120);
	            KalanCards.get(i).setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
	            index3 = i;
	            KalanCards.get(i).addMouseListener(new MouseAdapter() {
	            	private int myIndex;
	            	{
	            		this.myIndex = index3;
	            	}
	            	@Override
	            	public void mouseClicked(MouseEvent e) {

						try {
							JButton btn=(JButton)e.getSource();
							btn.setVisible(false);
							oyuncu1CardsButton.get(index).setVisible(true);
							oyuncu1CardsButton.get(index).setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
							oyuncu2CardsButton.get(index2).setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));	
							oyuncu2CardsButton.get(index2).setVisible(true);
							oyuncu_1.getCards().set(index, content.get(myIndex));
							kalanKartlar.remove(myIndex);
							kalanKartlar.remove(index2);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
	            	}
				});
	            this.add(KalanCards.get(i));
			}
			for(int i=0;i<3;i++) {
				oyuncu1CardsButton.add(new JButton());
				oyuncu1CardsButton.get(i).setSize(100, 150);
				oyuncu1CardsButton.get(i).setLocation((oyuncu1CardsButton.get(i).getSize().width*i)+30, 500);
				oyuncu1CardsButton.get(i).setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
				index = i;
				oyuncu1CardsButton.get(i).addMouseListener(new MouseAdapter() {
					private int myIndex;
					{
						this.myIndex = index;
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						JButton btn=(JButton)e.getSource();
						try {
							oynananCard1.setVisible(true);
							btn.setVisible(false);
							oynananCard1.removeAll();
							oynananCard1.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
							sonOynananCard1=oyuncu_1.getCards().get(myIndex);
							

							sonOynananCard2=oyuncu_2.kartSec();
							index2=0;
							for(int i=0;i<oyuncu2Cards.size();i++) {
								if(oyuncu2Cards.get(i).equals(sonOynananCard2)) {
									index2=i;
								}
							}
							oyuncu2CardsButton.get(index2).setVisible(false);
							oynananCard2.setVisible(true);
							oynananCard2.removeAll();
							oynananCard2.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
							
							if(sonOynananCard1.getHasarPuani()>sonOynananCard2.getHasarPuani()) {
								oyuncu_1.setSkor(oyuncu_1.getSkor()+5);
								oyuncu1Skor.setText("Skor : "+oyuncu_1.getSkor());
							}
							else if(sonOynananCard1.getHasarPuani()<sonOynananCard2.getHasarPuani()) {
								oyuncu_2.setSkor(oyuncu_2.getSkor()+5);
								oyuncu2Skor.setText("Skor : "+oyuncu_2.getSkor());

									
							}
							
							
							
						}catch(Exception e1) {
							
						}
						repaint();
						
					}
					@Override
					public void mouseEntered(MouseEvent e) {

	            		JButton btn = (JButton)e.getSource();
	            		try {
	            			btn.removeAll();
	            			btn.setIcon(new ImageIcon(ImageIO.read(new File(oyuncu_1.getCards().get(myIndex).getPokemonIcon()))));
	            			btn.setBackground(Color.white);
	            			btn.add(butonDegistir(oyuncu_1.getCards().get(myIndex)));
	 
	            		} catch (Exception e1) {
	            			// TODO Auto-generated catch block
	            			e1.printStackTrace();
	            		}
	            		repaint();
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
	            		JButton btn = (JButton)e.getSource();
	            		try {
	            			btn.removeAll();
	            			btn.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
	 
	            		} catch (Exception e1) {
	            			// TODO Auto-generated catch block
	            			e1.printStackTrace();
	            		}
	            		repaint();
					}
				});
				this.add(oyuncu1CardsButton.get(i));
			}
			
			for(int i=0;i<3;i++) {
				oyuncu2CardsButton.add(new JButton());
				oyuncu2CardsButton.get(i).setSize(100, 150);
				oyuncu2CardsButton.get(i).setLocation((oyuncu2CardsButton.get(i).getSize().width*i)+680, 500);
				oyuncu2CardsButton.get(i).setIcon(new ImageIcon(ImageIO.read(new File("images/card_back_100x150.png"))));
	            this.add(oyuncu2CardsButton.get(i));
			}
			
		}
		this.add(versus);
		this.add(logo2);
		this.add(logo3);
		this.add(logo);
		this.setBackground(Color.white);
		this.setLayout(null);
        myJFrame.setSize(1020, 1000);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setResizable(false);
        myJFrame.getContentPane().add(this);
        myJFrame.setVisible(true);
	}
	public JPanel butonDegistir(Pokemon poke) {
		JPanel cardTitle = new JPanel();
		JLabel labelText = new JLabel();
		cardTitle.setLayout(null);
		GridLayout experimentLayout = new GridLayout(3,1);
		cardTitle.setLayout(experimentLayout);
		labelText = new JLabel(poke.getPokemonAdi());
		labelText.setFont(labelText.getFont().deriveFont(labelText.getFont().getStyle() | Font.BOLD));
		labelText.setHorizontalAlignment(JLabel.CENTER);
		cardTitle.add(labelText);
		labelText = new JLabel(new ImageIcon(poke.getPokemonIcon()));
		labelText.setSize(100,50);
		cardTitle.add(labelText);
		labelText = new JLabel(("HP: "+poke.getHasarPuani()));
		labelText.setFont(labelText.getFont().deriveFont(labelText.getFont().getStyle() | Font.BOLD));
		labelText.setHorizontalAlignment(JLabel.CENTER);
		cardTitle.add(labelText);
		cardTitle.setBackground(Color.white);
		return cardTitle;
	}
	public boolean cardControl(ArrayList<Pokemon> poke , int index) {
		for(int i=0;i<poke.size();i++) {
			try {
				if(poke.get(i).equals(poke.get(index))) 
					return true;
			}catch(Exception ex) {
				return false;
			}

		}
		return false;	
	}
	public Pokemon kartSec(ArrayList<Pokemon> poke) {
		Random r = new Random();
        int index = r.nextInt(poke.size());
        Pokemon pokemon = poke.get(index);
        for(int i=0;i<content.size();i++) 
        	if(content.get(i).equals(pokemon))
        		KalanCards.get(i).setVisible(false);
        return pokemon;
		
	}

}

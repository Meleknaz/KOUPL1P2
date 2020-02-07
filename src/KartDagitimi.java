import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class KartDagitimi extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame myJFrame;
    ArrayList<JButton> cards;
    ArrayList<Pokemon> poke;
    ArrayList<oyuncu> oyuncu;
    JButton kartDagit;
    JPanel cardTitle;
    TextField name;
    int index;
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    public KartDagitimi(oyuncu oyuncu_1 , oyuncu oyuncu_2) throws IOException {	
        myJFrame = new JFrame("PC VS PC");
        if(oyuncu_2 instanceof insan) {
            name =new TextField();
            name.setBounds(500, 620, 200, 60);
            this.add(name);
        }

        oyuncu = new ArrayList<oyuncu>();
        poke = new ArrayList<Pokemon>();
        cards = new ArrayList<JButton>();
        kartDagit = new JButton("Kart Daðýt");
        
        oyuncu.add(oyuncu_1);
        oyuncu.add(oyuncu_2);
        
        kartDagit.setSize(200,60);
        kartDagit.setLocation(800,620);
        
        poke.add(new Pikachu());
        poke.add(new Snorlax());
        poke.add(new Squirtle());
        poke.add(new Bulbasaur());
        poke.add(new Butterfree());
        poke.add(new Charmander());
        poke.add(new Jigglypuff());
        poke.add(new Meowth());
        poke.add(new Zubat());
        poke.add(new Psyduck()); 
        
        for(int i=0;i<5;i++) {
        	index = i;
        	cards.add(new JButton());
            cards.get(i).setSize(200, 300);
            cards.get(i).setLocation(cards.get(i).getSize().width*i, 0);
            cards.get(i).setIcon(new ImageIcon(ImageIO.read(new File("images/card_back.png"))));
            this.index = i;
            cards.get(i).addMouseListener(new MouseAdapter() {
                private int myIndex;
                {
                    this.myIndex = index;
                }
            	@Override
            	public void mouseEntered(MouseEvent e) {   
            		JButton btn = (JButton)e.getSource();
            		try {
            			btn.removeAll();
    					cardTitle = new JPanel();
    					JLabel labelText = new JLabel();
    					cardTitle.setLayout(null);
    					GridLayout experimentLayout = new GridLayout(3,1);
    					cardTitle.setLayout(experimentLayout);
    					labelText = new JLabel(poke.get(myIndex).getPokemonAdi());
    					labelText.setFont(labelText.getFont().deriveFont(labelText.getFont().getStyle() | Font.BOLD));
    					labelText.setHorizontalAlignment(JLabel.CENTER);
    					cardTitle.add(labelText);
    					labelText = new JLabel(new ImageIcon(poke.get(myIndex).getPokemonIcon()));
    					cardTitle.add(labelText);
    					labelText = new JLabel(("Hasar Puaný : "+poke.get(myIndex).getHasarPuani()));
    					labelText.setFont(labelText.getFont().deriveFont(labelText.getFont().getStyle() | Font.BOLD));
    					labelText.setHorizontalAlignment(JLabel.CENTER);
    					cardTitle.add(labelText);
            			btn.setIcon(new ImageIcon(ImageIO.read(new File(poke.get(myIndex).getPokemonIcon()))));
            			cardTitle.setBackground(Color.white);
            			btn.setBackground(Color.white);
            			btn.add(cardTitle);
            		} catch (Exception e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
            		//repaint();
            		
            	}

            	@Override
            	public void mouseExited(MouseEvent e) {
            		JButton btn = (JButton)e.getSource();
            		try {
            			btn.removeAll();
            			btn.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back.png"))));
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
            		//repaint();
            	}
            });
            this.add(cards.get(i));
        }
        for(int i=5;i<10;i++) {
        	index = i;
        	cards.add(new JButton());
            cards.get(i).setSize(200, 300);
            cards.get(i).setLocation(cards.get(i).getSize().width*(i-5), 310);
            cards.get(i).setIcon(new ImageIcon(ImageIO.read(new File("images/card_back.png"))));
            this.index = i;
            cards.get(i).addMouseListener(new MouseAdapter() {
                private int myIndex;
                {
                    this.myIndex = index;
                }
            	@Override
            	public void mouseEntered(MouseEvent e) {        		
            		JButton btn = (JButton)e.getSource();
            		try {
            			btn.removeAll();
    					cardTitle = new JPanel();
    					JLabel labelText = new JLabel();
    					cardTitle.setLayout(null);
    					GridLayout experimentLayout = new GridLayout(3,1);
    					cardTitle.setLayout(experimentLayout);
    					labelText = new JLabel(poke.get(myIndex).getPokemonAdi());
    					labelText.setFont(labelText.getFont().deriveFont(labelText.getFont().getStyle() | Font.BOLD));
    					labelText.setHorizontalAlignment(JLabel.CENTER);
    					cardTitle.add(labelText);
    					labelText = new JLabel(new ImageIcon(poke.get(myIndex).getPokemonIcon()));
    					cardTitle.add(labelText);
    					labelText = new JLabel(("Hasar Puaný : "+poke.get(myIndex).getHasarPuani()));
    					labelText.setFont(labelText.getFont().deriveFont(labelText.getFont().getStyle() | Font.BOLD));
    					labelText.setHorizontalAlignment(JLabel.CENTER);
    					cardTitle.add(labelText);
            			btn.setIcon(new ImageIcon(ImageIO.read(new File(poke.get(myIndex).getPokemonIcon()))));
            			cardTitle.setBackground(Color.white);
            			btn.setBackground(Color.white);
            			btn.add(cardTitle);
            		} catch (Exception e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
            		//repaint();
            	}

            	@Override
            	public void mouseExited(MouseEvent e) {
            		JButton btn = (JButton)e.getSource();
            		try {
            			btn.removeAll();
            			btn.setIcon(new ImageIcon(ImageIO.read(new File("images/card_back.png"))));
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
            		//repaint();
            	}
            });
            this.add(cards.get(i));
        }
        
        kartDagit.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
            	if(oyuncu_2 instanceof insan ) {
                	if(!name.getText().equals("")) {
                    	oyuncu_1.setOyuncuAdi(name.getText());
                		startGame(oyuncu_1, oyuncu_2);
                	}
            	}
            	else {
            		startGame(oyuncu_1 , oyuncu_2);
            	}


            
            }
            
        });
        
        this.add(kartDagit);
        this.setLayout(null);
        myJFrame.setSize(1020, 1000);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setResizable(false);
        myJFrame.getContentPane().add(this);
        myJFrame.setVisible(true);
    }
    public boolean cardControl(ArrayList<Pokemon> poke, Pokemon poke_2 ) {
        for(int i=0;i<poke.size();i++) {
        	if(poke.get(i).equals(poke_2)) {
        		return true;
        	}
        }
    	return false;
    }
    public void startGame(oyuncu oyuncu_1 , oyuncu oyuncu_2) {
        try{
        	ArrayList<Pokemon> content = new ArrayList<Pokemon>(poke);
        	ArrayList<Pokemon> secilenKartlar = new ArrayList<Pokemon>();
        	for(int i =0;i<3;i++) {
        		Random r = new Random();
        		int a = 0+r.nextInt(9);
        		if(!cardControl(secilenKartlar , poke.get(a))) {
        			secilenKartlar.add(poke.get(a));
        			oyuncu.get(0).setCards(poke.get(a));
        			content.remove(poke.get(a));
        		}
        		else {
        			i--;
        		}
        	}
        	for(int i =0;i<3;i++) {
        		Random r = new Random();
        		int a = 0+r.nextInt(10);
        		if(!cardControl(secilenKartlar , poke.get(a))) {
        			secilenKartlar.add(poke.get(a));
        			oyuncu.get(1).setCards(poke.get(a));
        			content.remove(poke.get(a));
        		}
        		else {
        			i--;
        		}
        	}
        	new Versus(oyuncu_1 , oyuncu_2 , content);

        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }

}

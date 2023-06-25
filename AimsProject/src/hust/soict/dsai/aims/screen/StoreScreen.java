//package hust.soict.cybersec.aims.screen;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class StoreScreen extends JFrame{
//	private Store store;
//	
//	JPanel createNorth(){
//		Jpanel north = new Jpanel();
//		north.setLayout(new BoxLayout(north, Y_AXIS, BoxLayout.Y_AXIS));
//		north.add(createMenuBar());
//		return north;
//	}
//
//	JMenuBar createMenuBar(){
//
//		JMenu = new JMenu("Options");
//
//		JMenu smUpdateStore = new JMenu("Update Store");
//		smUpdateStore.add(new JMenuItem("Add Book"));
//		smUpdateStore.add(new JMenuItem("Add CD"));
//		smUpdateStore.add(new JMenuItem("Add DVD"));
//
//		menu.add(smUpdateStore);
//		menu.add(new JMenuItem("View store"));
//		menu.add(new JMenuItem("View cart"));
//
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
//		menuBar.add(menu);
//
//		return menuBar;
//	}
//
//	JPanel createHeader(){
//
//		JPanel header = new JPanel();
//		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
//
//		JLabel title = new JLabel("AIMS");
//		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
//
//		JButton cart = new JButton("View cart");
//		cart.setPreferredSize(new Dimension(100, 50));
//		cart.setMaximumSize(new Dimension(100,50));
//
//		header.add(Box.createRigidArea(new Dimension(10, 10)));
//		header.add(title);
//		header.add(Box.createHorizontalGlue());
//		header.add(cart);
//		header.add(Box.createRigidArea(new Dimension(10, 10)));
//
//		return header;
//	}
//	//create components
//	JPanel createCenter(){
//		JPanel center = new JPanel();
//		center.setLayout(new GridLayout(3, 3, 2, 2));
//
//		ArrayList<Media> mediaInStore = store.getItemsInStore();
//		for (int i=0; i<9; i++){
//			MediaStore cell = new MediaStore(mediaInStore.get(i));
//			center.add(cell);
//		}
//		return center;
//	}
//}
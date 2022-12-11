/**
 * Class MenuManagerGUI
 * @author Brian Fang
 * created: 12/08/2022
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MenuManagerGUI {

    private JFrame frame;
    private JList list;
    private DefaultListModel model = new DefaultListModel();
    private String selectElement;
    private JComboBox entreeBox; 
    private JComboBox sideBox; 
    private JComboBox saladBox; 
    private JComboBox dessertBox; 
    
    private HashMap<String, Entree> entrees = new HashMap<String, Entree>();
    private HashMap<String, Side> sides = new HashMap<String, Side>();
    private HashMap<String, Salad> saladHashMap = new HashMap<String, Salad>();
    private HashMap<String, Dessert> desserts = new HashMap<String, Dessert>();
    private HashMap<String, Menu> menus = new HashMap<String, Menu>();
    
    private ArrayList<Menu> menuList = new ArrayList<>();
    private MenuManager manager;
    private Menu menu = new Menu("Menu");

    public static void main(String[] args) throws IOException {
    	/**
         * Create the window
         */
        MenuManagerGUI window = new MenuManagerGUI();
        window.frame.setVisible(true);
        
    }

    public MenuManagerGUI() throws IOException {
    	/**
         * Build the window
         */
        this.manager = new MenuManager("data/dishes.txt");
        buildMainWindow();
        
    }
    
    public ArrayList<Menu> getMenuList() {
    	/**
         * Get menu list
         */
        return menuList;
    }

    public void setMenuList(ArrayList<Menu> menuList) {
    	/**
         * Set menu list
         */
        this.menuList = menuList;
    }

    private void buildMainWindow() {
    	/**
         * Build window function
         */
        frame = new JFrame();
        frame.setTitle("Menu Manager");
        frame.setBounds(410, 200, 600, 380);
        frame.getContentPane().setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel buildMenuTitle = new JLabel("Build your own Menu");
        buildMenuTitle.setBorder(BorderFactory.createEmptyBorder(5, 10, 1, 0));
        JLabel generateMenuTitle = new JLabel("Or generate a Menu");
        generateMenuTitle.setBorder(BorderFactory.createEmptyBorder(15, 10, 1, 0));
        
        leftPanel.add(buildMenuTitle);
        leftPanel.add(buildMenuPanel());
        leftPanel.add(generateMenuTitle);
        leftPanel.add(generateMenuPanel());
        frame.add(leftPanel);
        
        JPanel rightPanel = createdMenusPanel();
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        JPanel createdMenus = new JPanel(new CardLayout());
        
        createdMenus.add(rightPanel);
        frame.add(createdMenus);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
    }

    private JPanel buildMenuPanel() {
    	/**
         * Build menu panel
         */
        JPanel menuPanel = new JPanel(new GridLayout(5, 1));
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setBackground(Color.WHITE);
        topLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        menuPanel.setBackground(Color.WHITE);
        		
        Panel entreePanel = new Panel(new BorderLayout());
        Label entreeLabel = new Label("Entree    ");
        entreeBox = new JComboBox();
        for(Entree entree : manager.getEntrees()) {
            entreeBox.addItem(entree.getName());
            entrees.put(entree.getName(), entree);
        }
        entreeBox.setSelectedIndex(0);
        menu.setEntree(entrees.get(entreeBox.getSelectedItem() + ""));
        entreeBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.SELECTED == e.getStateChange()){
                    String entree = entreeBox.getSelectedItem() + "";
                    menu.setEntree(entrees.get(entree));
                }
            }
        });
        entreePanel.add(entreeLabel, BorderLayout.WEST);
        entreePanel.add(entreeBox, BorderLayout.CENTER);
        
        Panel sidePanel = new Panel(new BorderLayout());
        Label sideLabel = new Label("Side       ");
        sideBox = new JComboBox();
        for(Side side : manager.getSides()) {
            sideBox.addItem(side.getName());
            sides.put(side.getName(), side);
        }
        sideBox.setSelectedIndex(0);
        menu.setSide(sides.get(sideBox.getSelectedItem() + ""));
        sideBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String side = sideBox.getSelectedItem() + "";
                menu.setSide(sides.get(side));
            }
        });
        sidePanel.add(sideLabel,BorderLayout.WEST);
        sidePanel.add(sideBox,BorderLayout.CENTER);
        
        Panel saladPanel = new Panel(new BorderLayout());
        Label saladLabel = new Label("Salad     ");
        saladBox = new JComboBox();
        for(Salad salad : manager.getSalads()) {
            saladBox.addItem(salad.getName());
            saladHashMap.put(salad.getName(), salad);
        }
        saladBox.setSelectedIndex(0);
        menu.setSalad(saladHashMap.get(saladBox.getSelectedItem() + ""));
        saladBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String salad = saladBox.getSelectedItem() + "";
                menu.setSalad(saladHashMap.get(salad));
            }
        });
        saladPanel.add(saladLabel,BorderLayout.WEST);
        saladPanel.add(saladBox,BorderLayout.CENTER);
        
        Panel dessertPanel = new Panel(new BorderLayout());
        Label dessertLabel = new Label("Dessert ");
        dessertBox = new JComboBox();
        for(Dessert dessert : manager.getDesserts()) {
            dessertBox.addItem(dessert.getName());
            desserts.put(dessert.getName(), dessert);
        }
        dessertBox.setSelectedIndex(0);
        menu.setDessert(desserts.get(dessertBox.getSelectedItem() + ""));
        dessertBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String dessert = dessertBox.getSelectedItem() + "";
                menu.setDessert(desserts.get(dessert));
            }
        });
        dessertPanel.add(dessertLabel,BorderLayout.WEST);
        dessertPanel.add(dessertBox,BorderLayout.CENTER);
        
        Button createMenuDishes = new Button("Create Menu with these dishes");
        createMenuDishes.addActionListener(new MyActionListener());
        
        menuPanel.add(entreePanel);
        menuPanel.add(sidePanel);
        menuPanel.add(saladPanel);
        menuPanel.add(dessertPanel);
        menuPanel.add(createMenuDishes);
        topLeftPanel.add(menuPanel, BorderLayout.CENTER);
        
        return topLeftPanel;
        
    }
    
    private JPanel generateMenuPanel() {
    	/**
         * Build generate menu panel
         */
        JPanel botLeftPanel = new JPanel();
        botLeftPanel.setBackground(Color.WHITE);
        botLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel menuPanel = new JPanel(new GridLayout(3, 1));
        menuPanel.setBackground(Color.WHITE);
        Button randomMenu = new Button("Generate a Random Menu");
        randomMenu.addActionListener(new MyActionListener());
        Button minMenu = new Button("Generate a Minimum Calories Menu");
        minMenu.addActionListener(new MyActionListener());
        Button maxMenu = new Button("Generate a Maximum Calories Menu");
        maxMenu.addActionListener(new MyActionListener());
        
        menuPanel.add(randomMenu);
        menuPanel.add(minMenu);
        menuPanel.add(maxMenu);
        botLeftPanel.add(menuPanel, BorderLayout.CENTER);
        
        return botLeftPanel;
        
    }
    
    private JPanel createdMenusPanel() {
    	/**
         * Build created menu panel
         */
        JPanel rightPanel = new JPanel(new BorderLayout());
        JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT));
        title.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        Label label = new Label("Created Menus:");
        title.add(label);;
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        Button detailButton = new Button("Details");
        buttonPanel.add(detailButton);
        detailButton.addActionListener(new MyButtonListener());
        Button deleteButton = new Button("Delete all");
        buttonPanel.add(deleteButton);
        deleteButton.addActionListener(new MyButtonListener());
        Button saveButton = new Button("Save to file");
        buttonPanel.add(saveButton);
        saveButton.addActionListener(new MyButtonListener());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        list = new JList(model);
        list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        list.addMouseListener(new MyMouseListener());
        
        rightPanel.add(title, BorderLayout.NORTH);
        rightPanel.add(list, BorderLayout.CENTER);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        return rightPanel;
        
    }

    class MyActionListener implements ActionListener {
    	/**
         * Action listener for left panel
         */
        TextField input;
        @Override
        public void actionPerformed(ActionEvent a) {
        	
            if(a.getActionCommand().equals("Generate a Random Menu")) {
                menu = manager.randomMenu();
            }
            else if(a.getActionCommand().equals("Generate a Minimum Calories Menu")) {
                menu = manager.minCaloriesMenu("");
            }
            else if(a.getActionCommand().equals("Generate a Maximum Calories Menu")) {
                menu = manager.maxCaloriesMenu("");
            }
            else {
                menu.setName("");
            }
            
            JFrame displayFrame = new JFrame();
            displayFrame.setVisible(true);
            displayFrame.setBounds(480, 250, 400, 150);
            displayFrame.setTitle("Enter Menu Name");
            TextField textField = new TextField("", 20);
            Button button = new Button("Submit");
            button.addActionListener(new NameListener(textField, displayFrame));
            Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT));
            panel.add(textField);
            panel.add(button);
            displayFrame.add(panel);
            
        }
        
    }
    
    class MyMouseListener implements MouseListener  {
    	/**
         * Mouse Listener for clicks
         */
        @Override
        public void mouseClicked(MouseEvent event) {
            if(event.getClickCount() >= 1) {
                int index = list.getSelectedIndex();
                if (index >= 0) {
                    selectElement = model.getElementAt(index).toString();
                }
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {
        	
        }
        @Override
        public void mouseReleased(MouseEvent e){
        	
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        	
        }
        @Override
        public void mouseExited(MouseEvent e) {
        	
        }
        
    }
    
    class NameListener implements ActionListener {
    	/**
         * Action listener for entering menu name
         */
        TextField input;
        JFrame displayFrame;
        public NameListener(TextField textField, JFrame displayFrame) {
            this.input = textField;
            this.displayFrame = displayFrame;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	if(input.getText().equals("")) {
        		JOptionPane.showMessageDialog(null, "Please enter a name");
        	}
        	else {
        		menu.setName(input.getText());
                Menu newMenu = new Menu(menu.getName(), menu.getEntree(), menu.getSide(), menu.getSalad(), menu.getDessert());
                menuList.add(newMenu);
                menus.put(newMenu.getName(), newMenu);
                model.addElement(newMenu.getName());
                input.setText("");
                displayFrame.setVisible(false);
                menu.setEntree(entrees.get(entreeBox.getSelectedItem() + ""));
                menu.setSide(sides.get(sideBox.getSelectedItem() + ""));
                menu.setSalad(saladHashMap.get(saladBox.getSelectedItem() + ""));
                menu.setDessert(desserts.get(dessertBox.getSelectedItem() + ""));
        	}
        	
        }
        
    }
    
    class MyButtonListener implements ActionListener {
    	/**
         * ActionListener for right panel
         */
        JFrame displayFrame;
        Menu newMenu;
        
        public JPanel getPanel(String type) {
        	
            JPanel panel = new JPanel();
            JTextArea label;
            
            if(type.equals("Total calories:") || type.equals("Total price: $")) {
                label = new JTextArea(1, 20);
            }
            else {
                label = new JTextArea(3, 40);
            }
            label.setLineWrap(true);
            JLabel title;
            if(type.equals("Entree")) {
                title = new JLabel(type + '\t'+ '\t' + '\t');
                label.setText(newMenu.getEntree().toString());
            }
            else if(type.equals("Side")) {
                title = new JLabel(type + '\t'+ '\t' + '\t'+ '\t' + '\t'+ '\t');
                label.setText(newMenu.getSide().toString());
            }
            else if(type.equals("Salad")) {
                title = new JLabel(type + '\t' + '\t' + '\t' + '\t' + '\t');
                label.setText(newMenu.getSalad().toString());
            }
            else if(type.equals("Dessert")) {
                title = new JLabel(type + '\t');
                label.setText(newMenu.getDessert().toString());
            }
            else if(type.equals("Total calories:")) {
                title = new JLabel(type + '\t');
                label.setText(newMenu.totalCalories() +"");
            }
            else {
                title = new JLabel(type + '\t');
                label.setText(newMenu.totalPrice() + "");
            }
            
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setBackground(Color.WHITE);
            panel.add(title, BorderLayout.WEST);
            panel.add(label, BorderLayout.CENTER);
            
            return panel;
            
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	
            String command = e.getActionCommand();
            
            if(command.equals("Details") && !selectElement.equals("")) {
            	
            	displayFrame = new JFrame();
            	newMenu = menus.get(selectElement);
                displayFrame.setTitle("Menu: " + newMenu.getName());
                displayFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
                displayFrame.setBounds(410, 180, 600, 500);
                
                JPanel entreePanel = getPanel("Entree");
                displayFrame.add(entreePanel);
                JPanel sidePanel = getPanel("Side");
                displayFrame.add(sidePanel);
                JPanel saladPanel = getPanel("Salad");
                displayFrame.add(saladPanel);
                JPanel dessertPanel = getPanel("Dessert");
                displayFrame.add(dessertPanel);
                JPanel calories = getPanel("Total calories:");
                displayFrame.add(calories);
                JPanel price = getPanel("Total price: $");
                displayFrame.add(price);
                displayFrame.setVisible(true);
                
            }
            
            else if(command.equals("Delete all")) {
            	
                model.clear();
                menus.clear();
                menuList.clear();
                
            }
            
            else if(command.equals("Save to file") && !menuList.isEmpty()) {
            	
                try {
                    FileManager.writeMenu("data/menus.txt", menuList);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
                
            }
            
        }
        
    }
    
}
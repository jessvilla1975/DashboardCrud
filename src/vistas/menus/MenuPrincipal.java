/**
 * La clase `MenuPrincipal` en Java representa una aplicación GUI para administrar elementos y usuarios
 * del inventario, con funcionalidades para agregar, eliminar, actualizar elementos y registrar
 * usuarios.
 */

package vistas.menus;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import login.Login;
import login.LoginUsuarios;
import sql.Inventario;
import java.sql.ResultSet;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import table.TablaInventario;
import table.TablaUsuarios;
import vistas.ingresar.IngresarRopa;
import vistas.ingresar.IngresarUsers;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;


public class MenuPrincipal extends javax.swing.JFrame {
    
    LoginUsuarios user = new LoginUsuarios();
    Inventario crud=new Inventario();
    TablaInventario tablita = new TablaInventario();
    TablaUsuarios Tusers = new TablaUsuarios();
    IngresarRopa ropa = new IngresarRopa();
    IngresarUsers users = new IngresarUsers();


   
    
    
    public MenuPrincipal() {
        
        initComponents();
        panelTabla.setBackground(Color.WHITE);
        panelUsers.setBackground(Color.WHITE);
        Panels.setBackground(Color.WHITE);
        buscar.setBackground(Color.WHITE);
        buscar.setFocusable(false); 
        LabersUser.setText(user.nombre);
        LabersUser.setForeground(Color.black);
        Panelropa.setBackground(Color.WHITE);
        estado();
        alerta();
        panelderopa();
       
      
        
       
    }
    
    private void panelderopa() {
    Panelropa.setLayout(new GridLayout(NUM_ICONOS, 2, 0, 0)); // N filas, 2 columnas, sin espacios horizontales, espaciado vertical de 10

    iconos = new JLabel[NUM_ICONOS];
    JLabel[] textos = new JLabel[NUM_ICONOS]; // Arreglo para los JLabels de texto
    String[] comentarios = {
        "Excelente",
        "Me gusta",
        "Interesante",
        "Increíble",
        "Buen trabajo",
        "Genial",
        "Bien",
        "Perfecto"
           
    };

    for (int i = 0; i < NUM_ICONOS; i++) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/icon" + (i + 1) + ".png"));
        iconos[i] = new JLabel(icon);
        Panelropa.add(iconos[i]);

        // Agregar el JLabel de texto junto al icono principal
        textos[i] = new JLabel(comentarios[i]);
        textos[i].setFont(new Font("Arial", Font.PLAIN, 12)); // Puedes ajustar la fuente y el tamaño según tus preferencias
        textos[i].setForeground(Color.BLACK); // Puedes cambiar el color del texto si lo deseas
        Panelropa.add(textos[i]);
    }

    // Configurar el temporizador para la animación
    timer = new Timer(INTERVALO_ANIMACION, e -> {
        for (int i = 0; i < NUM_ICONOS; i++) {
            JLabel icono = iconos[i];
            int nuevaPosY = icono.getY() + paso * PASO_DESPLAZAMIENTO;

            if (paso == 1 && nuevaPosY > Panelropa.getHeight()) {
                icono.setLocation(icono.getX(), LIMITE_SUPERIOR);
            } else if (paso == -1 && nuevaPosY < LIMITE_SUPERIOR) {
                icono.setLocation(icono.getX(), Panelropa.getHeight());
            } else {
                icono.setLocation(icono.getX(), nuevaPosY);
            }

            // Mover el JLabel de texto junto con el icono principal
            JLabel texto = textos[i];
            texto.setLocation(icono.getX() + icono.getWidth() + ESPACIO_ENTRE_CHAT, icono.getY());
        }

        Panelropa.repaint();
    });
    timer.start();
}






    private void alerta(){
        int total = crud.StockProductos(); 
        if(total>0){
            Pstocks.setBackground(new java.awt.Color(255,255,255));
            jLabel15.setForeground(new java.awt.Color(196,12,12));
            stockCantidad.setForeground(new java.awt.Color(196,12,12));
            LabelAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/danger.png")));
            
           
        }else{
            Pstocks.setBackground(new java.awt.Color(255,255,255));
            stockCantidad.setForeground(new java.awt.Color(42,33,133));
            jLabel15.setForeground(new java.awt.Color(153,153,153));
            LabelAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/alert.png")));
            
            
        }
    }
    private void addTablaPanel() {
       
        tablita.setBounds(10, 80, panelTabla.getWidth(), panelTabla.getHeight());
        this.panelTabla.removeAll();
        this.panelTabla.add(tablita, BorderLayout.CENTER);
        
        this.panelTabla.revalidate();
        this.panelTabla.repaint();
        
    }
    
    private void addTablaUsuarios() {
        Tusers.setBounds(10, 80, Panels.getWidth(), Panels.getHeight());
        this.Panels.removeAll();
        this.Panels.add(Tusers, BorderLayout.CENTER);
        
        this.Panels.revalidate();
        this.Panels.repaint();
       
       
    }
    private void addInsertar() {
       
        ropa.setBounds(10, 80, addProductos.getWidth(), addProductos.getHeight());
        addProductos.removeAll();
        addProductos.add(ropa, BorderLayout.CENTER);
        addProductos.revalidate();
        addProductos.repaint();
    }
    
    private void addRegistrar() {
       
        //users.setBounds(0, 80, panelUsers.getWidth(), panelUsers.getHeight());
        panelUsers.removeAll();
        panelUsers.add(users, BorderLayout.CENTER);
        panelUsers.revalidate();
        panelUsers.repaint();
    }

    
    private void estado(){
        contarProductos(); 
        contarProductosAgotados();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        Pstocks = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        stockCantidad = new javax.swing.JLabel();
        LabelAlerta = new javax.swing.JLabel();
        Ptables = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        ico3 = new javax.swing.JLabel();
        Pfiles = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Pitems = new javax.swing.JPanel();
        cantidad = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        ico2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        add = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        update = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LabersUser = new javax.swing.JLabel();
        addProductos = new javax.swing.JPanel();
        Panels = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        panelUsers = new javax.swing.JPanel();
        Panelropa = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Panelmenu = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        signOut = new javax.swing.JLabel();
        help = new javax.swing.JLabel();
        setting = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        register = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(-2, 0));
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(1370, 735));
        bg.setPreferredSize(new java.awt.Dimension(1370, 735));
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bgMouseClicked(evt);
            }
        });
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(42, 33, 133));
        Titulo.setText("Available inventory");
        Titulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Titulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TituloMouseClicked(evt);
            }
        });
        bg.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 280, 50));

        Pstocks.setBackground(new java.awt.Color(255, 255, 255));
        Pstocks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        Pstocks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pstocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PstocksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PstocksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PstocksMouseExited(evt);
            }
        });
        Pstocks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Stock Items");
        Pstocks.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        stockCantidad.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        stockCantidad.setForeground(new java.awt.Color(42, 33, 133));
        stockCantidad.setText("5");
        stockCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockCantidadMouseClicked(evt);
            }
        });
        Pstocks.add(stockCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, 70));
        Pstocks.add(LabelAlerta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 70, 60));

        bg.add(Pstocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 220, 120));

        Ptables.setBackground(new java.awt.Color(255, 255, 255));
        Ptables.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        Ptables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ptables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PtablesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PtablesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PtablesMouseExited(evt);
            }
        });
        Ptables.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        l1.setForeground(new java.awt.Color(42, 33, 133));
        l1.setText("01");
        l1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
        });
        Ptables.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 60, 70));

        l2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        l2.setForeground(new java.awt.Color(153, 153, 153));
        l2.setText("Tables");
        Ptables.add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        ico3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cells.png"))); // NOI18N
        ico3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ico3MouseClicked(evt);
            }
        });
        Ptables.add(ico3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 70, 60));

        bg.add(Ptables, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 220, 120));

        Pfiles.setBackground(new java.awt.Color(255, 255, 255));
        Pfiles.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        Pfiles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pfiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PfilesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PfilesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PfilesMouseExited(evt);
            }
        });
        Pfiles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("File");
        Pfiles.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/file.png"))); // NOI18N
        Pfiles.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 70, 60));

        bg.add(Pfiles, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 220, 120));

        Pitems.setBackground(new java.awt.Color(255, 255, 255));
        Pitems.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        Pitems.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pitems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PitemsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PitemsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PitemsMouseExited(evt);
            }
        });
        Pitems.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cantidad.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        cantidad.setForeground(new java.awt.Color(42, 33, 133));
        cantidad.setText("120");
        cantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cantidadMouseClicked(evt);
            }
        });
        Pitems.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, 70));

        l4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        l4.setForeground(new java.awt.Color(153, 153, 153));
        l4.setText("Items");
        Pitems.add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        ico2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/prenda.png"))); // NOI18N
        Pitems.add(ico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 70, 60));

        bg.add(Pitems, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 220, 120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lupa.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 20, 20));

        buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(102, 102, 102));
        buscar.setText("Search here");
        buscar.setBorder(null);
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buscarMousePressed(evt);
            }
        });
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        bg.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 270, 20));

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        add.setText("Delete");
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.setOpaque(true);
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        bg.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 30, -1));

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete.png"))); // NOI18N
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.setOpaque(true);
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        bg.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 230, 30, -1));

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh.png"))); // NOI18N
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.setOpaque(true);
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateMousePressed(evt);
            }
        });
        bg.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 30, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/avatarAdmin.png"))); // NOI18N
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 30, 40));

        LabersUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabersUser.setText("User");
        bg.add(LabersUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));

        addProductos.setBackground(new java.awt.Color(255, 255, 255));
        addProductos.setPreferredSize(new java.awt.Dimension(620, 550));
        addProductos.setLayout(new java.awt.BorderLayout());
        bg.add(addProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 345, 516));

        Panels.setBackground(new java.awt.Color(255, 255, 255));
        Panels.setPreferredSize(new java.awt.Dimension(600, 410));
        Panels.setLayout(new java.awt.BorderLayout());
        bg.add(Panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 540, -1));

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));
        panelTabla.setPreferredSize(new java.awt.Dimension(872, 410));
        panelTabla.setLayout(new java.awt.BorderLayout());
        bg.add(panelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        panelUsers.setBackground(new java.awt.Color(255, 255, 255));
        panelUsers.setPreferredSize(new java.awt.Dimension(872, 410));
        panelUsers.setLayout(new java.awt.BorderLayout());
        bg.add(panelUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 345, 516));

        Panelropa.setLayout(new java.awt.BorderLayout());
        bg.add(Panelropa, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 150, 450));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(42, 33, 133));
        jLabel4.setText("Chats Customers");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 260, 150, -1));

        Panelmenu.setBackground(new java.awt.Color(42, 33, 133));
        Panelmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Panelmenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 290, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inventory App");
        Panelmenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        signOut.setBackground(new java.awt.Color(42, 33, 133));
        signOut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signOut.setForeground(new java.awt.Color(255, 255, 255));
        signOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ingresar.png"))); // NOI18N
        signOut.setText("  Sign out");
        signOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOut.setOpaque(true);
        signOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signOutMouseExited(evt);
            }
        });
        Panelmenu.add(signOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 290, 360, 40));

        help.setBackground(new java.awt.Color(42, 33, 133));
        help.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        help.setForeground(new java.awt.Color(255, 255, 255));
        help.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/help.png"))); // NOI18N
        help.setText("  Help");
        help.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        help.setOpaque(true);
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpMouseExited(evt);
            }
        });
        Panelmenu.add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 130, 380, 40));

        setting.setBackground(new java.awt.Color(42, 33, 133));
        setting.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        setting.setForeground(new java.awt.Color(255, 255, 255));
        setting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings.png"))); // NOI18N
        setting.setText("  Settings");
        setting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setting.setOpaque(true);
        setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingMouseExited(evt);
            }
        });
        Panelmenu.add(setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 180, 370, 40));

        home.setBackground(new java.awt.Color(42, 33, 133));
        home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/casa.png"))); // NOI18N
        home.setText("  Home");
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setOpaque(true);
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeMouseExited(evt);
            }
        });
        Panelmenu.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 80, 370, 40));

        register.setBackground(new java.awt.Color(42, 33, 133));
        register.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-user.png"))); // NOI18N
        register.setText("  Sign up");
        register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register.setOpaque(true);
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited(evt);
            }
        });
        Panelmenu.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 235, 360, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panelmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panelmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMousePressed
        if(buscar.getText().equals("Search here"))
        buscar.setText("");
        buscar.setFocusable(true);
        buscar.requestFocusInWindow();
    }//GEN-LAST:event_buscarMousePressed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    private void stockCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockCantidadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stockCantidadMouseClicked

    private void signOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutMouseEntered
        signOut.setBackground(new java.awt.Color(255,255,255));
        signOut.setForeground(new java.awt.Color(42,33,133));
    }//GEN-LAST:event_signOutMouseEntered

    private void signOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutMouseExited
        signOut.setBackground(new java.awt.Color(42,33,133));
        signOut.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_signOutMouseExited

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
        home.setBackground(new java.awt.Color(255,255,255));
        home.setForeground(new java.awt.Color(42,33,133));
    }//GEN-LAST:event_homeMouseEntered

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited
        home.setBackground(new java.awt.Color(42,33,133));
        home.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_homeMouseExited

    private void helpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseEntered
        help.setBackground(new java.awt.Color(255,255,255));
        help.setForeground(new java.awt.Color(42,33,133));
    }//GEN-LAST:event_helpMouseEntered

    private void helpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseExited
        help.setBackground(new java.awt.Color(42,33,133));
        help.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_helpMouseExited

    private void settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseEntered
        setting.setBackground(new java.awt.Color(255,255,255));
        setting.setForeground(new java.awt.Color(42,33,133));
    }//GEN-LAST:event_settingMouseEntered

    private void settingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseExited
        setting.setBackground(new java.awt.Color(42,33,133));
        setting.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_settingMouseExited

    private void cantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantidadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadMouseClicked

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_l1MouseClicked
    public void showTable(){
        System.out.println("boton tablas");
        alerta();
        estado(); 
        tablita.testData();
        addTablaPanel();
        tablita.setVisible(true);
        panelTabla.setVisible(true);
       
        
        
    }
     public void showTableUsers(){
        System.out.println("boton tablas");
        Tusers.testData();
        addTablaUsuarios();
        Tusers.setVisible(true);
        Panels.setVisible(true);
        
        
        
    }
    private void PtablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PtablesMouseClicked
       ropa.setVisible(false);
       addProductos.setVisible(false);
       Tusers.setVisible(false);
       Panels.setVisible(false);
       showTable();
       
    }//GEN-LAST:event_PtablesMouseClicked

    private void PtablesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PtablesMouseExited
        Ptables.setBackground(new java.awt.Color(255,255,255));
        l1.setForeground(new java.awt.Color(42,33,133));
        l2.setForeground(new java.awt.Color(153,153,153));
        l1.setFont(l1.getFont().deriveFont(48f)); 
        l2.setFont(l2.getFont().deriveFont(18f)); 
        l1.setSize(l1.getPreferredSize());
        l2.setSize(l2.getPreferredSize());
        l1.revalidate();
        l2.revalidate();
        l1.repaint();
        l2.repaint();    
        
    }//GEN-LAST:event_PtablesMouseExited

    private void PtablesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PtablesMouseEntered
        Ptables.setBackground(new java.awt.Color(42, 33, 133));
        l1.setForeground(new java.awt.Color(255, 255, 255));
        l2.setForeground(new java.awt.Color(255, 255, 255));
        l1.setFont(l1.getFont().deriveFont(53f)); 
        l2.setFont(l2.getFont().deriveFont(24f)); 
        l1.setSize(80, 90);
        l2.setSize(l2.getPreferredSize());
        l1.revalidate();
        l2.revalidate();
        l1.repaint();
        l2.repaint();    
    }//GEN-LAST:event_PtablesMouseEntered

    private void PitemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PitemsMouseClicked
        
    }//GEN-LAST:event_PitemsMouseClicked

    private void PitemsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PitemsMouseEntered
        Pitems.setBackground(new java.awt.Color(42,33,133));
        cantidad.setForeground(new java.awt.Color(255,255,255));
        l4.setForeground(new java.awt.Color(255,255,255));
        // Aumentar el tamaño de la fuente
        cantidad.setFont(cantidad.getFont().deriveFont(53f)); // Ajusta el tamaño según sea necesario
        l4.setFont(l4.getFont().deriveFont(24f)); // Ajusta el tamaño según sea necesario

        // Aumentar el tamaño de los JLabel
        cantidad.setSize(cantidad.getPreferredSize());
        l4.setSize(l4.getPreferredSize());
        cantidad.revalidate();
        l4.revalidate();
        cantidad.repaint();
        l4.repaint();

    }//GEN-LAST:event_PitemsMouseEntered

    private void PitemsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PitemsMouseExited
        Pitems.setBackground(new java.awt.Color(255,255,255));
        cantidad.setForeground(new java.awt.Color(42,33,133));
        l4.setForeground(new java.awt.Color(153,153,153));
        // Aumentar el tamaño de la fuente
        cantidad.setFont(cantidad.getFont().deriveFont(48f)); // Ajusta el tamaño según sea necesario
        l4.setFont(l4.getFont().deriveFont(18f)); // Ajusta el tamaño según sea necesario

        // Aumentar el tamaño de los JLabel
        cantidad.setSize(cantidad.getPreferredSize());
        l4.setSize(l4.getPreferredSize());
        cantidad.revalidate();
        l4.revalidate();
        cantidad.repaint();
        l4.repaint();
    }//GEN-LAST:event_PitemsMouseExited

    private void PfilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PfilesMouseClicked
        crud.generarReporteProductos();
    }//GEN-LAST:event_PfilesMouseClicked

    private void PfilesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PfilesMouseEntered
        Pfiles.setBackground(new java.awt.Color(42,33,133));
        jLabel12.setForeground(new java.awt.Color(255,255,255));
        // Aumentar el tamaño de la fuente
        jLabel12.setFont(jLabel12.getFont().deriveFont(24f)); // Ajusta el tamaño según sea necesario

        // Aumentar el tamaño del JLabel
        jLabel12.setSize(jLabel12.getPreferredSize());
        jLabel12.revalidate();
        jLabel12.repaint();
    }//GEN-LAST:event_PfilesMouseEntered

    private void PfilesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PfilesMouseExited
        Pfiles.setBackground(new java.awt.Color(255,255,255));
        jLabel12.setForeground(new java.awt.Color(153,153,153));
        jLabel12.setFont(jLabel12.getFont().deriveFont(18f)); // Ajusta el tamaño según sea necesario

        // Aumentar el tamaño del JLabel
        jLabel12.setSize(jLabel12.getPreferredSize());
        jLabel12.revalidate();
        jLabel12.repaint();
    }//GEN-LAST:event_PfilesMouseExited

    private void PstocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PstocksMouseClicked
        System.out.println("boton stock");
        estado();
        addProductos.setVisible(false);
        ropa.setVisible(false);
        tablita.testData4();
        tablita.setBackground(Color.WHITE);
        panelTabla.setVisible(true);
        tablita.setVisible(true);
    }//GEN-LAST:event_PstocksMouseClicked

    private void PstocksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PstocksMouseEntered
        
        int total = crud.StockProductos(); 
        if(total > 0){
            Pstocks.setBackground(Color.red);
            jLabel15.setForeground(new java.awt.Color(255,255,255));
            stockCantidad.setForeground(new java.awt.Color(255,255,255));

            // Aumentar el tamaño de la fuente
            jLabel15.setFont(jLabel15.getFont().deriveFont(24f)); // Ajusta el tamaño según sea necesario
            stockCantidad.setFont(stockCantidad.getFont().deriveFont(53f)); // Ajusta el tamaño según sea necesario

            // Aumentar el tamaño de los JLabels
            jLabel15.setSize(jLabel15.getPreferredSize());
            stockCantidad.setSize(stockCantidad.getPreferredSize());
            jLabel15.revalidate();
            stockCantidad.revalidate();
            jLabel15.repaint();
            stockCantidad.repaint();
        } else {
            Pstocks.setBackground(new java.awt.Color(42,33,133));
            stockCantidad.setForeground(new java.awt.Color(255,255,255));
            jLabel15.setForeground(new java.awt.Color(255,255,255));

            // Aumentar el tamaño de la fuente
            jLabel15.setFont(jLabel15.getFont().deriveFont(24f)); // Ajusta el tamaño según sea necesario
            stockCantidad.setFont(stockCantidad.getFont().deriveFont(53f)); // Ajusta el tamaño según sea necesario

            // Aumentar el tamaño de los JLabels
            jLabel15.setSize(jLabel15.getPreferredSize());
            stockCantidad.setSize(stockCantidad.getPreferredSize());
            jLabel15.revalidate();
            stockCantidad.revalidate();
            jLabel15.repaint();
            stockCantidad.repaint();
        }
    }//GEN-LAST:event_PstocksMouseEntered

    private void PstocksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PstocksMouseExited
        int total = crud.StockProductos(); 
        if(total > 0){
            Pstocks.setBackground(new java.awt.Color(255,255,255));
            jLabel15.setForeground(new java.awt.Color(196,12,12));
            stockCantidad.setForeground(new java.awt.Color(196,12,12));

            // Restaurar el tamaño de la fuente
            jLabel15.setFont(jLabel15.getFont().deriveFont(18f)); // Ajusta el tamaño según sea necesario
            stockCantidad.setFont(stockCantidad.getFont().deriveFont(48f)); // Ajusta el tamaño según sea necesario

            // Ajustar el tamaño de los JLabels
            jLabel15.setSize(jLabel15.getPreferredSize());
            stockCantidad.setSize(stockCantidad.getPreferredSize());
            jLabel15.revalidate();
            stockCantidad.revalidate();
            jLabel15.repaint();
            stockCantidad.repaint();
        } else {
            Pstocks.setBackground(new java.awt.Color(255,255,255));
            stockCantidad.setForeground(new java.awt.Color(42,33,133));
            jLabel15.setForeground(new java.awt.Color(153,153,153));

            // Restaurar el tamaño de la fuente
            jLabel15.setFont(jLabel15.getFont().deriveFont(18f)); // Ajusta el tamaño según sea necesario
            stockCantidad.setFont(stockCantidad.getFont().deriveFont(48f)); // Ajusta el tamaño según sea necesario

            // Ajustar el tamaño de los JLabels
            jLabel15.setSize(jLabel15.getPreferredSize());
            stockCantidad.setSize(stockCantidad.getPreferredSize());
            jLabel15.revalidate();
            stockCantidad.revalidate();
            jLabel15.repaint();
            stockCantidad.repaint();
        }
        
    }//GEN-LAST:event_PstocksMouseExited

    private void TituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TituloMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TituloMouseClicked

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseExited

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteMouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseExited

    private void signOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutMouseClicked
        Login lo = new Login();
        lo.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_signOutMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        System.out.println("Se presionó el botón eliminar");
        tablita.eliminarFila();
        tablita.testData();
        estado();
        alerta();
        addTablaPanel();

        

    }//GEN-LAST:event_deleteMouseClicked
    private void cerrar(){
        this.getContentPane().remove(panelTabla);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        System.out.println("add");
        ropa.Title.setForeground(Color.black);
        tablita.setVisible(false);
        panelTabla.setVisible(false);
        estado();
        addInsertar();
        addProductos.setVisible(true);
        ropa.setVisible(true);

    }//GEN-LAST:event_addMouseClicked
  
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.out.println("boton buscar");
        int id = Integer.parseInt(buscar.getText());
        tablita.testData2(id);
        tablita.setVisible(true);
         buscar.setText("Search here");
        
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked

        addTablaPanel();
        tablita.testData3();
        alerta();
        estado();
        
        //tablita.setBounds(330, 300, 872, 418);
       // tablita.setVisible(true);
    }//GEN-LAST:event_updateMouseClicked

    private void ico3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ico3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ico3MouseClicked

    private void registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseEntered
        register.setBackground(new java.awt.Color(255,255,255));
        register.setForeground(new java.awt.Color(42,33,133));
    }//GEN-LAST:event_registerMouseEntered

    private void registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseExited
        register.setBackground(new java.awt.Color(42,33,133));
        register.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_registerMouseExited

    private void showRegister(){
        Ptables.setVisible(false);
        Pitems.setVisible(false);
        Pfiles.setVisible(false);
        Pstocks.setVisible(false);
        add.setVisible(false);
        delete.setVisible(false);
        update.setVisible(false);
        Titulo.setVisible(false);
        buscar.setVisible(false);
        jLabel2.setVisible(false);
        tablita.setVisible(false);
        panelTabla.setVisible(false);
        ropa.setVisible(false);
        addProductos.setVisible(false);
        
        
    }
    
     private void showHome(){
        Ptables.setVisible(true);
        Pitems.setVisible(true);
        Pfiles.setVisible(true);
        Pstocks.setVisible(true);
        add.setVisible(true);
        delete.setVisible(true);
        update.setVisible(true);
        Titulo.setVisible(true);
        buscar.setVisible(true);
        jLabel2.setVisible(true);
        jLabel4.setVisible(true);
        addTablaPanel();
        //tablita.setVisible(true);
        panelTabla.setVisible(true);
        addInsertar();
        //ropa.setVisible(true);
        //addProductos.setVisible(true);
        panelUsers.setVisible(false);
        users.setVisible(false);
        
        
        //PanelTablaUses.setVisible(false);
        Tusers.setVisible(false);
        Panelropa.setVisible(true);
        
    }
    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        System.out.println("boton sing up");
        showRegister();
        addRegistrar();
        showTableUsers();
        panelUsers.setVisible(true);
        users.setVisible(true);
        Panels.setVisible(true);
        Tusers.setVisible(true);
        Panelropa.setVisible(false);
        jLabel4.setVisible(false);
        
        
    }//GEN-LAST:event_registerMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        System.out.println("home");
        showHome();
        
    }//GEN-LAST:event_homeMouseClicked

    private void bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bgMouseClicked

    private void updateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMousePressed
    public void contarProductos() {
    String cant = String.valueOf(crud.ContarProductos()); 
    cantidad.setText(cant);
    }
    
    
    private void contarProductosAgotados() {
    String cant = String.valueOf(crud.StockProductos()); 
    stockCantidad.setText(cant);
    }
   private int posicionY = 0;

   
 
   

    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        FlatLaf.registerCustomDefaultsSource("table");
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
                
                
            }
        });
    }
    private final int LIMITE_SUPERIOR = -100; 
    private final int NUM_ICONOS = 8; // Número total de iconos
    private final int INTERVALO_ANIMACION = 200; // Intervalo de tiempo en milisegundos para la animación
    private final int PASO_DESPLAZAMIENTO = 10;
    private int posY = 0; // Posición inicial del primer icono
    private int paso = -1; // Dirección del desplazamiento (1: hacia abajo, -1: hacia arriba)
    private Timer timer; // Temporizador para la animación
    private JLabel[] iconos; // Arreglo para almacenar los JLabels de los iconos
    private final int ESPACIO_ENTRE_CHAT = 1;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAlerta;
    public javax.swing.JLabel LabersUser;
    private javax.swing.JPanel Panelmenu;
    private javax.swing.JPanel Panelropa;
    public javax.swing.JPanel Panels;
    private javax.swing.JPanel Pfiles;
    private javax.swing.JPanel Pitems;
    private javax.swing.JPanel Pstocks;
    private javax.swing.JPanel Ptables;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel add;
    private javax.swing.JPanel addProductos;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField buscar;
    private javax.swing.JLabel cantidad;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel help;
    private javax.swing.JLabel home;
    private javax.swing.JLabel ico2;
    private javax.swing.JLabel ico3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l4;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JPanel panelUsers;
    private javax.swing.JLabel register;
    private javax.swing.JLabel setting;
    private javax.swing.JLabel signOut;
    private javax.swing.JLabel stockCantidad;
    private javax.swing.JLabel update;
    // End of variables declaration//GEN-END:variables
}
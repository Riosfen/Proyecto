package modelo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BigPanel extends JPanel implements Serializable{
    
    public static final String IMG_EQUIS = "recursos/salir2.jpeg";
    public static final String IMG_INFO = "recursos/info.png";
    public static final String IMG_ATRAS = "recursos/back.png";
    
    private Color color;
    private String tittle;
    private JLabel contenedorIcono, titulo;
    private JButton btnSalir, btnAyuda;
    private Image tratar;
    private ImageIcon icono1, icono2, imagen;
    private Font fuente = getFont();
    private tipoVentana tipo;
    
    private int size;
    
    //
    // Inicio lista de constructores 
    //
    
    public BigPanel(String tittle, Color color, tipoVentana tipo){
        this.color = color;
        this.tittle = tittle;
        this.tipo = tipo;
        barraSuperior();
        
    }
    public BigPanel(ImageIcon imagen, String tittle, Color color, tipoVentana tipo){
        this.color = color;
        this.imagen = imagen;
        this.tittle = tittle;
        this.tipo = tipo;
        barraSuperior();
        
    }
    public BigPanel(ImageIcon imagen, String tittle, tipoVentana tipo){
        this.imagen = imagen;
        this.tittle = tittle;
        this.tipo = tipo;
        barraSuperior();
        
    }
    
    //
    // Fin lista de constructores 
    //
    
    //
    // Inicio Getters y Setters
    //
    
    public void setTittleColor(Color color){
        titulo.setForeground(color);
    }
    public void setTittle(String tittle) {
        this.tittle = tittle;
        titulo.setText(tittle);
    }
    public void setIcono(ImageIcon icono) {
        this.icono2 = icono;
    }
    public void setFuente(Font fuente){
        this.fuente = fuente;
    }
    public void setFontSize(int size){
        titulo.setBorder(new EmptyBorder(0, (int)(size/1.5), 0, 0));
        fuente = new Font(fuente.getFamily(),fuente.getStyle(),(int)(size/1.5));
        titulo.setFont(fuente);
        btnAyuda.setPreferredSize(new Dimension(size, size));
        btnSalir.setPreferredSize(new Dimension(size, size));
        
        btnAyuda.setIcon(redimensionarImagenAlto(icono1,size));
        btnSalir.setIcon(redimensionarImagenAlto(icono2,size));
        
        contenedorIcono.setIcon(redimensionarImagenAncho(imagen,size));
    }
    public void setBackgroundColorBar(Color color){
        this.setBackground(color);
    }
    
    public int getTamFuente(){
        return  (int)(size/1.5);
    }
    public JLabel getTitulo(){
        return titulo;
    }
    public String getTittle(){
        return tittle;
    }
    public ImageIcon getLogo(){
        return imagen;
    }
    public Color getBackgroundColor(){
        return color;
    }
    public Color getFontColor(){
        return titulo.getForeground();
    }
    
    //
    // Fin Getters y Setters
    //
    
    //
    // Controlador
    public void controladorSalir(ActionListener a, String ActionCommand){
        btnSalir.addActionListener(a);
        btnSalir.setActionCommand(ActionCommand);
    }
    public void controladorAyuda(ActionListener a, String ActionCommand){
        btnAyuda.addActionListener(a);
        btnAyuda.setActionCommand(ActionCommand);
    }
    
    public enum tipoVentana{
        CERRAR,
        ATRAS
    }
    
    private ImageIcon redimensionarImagenAncho(ImageIcon icono, int size){
        try {
            tratar = icono.getImage();
            tratar = tratar.getScaledInstance(-1, size, Image.SCALE_DEFAULT);
            icono = new ImageIcon(tratar);
        } catch (NullPointerException e) {
            System.out.println("Error, no se encuentra la imagen o no se ha especificado ninguna");
        }
        
       return icono;
        
    }
    private ImageIcon redimensionarImagenAlto(ImageIcon icono, int size){
        try {
            tratar = icono.getImage();
            tratar = tratar.getScaledInstance(size, -1, Image.SCALE_SMOOTH);
            icono = new ImageIcon(tratar);
        } catch (NullPointerException e) {
            System.out.println("Error, no se encuentra la imagen o no se ha especificado ninguna");
        }

       return icono;
        
    }
    
    private void barraSuperior() {
        
        this.setLayout(new BorderLayout());
        
        JPanel botones = new javax.swing.JPanel();
        switch(tipo){
            case ATRAS:
                icono2 = new ImageIcon(IMG_ATRAS);
                break;
            case CERRAR:
                icono2 = new ImageIcon(IMG_EQUIS);
                break;
        }
        icono1 = new ImageIcon(IMG_INFO);
        contenedorIcono = new JLabel(imagen);
        btnAyuda = new JButton();
        btnAyuda.setContentAreaFilled(false);
        btnSalir = new JButton();
        btnSalir.setContentAreaFilled(false);
        titulo = new JLabel(tittle);
        
        botones.add(btnAyuda);
        botones.add(btnSalir);
        
        //Color defondo de la barra superior
        //
        if (color == null){
            this.setBackground(Color.GRAY);
            botones.setBackground(Color.GRAY);
        }else{
            this.setBackground(color);
            botones.setBackground(color);
        }
        
        //Icono de la cruz o diferente a la cruz de salir
        //
        if (imagen != null){ 
            this.add(contenedorIcono, BorderLayout.WEST);
            this.add(botones, BorderLayout.EAST);
            
        }else{
            this.add(botones, BorderLayout.EAST);
        }
        
        //Titulo de la ventana
        //
        this.add(titulo, BorderLayout.CENTER);
        
    }
    
    
}

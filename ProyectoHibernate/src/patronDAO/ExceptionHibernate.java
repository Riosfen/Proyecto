package patronDAO;

/**
 * Trata las excepciones de los campos
 * de escritura obligatorios que quedan vacios.
 * 
 * @author Victor Manuel Sanchez Mora
 */
@SuppressWarnings("serial")
public class ExceptionHibernate extends Exception {
    
    public ExceptionHibernate(String msg){
        super(msg);
    }
    
}
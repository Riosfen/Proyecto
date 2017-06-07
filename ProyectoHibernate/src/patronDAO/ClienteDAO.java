package patronDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import persistencia.Cliente;
import persistencia.HibernateUtil;

public class ClienteDAO extends GenericDAO<Cliente> {

	private static final String OBTENER_TODO = "SELECT c FROM Cliente c";

	public Cliente getClientePorDni(String dni){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Cliente cliente = (Cliente) session.createQuery("SELECT c FROM Cliente c WHERE c.dni = '"+dni+"'").uniqueResult();
		
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> obtenerTodo(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(OBTENER_TODO);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarClientePorDni(String dni){
		Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = sesion.createQuery("SELECT c FROM Cliente c WHERE c.dni LIKE '%" + dni + "%'");
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarClientePorNombre(String nombre){
		Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = sesion.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE '%"+nombre+"%'");
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarClientePorApellido(String apellido){
		Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = sesion.createQuery("SELECT c FROM Cliente c WHERE c.apellido LIKE '%"+apellido+"%'");
	
	return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarClientePorTelefono(String telefono){
		Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = sesion.createQuery("SELECT c FROM Cliente c WHERE c.telefono LIKE '%"+telefono+"%'");
	
	return query.list();
	}
	
}

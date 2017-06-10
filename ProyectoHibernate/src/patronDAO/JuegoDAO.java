package patronDAO;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import persistencia.HibernateUtil;
import persistencia.Juego;

public class JuegoDAO extends GenericDAO<Juego> {

	private static final String OBTENER_TODO = "SELECT j FROM Juego j";

	public Juego getJuegoPorNombre(String nombre){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//Juego juego = (Juego) session.createQuery("SELECT j FROM Juego j LEFT JOIN FETCH j.tipoJuego WHERE j.nombre = '"+nombre+"'").uniqueResult();
		Juego juego = (Juego) session.createQuery("SELECT j FROM Juego j WHERE j.nombre = '"+nombre+"'").uniqueResult();
		
		return juego;
	}
	
	@SuppressWarnings("unchecked")
	public List<Juego> buscarJuegoPorNombre(String nombre){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("SELECT j FROM Juego j WHERE j.nombre LIKE '%"+nombre+"%'");
		List<Juego> juegos = query.list();
		
		Set<Juego> juegoDuplicados = new LinkedHashSet<Juego>(juegos);
		juegos.clear();
		juegos.addAll(juegoDuplicados);
		
		return juegos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Juego> buscarJuegoPorEdadMayor(int edad){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("SELECT j FROM Juego j WHERE j.edadMinima >= "+edad);
		List<Juego> juegos = query.list();
		
		Set<Juego> juegoDuplicados = new LinkedHashSet<Juego>(juegos);
		juegos.clear();
		juegos.addAll(juegoDuplicados);
		
		return juegos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Juego> buscarJuegoPorPrecioMayor(double precio){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("SELECT j FROM Juego j WHERE j.precio >= "+precio);
		List<Juego> juegos = query.list();
		
		Set<Juego> juegoDuplicados = new LinkedHashSet<Juego>(juegos);
		juegos.clear();
		juegos.addAll(juegoDuplicados);
		
		return juegos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Juego> obtenerTodo(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(OBTENER_TODO);
		
		return query.list();
	}
	
}

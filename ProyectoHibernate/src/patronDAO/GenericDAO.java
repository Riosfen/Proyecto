package patronDAO;

import java.util.List;

import persistencia.HibernateUtil;

public class GenericDAO<T> {
	
	public void guardar(T entidad) {

		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		HibernateUtil.getSessionFactory().getCurrentSession().save(entidad);
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		HibernateUtil.getSessionFactory().getCurrentSession().refresh(entidad);
		
	}
	
	public void actualizar(T entidad) {

		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		HibernateUtil.getSessionFactory().getCurrentSession().update(entidad);
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		HibernateUtil.getSessionFactory().getCurrentSession().flush();
		HibernateUtil.getSessionFactory().getCurrentSession().refresh(entidad);
	}
	
	public  void borrar(T entidad) {

		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		HibernateUtil.getSessionFactory().getCurrentSession().delete(entidad);
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
	}
	
	public List<T> consultarTodo(Object entidad) {

		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		org.hibernate.Query query = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("SELECT e FROM " + entidad + " e");
		@SuppressWarnings("unchecked")
		List<T> entities = query.list();
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		return entities;
	}
	
	public void rollback (){

		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
    }
	
}

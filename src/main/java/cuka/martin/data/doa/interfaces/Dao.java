package cuka.martin.data.doa.interfaces;

import java.util.List;

import org.hibernate.Session;

public interface Dao<T,ID> {
	
	public T findById(Long id);
	
	public List<T> findAll();
	
	public T save(T entity);
	
	public void delete(T entity);
	
	public void flush();
	
	public void clear();
	
	public void setSession(Session session);
}

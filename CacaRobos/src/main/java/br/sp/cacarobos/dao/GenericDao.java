package br.sp.cacarobos.dao;
import java.util.List;
public interface GenericDao<T> {
	public void create(T t);
	public T read(Long t);
	public void update(T t);
	public void delete(Long t);
	public List<T> listAll();
}
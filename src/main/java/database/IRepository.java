package database;

public interface IRepository<T>  {
    void Insert(T entity);
}

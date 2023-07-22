package application;


import java.util.List;
public interface IDao<T> {
boolean  create(T o);

List<Person> findAll();

Person findByNom(String nom);


boolean delete(Person o);

boolean update(Person o, String prenom, String nom, String email, String tel);




}

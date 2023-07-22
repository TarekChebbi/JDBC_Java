package application;
import java.sql.Connection;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
import application.Person; 
import application.Connexion;
import application.IDao;
public class  PersonService implements IDao<Person>{

	public PersonService()
	{};
	
	@Override
	public  boolean  create(Person o) {
		
			try {
			String req = "insert into person ( prenom,nom,email,tel) values ('" + o.getPrenom() + "', '"+ o.getNom() + "','" + o.getEmail() + "','" + o.getTel() + "')";
			Statement st = Connexion.getCn().createStatement();			if
			(st.executeUpdate(req) == 1) {
			return true;
			} }
			catch (SQLException ex) {
			System.out.println("Erreur SQL");
			} return false;
			 }
    @Override
    public boolean delete(Person o) {
        try {
            String req = "DELETE FROM person WHERE nom = '" + o.getNom() + "' AND email = '" + o.getEmail()
                    + "' AND tel = '" + o.getTel() + "'";
            Statement st = Connexion.getCn().createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        }
        return false;
    }

    @Override
    public boolean update(Person o,String prenom,String nom,String email,String tel) {
        try {
            String req = "UPDATE person SET prenom = '" + prenom + "', nom = '"+nom+"', email = '" + email
                    + "', tel = '" + tel + "' WHERE nom = '" + o.getNom() + "'";
            Statement st = Connexion.getCn().createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        }
        return false;
    }

    @Override
    public Person findByNom(String nom) {
        try {
            String req = "SELECT * FROM person WHERE nom = '" + nom + "'";
            Statement st = Connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                return new Person(prenom, nom, email, tel);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();
        try {
            String req = "SELECT * FROM person";
            Statement st = Connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                personList.add(new Person(prenom, nom, email, tel));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL");
        }
        return personList;
    }
}





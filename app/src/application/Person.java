package application;

public class Person {
	private String prenom;
	private String nom;
	private String email;
	private String tel;
	public Person(String prenom, String nom, String email, String tel) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email=email;
		this.setTel(tel);
		}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Person [prenom=" + prenom + ", nom=" + nom + ", adresse-mail =" + email + ",telephone= "+tel+"]";
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	

}

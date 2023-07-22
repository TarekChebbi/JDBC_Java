package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class AddBookController implements Initializable {
	 @FXML
	 private TextField tfLastName;
	 @FXML
	 private TextField tfFirstName;
	 @FXML
	 private TextField tfEmail;
	 @FXML
	 private TextField tfTel;
	 @FXML
	 private Button addBtn;
	 @FXML
	 private Button exportBtn;
	 @FXML
	 private Button importBtn;
	 @FXML
	 private Button removeBtn;
	 @FXML
	 private Button quitBtn;
	 @FXML
	 private TableView<Person> table;
	 @FXML
	 private TableColumn<Person, String> emailCol;
	 @FXML
	 private TableColumn<Person, String> firstNameCol;
	 @FXML
	 private TableColumn<Person, String> lastNameCol;
	 @FXML
	 private TableColumn<Person, String> telCol;
	 private PersonService s =new PersonService();
	  private DataClass data = new DataClass();
	    private ObservableList<Person> list = FXCollections.observableArrayList(); 

	    @Override
	    public void initialize(URL url, ResourceBundle resourceBundle) {
	    	table.setEditable(true);
	        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
	        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
	        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
	        telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
	        
	        
	        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
	        telCol.setCellFactory(TextFieldTableCell.forTableColumn());

	        try {
	            list.addAll(data.getImportList());
	            table.setItems(list);
	        } catch (Exception e) {
	            System.err.println("Erreur lors de l'ajout des personnes à la liste : " + e.getMessage());
	        }
	    }

	    public ObservableList<Person> getList(){
	        return list;
	    }
	    public void addPersonne() {
	        String nom = tfFirstName.getText();
	        String prenom = tfLastName.getText();
	        String email = tfEmail.getText();  
	        String tel= tfTel.getText(); 
	        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty()) {
	        	
	            System.out.println("Veuillez remplir tous les champs.");
	            return;
	        }
	    	s.create(new Person(prenom, nom, email,"20587489"));

	        list.add(new Person(prenom, nom, email,"20587489"));
	        tfFirstName.clear();
	        tfLastName.clear();
	        tfEmail.clear();
	        tfTel.clear();
	   }

	   @FXML
	    public void removePersonne() {
	        Person selectedPerson = table.getSelectionModel().getSelectedItem();

	        if (selectedPerson == null) {
	            System.out.println("Veuillez sélectionner une personne à supprimer.");
	            return;
	        }
s.delete(selectedPerson);
	        list.remove(selectedPerson);
	    }
	   
	   @FXML
	    public void modifier() {
		      String nom = tfFirstName.getText();
		        String prenom = tfLastName.getText();
		        String email = tfEmail.getText();  
		        String tel= tfTel.getText(); 
	        Person selectedPerson = table.getSelectionModel().getSelectedItem();
	  
	        
	        if (selectedPerson == null) {
	            System.out.println("Veuillez sélectionner une personne à modifier.");
	            return;
	        }
	        
	        
	       
s.update(selectedPerson,nom,prenom,email,tel);
	        list.remove(selectedPerson);
	        list.add(new Person(nom,prenom,email,tel));
	    }
	   @FXML
	    public void select() {
		       
	        Person selectedPerson = table.getSelectionModel().getSelectedItem();
	  
	        tfFirstName.setText(selectedPerson.getPrenom());
		       tfLastName.setText(selectedPerson.getNom());
		  tfEmail.setText(selectedPerson.getEmail());  
		      tfTel.setText(selectedPerson.getTel());

   }
	 @FXML
	    public void exporterListe() {
	        //data.setExportList(list);
	        for (Person p: table.getItems())
	        	System.out.println(p);
	    }

	    @FXML
	    public void importerListe() {
	    	
	        list.clear();
	        list.addAll(s.findAll());
	    }

	    @FXML
	    public void quitterApplication() {
	        System.exit(0);
	    }
	}
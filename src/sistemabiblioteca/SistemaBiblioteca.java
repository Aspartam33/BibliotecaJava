/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabiblioteca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;


  
  

        

/**
 *
 * @author david
 */
public class SistemaBiblioteca {
       Connection conec;
       Statement instruc;
    /**
     * @param args the command line arguments
     */
    public SistemaBiblioteca(){
       
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conec=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca_ud2","root","");
            instruc=conec.createStatement();
        
        }
        catch (ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog (null, ex, "ADEVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void verReportes (String cod, Map parame){
        try{
        JasperReport jr= JasperCompileManager.compileReport(cod);
        JasperPrint jp= JasperFillManager.fillReport(jr,parame,conec);
        JasperViewer.viewReport(jp,false);
        }
        catch(JRException e) {
             JOptionPane.showMessageDialog (null, e, "ADEVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    
    }
    
}

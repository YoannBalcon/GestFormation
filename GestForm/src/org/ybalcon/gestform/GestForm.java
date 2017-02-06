package org.ybalcon.gestform;

import org.ybalcon.gestform.model.Frame;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import org.ybalcon.gestform.Dao.ConnectDb;

import org.ybalcon.gestform.Dao.FormationDao;
import org.ybalcon.gestform.model.Formation;
import org.ybalcon.gestform.model.Stagiaire;
import sun.applet.Main;

public class GestForm {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Formation formation = new Formation("Dev Logi");
        char reponse = 'O';
        int code = 0;
        int menu = 0;
        Frame frame = new Frame();
        frame.setVisible(true);
        while (reponse == 'O' || reponse == 'N') {

            System.out.println(" *===================================*");
            System.out.println("/ |   _ __ ___   ___ _ __  _   _     |");
            System.out.println("| |  | '_ ` _ \\ / _ \\ '_ \\| | | |    |");
            System.out.println("| |  | | | | | |  __/ | | | |_| |    |");
            System.out.println("| |  |_| |_| |_|\\___|_| |_|\\__,_|    |");
            System.out.println("| |                                  |");
            System.out.println("| |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("| | 1> Ajouter un stagiaire          |");
            System.out.println("| |                                  |");
            System.out.println("| |      2> Afficher les stagiaires  |");
            System.out.println("| |                                  |");
            System.out.println("| |..................................|");
            System.out.println("| |                                  |");
            System.out.println("| | 3> Ajouter une formation         |");
            System.out.println("| |                                  |");
            System.out.println("| |      4> Afficher les formations  |");
            System.out.println("| |                                  |");
            System.out.println("| |                                  |");
            System.out.println("| |..................................|");
            System.out.println("| | 5> Quitter                       |");
            System.out.println("| |                                  |");
            System.out.println("| *==================================*");
            System.out.println("/___________________________________/");

            menu = Integer.parseInt(sc.nextLine());

            if (menu == 1) {
                reponse = 'O';

                while (reponse == 'O') {
                    reponse = ' ';
                    code++;
                    int id = 0;

                    System.out.println("Veuillez saisir un nom :");
                    String v_nom = sc.nextLine();

                    System.out.println("Veuillez saisir un prenom :");
                    String v_prenom = sc.nextLine();

                    Stagiaire stagiaire = new Stagiaire(id, v_nom, v_prenom,
                            code);

                    System.out.println(v_prenom + " " + v_nom + " est inscrit");
                    formation.addStagiaire(stagiaire);

                    System.out.println("Voulez-vous continuer ? (O/N)");
                    reponse = sc.nextLine().charAt(0);
                }
            } else if (menu == 2) {
                for (int i = 0; i < formation.getStagiaires().size(); i++) {
                    Stagiaire stg = formation.getStagiaires().get(i);
                    System.out.println(stg.getNom() + " " + stg.getPrenom()
                            + " " + stg.getMatricule());
                    Thread.sleep(3000);
                }

//            } else if (menu == 3) {
//                System.out.print("Veuillez entrer un nom de formation");
//                String v_form = sc.nextLine();
//                FormationDao.create(v_form);
//                System.out.print("Formation \"" + v_form + "\" enregistrée !");
//                Thread.sleep(3000);

            } else if (menu == 4) {
                List<Formation> formations = FormationDao.findAll();
                for (Formation form : formations) {
                    System.out.print(form.getId() + " " + form.getNom() + "\n");
                }
                int id = sc.nextInt();
                Formation f = null;
                for (Formation form : formations) {
                    if (form.getId() == id) {
                        f = form;
                        break;
                    }
                }

                Thread.sleep(4000);

            } else {
                System.out.println("ciao ciao");
                break;
            }
        }
          
    }

}

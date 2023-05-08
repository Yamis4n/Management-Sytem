package com.evertonvsf.managementsystem.tests;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.dao.crud.users.technician.TechnicianListImpl;
import com.evertonvsf.managementsystem.models.users.Technician;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class TechnicianTest {
    public static void main(String[] args) {
        int choice;
        System.out.println("digite 1 para criar e 2 para ler");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        if (choice == 1) {
            Technician tech1 = addTechnician("everton", "everton123", "evertonvsf@gmail.com");
            Technician tech2 = addTechnician("vinicius", "vini123", "vini@gmail.com");
            System.out.println(tech1);
            System.out.println(tech2);
            DAO.getTechnicianDAO().writePersistence();
        }
        else if (choice == 2){
            List<Technician> technicians = DAO.getTechnicianDAO().findMany();
            for (Technician tech : technicians){
                System.out.println(tech);
            }
        }
        else {
            System.out.println("bye");
        }

    }

    public static Technician addTechnician(String name, String password, String email){
        return DAO.getTechnicianDAO().create(new Technician(name, password, email));
    }

}

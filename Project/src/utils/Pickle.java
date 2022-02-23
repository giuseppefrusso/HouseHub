/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pepito
 */
public class Pickle {

    public static boolean save(String path, Serializable obj) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Pickle.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static Serializable load(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (Serializable) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Pickle.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}

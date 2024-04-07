package persistence.local;

import business.entity.BaseProperty;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PropertiesDatabaseManagerImpl implements PropertyDatabaseManager {
    private static final String directoryPath = "cache/";
    private static final String databasePath = directoryPath + "real_estate_agency_db.txt";
    private static final File pathFile = new File(directoryPath);
    private static final File databaseFile = new File(databasePath);

    @Override
    public void saveAll(Collection<BaseProperty> properties) {
        createIfNotExists();
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(databaseFile, false))) {
            for (BaseProperty property : properties) {
                stream.writeObject(property);
            }
        } catch (FileNotFoundException e) {
            createIfNotExists();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BaseProperty> getAll() {
        List<BaseProperty> properties = new ArrayList<>();
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(databaseFile))) {
            while (true) {
                BaseProperty property = (BaseProperty) stream.readObject();
                properties.add(property);
            }
        } catch (EOFException e) {
            //System.out.println(e.getMessage());
        } catch (IOException e) {
            //System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
        }
        return properties;
    }

    private void createIfNotExists() {
        try {
//            if (pathFile.exists() && databaseFile.exists()) return;
            pathFile.mkdirs();
            databaseFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

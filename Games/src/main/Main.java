package homeworkFile.Games.src.main;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.*;

class Main {
    public static void main(String[] args) {
        GameProgress save1 = new GameProgress(100, "pistol", 5, 15.00);
        GameProgress save2 = new GameProgress(300, "shotgun", 10, 8.00);
        GameProgress save3 = new GameProgress(250, "carbine", 20, 50.00);

        saveGame("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
                "src\\homeworkFile\\Games\\saveGames\\save1.dat", save1);
        saveGame("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
                "src\\homeworkFile\\Games\\saveGames\\save2.dat", save2);
        saveGame("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
                "src\\homeworkFile\\Games\\saveGames\\save3.dat", save3);

     ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
                "src\\homeworkFile\\Games\\saveGames\\save1.dat");
        arrayList.add("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
                "src\\homeworkFile\\Games\\saveGames\\save2.dat");
        arrayList.add("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
                "src\\homeworkFile\\Games\\saveGames\\save3.dat");

        zipFiles("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
                "src\\homeworkFile\\Games\\saveGames\\zip.zip", arrayList);

        deleteFile("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
                "src\\homeworkFile\\Games\\saveGames\\save1.dat");
        deleteFile("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
                "src\\homeworkFile\\Games\\saveGames\\save2.dat");
        deleteFile("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
                "src\\homeworkFile\\Games\\saveGames\\save3.dat");

//        String[] st = new String[]{"D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
//                "src\\homeworkFile\\Games\\saveGames\\save1.dat",
//                "D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
//                        "src\\homeworkFile\\Games\\saveGames\\save2.dat",
//                "D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
//                        "src\\homeworkFile\\Games\\saveGames\\save3.dat"};
//        zipFiles1("D:\\Обучение Нетология\\Директории\\NetologyHomework\\" +
//                "src\\homeworkFile\\Games\\saveGames\\zip.zip", st);
    }

    public static void saveGame(String way, GameProgress save) {
        try (FileOutputStream stream = new FileOutputStream(way);
             ObjectOutputStream oos = new ObjectOutputStream(stream)) {
            oos.writeObject(save);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String wayZip, ArrayList<String> file) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(wayZip))) {
            for (String way : file) {
                try (FileInputStream fis = new FileInputStream(way)) {
                    ZipEntry entry = new ZipEntry(way);
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteFile(String file) {
        File file1 = new File(file);
        file1.delete();
    }

//    public static void zipFiles1(String wayZip, String[] file) {
//        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(wayZip))) {
//            for (int i = 0; i < file.length; i++) {
//                try (FileInputStream fis = new FileInputStream(file[i])) {
//                    ZipEntry entry = new ZipEntry(file[i]);
//                    zout.putNextEntry(entry);
//                    byte[] buffer = new byte[fis.available()];
//                    fis.read(buffer);
//                    zout.write(buffer);
//                    zout.closeEntry();
//                }
//            }
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
}

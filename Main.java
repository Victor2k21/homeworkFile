package homeworkFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringBuilder history = new StringBuilder();

        List<File> direc = new ArrayList<>();
        List<File> files = new ArrayList<>();

        File src = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\src");
        File res = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\res");
        File saveGames = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\saveGames");
        File temp = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\temp");

        File main = new File(src, "main");
        File test = new File(src, "test");

        File mainJava = new File(main, "Main.java");
        File utilsJava = new File(main, "Utils.java");

        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");

        File tempTxt = new File(temp, "temp.txt");

        direc.add(src);
        direc.add(res);
        direc.add(saveGames);
        direc.add(temp);
        direc.add(main);
        direc.add(test);
        direc.add(drawables);
        direc.add(vectors);
        direc.add(icons);

        files.add(mainJava);
        files.add(utilsJava);

        for (File file : direc) {
            newDirectory(file, history);
        }
        for (File file : files) {
            newDirectory(file, history);
        }

        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write(String.valueOf(history));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    static void newDirectory(File file, StringBuilder sb) {
        String time = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(Calendar.getInstance().getTime());
        if (file.mkdir()) {
            sb.append("Создался каталог ").append(file.getName())
                    .append(". Дата: ").append(time).append("\n");
        }

    }

    static void newFile(File file, StringBuilder sb) {
        String time = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(Calendar.getInstance().getTime());
        try {
            if (file.createNewFile()) {
                sb.append("Создался файл ").append(file.getName())
                        .append(". Дата: ").append(time).append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
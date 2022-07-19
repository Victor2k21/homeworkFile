package homeworkFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        StringBuilder history = new StringBuilder();

        File src = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\src");
        File res = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\res");
        File saveGames = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\saveGames");
        File temp = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\temp");
        File main = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\src\\main");
        File test = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\src\\test");
        File mainJava = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\src\\main\\Main.java");
        File utilsJava = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\src\\main\\Utils.java");
        File drawables = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\res\\drawables");
        File vectors = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\res\\vectors");
        File icons = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\res\\icons");
        File tempTxt = new File("D:\\Обучение Нетология\\Директории\\NetologyHomework\\src\\" +
                "homeworkFile\\Games\\temp\\temp.txt");

        newDirectory(src, history);
        newDirectory(res, history);
        newDirectory(saveGames, history);
        newDirectory(temp, history);
        newDirectory(main, history);
        newDirectory(test, history);
        newFile(mainJava, history);
        newFile(utilsJava, history);
        newDirectory(drawables, history);
        newDirectory(vectors, history);
        newDirectory(icons, history);
        newFile(tempTxt, history);

        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write(String.valueOf(history));
            writer.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

//        System.out.println(history);
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
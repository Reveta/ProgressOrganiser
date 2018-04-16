package ua.com.reveta.controller;

import lombok.Getter;
import lombok.Setter;
import ua.com.reveta.model.Achievement;
import ua.com.reveta.utils.Prop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class IOFile {

    private int sizeAchievement;

    private static IOFile ioFile;

    public static IOFile getTOFile() {
        if (ioFile != null) {
            ioFile = new IOFile();
            createFolders();
        }

        return ioFile;
    }

    public void InputAchievement(Achievement achievement) {
        String way = null;
        switch (achievement.getAchievementType()) {
            case LEETCODE_EXERCISE:
                way = Prop.getProp("toLeetCodeDir");
                break;
            case EPAM_EXERCISE:
                way = Prop.getProp("toEpamDir");
                break;
            case OTHER_ACHIVMENT:
                way = Prop.getProp("toOtherDir");
                break;
        }
        createFile(way, achievement);
    }

    private void createFile(String way, Achievement achievement) {
        try {
            File file = new File(way + String.valueOf(0001) + ".txt");
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            printWriter.print(achievement);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findAchievement(int idFile) {
        try {
            String id = String.valueOf(idFile);
            List<File> allFiles = findAllFiles();

            File file = allFiles.stream()
                    .filter(s -> s.getName().equals(id + ".txt"))
                    .findFirst()
                    .get();

            BufferedReader bufferedReader =
                    new BufferedReader(
                            new FileReader(file));

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<File> findAllFiles() throws IOException {
        return Files.walk(Paths.get(Prop.getProp("toRepository")))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
    }


    private static void createFolders() {
        boolean mkContrdir = new File(Prop.getProp("toRepository")).mkdirs();
        boolean mkEpamDir = new File(Prop.getProp("toEpamDir")).mkdirs();
        boolean mkLeetCodeDir = new File(Prop.getProp("toLeetCodeDir")).mkdirs();
        boolean mkOtherDir = new File(Prop.getProp("toOtherDir")).mkdirs();

        System.out.println(mkContrdir + " " + mkEpamDir + " " + mkLeetCodeDir + " " + mkOtherDir);


    }
}
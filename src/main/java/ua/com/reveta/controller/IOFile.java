package ua.com.reveta.controller;

import lombok.Getter;
import lombok.Setter;
import ua.com.reveta.model.Achievement;
import ua.com.reveta.utils.Prop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class IOFile {

    private int numFiles;
    private static IOFile ioFile;

    private IOFile() {
        this.numFiles = findAllFiles().size();
    }

    public static IOFile getTOFile() {
        if (ioFile == null) {
            ioFile = new IOFile();
            createFolders();
        }

        return ioFile;
    }

    void saveAchievement(Achievement achievement) {
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
            File file = new File(way + String.valueOf(achievement.getId()) + ".txt");
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            printWriter.print(achievement);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String findAchievement(int idFile) {
        File file;
        String fileInfo = "";
        try {
            String id = String.valueOf(idFile);
            List<File> allFiles = findAllFiles();

            file = allFiles.stream()
                    .filter(s -> s.getName().equals(id + ".txt"))
                    .findFirst()
                    .get();

            BufferedReader bufferedReader =
                    new BufferedReader(
                            new FileReader(file));

            String s;
            while ((s = bufferedReader.readLine()) != null) {
                fileInfo = fileInfo + ""+ s + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileInfo;
    }

    private List<File> findAllFiles(){
        List<File> list = new ArrayList<>();
        try {
            list = Files.walk(Paths.get(Prop.getProp("toRepository")))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    private static void createFolders() {
        boolean mkContrdir = new File(Prop.getProp("toRepository")).mkdirs();
        boolean mkEpamDir = new File(Prop.getProp("toEpamDir")).mkdirs();
        boolean mkLeetCodeDir = new File(Prop.getProp("toLeetCodeDir")).mkdirs();
        boolean mkOtherDir = new File(Prop.getProp("toOtherDir")).mkdirs();

        System.out.println(mkContrdir + " " + mkEpamDir + " " + mkLeetCodeDir + " " + mkOtherDir);


    }

    public int getNumFiles() {
        this.numFiles = findAllFiles().size();
        return numFiles;
    }
}
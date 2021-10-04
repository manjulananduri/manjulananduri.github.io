package framework;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileGenerator {
    public static void main(String[] args) {
        String title = "Network Delay Time";
        String postTitle = "Network Delay Time - (Leetcode 743) - Coding Interview Question";
        String postFileSuffix = "-coding-interview-question";
        new FileGenerator().generate(title, postTitle, postFileSuffix);
    }

    private void generate(String title, String postTitle, String postFileSuffix) {
        String filePrefix = String.join("", title.split(" "));
        String postFilePrefix = String.join("-", title.split(" ")) + postFileSuffix;

        String questionFile = filePrefix + Constants.QUESTION_FILE_SUFFIX.getValue();
        String solutionFile = filePrefix + Constants.SOLUTION_FILE_SUFFIX.getValue();
        String postFile = postFilePrefix + Constants.POST_FILE_SUFFIX.getValue();

        String postFilePath = Constants.POST_FILE_PATH.getValue() + postFile;

        //QuestionFile
        writeFile("", Constants.QUESITON_FILE_PATH.getValue() + questionFile);
        //PostFile
        generatePost(postFilePath, postTitle, questionFile, solutionFile);
        //SolutionFile
        writeFile("", Constants.SOLUTION_FILE_PATH.getValue() + solutionFile);
    }

    private void generatePost(String postPath, String postTitle, String questionFileName, String solutionFileName) {
        String file = readLineByLineJava8(Constants.POST_TEMPLATE_FILE_PATH.getValue());
        file = file.replaceAll(">>>postTitle<<<", postTitle);
        file = file.replaceAll(">>>questionFileName<<<", questionFileName);
        file = file.replaceAll(">>>solutionFileName<<<", solutionFileName);
        writeFile(file, postPath);
    }

    private void writeFile(String content, String filePath) {
        try {
            if (Files.exists(Paths.get(filePath))) {
                System.err.println("File already exists: " + filePath);
            } else {
                Files.write(Paths.get(filePath), content.getBytes());
                System.out.println("File Creation successful: " + filePath);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static String readLineByLineJava8(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }


    enum Constants {
        QUESTION_FILE_SUFFIX("Question.html"),
        SOLUTION_FILE_SUFFIX(".java"),
        POST_FILE_SUFFIX(".md"),

        BASE_PATH(System.getProperty("user.dir") + "/"),
        JAVA_CODE_PATH(BASE_PATH.getValue() + "src/"),
        CODING_INTERVIEW_PATH(BASE_PATH.getValue() + "_interviews/coding/"),

        SOLUTION_FILE_PATH(CODING_INTERVIEW_PATH.getValue() + "solutions/java/"),
        QUESITON_FILE_PATH(CODING_INTERVIEW_PATH.getValue() + "question/"),

        POST_TEMPLATE_FILE_PATH(JAVA_CODE_PATH.getValue() + "template/posttemplate.template"),
        POST_FILE_PATH(CODING_INTERVIEW_PATH.getValue());

        private String value;

        Constants(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Введите дату начала и примерного окончания проекта в формате дд.мм.гггг:");
        Scanner scanner = new Scanner(System.in);
        do{
            String input = scanner.next();
            Date begin = java.util.Date.from(LocalDate.parse(input, dateTimeFormatter).atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant());
            input = scanner.next();
            Date end = java.util.Date.from(LocalDate.parse(input, dateTimeFormatter).atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant());
            Project project = new Project();
            project.end = end;
            project.start = begin;
            System.out.println(project.getProjectCompletePercentage());
        }
        while(scanner.hasNext());
    }
}

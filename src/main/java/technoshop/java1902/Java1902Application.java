package technoshop.java1902;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import technoshop.java1902.jdbc.DbWorker;
import technoshop.java1902.telegramBot.Bot;

@SpringBootApplication
public class Java1902Application {

    public static void main(String[] args) {
//        DbWorker dbWorker = new DbWorker();
//        dbWorker.connect();
//        System.out.println(dbWorker.getUserCount());
        SpringApplication.run(Java1902Application.class, args);
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

}

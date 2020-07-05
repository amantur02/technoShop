package technoshop.java1902.telegramBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import technoshop.java1902.entity.User;
import technoshop.java1902.service.UserService;

import java.util.Collections;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Autowired
    private UserService userService;
    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        String text = msg.getText();

        if (text.equals("/start")){
            userService.create(new User("login", "123"));
        }else if (text.equals("stop")){
//            userService.getAll();
            List list = Collections.singletonList(userService.getAll().toString());
            sendMsg(msg,list.toString());
        }


    }
    @SuppressWarnings("deprecation") // Означает то, что в новых версиях метод уберут или заменят
    private void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
        s.setText(text);
        try { //Чтобы не крашнулась программа при вылете Exception
            Buttons.setButtons(s);
            execute(s);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "PhoneshopParserBot";
    }

    @Override
    public String getBotToken() {
        return "1368916287:AAGr_Vx7GJv6MZiZwUxwmcnUefFKhg7If0c";
    }
}

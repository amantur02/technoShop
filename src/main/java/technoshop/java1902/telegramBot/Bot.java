package technoshop.java1902.telegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import technoshop.java1902.jdbc.TelegramJdbc;
import technoshop.java1902.parser.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    TelegramJdbc telegramJdbc = new TelegramJdbc();
    @Override
    public void onUpdateReceived(Update update) {
        OnUpdateReceived onUpdateReceived = new OnUpdateReceived();
        try {
            onUpdateReceived.runUpdate(update);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendImageFromUrl (Message msg, String url){
        SendPhoto s = new SendPhoto();
        s.setChatId(msg.getChatId());
        s.setPhoto(url);
        try {
            execute(s);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation") // Означает то, что в новых версиях метод уберут или заменят
    public void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
        s.setText(text);
        try { //Чтобы не крашнулась программа при вылете Exception
            Buttons.setButtons(s);
//            Buttons.setInline();
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

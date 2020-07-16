package technoshop.java1902.telegramBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Buttons {
    public static synchronized void setButtons(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardButtonsFirst = new KeyboardRow();
        keyboardButtonsFirst.add(new KeyboardButton("/help"));
        KeyboardRow keyboardButtonsSecond = new KeyboardRow();
        keyboardButtonsSecond.add(new KeyboardButton("/start"));

        keyboard.add(keyboardButtonsFirst);
        keyboard.add(keyboardButtonsSecond);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
    public static void setInline() {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        buttons1.add(new InlineKeyboardButton().setText("/Button").setCallbackData("http://ostore.kg/upload/resize_cache/iblock/48c/220_200_1/1eb076c355038775dc87fb1bb40110aa.png"));
        buttons.add(buttons1);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
    }
//
//    public static SendMessage setInline(String buttons){
//        List<List<InlineKeyboardButton>> listList = new ArrayList<>();
//        List<InlineKeyboardButton> list = new ArrayList<>();
//        list.add(new InlineKeyboardButton().setText("Еще 10").setCallbackData(buttons));
//
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//        inlineKeyboardMarkup.setKeyboard(listList);
//    }
//    public static SendMessage sendInlineKeyBoardMessage2(long chatId) {
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
//        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//        inlineKeyboardButton1.setText("Тык");
//        inlineKeyboardButton1.setCallbackData("Hel");
//        inlineKeyboardButton2.setText("hoj");
//        inlineKeyboardButton2.setCallbackData("sddsd");
//        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
//        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
//        keyboardButtonsRow1.add(inlineKeyboardButton1);
//        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("Fi4a").setCallbackData("fewf"));
//        keyboardButtonsRow2.add(inlineKeyboardButton2);
//        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
//        rowList.add(keyboardButtonsRow1);
//        rowList.add(keyboardButtonsRow2);
//        inlineKeyboardMarkup.setKeyboard(rowList);
//        return new SendMessage().setChatId(chatId).setText("Пример").setReplyMarkup(inlineKeyboardMarkup);
//    }


}

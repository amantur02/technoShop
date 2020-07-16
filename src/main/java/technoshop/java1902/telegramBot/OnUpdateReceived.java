package technoshop.java1902.telegramBot;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import technoshop.java1902.jdbc.TelegramJdbc;
import technoshop.java1902.parser.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OnUpdateReceived {
    public void runUpdate(Update update) throws IOException {
        Bot bot = new Bot();
        Message msg = update.getMessage();
        String text = msg.getText();
        TelegramJdbc telegramJdbc = new TelegramJdbc();


        if (text.equals("/start")){                                 //Авторизация
            bot.sendMsg(msg,"Введите пароль:");
        }else if (text != null &&
                TelegramMethod.removeChars(text,1).equals("/") == false
                && TelegramMethod.removeChars(text, 2).equals("//") == false){
            Integer userId = telegramJdbc.selectFromUsers(text);
            if (userId != null){
                String response = telegramJdbc.createTelegramRegistration(msg.getChatId(), userId);
                bot.sendMsg(msg, response);
            }else
                bot.sendMsg(msg,"Не верный пароль");
        }

        if (text.equals("/help")){
            bot.sendMsg(msg,"Руководство" + "\n" +
                    "Показать все смартфоны: // названия смартфона // кол-тво" + "\n" +
                    "Показать все смартфоны по модели: /search_name- названия смартфона - модель" + "\n" +
                    "Показать все смартфоны по цене: /search_price- назания смартфона - цена от - и до" + "\n" +
                    "Оставить свое мнение о смартфоне: /comment_for- назания смартфона - ваше мнение о смартфоне" + "\n" +
                    "Посмотреть коментарии о смартфоне: /view_comment - названия смартфона");
        }



        List<Article> MainList = new ArrayList<>();
        if (text.equals("Вывести все сматрфоны")){
            bot.sendMsg(msg, "Напешите наименования смартфона c // а рядом кол-тво" +
                    "\n К примеру //apple//5");

        }else if (TelegramMethod.removeChars(text, 2).equals("//")){
            String nameDevice = TelegramMethod.splitString(text, "//").get(1);
            Integer quantity = Integer.valueOf(TelegramMethod.splitString(text, "//").get(2));

            bot.sendMsg(msg, "Загружаю...");

            try {
                MainList = TelegramMethod.getAllDevice(nameDevice);
            } catch (IOException e) {
                e.printStackTrace();
            }
            bot.sendMsg(msg, "Найдено: " + MainList.size() + "смартфонов"
                    + "\n по вашему запросу: /" + nameDevice);
            List<ArticlePhones> newList = new ArrayList<>();
            for (int i = 0; i < quantity; i++) {
                bot.sendImageFromUrl(msg,MainList.get(i).getLinkPicture());
                newList.add(new ArticlePhones(MainList.get(i).getNameCompany(),
                        MainList.get(i).getName(), MainList.get(i).getPrice(),
                            MainList.get(i).getLink()));
                bot.sendMsg(msg,newList.get(i).toString());
                bot.sendMsg(msg, "/comment_for-" + newList.get(i).getName());
            }


        }else if (TelegramMethod.splitString(text, "-").get(0).equals("/search_name")){
            String model = TelegramMethod.splitString(text, "-").get(2);
            String name = TelegramMethod.splitString(text, "-").get(1);
            List<Article> list = TelegramMethod.searchByName(name,model);

            bot.sendMsg(msg, "Загружаю...");

            List<ArticlePhones> newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                bot.sendImageFromUrl(msg,list.get(i).getLinkPicture());

                newList.add(new ArticlePhones(list.get(i).getNameCompany(),
                        list.get(i).getName(), list.get(i).getPrice(),
                            list.get(i).getLink()));
                bot.sendMsg(msg,newList.get(i).toString());
                bot.sendMsg(msg,"Оставить комментарий: /comment_for-" + list.get(i).getName() + " -Комментарий");
                bot.sendMsg(msg,"Посмотреть комментарий: /view_comment-" + list.get(i).getName());
            }


        }else if (TelegramMethod.splitString(text,"-").get(0).equals("/search_price")) {
            String name = TelegramMethod.splitString(text, "-").get(1);
            Integer from = Integer.valueOf(TelegramMethod.splitString(text, "-").get(2));
            Integer before = Integer.valueOf(TelegramMethod.splitString(text, "-").get(3));

            List<Article> list = TelegramMethod.searchByPrice(name,from,before);

            bot.sendMsg(msg, "Загружаю...");

            List<ArticlePhones> newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                bot.sendImageFromUrl(msg,list.get(i).getLinkPicture());

                newList.add(new ArticlePhones(list.get(i).getNameCompany(),
                        list.get(i).getName(), list.get(i).getPrice(),
                            list.get(i).getLink()));
                bot.sendMsg(msg,newList.get(i).toString());
                bot.sendMsg(msg,"Оставить комментарий: /comment_for-" + list.get(i).getName() + " - Комментарий");
                bot.sendMsg(msg,"Посмотреть комментарий: /view_comment-" + list.get(i).getName());
            }
        }

        if (TelegramMethod.splitString(text,"-").get(0).equals("/comment_for")){
            String name = TelegramMethod.splitString(text, "-").get(1);
            String comment = TelegramMethod.splitString(text, "-").get(2);

            bot.sendMsg(msg, "Загружаю...");

            Integer userId = telegramJdbc.selectFromTelegramRegistration(msg.getChatId());

            if (userId != null){
                String response = telegramJdbc.createComments(name,userId,comment);
                bot.sendMsg(msg,response);
            }else
                bot.sendMsg(msg,"Вы не зарегестрированы");


        }else if (TelegramMethod.splitString(text,"-").get(0).equals("/view_comment")){
            String name = TelegramMethod.splitString(text, "-").get(1);
            Integer userId = telegramJdbc.selectFromTelegramRegistration(msg.getChatId());

            bot.sendMsg(msg, "Загружаю...");

            if (userId != null) {
                List<String> listResponse = telegramJdbc.selectFromComment(name);
                bot.sendMsg(msg, String.valueOf(listResponse.size()));

                for (int i = 0; i < listResponse.size(); i++){
                    Long commentUserId = Long.valueOf(TelegramMethod.splitString(listResponse.get(i), "-").get(0));
                    String comment = TelegramMethod.splitString(listResponse.get(i), "-").get(1);

                    String nameUser = telegramJdbc.selectFromUsersWhereId(commentUserId);

                    bot.sendMsg(msg, "Кто оставил комментарий: " + nameUser + "\n" +
                            "Коментарий: " + comment);
            }
            }else
                bot.sendMsg(msg,"Вы не зарегестрированы");
        }


//        if (text.equals("/еще10")){
//        bot.sendMsg(msg,name);
//            if (MainList == null){
//                bot.sendMsg(msg, "Пока на этом все");
//            }else if (MainList.size() >= 10){
//                for (int i = 0; i < 10; i++)
//                    bot.sendMsg(msg, MainList.get(i).toString());
//                for (int i = 0; i < 10; i++)//разделил на for чтобы не прыгал по list.git(i);
//                    MainList.remove(i);
//            }else if (MainList.size() < 10)
//                bot.sendMsg(msg,MainList.toString());
//        }

    }
}

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//import org.apache.log4j.*;

public class Bot extends TelegramLongPollingBot {

    //example Start
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botapi = new TelegramBotsApi();

        try {
            botapi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            //write error massage
        }
    }

    //example answer TEXT
    public void sendTextMsg(Message msg, String text) {
        try {
            execute(new SendMessage().setChatId(msg.getChatId()).setText(text));
        } catch (Exception e) {
//            LOG.error("Can't send Text message: ", e);
        }
    }

    //example answer GIF
    public void sendGIFMsg(Message msg, String gif) {
        try {
            execute(new SendDocument().setChatId(msg.getChatId()).setDocument(gif));
        } catch (Exception e) {
//            LOG.error("Can't send GIF message: ", e);
        }
    }

    //example answer IMAGE
    public void sendImageMsg(Message msg, String image) {
        try {
            execute(new SendPhoto().setChatId(msg.getChatId()).setPhoto(image));
        } catch (Exception e) {
//            LOG.error("Can't send Photo message: ", e);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if(message != null && message.hasText()){
            sendTextMsg(message, "Brave new world");
        }
    }

    @Override
    public String getBotUsername() {
        return "uMediaBot";
    }

    @Override
    public String getBotToken() {
        return "711230373:AAF5J1HmvQ8zkf6vXY8-b6J9OMBZYr0xw6Q";
    }
}


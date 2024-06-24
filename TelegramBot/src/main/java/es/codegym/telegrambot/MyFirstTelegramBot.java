package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CharlyBotTelegram_bot";
    public static final String TOKEN = "7376946769:AAHKA9QeW_vQvwyttrAPCrAHi9J8c3R9ikU";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {

        // TODO: escribiremos la funcionalidad principal del bot aquí
        if (getMessageText().equals("/start")){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la neveraaa!!!!, +20 de fama","step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡Tomar una salchicha!, +20 de fama","step_2_btn",
                            "¡Tomar un pescado!, +20 de fama","step_2_btn",
                            "¡Tirar una lata de pepinillos!, +20 de fama","step_2_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(5); //es 5
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Domar al robot aspiradora, +5 de gloria","step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(10); //es 10
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("¡Enviar al robot aspiradora por comida!, +10 de fama","step_4_btn",
                            "Dar un paseo en el robot aspiradora!!!, +10 de fama","step_4_btn",
                            "¡Huir del robot aspiradora!, +10 de fama","step_4_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Encender goPro y equiparla contigo!!!!!, oyee! sumarias: +40 de gloria","step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            setUserGlory(155);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("¡Espiar al vecino, para la web!, +155 de fama", "step_6_btn",
                            "¡Espiar a amo, para la web!, +155 de fama", "step_6_btn",
                            "¡Grabarme para obtener reacciones :)!!!, +155 de fama", "step_6_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            setUserGlory(155); //es 10
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("¡Subir contenido a la web!", "step_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            setUserGlory(155);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("////_Acabar el dia_////", "step_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            setUserGlory(155);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT,Map.of());
        }


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Se Puede Borrar:
        //if (getMessageText().contains("Hola")){sendTextMessageAsync("_Hola_... *futuro programador!!!*");sendTextMessageAsync("Hola, *¿Cual es tu nombre?*");}

        //if (getMessageText().contains("Mi nombre es")){
            //sendTextMessageAsync("Hola ¿Que tal?, mi nombre es *Gato* y soy un bot _-V.2-_ en telegram app");
            //"Hola ¿Que tal?, mi nombre es *CharlyBot* y soy un bot _-V.2-_ en telegram app"}
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    private <K, V> void sendTextMessageAsync(String step2Text, Map<K,V> step2Btn, Map<K,V> step2Btn1, Map<K,V> step2Btn2) {
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}
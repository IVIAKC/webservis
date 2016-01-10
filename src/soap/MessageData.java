package soap;

import org.dom4j.Element;

/**
 * Created by IVIAKC on 10.01.2016.
 */
public class MessageData {


    String id;
    public MessageData(String dictionaryId){
        id = dictionaryId;
    }
    public void generateMessageData(Element getDictionary){
        Element messageData = getDictionary.addElement("smev:MessageData")
                .addAttribute("xmlns:smev", "http://smev.gosuslugi.ru/rev120315");
        Element appData = messageData.addElement("smev:AppData");
        Element dictionaryId = appData.addElement(id);

    }
}
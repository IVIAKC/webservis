package soap;

import org.dom4j.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
/**
 * Created by IVIAKC on 13.11.2015.
 */
public class Main {

    private  static SessionFactory dbSessions;

    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException {

        Document xml = DocumentHelper.createDocument(); //создаем
        Element root = xml.addElement("soap:Envelope"); // добавляем
        root.addNamespace("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        root.addNamespace("wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        root.addNamespace("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        root.addNamespace("ds", "http://www.w3.org/2000/09/xmldsig#");
        root.addNamespace("atc", "http://at-sibir.ru/getDictionary");
        root.addNamespace("smev", "http://smev.gosuslugi.ru/rev120315");
        Header header = new Header("Cert", "Hash", "Sign");
        header.CreateHeader(root);
        Element Body = root.addElement("soap:Body");
        Body.addAttribute("wsu:Id", "body");
        Body.addAttribute("xmlns:wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        Element getDictionary = Body.addElement("atc:getDictionary");
        getDictionary.addAttribute("xmlns:atc", "http://at-sibir.ru/getDictionary");
        Message message = new Message("a", "1", "b", "2", "c", "3");
        message.CreateMessage(getDictionary);
        MessageData mesagedata = new MessageData("DId");
        mesagedata.CreateMesageData(getDictionary);
        System.out.println(root.asXML()); // выводим


    }
}

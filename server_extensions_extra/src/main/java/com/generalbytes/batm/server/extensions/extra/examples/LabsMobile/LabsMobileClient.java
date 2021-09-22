package com.generalbytes.batm.server.extensions.extra.examples.LabsMobile;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author antonio
 */
public class LabsMobileClient {

    private String userName;
    private String password;

    /**
     * constructor que inicializa las credenciales para usar la api rest
     *
     * @param userName
     * @param password
     */
    public LabsMobileClient(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * clase para mandar mensaje mediante la api rest
     *
     * @param msisdn el numero al que se envia con clave del pais mas el numero
     * sin el signo de +
     * @param sender el numero que envia
     * @param message mensaje
     * @return
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public LabsMobileResponse SendMessage(String msisdn, String sender, String message) throws MalformedURLException, ProtocolException, IOException, SAXException, ParserConfigurationException {

        StringBuilder sbuilder = new StringBuilder();

        sbuilder.append("http://api.labsmobile.com/get/send.php?username=");
        sbuilder.append(this.userName);
        sbuilder.append("&password=");
        sbuilder.append(this.password);
        sbuilder.append("&msisdn=");
        sbuilder.append(msisdn);
        sbuilder.append("&sender=");
        sbuilder.append(sender);
        sbuilder.append("&message=");
        sbuilder.append(message);
        //sbuilder.append("&test=1"); si quieres hacerlo en modo prueba solo descomenta esta linea

        String url = sbuilder.toString();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        DocumentBuilderFactory dbf
                = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(response.toString()));

        Document doc = db.parse(is);
        LabsMobileResponse responseObj = new LabsMobileResponse();

        Element node = doc.getDocumentElement();
        String codeResponse = node.getElementsByTagName("code").item(0).getTextContent();
        String messageResponse = node.getElementsByTagName("message").item(0).getTextContent();
        int CodeResponseParse = Integer.valueOf(codeResponse);
        responseObj.setCode(CodeResponseParse);
        responseObj.setMessage(messageResponse);
        if (CodeResponseParse == 0) {
            String subIdResponse = node.getElementsByTagName("subid").item(0).getTextContent();
            responseObj.setSubId(subIdResponse);
        }        
        return responseObj;
    }
}

package ru.skilllbox.diplom.group40.social.service.repository.session;

import com.teamcenter.schemas.soa._2006_03.exceptions.InvalidCredentialsException;
import com.teamcenter.schemas.soa._2006_03.exceptions.ServiceException;
import com.teamcenter.services.strong.core.SessionService;
import com.teamcenter.services.strong.core._2006_03.Session.LoginResponse;
import com.teamcenter.soa.SoaConstants;
import com.teamcenter.soa.client.Connection;
import com.teamcenter.soa.client.model.ModelObject;
import org.apache.commons.httpclient.HttpState;


public class KolivimSession {

    public static final String USERNAME = "kim";

    public static final String PASSWORD = "test";

    public static final String GROUP = "";

    public static final String ROLE = "";

    public static final String LOCALE = "en_US";

    public static final String DISCRIMINATOR = "SoaSOAP";


    private Connection connection;

    private SessionService sessionService;

    private WHAppXCredentialManager credentialManager;


    public KolivimSession (String host) {
        credentialManager = new WHAppXCredentialManager();
        String protocol = (host.startsWith("http"))? SoaConstants.HTTP: SoaConstants.IIOP;
        connection = new Connection(host, new HttpState(), credentialManager, SoaConstants.REST, protocol, false);
        connection.setExceptionHandler(new WHAppXExceptionHandler());
        connection.getModelManager().addPartialErrorListener(new WHAppXPartialErrorListener());
        connection.getModelManager().addModelEventListener(new WHAppXModelEventListener());

        Connection.addRequestListener(new WHAppXRequestListener());
    }

    public Connection getConnection() {return connection;}
//    public SessionService getSessionService() {return sessionService;}

    public ModelObject loginAuto() {
        SessionService sessionService = SessionService.getService(connection);
        this.sessionService = sessionService;

        try {
            LoginResponse out = sessionService.login(USERNAME, PASSWORD, GROUP, ROLE, LOCALE, DISCRIMINATOR);
            return out.user;
        } catch (InvalidCredentialsException e) {
            System.out.println("KolivimSession: loginAuto() catch in *sessionService.login* : " + e.getMessage());
        }

        return null;
    }

    public void logout() {
        SessionService sessionService = SessionService.getService(connection);

        try {
            sessionService.logout();
            System.out.println("KolivimSession: logout() *sessionService.logout* SUCCESS");
        } catch (ServiceException e) {
            System.out.println("KolivimSession: logout() catch in *sessionService.logout* : " + e.getMessage());
        }
    }

}

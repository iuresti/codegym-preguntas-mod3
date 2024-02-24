package codegym.module3.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletController extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ServletController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if( req.getParameter("challengeDecision")!= null){

            if( Boolean.getBoolean(req.getParameter("challengeDecision"))){
                logger.info("Challenge accepted by " + session.getAttribute("playerName"));
            }else {
                logger.info("Challenge rejected by " + session.getAttribute("playerName"));
            }
        }

        String lastQuestion = (String)session.getAttribute("lastQuestion");

        if(lastQuestion == null){

        }


        String response = req.getParameter("response");



        logger.info("Request made to ServletController");
    }
}

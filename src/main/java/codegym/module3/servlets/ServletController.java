package codegym.module3.servlets;

import codegym.module3.models.Question;
import codegym.module3.services.QuestionsQuestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletController extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ServletController.class);

    private QuestionsQuestService questionsQuestService;

    public ServletController() {
        questionsQuestService = new QuestionsQuestService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String lastQuestion = (String) session.getAttribute("lastQuestion");
        String response = req.getParameter("playerResponse");

        if(response == null){
            logger.warn("No response received, redirected to index.jsp");
            String destination = "index.jsp";
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);

            session.removeAttribute("lastQuestion");
            requestDispatcher.forward(req, resp);

            return;
        }

        if (lastQuestion == null) {
            lastQuestion = "AcceptChallenge";
        }

        logger.info("Received response {} to question {}", response, lastQuestion);

        String nextQuestionId = questionsQuestService.processPlayerResponse(lastQuestion, response).orElseThrow();

        session.setAttribute("lastQuestion", nextQuestionId);

        logger.info("Next question is: " + nextQuestionId);

        logger.debug("Entrada en modo debug");

        String destination = "game/game.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);

        req.setAttribute("nextQuestion", questionsQuestService.getQuestionById(nextQuestionId));

        requestDispatcher.forward(req, resp);
    }
}

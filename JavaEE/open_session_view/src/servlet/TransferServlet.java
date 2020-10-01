package servlet;

import pojo.Account;
import service.AccountService;
import service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static service.AccountService.*;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
    AccountService service = new AccountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        Account sender = new Account();
        sender.setAccNo(req.getParameter("senderAccNo"));
        sender.setPassword(Integer.parseInt(req.getParameter("senderPassword")));
        sender.setBalance(Double.parseDouble(req.getParameter("senderBalance")));

        Account receiver = new Account();
        receiver.setName(req.getParameter("receiverName"));
        receiver.setAccNo(req.getParameter("receiverAccNo"));

        int transferResult = service.transfer(receiver,sender);
        switch (transferResult){
            case TRANSFER_SUCCESS:
                resp.sendRedirect("/bank/log");
                break;
            case TRANSFER_FAILURE:
            case ACCOUNT_NAME_NOT_MATCH:
            case ACCOUNT_BALANCE_NOT_ENOUGH:
            case ACCOUNT_PASSWORD_NOT_MATCH:
                req.getSession().setAttribute("error_code",transferResult);
                resp.sendRedirect("/bank/error/failure.jsp");
                break;
            default:

        }

    }
}

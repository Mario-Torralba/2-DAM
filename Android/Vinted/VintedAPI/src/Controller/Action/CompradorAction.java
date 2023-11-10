package Controller.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompradorAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                // cadDestino = findAll(request, response);
                break;
            case "FILTER":
                // cadDestino = findByFilter(request, response);
                break;
        }
        return cadDestino;
    }
}

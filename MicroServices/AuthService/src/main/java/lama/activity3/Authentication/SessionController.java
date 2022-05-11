package lama.activity3.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class SessionController {
    private static final String TEMPLATE =
            "<table border=\"1\">" +
                    "<tr><th>id</th><th>creation time</th><th>last accessed time</th></tr>" +
                    "<tr><td>%s</td><td>%s</td><td>%s</td></tr>" +
                    "</table>";

    @GetMapping("/")
    String sessionInfo(HttpSession session) {
        return String.format(TEMPLATE, session.getId(),
                new Date(session.getCreationTime()), new Date(session.getLastAccessedTime()));
    }
}

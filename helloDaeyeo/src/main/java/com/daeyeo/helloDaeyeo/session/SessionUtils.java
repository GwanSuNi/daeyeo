package com.daeyeo.helloDaeyeo.session;

import com.daeyeo.helloDaeyeo.exception.NotFoundMemberException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionUtils {
    public static String getUserIdFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null)
            throw new NotFoundMemberException("세션이 존재하지 않습니다.");

        String userId = (String) session.getAttribute("userId");
        if (userId.isBlank())
            throw new NotFoundMemberException("로그인 후 이용할 수 있습니다.");

        return userId;
    }
}

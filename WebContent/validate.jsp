 <%@ page import="net.tanesha.recaptcha.ReCaptchaImpl" %>
    <%@ page import="net.tanesha.recaptcha.ReCaptchaResponse" %>

    <html>
      <body>

		<%
		String user_name=(String)request.getParameter("user_name");
		
		%>





      <%
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6LcGN_MUAAAAACvLXkr41nWxnAzoZysSzsw6M3eV");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        if (reCaptchaResponse.isValid()) {
          out.print("Answer was entered correctly!");
        } else {
          out.print("Answer is wrong");
        }
      %>
      </body>
    </html>
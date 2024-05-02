package br.com.mgck.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.mgck.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Configuration
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        var servletPath = request.getServletPath();
        if (servletPath.equals("/tasks/")) {

            // pegar a autenticação do usuário/senha
            var authorization = request.getHeader("Authorization");
            var authEncoded = authorization.substring("Basic".length()).trim();
            byte[] authDecode = Base64.getDecoder().decode(authEncoded);
            var authString = new String(authDecode);
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // exibir dados
            System.out.println("Authorization");
            System.out.println(username);
            System.out.println(password);

            // validar usuário
            var checkedUser = this.userRepository.findByUsername(username);
            if (checkedUser == null) {
                response.sendError(401);
            } else {
                // Validar senha
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), checkedUser.getPassword());

                if (passwordVerify.verified) {
                    request.setAttribute("idUser", checkedUser.getId());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
            }
        } else {

            filterChain.doFilter(request, response);
        }
    }
}

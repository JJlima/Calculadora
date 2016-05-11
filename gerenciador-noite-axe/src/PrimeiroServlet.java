import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/PrimeiroTeste")
public class PrimeiroServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException { 
		
		//pega dos dados do html
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String DataNascimento = request.getParameter("dataNascimento");
		
		// chamar uma class para estanciar guarda os dados dessa classe
		Contato contato = new Contato ();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		//converte o dado de string pra data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(DataNascimento);
			contato.setDataNascimento(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//classe onde vou salvar meus dados no banco de dados
		ContatoDao dao = new ContatoDao();
		dao.salva(contato);
		
		//para imprimir
		PrintWriter out = response.getWriter();
		out.println("<html>"); 
		out.println("<body>");
		out.println("Contato <br> Nome:" + contato.getNome() + "<br> Endereco: "+contato.getEndereco()
		+ "<br> Email: "+contato.getEmail()+" <br> Data Nascimento: "+contato.getDataNascimento());
		out.println("</body>");
		out.println("</html>");
	}
}
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Conexao;
import model.Receptor;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        Conexao connect = new Conexao();
	Receptor contrato = new Receptor();
        public Servlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
            switch (action) {
                case "/main":
                    contratos(request, response);
                    break;
                case "/insert":
                    adicionarContrato(request, response);
                    break;
                case "/select":
                    listarContrato(request, response);
                    break;
                case "/update":
                    editarContrato(request, response);
                    break;
                case "/delete":
                    removerContrato(request, response);
                    break;
                case "/report":
                    relatorioPDF(request, response);
                    break;
                default:
                    response.sendRedirect("index.html");
                    break;
            }
	}
	protected void contratos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Receptor> lista = connect.listarContratos();
		request.setAttribute("contratos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
		rd.forward(request, response);
	}
	protected void adicionarContrato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contrato.setNome(request.getParameter("nome"));
		contrato.setEmail(request.getParameter("email"));
                contrato.setFone(request.getParameter("fone"));
                contrato.setHorario(request.getParameter("horario"));
                contrato.setDatas(request.getParameter("datas"));
                contrato.setVaga(request.getParameter("vaga"));
		connect.inserirContrato(contrato);
		response.sendRedirect("main");
	}
	protected void listarContrato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contrato.setId(request.getParameter("id"));
		connect.selecionarContrato(contrato);
		request.setAttribute("id", contrato.getId());
		request.setAttribute("nome", contrato.getNome());
		request.setAttribute("email", contrato.getEmail());
                request.setAttribute("fone", contrato.getFone());
                request.setAttribute("horario", contrato.getHorario());
                request.setAttribute("datas", contrato.getHorario());
                request.setAttribute("vaga", contrato.getVaga());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	protected void editarContrato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contrato.setId(request.getParameter("id"));
		contrato.setNome(request.getParameter("nome"));
		contrato.setEmail(request.getParameter("email"));
                contrato.setFone(request.getParameter("fone"));
                contrato.setHorario(request.getParameter("horario"));
                contrato.setDatas(request.getParameter("datas"));
                contrato.setVaga(request.getParameter("vaga"));
		connect.alterarContrato(contrato);
		response.sendRedirect("main");
	}
	protected void removerContrato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contrato.setId(request.getParameter("id"));
		connect.deletarContrato(contrato);
		response.sendRedirect("main");
	}
	protected void relatorioPDF(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "contratos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de contratos:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(5);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("E-mail"));
                        PdfPCell col3 = new PdfPCell(new Paragraph("Fone"));
                        PdfPCell col4 = new PdfPCell(new Paragraph("Horario"));
                        PdfPCell col5 = new PdfPCell(new Paragraph("Datas"));
                        PdfPCell col6 = new PdfPCell(new Paragraph("Vaga"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
                        tabela.addCell(col4);
                        tabela.addCell(col5);
                        tabela.addCell(col6);
			ArrayList<Receptor> lista = connect.listarContratos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getEmail());
                                tabela.addCell(lista.get(i).getFone());
                                tabela.addCell(lista.get(i).getHorario());
                                tabela.addCell(lista.get(i).getDatas());
                                tabela.addCell(lista.get(i).getVaga());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
}

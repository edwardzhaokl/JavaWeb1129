package servlet;

import model.*;
import org.apache.ibatis.session.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * author: zhaokl
 * <p>
 * created at: 29/11/2016 19:07
 * <p>
 * desc:
 */
public class Servlet1 extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

		String mapperXmlPath = this.getServletContext().getRealPath("/WEB-INF/classes/config.xml");

		InputStream inputStream = new FileInputStream(mapperXmlPath);

		System.out.println(inputStream.toString());
		response.getWriter().println("<br/>..................<br/>");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		String read = "mapper.MtModelMapper.read";
		MtModel mtModel = sqlSession.selectOne(read, 1L);

		String readAll = "mapper.MtModelMapper.readAll";
		List result = sqlSession.selectList(readAll, 3);

		response.getWriter().println("<br/>..................<br/>");
		response.getWriter().println(result.get(0).toString());
		response.getWriter().println("<br/>..................<br/>");


		sqlSession.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}

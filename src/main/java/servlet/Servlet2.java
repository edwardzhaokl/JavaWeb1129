package servlet;

import model.*;
import org.apache.ibatis.session.*;

import javax.servlet.http.*;
import java.io.*;

/**
 * author: zhaokl
 * <p>
 * created at: 29/11/2016 19:07
 * <p>
 * desc:
 */
public class Servlet2 extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

		String mapperXmlPath = this.getServletContext().getRealPath("/WEB-INF/classes/config.xml");

		InputStream inputStream = new FileInputStream(mapperXmlPath);

		System.out.println(inputStream.toString());
		response.getWriter().println("<br/>..................<br/>");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();


		/*MtModel mtModel = new MtModel();
		mtModel.setLevel(3);
		mtModel.setMtModelName("create");
		mtModel.setParentId(1L);
		mtModel.setValidity(1);

		String create = "mapper.MtModelMapper.create";

		int createResult = sqlSession.insert(create, mtModel);
		sqlSession.commit();

		response.getWriter().println("<br/>.......createResult.......<br/>");
		response.getWriter().println(createResult);*/


		MtModel mtModelForUpdate = new MtModel();
		mtModelForUpdate.setLevel(3);
		mtModelForUpdate.setMtModelName("test");
		mtModelForUpdate.setParentId(1L);
		mtModelForUpdate.setId(166L);
		mtModelForUpdate.setValidity(1);

		String update = "mapper.MtModelMapper.update";
		int updateResult = sqlSession.update(update, mtModelForUpdate);
		sqlSession.commit();

		response.getWriter().println("<br/>.......updateResult.......<br/>");
		response.getWriter().println(updateResult);


		sqlSession.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}

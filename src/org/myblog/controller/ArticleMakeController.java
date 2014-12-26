package org.myblog.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.myblog.model.ArticleVO;
import org.myblog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

@Controller
public class ArticleMakeController 
{
	@Resource(name = "articleServiceImpls")
	private ArticleService articleService;
	
	/**
	 * 生成首页静态化
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/make/v_index.do")
	public String list(HttpServletRequest request, ModelMap model) throws IOException
	{
		Configuration config = new Configuration(); // 创建Freemarker实例
		config.setDefaultEncoding("UTF-8");
		config.setDirectoryForTemplateLoading(new File(request.getSession().getServletContext().getRealPath("/free/index"))); // 设置模板文件目录
		config.setObjectWrapper(new DefaultObjectWrapper()); // 设置默认包装对象
		
		Template template = config.getTemplate("index.ftl"); // 得到模板对象
		
		List<ArticleVO> article = articleService.findAll();
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("articles", article); 
		
		File saveFile = new File(request.getSession()
				.getServletContext().getRealPath("/view/staticPage/index/" + "index.html")); 
		
		if(!saveFile.getParentFile().exists())
		{
			saveFile.getParentFile().mkdirs();
		}
		
		FileOutputStream output = new FileOutputStream(saveFile);
		OutputStreamWriter writer = new OutputStreamWriter(output);
		BufferedWriter buffer = new BufferedWriter(writer);

		try
		{
			template.process(root, buffer);
			buffer.flush();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			output.close();
			buffer.close();
		}
		
		return "index";
	}
}
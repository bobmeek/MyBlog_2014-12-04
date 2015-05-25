package org.myblog.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.myblog.model.IndexImageVO;
import org.myblog.service.facade.IndexImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping(value = "/index/")
public class IndexImageController {
	
	
	@Resource(name="indexImageServiceImpl")
	private IndexImageService indexImageService;
	
	
	
	@RequestMapping(value = "index-img/save")
	@ResponseBody
	public int save(IndexImageVO indexImage){
		
		indexImageService.save(indexImage);
		return 0;
	}
	
	
	@RequestMapping(value = "index-img/update")
	@ResponseBody
	public int update(IndexImageVO indexImage){
		
		indexImageService.update(indexImage);
		return 0;
	}
	
	@RequestMapping(value = "index-img/delete/{id}")
	@ResponseBody
	public int delete(@PathVariable int id){
		
		indexImageService.delete(id);
		return 0;
	}
	
	@RequestMapping(value = "index-img/show")
	@ResponseBody
	public List<IndexImageVO> show(){
		List<IndexImageVO> list = indexImageService.findAll();
		return list;
	}
	
	
	
	/**上传首页宣传图片**/
	@RequestMapping(value = "propaganda-img/upload")
	public String uploadPropagandaImg(String title,String fileType,String indexImgNameOld,MultipartFile propagandaImg, HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		 //可以在上传文件的同时接收其它参数
        //System.out.println("收到用户[" + uname + "]的文件上传请求");
        //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\resources\\upload\\文件夹中
        //这里实现文件上传操作用的是commons.io.FileUtils类,它会自动判断/upload是否存在,不存在会自动创建
        String realPath = request.getSession().getServletContext().getRealPath("resources/upload/img/index");
        response.setContentType("text/html; charset=UTF-8");   //设置响应给前台内容的数据格式
        PrintWriter out = response.getWriter();  //设置响应给前台内容的PrintWriter对象
        String originalFilename = null; //上传文件的原名(即上传前的文件名字)
        
        if(propagandaImg.isEmpty()){
            out.print("1");
            out.flush();
            return null;
        }else{
        	originalFilename = propagandaImg.getOriginalFilename();
        	originalFilename = originalFilename.substring(0,originalFilename.indexOf("."));
    		//图片存储格式
        	originalFilename= originalFilename+"_"+System.currentTimeMillis()+"."+fileType;
    		
            System.out.println("文件名称: " + originalFilename);
            System.out.println("文件名称: " + propagandaImg.getName());
            System.out.println("文件长度: " + propagandaImg.getSize());
            System.out.println("文件类型: " + propagandaImg.getContentType());
            System.out.println("========================================");
            try {
                //这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
                //此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传
            	File file = new File(realPath,indexImgNameOld);
            	if(file.exists())
            		file.delete();
                FileUtils.copyInputStreamToFile(propagandaImg.getInputStream(), new File(realPath, originalFilename));
            } catch (IOException e) {
                System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
                e.printStackTrace();
                out.print("1`文件上传失败，请重试！！");
                out.flush();
                return null;
            }
        }
        System.out.println("项目名称"+request.getContextPath());
        System.out.println("resources/upload/img/index/" + originalFilename);
        out.print("0`" + "resources/upload/img/index/" + originalFilename);

        
        out.flush();
		return null;
        
		
	}
	
	
	
}

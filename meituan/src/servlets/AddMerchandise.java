package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.AddMerchandiseService;

/**
 * Servlet implementation class AddMerchandise
 */
@WebServlet("/AddMerchandise")
public class AddMerchandise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMerchandise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
        String savePath = this.getServletContext().getRealPath("/upload");
        File file = new File(savePath);
        //�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"Ŀ¼�����ڣ���Ҫ����");
            //����Ŀ¼
            file.mkdir();
        }
        //��Ϣ��ʾ
        String message = "";
        String filename = "";
        String ppname ="";
        String price = "";
        String num = "";
        try{
            //ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
            //1������һ��DiskFileItemFactory����
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2������һ���ļ��ϴ�������
            ServletFileUpload upload = new ServletFileUpload(factory);
             //����ϴ��ļ�������������
            upload.setHeaderEncoding("UTF-8"); 
            //3���ж��ύ�����������Ƿ����ϴ�����������
            if(!ServletFileUpload.isMultipartContent(request)){
                //���մ�ͳ��ʽ��ȡ����
                return;
            }
            //4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form������������
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                //���fileitem�з�װ������ͨ�����������
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //�����ͨ����������ݵ�������������
                    String value = item.getString("UTF-8");
					if(name.equals("pname")){
						ppname = value;
					}
					
					if(name.equals("pprice")){
						price = value;
					}
					
					if(name.equals("pnum")){
						num = value;
					}
					
                  /*  System.out.println(name + "=" + value);*/
                }else{//���fileitem�з�װ�����ϴ��ļ�
                    //�õ��ϴ����ļ����ƣ�
                    filename = item.getName();
                   /* System.out.println(filename);*/
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    //ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
                    //������ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    //��ȡitem�е��ϴ��ļ���������
                    InputStream in = item.getInputStream();
                    //����һ���ļ������
                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                    //����һ��������
                    byte buffer[] = new byte[1024];
                    //�ж��������е������Ƿ��Ѿ�����ı�ʶ
                    int len = 0;
                    //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
                    while((len=in.read(buffer))>0){
                        //ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
                        out.write(buffer, 0, len);
                    }
                    //�ر�������
                    in.close();
                    //�ر������
                    out.close();
                    //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
                    item.delete();
                    message = "�ļ��ϴ��ɹ���";
                }
            }
        }catch (Exception e) {
            message= "�ļ��ϴ�ʧ�ܣ�";
            e.printStackTrace();
            
        }
        
        request.setCharacterEncoding("utf-8");
        String pname = ppname;
        String pprice = price;
        String pnum = num;
        String imgurl = "/meituan/upload/"+filename;
        String sid = (String) request.getSession().getAttribute("sid");//�����̵�id��store_id
        AddMerchandiseService am = new AddMerchandiseService();
        int result = am.addMerchandise(pname, pprice, imgurl, pnum, sid);
        if(result == 1){
        	response.sendRedirect("/meituan/uis");
        }
	}

}
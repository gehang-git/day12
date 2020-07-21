package com.xiaoshu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.config.util.ConfigUtil;
import com.xiaoshu.entity.Attachment;
import com.xiaoshu.entity.City;
import com.xiaoshu.entity.Dept;
import com.xiaoshu.entity.Emp;
import com.xiaoshu.entity.EmpVo;
import com.xiaoshu.entity.Log;
import com.xiaoshu.entity.Operation;
import com.xiaoshu.entity.Role;
import com.xiaoshu.entity.User;
import com.xiaoshu.service.DeptService;
import com.xiaoshu.service.EmpService;
import com.xiaoshu.service.OperationService;
import com.xiaoshu.service.RoleService;
import com.xiaoshu.service.UserService;
import com.xiaoshu.util.StringUtil;
import com.xiaoshu.util.TimeUtil;
import com.xiaoshu.util.WriterUtil;

@Controller
@RequestMapping("emp")
public class EmpController extends LogController{
	static Logger logger = Logger.getLogger(EmpController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService ;
	
	@Autowired
	private OperationService operationService;
	
	@Autowired
	private  EmpService empService;
	@Autowired
	private DeptService deptService;
	@RequestMapping("empIndex")
	public String index(HttpServletRequest request,Integer menuid) throws Exception{
		List<Role> roleList = roleService.findRole(new Role());
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		request.setAttribute("operationList", operationList);
		request.setAttribute("roleList", roleList);
		request.setAttribute("slist", empService.findCityByPid(0));
		request.setAttribute("dlist", deptService.findAll());
		//System.out.println(1/0);测试aop日志记录
		return "emp";
	}
	
	
	@RequestMapping(value="empList",method=RequestMethod.POST)
	public void empList(EmpVo empVo,HttpServletRequest request,HttpServletResponse response,String offset,String limit) throws Exception{
		try {
			String order = request.getParameter("order");
			String ordername = request.getParameter("ordername");
			
			Integer pageSize = StringUtil.isEmpty(limit)?ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			
			PageInfo<EmpVo> userList=empService.findPage(empVo,pageNum,pageSize);
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("total",userList.getTotal() );
			jsonObj.put("rows", userList.getList());
	        WriterUtil.write(response,jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户展示错误",e);
			throw e;
		}
	}
	
	
	// 新增或修改
	@RequestMapping("reserveUser")
	public void reserveUser(MultipartFile picFile,HttpServletRequest request,Emp emp,HttpServletResponse response){
		Integer id = emp.getTbEmpId();
		JSONObject result=new JSONObject();
		try {
			if (picFile!=null && picFile.getSize()>0) {
				//获取图片名称
				String filename = picFile.getOriginalFilename();
				//新的名字
				String newName = System.currentTimeMillis()+filename.substring(filename.lastIndexOf("."));
				//设置虚拟路径
				File file = new File("e:/img/"+newName);
				//上传
				picFile.transferTo(file);
				//设置数据到数据库
				emp.setTbEmpImg(newName);
			}
			if (id != null) {   // userId不为空 说明是修改
				Emp emp2 = empService.findEmpByName(emp.getTbEmpName());
				if(emp2==null || (emp2 != null && emp2.getTbEmpId().compareTo(id)==0)){
					empService.updateEmp(emp);
					result.put("success", true);
				}else{
					result.put("success", true);
					result.put("errorMsg", "该用户名被使用");
				}
				
			}else {   // 添加
				if(empService.findEmpByName(emp.getTbEmpName())==null){  // 没有重复可以添加
					empService.addEmp(emp);
					result.put("success", true);
				} else {
					result.put("success", true);
					result.put("errorMsg", "该用户名被使用");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("保存用户信息错误",e);
			result.put("success", true);
			result.put("errorMsg", "对不起，操作失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	
	@RequestMapping("deleteUser")
	public void delUser(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				empService.delete(Integer.parseInt(id));
			}
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}
	@RequestMapping("empEcharts")
	public void empEcharts(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			List<EmpVo> dlist = empService.findEcharts();
			result.put("success", true);
			result.put("dlist", dlist);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，报表数据失败");
		}
		WriterUtil.write(response, result.toString());
	}
	/*//导出
	@RequestMapping("exportEmp")
	public void exportEmp(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			//查询所有数据
			EmpVo empVo = new EmpVo();
			List<EmpVo> list= empService.findAll(empVo);
			//创建工作簿
			HSSFWorkbook book = new HSSFWorkbook();
			//创建sheet页	
			HSSFSheet sheet = book.createSheet();
			//定义头标题
			//员工编员,员工名称,员工性别,员工年龄,员工住址,员工头像,员工生日,部门名称
			String title[] = {"员工编员","员工名称","员工性别","员工年龄","员工住址","员工头像","员工生日","部门名称"};
			//将第一行数据放入
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < title.length; i++) {
				row.createCell(i).setCellValue(title[i]);
			}
			//循环list集合中的数据放入单元格
			for (int i = 0; i < list.size(); i++) {
				HSSFRow row2 = sheet.createRow(i+1);
				row2.createCell(0).setCellValue(list.get(i).getTbEmpId());
				row2.createCell(1).setCellValue(list.get(i).getTbEmpName());
				row2.createCell(2).setCellValue(list.get(i).getTbEmpSex().equals("1")?"男":"女");
				row2.createCell(3).setCellValue(list.get(i).getTbEmpAge());
				row2.createCell(4).setCellValue(list.get(i).getCname1()+"-"+list.get(i).getCname2()+"-"+list.get(i).getCname3());
				row2.createCell(5).setCellValue(list.get(i).getTbEmpImg());
				row2.createCell(6).setCellValue(TimeUtil.formatTime(list.get(i).getTbEmpBirthday(), "yyyy-MM-dd hh:mm:ss"));
				row2.createCell(7).setCellValue(list.get(i).getDname());
			}
			//写出文件（path为文件路径含文件名）
			OutputStream os;
			File file = new File("D:/开心.xls");
			
			if (!file.exists()){//若此目录不存在，则创建之  
				file.createNewFile();  
				logger.debug("创建文件夹路径为："+ file.getPath());  
            } 
			os = new FileOutputStream(file);
			book.write(os);
			os.close();
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}*/
	
	
	@RequestMapping("exportEmp")
	public void backup(HttpServletRequest request,HttpServletResponse response){
		JSONObject result = new JSONObject();
		try {
			String time = TimeUtil.formatTime(new Date(), "yyyyMMddHHmmss");
		    String excelName = "员工信息表"+time;
			EmpVo empVo = new EmpVo();
			List<EmpVo> list = empService.findAll(empVo);
			String[] handers = {"员工编员","员工名称","员工性别","员工年龄","员工住址","员工头像","员工生日","部门名称"};
			// 1导入硬盘
			ExportExcelToDisk(request,handers,list, excelName);
			
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("", "对不起，备份失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	
	
	// 导出到硬盘
	@SuppressWarnings("resource")
	private void ExportExcelToDisk(HttpServletRequest request,
			String[] handers, List<EmpVo> list, String excleName) throws Exception {
		
		try {
			HSSFWorkbook wb = new HSSFWorkbook();//创建工作簿
			HSSFSheet sheet = wb.createSheet("操作记录备份");//第一个sheet
			HSSFRow rowFirst = sheet.createRow(0);//第一个sheet第一行为标题
			rowFirst.setHeight((short) 500);
			for (int i = 0; i < handers.length; i++) {
				sheet.setColumnWidth((short) i, (short) 4000);// 设置列宽
			}
			//写标题了
			for (int i = 0; i < handers.length; i++) {
			    //获取第一行的每一个单元格
			    HSSFCell cell = rowFirst.createCell(i);
			    //往单元格里面写入值
			    cell.setCellValue(handers[i]);
			}
			for (int i = 0;i < list.size(); i++) {
			    //获取list里面存在是数据集对象
			    EmpVo e = list.get(i);
			    //创建数据行
			    HSSFRow row = sheet.createRow(i+1);
			    //设置对应单元格的值
			    row.setHeight((short)400);   // 设置每行的高度
			    //员工编员","员工名称","员工性别","员工年龄","员工住址","员工头像","员工生日","部门名称
			    row.createCell(0).setCellValue(e.getTbEmpId());
			    row.createCell(1).setCellValue(e.getTbEmpName());
			    row.createCell(2).setCellValue(e.getTbEmpSex().equals("1")?"男":"女");
			    row.createCell(3).setCellValue(e.getTbEmpAge());
			    row.createCell(4).setCellValue(e.getCname1()+"-"+e.getCname2()+"-"+e.getCname3());
			    row.createCell(5).setCellValue(e.getTbEmpImg());
			    row.createCell(6).setCellValue(TimeUtil.formatTime(e.getTbEmpBirthday(), "yyyy-MM-dd"));
			    row.createCell(7).setCellValue(e.getDname());
			}
			//写出文件（path为文件路径含文件名）
				OutputStream os;
				File file = new File("D:/"+excleName+".xls");
				
				if (!file.exists()){//若此目录不存在，则创建之  
					file.createNewFile();  
					logger.debug("创建文件夹路径为："+ file.getPath());  
	            } 
				os = new FileOutputStream(file);
				wb.write(os);
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
	}
	//三级联动
	@RequestMapping("findCityByPid")
	public void findCityByPid(Integer pid,HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			List<City> clist = empService.findCityByPid(pid);
			result.put("success", true);
			result.put("clist", clist);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	@RequestMapping("editPassword")
	public void editPassword(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		if(currentUser.getPassword().equals(oldpassword)){
			User user = new User();
			user.setUserid(currentUser.getUserid());
			user.setPassword(newpassword);
			try {
				userService.updateUser(user);
				currentUser.setPassword(newpassword);
				session.removeAttribute("currentUser"); 
				session.setAttribute("currentUser", currentUser);
				result.put("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("修改密码错误",e);
				result.put("errorMsg", "对不起，修改密码失败");
			}
		}else{
			logger.error(currentUser.getUsername()+"修改密码时原密码输入错误！");
			result.put("errorMsg", "对不起，原密码输入错误！");
		}
		WriterUtil.write(response, result.toString());
	}
}

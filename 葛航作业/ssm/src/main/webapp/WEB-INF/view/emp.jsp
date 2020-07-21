<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>员工页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>

<link
	href="${path }/resources/css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
<link href="${path }/resources/css/animate.css" rel="stylesheet">
<link href="${path }/resources/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
	<div class="panel-body">
		<div id="toolbar" class="btn-group">
			<c:forEach items="${operationList}" var="oper">
				<privilege:operation operationId="${oper.operationid }" id="${oper.operationcode }" name="${oper.operationname }" clazz="${oper.iconcls }"  color="#093F4D"></privilege:operation>
			</c:forEach>
        </div>
        <div class="row">
			  <div class="col-lg-2">
				<div class="input-group">
			      <span class="input-group-addon">员工名称 </span>
			      <input type="text" name="name" class="form-control" id="txt_search_name" >
				</div>
			  </div>
			  <div class="col-lg-2">
				<div class="input-group">
			      <span class="input-group-addon">员工性别 </span>
			      <input type="radio" name="sex" class="" id="txt_search_sex1" value="1">男
			      <input type="radio" name="sex" class="" id="txt_search_sex2" value="0">女
				</div>
			  </div>
			  <div class="col-lg-2">
				<div class="input-group">
			      <span class="input-group-addon">年龄区间 </span>
			      <input type="text" name="age1" class="" id="txt_search_age1" >--
			      <input type="text" name="age2" class="" id="txt_search_age2" >
				</div>
			  </div>
			  <div class="col-lg-2">
				<div class="input-group">
			      <span class="input-group-addon">生日区间</span>
			      <input type="date" name="birthday" class="" id="txt_search_birthday1" >--
			      <input type="date" name="birthday" class="" id="txt_search_birthday2" >
				</div>
			  </div>
			  <div class="col-lg-2">
				<div class="input-group">
					<span class="input-group-addon">部门名称</span>
					<select class="form-control" name="txt_search_roleid" id = "txt_search_dept">
						<option value="0">---请选择---</option>
						<c:forEach items="${dlist }" var="r">
						 	<option value="${r.id }">${r.name }</option>
						</c:forEach>
                	</select>
				</div>
			 </div>
            <button id="btn_search" type="button" class="btn btn-default">
            	<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
            </button>
	  	</div>
        
        <table id="table_user"></table>
		
	</div>
	
	<!-- 新增和修改对话框 -->
	<div class="modal fade" id="modal_user_edit" role="dialog" aria-labelledby="modal_user_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form id="form_user" method="post" action="reserveUser.htm" enctype="multipart/form-data">
						<input type="hidden" name="tbEmpId" id="hidden_txt_tbEmpId" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td>人员名称：</td>
								<td><input type="text" id="tbEmpName" name="tbEmpName"
									class="form-control" aria-required="true" required/></td>
								<td>&nbsp;&nbsp;</td>
								<td>人员性别 ：</td>
								<td>
									<input type="radio" id="tbEmpSex1" name="tbEmpSex"
									class="" aria-required="true" required value="1"/>男
									<input type="radio" id="tbEmpSex2" name="tbEmpSex"
									class="" aria-required="true" required value="0"/>女
								</td>
							</tr>
							<tr>
								<td>人员年龄：</td>
								<td><input type="text" id="tbEmpAge" name="tbEmpAge"
									class="form-control" aria-required="true" required/></td>
								<td>&nbsp;&nbsp;</td>
								<td>员工生日：</td>
								<td>
								<input placeholder="员工生日" id="tbEmpBirthday" name="tbEmpBirthday" class="laydate-icon form-control layer-date"/>
								</td>
							</tr>
							<tr>
								<td>员工头像：</td>
								<td>
									<img src=""  width="50px" id="pics">
									<input type="file" name="picFile">
									<input type="hidden" name="tbEmpImg" id="tbEmpImg">
								</td>
								<td>&nbsp;&nbsp;</td>
							</tr>
							<tr>
								<td>所属部门：</td>
								<td colspan="4">
									<select class="form-control" name="tbEmpDid" id = "tbEmpDid" aria-required="true" required>
										<option value="0">---请选择---</option>
										<c:forEach items="${dlist }" var="r">
										 	<option value="${r.id }">${r.name }</option>
										</c:forEach>
				                	</select>
								</td>
							</tr>
							<tr>
								<td>地址信息：</td>
								<td colspan="4">
									<select id="tbEmpShengid" name="tbEmpShengid" aria-required="true" required onchange="findCityByPid(this.value,0)">
										<option value="">--请选择省--</option>
										<c:forEach items="${slist }" var="s">
											<option value="${s.id }">${s.name }</option>
										</c:forEach>
									</select>-
									<select id="tbEmpSid" name="tbEmpSid" onchange="findCityByPid(this.value,1)">
										<option value="0">--请选择市--</option>
									</select>-
									<select id="tbEmpXid" name="tbEmpXid">
										<option value="0">--请选择县--</option>
									</select>
								</td>
							</tr>
						</table>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  id="submit_form_user_btn">保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
	<!--删除对话框 -->
	<div class="modal fade" id="modal_user_del" role="dialog" aria-labelledby="modal_user_del" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					 <h4 class="modal-title" id="modal_user_del_head"> 刪除  </h4>
				</div>
				<div class="modal-body">
							删除所选记录？
				</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-danger"  id="del_user_btn">刪除</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
			</div>
		</div>
	</div>
	<!--echarts报表 -->
	<div class="modal fade" id="modal_user_echarts" role="dialog" aria-labelledby="modal_user_echarts" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					 <h4 class="modal-title" id="modal_user_del_head"> Echarts报表 </h4>
				</div>
				<div class="modal-body">
						<div style="width: 600px;height: 300px" id="Echarts"></div>
				</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
			</div>
		</div>
	</div>
	<!--导出对话框 -->
	<div class="modal fade" id="modal_user_export" role="dialog" aria-labelledby="modal_user_export" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					 <h4 class="modal-title" id="modal_user_del_head"> 导出  </h4>
				</div>
				<div class="modal-body">
							导出所选记录？
				</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-danger"  id="export_user_btn">导出</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
			</div>
		</div>
	</div>
	
	
	<div class="ui-jqdialog modal-content" id="alertmod_table_user_mod"
		dir="ltr" role="dialog"
		aria-labelledby="alerthd_table_user" aria-hidden="true"
		style="width: 200px; height: auto; z-index: 2222; overflow: hidden;top: 274px; left: 534px; display: none;position: absolute;">
		<div class="ui-jqdialog-titlebar modal-header" id="alerthd_table_user"
			style="cursor: move;">
			<span class="ui-jqdialog-title" style="float: left;">注意</span> <a id ="alertmod_table_user_mod_a"
				class="ui-jqdialog-titlebar-close" style="right: 0.3em;"> <span
				class="glyphicon glyphicon-remove-circle"></span></a>
		</div>
		<div class="ui-jqdialog-content modal-body" id="alertcnt_table_user">
			<div id="select_message"></div>
			<span tabindex="0"> <span tabindex="-1" id="jqg_alrt"></span></span>
		</div>
		<div
			class="jqResize ui-resizable-handle ui-resizable-se glyphicon glyphicon-import"></div>
	</div>
	
	<!-- Peity-->
	<script src="${path }/resources/js/plugins/peity/jquery.peity.min.js"></script>
	
	<!-- Bootstrap table-->
	<script src="${path }/resources/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script src="${path }/resources/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

	<!-- 自定义js-->
	<script src="${path }/resources/js/content.js?v=1.0.0"></script>
	
	 <!-- jQuery Validation plugin javascript-->
    <script src="${path }/resources/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${path }/resources/js/plugins/validate/messages_zh.min.js"></script>
   
   	<!-- jQuery form  -->
    <script src="${path }/resources/js/jquery.form.min.js"></script>
    <!-- layerDate plugin javascript -->
	<script src="${path }/resources/js/plugins/layer/laydate/laydate.js"></script>
    
	<script type="text/javascript">
	Date.prototype.Format = function (fmt) {
	    var o = {  
	        "M+": this.getMonth() + 1, //月份   
	        "d+": this.getDate(), //日   
	        "H+": this.getHours(), //小时   
	        "m+": this.getMinutes(), //分   
	        "s+": this.getSeconds(), //秒   
	        "S": this.getMilliseconds() //毫秒   
	    };  
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
	    for (var k in o)  
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
	    return fmt;  
	};
	laydate({
        elem: '#tbEmpBirthday', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus', //响应事件。如果没有传入event，则按照默认的click
        format: 'YYYY-MM-DD'// 日期格式
    });
	function findCityByPid(pid,flag){
		$.ajax({
		    url:"findCityByPid.htm",
		    dataType:"json",
		    data:{"pid":pid},
		    type:"post",
		    async:false,
		    success:function(res){
		    	var obj = $("#tbEmpSid");
		    	var obj2 = $("#tbEmpXid");
		    	var onjInfo = '<option value="0">-请选择市-</option>';
		    	if (flag==1) {
					obj= $("#tbEmpXid");
					onjInfo = '<option value="0">-请选择县-</option>';
				}
		    	if(res.success){
		    		obj2.empty();
		    		obj2.append('<option value="0">-请选择县-</option>');
		    		obj.empty();
		    		obj.append(onjInfo);
		    		res.clist.forEach(function(city){
		    			obj.append('<option value='+city.id+'>'+city.name+'</option>')
		    		});
		    		
	    		}else{
	    			$("#select_message").text(res.errorMsg);
	    			$("#alertmod_table_user_mod").show();
	    		}
		    }
		});
	}
	$(function () {
	    init();
	    $("#btn_search").bind("click",function(){
	    	//先销毁表格  
	        $('#table_user').bootstrapTable('destroy');
	    	init();
	    }); 
	    var validator = $("#form_user").validate({
    		submitHandler: function(form){
   		      $(form).ajaxSubmit({
   		    	dataType:"json",
   		    	success: function (data) {
   		    		
   		    		if(data.success && !data.errorMsg ){
   		    			validator.resetForm();
   		    			$('#modal_user_edit').modal('hide');
   		    			$("#btn_search").click();
   		    		}else{
   		    			$("#select_message").text(data.errorMsg);
   		    			$("#alertmod_table_user_mod").show();
   		    		}
                }
   		      });     
   		   }  
	    });
	    $("#submit_form_user_btn").click(function(){
	    	$("#form_user").submit();
	    });
	});
	
	var init = function () {
		//1.初始化Table
	    var oTable = new TableInit();
	    oTable.Init();
	    //2.初始化Button的点击事件
	    var oButtonInit = new ButtonInit();
	    oButtonInit.Init();
	};
	
	var TableInit = function () {
	    var oTableInit = new Object();
	    //初始化Table
	    oTableInit.Init = function () {
	        $('#table_user').bootstrapTable({
	            url: 'empList.htm',         //请求后台的URL（*）
	            method: 'post',                      //请求方式（*）
	            contentType : "application/x-www-form-urlencoded",
	            toolbar: '#toolbar',                //工具按钮用哪个容器
	            striped: true,                      //是否显示行间隔色
	            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	            pagination: true,                   //是否显示分页（*）
	            sortable: true,                     //是否启用排序
	            sortName: "tbEmpId",
	            sortOrder: "desc",                   //排序方式
	            queryParams: oTableInit.queryParams,//传递参数（*）
	            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
	            pageNumber:1,                       //初始化加载第一页，默认第一页
	            pageSize: 10,                       //每页的记录行数（*）
	            pageList: [10, 25, 50, 75, 100],    //可供选择的每页的行数（*）
	            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	            strictSearch: true,
	            showColumns: true,                  //是否显示所有的列
	            showRefresh: false,                  //是否显示刷新按钮
	            minimumCountColumns: 2,             //最少允许的列数
	            clickToSelect: true,                //是否启用点击选中行
	           // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	            uniqueId: "tbEmpId",                     //每一行的唯一标识，一般为主键列
	            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
	            cardView: false,                    //是否显示详细视图
	            detailView: false,                   //是否显示父子表
	            columns: [{
	                checkbox: true
	            },
	            {
	                field: 'tbEmpId',
	                title: '员工编号',
	                sortable:true
	            },
	            {
	                field: 'tbEmpName',
	                title: '员工名称',
	                sortable:true
	            }, {
	                field: 'tbEmpSex',
	                title: '员工性别',
	                sortable:true,
	                formatter:function(value,row,index){
	                	return value=="1"?"男":"女";
	                }
	            }, {
	                field: 'tbEmpAge',
	                title: '员工年龄'
	            },
	            {
	                field: 'tbEmpAddress',
	                title: '员工住址',
	                formatter:function(value,row,index){
	                 	return row.cname1+"-"+row.cname2+"-"+row.cname3;
	                } 
	            },
	            {
	                field: 'tbEmpImg',
	                title: '员工头像',
	                sortable:true,
	                formatter:function(value,row,index){
	                	return '<img src="/img/'+value+'" width="50px"/>';
	                }
	            },
	            {
	                field: 'tbEmpBirthday',
	                title: '员工生日',
	                sortable:true,
	                formatter:function(value,row,index){
	                	return new Date(value).Format('yyyy-MM-dd');
	                }
	                
	            },
	            {
	                field: 'dname',
	                title: '部门名称',
	                sortable:true
	            }],
	            onClickRow: function (row) {
	            	$("#alertmod_table_user_mod").hide();
	            }
	        });
	    };

	    //得到查询的参数
	    oTableInit.queryParams = function (params) {
	        var temp = {//这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
	            limit: params.limit,   //页面大小
	            offset: params.offset,  //页码
	            tbEmpName: $("#txt_search_name").val(),
	            tbEmpSex: $("input[name='sex']:checked").val(),
	            age1: $("#txt_search_age1").val(),
	            age2: $("#txt_search_age2").val(),
	            birthday1:$("#txt_search_birthday1").val(),
	            birthday2:$("#txt_search_birthday2").val(),
	            tbEmpDid: $("#txt_search_dept").val(),
	            usertype: $("#txt_search_usertype").val(),
	            search:params.search,
	            order: params.order,
	            ordername: params.sort
	        };
	        return temp;
	    };
	    return oTableInit;
	};
	
	var ButtonInit = function () {
	    var oInit = new Object();
	    var postdata = {};

	    oInit.Init = function () {
	        //初始化页面上面的按钮事件
	    	$("#btn_add").click(function(){
	    		$('#password').attr("readOnly",false).val(getSelection.password);
	    		$("#form_user").resetForm();
	    		document.getElementById("hidden_txt_tbEmpId").value='';
	    		$('#pics').attr("src","");
	    		$('#modal_user_edit').modal({backdrop: 'static', keyboard: false});
				$('#modal_user_edit').modal('show');
	        });
	        
	    	$("#btn_edit").click(function(){
	    		var getSelections = $('#table_user').bootstrapTable('getSelections');
	    		if(getSelections && getSelections.length==1){
	    			initEditUser(getSelections[0]);
	    			$('#modal_user_edit').modal({backdrop: 'static', keyboard: false});
					$('#modal_user_edit').modal('show');
	    		}else{
	    			$("#select_message").text("请选择其中一条数据");
	    			$("#alertmod_table_user_mod").show();
	    		}
	    		
	        });
	    	
	    	$("#btn_delete").click(function(){
	    		var getSelections = $('#table_user').bootstrapTable('getSelections');
	    		if(getSelections && getSelections.length>0){
	    			$('#modal_user_del').modal({backdrop: 'static', keyboard: false});
	    			$("#modal_user_del").show();
	    		}else{
	    			$("#select_message").text("请选择数据");
	    			$("#alertmod_table_user_mod").show();
	    		}
	        });
	    	$("#btn_echarts").click(function(){
	    		var myEcharts = echarts.init(document.getElementById("Echarts"));
	    		$.ajax({
	    		    url:"empEcharts.htm",
	    		    dataType:"json",
	    		    type:"post",
	    		    success:function(res){
	    		    	if(res.success){
	    		    		$('#modal_user_echarts').modal({backdrop: 'static', keyboard: false});
	    	    			$("#modal_user_echarts").show();
	    	    			var xdata = new Array();
	    	    			var ydata = new Array();
	    	    			res.dlist.forEach(function(e){
	    	    				xdata.push(e.dname);
	    	    				ydata.push({value:e.num,name:e.dname});
	    	    			});
	    	    			/* 折线图
	    	    			var option = {
	    	    					title : {
	    	    						text : '初始化完毕，setOption填入数值'
	    	    					},
	    	    					tooltip : {},
	    	    					xAxis : [ {
	    	    						type : 'category',
	    	    						boundaryGap : false,
	    	    						data : xdata
	    	    					} ],
	    	    					yAxis : {},
	    	    					series : [ {
	    	    						name : "统计信息",
	    	    						type : 'line',
	    	    						data :ydata

	    	    					} ]
	    	    				}; */
	    	    				/* 
	    	    				平滑的曲线
	    	    				var option = {
	    	    					    tooltip : {},
	    	    					    xAxis: {
	    	    					        type: 'category',
	    	    					        data: xdata
	    	    					    },
	    	    					    yAxis: {
	    	    					        type: 'value'
	    	    					    },
	    	    					    series: [{
	    	    							name : "统计信息",
	    	    					        data: ydata,
	    	    					        type: 'line',
	    	    					        smooth: true
	    	    					    }]
	    	    					}; */
	    	    					//柱状图
	    	    					var option = {
	    	    							title : {
	    	    								text : '部门信息'
	    	    							},
	    	    							tooltip : {},
	    	    							legend : {
	    	    							},
	    	    							xAxis : {
	    	    								data : xdata
	    	    							},
	    	    							yAxis : {},
	    	    							series : [ {
	    	    								name : "统计信息",
	    	    								type : 'bar',
	    	    								data : ydata,
	    	    							} ]
	    	    						};
	    	    					/* 
	    	    						饼状图
	    	    					var option = {
	    	    						    title: {
	    	    						        text: '互联网部门信息',
	    	    						        subtext: '真实数据',
	    	    						        left: 'center'
	    	    						    },
	    	    						    tooltip: {
	    	    						        trigger: 'item',
	    	    						        formatter: '{a} <br/>{b} : {c} ({d}%)'
	    	    						    },
	    	    						    legend: {
	    	    						        orient: 'vertical',
	    	    						        left: 'left',
	    	    						        data:xdata
	    	    						    },
	    	    						    series: [
	    	    						        {
	    	    						            name: '统计信息',
	    	    						            type: 'pie',
	    	    						            radius: '55%',
	    	    						            center: ['50%', '60%'],
	    	    						            data:ydata,
	    	    						            emphasis: {
	    	    						                itemStyle: {
	    	    						                    shadowBlur: 10,
	    	    						                    shadowOffsetX: 0,
	    	    						                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	    	    						                }
	    	    						            }
	    	    						        }
	    	    						    ]
	    	    						}; */
								
	    	    			myEcharts.setOption(option);
	    	    			
	    	    		}
	    		    }
	    		});
	    			
	        });
	    	
	    	$("#btn_export").click(function(){
	    			$('#modal_user_export').modal({backdrop: 'static', keyboard: false});
	    			$("#modal_user_export").show();
	        });
	        
	        
	    };

	    return oInit;
	};
	
	$("#alertmod_table_user_mod_a").click(function(){
		$("#alertmod_table_user_mod").hide();
	});
	
	function initEditUser(getSelection){
		$('#hidden_txt_tbEmpId').val(getSelection.tbEmpId);
		$('#pics').attr("src","/img/"+getSelection.tbEmpImg);
		$('#tbEmpName').val(getSelection.tbEmpName);
		var sex = getSelection.tbEmpSex;
		if (sex==1) {
			$('#tbEmpSex1').prop("checked",true);
		}else{
			$('#tbEmpSex2').prop("checked",true);
		}
		$('#tbEmpAge').val(getSelection.tbEmpAge);
		//图片回显
		$('#tbEmpImg').val(getSelection.tbEmpImg);
		$('#pics').attr("src","/img/"+getSelection.tbEmpImg);
		
		$('#tbEmpBirthday').val(new Date(getSelection.tbEmpBirthday).Format("yyyy-MM-dd"));
		
		$('#tbEmpDid').val(getSelection.tbEmpDid);
		//省市联动回显
		$('#tbEmpShengid').val(getSelection.tbEmpShengid);
		var shengid = getSelection.tbEmpShengid;
		findCityByPid(shengid,0);
		$('#tbEmpSid').val(getSelection.tbEmpSid);
		var sid = getSelection.tbEmpSid;
		findCityByPid(sid,1);
		$('#tbEmpXid').val(getSelection.tbEmpXid);
	}
	
	$("#del_user_btn").click(function(){
		var getSelections = $('#table_user').bootstrapTable('getSelections');
		var idArr = new Array();
		var ids;
		getSelections.forEach(function(item){
			idArr.push(item.tbEmpId);
		});
		ids = idArr.join(",");
		$.ajax({
		    url:"deleteUser.htm",
		    dataType:"json",
		    data:{"ids":ids},
		    type:"post",
		    success:function(res){
		    	if(res.success){
	    			$('#modal_user_del').modal('hide');
	    			$("#btn_search").click();
	    		}else{
	    			$("#select_message").text(res.errorMsg);
	    			$("#alertmod_table_user_mod").show();
	    		}
		    }
		});
	});
	$("#export_user_btn").click(function(){
		/* location.href="exportEmp.htm";
		$('#modal_user_export').modal('hide'); */
		 $.ajax({
		    url:"exportEmp.htm",
		    dataType:"json",
		    type:"post",
		    success:function(res){
		    	if(res.success){
	    			$('#modal_user_export').modal('hide');
	    			$("#btn_search").click();
	    		}else{
	    			$("#select_message").text(res.errorMsg);
	    			$("#alertmod_table_user_mod").show();
	    		}
		    }
		}); 
	});
	
	</script>

</body>
</html>
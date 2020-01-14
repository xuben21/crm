<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="plan_edit">
  <div class="foot">
 	<form>
			<div class="form-group">
				<label>商机详情:</label>
			</div>
		</form>
</div>

<div style="margin-bottom: 50px;margin-top: -30px;">
	<table class="table table-hover">
		 <thead>
		    <tr style="background:#E8E8E8;">
		      <th>商机来源</th>

		      <th>成功几率</th>
		      

		      <th>商机指派</th>		 
			  <th>所属地区</th>

			  <th>创建人</th>

			  <th>商机描述</th>
		    </tr> 
		  </thead>

		  <tbody>
		    <tr>
		      <td>${chance.chcSource }</td>
		      <td>${chance.chcRate }</td>
		      <td>${chance.chcDueTo }</td>
		      <td>${chance.chcAddr }</td>
		      <td>${chance.chcCreateBy }</td>
		      <td>${chance.chcDesc }</td>
		    </tr> 
         </tbody>
    </table>
</div>
 <div class="foot">
 	<form class="form-inline">
			<div class="form-group">
				<label>开发计划:</label>
			</div>
			 <input class="btn btn-default" type="button" value="新增" id="add" style="margin-left:900px;">
		</form>
</div>
<div class="kaifa" style="margin-bottom: 30px;margin-top: -30px;height:200px;overflow:auto;">
	<table class="table table-hover">
		 <thead>
		    <tr style="background:#E8E8E8;">
		      <th>序号</th>
		      <th>计划内容</th>
		       <th>计划结果</th>
		         <th>操作</th>
		    </tr> 
		  </thead>
		  <tbody>
		  <c:forEach items="${chance.plans }" var = "plan"> 
		    <tr>
		     <td>${plan.plaId }</td>
		       <td>${plan.plaTodo }</td>
		      <td>${plan.plaResult }</td>
		       <td>
		      <i value="${plan.plaId }" class="layui-icon layui-icon-edit editPlan"></i>  
		      	<i value="${plan.plaId }" class="layui-icon layui-icon-delete deletePlan"></i>  
		      </td>
		    </tr> 
		    </c:forEach>
		      
         </tbody>
    </table>
</div>
	<div>
		<form>
			<div class="form-group" style="margin-left:500px;">
			<input class="btn btn-default tijiao" type="button" value="开发成功">
			<input class="btn btn-default back" type="button" value="返&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回">
			</div>
		</form>
	</div>

	<!-- 删除模态框 -->
<div class="modal" id="deleteModal">
  <div class="modal-dialog"  style="width:350px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">是否确定删除</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary">确定</button>
      </div>
    </div>
  </div>
</div>
<!-- 新增模态框 -->
<div class="modal"  id="toAdd">
  <div class="modal-dialog" style="height:400px;overflow:auto;">
    <div class="modal-content">
       <form>
					<div class="modal-body">
						<div class="form-group">
							<label>计划内容:</label>
							<input type="textarea" name="content" style="height:60px" class="form-control">
						</div>
						<div class="form-group">
							<label>计划结果:</label>
							<select name="result" id="" class="form-control">
								<option value="">请选择计划结果</option>
						        <option value="进行中">进行中</option>
						        <option value="成功">成功</option>
						        <option value="失败">失败</option>
							</select>
						</div>
						
					</div>
				</form>
				<div class="modal-footer">
				    <button class="btn" style="background:#ccc">取消</button>
					<button class="btn" style="background:#ccc">保存</button>
				</div>
    </div>
  </div>
</div>
</div>
<style>
#plan_edit{
	width: 1140px;
	overflow: hidden;
}
	.kaifa tr td:first-child,th:first-child{
		width: 100px;
	}
	.foot{
		/*margin-top: 150px;*/
		padding: 10px;
	}
	.foot label{
		font-size: 18px;
	}
	.form-inline{
		margin-top: 15px;
		margin-left: 10px;
		margin-bottom: 20px;
	}
	input[type=submit]{
		margin-left: 50px;
	}
	#add{
		margin-left:550px;
		width: 100px;
	}
	.table {
		margin-top: 10px;
	}
	.table th,td{
		text-align: center;
	}
	#deleteModal{
		margin-top: 100px;
	}
	#toAdd{
		margin-top: 50px;
	}
</style>
<script type="text/javascript">
    var planId;
    var chanceId = ${chanceId};
	$(function(){
	    $('.back').on('click',function(){
	    	$(".layui-nav-item dd:contains('商机开发计划')").trigger('click');
		})		
		$('.tijiao').on('click',function(){
		 $('.layui-body').load('./pages/plan.html');  
		})
			// 显示删除模态框
		$('.deleteUser').click(function(){
			$('#deleteModal').show();
		})
		// 关闭删除模态框
		$('.close').click(function(){
			planId = null;
			$('#deleteModal').hide();
		})
		// 关闭删除模态框
		$('.btn-default').click(function(){
			planId = null;
			$('#deleteModal').hide();
		})
		// 确定删除
		$('.btn-primary').click(function(){
			$('#deleteModal').hide();
		})
		// 点击新增显示模态框
		$('#add').click(function(){
			$('#toAdd').show();
		})
		// 新增模态框关闭
		$('button:contains(取消)').on('click',function(){
			$('button[type=reset]').trigger('click');	
			planId = null;
				$('#toAdd').hide();
		})
		// 新增模态框保存
		$('button:contains(保存)').on('click',function(){
			 var content = $('input[name=content]').val();
			 var result = $('select[name=result] option:selected').val();
			 var plan = {
					 plaId:planId,
					 plaTodo:content,
					 plaResult:result,
					 plaChcId:chanceId
			 }
			 $('.layui-body').load('./plan/toPlanEdit/'+chanceId);  
				$('#toAdd').hide();
		})	
		// 点击编辑显示模态框
		$('.editPlan').click(function(){
			planId = $(this).attr("value");
			var url = "plan/findPlanById/"+planId;
		    $.get(url,function(data){
		    	console.log(data)
		    	$('input[name=content]').val(data.plaTodo);
		    	$('select[name=result]').val(data.plaResult);
		    	
		    })
			$('#toAdd').show();
		})
	})
</script>
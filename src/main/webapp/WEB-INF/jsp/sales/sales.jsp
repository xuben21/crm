<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 销售商机 -->
<div id="sales">
  <div>
  <form class="form-inline">
  <div class="form-group">
    <input name="custName" type="text" class="form-control" id="exampleInputEmail3" placeholder="请输入客户名称">
  </div>

  <div class="form-group">
	<select name="region" id="" class="form-control">
		 <option value="">请选择所属地区</option>
        <option value="华中">华中</option>
        <option value="华北">华北</option>
        <option value="华南">华南</option>
        <option value="华东">华东</option>
	</select>
  </div>
  <input class="btn btn-default search" type="button" value="查询">
  <input class="btn btn-default" type="reset" value="重置">
  <input class="btn btn-default" type="button" value="新增" id="add">

</form>
</div>

<div>
	<table class="table table-hover">
		 <thead>
		    <tr style="background:#E8E8E8;">
		      <th>序号</th>
		      <th>客户名称</th>
		      <th>概要</th>
		      <th>联系人</th>
		      <th>联系电话</th>	
		      <th>商机指派</th>		 
			  <th>操作</th>
		    </tr> 
		  </thead>

		  <tbody>
		  <c:forEach items="${saleInfo.list }" var="sale">
		    <tr>
		     <td>${sale.chcId }</td>
		      <td>${sale.chcCustName }</td>
		      <td>${sale.chcTitle }</td>
		      <td>${sale.chcLinkman }</td>
		      <td>${sale.chcTel }</td>
		      <td>${sale.chcDueTo }</td>
		      <td>
		      	<i value="${sale.chcId }" class="layui-icon layui-icon-edit editUser">编辑</i>  
		      	<i value="${sale.chcId }" class="layui-icon layui-icon-delete deleteUser">删除</i>   
		      </td>
		    </tr> 
		  </c:forEach>      
         </tbody>
    </table>
</div>
<div class="fenye">
	<table class="footTable">
			<tr>
				<td colspan="5">共${saleInfo.total } 条记录 每页${saleInfo.size } 条 第${saleInfo.pageNum } 页 <a
					href="javascript:void(0)" onclick="pageSelect(1)">首页</a>
						<c:choose>	
							<c:when test="${saleInfo.hasPreviousPage }">
							<a href="javascript:void(0)" onclick="pageSelect(${saleInfo.prePage})">上一页</a>
							</c:when>
							<c:otherwise>
							<font color="#ABA8AB">上一页</font>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${saleInfo.hasNextPage }">
							<a href="javascript:void(0)" onclick="pageSelect(${saleInfo.nextPage})">下一页</a>
							</c:when>
							<c:otherwise>
							<font color="#ABA8AB">下一页</font>
							</c:otherwise>
						</c:choose>
					 <a href="javascript:void(0)" onclick="pageSelect(${saleInfo.lastPage })">尾页</a>
				</td>
			</tr>

		</table>
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
							<label>商机来源:</label>
							<input type="text" name="source"  class="form-control">
						</div>
						<div class="form-group">
							<label>客户名称:</label>
							<input type="text" name="clientName" class="form-control">
						</div>
						<div class="form-group">
							<label>成功几率:</label>
							<input type="text" name="rate" class="form-control">
						</div>
						<div class="form-group">
							<label>商机概要:</label>
							<input type="text" name="title" class="form-control">
						</div>
						<div class="form-group">
							<label>所属地区:</label>
							<select name="region" id="" class="form-control">
								<option value="">请选择所属地区</option>
						        <option value="华中">华中</option>
						        <option value="华北">华北</option>
						        <option value="华南">华南</option>
						        <option value="华东">华东</option>
							</select>
						</div>
						<div class="form-group">
							<label>联系人:</label>
							<input type="text" name="linkman" class="form-control">
						</div>
						<div class="form-group">
							<label>联系电话:</label>
							<input type="text" name="tel" class="form-control">
						</div>
						<div class="form-group">
							<label>创建人:</label>
							<input type="text" name="createBy" class="form-control">
						</div>
						<div class="form-group">
							<label>处理人:</label>
							<select name="dueTo" id="" class="form-control">
								<option value="">请选择处理人</option>
						        <option value="jingli1">jingli1</option>
						        <option value="jingli2">jingli2</option>
						        <option value="jingli3">jingli3</option>
							</select>
						</div>
						<div class="form-group">
							<label>商机描述:</label>
							<input type="textarea" name="desc" style="height:60px" class="form-control">
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
#sales{
	width: 1140px;
	overflow: hidden;
}
.pagination > .active > a, .pagination > .active > a:focus, .pagination > .active > a:hover, .pagination > .active > span, .pagination > .active > span:focus, .pagination > .active > span:hover {
    background-color: #ccc;
    border-color: #ccc;
}
.pagination > li > a, .pagination > li > span {
    color: black;
}
.fenye{
	margin-left: 400px;
}
	.form-inline{
		margin-top: 15px;
		margin-left: 10px;
		margin-bottom: 20px;
	}
	.search{
		margin-left: 50px;
	}
	#add{
		margin-left: 500px;
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
    var saleId;
    function pageSelect(currentPage){
	   $('.layui-body').load('./sale/findSaleChance/'+currentPage);
    }

	$(function(){
		// 显示删除模态框
		$('.deleteUser').click(function(){
			saleId = $(this).attr("value");
			$('#deleteModal').show();
		})
		// 关闭删除模态框
		$('.close').click(function(){
			saleId = null;
			$('#deleteModal').hide();
		})
		// 关闭删除模态框
		$('.btn-default').click(function(){
			saleId = null;
			$('#deleteModal').hide();
		})
		// 确定删除
		$('.btn-primary').click(function(){
			var url = "sale/deleteSaleById/"+saleId;
			$('.layui-body').load(url)
			alert("删除成功")
			$('#deleteModal').hide();
		})
		// 点击新增显示模态框
		$('#add').click(function(){
			$(".form-control").val("");
			$('#toAdd').show();
		})
		// 新增模态框关闭
		$('button:contains(取消)').on('click',function(){
			$('button[type=reset]').trigger('click');
			saleId = null;
				$('#toAdd').hide();
		})
		// 新增模态框保存
		$('button:contains(保存)').on('click',function(){
			 var source = $("input[name=source]").val();
			 var custName = $("input[name=clientName]").val();
			 var rate = $("input[name=rate]").val();
			 var title = $("input[name=title]").val();
			 var tel = $("input[name=tel]").val();
			 var region = $("select[name=region] option:selected").val();
			 var linkman = $("input[name=linkman]").val();
			 var creator = $("input[name=createBy]").val();
			 var dueTo = $("select[name=dueTo] option:selected").val();
			 var desc = $("input[name=desc]").val();
			 var data = {
					 chcId:saleId,
					 chcSource:source,
					 chcCustName:custName,
					 chcTitle:title,
					 chcRate:rate,
					 chcLinkman:linkman,
					 chcTel:tel,
					 chcAddr:region,
					 chcDesc:desc,
					 chcCreateBy:creator,
					 chcDueTo:dueTo
			 }
			 console.log(data)
			 var url = "sale/saveOrUpdate"
			 $.get(url,data,function(data){
				 alert(data)
			 })
			   
				$('#toAdd').hide();
			 $(".layui-nav-item dd:contains('销售商机管理')").trigger('click');
		})	
		// 点击编辑显示模态框
		$('.editUser').click(function(){
			saleId = $(this).attr("value");
			console.log("saleId:"+saleId)
			var sale;
	        $.get("sale/findSaleById/"+saleId,
			  	function(data){
	             	sale = data;
					console.log(sale)
					  $("input[name=source]").val(sale.chcSource);
					  $("input[name=clientName]").val(sale.chcCustName);
					  $("input[name=rate]").val(sale.chcRate);
					  $("input[name=title]").val(sale.chcTitle);
					  $("input[name=tel]").val(sale.chcTel);
					  $("select[name=region] ").val(sale.chcAddr);
					  $("input[name=linkman]").val(sale.chcLinkman);
				      $("input[name=createBy]").val(sale.chcCreateBy);
					  $("select[name=dueTo]").val(sale.chcDueTo);
					  $("input[name=desc]").val(sale.chcDesc);
				},"json");
			
			$('#toAdd').show();
		})
		// 查询
		$('.search').click(function(){
			var custName = $("input[name=custName]").val();
			var city = $("select[name=region] option:selected").val();
			console.log(custName +"/"+ city)
			var data = {
				custName:custName,
				region:city
			}
			var url = "sale/findSaleChanceLike/1"
			$('.layui-body').load(url,data)
			 
		})
	})
</script>